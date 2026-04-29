-- =========================
-- CATEGORIAS
-- =========================


-- =========================
-- PRODUTOS
-- =========================
INSERT INTO produto (id_produto, descricao_produto, img_url, nome_produto, preco) VALUES
                                                                                      (1, 'Smartphone Android', 'img1.jpg', 'Celular Samsung A54', 1999.90),
                                                                                      (2, 'Notebook gamer', 'img2.jpg', 'Notebook Dell G15', 5599.00),
                                                                                      (3, 'Camiseta algodão', 'img3.jpg', 'Camiseta Básica', 49.90),
                                                                                      (4, 'Tênis esportivo', 'img4.jpg', 'Nike Air Zoom', 399.90),
                                                                                      (5, 'Livro de programação', 'img5.jpg', 'Java para Iniciantes', 89.90),
                                                                                      (6, 'Controle PS5', 'img6.jpg', 'DualSense', 349.90),
                                                                                      (7, 'Cadeira gamer', 'img7.jpg', 'Cadeira ThunderX3', 899.90),
                                                                                      (8, 'Bola de futebol', 'img8.jpg', 'Adidas Pro', 129.90),
                                                                                      (9, 'Smart TV 50"', 'img9.jpg', 'LG UHD 4K', 2799.90),
                                                                                      (10, 'Fone Bluetooth', 'img10.jpg', 'JBL Tune 510BT', 199.90);

-- =========================
-- RELAÇÃO PRODUTO-CATEGORIA
-- =========================
INSERT INTO tb_produto_categoria (produto_id, categoria_id) VALUES
                                                                (1, 1),
                                                                (2, 1),
                                                                (3, 2),
                                                                (4, 6),
                                                                (5, 3),
                                                                (6, 4),
                                                                (7, 1),
                                                                (8, 6),
                                                                (9, 1),
                                                                (10, 1);

-- =========================
-- USUÁRIOS
-- =========================
INSERT INTO usuario (id, email, nome, roles, senha, telefone) VALUES
                                                                  (1, 'admin@email.com', 'Admin', 'ROLE_ADMIN', '123456', '11999999999'),
                                                                  (2, 'joao@email.com', 'João Silva', 'ROLE_USER', '123456', '11988888888'),
                                                                  (3, 'maria@email.com', 'Maria Souza', 'ROLE_USER', '123456', '11977777777'),
                                                                  (4, 'carlos@email.com', 'Carlos Lima', 'ROLE_USER', '123456', '11966666666'),
                                                                  (5, 'ana@email.com', 'Ana Paula', 'ROLE_USER', '123456', '11955555555');

-- =========================
-- PEDIDOS
-- =========================
INSERT INTO pedido (id_pedido, momento_pedido, status, cliente_id) VALUES
                                                                       (1, NOW(), 'PENDENTE', 2),
                                                                       (2, NOW(), 'PAGO', 3),
                                                                       (3, NOW(), 'ENVIADO', 4),
                                                                       (4, NOW(), 'ENTREGUE', 5),
                                                                       (5, NOW(), 'CANCELADO', 2);

-- =========================
-- ITENS DO PEDIDO
-- =========================
INSERT INTO item_do_pedido (preco, quantidade, id_pedido, id_produto) VALUES
                                                                          (1999.90, 1, 1, 1),
                                                                          (49.90, 2, 1, 3),
                                                                          (5599.00, 1, 2, 2),
                                                                          (349.90, 1, 2, 6),
                                                                          (399.90, 1, 3, 4),
                                                                          (89.90, 1, 3, 5),
                                                                          (129.90, 3, 4, 8),
                                                                          (2799.90, 1, 4, 9),
                                                                          (199.90, 2, 5, 10),
                                                                          (49.90, 1, 5, 3);

-- =========================
-- PAGAMENTOS
-- =========================
INSERT INTO pagamento (pedido_id_pedido, momento_pagamento) VALUES
                                                                (2, NOW()),
                                                                (3, NOW()),
                                                                (4, NOW());