// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class Methods extends MethodDecl {

    private MethodDecl MethodDecl;
    private SingleMethodDecl SingleMethodDecl;

    public Methods (MethodDecl MethodDecl, SingleMethodDecl SingleMethodDecl) {
        this.MethodDecl=MethodDecl;
        if(MethodDecl!=null) MethodDecl.setParent(this);
        this.SingleMethodDecl=SingleMethodDecl;
        if(SingleMethodDecl!=null) SingleMethodDecl.setParent(this);
    }

    public MethodDecl getMethodDecl() {
        return MethodDecl;
    }

    public void setMethodDecl(MethodDecl MethodDecl) {
        this.MethodDecl=MethodDecl;
    }

    public SingleMethodDecl getSingleMethodDecl() {
        return SingleMethodDecl;
    }

    public void setSingleMethodDecl(SingleMethodDecl SingleMethodDecl) {
        this.SingleMethodDecl=SingleMethodDecl;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.accept(visitor);
        if(SingleMethodDecl!=null) SingleMethodDecl.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MethodDecl!=null) MethodDecl.traverseTopDown(visitor);
        if(SingleMethodDecl!=null) SingleMethodDecl.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MethodDecl!=null) MethodDecl.traverseBottomUp(visitor);
        if(SingleMethodDecl!=null) SingleMethodDecl.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Methods(\n");

        if(MethodDecl!=null)
            buffer.append(MethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleMethodDecl!=null)
            buffer.append(SingleMethodDecl.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Methods]");
        return buffer.toString();
    }
}
