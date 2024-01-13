package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {

	protected int count;
	
	public int getCount() {return count;}
	
	
	public static class FormParamCounter extends CounterVisitor
	{
		public void visit(Parameters p)
		{
			count++;
		}
	}
	
	public static class VarCounter extends CounterVisitor
	{
		public void visit(SingleVar v)
		{
			count++;
		}
	}
}
