// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class MybArrayPositionDerived1 extends MybArrayPosition {

    private ArrayPosition ArrayPosition;

    public MybArrayPositionDerived1 (ArrayPosition ArrayPosition) {
        this.ArrayPosition=ArrayPosition;
        if(ArrayPosition!=null) ArrayPosition.setParent(this);
    }

    public ArrayPosition getArrayPosition() {
        return ArrayPosition;
    }

    public void setArrayPosition(ArrayPosition ArrayPosition) {
        this.ArrayPosition=ArrayPosition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ArrayPosition!=null) ArrayPosition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ArrayPosition!=null) ArrayPosition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ArrayPosition!=null) ArrayPosition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MybArrayPositionDerived1(\n");

        if(ArrayPosition!=null)
            buffer.append(ArrayPosition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MybArrayPositionDerived1]");
        return buffer.toString();
    }
}
