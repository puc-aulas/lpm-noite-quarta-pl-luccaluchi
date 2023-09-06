package project1;

public class Equipamento {
    
    private static int proximoCodigo = 1;
    private int codigo = 0;
    private String tipo;
    private String descricao;
    private float valorDiaria;
    private int quantidade;

    public Equipamento(int codigo, String tipo, String descricao, float valorDiaria, int quantidade) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
        this.quantidade = quantidade;
        //proximoCodigo++;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(float valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
