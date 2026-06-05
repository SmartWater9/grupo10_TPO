package grupo10.tpo.demo.model;

import grupo10.tpo.demo.model.enums.Rol;
import grupo10.tpo.demo.model.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "usuario")
public class Usuario  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nombre;

    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

<<<<<<< HEAD
    @NotNull
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

    @NotNull
=======
    @Column(nullable = false)
    private LocalDate fechaNacimiento;

>>>>>>> 83a4da560773229a5fb3417f7ef6f0c1fe98e8b7
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Rol rol;
}
