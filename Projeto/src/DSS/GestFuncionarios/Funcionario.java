package DSS.GestFuncionarios;

import DSS.Cliente;
import DSS.Equipamento;
import DSS.GestTecnicos.Tecnico;

public class Funcionario {

    private String username;
    private String password;
    private boolean autentificacao;
    //private boolean disponivel;

    //Construtor Funcioario
    public Funcionario (String username, String password) {
        this.username = username;
        this.password = password;
        this.autentificacao = false;
    }

    //Construtor a partir de objeto
    public Funcionario (Funcionario f) {
        this.username = f.getUsername();
        this.password = f.getPassword();
        this.autentificacao = false;
    }

    //Obtem username
    public String getUsername() {
        return this.username;
    }

    //Obtem password (apenas acessível pela própria classe).
    private String getPassword () {
        return this.password;
    }

    //Autentificação funcionário.
    public boolean autentificacao (String password) {
        if (this.password.equals(password)) {
            this.autentificacao = true;
            return true;
        }
        return false;
    }

    public void regista_equipamento(Equipamento e, Tecnico tecnico){
        // metodo que dado um equipamento regista-o no sistema
    }

    public void notifica_Cliente(Cliente c, Equipamento e){
        //Apos o Equipamento receber orçamento funcionário envia mail ao Cliente
    }

    public void entrega_do_equipamento(Cliente c, Equipamento e){
        //Cliente vem buscar equipamento, se for com orçamento aceite regista o pagamento se não for apenas regista que foi entregue
    }

    public void sem_confirmacao(Equipamento e){
        //Se cliente não deu confirmação de orçamento por mais de 30 dias, orçamento é arquivado
    }

    public Funcionario clone () {
        return new Funcionario(this);
    }
}