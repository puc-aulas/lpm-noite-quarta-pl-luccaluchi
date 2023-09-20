import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;

import org.junit.Test;

import com.locadora.Aluguel;
import com.locadora.Cliente;
import com.locadora.Equipamento;

public class AluguelTest {

// Teste para verificar se o método calcular valor do aluguel está retornando o número de dias corretamente.
    @Test
    public void deveCalcularOValorDoAluguelCorretamente() {
        Cliente cliente = new Cliente("João da Silva");
        Equipamento equipamento = new Equipamento("Machado", "11111", 100.00, 50);
        LocalDate dataInicioDoAluguel = LocalDate.now();
        LocalDate dataTerminoDoAluguel = dataInicioDoAluguel.plusDays(2);

        int totalDeDias = (int) dataInicioDoAluguel.until(dataTerminoDoAluguel).getDays();

        Aluguel aluguel = new Aluguel(cliente, equipamento, 10, dataInicioDoAluguel, dataTerminoDoAluguel);

        double expectedTotal = totalDeDias * 100.00 * 10;
        assertEquals(expectedTotal, aluguel.getValorTotal(), 0.001);
    }

// Teste para verificar se a validação da data de término ser maior que a de início está funcionando corretamente.
    @Test
    public void deveLancarExcecaoSeADataDeTerminoForAnteriorADataDeInicio() {
        Cliente cliente = new Cliente("João da Silva");
        Equipamento equipamento = new Equipamento("TV", "11111", 100.00, 0);
        LocalDate dataInicioDoAluguel = LocalDate.now();
        LocalDate dataTerminoDoAluguel = dataInicioDoAluguel.minusDays(1);

        assertThrows(IllegalArgumentException.class, () -> {
            new Aluguel(cliente, equipamento, 1, dataInicioDoAluguel, dataTerminoDoAluguel);
        });
    }
}
