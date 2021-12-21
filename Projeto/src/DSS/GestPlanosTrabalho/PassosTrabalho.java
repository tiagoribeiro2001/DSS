package DSS.GestPlanosTrabalho;

import java.io.Serializable;

public class PassosTrabalho implements Serializable {
    String passo;
    double custo;
    int tempo;

    public PassosTrabalho () {
        this.passo = "";
        this.custo = 0;
        int tempo = 0;
    }

    public PassosTrabalho (String passo, double custo, int tempo) {
        this.passo = passo;
        this.custo = custo;
        this.tempo = tempo;
    }

    public PassosTrabalho (PassosTrabalho pt) {
        this.passo = pt.getPasso();
        this.custo = pt.getCusto();
        this.tempo = pt.getTempo();
    }

    public String getPasso() { return this.passo;}
    public double getCusto () { return this.custo;}
    public int getTempo () { return this.tempo;}

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Passo: ").append(this.passo).append("\n");
        sb.append("Tempo previsto: ").append(this.tempo).append("\n");
        sb.append("Custo previsto: ").append(this.custo).append("\n");
        return sb.toString();
    }

    public PassosTrabalho clone() { return new PassosTrabalho(this);}

}
