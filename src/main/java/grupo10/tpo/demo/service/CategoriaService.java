package grupo10.tpo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import grupo10.tpo.demo.model.Categoria;
import grupo10.tpo.demo.model.Producto;
import grupo10.tpo.demo.repository.CategoriaRepository;

@Service

public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();   
    }

    public Categoria getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));

        for(Producto p : categoriaRepository.findById(id).orElseThrow(() -> new RuntimeException("Categoria no encontrada")).getProductos()) {
            p.getCategorias().remove(categoria);
        }

        categoriaRepository.delete(categoria);
    }
}
