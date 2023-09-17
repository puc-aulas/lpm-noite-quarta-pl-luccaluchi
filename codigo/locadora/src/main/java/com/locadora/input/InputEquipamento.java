package com.locadora.input;

import java.util.Scanner;

public class InputEquipamento {
    // int codigo, String tipo, String descricao, double valorDiaria, int quantidade
    private String tipo;
    private String descricao;
    private double valorDiaria;
    private int quantidade;

    public InputEquipamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo do equipamento: ");
        this.tipo = scanner.nextLine();
        System.out.println("Digite a descrição do equipamento: ");
        this.descricao = scanner.nextLine();
        System.out.println("Digite o valor da diária do equipamento: ");
        this.valorDiaria = scanner.nextDouble();
        System.out.println("Digite a quantidade do equipamento: ");
        this.quantidade = scanner.nextInt();
        scanner.nextLine();
        scanner.close();
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

    public int getQuantidade() {
        return quantidade;
    }
}