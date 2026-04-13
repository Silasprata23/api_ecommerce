package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.Request.UsuarioRequest;
import com.list.ecommerce.DTOs.Response.UsuarioResponse;
import com.list.ecommerce.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/criarUsuario")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioRequest));

    }


    @GetMapping(value = "/ListartodosUsuario")
    public List<UsuarioResponse> listarTodos(){
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping(value = "ListarUsuariopor{id}")
    public ResponseEntity<UsuarioResponse> buscarporid(@PathVariable Integer id){

        UsuarioResponse response = usuarioService.listarUsuarios(id);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping(value = "/deletarUsuario{id}")
    public ResponseEntity<?> deletarPorid(@PathVariable Integer id){
        return usuarioService.deletarUsuario(id);
    }

    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable Integer id,@RequestBody UsuarioRequest usuarioRequest){

      UsuarioResponse response = usuarioService.atualizarUsuario(id, usuarioRequest);

        return ResponseEntity.ok(response);

    }

    }











