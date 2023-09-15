package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class AluguelTest {

    @Test
    public void deveCalcularOValorDoAluguelCorretamente() {
        Cliente cliente = new Cliente("João da Silva");
        Equipamento equipamento = new Equipamento("TV", 100.00);
        LocalDate dataInicioDoAluguel = LocalDate.now();
        LocalDate dataTerminoDoAluguel = dataInicioDoAluguel.plusDays(2);

        Aluguel aluguel = new Aluguel(cliente, equipamento, 1, dataInicioDoAluguel, dataTerminoDoAluguel);

        Assertions.assertEquals(200.00, aluguel.getValorTotal());
    }

    @Test
    public void deveLancarExcecaoSeADataDeTerminoForAnteriorADataDeInicio() {
        Cliente cliente = new Cliente("João da Silva", "123.456.789-00");
        Equipamento equipamento = new Equipamento("TV", 100.00);
        LocalDate dataInicioDoAluguel = LocalDate.now();
        LocalDate dataTerminoDoAluguel = dataInicioDoAluguel.minusDays(1);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Aluguel aluguel = new Aluguel(cliente, equipamento, 1, dataInicioDoAluguel, dataTerminoDoAluguel);
        });
    }
}
