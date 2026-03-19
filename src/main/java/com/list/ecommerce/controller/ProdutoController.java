package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.ProdutoRequest;
import com.list.ecommerce.DTOs.ProdutoResponse;
import com.list.ecommerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/Produto")
public class ProdutoController {

    private final ProdutoService produtoService;


    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping(value = "/criarProduto")
    public ResponseEntity<ProdutoResponse> criarProduto(Integer id, ProdutoRequest produtoRequest){
         ProdutoResponse response = produtoService.criarProduto(id, produtoRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/listarTodos")
    public List<ProdutoResponse> listarTodos(){
        return produtoService.listarProdutos();
    }


    @GetMapping(value = "/listarPor{id}")
    public ResponseEntity<ProdutoResponse> listarPorid (@PathVariable Integer id){
        ProdutoResponse response = produtoService.listarporId(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/deletar{id}")
    public void deletar(@PathVariable Integer id){
        produtoService.deletarProduto(id);
    }


    @PutMapping(value = "/atualizar{id}")
    public ResponseEntity<ProdutoResponse> atualizarproduto(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest){
        ProdutoResponse response = produtoService.atualizarProduto(id, produtoRequest);
        return ResponseEntity.ok(response);
    }
}
