// generated with ast extension for cup
// version 0.8
// 1/0/2024 13:9:0


package rs.ac.bg.etf.pp1.ast;

public class MultiplePars extends FormPars {

    private FormPars FormPars;
    private SinglePar SinglePar;

    public MultiplePars (FormPars FormPars, SinglePar SinglePar) {
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.SinglePar=SinglePar;
        if(SinglePar!=null) SinglePar.setParent(this);
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
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
        if(FormPars!=null) FormPars.accept(visitor);
        if(SinglePar!=null) SinglePar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(SinglePar!=null) SinglePar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(SinglePar!=null) SinglePar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultiplePars(\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SinglePar!=null)
            buffer.append(SinglePar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultiplePars]");
        return buffer.toString();
    }
}
