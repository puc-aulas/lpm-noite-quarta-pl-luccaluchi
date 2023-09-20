package com.locadora;

public class Equipamento {

    private static int proximoId = 0;
    private int quantidade;
    private int idEquipamento;
    private String tipo;
    private String descricao;
    private double valorDiaria;

    public Equipamento(String tipo, String descricao, double valorDiaria, int quantidade)
            throws IllegalArgumentException {
        this.tipo = tipo;
        this.descricao = descricao;
        if (descricao.length() < 5) {
            throw new IllegalArgumentException("A descrição deve ter no mínimo 5 caracteres.");
        }

        this.valorDiaria = valorDiaria;
        if (quantidade < 0) {
            throw new IllegalArgumentException("A quantidade de equipamentos não pode ser negativa.");
        }
        this.idEquipamento = proximoId++;
        this.quantidade = quantidade;
    }
// Método para adicionar equipamentos ao estoque
    public void modificarQuantidade(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
    }

// Método para verificar se há equipamentos suficientes para realizar o aluguel
    public Boolean verificarDisponibilidade(int quantidadeSolicitada) {
        if (this.quantidade - quantidadeSolicitada < 0) {
            System.out.println("Não há equipamentos suficientes para realizar o aluguel");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public int getIdEquipamento() {
        return this.idEquipamento;
    }

    public String getTipo() {
        return this.tipo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
// Método toString() para retornar uma representação em String do objeto.
    @Override
    public String toString() {
        return this.tipo;
    }
    
// Método show() para retornar uma representação em String do objeto.
    public String show() {
        String returnFormated = String.format(
                "ID: %d\nTipo: %s\nDescrição: %s\nValor da diária: %.2f\nQuantidade: %d\n=====================================\n",
                this.idEquipamento,
                this.tipo,
                this.descricao,
                this.valorDiaria,
                this.quantidade);

        return returnFormated;
    }
}
