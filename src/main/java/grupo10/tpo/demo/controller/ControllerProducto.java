package grupo10.tpo.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/productos")
public class ControllerProducto {
    
    // https://localhost:8080/api/productos -> ejecutar este método y devolver la lista de productos (en este caso, un string de ejemplo)
    @GetMapping
    public String getAllProductos() {
        return "Lista de productos";
    }

    @GetMapping("/{id}")
    public String getProductoById(@PathVariable String id) {
        return "Producto con ID: " + id;
    }
    
    @GetMapping("/{id}")
    public String getProductoByParam(@RequestParam String param) {
        return "Producto con param: " + param;
    }
    
    
}
