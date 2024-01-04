// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class PrintStatement extends Statement {

    private Expr Expr;
    private PrintAmmount PrintAmmount;

    public PrintStatement (Expr Expr, PrintAmmount PrintAmmount) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PrintAmmount=PrintAmmount;
        if(PrintAmmount!=null) PrintAmmount.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public PrintAmmount getPrintAmmount() {
        return PrintAmmount;
    }

    public void setPrintAmmount(PrintAmmount PrintAmmount) {
        this.PrintAmmount=PrintAmmount;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(PrintAmmount!=null) PrintAmmount.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PrintAmmount!=null) PrintAmmount.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PrintAmmount!=null) PrintAmmount.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintStatement(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PrintAmmount!=null)
            buffer.append(PrintAmmount.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintStatement]");
        return buffer.toString();
    }
}
