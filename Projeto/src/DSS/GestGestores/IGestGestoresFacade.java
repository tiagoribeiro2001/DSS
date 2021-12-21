package DSS.GestGestores;

import DSS.GestFuncionarios.Funcionario;

public interface IGestGestoresFacade {
    boolean autenticaGestor(String username, String password);

    boolean isAutenticado(String username);

    void registaGestor(Gestor g);

    boolean registaGestor(Funcionario f);

}
