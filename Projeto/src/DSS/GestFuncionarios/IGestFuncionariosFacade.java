package DSS.GestFuncionarios;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.Exceptions.UsernameJaExisteException;
import DSS.Exceptions.UsernameNaoExisteException;

import java.util.Map;

public interface IGestFuncionariosFacade {
    void registaFuncionario(Funcionario novo) throws UsernameJaExisteException;

    boolean autenticaFuncionario (String username, String password) throws CredenciaisInvalidasException;

    boolean isAutenticado (String username);

    Map<String, Funcionario> getFuncionarios();

    void incrementaRecepcoes(String username);

    void incrementaEntregas(String username);

    String imprimeRecepcoesEntregas();

    void removeFuncionario (String username);

    Funcionario obtemFuncionario(String username);

    boolean existeFuncionario(String username) throws UsernameNaoExisteException;

}
