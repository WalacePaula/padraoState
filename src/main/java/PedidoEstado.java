public abstract class PedidoEstado {
    public abstract String getEstado();

    public boolean aprovarPagamento(Pedido pedido) {
        return false;
    }

    public boolean enviarPedido(Pedido pedido) {
        return false;
    }

    public boolean entregarPedido(Pedido pedido) {
        return false;
    }

    public boolean cancelarPedido(Pedido pedido) {
        return false;
    }
}
