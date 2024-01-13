package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.CounterVisitor.*;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;


public class CodeGenerator extends VisitorAdaptor {

	private int mainPC;
	
	public int getMainPC() {return this.mainPC;}
	
	
	public void visit(PrintStatement print)
	{
		if(print.getExpr().struct == Tab.intType)
		{
			Code.loadConst(5);
			Code.put(Code.print);
		}else	// char grana
		{
			Code.loadConst(1);
			Code.put(Code.bprint);
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
//	public void visit(FactorBool fact)
//	{
//		Obj con = Tab.insert(Obj.Con,  "$", fact.struct);
//		con.setLevel(0);
//		con.setAdr(fact.getB1());
//		
//		Code.load(con);
//	}
	
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
		
		// Generate enrty
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
		// na exprStack je vec taj broj - obradjeno u toku Expr
		
		Obj o = assign.getDesignator().obj;
		Code.store(o);
	}
	
	public void visit(FactorDesignator fact)
	{
		SyntaxNode parent = fact.getParent();
		
		// za ime bez namespacea
		DesignatorSingle ds = (DesignatorSingle)fact.getDesignator().getDesignatorName();
//		Code.load(Tab.find(ds.getName()));
		Code.load(fact.getDesignator().obj);
		
	}
	
}






















