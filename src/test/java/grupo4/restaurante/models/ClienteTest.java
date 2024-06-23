package restaurante.src.test.java.grupo4.restaurante.models;
import org.junit.Test;

import restaurante.src.main.java.grupo4.restaurante.models.Cliente;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void testGetNumPessoas() {
        Cliente cliente = new Cliente("João", 4);
        assertEquals(4, cliente.getNumPessoas());
    }

    @Test
    public void testGetNome() {
        Cliente cliente = new Cliente("Maria", 2);
        assertEquals("Maria", cliente.getNome());
    }
}