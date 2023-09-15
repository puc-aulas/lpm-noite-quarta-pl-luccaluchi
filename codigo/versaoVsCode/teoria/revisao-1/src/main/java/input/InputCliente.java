package org.example.input;

import java.util.Scanner;

public class InputCliente {

    public String nome;

    public InputCliente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do cliente: ");
        this.nome = scanner.nextLine();
    }

    public String getNome() {
        return nome;
    }



}
