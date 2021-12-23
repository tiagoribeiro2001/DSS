package DSS.GestGestores;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.GestFuncionarios.Funcionario;

public interface IGestGestoresFacade {
    boolean autenticaGestor(String username, String password) throws CredenciaisInvalidasException;

    boolean isAutenticado(String username);

    void registaGestor(String username, String password);

    boolean registaGestor(Funcionario f);

}
