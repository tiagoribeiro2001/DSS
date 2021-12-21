package DSS.GestEquipamentos;

public interface IGestEquipamentosFacade {
    void registaEquipamento (Equipamento e);
    void consertaEquipamento (int nif);
    void registaEquipamentoExpresso(Equipamento e);
    Equipamento obtemEquipamento (int nif);
    boolean existeEquipamento(int nif);
    void removeEquipamento(int nif);
    boolean isNaoReparadosEmpty ();
    double getCustoReparacaoTotal(int nif);
    void insereCustoReparacao(int nif, double custo);
    boolean estaReparado(int nif);
    boolean isExpressoEmpty();
    Equipamento getExpressoMaisAntigo();
}
