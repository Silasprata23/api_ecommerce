package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.UsuarioRequest;
import com.list.ecommerce.DTOs.UsuarioResponse;
import com.list.ecommerce.entity.Usuario;
import com.list.ecommerce.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/Usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/criarUsuario")
    public ResponseEntity<?> criarUsuario(@RequestBody UsuarioRequest usuarioRequest){
        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioRequest));

    }


    @GetMapping(value = "/Listartodos")
    public List<UsuarioResponse> listarTodos(){
        return usuarioService.listarTodosUsuarios();
    }

    @GetMapping(value = "Listarpor{id}")
    public ResponseEntity<UsuarioResponse> buscarporid(@PathVariable Integer id){

        UsuarioResponse response = usuarioService.listarUsuarios(id);

        return ResponseEntity.ok(response);
    }
    @DeleteMapping(value = "/deletar{id}")
    public ResponseEntity<?> deletarPorid(@PathVariable Integer id){
        return usuarioService.deletarUsuario(id);
    }

    public ResponseEntity<UsuarioResponse> atualizarUsuario(@PathVariable Integer id,@RequestBody UsuarioRequest usuarioRequest){

      UsuarioResponse response = usuarioService.atualizarUsuario(id, usuarioRequest);

        return ResponseEntity.ok(response);

    }

    }











