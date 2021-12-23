package DSS.GestFuncionarios;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.Exceptions.UsernameJaExisteException;
import DSS.Exceptions.UsernameNaoExisteException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class GestFuncionariosFacade implements IGestFuncionariosFacade, Serializable {

    private Map<String, Funcionario> funcionarios;

    public GestFuncionariosFacade (){
        this.funcionarios = new HashMap<>();
    }

    //Regista funcionário no sistema.
    public void registaFuncionario(Funcionario fun) throws UsernameJaExisteException{
        if (this.funcionarios.containsKey(fun.getUsername())) throw new UsernameJaExisteException("Erro: Já existe um funcionário registado com esse username!");
        funcionarios.put(fun.getUsername(), fun.clone());
    }

    public boolean existeFuncionario(String username) throws UsernameNaoExisteException {
        if (this.funcionarios.containsKey(username)) return true;
        throw new UsernameNaoExisteException("Erro: Esse funcionário não está registado no sistema.");
    }

    //Retorna true se o funcionario ficar autenticado, false se nao ficar.
    public boolean autenticaFuncionario (String username, String password) throws CredenciaisInvalidasException {
        if (this.funcionarios.containsKey(username)) {
            if (this.funcionarios.get(username).autentificacao(password))
                return true;
        }
        throw new CredenciaisInvalidasException("Erro: As credenciais inseridas são inválidas!");
    }

    public void removeFuncionario (String username) {
        this.funcionarios.remove(username);
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

    public Funcionario obtemFuncionario(String username) {
        return this.funcionarios.get(username).clone();
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
