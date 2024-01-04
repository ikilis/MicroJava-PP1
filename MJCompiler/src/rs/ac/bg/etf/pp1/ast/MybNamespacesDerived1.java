// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class MybNamespacesDerived1 extends MybNamespaces {

    private MybNamespaces MybNamespaces;
    private Namespace Namespace;

    public MybNamespacesDerived1 (MybNamespaces MybNamespaces, Namespace Namespace) {
        this.MybNamespaces=MybNamespaces;
        if(MybNamespaces!=null) MybNamespaces.setParent(this);
        this.Namespace=Namespace;
        if(Namespace!=null) Namespace.setParent(this);
    }

    public MybNamespaces getMybNamespaces() {
        return MybNamespaces;
    }

    public void setMybNamespaces(MybNamespaces MybNamespaces) {
        this.MybNamespaces=MybNamespaces;
    }

    public Namespace getNamespace() {
        return Namespace;
    }

    public void setNamespace(Namespace Namespace) {
        this.Namespace=Namespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MybNamespaces!=null) MybNamespaces.accept(visitor);
        if(Namespace!=null) Namespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MybNamespaces!=null) MybNamespaces.traverseTopDown(visitor);
        if(Namespace!=null) Namespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MybNamespaces!=null) MybNamespaces.traverseBottomUp(visitor);
        if(Namespace!=null) Namespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MybNamespacesDerived1(\n");

        if(MybNamespaces!=null)
            buffer.append(MybNamespaces.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Namespace!=null)
            buffer.append(Namespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MybNamespacesDerived1]");
        return buffer.toString();
    }
}
