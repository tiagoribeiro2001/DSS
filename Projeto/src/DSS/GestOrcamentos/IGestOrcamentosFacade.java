package DSS.GestOrcamentos;

import java.util.LinkedHashMap;

/**
 * Interface IGestOrcamentosFacade que contém os seguintes métodos
 */
public interface IGestOrcamentosFacade {
    /**
     * Método que adiciona um Orcamento ao sistema
     * @param o Orcamento a ser adicionado
     */
    void addOrcamento(Orcamento o);

    /**
     * Método que obtém o mapa de orcamentos
     * @return Mapa de orcamentos
     */
    LinkedHashMap<Integer, Orcamento> obtemListaOrcamentos();

    /**
     * Método que obtém o Orcamento que está à mais tempo no sistema
     * @return Orcamento à mais tempo no sistema
     */
    Orcamento obtemOrcamentoMaisAntigo();

    /**
     * Método que remove o Orcamento que está à mais tempo no sistema
     */
    void removeOrcamentoMaisAntigo();

    /**
     * Método que obtém o valor orçamentado para a reparação de um Equipamento de um dado nif
     * @param nif Nif do dono do Equipamento
     * @return Valor orçamentado
     */
    double obtemOrcamento(int nif);

    /**
     * Método que verifica se existe um orcamento para uma reparação de um Equipamento de um dado nif
     * @param nif Nif do dono do Equipamento
     * @return Booleano que indica se existe o orçamento
     */
    boolean existeOrcamento(int nif);

    /**
     * Método getter de um Orcamento dado um nif
     * @param nif Nif dodo do Equipamento
     * @return Orcamento da reparação do equipamento
     */
    Orcamento getOrcamento (int nif);

    /**
     * Método toString da classe GestOrcamentosFacade
     * @return String do mapa de orçamentos
     */
    String toString();
}
