package DSS.GestFuncionarios;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.Exceptions.UsernameJaExisteException;
import DSS.Exceptions.UsernameNaoExisteException;

import java.util.Map;

/**
 * Interface IGestFuncionariosFacade que contém os seguintes métodos
 */
public interface IGestFuncionariosFacade{
    /**
     * Método que regista um Funcionario no sistema
     * @param username Username do Funcionario
     * @param password Password do Funcionario
     * @throws UsernameJaExisteException Exceção lançada quando já existe um Funcionamrio com o mesmo username
     */
    void registaFuncionario(String username, String password) throws UsernameJaExisteException;

    /**
     * Método que efetua a autenticação de um Funcionario
     * @param username Username do Funcionario
     * @param password Password do Funcionario
     * @return Booleano que indica se o Funcionario foi autenticado com sucesso
     * @throws CredenciaisInvalidasException Exceção lançada quando as credenciais inseridas não coincidem com as de nenhum Funcionario registado no sistema
     */
    boolean autenticaFuncionario(String username, String password) throws CredenciaisInvalidasException;

    /**
     * Método que verifica se um Funcionario está autenticado
     * @param username Username do Funcionario
     * @return Booleano que indica se o Funcionario está autenticado
     */
    boolean isAutenticado(String username);

    /**
     * Método getter do mapa de GestFuncionarioFacade
     * @return Mapa dos funcionarios do sistema
     */
    Map<String, Funcionario> getFuncionarios();

    /**
     * Método getter de um Funcionario
     * @param username Username do Funcionario
     * @return Funcionario procurado
     * @throws UsernameNaoExisteException Exceção lançada quando não é encontrado o Funcionario com o username dado
     */
    Funcionario getFuncionario(String username) throws UsernameNaoExisteException;

    /**
     * Método que incrementa as recepções de equipamentos de um Funcionario
     * @param username Username do Funcionario
     */
    void incrementaRecepcoes(String username);

    /**
     * Método que incrementa as entregas de equipamentos de um Funcionario
     * @param username Username do Funcionario
     */
    void incrementaEntregas(String username);

    /**
     * Método que remove um Funcionario do sistema
     * @param username Username do Funcionario
     */
    void removeFuncionario (String username);

    /**
     * Método que verifica se existe um dado funcionario
     * @param username Username do Funcionario
     * @return Booleano que indica se esse Funcionario existe
     * @throws UsernameNaoExisteException Exceção lançada quando não existe tal Funcionario
     */
    boolean existeFuncionario(String username) throws UsernameNaoExisteException;

    /**
     * Método que verifica se existe algum Funcionario no sistema
     * @return Booleano que indica se existem algum Funcionario no sistema
     */
    boolean funcionariosIsEmpty();

    /**
     * Método que passa as informações sobre recepções e entregas de equipamentos para String
     * @return String com informação sobre recepções e entregas
     */
    String imprimeRecepcoesEntregas();
}
