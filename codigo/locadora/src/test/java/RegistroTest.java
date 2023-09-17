import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import com.locadora.Cliente;
import com.locadora.Equipamento;
import com.locadora.Registro;

public class RegistroTest {

    @Test
    public void throwCasoNaoExistaOEquipamento() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Registro sut = new Registro();
            sut.alugarEquipamento(1, 2, 1, "01/01/2021", "02/01/2021");
        });

        String expectedMessage = "Equipamento não encontrado.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void throwCasoNaoExistaOCliente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Registro sut = new Registro();
            Equipamento tesEquipamento = new Equipamento("Enxada", "Ferramenta para cavar", 10.00, 1);
            sut.addEquipamento(tesEquipamento);
            sut.alugarEquipamento(0, 1, 2, "01/01/2021", "02/01/2021");
        });

        String expectedMessage = "Cliente não encontrado.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void throwCasoNaoHajaQuantidadeSuficiente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Registro sut = new Registro();
            Equipamento tesEquipamento = new Equipamento("Enxada", "Ferramenta para cavar", 10.00, 1);
            sut.addEquipamento(tesEquipamento);
            Cliente tesCliente = new Cliente("João da Silva");
            sut.addCliente(tesCliente);
            sut.alugarEquipamento(0, 0, 2, "01/01/2021", "02/01/2021");
        });

        String expectedMessage = "Quantidade solicitada indisponível.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void throwCasoDataDeTerminoSejaAnteriorADataDeInicio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Registro sut = new Registro();
            Equipamento tesEquipamento = new Equipamento("Enxada", "Ferramenta para cavar", 10.00, 5);
            sut.addEquipamento(tesEquipamento);
            Cliente tesCliente = new Cliente("João da Silva");
            sut.addCliente(tesCliente);
            sut.alugarEquipamento(0, 0, 2, "01/01/2021", "02/01/2020");
        });

        String expectedMessage = "A data de término do aluguel não pode ser anterior à data de início.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void deveRealizarOAluguelCorretamente() {
        Registro sut = new Registro();
        Equipamento tesEquipamento = new Equipamento("Enxada", "Ferramenta para cavar", 10.00, 5);
        sut.addEquipamento(tesEquipamento);
        Cliente tesCliente = new Cliente("João da Silva");
        sut.addCliente(tesCliente);
        sut.alugarEquipamento(0, 0, 2, "01/01/2021", "02/01/2021");

        assertEquals(1, sut.alugueisDoMes(1, 2021).size());
        assertEquals(1, sut.alugueisPorIdCliente(0).size());
        assertEquals(3, sut.getEquipamentos().get(0).getQuantidade());
    }

    @Test
    public void deveListarApenasOsAlugueisDoCliente() {
        Registro sut = new Registro();

        Equipamento tesEquipamento = new Equipamento("Enxada", "Ferramenta para cavar", 10.00, 5);
        Equipamento tesEquipamento2 = new Equipamento("Martelo", "Ferramenta para bater", 10.00, 5);
        sut.addEquipamento(tesEquipamento);
        sut.addEquipamento(tesEquipamento2);

        Cliente tesCliente = new Cliente("João da Silva");
        Cliente tesCliente2 = new Cliente("Maria da Silva");
        sut.addCliente(tesCliente);
        sut.addCliente(tesCliente2);

        sut.alugarEquipamento(0, 0, 2, "01/01/2021", "02/01/2021");
        sut.alugarEquipamento(1, 0, 2, "01/01/2021", "02/01/2021");
        sut.alugarEquipamento(0, 1, 2, "01/01/2021", "02/01/2021");

        assertEquals(2, sut.alugueisPorIdCliente(0).size());
        assertEquals(1, sut.alugueisPorIdCliente(1).size());
    }

    @Test
    public void deveListarApenasOsAlugueisDoMesEFaturamento() {
        Registro sut = new Registro();

        Equipamento tesEquipamento = new Equipamento("Enxada", "Ferramenta para cavar", 10.00, 5);
        Equipamento tesEquipamento2 = new Equipamento("Martelo", "Ferramenta para bater", 10.00, 5);
        sut.addEquipamento(tesEquipamento);
        sut.addEquipamento(tesEquipamento2);

        Cliente tesCliente = new Cliente("João da Silva");
        Cliente tesCliente2 = new Cliente("Maria da Silva");
        sut.addCliente(tesCliente);
        sut.addCliente(tesCliente2);

        sut.alugarEquipamento(0, 0, 2, "01/01/2021", "02/01/2021");
        sut.alugarEquipamento(1, 0, 2, "01/01/2021", "02/01/2021");
        sut.alugarEquipamento(0, 1, 2, "01/01/2021", "02/01/2021");

        assertEquals(3, sut.alugueisDoMes(1, 2021).size());
        assertEquals(0, sut.alugueisDoMes(2, 2021).size());
        assertEquals(60.00, sut.getFaturamentoMensal(1, 2021), 0.001);
    }
}
