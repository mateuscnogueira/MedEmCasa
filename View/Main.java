package View;

import Control.GerenciadorDeListas;
import Model.Administrador;
import Model.Medico;
import Model.Paciente;

public class Main {
    public static void main(String[] args) {
        Administrador admMestre = new Administrador("Adm Mestre", "", "", "", "adm@gmail.com", "admin@", "Administrador Geral");
        GerenciadorDeListas.listaAdministradores.adicionarAdministrador(admMestre); //add diretamente na listaAdministradores

        //login com adm mestre
        //admMestre.realizarLogin();

        //criar outro adm e realizar login com essa conta
        //admMestre.realizarLogin();

        Paciente pacienteTeste = new Paciente("PacTeste", null, null, null, "pac@gmail.com", "pac123", null, null);
        GerenciadorDeListas.listaPacientes.adicionarPaciente(pacienteTeste);

        //pacienteTeste.realizarLogin();

        Medico medicoTeste = new Medico("MedTeste", null, null, null, "med@gmail.com", "med123", null, null);
        GerenciadorDeListas.listaMedicos.adicionarMedico(medicoTeste);

        medicoTeste.realizarLogin();
    }
}
