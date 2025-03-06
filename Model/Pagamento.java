package Model;

public class Pagamento {
    private static int contadorIdPagamento = 1;
    private int idPagamento;
    private float valor;
    private String dataDeVencimento = new String();
    private String dataDePagamento = new String();
    private String status = new String();
    private Paciente paciente;

    public Pagamento proximo;

    public Pagamento(Paciente paciente, float valor, String dataDeVencimento, String dataDePagamento, String status) {
        this.idPagamento = contadorIdPagamento++;
        this.paciente = paciente;
        this.valor = valor;
        this.dataDeVencimento = dataDeVencimento;
        this.dataDePagamento = dataDePagamento;
        this.status = status;
        this.proximo = null;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataDeVencimento() {
        return dataDeVencimento;
    }
    public void setDataDeVencimento(String dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }

    public String getDataDePagamento() {
        return dataDePagamento;
    }
    public void setDataDePagamento(String dataDePagamento) {
        this.dataDePagamento = dataDePagamento;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Pagamento obterProximo() {
        return proximo;
    }
    public void definirProximo(Pagamento proximo) {
        this.proximo = proximo;
    }
}
