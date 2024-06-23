package grupo4.restaurante.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoReport {
    private double valorPago;
    private double valorDescontado;
    private String metodoPagamento;
    private String dataPagamento;
}
