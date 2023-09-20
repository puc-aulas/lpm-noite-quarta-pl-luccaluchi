import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.locadora.Cliente;

public class ClienteTest {

// Teste para verificar se o cliene está sendo criado com o nome correto.
    @Test
    public void deveCriarUmClienteComNomeCorreto() {
        Cliente cliente = new Cliente("João da Silva");

        assertEquals("João da Silva", cliente.getNome());
    }

// Teste para verificar se o nome está vazio e lançar exceção se sim.
    @Test
    public void deveLancarExcecaoSeNomeForVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("");
        });
    }
}
