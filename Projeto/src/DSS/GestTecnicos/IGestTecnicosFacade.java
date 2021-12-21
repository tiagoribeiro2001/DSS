package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestFuncionarios.Funcionario;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public interface IGestTecnicosFacade {
    Tecnico getTecnico(String username);

    boolean autenticaTecnico(String username, String password);

    boolean isAutenticado (String username);

    void registaTecnico(Tecnico t);

    boolean existe(String username);

    List<Equipamento> getEquipamentosReparados(String username);

    void adicionaEquipamentosReparados(String username, Equipamento equip);

    void adicionaEquipamentosReparadosExpresso(String username, Equipamento eq);

    void incrementaTempoGasto (String username, int tempo);

    void incrementaDesvioTempoGasto (String username, int tempo);

    String imprimeReparacoesInfo();

    boolean registaTecnico (Funcionario f);
}
