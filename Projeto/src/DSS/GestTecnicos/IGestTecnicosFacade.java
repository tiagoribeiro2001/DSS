package DSS.GestTecnicos;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.Exceptions.UsernameNaoExisteException;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestFuncionarios.Funcionario;
import DSS.GestPlanosTrabalho.PlanoTrabalho;

import java.util.List;

/**
 * Interface IGestTecnicosFacade que ocntém os seguintes métodos
 */
public interface IGestTecnicosFacade {
    /**
     * Método getter de um Tecnico
     * @param username Username do Tecnico a procurar
     * @return Tecnico que foi procurado
     * @throws UsernameNaoExisteException Exceção lançada quando não é encontrado um Tecnico com o username dado
     */
    Tecnico getTecnico(String username) throws UsernameNaoExisteException;

    /**
     * Método que efetua a autenticação de um Tecnico
     * @param username Username do Tecnico
     * @param password Password do Tecnico
     * @return Booleano que indica se o Tecnico foi autenticado com sucesso
     * @throws CredenciaisInvalidasException Exceção lançada quando as credencias fornecidas não correspondem às que estão no sistema
     */
    boolean autenticaTecnico(String username, String password) throws CredenciaisInvalidasException;

    /**
     * Método que verifica se um Tecnico está autenticado
     * @param username Username do Tecnico
     * @return Booleano que indica se o Tecnico está autenticado
     */
    boolean isAutenticado(String username);

    /**
     * Método que regista um Tecnico no sitema
     * @param t Tecnico a registar
     */
    void registaTecnico(Tecnico t);

    /**
     * Método que verifica se existe um Tecnico com um dado username
     * @param username Username a procurar
     * @return Booleano que indica se o Tecnico existe
     */
    boolean existe(String username);

    /**
     * Método getter da lista de equipamentos reparados por um Tecnico
     * @param username Username do Tecnico
     * @return Lista de equipamentos reparados
     */
    List<Equipamento> getEquipamentosReparados(String username);

    /**
     * Método que adiciona um Equipamento à lista de equipamentos reparados de um dado Tecnico
     * @param username Username do Tecnico
     * @param equip Equipamento a adicionar
     */
    void adicionaEquipamentosReparados(String username, Equipamento equip);

    /**
     * Método que adiciona um Equipamento expresso à lista de equipamentos expresso reparados de um dado Tecnico
     * @param username Username do Tecnico
     * @param eq Equipamento a adicionar
     */
    void adicionaEquipamentosReparadosExpresso(String username, Equipamento eq);

    /**
     * Método que adiciona um plano de trabalho ao mapa de planos de trabalho realizados de uma dado Tecnico
     * @param username Username do Tecnico
     * @param nif Nif do dono do Equipamento
     * @param plano Plano de trabalho a inserir
     */
    void addPlanoTrabalho(String username, int nif, PlanoTrabalho plano);

    /**
     * Método que incrementa o tempo gasto em reparações de um dado Tecnico
     * @param username Username do Tecnico
     * @param tempo Tempo gasto em reparações
     */
    void incrementaTempoGasto(String username, int tempo);

    /**
     * Método que incrementa o desvio de tempo gasto em reparações de um dado Tecnico
     * @param username Username do Tecnico
     * @param tempo Desvio de tempo gasto em reprações
     */
    void incrementaDesvioTempoGasto(String username, int tempo);

    /**
     * Método que verifica se o mapa de técnicos do sistema está vazio
     * @return Booleano que indica se o mapa está vazio
     */
    boolean tecnicosIsEmpty();

    /**
     * Método que cria uma String com informações sobre as reparação efetuados pelo Tecnico
     * @return String com informações sobre as reparações de um Tecnico
     */
    String imprimeReparacoesInfo();

    /**
     * Método que cria uma String com informação sobre todas as intervenções de um Tecnico
     * @param username Username do Tecnico
     * @return String com informações sobre todas as intervenções de um Tecnico
     * @throws UsernameNaoExisteException Exceção lançada quando o username dado não existe no sistema
     */
    String imprimeIntervencoes(String username) throws UsernameNaoExisteException;

    /**
     * Método que efetua o registo de um Tecnico a partir de um Funcionario
     * @param f Funcionario a registar como Tecnico
     * @return Booleano que indica se o registo foi efetuado com sucesso
     */
    boolean registaTecnico(Funcionario f);
}
