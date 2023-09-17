package com.locadora.input;

import java.util.Scanner;

public class InputSearchByMonth
{
    private int month;
    private int year;

    public InputSearchByMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o mês: ");
        this.month = scanner.nextInt();
        System.out.println("Digite o ano: ");
        this.year = scanner.nextInt();
        scanner.close();
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

}
