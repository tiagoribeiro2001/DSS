package DSS.UI;
import DSS.Exceptions.*;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestEquipamentos.GestEquipamentosFacade;
import DSS.GestEquipamentos.IGestEquipamentosFacade;
import DSS.GestFuncionarios.Funcionario;
import DSS.GestFuncionarios.GestFuncionariosFacade;
import DSS.GestFuncionarios.IGestFuncionariosFacade;
import DSS.GestGestores.GestGestoresFacade;
import DSS.GestGestores.Gestor;
import DSS.GestGestores.IGestGestoresFacade;
import DSS.GestOrcamentos.GestOrcamentosFacade;
import DSS.GestOrcamentos.IGestOrcamentosFacade;
import DSS.GestPagamentos.GestPagamentosFacade;
import DSS.GestPagamentos.IGestPagamentosFacade;
import DSS.GestPagamentos.Pagamento;
import DSS.GestPedidosOrcamento.GestPedidosOrcamentoFacade;
import DSS.GestPedidosOrcamento.IGestPedidosOrcamentoFacade;
import DSS.GestPedidosOrcamento.PedidoOrcamento;
import DSS.GestPlanosTrabalho.GestPlanosTrabalhoFacade;
import DSS.GestPlanosTrabalho.IGestPlanosTrabalhoFacade;
import DSS.GestPlanosTrabalho.PlanoTrabalho;
import DSS.GestTecnicos.GestTecnicosFacade;
import DSS.GestTecnicos.IGestTecnicosFacade;
import DSS.GestOrcamentos.Orcamento;
import DSS.GestTecnicos.Tecnico;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.Math.abs;

public class TextUI implements Serializable {
    private IGestFuncionariosFacade funcionarios;
    private IGestGestoresFacade gestores;
    private IGestTecnicosFacade tecnicos;
    private IGestEquipamentosFacade equipamentos;
    private IGestOrcamentosFacade orcamentos;
    private IGestPedidosOrcamentoFacade pedidosOrcamento;
    private IGestPagamentosFacade pagamentos;
    private IGestPlanosTrabalhoFacade planosTrabalho;
    private static Scanner scanner = new Scanner(System.in);
    private String username;

    private Gestor gest = new Gestor("ges", "admin123");

    public TextUI() {
        this.funcionarios = new GestFuncionariosFacade();
        this.gestores = new GestGestoresFacade();
        this.tecnicos = new GestTecnicosFacade();
        this.equipamentos = new GestEquipamentosFacade();
        this.orcamentos = new GestOrcamentosFacade();
        this.pedidosOrcamento = new GestPedidosOrcamentoFacade();
        this.pagamentos = new GestPagamentosFacade();
        this.planosTrabalho = new GestPlanosTrabalhoFacade();
        this.username = "";
    }

    public void run() {
        System.out.println("Bem vindo ao Sistema de Reparações de dispositivos!");
        this.menuPrincipal();
        System.out.println("Até à próxima!");
    }

    private void menuPrincipal() {
        Menu menu = new Menu(new String[]{
                "Registar novo utilizador",
                "Autenticar Funcionario de balcão",
                "Autenticar Gestor",
                "Autenticar Técnico"
        });

        menu.setHandler(1, this::registarUser);
        menu.setHandler(2, this::autenticarFuncionario);
        menu.setHandler(3, this::autenticarGestor);
        menu.setHandler(4, this::autenticarTecnico);

        //Gestor inicial do sistema
        this.gestores.registaGestor(this.gest);

        menu.run();
    }

    private void menuFuncionario() {
        Menu menu = new Menu(new String[]{
                "Registar recebimento de dispositivo",
                "Registar entrega de dispositivo",
                "Registar pagamento de reparação"
        });
        menu.setHandler(1, this::registarRecDispositivo);
        menu.setHandler(2, this::registarEntregaDispositivo);
        menu.setHandler(3, this::registarPagamentoReparacao);

        menu.run();
    }

