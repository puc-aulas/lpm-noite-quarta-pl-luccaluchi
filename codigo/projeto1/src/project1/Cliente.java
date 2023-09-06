package project1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    
    //private static int proximoId = 1;
    private int idCliente;
    private String nome;
    private List<Aluguel> alugueisFeitos = new ArrayList<>();

    public Cliente(int idCliente, String nome) {
        this.idCliente = idCliente;
        this.nome = nome;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public List<Aluguel> getAlugueisFeitos() {
        return alugueisFeitos;
    }

    public void setAlugueisFeitos(List<Aluguel> alugueisFeitos) {
        this.alugueisFeitos = alugueisFeitos;
    }

}
