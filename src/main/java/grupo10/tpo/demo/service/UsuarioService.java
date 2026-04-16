package grupo10.tpo.demo.service;

import grupo10.tpo.demo.dto.usuario.AuthResponse;
import grupo10.tpo.demo.dto.usuario.UsuarioRegistroRequest;
import grupo10.tpo.demo.dto.usuario.UsuarioResponse;
import grupo10.tpo.demo.exception.RecursosDuplicadosException;
import grupo10.tpo.demo.exception.usuario.UsuarioNotFoundException;
import grupo10.tpo.demo.model.Usuario;
import grupo10.tpo.demo.model.enums.Rol;
import grupo10.tpo.demo.repository.UsuarioRepository;
import grupo10.tpo.demo.security.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder,
                          JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

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

    public AuthResponse registrarUsuario(UsuarioRegistroRequest request) {
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new RecursosDuplicadosException("Ya existe un usuario con ese email");
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(request.getNombre());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setFechaNacimiento(request.getFechaNacimiento());
        usuario.setSexo(request.getSexo());
        usuario.setRol(Rol.ROLE_USER);

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        String token = jwtService.generateToken(usuarioGuardado);

        return new AuthResponse(token, toResponse(usuarioGuardado));
    }

    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new UsuarioNotFoundException("Usuario no encontrado");
        }
        usuarioRepository.deleteById(id);
    }
}