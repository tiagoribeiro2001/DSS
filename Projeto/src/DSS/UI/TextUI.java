package DSS.UI;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestEquipamentos.GestEquipamentosFacade;
import DSS.GestEquipamentos.IGestEquipamentosFacade;
import DSS.GestFuncionarios.Funcionario;
import DSS.GestFuncionarios.GestFuncionariosFacade;
import DSS.GestFuncionarios.IGestFuncioariosFacade;
import DSS.GestGestores.GestGestoresFacade;
import DSS.GestGestores.IGestGestoresFacade;
import DSS.GestOrcamentos.GestOrcamentosFacade;
import DSS.GestOrcamentos.IGestOrcamentosFacade;
import DSS.GestPagamentos.GestPagamentosFacade;
import DSS.GestPagamentos.IGestPagamentosFacade;
import DSS.GestPagamentos.Pagamento;
import DSS.GestPedidosOrcamento.GestPedidosOrcamentoFacade;
import DSS.GestPedidosOrcamento.IGestPedidosOrcamentoFacade;
import DSS.GestPedidosOrcamento.PedidoOrcamento;
import DSS.GestTecnicos.GestTecnicosFacade;
import DSS.GestTecnicos.IGestTecnicosFacade;
import DSS.GestOrcamentos.Orcamento;
import DSS.GestTecnicos.Tecnico;

import java.util.Scanner;

public class TextUI {
    private IGestFuncioariosFacade funcionarios;
    private IGestGestoresFacade gestores;
    private IGestTecnicosFacade tecnicos;
    private IGestEquipamentosFacade equipamentos;
    private IGestOrcamentosFacade orcamentos;
    private IGestPedidosOrcamentoFacade pedidosOrcamento;
    private IGestPagamentosFacade pagamentos;
    private Scanner scanner;
    private String username;

    public TextUI() {
        this.funcionarios = new GestFuncionariosFacade();
        this.gestores = new GestGestoresFacade();
        this.tecnicos = new GestTecnicosFacade();
        this.equipamentos = new GestEquipamentosFacade();
        this.orcamentos = new GestOrcamentosFacade();
        this.pedidosOrcamento = new GestPedidosOrcamentoFacade();
        this.pagamentos = new GestPagamentosFacade();
        this.username = "";
        scanner = new Scanner(System.in);
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

        menu.run();
    }

    private void menuFuncionario() {
        Menu menu = new Menu(new String[]{
                "Registar recebimento de dispositivo",
                "Regista pedido de orçamento",
                "Regista entrega de dispositivo",
                "Registar pagamento de reparação"
        });
        menu.setHandler(1, this::registarRecDispositivo);
        menu.setHandler(2, this::registarPedidoOrcamento);
        menu.setHandler(3, this::registarEntregaDispositivo);
        menu.setHandler(4, this::registarPagamentoReparacao);

        menu.run();
    }

    private void menuTecnico() {
        Menu menu = new Menu(new String[]{
                "Registar orçamento no sistema",
                "Registar reparação no sistema",
                "Registar plano de trabalhos",
                "Registar reparação urgente"
        });
        menu.setHandler(1, this::registarOrcamento);
        menu.setHandler(2, this::registarReparacao);
        menu.setHandler(3, this::registarPlanoTrabalhos);
        menu.setHandler(4, this::registarReparacaoUrgente);

        menu.run();
    }

    private void menuGestor() {
        Menu menu = new Menu(new String[]{
                "Aceder a lista de reparações por técnico.",
                "Aceder a lista de receções e entregas por funcionário.",
                "Aceder a lista de todas as intervenções realizadas por técnico."
        });
        menu.setHandler(1, this::acederListaReparacoes);
        menu.setHandler(2, this::acederListaRececoesEntregas);
        menu.setHandler(3, this::acederListaIntervencoes);

        menu.run();
    }

    //---------------- MÉTODOS AUXILIARES -----------------//

