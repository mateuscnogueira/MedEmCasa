package Control;

import Model.Paciente;
import Model.Pagamento;
import java.util.Scanner;

public class ListaPagamentos {
    private Pagamento inicial;
    private int totalDePagamentos;
    private Scanner leitor = new Scanner(System.in);

    public ListaPagamentos() {
        this.inicial = null;
        this.totalDePagamentos = 0;
    }

    public Pagamento getInicial() {
        return inicial;
    }

    public int getTotalDePagamentos() {
        return totalDePagamentos;
    }

    public void cadastrarPagamento() {
        System.out.println("\nCadastrar Pagamento\n");

        System.out.print("Insira o nome do paciente: ");
        String nomeBuscado = leitor.nextLine();

        // Verificar se o paciente existe na lista global de pacientes
        Paciente pacienteAtual = GerenciadorDeListas.listaPacientes.getInicial();
        while (pacienteAtual != null && !pacienteAtual.getNome().equalsIgnoreCase(nomeBuscado)) {
            pacienteAtual = pacienteAtual.obterProximo();
        }

        if(pacienteAtual == null) {
            System.out.println("\nPaciente não encontrado! O pagamento não pode ser cadastrado.\n");
        } else {
            System.out.print("Insira o valor do pagamento: ");
            float valor = leitor.nextFloat();
            leitor.nextLine(); // Limpar buffer

            System.out.print("Insira a data do vencimento (dd/mm/aaaa): ");
            String dataVencimento = leitor.nextLine();

            System.out.print("Insira a data do pagamento (dd/mm/aaaa): ");
            String dataPagamento = leitor.nextLine();

            System.out.print("Insira o status do pagamento (pago/pendente): ");
            String status = leitor.nextLine();

            Pagamento novoPagamento = new Pagamento(pacienteAtual, valor, dataVencimento, dataPagamento, status);

            if (inicial == null) {
                inicial = novoPagamento;
            } else {
                Pagamento pagamentoAtual = inicial;
                while (pagamentoAtual.obterProximo() != null) {
                    pagamentoAtual = pagamentoAtual.obterProximo();
                }
                pagamentoAtual.definirProximo(novoPagamento);
            }
    
            totalDePagamentos++;
            System.out.println("\nPagamento cadastrado com sucesso!\n\n");
        }

    }

    public void editarPagamento() {
        System.out.println("\nEditar Pagamento\n");

        System.out.print("Insira o nome do paciente: ");
        String nomeBuscado = leitor.nextLine();
        System.out.print("Insira o ID de Pagamento: ");
        int idBuscado = leitor.nextInt();
        leitor.nextLine(); // limpar buffer

        // Verificar se o paciente e o id existem e estão na mesma posição na lista global de Pagamentos
        Pagamento pagamentoAtual = GerenciadorDeListas.listaPagamentos.getInicial();

        while(pagamentoAtual != null && (!pagamentoAtual.getPaciente().getNome().equals(nomeBuscado) || pagamentoAtual.getIdPagamento() != idBuscado)) {
            pagamentoAtual = pagamentoAtual.obterProximo();
        }

        if(pagamentoAtual == null) {
            System.out.println("\nPagamento não encontrado!\n");
        } else {
            System.out.println("\nPagamento encontrado. O que deseja editar?\n");

            int opcao;
            String troca = new String();
            float valor;

            do {
                System.out.println("1 - Valor");
                System.out.println("2 - Data de Pagamento");
                System.out.println("3 - Status");
                System.out.println("0 - Sair");
                System.out.print("\nDigite a opção desejada: ");
                opcao = leitor.nextInt();
                leitor.nextLine(); // Limpar buffer
                switch (opcao) {
                    case 1:
                        System.out.print("Novo valor: ");
                        valor = leitor.nextFloat();
                        leitor.nextLine(); //limpar buffer
                        pagamentoAtual.setValor(valor);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 2:
                        System.out.print("Nova data de pagamento: ");
                        troca = leitor.nextLine();
                        pagamentoAtual.setDataDePagamento(troca);
                        System.out.println("\nModificação realizada com êxito!");
                        System.out.println("\nDeseja modificar mais algum campo?\n");
                        break;
                    case 3:
                        System.out.print("Novo status: (Pago/Pendente/Vencido): ");
                        troca = leitor.nextLine();
                        pagamentoAtual.setStatus(troca);
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
            } while(opcao != 0);
        }
    }

    public void listarPagamentos() {
        if (inicial == null) {
            System.out.println("Nenhum Pagamento cadastrado.");
        } else {
            Pagamento atual = inicial;
            while (atual != null) {
                System.out.println("IdPagamento: " + atual.getIdPagamento()
                + ", Paciente: " + atual.getPaciente().getNome()
                + ", Valor: " + atual.getValor()
                + ", Data do Vencimento: " + atual.getDataDeVencimento()
                + ", Data do Pagamento: " + atual.getDataDePagamento()
                + ", Status: " + atual.getStatus() + "\n");
                atual = atual.obterProximo();
            }
        }
    }
    
    public void gerenciarPagamento() {
        int opcao;
        do {
            System.out.println("\nGerenciamento de Pagamentos:");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Editar");
            System.out.println("3 - Listar Pagamentos Cadastrados");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = leitor.nextInt();
            leitor.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    cadastrarPagamento();
                    break;
                case 2:
                    editarPagamento();
                    break;
                case 3:
                    listarPagamentos();
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
