package DSS.GestPlanosTrabalho;

public interface IGestPlanosTrabalhoFacade {

    void adicionaPlano(PlanoTrabalho pt);
    PlanoTrabalho obterPlano(int nif);
}
