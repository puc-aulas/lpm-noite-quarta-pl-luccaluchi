package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Registro {
    private List<Aluguel> alugueis = new ArrayList<Aluguel>();
    private List<Cliente> clientes = new ArrayList<Cliente>();
    private List<Equipamento>equipamentos =  new ArrayList<Equipamento>();
    Scanner s = new Scanner(System.in);


    public static void main(String[] args) throws Exception {

        //equipamentos.add(equipamento);

        
    }
    public Equipamento addEquipamento(){
        String tipo,  descricao;
        float valorDiaria;
        int quantidade, codigo;

        System.out.println("Código: ");
        codigo = s.nextInt();
        System.out.println("Tipo: ");
        tipo = s.nextLine();
        System.out.println("Descrição: ");
        descricao = s.nextLine();
        System.out.println("Valor da diária: ");
        valorDiaria = s.nextFloat();
        System.out.println("Quantidade: ");
        quantidade = s.nextInt();

        for(Equipamento equipamento : equipamentos) {
            if (equipamento.getCodigo() == codigo) {
                System.out.println("Código já existente");
                return null;
            }
        }

        codigo = this.equipamentos.size();

        return new Equipamento(codigo, tipo,descricao, valorDiaria, quantidade);
    }

    public Aluguel alugarEquipamento(){
        Cliente cliente;
        Equipamento equipamento;
        String dataInicioDoAluguel;
        String dataTerminoDoAluguel;

        System.out.println("Código do cliente: ");
        int codCliente = s.nextInt();
        for(Cliente buscaCliente : clientes) {
            if (buscaCliente.getIdCliente() == codCliente) {
                cliente = buscaCliente;
            }
        }
        System.out.println("Código do equipamento: ");
        int codEquipamento = s.nextInt();
        for(Equipamento buscaEquipamento : equipamentos) {
            if (buscaEquipamento.getCodigo() == codEquipamento) {
                equipamento = buscaEquipamento;
            }
        }
        System.out.println("Data de início(padrão dd/mm/aaaa): ");
        dataInicioDoAluguel = s.nextLine();
        System.out.println("Data de término(padrão dd/mm/aaaa): ");
        dataTerminoDoAluguel = s.nextLine();

        return new Aluguel(cliente, equipamento, dataInicioDoAluguel, dataTerminoDoAluguel);
    }

}
