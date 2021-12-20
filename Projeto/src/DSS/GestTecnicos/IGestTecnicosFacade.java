package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;

import java.util.List;

public interface IGestTecnicosFacade {
    public Tecnico getTecnico(String username);
    public boolean autenticaTecnico(String username, String password);
    boolean isAutenticado (String username);
    boolean existe(String username);
    List<Equipamento> getEquipamentosReparados(String username);
}
