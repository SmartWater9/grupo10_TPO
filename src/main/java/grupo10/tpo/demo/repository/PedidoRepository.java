package grupo10.tpo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import grupo10.tpo.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    
}
