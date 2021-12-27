package DSS.GestPagamentos;

import DSS.GestEquipamentos.Equipamento;

/**
 * Interface IGestPagamentosFacade que contém os seguintes métodos
 */
public interface IGestPagamentosFacade {
    /**
     * Método que adiciona um Pagamnento ao sistema
     * @param nif Nif do dono do equipamento
     * @param valor Valor da reparação
     * @param equip Equipamnento que foi reparado
     */
    void addPagamento(int nif, double valor, Equipamento equip);
}
