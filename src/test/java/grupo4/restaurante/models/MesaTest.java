package restaurante.src.test.java.grupo4.restaurante.models;
import static org.junit.Assert.*;
import org.junit.Test;

import restaurante.src.main.java.grupo4.restaurante.models.Cliente;
import restaurante.src.main.java.grupo4.restaurante.models.Mesa;

public class MesaTest {

    @Test
    public void testAdicionarCliente() {
        Mesa mesa = new Mesa(10);
        Cliente cliente1 = new Cliente("João", 4);
        Cliente cliente2 = new Cliente("Maria", 3);

        assertTrue(mesa.adicionarCliente(cliente1));
        assertTrue(mesa.adicionarCliente(cliente2));
        assertFalse(mesa.adicionarCliente(new Cliente("Pedro", 5))); // Não há espaço suficiente
    }

    @Test
    public void testRemoverCliente() {
        Mesa mesa = new Mesa(10);
        Cliente cliente1 = new Cliente("João", 4);
        Cliente cliente2 = new Cliente("Maria", 3);

        mesa.adicionarCliente(cliente1);
        mesa.adicionarCliente(cliente2);

        assertTrue(mesa.removerCliente(cliente1));
        assertFalse(mesa.removerCliente(new Cliente("Ana", 2))); // O cliente não está na mesa
    }

    @Test
    public void testIsCheia() {
        Mesa mesa = new Mesa(5);
        Cliente cliente1 = new Cliente("João", 3);
        Cliente cliente2 = new Cliente("Maria", 2);

        mesa.adicionarCliente(cliente1);
        mesa.adicionarCliente(cliente2);

        assertTrue(mesa.isCheia());

        mesa.removerCliente(cliente1);

        assertFalse(mesa.isCheia());
    }

    @Test
    public void testIsVazia() {
        Mesa mesa = new Mesa(5);
        assertTrue(mesa.isVazia());

        Cliente cliente = new Cliente("João", 3);
        mesa.adicionarCliente(cliente);

        assertFalse(mesa.isVazia());
    }

    @Test
    public void testAssentosDisponiveis() {
        Mesa mesa = new Mesa(10);
        assertEquals(10, mesa.assentosDisponiveis());

        Cliente cliente1 = new Cliente("João", 4);
        Cliente cliente2 = new Cliente("Maria", 3);

        mesa.adicionarCliente(cliente1);
        mesa.adicionarCliente(cliente2);

        assertEquals(3, mesa.assentosDisponiveis());
    }
}