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
    private List<Equipamento> equipamentos_reparados_expresso;
    private int tempoGasto;

    public Tecnico (String username, String password) {
        this.username = username;
        this.password = password;
        this.autenticado = false;
        this.equipamentos_reparados = new ArrayList<>();
        this.equipamentos_reparados_expresso = new ArrayList<>();
        this.tempoGasto = 0;
    }

    public Tecnico (Tecnico t) {
        this.username = t.getUsername();
        this.autenticado = t.isAutenticado();
        this.password = t.getPassword();
        this.equipamentos_reparados = t.getEquipamentosReparados();
        this.equipamentos_reparados_expresso = t.getEquipamentosReparadosExpresso();
        this.tempoGasto = t.getTempoGasto();
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

    public int getTempoGasto() {
        return this.tempoGasto;
    }

    public List<Equipamento> getEquipamentosReparados() {
        return this.equipamentos_reparados.stream().map(Equipamento::clone).collect(Collectors.toList());
    }

    public List<Equipamento> getEquipamentosReparadosExpresso() {
        return this.equipamentos_reparados_expresso.stream().map(Equipamento::clone).collect(Collectors.toList());
    }

    public void incrementaTempoGasto(int tempo) {this.tempoGasto += tempo;}

    public boolean autenticacao (String password) {
        if(this.password.equals(password)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    public void addEquipamentosReparados(Equipamento e){
        this.equipamentos_reparados.add(e);
    }

    public void addEquipamentosReparadosExpresso(Equipamento eq) {this.equipamentos_reparados_expresso.add(eq);}

    public String toString() {
        StringBuilder sb = new StringBuilder("Funcionario {\n");
        sb.append("\tUsername - ").append(username).append("\n");
        sb.append("}");
        return sb.toString();
    }

    public Tecnico clone() {return new Tecnico(this);}
}
