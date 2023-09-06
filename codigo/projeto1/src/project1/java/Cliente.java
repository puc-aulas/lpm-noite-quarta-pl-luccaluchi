package project1.java;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int proximoId = 0;
    private int idCliente = 0;
    private String nome;

    private List<Aluguel> alugueisFeitos;

    public Cliente(String nome) {
        this.idCliente = proximoId++;
        this.nome = nome;
        alugueisFeitos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public List<Aluguel> getAlugueisFeitos() {
        return alugueisFeitos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAlugueisFeitos(List<Aluguel> alugueisFeitos) {
        this.alugueisFeitos = alugueisFeitos;
    }

    public void addAluguel(Aluguel newAluguel) {
        this.alugueisFeitos.add(newAluguel);
    }
}
