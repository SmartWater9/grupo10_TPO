package grupo10.tpo.demo.dto.pedido;

import java.util.List;

public class PedidoResponse {

    private Long id;
    private Long usuarioId;
    private List<Long> productoIds;
    private String estado;
    private String direccionEnvio;

    public PedidoResponse() {}

    public PedidoResponse(Long id, Long usuarioId, List<Long> productoIds, String estado, String direccionEnvio) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.productoIds = productoIds;
        this.estado = estado;
        this.direccionEnvio = direccionEnvio;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public List<Long> getProductoIds() {
        return productoIds;
    }

    public String getEstado() {
        return estado;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }
}