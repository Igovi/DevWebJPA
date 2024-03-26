package br.uff.dao.impl;

import br.uff.dao.ProdutoDAO;
import br.uff.excecao.ProdutoNaoEncontradoExeception;
import br.uff.modelo.Produto;
import br.uff.util.FabricaDeEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class JPAProdutoDAO implements ProdutoDAO {
    public long inclui(Produto umProduto)
    {

	EntityManager em = FabricaDeEntityManager.criarEntityManager();
	EntityTransaction tx = em.getTransaction();;
    tx.begin();
	try
	{
        em.persist(umProduto);
        tx.commit();
		return umProduto.getId();
	}
	catch(RuntimeException e)
	{	if (tx != null)
		{
		}
		throw e;
	}
	finally
	{
    em.close();
	}
    }

    public Produto recuperaUmProduto(long id) throws ProdutoNaoEncontradoExeception
    {

	EntityManager em = null;

	try
		{
		em = FabricaDeEntityManager.criarEntityManager();

			Produto produto = em.find(Produto.class, id);
            if(produto == null)
			{	throw new ProdutoNaoEncontradoExeception("Produto não encontrado");
			}
		return produto;
	}
	finally
	{   em.close();
	}
    }

    public void altera(Produto umProduto) throws ProdutoNaoEncontradoExeception
    {
	EntityManager em = null;
	EntityTransaction tx = null;
	try
		{
			em = FabricaDeEntityManager.criarEntityManager();
			tx = em.getTransaction();
			tx.begin();
			Produto produto = em.find(Produto.class, umProduto.getId());
			if (produto != null) {
				produto.setNome((umProduto.getNome()));
				produto.setDescricao(umProduto.getDescricao());
				produto.setPreco(umProduto.getPreco());
				produto.setQuantidade(umProduto.getQuantidade());
				produto.setImageUrl(umProduto.getImageUrl());

				em.merge(produto);
				tx.commit();
			}

		}
		catch(RuntimeException e)
		{
			if (tx != null)
		    {   tx.rollback();
		    }
		    throw e;
		}
		finally
	{   em.close();
		}
    }

	public void exclui(long numero) throws ProdutoNaoEncontradoExeception
	{
		EntityManager em = FabricaDeEntityManager.criarEntityManager();
		EntityTransaction tx = em.getTransaction();;

		try
		{
			tx.begin();
			Produto produto = em.find(Produto.class, numero);


			if(produto == null)
			{	tx.rollback();
				throw new ProdutoNaoEncontradoExeception("Produto não encontrado");
			}
			em.remove(produto);
			tx.commit();
		}
		catch(RuntimeException e)
		{
			if (tx != null)
			{   tx.rollback();
			}
			throw e;
		}
		finally
		{   em.close();
		}
	}

    public List<Produto> recuperaProdutos()
    {
		EntityManager em = null;

		try
		{	em = FabricaDeEntityManager.criarEntityManager();
			TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
			List<Produto> produtos = query.getResultList();
			em.close();
			return produtos;
		}
		finally{

		}
    }
}
