package org.example;

public class Cliente {

    private static int proximoId = 1;
    private int idCliente = 0;
    private String nome;

    public Cliente(String nome) {
        this.idCliente = proximoId;
        this.nome = nome;
        Cliente.proximoId++;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
