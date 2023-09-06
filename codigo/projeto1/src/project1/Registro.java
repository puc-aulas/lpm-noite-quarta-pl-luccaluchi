package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {


    private List<Aluguel> alugueis = new ArrayList<Aluguel>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Equipamento> equipamentos = new ArrayList<Equipamento>();
    Scanner s = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Registro registro = new Registro();

        while (true) {
            Scanner s = new Scanner(System.in);

            System.out.println("Escolha uma operação:");
            System.out.println("1. Listar alugueis por cliente");
            System.out.println("2. Alugar equipamento");
            System.out.println("3. Adicionar cliente");
            System.out.println("4. Adicionar equipamento");
            System.out.println("5. Sair");

            int escolha = s.nextInt();

            switch (escolha) {
                case 1 -> registro.getAlugueisPorCliente();
                case 2 -> registro.alugueis.add(registro.alugarEquipamento());
                case 3 -> registro.clientes.add(registro.addCliente());
                case 4 -> registro.equipamentos.add(registro.addEquipamento());
                case 5 -> {
                    System.out.println("Encerrando o programa.");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

        public Cliente addCliente() {

            int idCliente = this.clientes.size() + 1;
            System.out.println("Cliente criado com o código: " + idCliente);
            return new Cliente(idCliente);
        }
        public Equipamento addEquipamento() {
            String tipo, descricao;
            float valorDiaria;
            int quantidade, codigo;

            System.out.println("Código: ");
            codigo = s.nextInt();
            s.nextLine();
            System.out.println("Tipo: ");
            tipo = s.nextLine();
            s.nextLine();
            System.out.println("Descrição: ");
            descricao = s.nextLine();
            s.nextLine();
            System.out.println("Valor da diária: ");
            valorDiaria = s.nextFloat();
            s.nextLine();
            System.out.println("Quantidade: ");
            quantidade = s.nextInt();
            s.nextLine();


            for (Equipamento equipamento : equipamentos) {
                if (equipamento.getCodigo() == codigo) {
                    System.out.println("Código já existente");
                    return null;
                }
            }

            codigo = this.equipamentos.size() + 1;

            return new Equipamento(codigo, tipo, descricao, valorDiaria, quantidade);
        }

        public Aluguel alugarEquipamento() {
            Cliente cliente = null;
            Equipamento equipamento = null;
            String dataInicioDoAluguel;
            String dataTerminoDoAluguel;
            List<Aluguel> alugueisFeitos = new ArrayList<>();


            System.out.println("Código do cliente: ");
            int codCliente = s.nextInt();
            for (Cliente buscaCliente : clientes) {
                if (buscaCliente.getIdCliente() == codCliente) {
                    cliente = buscaCliente;
                }
            }
            System.out.println("Código do equipamento: ");
            int codEquipamento = s.nextInt();
            for (Equipamento buscaEquipamento : equipamentos) {
                if (buscaEquipamento.getCodigo() == codEquipamento) {
                    equipamento = buscaEquipamento;
                }
            }
            System.out.println("Data de início(padrão dd/mm/aaaa): ");
            dataInicioDoAluguel = s.nextLine();
            s.nextLine();
            System.out.println("Data de término(padrão dd/mm/aaaa): ");
            dataTerminoDoAluguel = s.nextLine();
            s.nextLine();

            int id = alugueis.size() + 1;

            Aluguel novoAluguel = new Aluguel(id, cliente, equipamento, dataInicioDoAluguel, dataTerminoDoAluguel);

            alugueisFeitos.add(novoAluguel);

            cliente.setAlugueisFeitos(alugueisFeitos);

            return novoAluguel;
        }

        public void getAlugueisPorCliente() {

            System.out.println("Código do cliente: ");
            int codCliente = s.nextInt();
            for (Cliente clienteBuscado : clientes) {
                if (clienteBuscado.getIdCliente() == codCliente) {
                    List<Aluguel> alugueisFeitos = new ArrayList<>(clienteBuscado.getAlugueisFeitos());
                        for (Aluguel aluguel : alugueisFeitos){
                        System.out.println("Id: " + aluguel.getIdAluguel());
                        System.out.println("Início: " + aluguel.getDataInicioDoAluguel());
                        System.out.println("Término: " + aluguel.getDataTerminoDoAluguel());
                        System.out.println("Valor: " + aluguel.getValorTotal());
                    }
                }
            }

        }

    }

