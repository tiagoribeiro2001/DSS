package DSS.GestEquipamentos;

import DSS.GestFuncionarios.Funcionario;
import DSS.GestTecnicos.Tecnico;

public class Equipamento {

    private int nifCliente;
    private String contacto;
    private Funcionario funcionario;
    private boolean repaired;
    private boolean servicoExpresso;

    public Equipamento (int nif, Funcionario fun, String cont, boolean expresso) {
        this.nifCliente = nif;
        this.funcionario = fun.clone();
        this.contacto = cont;
        this.repaired = false;
        this.servicoExpresso = expresso;
    }

    public Equipamento(Equipamento e) {
        this.nifCliente = e.getNifCliente();
        this.funcionario = e.getFuncionario();
        this.contacto = e.getContacto();
        this.repaired = e.isRepaired();
        this.servicoExpresso = e.isServicoExpresso();
    }

    public int getNifCliente(){return this.nifCliente;}
    public Funcionario getFuncionario(){return this.funcionario.clone();}
    public boolean isRepaired() {return this.repaired;}
    public boolean isServicoExpresso(){return this.servicoExpresso;}
    public String getContacto() {return this.contacto;}



    public Equipamento clone () {return new Equipamento(this);}
}
