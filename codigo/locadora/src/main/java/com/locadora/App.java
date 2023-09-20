package com.locadora;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.locadora.input.InputAluguel;
import com.locadora.input.InputCliente;
import com.locadora.input.InputEquipamento;

public class App {
    public static void main(String[] args) throws Exception {
        Registro locadora = new Registro();
        Scanner scanner = new Scanner(System.in);
        Boolean executa = Boolean.TRUE;

        while (executa) {
            System.out.println("Escolha uma operação:");
            System.out.println("0. Inserir dados iniciais");
            System.out.println("1. Adicionar equipamento");
            System.out.println("2. Adicionar cliente");
            System.out.println("3. Alugar equipamento");
            System.out.println("4. Listar alugueis por cliente");
            System.out.println("5. Listar alugueis por mês");
            System.out.println("6. Listar equipamentos");
            System.out.println("7. Listar clientes");
            System.out.println("8. Listar alugueis");
            // System.out.println("9. Modificar quantidade de um equipamento");
            // System.out.println("10. Sair");
            System.out.println("9. Rodar testes");
            System.out.println("10. Sair");
            System.out.println("-> ");

            int escolha = scanner.nextInt();

// Menu de opções para interação com o usuário
 
            switch (escolha) {
                case 0: // Inserir dados iniciais
                    insertInicialData(locadora);
                    break;
                case 1: // Adicionar equipamento
                    InputEquipamento newInputEquipamento = new InputEquipamento();
                    Equipamento equipamento = new Equipamento(newInputEquipamento.getTipo(),
                            newInputEquipamento.getDescricao(), newInputEquipamento.getValorDiaria(),
                            newInputEquipamento.getQuantidade());
                    locadora.addEquipamento(equipamento);
                    System.out.println("\nEquipamento cadastrado com sucesso!\n");
                    break;
                case 2: // Adicionar cliente
                    InputCliente newInputCliente = new InputCliente();
                    Cliente cliente = new Cliente(newInputCliente.getNome());
                    locadora.addCliente(cliente);
                    System.out.println("\nCliente cadastrado com sucesso!\n");
                    break;
                case 3: // Alugar equipamento
                    InputAluguel newInputAluguel = new InputAluguel();
                    try {
                        locadora.alugarEquipamento(newInputAluguel.getIdEquipamento(),
                                newInputAluguel.getIdCliente(), newInputAluguel.getQuantidade(),
                                newInputAluguel.getDataInicio(), newInputAluguel.getDataTermino());
                        System.out.println("\nAluguel realizado com sucesso!\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage() + "\n");
                    }
                    break;
                case 4: // Listar alugueis por cliente
                    try {
                        System.out.println("Digite o id do cliente: ");
                        int clienteId = scanner.nextInt();
                        listarAlugueisPorCliente(locadora.alugueisPorIdCliente(clienteId));
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage() + "\n");
                    }
                    break;
                case 5: // Listar alugueis por mês
                    System.out.print("Digite o mês (1 - 12): ");

                    try {
                        int mes = scanner.nextInt();
                        System.out.print("Digite o ano: ");
                        int ano = scanner.nextInt();
                        locadora.alugueisDoMes(mes, ano);
                        List<Aluguel> alugueisDoMes = locadora.alugueisDoMes(mes, ano);
                        for (Aluguel aluguel : alugueisDoMes) {
                            System.out.println(aluguel);
                        }
                        System.out
                                .println("\n\nFaturamento total: R$" +
                                        locadora.getFaturamentoMensal(mes, ano) + "\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage() + "\n");
                    }

                    break;
                case 6: // Listar equipamentos
                    System.out.println("\nEquipamentos cadastrados:");
                    for (Equipamento equipamentoCadastrado : locadora.getEquipamentos()) {
                        System.out.println(equipamentoCadastrado.show());
                    }
                    break;
                case 7: // Listar clientes
                    System.out.println("\nClientes cadastrados:");
                    for (Cliente clienteCadastrado : locadora.getClientes()) {
                        System.out.println(clienteCadastrado);
                    }
                    break;
                case 8: // Listar alugueis
                    System.out.println("\nAlugueis cadastrados:");
                    for (Aluguel aluguelCadastrado : locadora.getAlugueis()) {
                        System.out.println(aluguelCadastrado);
                    }
                    break;
                // case 9: // Modificar quantidade de um equipamento
                // InputAtualizaEquipamento inputAtualizaEquipamento = new
                // InputAtualizaEquipamento();
                // try {
                // locadora.atualizaQuantidadeEquipamento(inputAtualizaEquipamento.getIdEquipamento(),
                // inputAtualizaEquipamento.getQuantidade());
                // System.out.println("\nQuantidade atualizada com sucesso!\n");
                // } catch (IllegalArgumentException e) {
                // System.out.println("\n" + e.getMessage() + "\n");
                // }
                // break;
                case 9: // Rodar testes
                    System.out.println("Rodando testes...");
                    try {
                        executarUnitTests();
                    } catch (IOException e) {
                        System.out.println("Erro ao executar testes.");
                    }
                    break;
                case 10: // Sair
                    System.out.println("Encerrando o programa.");
                    executa = Boolean.FALSE;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    private static void executarUnitTests() throws IOException, InterruptedException {
        List<Process> processes = new ArrayList<>();

        // Lista de comandos para executar todos métodos de teste das classes
        String[] commands = {
                "mvn -Dtest=AluguelTest,ClienteTest,EquipamentoTest test",
                "mvn -Dtest=RegistroTest#throwCasoNaoExistaOEquipamento test",
                "mvn -Dtest=RegistroTest#throwCasoNaoExistaOCliente test",
                "mvn -Dtest=RegistroTest#throwCasoNaoHajaQuantidadeSuficiente test",
                "mvn -Dtest=RegistroTest#throwCasoDataDeTerminoSejaAnteriorADataDeInicio test",
                "mvn -Dtest=RegistroTest#deveRealizarOAluguelCorretamente test",
                "mvn -Dtest=RegistroTest#deveListarApenasOsAlugueisDoCliente test",
                "mvn -Dtest=RegistroTest#deveListarApenasOsAlugueisDoMesEFaturamento test"
        };

        // adiciona todos os processos na lista
        for (String command : commands) {
            Process process = Runtime.getRuntime().exec(command);
            processes.add(process);
        }

        // executa todos os processos e mostra o output (apenas resultados dos testes)
        for (Process process : processes) {
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            boolean printOutput = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("T E S T S")) {
                    // Start printing output from this point
                    printOutput = true;
                }

                if (printOutput) {
                    System.out.println(line);
                }
            }
        }
    }

    static void listarAlugueisPorCliente(List<Aluguel> alugueisDoCliente) {
        for (Aluguel aluguel : alugueisDoCliente) {
            System.out.println(aluguel);
        }
    }

    static void insertInicialData(Registro register) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/MM/yyyy");

        // Equipamentos - 5
        Equipamento equipamento1 = new Equipamento("Enxada", "Enxada para jardinagem", 10.0, 10);
        Equipamento equipamento2 = new Equipamento("Martelo", "Martelo para construção", 5.0, 10);
        Equipamento equipamento3 = new Equipamento("Furadeira", "Furadeira para construção", 20.0, 10);
        Equipamento equipamento4 = new Equipamento("Betoneira", "Betoneira para construção", 50.0, 10);
        Equipamento equipamento5 = new Equipamento("Escada", "Escada para construção", 15.0, 10);

        // Clientes - 5
        Cliente cliente1 = new Cliente("João da Silva");
        Cliente cliente2 = new Cliente("Maria da Silva");
        Cliente cliente3 = new Cliente("José da Silva");
        Cliente cliente4 = new Cliente("Pedro da Silva");
        Cliente cliente5 = new Cliente("Ana da Silva");

        // Alugueis - 15
        Aluguel aluguel1 = new Aluguel(cliente1, equipamento1, 1, LocalDate.parse("01/01/2021", formato),
                LocalDate.parse("02/01/2021", formato));
        Aluguel aluguel2 = new Aluguel(cliente2, equipamento2, 2, LocalDate.parse("01/01/2021", formato),
                LocalDate.parse("02/01/2021", formato));
        Aluguel aluguel3 = new Aluguel(cliente3, equipamento3, 3, LocalDate.parse("01/01/2021", formato),
                LocalDate.parse("02/01/2021", formato));
        Aluguel aluguel4 = new Aluguel(cliente4, equipamento4, 4, LocalDate.parse("01/01/2021", formato),
                LocalDate.parse("02/01/2021", formato));
        Aluguel aluguel5 = new Aluguel(cliente5, equipamento5, 5, LocalDate.parse("01/01/2021", formato),
                LocalDate.parse("02/01/2021", formato));
        Aluguel aluguel6 = new Aluguel(cliente1, equipamento1, 1, LocalDate.parse("01/02/2021", formato),
                LocalDate.parse("02/02/2021", formato));
        Aluguel aluguel7 = new Aluguel(cliente2, equipamento2, 2, LocalDate.parse("01/02/2021", formato),
                LocalDate.parse("02/02/2021", formato));
        Aluguel aluguel8 = new Aluguel(cliente3, equipamento3, 3, LocalDate.parse("01/02/2021", formato),
                LocalDate.parse("02/02/2021", formato));
        Aluguel aluguel9 = new Aluguel(cliente4, equipamento4, 4, LocalDate.parse("01/02/2021", formato),
                LocalDate.parse("02/02/2021", formato));
        Aluguel aluguel10 = new Aluguel(cliente5, equipamento5, 5, LocalDate.parse("01/02/2021", formato),
                LocalDate.parse("02/02/2021", formato));
        Aluguel aluguel11 = new Aluguel(cliente1, equipamento1, 1, LocalDate.parse("01/03/2021", formato),
                LocalDate.parse("02/03/2021", formato));
        Aluguel aluguel12 = new Aluguel(cliente2, equipamento2, 2, LocalDate.parse("01/03/2021", formato),
                LocalDate.parse("02/03/2021", formato));
        Aluguel aluguel13 = new Aluguel(cliente3, equipamento3, 3, LocalDate.parse("01/03/2021", formato),
                LocalDate.parse("02/03/2021", formato));
        Aluguel aluguel14 = new Aluguel(cliente4, equipamento4, 4, LocalDate.parse("01/03/2021", formato),
                LocalDate.parse("02/03/2021", formato));
        Aluguel aluguel15 = new Aluguel(cliente5, equipamento5, 5, LocalDate.parse("01/03/2021", formato),
                LocalDate.parse("02/03/2021", formato));

        register.addEquipamento(equipamento1);
        register.addEquipamento(equipamento2);
        register.addEquipamento(equipamento3);
        register.addEquipamento(equipamento4);
        register.addEquipamento(equipamento5);

        register.addCliente(cliente1);
        register.addCliente(cliente2);
        register.addCliente(cliente3);
        register.addCliente(cliente4);
        register.addCliente(cliente5);

        register.getAlugueis().add(aluguel1);
        register.getAlugueis().add(aluguel2);
        register.getAlugueis().add(aluguel3);
        register.getAlugueis().add(aluguel4);
        register.getAlugueis().add(aluguel5);
        register.getAlugueis().add(aluguel6);
        register.getAlugueis().add(aluguel7);
        register.getAlugueis().add(aluguel8);
        register.getAlugueis().add(aluguel9);
        register.getAlugueis().add(aluguel10);
        register.getAlugueis().add(aluguel11);
        register.getAlugueis().add(aluguel12);
        register.getAlugueis().add(aluguel13);
        register.getAlugueis().add(aluguel14);
        register.getAlugueis().add(aluguel15);

        System.out.println("*********************************************************");
        System.out.println("Dados iniciais inseridos com sucesso!");
        System.out.println("Foram inseridos 5 equipamentos, 5 clientes e 15 alugueis.");
        System.out.println("*********************************************************");
    }
}
