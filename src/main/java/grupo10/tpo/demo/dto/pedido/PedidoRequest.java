package grupo10.tpo.demo.dto.pedido;

import java.util.List;

public class PedidoRequest {

    private Long usuarioId;
<<<<<<< HEAD
    private List<Long> productoIds;
=======
    private List<ItemPedidoRequest> items;
>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
    private String direccionEnvio;

    public PedidoRequest() {}

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

<<<<<<< HEAD
    public List<Long> getProductoIds() {
        return productoIds;
    }

    public void setProductoIds(List<Long> productoIds) {
        this.productoIds = productoIds;
=======
    public List<ItemPedidoRequest> getItems() {
        return items;
    }

    public void setItems(List<ItemPedidoRequest> items) {
        this.items = items;
>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
}