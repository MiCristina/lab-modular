package grupo4.restaurante.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Atendimento {
    private Mesa mesa;
    private Pedido pedido;
    private Pagamento pagamento;

    public Atendimento(Mesa mesa) {
        this.mesa = mesa;
        this.pedido = new Pedido();
    }

    public void fazerPedido(List<String> itens, List<Integer> quantidades) {
        if (itens.size() != quantidades.size()) {
            throw new IllegalArgumentException("Itens e quantidades devem ter o mesmo tamanho");
        }
        for (int i = 0; i < itens.size(); i++) {
            pedido.adicionarItem(itens.get(i), quantidades.get(i));
        }
    }

    public void adicionarItem(String item, int quantidade) {
        pedido.adicionarItem(item, quantidade);
    }

    public double calcularConta(Map<String, Double> precos) {
        double total = pedido.calcularTotal(precos);
        return total + total * 0.10; // Inclui a taxa de serviço de 10%
    }

    public void registrarPagamento(double valor, MetodoPagamento metodo, LocalDateTime data) {
        pagamento = new Pagamento(valor, metodo, data);
    }

    public double calcularValorDividido(Map<String, Double> precos) {
        double total = calcularConta(precos);
        int numClientes = mesa.getClientes().size();
        return total / numClientes;
    }

    
    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
