package grupo10.tpo.demo.service;

import grupo10.tpo.demo.dto.usuario.UsuarioRegistroRequest;
import grupo10.tpo.demo.dto.usuario.UsuarioResponse;
import grupo10.tpo.demo.exception.RecursosDuplicadosException;
import grupo10.tpo.demo.exception.usuario.UsuarioNotFoundException;
import grupo10.tpo.demo.model.Usuario;
import grupo10.tpo.demo.repository.UsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
            usuario.getId(),
            usuario.getNombre(),
            usuario.getEmail(),
            usuario.getFechaNacimiento(),
            usuario.getSexo()
        );
    }

    public List<UsuarioResponse> getAllUsuarios() {
    return usuarioRepository.findAll()
        .stream()
        .map(this::toResponse)
        .toList();
}

    public UsuarioResponse getUser(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuario no encontrado"));
        return toResponse(usuario);
    }

    public UsuarioResponse save(UsuarioRegistroRequest user) {
      if (usuarioRepository.existsByEmail(user.getEmail())) {
            throw new RecursosDuplicadosException("Ya existe un usuario con ese email");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(user.getNombre());
        usuario.setEmail(user.getEmail());
        usuario.setPassword(user.getPassword());
        usuario.setFechaNacimiento(user.getFechaNacimiento());
        usuario.setSexo(user.getSexo());
        
        Usuario guardado = usuarioRepository.save(usuario);
        return toResponse(guardado);

    }

    
    public UsuarioResponse registrarUsuario(UsuarioRegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RecursosDuplicadosException("Ya existe un usuario con ese email");
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
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}