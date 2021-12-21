package DSS.GestPlanosTrabalho;

public class PassosTrabalho {
    String passo;
    double custo;

    public PassosTrabalho () {
        this.passo = "";
        this.custo = 0;
    }

    public PassosTrabalho (String passo, double custo) {
        this.passo = passo;
        this.custo = custo;
    }

    public PassosTrabalho (PassosTrabalho pt) {
        this.passo = pt.getPasso();
        this.custo = pt.getCusto();
    }

    public String getPasso() { return this.passo;}
    public double getCusto () { return this.custo;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passo: ").append(this.passo).append("\n");
        sb.append("Custo: ").append(this.custo).append("\n");
        return sb.toString();
    }

    public PassosTrabalho clone() { return new PassosTrabalho(this);}

}
