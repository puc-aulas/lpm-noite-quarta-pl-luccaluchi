package project1;

import java.util.List;

public class Aluguel {
    
    private static int proximoId = 1;
    private int idAluguel;
    private Cliente cliente;
    private Equipamento equipamento;
    private String dataInicioDoAluguel;
    private String dataTerminoDoAluguel;
    private double valorTotal;

    public Aluguel(int id, Cliente cliente, Equipamento equipamento, String dataInicioDoAluguel, String dataTerminoDoAluguel) {
        this.idAluguel = id;
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.dataInicioDoAluguel = dataInicioDoAluguel;
        this.dataTerminoDoAluguel = dataTerminoDoAluguel;
        proximoId++;
    }

    public double calcularValorDoAluguel(List<Equipamento> equipamentos, int id){

        for(Equipamento equipamento : equipamentos)
            if( equipamento.getCodigo() == id ){
                return equipamento.getValorDiaria();
            }
        return 0;
    }

    public int getIdAluguel() {
        return idAluguel;
    }

    public void setIdALuguel(int idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public String getDataInicioDoAluguel() {
        return dataInicioDoAluguel;
    }

    public void setDataInicioDoAluguel(String dataInicioDoAluguel) {
        this.dataInicioDoAluguel = dataInicioDoAluguel;
    }

    public String getDataTerminoDoAluguel() {
        return dataTerminoDoAluguel;
    }

    public void setDataTerminoDoAluguel(String dataTerminoDoAluguel) {
        this.dataTerminoDoAluguel = dataTerminoDoAluguel;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    // public int calcularValorDoAluguel() {

    // }
}
