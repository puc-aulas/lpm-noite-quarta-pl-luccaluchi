package project1;

public class Equipamento {
    
    private static int proximoCodigo = 1;
    private int codigo = 0;
    private String tipo;
    private String descricao;
    private float valorDiaria;
    private int quantidade;

    public Equipamento(String tipo, String descricao, float valorDiaria, int quantidade) {
        this.codigo = proximoCodigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
        this.quantidade = quantidade;
        proximoCodigo++;
    }

    public int getCodigo() {
        return codigo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
