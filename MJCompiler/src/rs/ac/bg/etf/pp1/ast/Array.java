// generated with ast extension for cup
// version 0.8
// 1/0/2024 13:9:0


package rs.ac.bg.etf.pp1.ast;

public class Array extends MaybeArray {

    public Array () {
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
        buffer.append("Array(\n");

        buffer.append(tab);
        buffer.append(") [Array]");
        return buffer.toString();
    }
}