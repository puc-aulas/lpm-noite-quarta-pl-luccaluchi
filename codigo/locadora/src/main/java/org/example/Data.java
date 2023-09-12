package org.example;

import java.util.ArrayList;
import java.util.List;

public class Data {

public static List<Cliente> getDataClientes() {
        List<Cliente> dataClientes = new ArrayList<Cliente>();
        dataClientes.add(new Cliente("Cliente teste 01"));
        dataClientes.add(new Cliente("Cliente teste 02"));
        dataClientes.add(new Cliente("Cliente teste 03"));
        return dataClientes;
    }

    public static List<Equipamento> getDataEquipamentos() {
        List<Equipamento> dataEquipamentos = new ArrayList<Equipamento>();
        dataEquipamentos.add(new Equipamento("Teste 01", "Descrição 01", 1, 1));
        dataEquipamentos.add(new Equipamento("Teste 02", "Descrição 02", 2, 2));
        dataEquipamentos.add(new Equipamento("Teste 03", "Descrição 03", 3, 3));
        return dataEquipamentos;
    }

}
