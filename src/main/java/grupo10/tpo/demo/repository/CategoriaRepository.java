package grupo10.tpo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import grupo10.tpo.demo.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
