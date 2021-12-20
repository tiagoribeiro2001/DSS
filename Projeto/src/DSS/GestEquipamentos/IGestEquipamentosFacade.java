package DSS.GestEquipamentos;

public interface IGestEquipamentosFacade {
    void insereEquipamento (Equipamento e);

    Equipamento obtemEquipamento (int nif);
    boolean existeEquipamento(int nif);
    void removeEquipamento(int nif);
}
