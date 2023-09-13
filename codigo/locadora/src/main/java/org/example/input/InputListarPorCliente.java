package org.example.input;

import java.util.Scanner;

public class InputListarPorCliente {

    public static int idCliente;

    public  static int inputListarPorCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o id do cliente: ");
        InputListarPorCliente.idCliente = scanner.nextInt();
        return idCliente;
    }
}
