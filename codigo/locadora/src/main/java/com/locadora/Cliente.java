package com.locadora;

public class Cliente {

// Optou-se pelo uso da variável static para gerenciar o número dos ids para que os ids sejam sequenciais, náo se repitam.
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

// O método toString() é um método especial que retorna uma representação em String do objeto.
    @Override
    public String toString() {
        String returnString = "Cliente " + this.idCliente + 1;
        returnString += "\nNome: " + this.nome;
        returnString += "\n===================\n";
        return returnString;
    }
}
