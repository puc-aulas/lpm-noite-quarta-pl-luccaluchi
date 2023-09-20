package com.locadora;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Registro {
    private static int idGenerator = 0;
    private int idRegistro;

// Listas para armazenar os objetos criados(Aluguel, Cliente, Equipamento)
    private List<Aluguel> alugueis;
    private List<Cliente> clientes;
    private List<Equipamento> equipamentos;

    public Registro() {
        this.idRegistro = idGenerator++;
        this.alugueis = new ArrayList<Aluguel>();
        this.clientes = new ArrayList<Cliente>();
        this.equipamentos = new ArrayList<Equipamento>();
    }

// Método para alugar equipamentos, recebe o id de equipamento, id de cliente, quantidade, data de início e data de término
// do aluguel. Formata as datas para LocalDate, cria o aluguel e adiciona à lista de alugueis, atualiza a quantidade de equipamentos
    public Aluguel alugarEquipamento(int equipamentoId,
            int clienteId,
            int quantidade,
            String dataInicioString,
            String dataTerminoString) throws IllegalArgumentException {

        // Procura o equipamento na lista
        Equipamento equipamento = this.getEquipamento(equipamentoId);
        if (equipamento == null) {
            throw new IllegalArgumentException("Equipamento não encontrado.");
        }

        // Procura o cliente na lista
        Cliente cliente = this.getCliente(clienteId);
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }

        // Verifica se a quantidade solicitada está disponível
        if (!equipamento.verificarDisponibilidade(quantidade)) {
            throw new IllegalArgumentException("Quantidade solicitada indisponível.");
        }

        // string date to local date
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");
        LocalDate dataInicio = LocalDate.parse(dataInicioString, formato);
        LocalDate dataTermino = LocalDate.parse(dataTerminoString, formato);

        // Cria o aluguel
        Aluguel aluguel = new Aluguel(cliente, equipamento, quantidade, dataInicio, dataTermino);

        // Adiciona o aluguel à lista de alugueis
        this.alugueis.add(aluguel);

        // Atualiza a quantidade de equipamentos
        equipamento.modificarQuantidade(-quantidade);

        return aluguel;
    }

    public List<Equipamento> getEquipamentos() {
        return this.equipamentos;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public List<Aluguel> getAlugueis() {
        return this.alugueis;
    }

    public List<Aluguel> alugueisPorIdCliente(int idCliente) {
        List<Aluguel> alugueisPorIdCliente = new ArrayList<Aluguel>();

        for (Aluguel aluguel : this.alugueis) {
            if (aluguel.getCliente().getIdCliente() == idCliente) {
                alugueisPorIdCliente.add(aluguel);
            }
        }

        return alugueisPorIdCliente;
    }

    public List<Aluguel> alugueisDoMes(int mes, int ano) {
        List<Aluguel> alugueisDoMes = new ArrayList<Aluguel>();

        for (Aluguel aluguel : this.alugueis) {
            if (aluguel.getDataInicioDoAluguel().getMonthValue() == mes
                    && aluguel.getDataInicioDoAluguel().getYear() == ano) {
                alugueisDoMes.add(aluguel);
            }
        }

        return alugueisDoMes;
    }

    public void addEquipamento(Equipamento equipamento) {
        this.equipamentos.add(equipamento);
    }

    public void addCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    private Equipamento getEquipamento(int idEquipamento) {
        for (Equipamento equipamento : this.equipamentos) {
            if (equipamento.getIdEquipamento() == idEquipamento) {
                return equipamento;
            }
        }

        return null;
    }

    private Cliente getCliente(int idCliente) {
        for (Cliente cliente : this.clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }

        return null;
    }

    public double getFaturamentoMensal(int mes, int ano) {
        double faturamento = 0;

        for (Aluguel aluguel : this.alugueis) {
            if (aluguel.getDataInicioDoAluguel().getMonthValue() == mes &&
                    aluguel.getDataInicioDoAluguel().getYear() == ano) {
                faturamento += aluguel.getValorTotal();
            }
        }

        return faturamento;
    }

    public int getIdRegistro() {
        return idRegistro;
    }
}
