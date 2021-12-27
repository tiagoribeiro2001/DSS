package DSS.GestPlanosTrabalho;

import java.io.Serializable;

/**
 * Classe PassosTrabalho usada para representar um passo da reparação de um equipamento
 */
public class PassosTrabalho implements Serializable {
    String passo;
    double custo;
    int tempo;

    /**
     * Construtor vazio da classe PassosTrabalho
     */
    public PassosTrabalho () {
        this.passo = "";
        this.custo = 0;
        int tempo = 0;
    }

    /**
     * Construtor parametrizado da classe PassosTrabalho
     * @param passo String que descreve o que foi realizado nesse passo
     * @param custo Custo deste passo
     * @param tempo Tempo necessário para a realização deste passo
     */
    public PassosTrabalho(String passo, double custo, int tempo){
        this.passo = passo;
        this.custo = custo;
        this.tempo = tempo;
    }

    /**
     * Contrutor clone da classe PassosTrabalho
     * @param pt PassosTrabalho a ser copiado
     */
    public PassosTrabalho(PassosTrabalho pt){
        this.passo = pt.getPasso();
        this.custo = pt.getCusto();
        this.tempo = pt.getTempo();
    }

    /**
     * Método getter da descrição do passo
     * @return String que descreve o passo
     */
    public String getPasso(){
        return this.passo;
    }

    /**
     * Método getter do custo do passo
     * @return Custo do passo
     */
    public double getCusto(){
        return this.custo;
    }

    /**
     * Método getter do tempo necessário para a realização do passo
     * @return Tempo que demora o passo
     */
    public int getTempo(){
        return this.tempo;
    }

    /**
     * Método toString da classe PassosTrabalho
     * @return String do PassosTrabalho
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Passo: ").append(this.passo).append("\n");
        sb.append("Tempo previsto: ").append(this.tempo).append("\n");
        sb.append("Custo previsto: ").append(this.custo).append("\n");
        return sb.toString();
    }

    /**
     * Método clone da classe PassosTrabalho
     * @return PassosTrabalho clonado
     */
    public PassosTrabalho clone(){
        return new PassosTrabalho(this);
    }

}
