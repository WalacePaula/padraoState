public class PedidoEstadoAguardandoPagamento extends PedidoEstado{
    private PedidoEstadoAguardandoPagamento() {};
    private static PedidoEstadoAguardandoPagamento instance = new PedidoEstadoAguardandoPagamento();
    public static PedidoEstadoAguardandoPagamento getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Aguardando Pagamento";
    }

    @Override
    public boolean aprovarPagamento(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        return true;
    }

    @Override
    public boolean cancelarPedido(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}
