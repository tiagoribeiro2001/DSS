package DSS.GestPlanosTrabalho;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestOrcamentos.Orcamento;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlanoTrabalho implements Serializable {
    private List<PassosTrabalho> plano;
    private Orcamento orc;

    public PlanoTrabalho(Equipamento e) {
        this.plano = new ArrayList<>();
        this.orc = new Orcamento(e.clone());
    }

    public PlanoTrabalho(PlanoTrabalho pt) {
        this.plano = pt.getPlano();
        this.orc = pt.getOrcamento();
    }

    public double getCustoTotal() {
        return this.plano.stream().mapToDouble(PassosTrabalho::getCusto).sum();
    }

    public void adicionaPasso (String passo, double custo, int tempo) {
        PassosTrabalho pt = new PassosTrabalho(passo, custo, tempo);
        this.plano.add(pt.clone());
    }

    public void registaOrcamento (String problema) {
        this.orc.setValor(getCustoTotal());
        this.orc.setProblema(problema);
    }

    public List<PassosTrabalho> getPlano () { return this.plano.stream().map(PassosTrabalho::clone).collect(Collectors.toList()); }
    public Orcamento getOrcamento() { return this.orc.clone(); }

    public int getTempo(int passo){
        return this.plano.get(passo).getTempo();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{\n");
        this.plano.forEach(j -> sb.append(j.toString()));
        sb.append("}\n");
        return sb.toString();
    }

    public int tamanhoPlano() {
        return this.plano.size();
    }
    public PlanoTrabalho clone() { return new PlanoTrabalho(this); }

}
