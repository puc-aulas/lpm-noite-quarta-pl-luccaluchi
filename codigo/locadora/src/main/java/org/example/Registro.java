package org.example;

import org.example.input.InputCliente;
import org.example.input.InputEquipamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {

    private static List<Aluguel> alugueis = new ArrayList<Aluguel>();
    private static List<Cliente> clientes = new ArrayList<Cliente>();
    private static List<Equipamento> equipamentos = new ArrayList<Equipamento>();
    private static Boolean executa = Boolean.TRUE;


    public static void main(String[] args) {

        equipamentos.addAll(Data.getDataEquipamentos());
        clientes.addAll(Data.getDataClientes());


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
                    addEquipamento();
                    System.out.println("Equipamento cadastrado com sucesso!");
                    break;
                case 2:
                    addCliente();
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
        System.out.println(" Lista de equipamentos: ");
        for (Equipamento equipamento : equipamentos) {
            System.out.print("Id: " + equipamento.getIdEquipamento() + "\t|\t");
            System.out.print("Tipo: " + equipamento.getTipo() + "\t|\t");
            System.out.print("Valor da diária: " + equipamento.getValorDiaria() + "\t|\t");
            System.out.print("Quantidade: " + equipamento.getQuantidade() + "\t|\t");
            System.out.println("Descrição: " + equipamento.getDescricao());
        }
        System.out.println();
    }

    public static void addCliente(){
        InputCliente newInput = new InputCliente();
        Cliente cliente = new Cliente(newInput.getNome());
        Registro.clientes.add(cliente);
    }

    public static void listarClientes() {

        if (clientes.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        System.out.println(" Lista de clientes: ");
        for (Cliente cliente : clientes) {
            System.out.print("Id: " + cliente.getIdCliente() + "\t|\t");
            System.out.println("Nome: " + cliente.getNome());
        }
        System.out.println();
    }

}
