package com.locadora.input;

import java.time.LocalDate;
import java.util.Scanner;

public class InputAluguel {
    private int idCliente;
    private int idEquipamento;
    private int quantidade;
    private String dataInicio;
    private String dataTermino;

    public InputAluguel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do cliente: ");
        this.idCliente = scanner.nextInt();
        System.out.println("Id do equipamento: ");
        this.idEquipamento = scanner.nextInt();
        System.out.println("Quantidade: ");
        this.quantidade = scanner.nextInt();
        System.out.println("Data de início(dd/mm/aaaa):");
        scanner.nextLine();
        this.dataInicio = scanner.nextLine();

        System.out.println("Data de término(dd/mm/aaaa): ");

        this.dataTermino = scanner.nextLine();
        scanner.close();
    }
    public int getIdCliente() {
        return idCliente;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getDataInicio() {
        return dataInicio;
    }
    public String getDataTermino() {
        return dataTermino;
    }
}
