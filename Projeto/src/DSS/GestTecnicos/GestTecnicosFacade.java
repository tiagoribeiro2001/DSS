package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestFuncionarios.Funcionario;
import DSS.GestPlanosTrabalho.PlanoTrabalho;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestTecnicosFacade implements IGestTecnicosFacade, Serializable {

    private Map<String, Tecnico> tecnicos;

    public GestTecnicosFacade () {
        this.tecnicos = new HashMap<>();
    }

    public Tecnico getTecnico(String username){
        return this.tecnicos.get(username);
    }

    //Autentica um Técnico.
    public boolean autenticaTecnico(String username, String password) {
        if (this.tecnicos.containsKey(username)) {
            return this.tecnicos.get(username).autenticacao(password);
        }
        return false;
    }

    public boolean existe(String username) {
        return this.tecnicos.containsKey(username);
    }

    public List<Equipamento> getEquipamentosReparados(String username) {
        return this.tecnicos.get(username).getEquipamentosReparados();
    }

    public boolean registaTecnico (Funcionario f) {
        if (!this.tecnicos.containsKey(f.getUsername())) {
            Tecnico t = new Tecnico(f.getUsername(), f.getPassword());
            this.tecnicos.put(t.getUsername(), t.clone());
            return true;
        }
        return false;
    }

    public void registaTecnico(Tecnico t) {
        this.tecnicos.put(t.getUsername(), t.clone());
    }

    public boolean isAutenticado (String username) {
        return this.tecnicos.get(username).isAutenticado();
    }

    public void adicionaEquipamentosReparados(String username, Equipamento equip){
        this.tecnicos.get(username).addEquipamentosReparados(equip);
    }

    public void incrementaTempoGasto (String username, int tempo) {
        this.tecnicos.get(username).incrementaTempoGasto(tempo);
    }

    public void incrementaDesvioTempoGasto (String username, int tempo) {
        this.tecnicos.get(username).incrementaDesvioTempoGasto(tempo);
    }

    public void adicionaEquipamentosReparadosExpresso(String username, Equipamento eq) {
        this.tecnicos.get(username).addEquipamentosReparadosExpresso(eq);
    }

    public String imprimeReparacoesInfo() {
        StringBuilder sb = new StringBuilder();
        for (Tecnico tec : tecnicos.values()){
            sb.append("Username: ").append(tec.getUsername()).append("\n");
            sb.append("Duração média das reparações: ").append(tec.tempoMedioReparacao()).append(" minutos\n");
            sb.append("Desvio médio em relação à duração prevista: ").append(tec.desvioTempoMedioReparacao()).append(" minutos\n");
        }
        return sb.toString();
    }


}
