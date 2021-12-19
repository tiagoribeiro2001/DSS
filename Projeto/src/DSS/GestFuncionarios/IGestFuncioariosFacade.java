package DSS.GestFuncionarios;

import java.util.Map;

public interface IGestFuncioariosFacade {
    void registaFuncionario(Funcionario novo);

    boolean autenticaFuncionario (String username, String password);

    Map<String, Funcionario> getFuncionarios();

}
