package DSS.GestFuncionarios;

import DSS.GestTecnicos.Tecnico;

import java.util.HashMap;
import java.util.Map;


public class GestFuncionariosFacade implements IGestFuncionariosFacade {

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
        Map<String, Funcionario> newFun = new HashMap<>();
        this.funcionarios.values().forEach(j -> newFun.put(j.getUsername(), j.clone())); //Clonar HashMap
        return newFun;
    }

    public void incrementaRecepcoes(String username){
        this.funcionarios.get(username).incRecepcoes();
    }

    public void incrementaEntregas(String username){
        this.funcionarios.get(username).incEntregas();
    }

    public String imprimeRecepcoesEntregas() {
        StringBuilder sb = new StringBuilder();
        for (Funcionario fun : funcionarios.values()){
            sb.append("Username: ").append(fun.getUsername()).append("\n");
            sb.append("Número de recepções de equipamentos: ").append(fun.getRecepcoes()).append("\n");
            sb.append("Número de entregas de equipamentos: ").append(fun.getEntregas()).append("\n");
        }
        return sb.toString();
    }
}
