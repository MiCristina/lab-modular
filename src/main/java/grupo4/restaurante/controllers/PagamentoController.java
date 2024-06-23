package grupo4.restaurante.controllers;

import grupo4.restaurante.models.MetodoPagamento;
import grupo4.restaurante.models.Pagamento;
import grupo4.restaurante.repositories.PagamentoRepository;
import grupo4.restaurante.models.PagamentoReport;
import grupo4.restaurante.models.Report;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.parse;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

@AllArgsConstructor
@RestController
public class PagamentoController {

    private PagamentoRepository pagamentoRepository;

    @PostMapping("/pagamentos")
    public Pagamento createPagamento(@RequestBody Pagamento pagamento) {
        pagamento.setData(now());
        return pagamentoRepository.save(pagamento);
    }

    @GetMapping("/pagamentos")
    public Report getPagamentos(@RequestParam(required = false) String data, @RequestParam(required = false) MetodoPagamento metodoPagamento) {

        List<Pagamento> pagamentos = pagamentoRepository.findAll();
        List<Pagamento> filteredPagamentos = pagamentos.stream()
                .filter(p -> data == null || p.getData().toLocalDate().isEqual(parse(data, ofPattern("dd-MM-yyyy")).toLocalDate()))
                .filter(p -> metodoPagamento == null || p.getMetodo().equals(metodoPagamento))
                .collect(toList());

        double valorBrutoTotal = filteredPagamentos.stream()
                .map(Pagamento::getValor)
                .reduce(0.0, Double::sum);

        double valorLiquidoTotal = filteredPagamentos.stream()
                .map(Pagamento::calcularValorFinal)
                .reduce(0.0, Double::sum);

        filteredPagamentos.sort(comparing(Pagamento::getData));

        Report report = new Report();
        report.setValorBrutoTotal(valorBrutoTotal);
        report.setValorLiquidoTotal(valorLiquidoTotal);
        report.setPagamentos(new ArrayList<>());

        for (Pagamento pagamento : filteredPagamentos) {
            PagamentoReport pagamentoReport = new PagamentoReport(
                    pagamento.getValor(),
                    pagamento.getValor() - pagamento.calcularValorFinal(),
                    pagamento.getMetodo().name(),
                    pagamento.getData().format(ofPattern("dd-MM-yyyy")));
            report.getPagamentos().add(pagamentoReport);
        }
        return report;
    }
}
