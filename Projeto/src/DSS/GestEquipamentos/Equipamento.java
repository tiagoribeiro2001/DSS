package DSS.GestEquipamentos;

import DSS.GestFuncionarios.Funcionario;
import DSS.GestTecnicos.Tecnico;

public class Equipamento {

    private int nifCliente;
    private Funcionario funcionario;
    private boolean repaired;
    private boolean servicoExpresso;

    public Equipamento (int nif, Funcionario fun, boolean expresso) {
        this.nifCliente = nif;
        this.funcionario = fun.clone();
        this.repaired = false;
        this.servicoExpresso = expresso;
    }

    public Equipamento(Equipamento e) {
        this.nifCliente = e.getNifCliente();
        this.funcionario = e.getFuncionario();
        this.repaired = e.isRepaired();
        this.servicoExpresso = e.isServicoExpresso();
    }

    public int getNifCliente(){return this.nifCliente;}
    public Funcionario getFuncionario(){return this.funcionario.clone();}
    public boolean isRepaired() {return this.repaired;}
    public boolean isServicoExpresso(){return this.servicoExpresso;}



    public Equipamento clone () {return new Equipamento(this);}
}
