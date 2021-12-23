package DSS.GestEquipamentos;

import DSS.Exceptions.EquipamentoInexistenteException;
import DSS.GestFuncionarios.Funcionario;

public interface IGestEquipamentosFacade {
    void registaEquipamento (int nif, Funcionario fun, String email, boolean expresso);
    void consertaEquipamento (int nif);
    void registaEquipamentoExpresso(int nif, Funcionario fun, String email, boolean expresso);
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
