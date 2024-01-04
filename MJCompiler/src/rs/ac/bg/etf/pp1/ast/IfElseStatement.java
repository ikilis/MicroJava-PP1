// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class IfElseStatement extends Statement {

    private IfHeader IfHeader;
    private Statement Statement;
    private MybElse MybElse;

    public IfElseStatement (IfHeader IfHeader, Statement Statement, MybElse MybElse) {
        this.IfHeader=IfHeader;
        if(IfHeader!=null) IfHeader.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.MybElse=MybElse;
        if(MybElse!=null) MybElse.setParent(this);
    }

    public IfHeader getIfHeader() {
        return IfHeader;
    }

    public void setIfHeader(IfHeader IfHeader) {
        this.IfHeader=IfHeader;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public MybElse getMybElse() {
        return MybElse;
    }

    public void setMybElse(MybElse MybElse) {
        this.MybElse=MybElse;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfHeader!=null) IfHeader.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(MybElse!=null) MybElse.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfHeader!=null) IfHeader.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(MybElse!=null) MybElse.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfHeader!=null) IfHeader.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(MybElse!=null) MybElse.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("IfElseStatement(\n");

        if(IfHeader!=null)
            buffer.append(IfHeader.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MybElse!=null)
            buffer.append(MybElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [IfElseStatement]");
        return buffer.toString();
    }
}
