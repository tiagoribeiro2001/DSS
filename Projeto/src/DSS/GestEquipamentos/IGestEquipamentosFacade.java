package DSS.GestEquipamentos;

import DSS.Exceptions.EquipamentoInexistenteException;

public interface IGestEquipamentosFacade {
    void registaEquipamento (Equipamento e);
    void consertaEquipamento (int nif);
    void registaEquipamentoExpresso(Equipamento e);
    Equipamento obtemEquipamento (int nif) throws EquipamentoInexistenteException;
    boolean existeEquipamento(int nif);
    void removeEquipamento(int nif) throws EquipamentoInexistenteException;
    boolean isNaoReparadosEmpty ();
    double getCustoReparacaoTotal(int nif);
    void insereCustoReparacao(int nif, double custo);
    boolean estaReparado(int nif) throws EquipamentoInexistenteException;
    boolean isExpressoEmpty();
    Equipamento getExpressoMaisAntigo();
}
