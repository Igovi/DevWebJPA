CREATE TABLE Produto (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nome VARCHAR(255) NOT NULL,
                         descricao TEXT,
                         preco DOUBLE NOT NULL,
                         quantidade INT NOT NULL,
                         imageUrl VARCHAR(255)
);

-- Criação da tabela Order
CREATE TABLE Pedido (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nomeCliente VARCHAR(255) NOT NULL,
                        emailCliente VARCHAR(255) NOT NULL,
                        precoTotal DOUBLE NOT NULL,
                        dataPedido DATE NOT NULL,
                        statusPedido VARCHAR(50) NOT NULL
);

-- Criação da tabela OrderItem
CREATE TABLE ItemPedido (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            pedidoId INT NOT NULL,
                            produtoId INT NOT NULL,
                            quantidade INT NOT NULL,
                            subtotal DOUBLE NOT NULL,
                            FOREIGN KEY (pedidoId) REFERENCES Pedido (id),
                            FOREIGN KEY (produtoId) REFERENCES Produto(id)
);

INSERT INTO Produto (nome, descricao, preco, quantidade, imageUrl) VALUES
                                                                       ('Kit de Sobrevivência Básico', 'Inclui água, comida enlatada, faca multiuso e kit de primeiros socorros.', 49.99, 100, 'https://example.com/kit_basico.jpg'),
                                                                       ('Rifle de Assalto AR-15', 'Rifle de assalto semi-automático, calibre 5.56mm, alta precisão e confiabilidade.', 999.99, 50, 'https://example.com/ar15.jpg'),
                                                                       ('Machado Tático', 'Machado multiuso com lâmina afiada, martelo e corda de sobrevivência integrada.', 39.99, 75, 'https://example.com/machado_tatico.jpg'),
                                                                       ('Kit de Primeiros Socorros Avançado', 'Inclui suprimentos médicos avançados para tratar ferimentos graves.', 79.99, 30, 'https://example.com/kit_primeiros_socorros.jpg');