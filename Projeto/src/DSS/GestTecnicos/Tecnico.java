package DSS.GestTecnicos;

import DSS.Equipamento;

import java.util.List;

public class Tecnico {

    private String username;
    private String password;
    private boolean autenticado;
    private List<Equipamento> orcamentos;
    private List<Equipamento> orcamentos_para_reparar;
    private List<Equipamento> equipamentos_reparados;


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
}
