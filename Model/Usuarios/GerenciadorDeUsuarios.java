package Model.Usuarios;

import Control.Registros.GerenciadorDeRegistros;
import Control.Usuarios.GerenciadorDeListas;

public class GerenciadorDeUsuarios {
    private static GerenciadorDeUsuarios instancia;
    private Administrador administrador;
    private Medico medico;
    private Paciente paciente;

    private GerenciadorDeUsuarios() {
        inicializarUsuarios();
    }

    public static GerenciadorDeUsuarios getInstancia() {
        if(instancia == null) {
            instancia = new GerenciadorDeUsuarios();
        }
        return instancia;
    }

    private void inicializarUsuarios() {
        administrador = new Administrador("Adm Mestre", "", "", "", "adm@gmail.com", "admin@", "Administrador Geral");
        GerenciadorDeListas.listaAdministradores.adicionarAdministrador(administrador);

        medico = new Medico("MedTeste", null, null, null, "med@gmail.com", "med123", null, null);
        GerenciadorDeListas.listaMedicos.adicionarMedico(medico);
        /* 
        */
        paciente = new Paciente("PacTeste", null, null, null, "pac@gmail.com", "pac123", null, null);
        GerenciadorDeListas.listaPacientes.adicionarPaciente(paciente);
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
