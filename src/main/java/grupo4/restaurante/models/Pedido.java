package grupo4.restaurante.models;

import java.util.Map;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class Pedido {

    private Map<String, Integer> itens;

    public Pedido() {
    }

    public Pedido(Map<String, Integer> itens) {
        this.itens = itens;
    }

    public void adicionarItem(String item, int quantidade) {
        Objects.requireNonNull(item, "Item não pode ser nulo");
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        itens.put(item, itens.getOrDefault(item, 0) + quantidade);
    }

    public double calcularTotal(Map<String, Double> precos) {
        double total = 0.0;

        for (Map.Entry<String, Integer> entrada : itens.entrySet()) {
            String item = entrada.getKey();
            int quantidade = entrada.getValue();
            double precoItem = precos.getOrDefault(item, 0.0);
            total += precoItem * quantidade;
        }

        return total;
    }

    public Map<String, Integer> getItens() {
        return itens;
    }

    public void setItens(Map<String, Integer> itens) {
        this.itens = itens;
    }
}
