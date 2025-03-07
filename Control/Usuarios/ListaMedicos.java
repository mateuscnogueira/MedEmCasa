package Control.Usuarios;

import Model.Usuarios.Medico;
import java.util.Scanner;

public class ListaMedicos implements ColecaoDeUsuarios {

    private Medico inicial;
    private int totalDeMedicos;
    private Scanner leitor = new Scanner(System.in);

    public ListaMedicos() {
        this.inicial = null;
        this.totalDeMedicos = 0;
    }

    public Medico getInicial() {
        return inicial;
    }

    public int getTotalDeMedicos() {
        return totalDeMedicos;
    }

    //add MedTeste para realizar testes na Main
    public void adicionarMedico(Medico medTeste) {
        if (inicial == null) {
            inicial = medTeste;
        } else {
            Medico atual = inicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(medTeste);
        }
        totalDeMedicos++;
    }

    @Override
    public void cadastrarUsuario() {
        System.out.println("Cadastrar Médico");
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
        System.out.print("Insira o CRM: ");
        String crm = leitor.nextLine();
        System.out.print("Insira a especialidade: ");
        String especialidade = leitor.nextLine();

        Medico novoMedico = new Medico(nome, cpf, telefone, endereco, email, senha, crm, especialidade);
        if (inicial == null) {
            inicial = novoMedico;
        } else {
            Medico atual = inicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(novoMedico);
        }
        totalDeMedicos++;
        System.out.println("Médico cadastrado com sucesso.");
    }

    @Override
    public void editarUsuario() {
        System.out.println("Editar Médico");
        System.out.print("Digite o CRM do médico a ser editado: ");
        String crmBuscado = leitor.nextLine();
        Medico atual = inicial;
        while (atual != null && !atual.getCrm().equals(crmBuscado)) {
            atual = atual.obterProximo();
        }
        if (atual != null) {
            String troca = new String();
            int opcao = -1;

            System.out.println("Médico encontrado. O que deseja editar?");
            do {

                System.out.println("1 - Telefone");
                System.out.println("2 - Endereço");
                System.out.println("3 - Email");
                System.out.println("4 - Senha");
                System.out.println("5 - Especialidade");
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
                    case 5:
                        System.out.print("Nova especialidade: ");
                        troca = leitor.nextLine();
                        atual.setEspecialidade(troca);
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
            System.out.println("Médico não encontrado.");
        }
    }

    @Override
    public void excluirUsuario() {
        System.out.print("Digite o CRM do médico a ser excluído: ");
        String crmBuscado = leitor.nextLine();
        Medico atual = inicial;
        Medico anterior = null;
        while (atual != null && !atual.getCrm().equals(crmBuscado)) {
            anterior = atual;
            atual = atual.obterProximo();
        }
        if (atual != null) {
            System.out.print("Tem certeza que deseja excluir o Médico: " + atual.getEmail() + " ? (sim/não): ");
            String confirmacao = leitor.nextLine().toLowerCase();  // converte toda a string para minúscula.

            if (confirmacao.equals("sim")) {
                if (anterior == null) {
                    inicial = atual.obterProximo();
                } else {
                    anterior.definirProximo(atual.obterProximo());
                }
                System.out.println("Médico excluído com sucesso.");
            } else {
                System.out.println("\nOperação cancelada.\n\n");
            }
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    @Override
    public void listarCadastros() {
        if (inicial == null) {
            System.out.println("Nenhum Médico cadastrado.");
        } else {
            Medico atual = inicial;
            while (atual != null) {
                System.out.println("IdUser: " + atual.getId_user() 
                + ", IdMed: " + atual.getIdMedico() 
                + ", Nome: " + atual.getNome() 
                + ", CPF: " + atual.getCpf() 
                + ", Telefone: " + atual.getTelefone() 
                + ", Endereço: " + atual.getEndereco() 
                + ", Email: " + atual.getEmail() 
                + ", Senha: " + atual.getSenha()
                + ", CRM: " + atual.getCrm()
                + ", Especialidade: " + atual.getCrm() + "\n");
                atual = atual.obterProximo();
            }
        }
    }

    @Override
    public void gerenciarUsuario() {
        int opcao;
        do {
            System.out.println("\n\nGerenciamento de Médicos\n");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar Médicos Cadastrados");
            System.out.println("0 - Finalizar Gerenciamento");

            System.out.print("Digite a opção desejada: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar o buffer

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
                    System.out.println("Opção Inválida.");
            }
        } while (opcao != 0);
    }
}
