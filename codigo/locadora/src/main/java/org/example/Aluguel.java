package org.example;

import java.util.Date;

public class Aluguel {
    private static int proximoId = 1;
    private int idAluguel;
    private Cliente cliente;
    private Equipamento equipamento;
    private Date dataInicioDoAluguel;
    private Date dataTerminoDoAluguel;
    private double valorTotal;

    public Aluguel(Cliente cliente, Equipamento equipamento, Date dataInicioDoAluguel, Date dataTerminoDoAluguel) {
        this.idAluguel = proximoId;
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicioDoAluguel = dataInicioDoAluguel;
        this.dataTerminoDoAluguel = dataTerminoDoAluguel;
        this.valorTotal = calcularValorDoAluguel(dataInicioDoAluguel, dataTerminoDoAluguel);
        Aluguel.proximoId++;
    }

    public int calcularNumeroDeDias(Date dataInicioDoAluguel, Date dataTerminoDoAluguel) {
        long diferenca = dataTerminoDoAluguel.getTime() - dataInicioDoAluguel.getTime();
        if (diferenca < 0) {
            throw new IllegalArgumentException("A data de término do aluguel não pode ser anterior à data de início.");
        }
        return (int) (diferenca / (1000 * 60 * 60 * 24));
    }

     public double calcularValorDoAluguel(Date dataInicioDoAluguel, Date dataTerminoDoAluguel) {
         int numeroDeDias = calcularNumeroDeDias(dataInicioDoAluguel, dataTerminoDoAluguel);
         return numeroDeDias * equipamento.getValorDiaria();
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

    public Date getDataInicioDoAluguel() {
        return dataInicioDoAluguel;
    }

    public Date getDataTerminoDoAluguel() {
        return dataTerminoDoAluguel;
    }

    public double getValorTotal() {
        return valorTotal;
    }
}
