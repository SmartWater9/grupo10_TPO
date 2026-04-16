package grupo10.tpo.demo.dto.usuario;

import grupo10.tpo.demo.model.enums.Sexo;

import java.time.LocalDate;

public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;
    private Sexo sexo;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String nombre, String email, LocalDate fechaNacimiento, Sexo sexo) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }
}