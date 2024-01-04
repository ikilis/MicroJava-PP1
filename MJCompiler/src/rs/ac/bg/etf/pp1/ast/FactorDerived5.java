// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class FactorDerived5 extends Factor {

    private Type Type;
    private ArrayPosition ArrayPosition;

    public FactorDerived5 (Type Type, ArrayPosition ArrayPosition) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.ArrayPosition=ArrayPosition;
        if(ArrayPosition!=null) ArrayPosition.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
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
        if(Type!=null) Type.accept(visitor);
        if(ArrayPosition!=null) ArrayPosition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ArrayPosition!=null) ArrayPosition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ArrayPosition!=null) ArrayPosition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FactorDerived5(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ArrayPosition!=null)
            buffer.append(ArrayPosition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FactorDerived5]");
        return buffer.toString();
    }
}
