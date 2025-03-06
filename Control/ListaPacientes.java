package Control;

import Model.Paciente;
import Model.PlanoDeSaude;

import java.util.Scanner;

public class ListaPacientes implements ColecaoDeUsuarios {

    private Paciente inicial;
    private int totalDePacientes;
    private Scanner leitor = new Scanner(System.in);

    public ListaPacientes() {
        this.inicial = null;
        this.totalDePacientes = 0;
    }

    public Paciente getInicial() {
        return inicial;
    }

    public int getTotalDePacientes() {
        return totalDePacientes;
    }

    //add PacTeste para realizar testes na Main
    public void adicionarPaciente(Paciente pacienteTeste) {
        if (inicial == null) {
            inicial = pacienteTeste;
        } else {
            Paciente atual = inicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(pacienteTeste);
        }
        totalDePacientes++;
    }

    @Override
    public void cadastrarUsuario() {
        System.out.println("Cadastrar Usuário");
        System.out.print("Insira o nome: ");
        String nome = leitor.nextLine();
        System.out.print("Insira o cpf: ");
        String cpf = leitor.nextLine();
        System.out.print("Insira o telefone: ");
        String telefone = leitor.nextLine();
        System.out.print("Insira o endereço: ");
        String endereco = leitor.nextLine();
        System.out.print("Insira o email: ");
        String email = leitor.nextLine();
        System.out.print("Insira a senha: ");
        String senha = leitor.nextLine();
        System.out.print("Insira a Data de Nascimento (DD/MM/AAAA): ");
        String dataDeNascimento = leitor.nextLine();

        System.out.println("\n\n*** Planos de Saúde ***\n");
        //Listar planos cadastrados para que o usuário escolha
        GerenciadorDeListas.listaPlanos.listarPlanos();
        
        System.out.print("Insira o ID do Plano desejado: ");
        int planoDesejado = leitor.nextInt();
        leitor.nextLine(); //limpar buffer
        
        // Verificar se o plano desejado existe na lista global de planos
        PlanoDeSaude planoAtual = GerenciadorDeListas.listaPlanos.getInicial();
        while(planoAtual != null && planoAtual.getIdPlano() != planoDesejado) {
            planoAtual = planoAtual.obterProximo();
        }
        
        if(planoAtual == null) {
            System.out.println("Esse plano não existe! Tente novamente.");
        } else {
            Paciente novoPaciente = new Paciente(nome, cpf, telefone, endereco, email, senha, dataDeNascimento, planoAtual);
            if (inicial == null) {
                inicial = novoPaciente;
            } else {
                Paciente atual = inicial;
                while (atual.obterProximo() != null) {
                    atual = atual.obterProximo();
                }
                atual.definirProximo(novoPaciente);
            }
            totalDePacientes++;
            System.out.println("Paciente cadastrado com sucesso.");
        }
    }
    
    @Override
    public void editarUsuario() {
        System.out.println("Editar Paciente");
        System.out.print("Digite o email do paciente a ser editado: ");
        String emailBuscado = leitor.nextLine();
        Paciente atual = inicial;
        while (atual != null && !atual.getEmail().equals(emailBuscado)) {
            atual = atual.obterProximo();
        }
        if (atual != null) {
            String troca = new String();
            int opcao = -1;

            System.out.println("Paciente encontrado. O que deseja editar?");
            do {

                System.out.println("1 - Telefone");
                System.out.println("2 - Endereço");
                System.out.println("3 - Email");
                System.out.println("4 - Senha");
                System.out.println("0 - Sair");
                opcao = leitor.nextInt();
                leitor.nextLine(); // Limpar buffer
                switch (opcao) {
                    case 1:
                        System.out.print("Novo telefone: ");
                        troca = leitor.nextLine();
                        atual.setTelefone(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 2:
                        System.out.print("Novo endereço: ");
                        troca = leitor.nextLine();
                        atual.setEndereco(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 3:
                        System.out.print("Novo email: ");
                        troca = leitor.nextLine();
                        atual.setEmail(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 4:
                        System.out.print("Nova senha: ");
                        troca = leitor.nextLine();
                        atual.setSenha(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 0:
                        System.out.println("\nDados Salvos!\n\n");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente");
                        System.out.println("\nQual campo deseja modificar?\n");
                        break;
                }
            } while (opcao != 0);
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    @Override
    public void excluirUsuario() {
        System.out.print("Digite o email do paciente a ser excluído: ");
        String emailBuscado = leitor.nextLine();
        Paciente atual = inicial;
        Paciente anterior = null;
        while (atual != null && !atual.getEmail().equals(emailBuscado)) {
            anterior = atual;
            atual = atual.obterProximo();
        }
        if (atual != null) {
            System.out.print("Tem certeza que deseja excluir o Paciente: " + atual.getEmail() + " ? (sim/não): ");
            String confirmacao = leitor.nextLine().toLowerCase();  // converte toda a string para minúscula.

            if (confirmacao.equals("sim")) {
                if (anterior == null) {
                    inicial = atual.obterProximo();
                } else {
                    anterior.definirProximo(atual.obterProximo());
                }
                System.out.println("Paciente excluído com sucesso.");
            } else {
                System.out.println("\nOperação cancelada.\n\n");
            }
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
    
    @Override
    public void listarCadastros() {
        if (inicial == null) {
            System.out.println("Nenhum Paciente cadastrado.");
        } else {
            Paciente atual = inicial;
            while (atual != null) {
                System.out.println("IdUser: " + atual.getId_user() 
                + ", IdPaciente: " + atual.getIdPaciente() 
                + ", Nome: " + atual.getNome() 
                + ", CPF: " + atual.getCpf() 
                + ", Telefone: " + atual.getTelefone() 
                + ", Endereço: " + atual.getEndereco() 
                + ", Email: " + atual.getEmail() 
                + ", Senha: " + atual.getSenha()
                + ", Data de Nascimento: " + atual.getDataDeNascimento()
                + ", Plano: " + atual.getPlano().getNomePlano() + "\n");
                atual = atual.obterProximo();
            }
        }
    }

    public void gerenciarUsuario() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Pacientes:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar Pacientes Cadastrados");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    editarUsuario();
                    break;
                case 3:
                    excluirUsuario();
                    break;
                case 4:
                    listarCadastros();
                    break;
                case 0:
                    System.out.println("Gerenciamento Finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
}
