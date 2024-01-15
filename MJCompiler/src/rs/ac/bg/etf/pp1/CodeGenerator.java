package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;


public class CodeGenerator extends VisitorAdaptor {

	private int mainPC;
	
	public int getMainPC() {return this.mainPC;}
	
	
	public void visit(PrintStatement print)
	{
		
		int printAmmount = 5;
		if(print.getExpr().struct == Tab.charType)
		{
			Code.loadConst(1);
			Code.put(Code.bprint);
		}else
		{
			if (print.getPrintAmmount() instanceof HasPrintAmmount) 
			{
				HasPrintAmmount p = (HasPrintAmmount) print.getPrintAmmount();
				printAmmount = p.getAmmount();
			}
			Code.loadConst(printAmmount);
			Code.put(Code.print);
				
		}
	}
	
	public void visit(FactorNumber fact)
	{
		Obj con = Tab.insert(Obj.Con,  "$", fact.struct);
		con.setLevel(0);
		con.setAdr(fact.getN1());
		
		Code.load(con);
	}
	public void visit(FactorChar fact)
	{
		Obj con = Tab.insert(Obj.Con,  "$", fact.struct);
		con.setLevel(0);
		con.setAdr(fact.getC1());
		
		Code.load(con);
	}
	public void visit(FactorBool fact)
	{
		Obj con = Tab.insert(Obj.Con,  "$", fact.struct);
		con.setLevel(0);
		final int constValue = fact.getB1() ? 1 : 0;
		con.setAdr(constValue);
		
		Code.load(con);
	}
	// TODO: uradi za nizove
	public void visit(FactorDesignator factorDesignator) {
		Code.load(factorDesignator.getDesignator().obj);
	}
	public void visit(FactorNew fact)
	{
		Code.put(Code.newarray);
		if(fact.getType().struct.getKind() == Struct.Char)
			Code.put(0);
		else
			Code.put(1);
	}
	
	
	public void visit(ReturnVoid met)
	{
		if("main".equalsIgnoreCase(met.getName()))
			this.mainPC = Code.pc;
		// met.obj.setAdr(Code.pc);
		
		// Collect args and local vars
		SyntaxNode methodNode = met.getParent();
		
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter parCnt = new FormParamCounter();
		methodNode.traverseTopDown(parCnt);
		
		// Generate entry
		Code.put(Code.enter);
		Code.put(parCnt.getCount());
		Code.put(parCnt.getCount() + varCnt.getCount());
		
	}
	
	public void visit(ReturnSmt met)
	{
		if("main".equalsIgnoreCase(met.getName()))
			this.mainPC = Code.pc;
		// met.obj.setAdr(Code.pc);
		
		// Collect args and local vars
		SyntaxNode methodNode = met.getParent();
		
		VarCounter varCnt = new VarCounter();
		methodNode.traverseTopDown(varCnt);
		
		FormParamCounter parCnt = new FormParamCounter();
		methodNode.traverseTopDown(parCnt);
		
		// Generate entry
		Code.put(Code.enter);
		Code.put(parCnt.getCount());
		Code.put(parCnt.getCount() + varCnt.getCount());
		
	}
	
	public void visit(SingleMethodDecl methodDecl)
	{
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(AssignOperation assign)
	{
		Obj o = assign.getDesignator().obj;
		Code.store(o);
	}
	// TODO: uradi za nizove
	public void visit(DesignatorIncrement des)
	{
		Obj obj = des.getDesignator().obj;
		
		if(obj.getKind() == Obj.Elem)
		{
			Code.put(Code.dup2);
			
		}
		
		Code.load(obj);
		Code.loadConst(1);
		Code.put(Code.add);
		Code.store(obj);
	}
	// TODO: uradi za nizove
	public void visit(DesignatorDecrement des)
	{
		
		Obj obj = des.getDesignator().obj;
		
		if(obj.getKind() == Obj.Elem)
		{
			Code.put(Code.dup2);
			
		}
		Code.load(obj);
		Code.loadConst(1);
		Code.put(Code.sub);
		Code.store(obj);
	}
	
	
	public void visit(AddopExpr expr)
	{
		if(expr.getAddop() instanceof Plus)
			Code.put(Code.add);
		else
			Code.put(Code.sub);
	}
	public void visit(NegativeTerm expr)
	{
		Code.put(Code.neg);
	}
	
	public void visit(MulTerm mul)
	{
		Mulop m = mul.getMulop();
		
		if(m instanceof Multipli) Code.put(Code.mul);
		if(m instanceof Divide) Code.put(Code.div);
		if(m instanceof Moduo) Code.put(Code.rem);
	}
	public void visit(DesignatorIdent des)
	{
//		Obj o = des.obj
//		System.out.println(des.obj.getName());
		if(des.getParent() instanceof DesignatorIndex)
			Code.load(des.obj);
	}
	public void visit(DesignatorNamespace des)
	{
//		Obj o = des.obj
//		System.out.println(des.obj.getName());
		if(des.getParent() instanceof DesignatorIndex)
			Code.load(des.obj);
	}
	
	public void visit(ReadStatement read)
	{
		if (read.getDesignator().obj.getType() == Tab.charType) {
			Code.put(Code.bread);
			Code.store(read.getDesignator().obj);
		}
		else {
			Code.put(Code.read);
			Code.store(read.getDesignator().obj);
		}
	}
	
	

	
	
	
}






















