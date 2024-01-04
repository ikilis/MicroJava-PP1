// generated with ast extension for cup
// version 0.8
// 4/0/2024 17:45:25


package rs.ac.bg.etf.pp1.ast;

public class DesignatorDerived1 extends Designator {

    private DesignatorName DesignatorName;
    private MybArrayPosition MybArrayPosition;

    public DesignatorDerived1 (DesignatorName DesignatorName, MybArrayPosition MybArrayPosition) {
        this.DesignatorName=DesignatorName;
        if(DesignatorName!=null) DesignatorName.setParent(this);
        this.MybArrayPosition=MybArrayPosition;
        if(MybArrayPosition!=null) MybArrayPosition.setParent(this);
    }

    public DesignatorName getDesignatorName() {
        return DesignatorName;
    }

    public void setDesignatorName(DesignatorName DesignatorName) {
        this.DesignatorName=DesignatorName;
    }

    public MybArrayPosition getMybArrayPosition() {
        return MybArrayPosition;
    }

    public void setMybArrayPosition(MybArrayPosition MybArrayPosition) {
        this.MybArrayPosition=MybArrayPosition;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.accept(visitor);
        if(MybArrayPosition!=null) MybArrayPosition.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorName!=null) DesignatorName.traverseTopDown(visitor);
        if(MybArrayPosition!=null) MybArrayPosition.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorName!=null) DesignatorName.traverseBottomUp(visitor);
        if(MybArrayPosition!=null) MybArrayPosition.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorDerived1(\n");

        if(DesignatorName!=null)
            buffer.append(DesignatorName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MybArrayPosition!=null)
            buffer.append(MybArrayPosition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorDerived1]");
        return buffer.toString();
    }
}
