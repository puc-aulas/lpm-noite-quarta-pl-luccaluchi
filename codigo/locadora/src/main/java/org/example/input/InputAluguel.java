package org.example.input;

import java.util.Date;
import java.util.Scanner;

public class InputAluguel {
    private int idCliente;
    private int idEquipamento;
    private int quantidade;
    private Date dataInicio;
    private Date dataTermino;

    public InputAluguel() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id do cliente: ");
        this.idCliente = scanner.nextInt();
        System.out.println("Id do equipamento: ");
        this.idEquipamento = scanner.nextInt();
        System.out.println("Quantidade: ");
        this.quantidade = scanner.nextInt();
        System.out.println("Data de início(dd/mm/aaaa):");
        this.dataInicio = stringToDate(scanner.nextLine());
        scanner.nextLine();
        System.out.println("Data de término(dd/mm/aaaa): ");
        this.dataTermino = stringToDate(scanner.nextLine());
    }
    public Date stringToDate(String data) {
        String[] dataSplit = data.split("/");
        int dia = Integer.parseInt(dataSplit[0]);
        int mes = Integer.parseInt(dataSplit[1]);
        int ano = Integer.parseInt(dataSplit[2]);
        return new Date(ano, mes, dia);
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

    public Date getDataInicio() {
        return dataInicio;
    }
    public Date getDataTermino() {
        return dataTermino;
    }
}
