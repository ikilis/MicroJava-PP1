// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class MybArrayPositionDerived2 extends MybArrayPosition {

    public MybArrayPositionDerived2 () {
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
        buffer.append("MybArrayPositionDerived2(\n");

        buffer.append(tab);
        buffer.append(") [MybArrayPositionDerived2]");
        return buffer.toString();
    }
}
