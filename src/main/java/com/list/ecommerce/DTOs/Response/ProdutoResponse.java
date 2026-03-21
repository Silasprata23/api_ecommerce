package com.list.ecommerce.DTOs.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {


    private long idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double preco;
    private String imgUrl;
}
