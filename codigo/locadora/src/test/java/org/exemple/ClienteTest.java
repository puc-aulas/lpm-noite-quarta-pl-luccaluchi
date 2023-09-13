package org.exemple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    public void deveCriarUmClienteComNomeCorreto() {
        Cliente cliente = new Cliente("João da Silva");

        Assertions.assertEquals("João da Silva", cliente.getNome());
    }

    @Test
    public void deveLancarExcecaoSeNomeForVazio() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Cliente("");
        });
    }
}
