package DSS.UI;
import DSS.GestEquipamentos.Equipamento;
import DSS.GestFuncionarios.Funcionario;
import DSS.GestFuncionarios.GestFuncionariosFacade;
import DSS.GestFuncionarios.IGestFuncioariosFacade;
import DSS.GestGestores.GestGestoresFacade;
import DSS.GestGestores.IGestGestoresFacade;
import DSS.GestTecnicos.GestTecnicosFacade;
import DSS.GestTecnicos.IGestTecnicosFacade;

import java.util.Scanner;

public class TextUI {
    private IGestFuncioariosFacade funcionarios;
    private IGestGestoresFacade gestores;
    private IGestTecnicosFacade tecnicos;
    private Scanner scanner;

    public TextUI() {
        this.funcionarios = new GestFuncionariosFacade();
        this.gestores = new GestGestoresFacade();
        this.tecnicos = new GestTecnicosFacade();
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Bem vindo ao Sistema de Reparações de dispositivos!");
        this.menuPrincipal();
        System.out.println("Obrigado pela sua preferência!");
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
    public void registarUser() {
        System.out.println("Por favor insira um nome de utilizador: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insita uma password:");
        String password = scanner.nextLine();
        Funcionario novo = new Funcionario(username, password);
        funcionarios.registaFuncionario(novo);
    }

    //Autenticar funcionário.
    public void autenticarFuncionario() {
        System.out.println("Por favor indique o seu username: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insira a sua password: ");
        String password = scanner.nextLine();
        if (this.funcionarios.autenticaFuncionario(username, password)) {
            System.out.println("Funcionário autenticado com sucesso.");
        } else
            System.out.println("Credenciais inseridas são inválidas.");
    }

    //Autenticar Gestor.
    public void autenticarGestor () {
        System.out.println("Por favor indique o seu username: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insira a sua password: ");
        String password = scanner.nextLine();
        if (this.gestores.autenticaGestor(username, password))
            System.out.println("Gestor autenticado com sucesso.");
        else
            System.out.println("Credenciais inseridas são inválidas.");
    }

    //Autenticar Técnico.
     public void autenticarTecnico() {
        System.out.println("Por favor indique o seu username: ");
        String username = scanner.nextLine();
        System.out.println("Por favor insira a sua password: ");
        String password = scanner.nextLine();
        if (this.tecnicos.autenticaTecnico(username, password))
            System.out.println("Técnico autenticado com sucesso.");
        else
            System.out.println("As credenciais inseridas são inválidas.");
    }

    public void registarRecDispositivo (){
        Equipamento eq;
        System.out.println("Insira o username do funcionário: ");
        String username = scanner.nextLine();
        if (this.funcionarios.isAutenticado(username)) {
            System.out.println("Insira o nif do cliente:");
            int nif = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Pretende que seja realizado o Serviço Expresso?\n1- Sim\n2- Não");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if (opcao == 1) {
                eq = new Equipamento(nif, this.funcionarios.getFuncionarios().get(username).clone(), true);
            }
            else
                eq = new Equipamento(nif, this.funcionarios.getFuncionarios().get(username).clone(), false);
        }
    }



}
