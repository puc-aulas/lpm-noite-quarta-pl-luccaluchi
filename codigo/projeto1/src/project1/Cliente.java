package project1;

import java.util.List;

public class Cliente {
    
    //private static int proximoId = 1;
    private int idCliente = 0;
    private List<Aluguel> alugueisFeitos;

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
        //proximoId++;
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
