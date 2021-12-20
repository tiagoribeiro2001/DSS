package DSS.GestFuncionarios;

import java.util.Map;

public interface IGestFuncionariosFacade {
    void registaFuncionario(Funcionario novo);

    boolean autenticaFuncionario (String username, String password);

    boolean isAutenticado (String username);

    Map<String, Funcionario> getFuncionarios();

    public void incrementaRecepcoes(String username);

    public void incrementaEntregas(String username);

}
