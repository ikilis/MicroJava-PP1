// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementDerived1 extends DesignatorStatement {

    private AssignOperation AssignOperation;

    public DesignatorStatementDerived1 (AssignOperation AssignOperation) {
        this.AssignOperation=AssignOperation;
        if(AssignOperation!=null) AssignOperation.setParent(this);
    }

    public AssignOperation getAssignOperation() {
        return AssignOperation;
    }

    public void setAssignOperation(AssignOperation AssignOperation) {
        this.AssignOperation=AssignOperation;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(AssignOperation!=null) AssignOperation.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(AssignOperation!=null) AssignOperation.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(AssignOperation!=null) AssignOperation.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementDerived1(\n");

        if(AssignOperation!=null)
            buffer.append(AssignOperation.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementDerived1]");
        return buffer.toString();
    }
}
