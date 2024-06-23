package restaurante.src.test.java.grupo4.restaurante.models;

import org.junit.Test;
import static org.junit.Assert.*;

public class ProdutoTest {

    @Test
    public void testGetterSetter() {
        // Criando um objeto Produto
        Produto produto = new Produto("Moqueca de Palmito", 25.99, "Comida");

        // Testando os getters
        assertEquals("Moqueca de Palmito", produto.getNome());
        assertEquals(25.99, produto.getPreco(), 0.001); // Utilize o delta para comparação de doubles
        assertEquals("Comida", produto.getTipo());

        // Testando os setters
        produto.setNome("Strogonoff de Cogumelos");
        produto.setPreco(29.99);
        produto.setTipo("Comida");

        // Verificando se as alterações foram aplicadas corretamente
        assertEquals("Strogonoff de Cogumelos", produto.getNome());
        assertEquals(29.99, produto.getPreco(), 0.001); // Utilize o delta para comparação de doubles
        assertEquals("Comida", produto.getTipo());
    }
}