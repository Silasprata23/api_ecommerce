package com.list.ecommerce.DTOs.Request;

import com.list.ecommerce.enums.StatusDoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoRequest {

    private int cliente_id;
    private long idPedido;
    private Instant Momento;
    private StatusDoPedido status;

}
