package DSS.GestGestores;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.GestFuncionarios.Funcionario;

/**
 * Interface IGestGestoresFacade que contém os seguintes métodos
 */
public interface IGestGestoresFacade{
    /**
     * Método que efetua a autenticação de um Gestor
     * @param username Username do Gestor
     * @param password Password do Gestor
     * @return Booleano que indica se o Gestor foi autenticado com sucesso
     * @throws CredenciaisInvalidasException
     */
    boolean autenticaGestor(String username, String password) throws CredenciaisInvalidasException;

    /**
     * Método que verifica se um Gestor está autenticado
     * @param username Username do Gestor
     * @return Booleano que indica se o Gestor está autenticado
     */
    boolean isAutenticado(String username);

    /**
     * Método que regista um Gestor no sistema
     * @param username Username do Gestor
     * @param password Password do Gestor
     */
    void registaGestor(String username, String password);

    /**
     * Método que efetua o registo de um Gestor a partir de um Funcionario
     * @param f Funcionario a registar como Gestor
     * @return Booleano que indica se o registo foi efetuado com sucesso
     */
    boolean registaGestor(Funcionario f);

}
