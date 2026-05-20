package com.list.ecommerce.service;

import com.list.ecommerce.DTOs.Request.LoginRequest;
import com.list.ecommerce.DTOs.Request.UsuarioRequest;
import com.list.ecommerce.DTOs.Response.UsuarioResponse;
import com.list.ecommerce.entity.Usuario;
import com.list.ecommerce.enums.Role;
import com.list.ecommerce.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, AuthenticationManager authManager, JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authManager = authManager;
        this.jwtService = jwtService;
    }


    public String login(@RequestBody LoginRequest loginRequest){
    authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    loginRequest.getEmail(),
                    loginRequest.getSenha()
            )
    );
    return jwtService.gerarToken(loginRequest.getEmail());
    }





    public UsuarioResponse criarUsuario(UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuarioRequest.getEmail());
        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("Email ja registrado");
        }
        Usuario usuario = new Usuario();

        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setSenha(passwordEncoder.encode(usuarioRequest.getSenha()));
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setRoles(Role.ROLE_USER);
        usuario.setImgUrl(usuarioRequest.getImgUrl());

        usuarioRepository.save(usuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getImgUrl(),
                usuario.getPedidos()
        );
        return usuarioResponse;


    }
    public List<UsuarioResponse> listarTodosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getImgUrl(),
                usuario.getPedidos()
        )).toList();
    }

    public UsuarioResponse listarUsuarios(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getImgUrl(),
                usuario.getPedidos()
        );
    }

    public ResponseEntity<?> deletarUsuario(Integer id) {

     Usuario usuario =  usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
     usuarioRepository.delete(usuario);
        return null;
    }

    public UsuarioResponse atualizarUsuario(Integer id,UsuarioRequest usuarioRequest) {

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new RuntimeException("Usuario não encontrado"));
        usuario.setNome(usuarioRequest.getNome());
        usuario.setEmail(usuarioRequest.getEmail());
        usuario.setTelefone(usuarioRequest.getTelefone());
        usuario.setSenha(usuarioRequest.getSenha());
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getTelefone(),
                usuario.getEmail(),
                usuario.getImgUrl(),
                usuario.getPedidos()
        );
          return usuarioResponse;
    }

}
