public class Pedido {
    private String cliente;
    private PedidoEstado estado;

    public Pedido(String cliente) {
        this.cliente = cliente;
        // O estado inicial de todo novo pedido é Aguardando Pagamento
        this.estado = PedidoEstadoAguardandoPagamento.getInstance();
    }

    // Getters e Setters
    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public PedidoEstado getEstado() {
        return estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public String getCliente() {
        return cliente;
    }

    // Métodos que delegam o comportamento para o estado atual
    public boolean aprovarPagamento() {
        return estado.aprovarPagamento(this);
    }

    public boolean enviarPedido() {
        return estado.enviarPedido(this);
    }

    public boolean entregarPedido() {
        return estado.entregarPedido(this);
    }

    public boolean cancelarPedido() {
        return estado.cancelarPedido(this);
    }
}
