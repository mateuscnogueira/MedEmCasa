package View;

import Model.Registros.GerenciadorDeRegistros;
import Model.Usuarios.GerenciadorDeUsuarios;

public class Main {
    public static void main(String[] args) {
        /* Antes do Gerenciador de Usuarios
        Administrador admMestre = new Administrador("Adm Mestre", "", "", "", "adm@gmail.com", "admin@", "Administrador Geral");
        GerenciadorDeListas.listaAdministradores.adicionarAdministrador(admMestre); //add diretamente na listaAdministradores

        Paciente pacienteTeste = new Paciente("PacTeste", null, null, null, "pac@gmail.com", "pac123", null, null);
        GerenciadorDeListas.listaPacientes.adicionarPaciente(pacienteTeste);
        
        Medico medicoTeste = new Medico("MedTeste", null, null, null, "med@gmail.com", "med123", null, null);
        GerenciadorDeListas.listaMedicos.adicionarMedico(medicoTeste);

        admMestre.realizarLogin();
        pacienteTeste.realizarLogin();
        medicoTeste.realizarLogin();
         */
        
        //Usando o GerenciadorDeUsuarios para melhorar a visualização e clareza da Main, além de otimizar
        GerenciadorDeRegistros registros = GerenciadorDeRegistros.getInstancia();
        GerenciadorDeUsuarios usuario = GerenciadorDeUsuarios.getInstancia();

        usuario.getAdministrador().realizarLogin();
        //usuario.getMedico().realizarLogin();
        usuario.getPaciente().realizarLogin(); 
    }
}
