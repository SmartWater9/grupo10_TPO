package grupo10.tpo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo10.tpo.demo.model.Producto;
import grupo10.tpo.demo.repository.ProductoRepository;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class ProductoService {
 
    @Autowired
    private ProductoRepository productoRepository;
    
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminar(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("Producto no encontrado");
        }
        productoRepository.deleteById(id);
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }
    
    public List<Producto> getProductosByCategoriaId(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }


    public Producto descontarStock(Long id, int cantidad) {
        Producto producto = getProductoById(id);

        if (producto.getStock() < cantidad) {
            throw new RuntimeException("No hay suficiente stock disponible");
        }

        producto.setStock(producto.getStock() - cantidad);
        return save(producto);
    }
}
