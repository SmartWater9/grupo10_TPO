package grupo10.tpo.demo.service;

import grupo10.tpo.demo.dto.usuario.UsuarioRegistroRequest;
import grupo10.tpo.demo.dto.usuario.UsuarioResponse;
import grupo10.tpo.demo.model.Usuario;
import grupo10.tpo.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUser(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    
    public UsuarioResponse registrarUsuario(UsuarioRegistroRequest request) {

        
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Ya existe un usuario con ese email");
        }

        
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());
        usuario.setFechaNacimiento(request.getFechaNacimiento());
        usuario.setSexo(request.getSexo());

        
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        
        return new UsuarioResponse(
                usuarioGuardado.getId(),
                usuarioGuardado.getNombre(),
                usuarioGuardado.getEmail(),
                usuarioGuardado.getFechaNacimiento(),
                usuarioGuardado.getSexo()
        );
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}