// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class DesignatorNameDerived2 extends DesignatorName {

    private String I1;

    public DesignatorNameDerived2 (String I1) {
        this.I1=I1;
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorNameDerived2(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorNameDerived2]");
        return buffer.toString();
    }
}
