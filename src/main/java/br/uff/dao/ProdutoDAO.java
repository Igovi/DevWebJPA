package br.uff.dao;

import br.uff.excecao.ProdutoNaoEncontradoExeception;
import br.uff.modelo.Produto;

import java.util.List;

public interface ProdutoDAO {
    long inclui(Produto umProduto);
    void altera(Produto umProduto) throws ProdutoNaoEncontradoExeception;
    void exclui(long id) throws ProdutoNaoEncontradoExeception;
    Produto recuperaUmProduto(long numero) throws ProdutoNaoEncontradoExeception;
    List<Produto> recuperaProdutos();
}
