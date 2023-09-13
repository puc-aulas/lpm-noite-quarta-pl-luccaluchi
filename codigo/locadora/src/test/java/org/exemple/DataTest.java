package org.exemple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DataTest {

    @Test
    public void deveAdicionarEquipamentoCorretamente() {
        Equipamento equipamento = new Equipamento("Equipamento teste", "Descrição teste", 10, 1);

        Data.addEquipamento(equipamento);

        Assertions.assertEquals(4, Data.equipamentos.size());
        Assertions.assertEquals("Equipamento teste", Data.equipamentos.get(3).getNome());
    }

    @Test
    public void deveAdicionarClienteCorretamente() {
        Cliente cliente = new Cliente("Cliente teste");

        Data.addCliente(cliente);

        Assertions.assertEquals(4, Data.clientes.size());
        Assertions.assertEquals("Cliente teste", Data.clientes.get(3).getNome());
    }

    @Test
    public void deveAdicionarAluguelCorretamente() {
        Aluguel aluguel = new Aluguel(new Cliente("Cliente teste"), new Equipamento("Equipamento teste"), 1, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 2));

        Data.addAluguel(aluguel);

        Assertions.assertEquals(4, Data.alugueis.size());
        Assertions.assertEquals(new Aluguel(new Cliente("Cliente teste"), new Equipamento("Equipamento teste"), 1, LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 2)), Data.alugueis.get(3));
    }

    @Test
    public void deveAtualizarQuantidadeDeEquipamentoCorretamente() {
        Equipamento equipamento = new Equipamento("Equipamento teste", "Descrição teste", 10, 1);

        Data.addEquipamento(equipamento);

        Data.atualizarQuantidade(equipamento.getIdEquipamento(), 2);

        Assertions.assertEquals(2, equipamento.getQuantidade());
    }
}
