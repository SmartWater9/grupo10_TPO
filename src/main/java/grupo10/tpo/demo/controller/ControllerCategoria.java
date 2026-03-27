package grupo10.tpo.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import grupo10.tpo.demo.service.CategoriaService;

import grupo10.tpo.demo.model.Categoria;  


@RestController
@RequestMapping("/api/categorias")
public class ControllerCategoria {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String getAllCategorias() {
        return "Lista de categorias";
    }

    @GetMapping("/{id}")
    public String getCategoriaById(@PathVariable String id) {
        return "Categoria con ID: " + id;
    }

    @PostMapping
    public String crearCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria) + "Categoria creada: " + categoria.getNombre();
    }

    @DeleteMapping("/{id}")
    public Categoria eliminarCategoria(@PathVariable String id) {
        return categoriaService.eliminar(Long.parseLong(id));       
    }
}