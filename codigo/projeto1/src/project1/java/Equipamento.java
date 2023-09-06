package project1.java;

public class Equipamento {
    private static int proximoCodigo = 0;
    private int codigo = 0;
    private String tipo;
    private String descricao;
    private double valorDiaria;
    private static int quantidade;

    public Equipamento(String tipo, String descricao, double valorDiaria, int quant) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
        quantidade = quant;
        this.codigo = proximoCodigo++;
    }

    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int qnt) {
        quantidade = qnt;
    }
}
