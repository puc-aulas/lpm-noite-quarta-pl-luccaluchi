package com.locadora;

public class Cliente {

    private static int proximoId = 0;
    private int idCliente = 0;
    private String nome;

    public Cliente(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do cliente não pode ser vazio.");
        }
        this.idCliente = proximoId++;
        this.nome = nome;
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

    @Override
    public String toString() {
        String returnString = "Cliente " + this.idCliente + 1;
        returnString += "\nNome: " + this.nome;
        returnString += "\n===================\n";
        return returnString;
    }
}
