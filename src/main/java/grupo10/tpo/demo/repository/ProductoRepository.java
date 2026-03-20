package grupo10.tpo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import grupo10.tpo.demo.model.Producto;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    //findAll() ya está implementado por JpaRepository, no es necesario definirlo aquí
    // select * from productos
}
