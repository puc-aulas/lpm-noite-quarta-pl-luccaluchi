package org.example;

import org.example.input.InputSearchByMonth;

public class SearchRentByMonth {

    public static void searchRentByMonth() {
        InputSearchByMonth inputSearchByMonth = new InputSearchByMonth();
        int month = inputSearchByMonth.getMonth();
        int year = inputSearchByMonth.getYear();
        System.out.println("Aluguéis do mês " + month + " de " + year);
        for (Aluguel aluguel : Data.alugueis) {
            if (aluguel.getDataInicioDoAluguel().getMonthValue() == month && aluguel.getDataInicioDoAluguel().getYear() == year) {
                System.out.print("Id: " + aluguel.getIdAluguel() + "\t|\t");
                System.out.print("Cliente: " + aluguel.getCliente().getNome() + "\t|\t");
                System.out.print("Equipamento: " + aluguel.getEquipamento().getTipo() + "\t|\t");
                System.out.print("Quantidade: " + aluguel.getQuantidade() + "\t|\t");
                System.out.print("Data de início: " + aluguel.getDataInicioDoAluguel() + "\t|\t");
                System.out.print("Data de término: " + aluguel.getDataTerminoDoAluguel() + "\t|\t");
                System.out.println("Valor total: " + aluguel.getValorTotal());
            }
        }
    }

}
