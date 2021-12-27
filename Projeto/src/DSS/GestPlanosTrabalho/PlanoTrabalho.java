package DSS.GestPlanosTrabalho;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestOrcamentos.Orcamento;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe PlanoTrabalho usada para representar um plano de trabalho de uma reparação
 */
public class PlanoTrabalho implements Serializable{
    private List<PassosTrabalho> plano;
    private Orcamento orc;

    /**
     * Constutor parametrizado da classe PlanoTrabalho
     * @param e Equipamento a que se refere o plano
     */
    public PlanoTrabalho(Equipamento e){
        this.plano = new ArrayList<>();
        this.orc = new Orcamento(e.clone());
    }

    /**
     * Construtor clone da classe PlanoTrabalho
     * @param pt PlanoTrabalho a ser copiado
     */
    public PlanoTrabalho(PlanoTrabalho pt){
        this.plano = pt.getPlano();
        this.orc = pt.getOrcamento();
    }

    /**
     * Método getter do custo total do plano de trabalho
     * @return Custo total do plano
     */
    public double getCustoTotal(){
        return this.plano.stream().mapToDouble(PassosTrabalho::getCusto).sum();
    }

    /**
     * Método que adiciona um passo ao plano de trabalhos
     * @param passo String que descreve o passo
     * @param custo Custo do passo
     * @param tempo Duração do passo
     */
    public void adicionaPasso(String passo, double custo, int tempo){
        PassosTrabalho pt = new PassosTrabalho(passo, custo, tempo);
        this.plano.add(pt.clone());
    }

    /**
     * Método que regista um Orcamento
     * @param problema Descrição do problema
     */
    public void registaOrcamento(String problema){
        this.orc.setValor(getCustoTotal());
        this.orc.setProblema(problema);
    }

    /**
     * Método getter da lista de passos do plano de trabalho
     * @return Lista de passos
     */
    public List<PassosTrabalho> getPlano(){
        return this.plano.stream().map(PassosTrabalho::clone).collect(Collectors.toList());
    }

    /**
     * Método getter do Orcamento do plano de trabalho
     * @return Orcamento do plano de trabalho
     */
    public Orcamento getOrcamento(){
        return this.orc.clone();
    }

    /**
     * Método getter da duração de um passo
     * @param passo Número do passo
     * @return Duração do passo
     */
    public int getTempo(int passo){
        return this.plano.get(passo).getTempo();
    }

    /**
     * Método toString da classe PlanoTrabalho
     * @return String do PlanoTrabalho
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("{\n");
        this.plano.forEach(j -> sb.append(j.toString()));
        sb.append("}\n");
        return sb.toString();
    }

    /**
     * Método que calcula o número de passos de um plano de trabalho
     * @return Número de passos do plano
     */
    public int tamanhoPlano(){
        return this.plano.size();
    }

    /**
     * Método clone da classe PlanoTrabalho
     * @return PLanoTrabalho clonado
     */
    public PlanoTrabalho clone(){
        return new PlanoTrabalho(this);
    }

}
