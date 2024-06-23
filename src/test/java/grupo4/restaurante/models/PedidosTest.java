import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PedidoTest {

    private Pedido pedido;

    @Test
    public void testAdicionarItem() {
        pedido.adicionarItem("item1", 2);
        Map<String, Integer> itens = pedido.getItens();
        assertEquals(1, itens.size());
        assertEquals(2, itens.get("item1"));
    }

    @Test
    public void testAdicionarItemNull() {
        assertThrows(NullPointerException.class, () -> pedido.adicionarItem(null, 2));
    }

    @Test
    public void testAdicionarItemQuantidadeZero() {
        assertThrows(IllegalArgumentException.class, () -> pedido.adicionarItem("item1", 0));
    }

    @Test
    public void testCalcularPreco() {
        pedido.adicionarItem("item1", 2);
        pedido.adicionarItem("item2", 3);
        double total = pedido.calcularPreco();
        assertEquals(50.0, total);
    }

    @Test
    public void testCalcularPrecoEmpty() {
        double total = pedido.calcularPreco();
        assertEquals(0.0, total);
    }
}
