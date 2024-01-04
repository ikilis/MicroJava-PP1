// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class OnePar extends FormPars {

    private SinglePar SinglePar;

    public OnePar (SinglePar SinglePar) {
        this.SinglePar=SinglePar;
        if(SinglePar!=null) SinglePar.setParent(this);
    }

    public SinglePar getSinglePar() {
        return SinglePar;
    }

    public void setSinglePar(SinglePar SinglePar) {
        this.SinglePar=SinglePar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SinglePar!=null) SinglePar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SinglePar!=null) SinglePar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SinglePar!=null) SinglePar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("OnePar(\n");

        if(SinglePar!=null)
            buffer.append(SinglePar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [OnePar]");
        return buffer.toString();
    }
}
