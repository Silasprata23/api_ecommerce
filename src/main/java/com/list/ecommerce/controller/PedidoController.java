package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.PedidoResponse;
import com.list.ecommerce.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/Pedido")
public class PedidoController {

    private final PedidoService pedidoService;


    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping(value = "/BuscarPedido{id}")
    public ResponseEntity<PedidoResponse> buscarPedido(@PathVariable Integer id){
        PedidoResponse response = pedidoService.buscarPedidos(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/Deletar{id}")
    public void deletarPedido(@PathVariable Integer id){
        pedidoService.deletarPedido(id);
    }


}
