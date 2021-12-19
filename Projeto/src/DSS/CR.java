package DSS;

import DSS.GestFuncionarios.Funcionario;
import DSS.GestTecnicos.Tecnico;

import java.util.List;
import java.util.Map;

public class CR {

    private Map<Integer, List<Equipamento>> equipamentos_por_reparar;
    private Map<Integer, Funcionario> funcionario;
    private Map<Integer, Tecnico> tecnico;
    private Map<Integer,Cliente> clientes;
    private List<Equipamento> equipamento_abandonado;

    public void new_Registo(Cliente c, Equipamento e){
        //Cliente quer registar equipamento
    }

    public void equipamento_antigo(){
        //Método que verifica os equipamentos todos e coloca como abandonado aqueles que estão à espera a mais de 90 dias
    }


}