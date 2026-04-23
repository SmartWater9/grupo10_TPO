package grupo10.tpo.demo.dto;

import lombok.Data;

@Data
public class CategoriaRequest {
    private String nombre;
    private Long categoriaPadreId;
    
}