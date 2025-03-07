package Control.Registros;

import Model.Registros.*;;

public class GerenciadorDeRegistros {
    public static ListaPlanos listaPlanos = new ListaPlanos();
    public static ListaPagamentos listaPagamentos = new ListaPagamentos();
    
    public static void inicializarDados() {
        System.out.println("Inicializando dados do sistema...");
        listaPlanos = new ListaPlanos();
        listaPagamentos = new ListaPagamentos();
        System.out.println("Dados inicializados com sucesso.");
    }
}
