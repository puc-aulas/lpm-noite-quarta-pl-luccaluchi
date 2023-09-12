package org.example;

import org.example.input.InputEquipamento;

import java.util.ArrayList;
import java.util.List;

public class Registro {

    private static List<Aluguel> alugueis = new ArrayList<Aluguel>();
    private static List<Cliente> clientes = new ArrayList<Cliente>();
    private static List<Equipamento> equipamentos = new ArrayList<Equipamento>();


    public static void main(String[] args) {

        addEquipamento();
        addEquipamento();
        addEquipamento();
        listarEquipamentos();


    }

    public static void addEquipamento(){
        InputEquipamento newInput = new InputEquipamento();
        Equipamento equipamento = new Equipamento(newInput.getTipo(), newInput.getDescricao(), newInput.getValorDiaria(), newInput.getQuantidade());
        Registro.equipamentos.add(equipamento);
    }

    public static void listarEquipamentos() {
        if (equipamentos.isEmpty()) {
            System.out.println("Não há equipamentos cadastrados.");
            return;
        }
        System.out.println("Equipamentos: ");
        for (Equipamento equipamento : equipamentos) {
            System.out.print("Id: " + equipamento.getIdEquipamento() + "\t|\t");
            System.out.print("Tipo: " + equipamento.getTipo() + "\t|\t");
            System.out.print("Valor da diária: " + equipamento.getValorDiaria() + "\t|\t");
            System.out.print("Quantidade: " + equipamento.getQuantidade() + "\t|\t");
            System.out.println("Descrição: " + equipamento.getDescricao());
        }
        System.out.println();
    }

}
