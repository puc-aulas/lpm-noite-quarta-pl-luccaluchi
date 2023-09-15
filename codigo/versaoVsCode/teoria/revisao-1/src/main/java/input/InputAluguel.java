package org.example.input;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class InputAluguel {
    private int idCliente;
    private int idEquipamento;
    private int quantidade;
    private LocalDate dataInicio;
    private LocalDate dataTermino;

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
        this.dataInicio = stringToDate(scanner.nextLine());

        System.out.println("Data de término(dd/mm/aaaa): ");

        this.dataTermino = stringToDate(scanner.nextLine());
    }
    public LocalDate stringToDate(String data) {
        String[] dataSplit = data.split("/");
        int dia = Integer.parseInt(dataSplit[0]);
        int mes = Integer.parseInt(dataSplit[1]);
        int ano = Integer.parseInt(dataSplit[2]);
        return LocalDate.of(ano, mes, dia);
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

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public LocalDate getDataTermino() {
        return dataTermino;
    }
}
