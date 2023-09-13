package org.example;

import org.example.input.InputCliente;
import org.example.input.InputEquipamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Data {

    public static List<Aluguel> alugueis = new ArrayList<Aluguel>();
    public static List<Cliente> clientes = new ArrayList<Cliente>();
    public static List<Equipamento> equipamentos = new ArrayList<Equipamento>();


public void dadosIniciaisClientes() {
        clientes.add(new Cliente("Cliente teste 01"));
        clientes.add(new Cliente("Cliente teste 02"));
        clientes.add(new Cliente("Cliente teste 03"));

        equipamentos.add(new Equipamento("Teste 01", "Descrição 01", 10, 1));
        equipamentos.add(new Equipamento("Teste 02", "Descrição 02", 10, 1));
        equipamentos.add(new Equipamento("Teste 03", "Descrição 03", 10, 1));

        alugueis.add( new Aluguel(getCliente(1), getEquipamento(1), new Date(2021, 1, 1), new Date(2021, 1, 2)));
        alugueis.add( new Aluguel(getCliente(2), getEquipamento(2), new Date(2021, 1, 1), new Date(2021, 1, 3)));
        alugueis.add( new Aluguel(getCliente(3), getEquipamento(3), new Date(2021, 1, 1), new Date(2021, 1, 4)));
    }

    //Editar os add's
    public void addEquipamento(Equipamento equipamento) {
        Data.equipamentos.add(equipamento);
    }

    public void addCliente(Cliente cliente){
        Data.clientes.add(cliente);
    }

    public void addAluguel(Aluguel aluguel) {
        Data.alugueis.add(aluguel);
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
