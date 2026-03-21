package com.list.ecommerce.repository;

import com.list.ecommerce.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    Optional<Pedido> findPedidoByIdPedido(long idPedido);

}
