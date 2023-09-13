package org.exemple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EquipamentoTest {

    @Test
    public void deveCriarUmEquipamentoComDadosCorretos() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        Assertions.assertEquals("TV", equipamento.getTipo());
        Assertions.assertEquals("Descrição da TV", equipamento.getDescricao());
        Assertions.assertEquals(100.00, equipamento.getValorDiaria());
        Assertions.assertEquals(1, equipamento.getQuantidade());
    }

    @Test
    public void deveLancarExcecaoSeQuantidadeForNegativa() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Equipamento("TV", "Descrição da TV", 100.00, -1);
        });
    }

    @Test
    public void deveRetornarVerdadeiroSeHaviaQuantidadeSuficiente() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 10);

        Assertions.assertTrue(equipamento.verificarDisponibilidade(1));
    }

    @Test
    public void deveRetornarFalsoSeNaoHaviaQuantidadeSuficiente() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        Assertions.assertFalse(equipamento.verificarDisponibilidade(2));
    }

}
