package com.locadora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Aluguel {
    private static int proximoId = 1;
    private int idAluguel;
    private Cliente cliente;
    private Equipamento equipamento;
    private int quantidade;
    private LocalDate dataInicioDoAluguel;
    private LocalDate dataTerminoDoAluguel;
    private double valorTotal;

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

    public int calcularNumeroDeDias(LocalDate dataInicioDoAluguel, LocalDate dataTerminoDoAluguel) {
        long diferenca = ChronoUnit.DAYS.between(dataInicioDoAluguel, dataTerminoDoAluguel);
        if (diferenca < 0) {
            throw new IllegalArgumentException("A data de término do aluguel não pode ser anterior à data de início.");
        }
        return (int) diferenca;

    }

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