    private void menuTecnico() {
        Menu menu = new Menu(new String[]{
                "Registar orçamento no sistema",
                "Registar reparação no sistema",
                "Registar reparação urgente"
        });
        menu.setHandler(1, this::registarOrcamento);
        menu.setHandler(2, this::registarReparacao);
        menu.setHandler(3, this::registarReparacaoUrgente);

        menu.run();
    }

    private void menuGestor() {
        Menu menu = new Menu(new String[]{
                "Aceder a lista de reparações por técnico.",
                "Aceder a lista de receções e entregas por funcionário.",
                "Aceder a lista de todas as intervenções realizadas por técnico.",
                "Promover Funcionário."
        });
        menu.setHandler(1, this::acederListaReparacoes);
        menu.setHandler(2, this::acederListaRececoesEntregas);
        menu.setHandler(3, this::acederListaIntervencoes);
        menu.setHandler(4, this::promoverFuncionario);

        menu.run();
    }

    //---------------- MÉTODOS AUXILIARES -----------------//

    /*Registo de utilizador (inicialmente é automaticamente registado como Funcionário de balcão. O gestor depois trata
    de conceder as autorizações de gestor / técnico).
    */
    private void registarUser() {
        try {
            System.out.println("Por favor insira um nome de utilizador: ");
            String username = scanner.nextLine();
            System.out.println("Por favor insira uma password:");
            String password = scanner.nextLine();
            Funcionario novo = new Funcionario(username, password);
            funcionarios.registaFuncionario(novo);
            System.out.println("\033[0;32m" + "Funcionário registado com sucesso." + "\033[0m");
        }
        catch(UsernameJaExisteException e) {
            System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
        }
    }

    //Autenticar funcionário.
    private void autenticarFuncionario() {
        try {
            System.out.println("Por favor indique o seu username: ");
            String username = scanner.nextLine();
            System.out.println("Por favor insira a sua password: ");
            String password = scanner.nextLine();
            this.funcionarios.autenticaFuncionario(username, password);
            System.out.println("Funcionário autenticado com sucesso.");
            this.username = username;
            this.menuFuncionario();
        }
        catch (InputMismatchException | CredenciaisInvalidasException e) {
            System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
        }
    }

    //Autenticar Gestor.
    private void autenticarGestor (){
        try {
            System.out.println("Por favor indique o seu username: ");
            String username = scanner.nextLine();
            System.out.println("Por favor insira a sua password: ");
            String password = scanner.nextLine();
            this.gestores.autenticaGestor(username, password);
            System.out.println("Gestor autenticado com sucesso.");
            this.username = username;
            this.menuGestor();
        }
        catch (InputMismatchException | CredenciaisInvalidasException e) {
            System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
        }
    }

    //Autenticar Técnico.
     private void autenticarTecnico() {
        try {
            System.out.println("Por favor indique o seu username: ");
            String username = scanner.nextLine();
            System.out.println("Por favor insira a sua password: ");
            String password = scanner.nextLine();
            this.tecnicos.autenticaTecnico(username, password);
            System.out.println("Técnico autenticado com sucesso.");
            this.username = username;
            this.menuTecnico();
        }
        catch (InputMismatchException | CredenciaisInvalidasException e) {
            System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
        }
    }

