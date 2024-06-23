package grupo4.restaurante.repositories;

import grupo4.restaurante.models.Pagamento;
import grupo4.restaurante.models.MetodoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    List<Pagamento> findByDataBetween(LocalDateTime start, LocalDateTime end);
    List<Pagamento> findByMetodo(MetodoPagamento metodo);
    List<Pagamento> findByDataBetweenAndMetodo(LocalDateTime start, LocalDateTime end, MetodoPagamento metodo);
}
