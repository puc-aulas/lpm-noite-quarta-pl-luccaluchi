package com.locadora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Aluguel {
// Optou-se pelo uso da variável static para gerenciar o número dos ids para que os ids sejam sequenciais, náo se repitam 
// e sejam maior que zero.
    private static int proximoId = 1;
    private int idAluguel;
    private Cliente cliente;
    private Equipamento equipamento;
    private int quantidade;
    private LocalDate dataInicioDoAluguel;
    private LocalDate dataTerminoDoAluguel;
    private double valorTotal;

// Construtor da classe Aluguel, recebe como parâmetros um objeto Cliente, um objeto Equipamento, a quantidade de equipamentos
// a serem alugados, e as datas de aluguel. invoca o método calcularValorDoAluguel para calcular o valor total do aluguel e cria
// um aluguel com o gerado na variável static proximoId.
    public Aluguel(Cliente cliente, Equipamento equipamento, int quantidade, LocalDate dataInicioDoAluguel,
            LocalDate dataTerminoDoAluguel) {
        this.idAluguel = proximoId;
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.quantidade = quantidade;
        if (dataTerminoDoAluguel.isBefore(dataInicioDoAluguel)) {
            throw new IllegalArgumentException("A data de término do aluguel não pode ser anterior à data de início.");
        }
        this.dataInicioDoAluguel = dataInicioDoAluguel;
        this.dataTerminoDoAluguel = dataTerminoDoAluguel;
        this.valorTotal = calcularValorDoAluguel(dataInicioDoAluguel, dataTerminoDoAluguel);

        Aluguel.proximoId++;
    }

// Calcula diferença de dias entre duas datas e valida se o fim é início, caso não, retorna excessão, se sim, retorna um int com
// a diferença em dias.
    public int calcularNumeroDeDias(LocalDate dataInicioDoAluguel, LocalDate dataTerminoDoAluguel) {
        long diferenca = ChronoUnit.DAYS.between(dataInicioDoAluguel, dataTerminoDoAluguel);
        if (diferenca < 0) {
            throw new IllegalArgumentException("A data de término do aluguel não pode ser anterior à data de início.");
        }
        return (int) diferenca;

    }

// Recebe as datas de início e fim do aluguel, invoca o método de calcular e validar número de dias, invoca o método get para pegar o valor 
// da diária do equipamento instanciado na classe e multiplica pelo número de dias.
    public double calcularValorDoAluguel(LocalDate dataInicioDoAluguel, LocalDate dataTerminoDoAluguel) {
        int numeroDeDias = calcularNumeroDeDias(dataInicioDoAluguel, dataTerminoDoAluguel);
        return numeroDeDias * equipamento.getValorDiaria() * this.quantidade;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public LocalDate getDataInicioDoAluguel() {
        return dataInicioDoAluguel;
    }

    public LocalDate getDataTerminoDoAluguel() {
        return dataTerminoDoAluguel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public int getQuantidade() {
        return quantidade;
    }

// O método toString() é um método que retorna uma representação em String do objeto.
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataInicioDoAluguel = this.dataInicioDoAluguel.format(formatter);
        String dataTerminoDoAluguel = this.dataTerminoDoAluguel.format(formatter);

        String returnString = "Aluguel " + this.idAluguel;
        returnString += "\nCliente: " + this.cliente.getNome();
        returnString += "\nEquipamento: " + this.equipamento.getTipo();
        returnString += "\nQuantidade: " + this.quantidade;
        returnString += "\nData de início: " + dataInicioDoAluguel;
        returnString += "\nData de término: " + dataTerminoDoAluguel;
        returnString += "\nValor total: " + this.valorTotal;
        returnString += "\n====================\n";
        return returnString;
    }
}
