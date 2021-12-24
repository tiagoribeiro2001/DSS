package DSS.GestEquipamentos;

import DSS.Exceptions.EquipamentoInexistenteException;
import DSS.GestFuncionarios.Funcionario;

public interface IGestEquipamentosFacade {
    /**
     * Método que regista um equipamento que necessita de uma reparação normal no sistema
     * @param nif Nif do cliente
     * @param fun Funcionário que reparou o equipamento
     * @param email Contacto do cliente (e-mail)
     * @param expresso Booleano que indica se o serviço realizado foi expresso
     */
    void registaEquipamento (int nif, Funcionario fun, String email, boolean expresso);

    /**
     * Método que adiciona um equipamento à lista de equipamentos acertados
     * @param nif Nif do cliente
     */
    void consertaEquipamento (int nif);

    /**
     * Método que regista um equipamento que necessita de uma reparação expresso no sistema
     * @param nif Nif do cliente
     * @param fun Funcionário que reparou o equipamento
     * @param email Contacto do cliente (e-mail)
     * @param expresso Booleano que indica se o serviço realizado foi expresso
     */
    void registaEquipamentoExpresso(int nif, Funcionario fun, String email, boolean expresso);

    /**
     * Método que procura um equipamento pelo seu id (nif)
     * @param nif Nif do dono do equipamento
     * @return Equipamento procurado
     * @throws EquipamentoInexistenteException Exceção lançada quando não é encontrado o equipamento procurado
     */
    Equipamento obtemEquipamento (int nif) throws EquipamentoInexistenteException;

    /**
     * Método que verifica se existe um dado equipamento
     * @param nif Nif do cliente
     * @return Booleano que indica se existe o euqipamento
     */
    boolean existeEquipamento(int nif);

    /**
     * Método que remove um equipamento do sistema
     * @param nif Nif do cliente
     * @throws EquipamentoInexistenteException Exceção lançada quando não é encontrado o equipamento a remover
     */
    void removeEquipamento(int nif) throws EquipamentoInexistenteException;

    /**
     * Método que verifica se a lista de equipamentos não reparados está vazia
     * @return Booleano que indica se a lista está vazia
     */
    boolean isNaoReparadosEmpty ();

    /**
     * Método que indica o custo da reparação
     * @param nif Nif do cliente
     * @return Valor da reparação
     */
    double getCustoReparacaoTotal(int nif);

    /**
     * Método que altera o custo da reparação de unm equipamento
     * @param nif Nif do cliente
     * @param custo Custo da reparação
     */
    void insereCustoReparacao(int nif, double custo);

    /**
     * Método que indica se um equipamento está reparado
     * @param nif Nif do cliente
     * @return Booleano que indica o estado atual de reparação do equipamento
     * @throws EquipamentoInexistenteException Execeção lançada quando não é encontrado o equipamento à procura
     */
    boolean estaReparado(int nif) throws EquipamentoInexistenteException;

    /**
     * Método que verifica se a lista de equipamentos à espera de uma reparação expresso está vazia
     * @return Booleano que indica se a lista está vazia
     */
    boolean isExpressoEmpty();

    /**
     * Método que devolve o equipamento à espera de uma reparação expresso registado há mais tempo no sistema
     * @return Equipamento expresso À mais tempo no sistema
     */
    Equipamento getExpressoMaisAntigo();
}
