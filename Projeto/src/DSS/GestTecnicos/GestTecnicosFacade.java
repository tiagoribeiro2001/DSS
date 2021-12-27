package DSS.GestTecnicos;

import DSS.Exceptions.CredenciaisInvalidasException;
import DSS.Exceptions.UsernameNaoExisteException;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestFuncionarios.Funcionario;
import DSS.GestPlanosTrabalho.PlanoTrabalho;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe GestTecnicosFacade usada para representar um coleção de Tecnicos no sistema
 */
public class GestTecnicosFacade implements IGestTecnicosFacade, Serializable {

    private Map<String, Tecnico> tecnicos;

    public GestTecnicosFacade () {
        this.tecnicos = new HashMap<>();
    }

    public Tecnico getTecnico(String username) throws UsernameNaoExisteException {
        if(this.tecnicos.containsKey(username))
            return this.tecnicos.get(username);
        throw new UsernameNaoExisteException("Erro: Username não está registado no sistema.");
    }

    //Autentica um Técnico.
    public boolean autenticaTecnico(String username, String password) throws CredenciaisInvalidasException {
        if (this.tecnicos.containsKey(username)) {
            if (this.tecnicos.get(username).autenticacao(password))
                return true;
        }
        throw new CredenciaisInvalidasException("Erro: Credenciais inseridas são inválidas.");
    }

    public boolean registaTecnico (Funcionario f) {
        if (!this.tecnicos.containsKey(f.getUsername())) {
            Tecnico t = new Tecnico(f.getUsername(), f.getPassword());
            this.tecnicos.put(t.getUsername(), t.clone());
            return true;
        }
        return false;
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

    public void addPlanoTrabalho(String username, int nif, PlanoTrabalho plano){
        this.tecnicos.get(username).addPlanoTrabalho(nif, plano);
    }

    public boolean tecnicosIsEmpty(){
        return this.tecnicos.isEmpty();
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

    public String imprimeIntervencoes(String username) throws UsernameNaoExisteException{
        StringBuilder sb = new StringBuilder();
        Tecnico tec = getTecnico(username);
        sb.append("Reparações Normais:\n");
        for(Equipamento e : tec.getEquipamentosReparados()) {
            int nif = e.getNifCliente();
            sb.append("[NIF: ").append(nif).append("] Plano de trabalho da reparação:\n");
            PlanoTrabalho plano = tec.getPlanoTrabalho(nif);
            for (int i = 0; i < plano.tamanhoPlano(); i++) {
                sb.append("--------------------//----------------------\n");
                sb.append(plano.getPlano().get(i).toString()).append("\n");
            }
        }
        sb.append("Reparações Expresso:\n");
        for(Equipamento e : tec.getEquipamentosReparadosExpresso()) {
            int nif = e.getNifCliente();
            double custo = e.getCustoReparacao();
            sb.append("[NIF: ").append(nif).append("] Custo da reparação expresso: ").append(custo).append("\n");
            sb.append("--------------------//----------------------\n");
        }
        return sb.toString();
    }

}
