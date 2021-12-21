package DSS.GestPlanosTrabalho;

public interface IGestPlanosTrabalhoFacade {
    void adicionaPlano(PlanoTrabalho pt);

    PlanoTrabalho obterPlano(int nif);

    void adicionaPlanoRealizado(PlanoTrabalho pt);

    PlanoTrabalho obterPlanoRealizado(int nif);

    int getTempoPasso(int nif, int passo);
}
