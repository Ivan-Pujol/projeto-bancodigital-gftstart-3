package one.digitalinovation;

public class Cliente {

    private String nome;
    private boolean ccNegativa, cpNegativa;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isCcNegativa() {
        return ccNegativa;
    }

    public void setCcNegativa(boolean ccNegativa) {
        this.ccNegativa = ccNegativa;
    }

    public boolean isCpNegativa() {
        return cpNegativa;
    }

    public void setCpNegativa(boolean cpNegativa) {
        this.cpNegativa = cpNegativa;
    }

    public Cliente(String nome, String tipo) {
        this.setNome(nome);
        this.setTipo(tipo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