    /*Registo de utilizador (inicialmente é automaticamente registado como Funcionário de balcão. O gestor depois trata
    de conceder as autorizações de gestor / técnico).
    */
    private void registarUser() {
        System.out.println("Por favor insira um nome de utilizador: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insita uma password:");
        String password = scanner.nextLine();
        Funcionario novo = new Funcionario(username, password);
        funcionarios.registaFuncionario(novo);
    }

    //Autenticar funcionário.
    private void autenticarFuncionario() {
        System.out.println("Por favor indique o seu username: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insira a sua password: ");
        String password = scanner.nextLine();
        if (this.funcionarios.autenticaFuncionario(username, password)) {
            System.out.println("Funcionário autenticado com sucesso.");
            this.username = username;
            this.menuFuncionario();
        } else
            System.out.println("Credenciais inseridas são inválidas.");
    }

    //Autenticar Gestor.
    private void autenticarGestor () {
        System.out.println("Por favor indique o seu username: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insira a sua password: ");
        String password = scanner.nextLine();
        if (this.gestores.autenticaGestor(username, password)) {
            System.out.println("Gestor autenticado com sucesso.");
            this.username = username;
            this.menuGestor();
        }
        else
            System.out.println("Credenciais inseridas são inválidas.");
    }

    //Autenticar Técnico.
     private void autenticarTecnico() {
        System.out.println("Por favor indique o seu username: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insira a sua password: ");
        String password = scanner.nextLine();
        if (this.tecnicos.autenticaTecnico(username, password)) {
            System.out.println("Técnico autenticado com sucesso.");
            this.username = username;
            this.menuTecnico();
        }
        else
            System.out.println("As credenciais inseridas são inválidas.");
    }

