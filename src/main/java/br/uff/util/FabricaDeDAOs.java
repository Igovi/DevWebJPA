package br.uff.util;

import br.uff.dao.impl.JPAProdutoDAO;

public class FabricaDeDAOs {
    public static <T> T getDAO(Class<T> tipo)
    {
        return (T) new JPAProdutoDAO();
        // Permite que a gente investigue as classes no package "com.carlosribeiro.dao.impl"

        // Nesse momento a variável tipo estará valendo Produto.class
        // A linha abaixo verifica se no package "com.carlosribeiro.dao.impl"
        // existe uma classe subtipo de Produto.class.
        // Vai retornar um Set contendo a classe JPAProdutoDAO.

        // Não pode haver mais de uma classe nesse package que estenda ProdutoDAO
        // caso contrário a gente não saberia qual utilizar.

        // Retorna a classe JPAProdutoDAO na variável classe.

        // Instancia um objeto do tipo JPAProdutoDAO usando o construtor Padrão
    }
}
