package DSS.GestPedidosOrcamento;

import DSS.GestEquipamentos.Equipamento;
import java.io.Serializable;

/**
 * Classe PedidoOrcamento usada para representar um pedido de orçamento para uma reparação no sistema
 */
public class PedidoOrcamento implements Serializable{
    private Equipamento equipamento;
    private String problema;

    /**
     * Construtor parametrizado da classe PedidoOrcamento
     * @param eq Equipamento a ser reparado
     * @param problema Problema que leva à reparação
     */
    public PedidoOrcamento(Equipamento eq, String problema){
        this.equipamento = eq;
        this.problema = problema;
    }

    /**
     * Construtor clone da classe PedidoOrcamento
     * @param po PedidoOrcamento a ser copiado
     */
    public PedidoOrcamento(PedidoOrcamento po){
        this.equipamento = po.getEquipamento();
        this.problema = po.getProblema();
    }

    /**
     * Método getter do Equipamento a que se refere o PedidoOrcamento
     * @return Equipamento a que se refere o PedidoOrcamento
     */
    public Equipamento getEquipamento(){
        return this.equipamento.clone();
    }

    /**
     * Método getter do problema do Equipamento
     * @return String que descreve o problema
     */
    public String getProblema(){
        return this.problema;
    }

    /**
     * Método clone da classe PedidoOrcamento
     * @return PedidoOrcamento clonado
     */
    public PedidoOrcamento clone(){
        return new PedidoOrcamento(this);
    }
}
