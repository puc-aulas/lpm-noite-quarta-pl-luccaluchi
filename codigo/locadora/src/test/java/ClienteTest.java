import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.locadora.Cliente;

public class ClienteTest {

    @Test
    public void deveCriarUmClienteComNomeCorreto() {
        Cliente cliente = new Cliente("João da Silva");

        assertEquals("João da Silva", cliente.getNome());
    }

    @Test
    public void deveLancarExcecaoSeNomeForVazio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("");
        });
    }
}
