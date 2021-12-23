package DSS.GestPagamentos;

import DSS.GestEquipamentos.Equipamento;

public interface IGestPagamentosFacade {
    void addPagamento(int nif, double valor, Equipamento equip);
}
