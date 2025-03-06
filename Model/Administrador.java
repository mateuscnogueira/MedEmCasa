package Model;

import java.util.Scanner;
import Control.GerenciadorDeListas;

public class Administrador extends Usuario {
    private static int contadorIdAdministrador = 1;
    private int idAdministrador;
    private String funcao = new String();

    private Scanner leitor = new Scanner(System.in);
    private Administrador proximo;

    public Administrador(String nome, String cpf, String telefone, String endereco, String email, String senha, String funcao) {
        super(nome, cpf, telefone, endereco, email, senha);
        this.idAdministrador = contadorIdAdministrador++;
        this.funcao = funcao;
        this.proximo = null;
    }

    public int getIdAdministrador() {
        return idAdministrador;
    }

    public String getFuncao() {
        return funcao;
    }
    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Administrador obterProximo() {
        return proximo;
    }
    public void definirProximo(Administrador proximo) {
        this.proximo = proximo;
    }

    @Override
    public void realizarLogin() {
        boolean acessoLiberado = false;

        while(acessoLiberado != true) {
            System.out.println("\nLogin - Administrador\n");
            System.out.print("\nUsuário: ");
            String emailDigitado = leitor.nextLine();
            System.out.print("\nSenha: ");
            String senhaDigitada = leitor.nextLine();

            Administrador admAtual = GerenciadorDeListas.listaAdministradores.getInicial();

            while(admAtual != null & acessoLiberado != true) {
                if(admAtual.getEmail().equals(emailDigitado) && admAtual.getSenha().equals(senhaDigitada)) {
                    System.out.println("\nLogin bem-sucedido! Acessando menu...\n");
                    acessoLiberado = true;
                } else {
                    admAtual = admAtual.obterProximo();
                }
            }
            if(acessoLiberado == false) {
                System.out.println("\nUsuário ou senha incorretos! Tente novamente.\n");     
            } else {
                visualizarMenu();
            }
        }
    }

    @Override
    public void visualizarMenu() {
        int opcao;
        do {
            System.out.println("\nMenu do Administrador");
            System.out.println("1 - Gerenciar Administradores");
            System.out.println("2 - Gerenciar Médicos");
            System.out.println("3 - Gerenciar Pacientes");
            System.out.println("4 - Gerenciar Planos");
            System.out.println("5 - Gerenciar Pagamentos");
            System.out.println("0 - Sair");

            System.out.print("Digite a opção desejada: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    GerenciadorDeListas.listaAdministradores.gerenciarUsuario();
                    break;
                case 2:
                    GerenciadorDeListas.listaMedicos.gerenciarUsuario();
                    break;
                case 3:
                    GerenciadorDeListas.listaPacientes.gerenciarUsuario();
                    break;
                case 4:
                    GerenciadorDeListas.listaPlanos.gerenciarPlano();
                    break;
                case 5:
                    GerenciadorDeListas.listaPagamentos.gerenciarPagamento();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}

