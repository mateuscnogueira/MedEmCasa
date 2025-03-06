package Model;

import java.util.Scanner;
import Control.GerenciadorDeListas;

public class Medico extends Usuario {
    private static int contadorIdMedico = 1;
    private int idMedico;
    private String especialidade = new String();
    private String crm = new String();

    private Scanner leitor = new Scanner(System.in);
    public Medico proximo;

    public Medico(String nome, String cpf, String telefone, String endereco, String email, String senha, String crm, String especialidade) {
        super(nome, cpf, telefone, endereco, email, senha);
        this.idMedico = contadorIdMedico++;
        this.crm = crm;
        this.especialidade = especialidade;
        this.proximo = null;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Medico obterProximo() {
        return proximo;
    }

    public void definirProximo(Medico proximo) {
        this.proximo = proximo;
    }

    @Override
    public void realizarLogin() {
        boolean acessoLiberado = false;

        while(acessoLiberado != true) {
            System.out.println("\nLogin - Médico\n");
            System.out.print("\nUsuário: ");
            String emailDigitado = leitor.nextLine();
            System.out.print("\nSenha: ");
            String senhaDigitada = leitor.nextLine();

            Medico medAtual = GerenciadorDeListas.listaMedicos.getInicial();

            while(medAtual != null & acessoLiberado != true) {
                if(medAtual.getEmail().equals(emailDigitado) && medAtual.getSenha().equals(senhaDigitada)) {
                    System.out.println("\nLogin bem-sucedido! Acessando menu...\n");
                    acessoLiberado = true;
                } else {
                    medAtual = medAtual.obterProximo();
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
            System.out.println("\nMenu do Médico");
            System.out.println("1 - Visualizar Consultas ");
            System.out.println("2 - Editar Cadastro");
            System.out.println("3 - Visualizar Dados Pessoais");
            System.out.println("0 - Sair");
            
            /*
            Médico visualiza consultas disponíveis > seleciona alguma consulta
            gerenciarConsultas() :
                1 - Realizar Consulta
                2 - Consultar Histórico Médico > retorna o prontuário do paciente
                3 - Gerenciar Prontuário
                    3.1 - Gerar Prontuário
                        3.11 - CadastrarProntuario
                        3.12 - Preescrever Receitas
                        3.13 - Solicitar Exames
                        3.14 - Registrar Resultado
                    3.2 - Atualizar Prontuário
                        3.21 - Editar Prontuario
                        3.22 - Preescrever Receitas
                        3.23 - Solicitar Exames
                        3.24 - Registrar Resultado
                    3.5 -
            */

            System.out.print("Digite a opção desejada: ");
            opcao = leitor.nextInt();
            leitor.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    break;
                case 2:
                    GerenciadorDeListas.listaMedicos.editarUsuario();
                    break;
                case 3:
                    GerenciadorDeListas.listaMedicos.listarCadastros(); //fazer listar apenas do médico que solicitou
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
