package grupo4.restaurante.models;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    private List<Mesa> mesas = new ArrayList<>();
    private List<RequisicaoMesa> filaEspera = new ArrayList<>();

    public Restaurante() {
    
        for (int i = 0; i < 4; i++) mesas.add(new Mesa(4));
        for (int i = 0; i < 4; i++) mesas.add(new Mesa(6));
        for (int i = 0; i < 2; i++) mesas.add(new Mesa(8));
    }

    public void criarRequisicao(Cliente cliente) {
        RequisicaoMesa requisicao = new RequisicaoMesa(cliente);
        filaEspera.add(requisicao);
        alocarMesa(requisicao);
    }

    public void alocarMesa(RequisicaoMesa requisicao) {
        Mesa mesaDisponivel = encontrarMesaDisponivel(requisicao.getCliente().getNumPessoas());
        if (mesaDisponivel != null) {
            mesaDisponivel.adicionarCliente(requisicao.getCliente());
            requisicao.setMesa(mesaDisponivel);
            filaEspera.remove(requisicao);
        }
       
    }

    public Mesa encontrarMesaDisponivel(int numPessoas) {
        for (Mesa mesa : mesas) {
            if (!mesa.isCheia() && mesa.assentosDisponiveis() >= numPessoas) {
                return mesa;
            }
        }
        return null;
    }
}
