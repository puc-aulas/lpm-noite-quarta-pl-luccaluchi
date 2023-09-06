package project1.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    private List<Aluguel> alugueis = new ArrayList<Aluguel>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Equipamento> equipamentos = new ArrayList<Equipamento>();
    private static Scanner s;

    Registro() {
        s = new Scanner(System.in);
    }

    public static void main(String[] args) throws Exception {
        Registro registro = new Registro();

        while (true) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Listar alugueis por cliente");
            System.out.println("2. Alugar equipamento");
            System.out.println("3. Adicionar cliente");
            System.out.println("4. Adicionar equipamento");
            System.out.println("5. Sair");
            System.out.println("-> ");

            int escolha = s.nextInt();

            switch (escolha) {
                case 1: // Listar alugueis por cliente
                    registro.getAlugueisPorCliente();
                    break;
                case 2: // Alugar equipamento
                    Aluguel novoAluguel = registro.alugarEquipamento();
                    registro.alugueis.add(novoAluguel);
                    System.out.println("Aluguel criado com sucesso!");
                    break;
                case 3: // Adicionar cliente
                    Cliente newCliente = registro.addCliente();
                    registro.clientes.add(newCliente);
                    System.out.println("Cliente criado com sucesso!");
                    break;
                case 4: // Adicionar equipamento
                    Equipamento newEquipamento = registro.addEquipamento();
                    registro.equipamentos.add(newEquipamento);
                    System.out.println("Equipamento criado com sucesso!");
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    s.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public Cliente addCliente() {
        System.out.println("Insira o nome do cliente: ");
        String nome;
        nome = s.nextLine();
        System.out.println("Cliente " + nome + " criado!");
        return new Cliente(nome);
    }

    public Equipamento addEquipamento() {
        String tipo, descricao;
        float valorDiaria;
        int quantidade;

        System.out.println("Tipo: ");
        tipo = s.nextLine();

        s.nextLine();

        do {
            System.out.println("Descrição: ");
            descricao = s.nextLine();

            if (descricao.length() < 5)
                System.out.println("Tamanho minimo é 5 caracteres");

        } while (descricao.length() < 5);

        s.nextLine();

        System.out.println("Valor da diária: ");
        valorDiaria = s.nextFloat();

        s.nextLine();

        System.out.println("Quantidade: ");
        quantidade = s.nextInt();
        s.nextLine();

        return new Equipamento(tipo, descricao, valorDiaria, quantidade);
    }

    public Aluguel alugarEquipamento() {
        Cliente cliente = null;
        Equipamento equipamento = null;
        String dataInicioDoAluguel;
        String dataTerminoDoAluguel;

        listarClientes();

        System.out.println("ID do cliente: ");
        int codCliente = s.nextInt();

        for (Cliente cl : this.clientes) {
            if (cl.getIdCliente() == codCliente) {
                cliente = cl;
            }
        }

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }

        listarEquipamentos();

        System.out.println("Código do equipamento: ");
        int codEquipamento = s.nextInt();
        for (Equipamento buscaEquipamento : equipamentos) {
            if (buscaEquipamento.getCodigo() == codEquipamento) {
                equipamento = buscaEquipamento;
            }
        }

        if (equipamento == null) {
            System.out.println("Equipamento não encontrado.");
            return null;
        }

        System.out.println("Data de início(padrão dd/mm/aaaa): ");
        dataInicioDoAluguel = s.nextLine();

        s.nextLine();

        System.out.println("Data de término(padrão dd/mm/aaaa): ");
        dataTerminoDoAluguel = s.nextLine();
        s.nextLine();

        Aluguel novoAluguel = new Aluguel(cliente, equipamento, dataInicioDoAluguel, dataTerminoDoAluguel);

        cliente.addAluguel(novoAluguel);

        return novoAluguel;
    }

    public void getAlugueisPorCliente() {
        if (clientes.size() < 0) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }

        this.listarClientes();

        System.out.println("Insira id do cliente: ");
        int codCliente = s.nextInt();

        for (Cliente clienteBuscado : clientes) {
            if (clienteBuscado.getIdCliente() == codCliente) {
                List<Aluguel> alugueisFeitos = new ArrayList<>(clienteBuscado.getAlugueisFeitos());
                for (Aluguel aluguel : alugueisFeitos) {
                    System.out.println("Id: " + aluguel.getIdAluguel());
                    System.out.println("Início: " + aluguel.getDataInicioDoAluguel());
                    System.out.println("Término: " + aluguel.getDataTerminoDoAluguel());
                    System.out.println("Valor: " + aluguel.getValorTotal());
                    System.out.println();
                }
                return;
            }
        }
        System.out.println("Cliente não encontrado.");
    }

    public void listarClientes() {
        if (clientes.size() == 0) {
            System.out.println("Não há clientes cadastrados.");
            return;
        }
        System.out.println("Clientes: ");
        for (Cliente cliente : clientes) {
            System.out.print("Id: " + cliente.getIdCliente() + "\t|\t");
            System.out.println("Nome: " + cliente.getNome());
        }
        System.out.println();
    }

    public void listarEquipamentos() {
        if (equipamentos.size() == 0) {
            System.out.println("Não há equipamentos cadastrados.");
            return;
        }
        System.out.println("Equipamentos: ");
        for (Equipamento equipamento : equipamentos) {
            System.out.print("Id: " + equipamento.getCodigo() + "\t|\t");
            System.out.print("Tipo: " + equipamento.getTipo() + "\t|\t");
            System.out.print("Valor da diária: " + equipamento.getValorDiaria() + "\t|\t");
            System.out.print("Quantidade: " + equipamento.getQuantidade() + "\t|\t");
            System.out.println("Descrição: " + equipamento.getDescricao());
        }
        System.out.println();
    }
}
