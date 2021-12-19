package DSS.GestFuncionarios;

import java.util.HashMap;
import java.util.Map;

public class GestFuncionariosFacade implements IGestFuncioariosFacade {

    private Map<String, Funcionario> funcionarios;

    public GestFuncionariosFacade (){
        this.funcionarios = new HashMap<>();
    }

    //Regista funcionário no sistema.
    public void registaFuncionario(Funcionario fun) {
        funcionarios.put(fun.getUsername(), fun.clone());
    }

    //Retorna true se o funcionario ficar autenticado, false se nao ficar.
    public boolean autenticaFuncionario (String username, String password) {
        if (this.funcionarios.containsKey(username)) {
            return this.funcionarios.get(username).autentificacao(password);
        }
        return false;
    }

    public boolean isAutenticado (String username) {
        return this.funcionarios.get(username).isAutenticado();
    }
    //Devolve todos os funcionários registados no sistema.
    public Map<String,Funcionario> getFuncionarios() {
        Map<String, Funcionario> newFun = new HashMap<String, Funcionario>();
        this.funcionarios.values().forEach(j -> newFun.put(j.getUsername(), j.clone())); //Clonar HashMap
        return newFun;
    }
}