    // ----------------- Auxiliares menu funcionario -----------------------//
    //Regista o recebimento do dspositivo
    private void registarRecDispositivo (){
        Equipamento eq;
        //Verifica que o funcionário está autenticado.
        if (this.funcionarios.isAutenticado(this.username)) {
            System.out.println("Insira o nif do cliente:");
            int nif = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Insira o email do cliente:");
            String email = scanner.nextLine();
            System.out.println("Pretende que seja realizado o Serviço Expresso?\n1- Sim\n2- Não");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                eq = new Equipamento(nif, this.funcionarios.getFuncionarios().get(username).clone(), email, true);
            }
            else
                eq = new Equipamento(nif, this.funcionarios.getFuncionarios().get(username).clone(), email, false);
            this.equipamentos.insereEquipamento(eq);
        }
        else {
            System.out.println("Erro: O funcionário deverá estar registado para poder inserir um dispositivo.");
        }
    }

    //Regista um pedido de orçamento.
    private void registarPedidoOrcamento () {
        Orcamento oc;
        //Verifica que o funcionário está autenticado.
        if (this.funcionarios.isAutenticado(this.username)) {
            System.out.println("Insira o nif do proprietário do orçamento.");
            int nif = scanner.nextInt();
            scanner.nextLine();
            //Verifica se existe algum equipamento pertencente a esse cliente registado no sistema.
            if (this.equipamentos.existeEquipamento(nif)) {
                System.out.println("Insira o problema descrito pelo cliente:");
                String problema = scanner.nextLine();
                Equipamento eq = equipamentos.obtemEquipamento(nif);
                PedidoOrcamento po = new PedidoOrcamento(eq.clone(), problema);
                this.pedidosOrcamento.addPedidoOrcamento(po.clone());
                System.out.println("Pedido de orçamento foi registado.");
            }
            else {
                System.out.println("Erro: O equipamento deverá ser registado antes do seu respetivo pedido de orçamento.");
            }
        }
        System.out.println("Erro: O funcionário deverá estar autenticado.");
    }

    //Regista entrega do dispositivo.
    private void registarEntregaDispositivo() {
        //Verifica que o funcionario esta autenticado.
        if(this.funcionarios.isAutenticado(this.username)) {
            System.out.println("Por favor insira o nif do cliente:");
            int nif = scanner.nextInt();scanner.nextLine();
            //verifica que o equipamento esta registado no sistema.
            if (this.equipamentos.existeEquipamento(nif)){
                //Remove o equipamento do sistema (Já que foi entregue).
                this.equipamentos.removeEquipamento(nif);
                System.out.println("Registo de entrega do equipamento efetuado com sucesso.");
            }
            else
                System.out.println("Erro: Não existe nenhum registo desse equipamento.");
        }
        else
            System.out.println("Erro: O funcionário deverá estar registado.");
    }

    private void registarPagamentoReparacao () {
        //Verifica que o funcionario esta autenticado.
        if (this.funcionarios.isAutenticado(this.username)) {
            System.out.println("Por favor insira o nif do cliente: ");
            int nif = scanner.nextInt();scanner.nextLine();
            //Verifica que o equipamento esta registado no sistema.
            if (this.equipamentos.existeEquipamento(nif)) {
                //Verifica que existe um orçamento para o dispositivo registado no sistema.
                if (this.orcamentos.existeOrcamento(nif)) {
                    //Obtem o valor a pagar
                    int valorApagar = this.orcamentos.obtemOrcamento(nif);
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
                    System.out.println("Não existe nenhum orçamento para este dispositivo.");
                }
            }
            else
                System.out.println("Este equipamento não está registado no sistema.");
        }
        else
            System.out.println("Erro: O funcionário deverá estar registado.");
    }

    //------------------ Auxiliares menu tecnico -----------------------//

    private void registarOrcamento () {
        if (this.tecnicos.isAutenticado(this.username)) {
            PedidoOrcamento po = this.pedidosOrcamento.obtemPedido();
            System.out.println(po.getProblema());
            System.out.println("Com base no problema descrito, qual será o orçamento atribuido?");
            int valor = scanner.nextInt();scanner.nextLine();
            Orcamento orc = new Orcamento(po.getEquipamento(), valor);
            this.orcamentos.addOrcamento(orc);
            System.out.println("Orçamento registado com sucesso.");
            //Talvez implementar para enviar email para o cliente.
        }
        else {
            System.out.println("Erro: O Técnico deverá estar registado.");
        }
    }

    private void registarReparacao () {
        if (this.tecnicos.isAutenticado(this.username)) {
            Orcamento o = this.orcamentos.obtemOrcamentoMaisAntigo();
            int nif = o.getNif();
            System.out.println("Próxima reparação: " + nif);
            System.out.println("A reparação foi efetuada?\n1- Sim\n2- Não");
            int opcao = scanner.nextInt();scanner.nextLine();
            /*Caso de ter sido efetuada a reparação, esta é removida da lista de
             orcamentos e o equipamento é adicionado à lista de equipamentos reparados pelo técnico.
             */
            if (opcao == 1) {
                Equipamento equip = o.getEquipamento();
                Tecnico tec = this.tecnicos.getTecnico(this.username);
                tec.addEquipamentosReparados(equip);
                this.orcamentos.removeOrcamentoMaisAntigo();
                //Talvez implementar para enviar email para o cliente.
            }
        }
        else {
            System.out.println("Erro: O Técnico deverá estar registado.");
        }
    }
    // ------------------- Auxiliares menu gestor --------------------//
    public void acederListaReparacoes () {
        if (this.gestores.isAutenticado(this.username)) {
            System.out.println("Lista de Técnicos: ");
            System.out.println(this.tecnicos.toString());
            System.out.println("Por favor insira o username do técnico que pretende avaliar: ");
            String usernameT = scanner.nextLine();
            if (this.tecnicos.existe(usernameT)) {
                System.out.println(this.tecnicos.getEquipamentosReparados(usernameT).toString());
            }
            else {
                System.out.println("Não existe nenhum técnico com esse username.");
            }
        }
        else {
            System.out.println("Erro: O gestor deverá estar autenticado.");
        }
    }


}
