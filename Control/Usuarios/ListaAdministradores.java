package Control.Usuarios;

import Model.Usuarios.Administrador;
import java.util.Scanner;

public class ListaAdministradores implements ColecaoDeUsuarios {
    private Administrador inicial;
    private int totalDeAdministradores;
    private Scanner leitor = new Scanner(System.in);

    public ListaAdministradores() {
        this.inicial = null;
        this.totalDeAdministradores = 0;
    }

    public Administrador getInicial() {
        return inicial;
    }

    public int getTotalDeAdministradores() {
        return totalDeAdministradores;
    }

    //add AdmMestre para realizar testes na Main
    public void adicionarAdministrador(Administrador admMestre) {
        if (inicial == null) {
            inicial = admMestre;
        } else {
            Administrador atual = inicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(admMestre);
        }
        totalDeAdministradores++;
    }

    @Override
    public void cadastrarUsuario() {
        System.out.println("\nCadastrar Administrador\n");

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
        System.out.print("Insira a função: ");
        String funcao = leitor.nextLine();
        
        Administrador novoAdministrador = new Administrador(nome, cpf, telefone, endereco, email, senha, funcao);

        if (inicial == null) {
            inicial = novoAdministrador;
        } else {
            Administrador atual = inicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(novoAdministrador);
        }
        System.out.println("\nAdministrador cadastrado com sucesso.\n\n");
    }

    @Override
    public void editarUsuario() {
        System.out.println("\nEditar Administrador\n");
        System.out.print("Digite o email do Administrador para editar: ");
        String emailBuscado = leitor.nextLine();
        Administrador atual = inicial;
        while (atual != null && !atual.getEmail().equals(emailBuscado)) {
            atual = atual.obterProximo();
        }
        if (atual != null) {
            String troca = new String();
            int opcao = -1;

            System.out.println("\nAdministrador encontrado. O que deseja editar?\n");
            do {

                System.out.println("1 - Telefone");
                System.out.println("2 - Endereço");
                System.out.println("3 - Email");
                System.out.println("4 - Senha");
                System.out.println("5 - Função");
                System.out.println("0 - Sair");
                System.out.print("\nDigite a opção desejada: ");
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
                    case 5:
                        System.out.print("Nova especialidade: ");
                        troca = leitor.nextLine();
                        atual.setFuncao(troca);
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
            System.out.println("Administrador não encontrado.");
        }
    }

    @Override
    public void excluirUsuario() {
        System.out.print("Digite o email do Administrador a ser excluído: ");
        String emailBuscado = leitor.nextLine();
        Administrador atual = this.inicial;
        Administrador anterior = null;
        while (atual != null && !atual.getEmail().equals(emailBuscado)) {
            anterior = atual;
            atual = atual.obterProximo();
        }
        if (atual != null) {
            System.out.print("Tem certeza que deseja excluir o Administrador: " + atual.getEmail() + " ? (sim/não): ");
            String confirmacao = leitor.nextLine().toLowerCase();  // converte toda a string para minúscula.

            if(confirmacao.equals("sim")) {
                if (anterior == null) {
                    inicial = atual.obterProximo();
                } else {
                    anterior.definirProximo(atual.obterProximo());
                }
                System.out.println("Administrador excluído com sucesso.");
            } else {
                System.out.println("\nOperação cancelada.\n\n");
            }
        } else {
            System.out.println("Administrador não encontrado.");
        }
    }

    @Override
    public void listarCadastros() {
        if (inicial == null) {
            System.out.println("Nenhum Administrador cadastrado.");
        } else {
            Administrador atual = inicial;
            while (atual != null) {
                System.out.println("IdUser: " + atual.getId_user() 
                + ", IdAdm: " + atual.getIdAdministrador() 
                + ", Nome: " + atual.getNome() 
                + ", CPF: " + atual.getCpf() 
                + ", Telefone: " + atual.getTelefone() 
                + ", Endereço: " + atual.getEndereco() 
                + ", Email: " + atual.getEmail() 
                + ", Senha: " + atual.getSenha()
                + ", Função: " + atual.getFuncao() + "\n");
                atual = atual.obterProximo();
            }
        }
    }

    @Override
    public void gerenciarUsuario() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Administradores:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar Administradores Cadastrados");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer

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

