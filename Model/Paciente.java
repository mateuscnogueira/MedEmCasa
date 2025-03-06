package Model;

import java.util.Scanner;
import Control.GerenciadorDeListas;

public class Paciente extends Usuario {
    private static int contadorIdPaciente = 1;
    private int idPaciente;
    private String dataDeNascimento = new String();
    private PlanoDeSaude plano;

    private Scanner leitor = new Scanner(System.in);
    public Paciente proximo;

    public Paciente(String nome, String cpf, String telefone, String endereco, String email, String senha, String dataDeNascimento, PlanoDeSaude plano) {
        super(nome, cpf, telefone, endereco, email, senha);
        this.idPaciente = contadorIdPaciente++;
        this.dataDeNascimento = dataDeNascimento;
        this.plano = plano;
        this.proximo = null;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public PlanoDeSaude getPlano() {
        return plano;
    }
    public void setPlano(PlanoDeSaude plano) {
        this.plano = plano;
    }

    public Paciente obterProximo() {
        return proximo;
    }
    public void definirProximo(Paciente proximo) {
        this.proximo = proximo;
    }
    
    @Override
    public void realizarLogin() {
        boolean acessoLiberado = false;

        while(acessoLiberado != true) {
            System.out.println("\nLogin - Paciente\n");
            System.out.print("\nUsuário: ");
            String emailDigitado = leitor.nextLine();
            System.out.print("\nSenha: ");
            String senhaDigitada = leitor.nextLine();

            Paciente pacienteAtual = GerenciadorDeListas.listaPacientes.getInicial();

            while(pacienteAtual != null & acessoLiberado != true) {
                if(pacienteAtual.getEmail().equals(emailDigitado) && pacienteAtual.getSenha().equals(senhaDigitada)) {
                    System.out.println("\nLogin bem-sucedido! Acessando menu...\n");
                    acessoLiberado = true;
                } else {
                    pacienteAtual = pacienteAtual.obterProximo();
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
            System.out.println("\nMenu do Paciente");
            System.out.println("1 - Realizar Cadastro ");
            System.out.println("2 - Editar Cadastro");
            System.out.println("3 - Excluir Cadastro");
            System.out.println("4 - Visualizar Dados Pessoais");
            System.out.println("5 - Agendar Consulta");
            System.out.println("0 - Sair");

            System.out.print("Digite a opção desejada: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    GerenciadorDeListas.listaPacientes.cadastrarUsuario();
                    break;
                case 2:
                    GerenciadorDeListas.listaPacientes.editarUsuario();
                    break;
                case 3:
                    GerenciadorDeListas.listaPacientes.excluirUsuario();
                    break;
                case 4:
                    //GerenciadorDeListas.listaPlanos.visualizarDadosPessoais();
                    break;
                case 5:
                    //GerenciadorDeListas.listaConsultas.agendarConsulta();
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
