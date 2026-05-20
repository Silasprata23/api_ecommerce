package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.Request.LoginRequest;
import com.list.ecommerce.DTOs.Request.UsuarioRequest;
import com.list.ecommerce.DTOs.Response.UsuarioResponse;
import com.list.ecommerce.service.FotoService;
import com.list.ecommerce.service.JwtService;
import com.list.ecommerce.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final FotoService fotoService;

    public UsuarioController(UsuarioService usuarioService, FotoService fotoService) {
        this.usuarioService = usuarioService;

        this.fotoService = fotoService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(usuarioService.login(loginRequest));
    }


    @PostMapping(value = "/criarUsuario")
    public ResponseEntity<?> criarUsuario(@RequestParam String nome,
                                          @RequestParam String email,
                                          @RequestParam String senha,
                                          @RequestParam String telefone,
                                          @RequestParam MultipartFile imgURl) throws IOException {
        String pathFoto = fotoService.saveFoto(imgURl);

        UsuarioRequest usuarioRequest = new UsuarioRequest(nome, email, senha, telefone,pathFoto);

        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioRequest));

    }


    @GetMapping(value = "/ListartodosUsuario")
    public List<UsuarioResponse> listarTodos() {
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping(value = "ListarUsuariopor{id}")
    public ResponseEntity<UsuarioResponse> buscarporid(@PathVariable Integer id) {

        UsuarioResponse response = usuarioService.listarUsuarios(id);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/deletarUsuario{id}")
    public ResponseEntity<?> deletarPorid(@PathVariable Integer id) {
        return usuarioService.deletarUsuario(id);
    }

    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable Integer id, @RequestBody UsuarioRequest usuarioRequest) {

        UsuarioResponse response = usuarioService.atualizarUsuario(id, usuarioRequest);

        return ResponseEntity.ok(response);

    }

}











