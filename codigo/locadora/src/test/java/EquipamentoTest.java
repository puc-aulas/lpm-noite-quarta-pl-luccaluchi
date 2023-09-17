import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.locadora.Equipamento;

public class EquipamentoTest {

    @Test
    public void deveCriarUmEquipamentoComDadosCorretos() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        assertEquals("TV", equipamento.getTipo());
        assertEquals("Descrição da TV", equipamento.getDescricao());
        assertEquals(100.00, equipamento.getValorDiaria(), 0.001);
        assertEquals(1, equipamento.getQuantidade());
    }

    @Test
    public void deveLancarExcecaoSeQuantidadeForNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Equipamento("TV", "Descrição da TV", 100.00, -1);
        });
    }

    @Test
    public void deveRetornarVerdadeiroSeHaviaQuantidadeSuficiente() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 10);

        assertTrue(equipamento.verificarDisponibilidade(1));
    }

    @Test
    public void deveRetornarFalsoSeNaoHaviaQuantidadeSuficiente() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        assertFalse(equipamento.verificarDisponibilidade(2));
    }

    @Test
    public void deveLancarExcecaoSeDescricaoTiverMenosDe5Caracteres() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Equipamento("TV", "1234", 100.00, 1);
        });

        String expectedMessage = "A descrição deve ter no mínimo 5 caracteres.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
