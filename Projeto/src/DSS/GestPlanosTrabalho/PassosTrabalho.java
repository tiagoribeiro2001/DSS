package DSS.GestPlanosTrabalho;

public class PassosTrabalho {
    String passo;
    int custo;

    public PassosTrabalho () {
        this.passo = "";
        this.custo = 0;
    }

    public PassosTrabalho (String passo, int custo) {
        this.passo = passo;
        this.custo = custo;
    }

    public PassosTrabalho (PassosTrabalho pt) {
        this.passo = pt.getPasso();
        this.custo = pt.getCusto();
    }

    public String getPasso() { return this.passo;}
    public int getCusto () { return this.custo;}

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        sb.append("\tPasso: ").append(this.passo).append("\n");
        sb.append("\tCusto: ").append(this.custo).append("\n");
        sb.append("}\n");
        return sb.toString();
    }

    public PassosTrabalho clone() { return new PassosTrabalho(this);}

}
