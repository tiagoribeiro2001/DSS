package DSS.GestFuncionarios;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.Exceptions.UsernameJaExisteException;
import DSS.Exceptions.UsernameNaoExisteException;

import java.util.Map;

public interface IGestFuncionariosFacade {
    void registaFuncionario(String username, String password) throws UsernameJaExisteException;

    boolean autenticaFuncionario (String username, String password) throws CredenciaisInvalidasException;

    boolean isAutenticado (String username);

    Map<String, Funcionario> getFuncionarios();

    Funcionario getFuncionario(String username) throws UsernameNaoExisteException;

    void incrementaRecepcoes(String username);

    void incrementaEntregas(String username);

    void removeFuncionario (String username);

    Funcionario obtemFuncionario(String username);

    boolean existeFuncionario(String username) throws UsernameNaoExisteException;

    boolean funcionariosIsEmpty();

    String imprimeRecepcoesEntregas();
}