    // ----------------- Auxiliares menu funcionario -----------------------//
    //Regista o recebimento do dspositivo
    private void registarRecDispositivo (){
        Equipamento eq;
        //Verifica que o funcionário está autenticado.
        if (this.funcionarios.isAutenticado(this.username)) {
            try {
                System.out.println("Insira o nif do cliente:");
                int nif = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Insira o email do cliente:");
                String email = scanner.nextLine();
                System.out.println("Pretende que seja realizado o Serviço Expresso?\n1- Sim\n2- Não");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                if (opcao == 1) {
                    if (this.equipamentos.isNaoReparadosEmpty()) {
                        eq = new Equipamento(nif, this.funcionarios.getFuncionarios().get(username).clone(), email, true);
                        this.equipamentos.registaEquipamentoExpresso(eq);
                        this.funcionarios.incrementaRecepcoes(this.username);
                        System.out.println("\033[0;32mPedido Expresso realizado com sucesso. \033[0m");
                    } else
                        System.out.println("\033[0;31mErro: Não há disponibilidade para realizar o serviço expresso. \033[0m");
                } else if (opcao == 2) {
                    eq = new Equipamento(nif, this.funcionarios.getFuncionarios().get(username).clone(), email, false);
                    this.equipamentos.registaEquipamento(eq);
                    this.funcionarios.incrementaRecepcoes(this.username);
                    this.registarPedidoOrcamento(nif);
                }
                else {
                    System.out.println("\033[0;31mErro: Opção inválida. \033[0m");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\033[0;31m" + "Erro: Input inserido é inválido." + "\033[0m");
                scanner.nextLine();
            }
        }
        else {
            System.out.println("\033[0;31mErro: O funcionário deverá estar autenticado para poder inserir um dispositivo. \033[0m");
        }
    }

    //Regista um pedido de orçamento.
    private void registarPedidoOrcamento (int nif) {
        Orcamento oc;
        //Verifica que o funcionário está autenticado.
        if (this.funcionarios.isAutenticado(this.username)) {
            //Verifica se existe algum equipamento pertencente a esse cliente registado no sistema.
            try{
                System.out.println("Insira o problema descrito pelo cliente:");
                String problema = scanner.nextLine();
                Equipamento eq = equipamentos.obtemEquipamento(nif);
                PedidoOrcamento po = new PedidoOrcamento(eq.clone(), problema);
                this.pedidosOrcamento.addPedidoOrcamento(po.clone());
                System.out.println("Pedido de orçamento foi registado.");
            }
            catch(EquipamentoInexistenteException e) {
                System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
            }
        }
        else
            System.out.println("\033[0;31mErro: O funcionário deverá estar autenticado.\033[0m");
    }

    //Regista entrega do dispositivo.
    private void registarEntregaDispositivo() {
        //Verifica que o funcionario esta autenticado.
        if(this.funcionarios.isAutenticado(this.username)) {
            System.out.println("Por favor insira o nif do cliente:");
            int nif = scanner.nextInt();scanner.nextLine();
            //verifica que o equipamento esta registado no sistema.
            try {
                //Remove o equipamento do sistema (Já que foi entregue).
                this.equipamentos.removeEquipamento(nif);
                System.out.println("Registo de entrega do equipamento efetuado com sucesso.");
                this.funcionarios.incrementaEntregas(this.username);
            }
            catch(EquipamentoInexistenteException e) {
                System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
            }
        }
        else
            System.out.println("\033[0;31mErro: O funcionário deverá estar registado. \033[0m");
    }

    private void registarPagamentoReparacao () {
        //Verifica que o funcionario esta autenticado.
        if (this.funcionarios.isAutenticado(this.username)) {
            System.out.println("Por favor insira o nif do cliente: ");
            int nif = scanner.nextInt();scanner.nextLine();
            //Verifica que o equipamento esta registado no sistema.
            try {
                //Verifica que existe um orçamento para o dispositivo registado no sistema.
                if (this.equipamentos.estaReparado(nif)) {
                    //Obtem o valor a pagar
                    double valorApagar = this.equipamentos.getCustoReparacaoTotal(nif);
                    System.out.println("O valor a pagar é " + valorApagar + ".");
                    //Pede confirmação de pagamento
                    System.out.println("O pagamento foi efetuado?\n1- Sim\n2- Não");
                    int opcao = scanner.nextInt();scanner.nextLine();
                    //Caso de ter sido efetuado pagamento, este fica registado.
                    if (opcao == 1) {
                        Pagamento pagamento = new Pagamento(nif, valorApagar, this.equipamentos.obtemEquipamento(nif).clone());
                        this.pagamentos.addPagamento(pagamento);
                    }
                }
                else {
                    System.out.println("Este dispositivo nao foi reparado.");
                }
            }
            catch (EquipamentoInexistenteException e) {
                System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
            }
        }
        else
            System.out.println("Erro: O funcionário deverá estar registado.");
    }

    //------------------ Auxiliares menu tecnico -----------------------//

    private PlanoTrabalho menuOrcamento(Equipamento e) {
        PlanoTrabalho pt = new PlanoTrabalho(e.clone());
        String res = "";
        while (!res.equals("sair")) {
            System.out.println("Insira um passo (Se pretender sair escreva \"sair\"):");
            res = scanner.nextLine();
            if (!res.equals("sair")) {
                try {
                    System.out.println("Insira um custo associado a dito passo:");
                    double custo = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Insira uma duração (em minutos) associado a dito passo:");
                    int tempo = scanner.nextInt();
                    scanner.nextLine();
                    pt.adicionaPasso(res, custo, tempo);
                }
                catch (InputMismatchException exc) {
                    System.out.println("\033[0;31m" + "Erro: Input inválido." + "\033[0m");
                    scanner.nextLine();
                }
            }
        }
        return pt;
    }

    private void registarOrcamento () {
        if (this.tecnicos.isAutenticado(this.username)) {
            try {
                PedidoOrcamento po = this.pedidosOrcamento.obtemPedido();

                System.out.println("Problema do Dispositivo:");
                System.out.println(po.getProblema());
                System.out.println("--------------------------------");
                PlanoTrabalho pt = menuOrcamento(po.getEquipamento().clone());
                pt.registaOrcamento(po.getProblema());
                this.orcamentos.addOrcamento(pt.getOrcamento());
                this.equipamentos.insereCustoReparacao(po.getEquipamento().getNifCliente(), pt.getOrcamento().getValor());
                this.planosTrabalho.adicionaPlano(pt);
                System.out.println("Orçamento registado com sucesso.");
                this.pedidosOrcamento.removePedidoOrcamento();
                //Talvez implementar para enviar email para o cliente.
            }
            catch (PedidoOrcamentoInexistenteException e) {
                System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
            }
        }
        else {
            System.out.println("Erro: O Técnico deverá estar registado.");
        }
    }

    private void registarReparacao () throws EquipamentoInexistenteException {
        if (this.tecnicos.isAutenticado(this.username)) {
            if (!this.equipamentos.isNaoReparadosEmpty()) {
                double custoReal = 0.0;
                Orcamento o = this.orcamentos.obtemOrcamentoMaisAntigo();
                int nif = o.getNif();
                System.out.println("\n-------------------//-----------------------");
                System.out.println("REPARAÇÃO DE DISPOSITIVO\n");
                System.out.println("Identificador do dispositivo: " + nif);
                System.out.println("Plano de trabalhos:");
                PlanoTrabalho pt = this.planosTrabalho.obterPlano(nif);
                PlanoTrabalho planoReal = new PlanoTrabalho(equipamentos.obtemEquipamento(nif));
                try {
                    for (int i = 0; i < pt.tamanhoPlano(); i++) {
                        System.out.println("\n--------------------//----------------------");
                        System.out.println(pt.getPlano().get(i).toString());
                        System.out.println("Indique o tempo gasto para a tarefa (em minutos): ");
                        int gasto = scanner.nextInt();
                        scanner.nextLine();
                        int gastoPlano = pt.getTempo(i);
                        this.tecnicos.incrementaDesvioTempoGasto(this.username, abs(gasto - gastoPlano));
                        this.tecnicos.incrementaTempoGasto(this.username, gasto);
                        System.out.println("Insira o custo atribuido à realização deste passo: ");
                        double temp = scanner.nextDouble();
                        scanner.nextLine();
                        custoReal += temp;
                        planoReal.adicionaPasso(pt.getPlano().get(i).getPasso(), temp, gasto);
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("\033÷0;31m" + "Erro: Input inválido." + "\033[0m");
                }
                System.out.println("\n--------------------//----------------------");
                if (custoReal > o.getValor()*1.20)
                    System.out.println("Custo de reparação real foi superior ao orçamento.");
                try {
                    System.out.println("Pretende que seja realizada a reparação?\n1- Sim\n2- Não");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();

                    if (opcao == 1) {
                        this.equipamentos.consertaEquipamento(o.getEquipamento().getNifCliente());
                        this.tecnicos.adicionaEquipamentosReparados(this.username, o.getEquipamento().clone());
                        this.orcamentos.removeOrcamentoMaisAntigo();
                        this.planosTrabalho.adicionaPlanoRealizado(planoReal);
                        System.out.println("Reparação realizada com sucesso!");
                    } else
                        System.out.println("A reparação não foi concluída.");
                }
                catch (InputMismatchException e) {
                    System.out.println("\033[0;31m" + "Erro: Input inválido." + "\033[0m");
                }
            }
            else if (!this.equipamentos.isExpressoEmpty()) {
                Equipamento e = this.equipamentos.getExpressoMaisAntigo();
                System.out.println("[Serviço Expresso]: Insira o preço pelo serviço realizado: ");
                double preco = scanner.nextDouble(); scanner.nextLine();
                this.equipamentos.insereCustoReparacao(e.getNifCliente(), preco);
                this.tecnicos.adicionaEquipamentosReparadosExpresso(this.username, equipamentos.obtemEquipamento(e.getNifCliente()).clone());
                this.equipamentos.consertaEquipamento(e.getNifCliente());
                System.out.println("\033[0;32mServiço de reparação expresso registado com sucesso.\033[0m");
            }
            else {
                System.out.println("\033[0;31mErro: Não há equipamentos para reparar.\033[0m");
            }
        }
        else {
            System.out.println("\033[0;31mErro: O Técnico deverá estar registado.\033[0m");
        }
    }

    private void registarReparacaoUrgente () throws EquipamentoInexistenteException {
        double custoReal = 0.0;
        if (!this.equipamentos.isNaoReparadosEmpty()) {
            System.out.println(this.orcamentos.toString());
            System.out.println("Insira o ID da reparação que pretende efetuar: ");
            int nif = scanner.nextInt();
            scanner.nextLine();
            Orcamento o = this.orcamentos.getOrcamento(nif);
            System.out.println("\n-------------------//-----------------------");
            System.out.println("REPARAÇÃO DE DISPOSITIVO\n");
            System.out.println("Identificador do dispositivo: " + nif);
            System.out.println("Plano de trabalhos:");
            PlanoTrabalho pt = this.planosTrabalho.obterPlano(nif);
            PlanoTrabalho planoReal = new PlanoTrabalho(equipamentos.obtemEquipamento(nif));
            try {
                for (int i = 0; i < pt.tamanhoPlano(); i++) {
                    System.out.println("\n--------------------//----------------------");
                    System.out.println(pt.getPlano().get(i).toString());
                    System.out.println("Indique o tempo gasto para a tarefa (em minutos): ");
                    int gasto = scanner.nextInt();
                    scanner.nextLine();
                    int gastoPlano = pt.getTempo(i);
                    this.tecnicos.incrementaDesvioTempoGasto(this.username, abs(gasto - gastoPlano));
                    this.tecnicos.incrementaTempoGasto(this.username, gasto);
                    System.out.println("Insira o custo atribuido à realização deste passo: ");
                    double temp = scanner.nextDouble();
                    scanner.nextLine();
                    custoReal += temp;
                    planoReal.adicionaPasso(pt.getPlano().get(i).getPasso(), temp, gasto);
                }
            }
            catch (InputMismatchException e) {
                System.out.println("\033÷0;31m" + "Erro: Input inválido." + "\033[0m");
            }
            System.out.println("\n--------------------//----------------------");
            if (custoReal > o.getValor()*1.20)
                System.out.println("Custo de reparação real foi superior ao orçamento.");
            try {
                System.out.println("Pretende que seja realizada a reparação?\n1- Sim\n2- Não");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    this.equipamentos.consertaEquipamento(o.getEquipamento().getNifCliente());
                    this.tecnicos.adicionaEquipamentosReparados(this.username, o.getEquipamento().clone());
                    this.orcamentos.removeOrcamentoMaisAntigo();
                    this.planosTrabalho.adicionaPlanoRealizado(planoReal);
                    System.out.println("Reparação realizada com sucesso!");
                } else
                    System.out.println("A reparação não foi concluída.");
            }
            catch (InputMismatchException e) {
                System.out.println("\033[0;31m" + "Erro: Input inválido." + "\033[0m");
            }
        }
    }
    // ------------------- Auxiliares menu gestor --------------------//
    private void acederListaReparacoes () {
        if (this.gestores.isAutenticado(this.username)) {
            System.out.println("Lista de Técnicos: ");
            System.out.println(this.tecnicos.imprimeReparacoesInfo());
        }
        else {
            System.out.println("Erro: O gestor deverá estar autenticado.");
        }
    }

    private void acederListaRececoesEntregas () {
        if (this.gestores.isAutenticado(this.username)) {
            System.out.println("Lista de Funcionários: ");
            System.out.println(this.funcionarios.imprimeRecepcoesEntregas());
        }
        else {
            System.out.println("Erro: O gestor deverá estar autenticado.");
        }
    }

    private void acederListaIntervencoes () {
        if (this.gestores.isAutenticado(this.username)) {
            System.out.println("Insira o username do técnico de que quer ver as intervenções:");
            String usernameTecnico = scanner.nextLine();
            try {
                imprimeIntervencoes(usernameTecnico);
            }
            catch (UsernameNaoExisteException e) {
                System.out.println("\033÷0;31m" + e.getMessage() + "\033[0m");
            }
        }
        else
            System.out.println("Erro: O gestor deverá estar autenticado.");
    }

    public void imprimeIntervencoes(String username) throws UsernameNaoExisteException{
        StringBuilder sb = new StringBuilder();
        Tecnico tec = tecnicos.getTecnico(username);
        System.out.println("Reparações Normais:");
        for(Equipamento e : tec.getEquipamentosReparados()) {
            int nif = e.getNifCliente();
            System.out.println("[NIF: " + nif + "] Plano de trabalho da reparação:");
            PlanoTrabalho plano = planosTrabalho.obterPlanoRealizado(nif);
            for (int i = 0; i < plano.tamanhoPlano(); i++) {
                System.out.println("--------------------//----------------------");
                System.out.println(plano.getPlano().get(i).toString());
            }
        }
        System.out.println("Reparações Expresso:");
        for(Equipamento e : tec.getEquipamentosReparadosExpresso()) {
            int nif = e.getNifCliente();
            double custo = e.getCustoReparacao();
            System.out.println("[NIF: " + nif + "] Custo da reparação expresso: " + custo);
            System.out.println("--------------------//----------------------");
        }
    }

    public void promoverFuncionario() {
        if (this.gestores.isAutenticado(this.username)) {
            System.out.println("Insira o username do Funcionário que pretende promover:");
            String username = scanner.nextLine();
            try {
                this.funcionarios.existeFuncionario(username);
                try {
                    System.out.println("Para que posição pretende promover o funcionáio?\n1- Técnico\n2- Gestor");
                    int opcao = scanner.nextInt();
                    scanner.nextLine();
                    if (opcao == 1) {
                        while (!this.tecnicos.registaTecnico(this.funcionarios.obtemFuncionario(username))) {
                            System.out.println("Já existe um técnico com esse username, por favor insira um novo:");
                            username = scanner.nextLine();
                        }
                        this.funcionarios.removeFuncionario(username);
                        System.out.println("Funcionário promovido a técnico com sucesso!");
                    } else if (opcao == 2) {
                        while (!this.gestores.registaGestor(this.funcionarios.obtemFuncionario(username))) {
                            System.out.println("Já existe um gestor com esse username, por favor insira um novo:");
                            username = scanner.nextLine();
                        }
                        this.funcionarios.removeFuncionario(username);
                        System.out.println("Funcionário promovido a Gestor com sucesso!");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("\033[0;31m" + "Erro: Input inválido." + "\033[0m");
                }
            }
            catch (UsernameNaoExisteException e) {
                System.out.println("\033[0;31m" + e.getMessage() + "\033[0m");
            }
        }
        else
            System.out.println("Erro: Gestor deverá estar autenticado.");
    }

}
