package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.Request.PagamentoRequest;
import com.list.ecommerce.DTOs.Response.PagamentoResponse;
import com.list.ecommerce.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {


    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping(value = "/criarpagamento")
    public ResponseEntity<PagamentoResponse> criarPagamento(Integer id, PagamentoRequest pagamentoRequest){
        PagamentoResponse response = pagamentoService.criarPagamento(id, pagamentoRequest);
        return ResponseEntity.ok(response);

    }
    @GetMapping(value = "/buscarpedidoPor{id}")
    public ResponseEntity<PagamentoResponse> buscarPedido(@PathVariable Integer id){
        PagamentoResponse response = pagamentoService.buscarPagamento(id);
        return ResponseEntity.ok(response);
    }
}
