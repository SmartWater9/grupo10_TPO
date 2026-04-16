package grupo10.tpo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import grupo10.tpo.demo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByEmail(String email);
}