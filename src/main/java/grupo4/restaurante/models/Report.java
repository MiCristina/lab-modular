package grupo4.restaurante.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Report {
    private double valorBrutoTotal;
    private double valorLiquidoTotal;
    private List<PagamentoReport> pagamentos;
}
