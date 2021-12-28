package DSS.GestPlanosTrabalho;

import DSS.GestEquipamentos.Equipamento;

/**
 * Interface IGestPlanosTrabalho que contém os seguintes métodos
 */
public interface IGestPlanosTrabalhoFacade {
    /**
     * Método que adiciona um PlanoTrabalho ao sistema
     * @param pt PlanoTrabalho a ser adicionado
     */
    void adicionaPlano(PlanoTrabalho pt);

    /**
     * Método que cria um plano de trabalho e o adiciona ao sistema
     * @param e Equipamento a qual vai ser aplicado o plano
     */
    void criaPlano(Equipamento e);

    /**
     * Método que cria um plano de trabalho que já foi realizado e o adiciona ao sistema
     * @param e Equipamento a qual foi aplicado o plano
     */
    void criaPlanoRealizado(Equipamento e);

    /**
     * Método que obtém o PlanoTrabalho dado um nif
     * @param nif Nif do dono do Equipamento
     * @return PlanoTrabalho efetuado na reparação do equipamento
     */
    PlanoTrabalho obterPlano(int nif);

    /**
     * Método que adiciona um PlanoTrabalho ao mapa de planosde trabalho realizados
     * @param pt PlanoTrabalho que foi realizado
     */
    void adicionaPlanoRealizado(PlanoTrabalho pt);

    /**
     * Método que adiciona um passo a um plano de trabalho dado um nif
     * @param nif Nif do dono do Equipamento
     * @param passo String que descreve o passo
     * @param custo Custo do passo
     * @param tempo Tempo necessário para efetuar o passo
     */
    void adicionaPassoToPlano(int nif, String passo, double custo, int tempo);

    /**
     * Método que adiciona um passo a um plano de trabalho já realizado dado um nif
     * @param nif Nif do dono do Equipamento
     * @param passo String que descreve o passo
     * @param custo Custo do passo
     * @param tempo Tempo necessário para efetuar o passo
     */
    void adicionaPassoToPlanoRealizado(int nif, String passo, double custo, int tempo);

    /**
     * Método que obtém o plano de trabalho que foi realziado dado um nif
     * @param nif Nif do dono do Equipamento
     * @return PlanoTrabalho que foi realizado
     */
    PlanoTrabalho obterPlanoRealizado(int nif);

    /**
     * Método getter do tempo que demorou um dado passo de um PlanoTrabalho
     * @param nif Nif do dono do Equipamento
     * @param passo Número do passo
     * @return Tempo que demorou a realização do passo
     */
    int getTempoPasso(int nif, int passo);
}
