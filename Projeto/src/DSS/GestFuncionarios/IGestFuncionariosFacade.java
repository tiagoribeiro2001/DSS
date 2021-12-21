package DSS.GestFuncionarios;

import java.util.Map;

public interface IGestFuncionariosFacade {
    void registaFuncionario(Funcionario novo);

    boolean autenticaFuncionario (String username, String password);

    boolean isAutenticado (String username);

    Map<String, Funcionario> getFuncionarios();

    void incrementaRecepcoes(String username);

    void incrementaEntregas(String username);

    String imprimeRecepcoesEntregas();

    void removeFuncionario (String username);

    Funcionario obtemFuncionario(String username);

}
