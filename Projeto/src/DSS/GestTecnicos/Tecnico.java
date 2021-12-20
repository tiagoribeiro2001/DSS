package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tecnico {

    private String username;
    private String password;
    private boolean autenticado;
    private List<Equipamento> equipamentos_reparados;

    public Tecnico (String username, String password) {
        this.username = username;
        this.password = password;
        this.autenticado = false;
        this.equipamentos_reparados = new ArrayList<>();
    }

    public Tecnico (Tecnico t) {
        this.username = t.getUsername();
        this.autenticado = t.isAutenticado();
        this.password = t.getPassword();
        this.equipamentos_reparados = t.getEquipamentosReparados();
    }

    public String getUsername() {
        return this.username;
    }

    private String getPassword() {
        return this.password;
    }

    public boolean isAutenticado() {
        return this.autenticado;
    }

    public List<Equipamento> getEquipamentosReparados() {
        return this.equipamentos_reparados.stream().map(Equipamento::clone).collect(Collectors.toList());
    }

    public boolean autenticacao (String password) {
        if(this.password.equals(password)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    public void calOrcamento(Equipamento e){
        //Calcula o orcamento do equipamento
    }

    public void give_orcamento(Equipamento e){
        //Tecnico atribui um orçamento ao equipamento
    }

    public void equipamentoReparado(Equipamento e){
        //Tecnico indica que o equipamento está repado
    }

    public void addEquipamentosReparados(Equipamento e){
        this.equipamentos_reparados.add(e);
    }

    public Tecnico clone() {return new Tecnico(this);}
}
