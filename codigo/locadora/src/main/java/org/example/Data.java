package org.example;

import org.example.input.InputCliente;
import org.example.input.InputEquipamento;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static List<Aluguel> alugueis = new ArrayList<Aluguel>();
    public static List<Cliente> clientes = new ArrayList<Cliente>();
    public static List<Equipamento> equipamentos = new ArrayList<Equipamento>();


public void dadosIniciaisClientes() {
        List<Cliente> dataClientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("Cliente teste 01"));
        clientes.add(new Cliente("Cliente teste 02"));
        clientes.add(new Cliente("Cliente teste 03"));
    }

    public void dadosIniciaisEquipametos() {
        equipamentos.add(new Equipamento("Teste 01", "Descrição 01", 1, 1));
        equipamentos.add(new Equipamento("Teste 02", "Descrição 02", 2, 2));
        equipamentos.add(new Equipamento("Teste 03", "Descrição 03", 3, 3));
    }

    public void addEquipamento(String tipo, String descricao, double valorDiaria, int quantidade) {
        Equipamento equipamento = new Equipamento(tipo, descricao, valorDiaria, quantidade);
        Data.equipamentos.add(equipamento);
    }
    public void addAluguel(Cliente cliente, Equipamento equipamento, int quantidade, int dias) {
        Aluguel aluguel = new Aluguel(cliente, equipamento, quantidade, dias);
        Data.alugueis.add(aluguel);
    }

    public void addCliente(String nome){
        Cliente cliente = new Cliente(nome);
        Data.clientes.add(cliente);
    }

    public Cliente getCliente(int idCliente) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    public Equipamento getEquipamento(int idEquipamento) {
        for (Equipamento equipamento : equipamentos) {
            if (equipamento.getIdEquipamento() == idEquipamento) {
                return equipamento;
            }
        }
        return null;
    }



}
