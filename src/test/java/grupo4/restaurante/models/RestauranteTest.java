package restaurante.src.test.java.grupo4.restaurante.models;
import static org.junit.Assert.*;
import org.junit.Test;

import restaurante.src.main.java.grupo4.restaurante.models.Cliente;
import restaurante.src.main.java.grupo4.restaurante.models.Restaurante;

public class RestauranteTest {

  @Test
  public void testCriarRequisicaoEAlocarMesa() {
    Restaurante restaurante = new Restaurante();

    Cliente cliente1 = new Cliente("João", 4);
    Cliente cliente2 = new Cliente("Maria", 6);
    Cliente cliente3 = new Cliente("Pedro", 2);

    // O restaurante é inicializado com 10 mesas de diferentes capacidades
    // Portanto, devemos ser capazes de alocar mesas para os clientes

    restaurante.criarRequisicao(cliente1);
    restaurante.criarRequisicao(cliente2);
    restaurante.criarRequisicao(cliente3);

    // Verifica se as mesas foram alocadas corretamente
    assertFalse(restaurante.filaEspera.contains(cliente1));
    assertFalse(restaurante.filaEspera.contains(cliente2));
    assertTrue(restaurante.filaEspera.contains(cliente3));

    assertNotNull(cliente1.getMesa());
    assertNotNull(cliente2.getMesa());
    assertNotNull(cliente3.getMesa());
	}
}