package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;

import java.util.List;

public interface IGestTecnicosFacade {
    public Tecnico getTecnico(String username);
    public boolean autenticaTecnico(String username, String password);
    boolean isAutenticado (String username);
    void registaTecnico(Tecnico t);
    boolean existe(String username);
    List<Equipamento> getEquipamentosReparados(String username);
    public void adicionaEquipamentosReparados(String username, Equipamento equip);
    void adicionaEquipamentosReparadosExpresso(String username, Equipamento eq);
    void incrementaTempoGasto (String username, int tempo);
}
