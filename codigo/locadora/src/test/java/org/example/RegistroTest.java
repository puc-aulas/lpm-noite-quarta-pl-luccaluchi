package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistroTest {

    @Test
    public void deveAdicionarEquipamentoComSucesso() {
        Registro registro = new Registro();

        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 1);

        registro.addEquipamento(equipamento);

        Assertions.assertEquals(1, registro.getEquipamentos().size());
        Assertions.assertEquals("TV", registro.getEquipamentos().get(0).getTipo());
    }

    @Test
    public void deveAdicionarClienteComSucesso() {
        Registro registro = new Registro();

        Cliente cliente = new Cliente("Cliente teste");

        registro.addCliente(cliente);

        Assertions.assertEquals(1, registro.getClientes().size());
        Assertions.assertEquals("Cliente teste", registro.getClientes().get(0).getNome());
    }

    @Test
    public void deveAlugarEquipamentoComSucesso() throws Exception {
        Registro registro = new Registro();

        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 10);
        Cliente cliente = new Cliente("Cliente teste");

        registro.addEquipamento(equipamento);
        registro.addCliente(cliente);

        Aluguel aluguel = new Aluguel(cliente, equipamento, 1, LocalDate.now(), LocalDate.now().plusDays(2));

        registro.alugarEquipamento(aluguel);

        Assertions.assertEquals(1, registro.getAlugueis().size());
        Assertions.assertEquals(1, registro.getAlugueis().get(0).getQuantidade());
    }

    @Test
    public void deveListarAlugueisPorClienteComSucesso() throws Exception {
        Registro registro = new Registro();

        Equipamento equipamento = new Equipamento("TV", "Descrição da TV", 100.00, 10);
        Cliente cliente = new Cliente("Cliente teste");

        registro.addEquipamento(equipamento);
        registro.addCliente(cliente);

        Aluguel aluguel1 = new Aluguel(cliente, equipamento, 1, LocalDate.now(), LocalDate.now().plusDays(2));
        Aluguel aluguel2 = new Aluguel(cliente, equipamento, 2, LocalDate.now(), LocalDate.now().plusDays(4));

        registro.alugarEquipamento(aluguel1);
        registro.alugarEquipamento(aluguel2);

        List<Aluguel> alugueis = registro.listarAlugueisPorCliente(cliente.getIdCliente());

        Assertions.assertEquals(2, alugueis.size());
        Assertions.assertEquals(aluguel1.getIdAluguel(), alugueis.get(0).getIdAluguel());
        Assertions.assertEquals(aluguel2.getIdAluguel(), alugueis.get(1).getIdAluguel());
    }

}
