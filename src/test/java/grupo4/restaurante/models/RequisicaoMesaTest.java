package restaurante.src.test.java.grupo4.restaurante.models;
import static org.junit.Assert.*;
import org.junit.Test;

import restaurante.src.main.java.grupo4.restaurante.models.Cliente;
import restaurante.src.main.java.grupo4.restaurante.models.Mesa;
import restaurante.src.main.java.grupo4.restaurante.models.RequisicaoMesa;

import java.util.Date;

public class RequisicaoMesaTest {

    @Test
    public void testDataEntrada() {
        Cliente cliente = new Cliente("João", 4);
        RequisicaoMesa requisicao = new RequisicaoMesa(cliente);

        Date dataAtual = new Date();
        assertEquals(dataAtual, requisicao.getDataEntrada());
    }

    @Test
    public void testSetDataSaida() {
        Cliente cliente = new Cliente("Maria", 2);
        RequisicaoMesa requisicao = new RequisicaoMesa(cliente);

        Date dataSaida = new Date();
        requisicao.setDataSaida(dataSaida);

        assertEquals(dataSaida, requisicao.getDataSaida());
    }

    @Test
    public void testSetMesa() {
        Cliente cliente = new Cliente("Pedro", 3);
        RequisicaoMesa requisicao = new RequisicaoMesa(cliente);

        Mesa mesa = new Mesa(10);
        requisicao.setMesa(mesa);

        assertEquals(mesa, requisicao.getMesa());
    }

    @Test
    public void testGetCliente() {
        Cliente cliente = new Cliente("Ana", 2);
        RequisicaoMesa requisicao = new RequisicaoMesa(cliente);

        assertEquals(cliente, requisicao.getCliente());
    }
}