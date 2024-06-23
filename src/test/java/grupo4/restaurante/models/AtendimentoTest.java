package restaurante.src.test.java.grupo4.restaurante.models;
import org.junit.Test;

import restaurante.src.main.java.grupo4.restaurante.models.Atendimento;

import static org.junit.Assert.*;


class AtendimentoTest {

    @Mock
    private Mesa mesaMock;
    
    @Mock
    private Pedido pedidoMock;
    
    private Atendimento atendimento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        atendimento = new Atendimento(mesaMock);
        atendimento.setPedido(pedidoMock); // Injetando um Pedido mock no Atendimento
    }

    @Test
    void testFazerPedido() {
        String[] itens = {"Item1", "Item2"};
        int[] quantidades = {1, 2};
        
        atendimento.fazerPedido(itens, quantidades);

        // Verifica se o método adicionarItem é chamado com os argumentos corretos
        verify(pedidoMock, times(1)).adicionarItem(itens[0], quantidades[0]);
        verify(pedidoMock, times(1)).adicionarItem(itens[1], quantidades[1]);
    }

    @Test
    void testAdicionarItem() {
        String item = "Item1";
        int quantidade = 1;
        
        atendimento.adicionarItem(item, quantidade);

        // Verifica se o método adicionarItem é chamado com os argumentos corretos
        verify(pedidoMock).adicionarItem(item, quantidade);
    }

    @Test
    void testCalcularConta() {
        when(pedidoMock.calcularTotal()).thenReturn(100.0);

        double total = atendimento.calcularConta();

        assertEquals(100.0, total, "A conta calculada deve ser igual ao valor retornado pelo pedido.");
        verify(pedidoMock).calcularTotal(); // Verifica se o método calcularTotal foi chamado
    }

}
