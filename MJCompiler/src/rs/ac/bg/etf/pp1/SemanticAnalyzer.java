package rs.ac.bg.etf.pp1;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;


public class SemanticAnalyzer extends VisitorAdaptor {
	
	Logger log =  Logger.getLogger(getClass());
	boolean errorDetected = false;
	public int nVars;
	private Struct currentType = Tab.noType;
	private String currentNamespace = null;
	
	private Obj currentMethod = Tab.noObj;
	private int formalParCnt = 0;
	public boolean mainFound = false;
	private String _MAIN_ = "main";
	
	public void report_error(String message, SyntaxNode info) {
		errorDetected = true;
		StringBuilder msg = new StringBuilder(message);
		int line = (info == null) ? 0: info.getLine();
		if (line != 0)
			msg.append (" on line ").append(line);
		log.error(msg.toString());
	}
	
	private String fullName(String name)
	{
		String ret = name;
		if(this.currentNamespace != null)
			ret = "__" + this.currentNamespace + "__" + name;
		
		return ret;
	}
	

	public void visit(ProgramName progName)
	{
		progName.obj = Tab.insert(Obj.Prog, progName.getProgName(), Tab.noType);
		Tab.openScope();
	}
	
	public void visit(Program program)
	{	
		nVars = Tab.currentScope.getnVars();
		Tab.chainLocalSymbols(program.getProgramName().obj);
		Tab.closeScope();
	}
	
	public void visit(DeclarationList declList)
	{
		return;
	}
	
	
	public void visit(IntConst intConst)
	{
		String name = intConst.getName();
		
		// Dodaj ostatakImena
		name = this.fullName(name);
		
		// Da li se koristi ime
		if(Tab.find(name) != Tab.noObj)
		{
			report_error("Variable "+ name +" is already defined",null);
			return;
		} 
		//  Proveri je li je dobar tip
		if(!currentType.equals(Tab.intType))
		{
			report_error("Incorrect type for: "+ name,null);
			return;
		}
		
		Obj obj = Tab.insert(Obj.Con, name, this.currentType);
		obj.setAdr(intConst.getValue());	
	}
	
	public void visit(BoolConst boolConst)
	{
		String name = boolConst.getName();
		int value = boolConst.getValue() ? 1: 0;
		name = this.fullName(name);
		
		// Da li se koristi ime
		if(Tab.find(name) != Tab.noObj)
		{
			report_error("Variable "+ name +" is already defined",null);
			return;
		} 
		//  Proveri je li je dobar tip
		if(!currentType.equals(SymbolTable.boolType))
		{
			report_error("Incorrect type for: "+ name,null);
			return;
		}
		
		Obj obj = Tab.insert(Obj.Con, name, this.currentType);
		obj.setAdr(value);	
	}
	
	public void visit(CharConst charConst)
	{
		String name = charConst.getName();
		name = this.fullName(name);
		
		// Da li se koristi ime
		if(Tab.find(name) != Tab.noObj)
		{
			report_error("Variable "+ name +" is already defined",null);
			return;
		} 
		//  Proveri je li je dobar tip
		if(!currentType.equals(SymbolTable.charType))
		{
			report_error("Incorrect type for: "+ name,null);
			return;
		}
		
		Obj obj = Tab.insert(Obj.Con, name, this.currentType);
		obj.setAdr(charConst.getValue());	
	}
	
	public void visit(Type type)
	{
		Obj typeNode = Tab.find(type.getType());
		
		if(typeNode == Tab.noObj)
		{
			report_error("Not supported "+ type.getType(), null);
			this.currentType = Tab.noType;
			return;
		}
		if(typeNode.getKind() == Obj.Type)
		{
			this.currentType = typeNode.getType();
		}
		else
		{
			report_error("Not supported "+ type.getType(), null);
			this.currentType = Tab.noType;
			return;
		}
		
	}
	
	public void visit(SingleVar singleVar)
	{
		if (currentType == Tab.noType) {
			report_error("Unsuported type " + this.currentType, null);
			return;
		}
		
		String name = singleVar.getName();
		name = this.fullName(name);
		MaybeArray isArray = singleVar.getMaybeArray();
		
		if(Tab.currentScope.findSymbol(name) != null)
		{
			report_error("Variable " + singleVar.getName() + " already defined!", null);
			return;
		}
		if( isArray instanceof NotArray)
			Tab.insert(Obj.Var, name, currentType);
		else {
			Struct arrayStruct = new Struct(Struct.Array, this.currentType);
			Tab.insert(Obj.Var, name, arrayStruct);
		}
		
			
	}

	public void visit(NamespaceHeader header)
	{
		this.currentNamespace = header.getName();
	}
	
	public void visit(Namespace namespace)
	{
		this.currentNamespace = null;
	}
	
	public void visit(ReturnVoid methodHeader)
	{
		Struct retType = Tab.noType;
		this.currentMethod = Tab.insert(Obj.Meth, methodHeader.getName(), retType);
		Tab.openScope();
		
		if(methodHeader.getName().equals(this._MAIN_))
			this.mainFound = true;
	}
	public void visit(ReturnSmt methodHeader)
	{
		Struct retType = this.currentType;
		this.currentMethod = Tab.insert(Obj.Meth, methodHeader.getName(), retType);
		Tab.openScope();
		
		if(methodHeader.getName().equals(this._MAIN_))
			this.mainFound = true;
	}
	public void visit(SingleMethodDecl methodDecl)
	{
		// num of formal paramas 
		this.currentMethod.setLevel(this.formalParCnt);
		
		Tab.chainLocalSymbols(this.currentMethod);
		Tab.closeScope();
		
		
		// cleanup for future
		this.currentMethod = null;	
		this.formalParCnt = 0;
		
	}
	public void visit(SinglePar singlePar)
	{
		String name = singlePar.getName();
		
		if (currentType == Tab.noType) {
			report_error("Unsuported type " + this.currentType, null);
			return;
		}
		if(Tab.currentScope.findSymbol(name) != null)
		{
			report_error("Variable " + singlePar.getName() + " already a formal parameter here!", null);
			return;
		}	
		

		MaybeArray isArray = singlePar.getMaybeArray();
		if( isArray instanceof NotArray)
			Tab.insert(Obj.Var, name, currentType);
		else {
			Struct arrayStruct = new Struct(Struct.Array, this.currentType);
			Tab.insert(Obj.Var, name, arrayStruct);
		}
		Tab.find(name).setFpPos(this.formalParCnt++);
	}
	
}
































