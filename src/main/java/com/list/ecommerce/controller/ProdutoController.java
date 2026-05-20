package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.Request.ProdutoRequest;
import com.list.ecommerce.DTOs.Response.ProdutoResponse;
import com.list.ecommerce.service.FotoService;
import com.list.ecommerce.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Produto")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final FotoService fotoService;

    public ProdutoController(ProdutoService produtoService, FotoService fotoService) {
        this.produtoService = produtoService;
        this.fotoService = fotoService;
    }

    @PostMapping(value = "/criarProduto")
    public ResponseEntity<?> criarProduto(@RequestParam String nomeProduto,
                                          @RequestParam String descricaoProduto,
                                          @RequestParam  double preco,
                                          @RequestParam MultipartFile imgUrl) throws IOException {

        String pathFoto = fotoService.saveFoto(imgUrl);

        ProdutoRequest produtoRequest = new ProdutoRequest(nomeProduto, descricaoProduto, preco, pathFoto);

        ProdutoResponse response = produtoService.criarProduto(produtoRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/listarTodosProduto")
    public List<ProdutoResponse> listarTodos(){
        return produtoService.listarProdutos();
    }


    @GetMapping(value = "/listarProdutoPor{id}")
    public ResponseEntity<ProdutoResponse> listarPorid (@PathVariable Integer id){
        ProdutoResponse response = produtoService.listarporId(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/deletarProduto{id}")
    public void deletar(@PathVariable Integer id){
        produtoService.deletarProduto(id);
    }


    @PutMapping(value = "/atualizarProduto{id}")
    public ResponseEntity<ProdutoResponse> atualizarproduto(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest){
        ProdutoResponse response = produtoService.atualizarProduto(id, produtoRequest);
        return ResponseEntity.ok(response);
    }
}
