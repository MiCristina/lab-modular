package grupo4.restaurante.models;

import java.util.ArrayList;
import java.util.List;

public class Mesa {
    private int capacidade;
    private List<Cliente> clientes = new ArrayList<>();

    public Mesa(int capacidade) {
        this.capacidade = capacidade;
    }

    public boolean adicionarCliente(Cliente cliente) {
        if (!isCheia() && assentosDisponiveis() >= cliente.getNumPessoas()) {
            clientes.add(cliente);
            return true;
        }
        return false;
    }

    public boolean removerCliente(Cliente cliente) {
        return clientes.remove(cliente);
    }

    public boolean isCheia() {
        return assentosDisponiveis() == 0;
    }

    public boolean isVazia() {
        return clientes.isEmpty();
    }

    public int assentosDisponiveis() {
        int ocupados = 0;
        for (Cliente cliente : clientes) {
            ocupados += cliente.getNumPessoas();
        }
        return capacidade - ocupados;
    }

    
    public int getCapacidade() {
        return capacidade;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
