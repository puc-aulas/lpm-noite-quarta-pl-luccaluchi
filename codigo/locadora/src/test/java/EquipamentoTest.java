import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.locadora.Equipamento;

public class EquipamentoTest {

// Teste para verificar se o equipamento está sendo criado com os dados corretos.  
    @Test
    public void deveCriarUmEquipamentoComDadosCorretos() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        assertEquals("TV", equipamento.getTipo());
        assertEquals("Descrição da TV", equipamento.getDescricao());
        assertEquals(100.00, equipamento.getValorDiaria(), 0.001);
        assertEquals(1, equipamento.getQuantidade());
    }

// Teste para verificar se o método de adicionar equipamentos está atendendo a restrição de não permitir valores negativos na quantidade
// de equipamentos.
    @Test
    public void deveLancarExcecaoSeQuantidadeForNegativa() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Equipamento("TV", "Descrição da TV", 100.00, -1);
        });
    }

// Teste para verificar se o método de verificar se há equipamentos suficientes para realizar o aluguel está funcionando corretamente
// retornando true se sim.
    @Test
    public void deveRetornarVerdadeiroSeHaviaQuantidadeSuficiente() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 10);

        assertTrue(equipamento.verificarDisponibilidade(1));
    }

// Teste para verificar se o método de verificar se há equipamentos suficientes para realizar o aluguel. Retorna 
// false se não.
    @Test
    public void deveRetornarFalsoSeNaoHaviaQuantidadeSuficiente() {
        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        assertFalse(equipamento.verificarDisponibilidade(2));
    }

// Teste para validar se a descrição de um equipamento está atendendo a restrição de ter no mínimo 5 caracteres. Retorna exceção se não.
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
