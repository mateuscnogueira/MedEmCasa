package Control;

import Model.Administrador;
import Model.Medico;
import Model.Paciente;
import Model.PlanoDeSaude;
import Model.Pagamento;

public class GerenciadorDeListas {
    public static ListaAdministradores listaAdministradores = new ListaAdministradores();
    public static ListaMedicos listaMedicos = new ListaMedicos();
    public static ListaPacientes listaPacientes = new ListaPacientes();
    public static ListaPlanos listaPlanos = new ListaPlanos();
    public static ListaPagamentos listaPagamentos = new ListaPagamentos();
    
    public static void inicializarDados() {
        System.out.println("Inicializando dados do sistema...");
        listaAdministradores = new ListaAdministradores();
        listaMedicos = new ListaMedicos();
        listaPacientes = new ListaPacientes();
        listaPlanos = new ListaPlanos();
        listaPagamentos = new ListaPagamentos();
        System.out.println("Dados inicializados com sucesso.");
    }
}

