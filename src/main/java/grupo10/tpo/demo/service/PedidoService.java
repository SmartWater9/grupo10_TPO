package grupo10.tpo.demo.service;

import grupo10.tpo.demo.dto.pedido.PedidoRequest;
import grupo10.tpo.demo.dto.pedido.PedidoResponse;
import grupo10.tpo.demo.model.Pedido;
import grupo10.tpo.demo.model.Producto;
import grupo10.tpo.demo.model.Usuario;
import grupo10.tpo.demo.repository.PedidoRepository;
import grupo10.tpo.demo.repository.ProductoRepository;
import grupo10.tpo.demo.repository.UsuarioRepository;
import grupo10.tpo.demo.exception.usuario.UsuarioNotFoundException;
import grupo10.tpo.demo.exception.producto.ProductoNotFoundException;

import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         UsuarioRepository usuarioRepository,
                         ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
        this.productoRepository = productoRepository;
    }

    public PedidoResponse crearPedido(PedidoRequest request) {

        Usuario usuario = usuarioRepository.findById(request.getUsuarioId())
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado"));

        List<Producto> productos = productoRepository.findAllById(request.getProductoIds());

        if (productos.size() != request.getProductoIds().size()) {
            throw new ProductoNotFoundException("Uno o más productos no existen");
        }

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setProductos(productos);
        pedido.setDireccionEnvio(request.getDireccionEnvio());
        pedido.setEstado("PENDIENTE");

        Pedido guardado = pedidoRepository.save(pedido);

        return toResponse(guardado);
    }

    public List<PedidoResponse> getAllPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public PedidoResponse getPedidoById(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        return toResponse(pedido);
    }

    public void eliminarPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        pedidoRepository.delete(pedido);
    }

    private PedidoResponse toResponse(Pedido pedido) {
        return new PedidoResponse(
                pedido.getId(),
                pedido.getUsuario().getId(),
                pedido.getProductos().stream().map(Producto::getId).toList(),
                pedido.getEstado(),
                pedido.getDireccionEnvio()
        );
    }
}