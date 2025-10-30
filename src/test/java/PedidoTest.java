import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    Pedido pedido;

    @BeforeEach
    public void setUp() {
        pedido = new Pedido("Cliente Teste");
    }

    @Test
    public void deveAprovarPagamentoPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.aprovarPagamento());
        assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveEntregarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void deveCancelarPedidoAguardandoPagamento() {
        pedido.setEstado(PedidoEstadoAguardandoPagamento.getInstance());
        assertTrue(pedido.cancelarPedido());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveAprovarPagamentoPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.aprovarPagamento());
    }

    @Test
    public void deveEnviarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.enviarPedido());
        assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        assertTrue(pedido.cancelarPedido());
        assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveAprovarPagamentoPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.aprovarPagamento());
    }

    @Test
    public void naoDeveEnviarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void deveEntregarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertTrue(pedido.entregarPedido());
        assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        assertFalse(pedido.cancelarPedido());
    }

    @Test
    public void naoDeveAprovarPagamentoPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.aprovarPagamento());
    }

    @Test
    public void naoDeveEnviarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveEntregarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        assertFalse(pedido.cancelarPedido());
    }

    @Test
    public void naoDeveAprovarPagamentoPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.aprovarPagamento());
    }

    @Test
    public void naoDeveEnviarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.enviarPedido());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.entregarPedido());
    }

    @Test
    public void naoDeveCancelarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        assertFalse(pedido.cancelarPedido());
    }
}
