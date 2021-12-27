package DSS.GestTecnicos;

import DSS.GestEquipamentos.Equipamento;
import DSS.GestPlanosTrabalho.PlanoTrabalho;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Classe Tecnico usada para representar um tecnico presente no sistema
 */
public class Tecnico implements Serializable{
    private String username;
    private String password;
    private boolean autenticado;
    private List<Equipamento> equipamentos_reparados;
    private List<Equipamento> equipamentos_reparados_expresso;
    private int tempoGasto;
    private int desvioTempoGasto;
    private Map<Integer, PlanoTrabalho> planosRealizados;

    /**
     * Construtor parametrizado da classe Tecnico
     * @param username Username do Tecnico
     * @param password Password do Tecnico
     */
    public Tecnico(String username, String password){
        this.username = username;
        this.password = password;
        this.autenticado = false;
        this.equipamentos_reparados = new ArrayList<>();
        this.equipamentos_reparados_expresso = new ArrayList<>();
        this.tempoGasto = 0;
        this.desvioTempoGasto = 0;
        this.planosRealizados = new HashMap<>();
    }

    /**
     * Construtor clone da classe Tecnico
     * @param t Tecnico a ser copiado
     */
    public Tecnico(Tecnico t){
        this.username = t.getUsername();
        this.autenticado = t.isAutenticado();
        this.password = t.getPassword();
        this.equipamentos_reparados = t.getEquipamentosReparados();
        this.equipamentos_reparados_expresso = t.getEquipamentosReparadosExpresso();
        this.tempoGasto = t.getTempoGasto();
        this.desvioTempoGasto = t.getDesvioTempoGasto();
        this.planosRealizados = t.getPlanosRealizados();
    }

    /**
     * Método getter do username do Tecnico
     * @return Username do Tecnico
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * Método getter da password do Tecnico
     * @return Password do Tecnico
     */
    private String getPassword(){
        return this.password;
    }

    /**
     * Método que verifica se um Tecnico está autenticado
     * @return Booleano que indica se o Tecnico está autenticado
     */
    public boolean isAutenticado(){
        return this.autenticado;
    }

    /**
     * Método getter do tempo gasto em reparações pelo Tecnico
     * @return Tempo gasto em reparações
     */
    public int getTempoGasto(){
        return this.tempoGasto;
    }

    /**
     * Método getter do desvio de tempo gasto em reparações pelo Tecnico
     * @return Desvio de tempo gasto em reparações
     */
    public int getDesvioTempoGasto(){
        return this.desvioTempoGasto;
    }

    /**
     * Método getter da lista de equipamentos reparados por uma reparação normal efetuada pelo Tecnico
     * @return Lista de equipamentos reparados
     */
    public List<Equipamento> getEquipamentosReparados(){
        return this.equipamentos_reparados.stream().map(Equipamento::clone).collect(Collectors.toList());
    }

    /**
     * Método getter da lista de equipamentos reparados por uma reparação expresso efetuada pelo Tecnico
     * @return Lsita de equipamentos expresso reparados
     */
    public List<Equipamento> getEquipamentosReparadosExpresso(){
        return this.equipamentos_reparados_expresso.stream().map(Equipamento::clone).collect(Collectors.toList());
    }

    /**
     * Método getter do mapa de planos de trabalhos realizados nas reparações do Tecnico
     * @return Mapa de planos de trabalho efetuados
     */
    public Map<Integer, PlanoTrabalho> getPlanosRealizados(){
        return new HashMap<>(this.planosRealizados);
    }

    /**
     * Método getter de um plano de trabalho dado um nif do cliente a qual pertence o equipamento
     * @param nif Nif do dono do equipamento de que será procurado o plano de trabalho
     * @return Plano de trabalho do equipamento
     */
    public PlanoTrabalho getPlanoTrabalho(int nif){
        return this.planosRealizados.get(nif);
    }

    /**
     * Método que adiciona um plano de trabalho ao mapa de planos de trabalho realizados pelo Tecnico
     * @param nif Nif do dono do equipamento que será a chave no mapa
     * @param plano Plano de trabalho a inserir no mapa
     */
    public void addPlanoTrabalho(int nif, PlanoTrabalho plano){
        this.planosRealizados.put(nif, plano);
    }

    /**
     * Método que incrementa o tempo gasto em reparações de um Tecnico
     * @param tempo Tempo a incrementar
     */
    public void incrementaTempoGasto(int tempo){
        this.tempoGasto += tempo;
    }

    /**
     * Método que incrementa o desvio de tempo gasto em reparações de um Tecnico
     * @param tempo Desvio de tempo a incrementar
     */
    public void incrementaDesvioTempoGasto(int tempo) {
        this.desvioTempoGasto += tempo;
    }

    /**
     * Método que efetua a autenticação do Tecnico
     * @param password Password do Tecnico
     * @return Booleano que indica se foi efetuada a autenticação com sucesso
     */
    public boolean autenticacao (String password) {
        if(this.password.equals(password)) {
            this.autenticado = true;
            return true;
        }
        return false;
    }

    /**
     * Método que adiciona um Equipamento à lista de equipamentos reparados pelo Tecnico
     * @param e Equipamento que foi reparado
     */
    public void addEquipamentosReparados(Equipamento e){
        this.equipamentos_reparados.add(e);
    }

    /**
     * Método que adiciona um Equipamento à lista de equipamentos expresso reparados pelo Tecnico
     * @param eq Equipamento expresso que foi reparado
     */
    public void addEquipamentosReparadosExpresso(Equipamento eq){
        this.equipamentos_reparados_expresso.add(eq);
    }

    /**
     * Método que calcula o tempo médio de reparação de um Tecnico
     * @return Tempo médio de reparação
     */
    public float tempoMedioReparacao(){
        if (this.equipamentos_reparados.size() == 0)
            return 0;
        return (float) this.tempoGasto / this.equipamentos_reparados.size();
    }

    /**
     * Método que calcula o desvio médio de tempo de reparação de um Tecnico
     * @return Desvio médio de tempo de reparação
     */
    public float desvioTempoMedioReparacao(){
        if (this.equipamentos_reparados.size() == 0)
            return 0;
        return (float) this.desvioTempoGasto / this.equipamentos_reparados.size();
    }

    /**
     * Método toString da classe Tecnico
     * @return String do Tecnico
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("Funcionario {\n");
        sb.append("\tUsername - ").append(username).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Método clone da classe Tecnico
     * @return Tecnico clonado
     */
    public Tecnico clone(){
        return new Tecnico(this);
    }
}
