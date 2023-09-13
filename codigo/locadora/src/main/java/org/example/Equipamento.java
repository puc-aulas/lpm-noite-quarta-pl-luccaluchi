package org.example;

public class Equipamento {

    private static int proximoId = 1;
    private int quantidade;
    private int idEquipamento = 0;
    private String tipo;
    private String descricao;
    private double valorDiaria;

    public Equipamento(String tipo, String descricao, double valorDiaria, int quantidade) {
        this.idEquipamento = proximoId;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorDiaria = valorDiaria;
        this.quantidade = quantidade;
        Equipamento.proximoId++;
    }

    public void subtrairQuantidade(int quantidade) {
        this.quantidade -= quantidade;

    }

    public void somarQuantidade(int quantidade) {
        this.quantidade += quantidade;
    }

    public Boolean verificarDisponibilidade(int quantidadeSolicitada) {
        if (this.quantidade - quantidadeSolicitada < 0) {
            System.out.println("Não há equipamentos suficientes para realizar o aluguel");
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }


    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
