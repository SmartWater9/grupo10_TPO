package grupo10.tpo.demo.controller;

import grupo10.tpo.demo.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import grupo10.tpo.demo.dto.ProductoDTO;
import grupo10.tpo.demo.model.Producto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/productos")
public class ControllerProducto {
    
    @Autowired
    private ProductoService productoService;

    ControllerProducto(ProductoService productoService) {
        this.productoService = productoService;
    }

    // https://localhost:8080/api/productos -> ejecutar este método y devolver la lista de productos (en este caso, un string de ejemplo)
    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos(); // Reemplaza esto con la lógica real para obtener los productos";
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }
    
    @GetMapping("/categoria/{categoriaId}")
    public List<Producto> getProductosByCategoriaId(@PathVariable Long categoriaId) {
        return productoService.getProductosByCategoriaId(categoriaId); // Reemplaza esto con la lógica real para obtener los productos
    }
    
    @PostMapping
    public Producto crearProducto(@RequestBody ProductoDTO req) {
        return productoService.crearProductoConCategorias(req);
    }
    
}
