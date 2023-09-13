package org.example;

import org.example.input.InputCliente;
import org.example.input.InputEquipamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {


    private static Boolean executa = Boolean.TRUE;


    public static void main(String[] args) {
        Data database = new Data();

        while (executa) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Adicionar equipamento");
            System.out.println("2. Adicionar cliente");
            System.out.println("3. Alugar equipamento");
            System.out.println("4. Listar alugueis por cliente");
            System.out.println("5. Listar equipamentos");
            System.out.println("6. Listar clientes");
            System.out.println("7. Sair");
            System.out.println("-> ");

            Scanner scanner = new Scanner(System.in);

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    InputEquipamento newInputEquipamento = new InputEquipamento();
                    database.addEquipamento(newInputEquipamento.getTipo(), newInputEquipamento.getDescricao(), newInputEquipamento.getValorDiaria(), newInputEquipamento.getQuantidade());
                    System.out.println("Equipamento cadastrado com sucesso!");
                    break;
                case 2:
                    InputCliente newInputCliente = new InputCliente();
                    database.addCliente(newInputCliente.getNome());
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("Aluguel criado com sucesso!");
                    break;
                case 4:
                    System.out.println("Case 4");
                    break;
                case 5:
                    listarEquipamentos();
                    break;
                case 6:
                    listarClientes();
                    break;
                case 7:
                    System.out.println("Encerrando o programa.");
                    executa = Boolean.FALSE;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }


    }



    public static void listarEquipamentos() {
        if (Data.equipamentos.isEmpty()) {
            System.out.println("Não há equipamentos cadastrados.");
            return;
        }
        System.out.println(" Lista de equipamentos: ");
        for (Equipamento equipamento : Data.equipamentos) {
            System.out.print("Id: " + equipamento.getIdEquipamento() + "\t|\t");
            System.out.print("Tipo: " + equipamento.getTipo() + "\t|\t");
            System.out.print("Valor da diária: " + equipamento.getValorDiaria() + "\t|\t");
            System.out.print("Quantidade: " + equipamento.getQuantidade() + "\t|\t");
            System.out.println("Descrição: " + equipamento.getDescricao());
        }
        System.out.println();
    }



    public static void listarClientes() {
        if (Data.clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        System.out.println(" Lista de clientes: ");
        for (Cliente cliente : Data.clientes) {
            System.out.print("Id: " + cliente.getIdCliente() + "\t|\t");
            System.out.println("Nome: " + cliente.getNome());
        }
        System.out.println();
    }

}
