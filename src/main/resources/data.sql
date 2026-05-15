-- =========================================
-- POPULANDO TABELA USUARIO
-- =========================================

INSERT INTO usuario (nome, email, senha, telefone, roles) VALUES
                                                              ('João Silva', 'joao@gmail.com', '123456', '11999990001', 'ROLE_USER'),
                                                              ('Maria Oliveira', 'maria@gmail.com', '123456', '11999990002', 'ROLE_USER'),
                                                              ('Carlos Souza', 'carlos@gmail.com', '123456', '11999990003', 'ROLE_ADMIN'),
                                                              ('Ana Costa', 'ana@gmail.com', '123456', '11999990004', 'ROLE_USER');

-- =========================================
-- POPULANDO TABELA CATEGORIA
-- =========================================

INSERT INTO categoria (nome_categoria) VALUES
                                           ('Eletrônicos'),
                                           ('Informática'),
                                           ('Livros'),
                                           ('Games'),
                                           ('Periféricos');

-- =========================================
-- POPULANDO TABELA PRODUTO
-- =========================================

INSERT INTO produto (nome_produto, descricao_produto, img_url, preco) VALUES
                                                                          (
                                                                              'Notebook Dell',
                                                                              'Notebook Dell Inspiron i7 16GB RAM',
                                                                              'https://images.com/notebook-dell.jpg',
                                                                              4500.00
                                                                          ),
                                                                          (
                                                                              'Mouse Gamer',
                                                                              'Mouse RGB 7200 DPI',
                                                                              'https://images.com/mouse-gamer.jpg',
                                                                              150.00
                                                                          ),
                                                                          (
                                                                              'Teclado Mecânico',
                                                                              'Teclado mecânico RGB ABNT2',
                                                                              'https://images.com/teclado.jpg',
                                                                              350.00
                                                                          ),
                                                                          (
                                                                              'PlayStation 5',
                                                                              'Console Sony PlayStation 5',
                                                                              'https://images.com/ps5.jpg',
                                                                              4200.00
                                                                          ),
                                                                          (
                                                                              'Livro Clean Code',
                                                                              'Livro de boas práticas em programação',
                                                                              'https://images.com/clean-code.jpg',
                                                                              120.00
                                                                          );

-- =========================================
-- RELACIONAMENTO PRODUTO x CATEGORIA
-- =========================================

INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES
                                                                (1, 1),
                                                                (1, 2),
                                                                (2, 5),
                                                                (3, 5),
                                                                (4, 4),
                                                                (5, 3);

-- =========================================
-- POPULANDO TABELA PEDIDO
-- STATUS:
-- 0 = AGUARDANDO_PAGAMENTO
-- 1 = PAGO
-- 2 = ENVIADO
-- 3 = ENTREGUE
-- 4 = CANCELADO
-- =========================================

INSERT INTO pedido (momento_pedido, status, cliente_id) VALUES
                                                            ('2026-05-15 10:00:00', 1, 1),
                                                            ('2026-05-15 11:30:00', 0, 2),
                                                            ('2026-05-15 14:20:00', 2, 3);

-- =========================================
-- POPULANDO ITEM_DO_PEDIDO
-- =========================================

INSERT INTO item_do_pedido (id_pedido, id_produto, quantidade, preco) VALUES
                                                                          (1, 1, 1, 4500.00),
                                                                          (1, 2, 2, 150.00),

                                                                          (2, 5, 1, 120.00),

                                                                          (3, 4, 1, 4200.00),
                                                                          (3, 3, 1, 350.00);

-- =========================================
-- POPULANDO PAGAMENTO
-- =========================================

INSERT INTO pagamento (pedido_id_pedido, momento_pagamento) VALUES
                                                                (1, '2026-05-15 10:10:00'),
                                                                (3, '2026-05-15 14:35:00');