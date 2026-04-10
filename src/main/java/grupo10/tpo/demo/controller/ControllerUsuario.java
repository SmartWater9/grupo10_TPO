package grupo10.tpo.demo.controller;

import grupo10.tpo.demo.dto.usuario.UsuarioRegistroRequest;
import grupo10.tpo.demo.dto.usuario.UsuarioResponse;
import grupo10.tpo.demo.model.Usuario;
import grupo10.tpo.demo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class ControllerUsuario {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Long id) {
        return usuarioService.getUser(id);
    }

    @PostMapping("/registro")
    public ResponseEntity<UsuarioResponse> registrarUsuario(@Valid @RequestBody UsuarioRegistroRequest request) {
        UsuarioResponse response = usuarioService.registrarUsuario(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}