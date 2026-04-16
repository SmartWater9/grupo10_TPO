package grupo10.tpo.demo.controller;

import grupo10.tpo.demo.dto.ProductoRequest;
import grupo10.tpo.demo.dto.ProductoResponse;
import grupo10.tpo.demo.service.ProductoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<ProductoResponse> getAllProductos() {
        return productoService.getAllProductos();
    }

    @GetMapping("/{id}")
    public ProductoResponse getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @GetMapping("/categoria/{categoriaId}")
    public List<ProductoResponse> getProductosByCategoriaId(@PathVariable Long categoriaId) {
        return productoService.getProductosByCategoriaId(categoriaId);
    }

    @PostMapping
    public ProductoResponse crearProducto(@RequestBody ProductoRequest req) {
        return productoService.crearProductoConCategorias(req);
    }
}