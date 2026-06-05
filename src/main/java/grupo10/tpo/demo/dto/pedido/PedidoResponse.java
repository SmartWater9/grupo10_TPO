package grupo10.tpo.demo.dto.pedido;

import java.util.List;

public class PedidoResponse {

    private Long id;
    private Long usuarioId;
<<<<<<< HEAD
    private List<Long> productoIds;
=======
    private List<ItemPedidoResponse> items;
>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
    private String estado;
    private String direccionEnvio;

    public PedidoResponse() {}

<<<<<<< HEAD
    public PedidoResponse(Long id, Long usuarioId, List<Long> productoIds, String estado, String direccionEnvio) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.productoIds = productoIds;
=======
    public PedidoResponse(Long id, Long usuarioId, List<ItemPedidoResponse> items, String estado, String direccionEnvio) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.items = items;
>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
        this.estado = estado;
        this.direccionEnvio = direccionEnvio;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

<<<<<<< HEAD
    public List<Long> getProductoIds() {
        return productoIds;
=======
    public List<ItemPedidoResponse> getItems() {
        return items;
>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
    }

    public String getEstado() {
        return estado;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }
}