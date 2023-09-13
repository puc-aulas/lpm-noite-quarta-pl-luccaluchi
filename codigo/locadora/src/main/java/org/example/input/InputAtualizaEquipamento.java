package org.example.input;

import java.util.Scanner;

public class InputAtualizaEquipamento {
    public int idEquipamento;
    public int quantidade;

    public InputAtualizaEquipamento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o id do equipamento: ");
        this.idEquipamento = scanner.nextInt();
        System.out.println("Digite a quantidade: ");
        this.quantidade = scanner.nextInt();
    }
/*
    public int getId() {
        return idEquipamento;
    }

 */
}
