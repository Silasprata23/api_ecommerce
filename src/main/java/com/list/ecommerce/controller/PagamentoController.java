package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.PagamentoRequest;
import com.list.ecommerce.DTOs.PagamentoResponse;
import com.list.ecommerce.service.PagamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/pagamento")
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

    public ResponseEntity<PagamentoResponse> buscarPedido(@PathVariable Integer id){
        PagamentoResponse response = pagamentoService.buscarPagamento(id);
        return ResponseEntity.ok(response);
    }
}
