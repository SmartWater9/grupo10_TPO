package grupo10.tpo.demo.repository;

<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
import org.springframework.data.jpa.repository.JpaRepository;
import grupo10.tpo.demo.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

<<<<<<< HEAD
    
=======
    List<Pedido> findByProductos_Id(Long productoId);
>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
}
