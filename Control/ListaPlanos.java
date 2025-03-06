package Control;

import java.util.Scanner;
import Model.PlanoDeSaude;

public class ListaPlanos {
    private PlanoDeSaude inicial;
    private int totalDePlanos;
    private Scanner leitor = new Scanner(System.in);

    public ListaPlanos() {
        this.inicial = null;
        this.totalDePlanos = 0;
    }

    public PlanoDeSaude getInicial() {
        return inicial;
    }
    
    public int getTotalDePlanos() {
        return totalDePlanos;
    }

    public void cadastrarPlano() {
        System.out.println("\nCadastrar Plano\n");

        System.out.print("Insira o nome do plano: ");
        String nomePlano = leitor.nextLine();
        System.out.print("Insira a cobertura: ");
        String cobertura = leitor.nextLine();
        System.out.print("Insira o valor: ");
        float valor = leitor.nextFloat();
        leitor.nextLine(); //limpar buffer
        
        PlanoDeSaude novoPlano = new PlanoDeSaude(nomePlano, cobertura, valor);

        if (inicial == null) {
            inicial = novoPlano;
        } else {
            PlanoDeSaude atual = inicial;
            while (atual.obterProximo() != null) {
                atual = atual.obterProximo();
            }
            atual.definirProximo(novoPlano);
        }
        System.out.println("\nPlano de Saúde cadastrado com sucesso!\n\n");
    }

    public void editarPlano() {
        System.out.println("\nEditar Plano de Saúde\n");
        System.out.print("Digite o nome do plano que deseja editar: ");
        String planoBuscado = leitor.nextLine();
        PlanoDeSaude atual = inicial;
        while (atual != null && !atual.getNomePlano().equals(planoBuscado)) {
            atual = atual.obterProximo();
        }
        if (atual != null) {
            String troca = new String();
            int opcao = -1;

            System.out.println("\nPlano encontrado. O que deseja editar?\n");
            do {

                System.out.println("1 - Nome do Plano");
                System.out.println("2 - Cobertura");
                System.out.println("3 - Valor");
                System.out.println("0 - Sair");
                System.out.print("\nDigite a opção desejada: ");
                opcao = leitor.nextInt();
                leitor.nextLine(); // Limpar buffer
                switch (opcao) {
                    case 1:
                        System.out.print("Novo nome do plano: ");
                        troca = leitor.nextLine();
                        atual.setNomePlano(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 2:
                        System.out.print("Nova cobertura: ");
                        troca = leitor.nextLine();
                        atual.setCobertura(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 3:
                        System.out.print("Novo valor: ");
                        float valor = leitor.nextFloat();
                        atual.setValor(valor);
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
            System.out.println("Plano de Saúde não encontrado.");
        }
    }

    public void excluirPlano() {
        System.out.print("Digite o email do Plano De Saúde a ser excluído: ");
        String planoBuscado = leitor.nextLine();
        PlanoDeSaude atual = this.inicial;
        PlanoDeSaude anterior = null;
        while (atual != null && !atual.getNomePlano().equals(planoBuscado)) {
            anterior = atual;
            atual = atual.obterProximo();
        }
        if (atual != null) {
            System.out.print("Tem certeza que deseja excluir o Plano De Saúde: " + atual.getNomePlano() + " ? (sim/não): ");
            String confirmacao = leitor.nextLine().toLowerCase();  // converte toda a string para minúscula.

            if(confirmacao.equals("sim") || confirmacao.equals("s")) {
                if (anterior == null) {
                    inicial = atual.obterProximo();
                } else {
                    anterior.definirProximo(atual.obterProximo());
                }
                System.out.println("Plano De Saúde excluído com sucesso.");
            } else {
                System.out.println("\nOperação cancelada.\n\n");
            }
        } else {
            System.out.println("Plano De Saúde não encontrado.");
        }
    }

    public void listarPlanos() {
        if (inicial == null) {
            System.out.println("Nenhum Plano cadastrado.");
        } else {
            PlanoDeSaude atual = inicial;
            while (atual != null) {
                System.out.println("IdPlano: " + atual.getIdPlano() 
                + ", Nome do Plano: " + atual.getNomePlano() 
                + ", Cobertura: " + atual.getCobertura()
                + ", Valor: " + atual.getValor() + "\n");
                atual = atual.obterProximo();
            }
        }
    }

    public void gerenciarPlano() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Planos de Saúde:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Listar Planos Cadastrados");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarPlano();
                    break;
                case 2:
                    editarPlano();
                    break;
                case 3:
                    excluirPlano();
                    break;
                    case 4:
                    listarPlanos();
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
