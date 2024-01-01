// generated with ast extension for cup
// version 0.8
// 1/0/2024 13:9:0


package rs.ac.bg.etf.pp1.ast;

public class NoMethod extends MethodDecl {

    public NoMethod () {
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
        buffer.append("NoMethod(\n");

        buffer.append(tab);
        buffer.append(") [NoMethod]");
        return buffer.toString();
    }
}
