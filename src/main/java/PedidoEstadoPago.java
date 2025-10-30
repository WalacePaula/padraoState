public class PedidoEstadoPago extends PedidoEstado{
    private PedidoEstadoPago() {};
    private static PedidoEstadoPago instance = new PedidoEstadoPago();
    public static PedidoEstadoPago getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Pago";
    }

    @Override
    public boolean enviarPedido(Pedido pedido) {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        return true;
    }

    @Override
    public boolean cancelarPedido(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
