package grupo4.restaurante.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MetodoPagamento metodo;

    private double valor;

    private LocalDateTime data;

    public Pagamento(double valor, MetodoPagamento metodo, LocalDateTime data) {
    }

    public double calcularValorFinal() {
        return valor - metodo.calcularDesconto(valor);
    }
}
