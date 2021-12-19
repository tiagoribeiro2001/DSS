package DSS;

import DSS.GestFuncionarios.Funcionario;

import java.util.List;

public class Cliente {

    private String endereco_mail;
    private List<String> mails;
    private int NIF;

    public void pede_orcamento(Equipamento e, Funcionario f){
        //Pede orçamento para a reparação de um equipamento
    }

    public boolean recebe_orcamento(Equipamento e){
        //Cliente receber orçamento e indica se aceita ou recusa
        return true;
    }

    public void enviar_resposta(Funcionario f){
        //Apos receber mail do orçamento decide se aceita ou não e envia a sua resposta
    }

    public Equipamento recolher_equipamento(){
        //Se não aceitar vai buscar o equipamento
        return null;
    }

}
