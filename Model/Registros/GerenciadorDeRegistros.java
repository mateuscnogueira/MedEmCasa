package Model.Registros;

import Control.Usuarios.GerenciadorDeListas;
import Model.Usuarios.GerenciadorDeUsuarios;

public class GerenciadorDeRegistros {
    private static GerenciadorDeRegistros instancia;
    private PlanoDeSaude plano;

    private GerenciadorDeRegistros() {
        inicializarRegistros();
    }

    public static GerenciadorDeRegistros getInstancia() {
        if(instancia == null) {
            instancia = new GerenciadorDeRegistros();
        }
        return instancia;
    }

    private void inicializarRegistros() {
        plano = new PlanoDeSaude("Basic", "Emergencial", 10);
    }
}
