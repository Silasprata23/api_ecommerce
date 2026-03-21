package com.list.ecommerce.DTOs.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {


    private String nomeProduto;
    private String descricaoProduto;
    private double preco;
    private String imgUrl;



}
