package Control.Usuarios;

import Model.Usuarios.Administrador;
import Model.Usuarios.Medico;
import Model.Usuarios.Paciente;

public class GerenciadorDeListas {
    public static ListaAdministradores listaAdministradores = new ListaAdministradores();
    public static ListaMedicos listaMedicos = new ListaMedicos();
    public static ListaPacientes listaPacientes = new ListaPacientes();
    
    public static void inicializarDados() {
        System.out.println("Inicializando dados do sistema...");
        listaAdministradores = new ListaAdministradores();
        listaMedicos = new ListaMedicos();
        listaPacientes = new ListaPacientes();
        System.out.println("Dados inicializados com sucesso.");
    }
}

