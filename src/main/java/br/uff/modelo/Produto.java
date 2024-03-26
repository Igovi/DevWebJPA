package br.uff.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="produto")

public class Produto
{
    private Long id;
    private String nome;

    private String descricao;
    private double preco;

    private  int quantidade;
    private String imageUrl;

    // ********* Construtores *********

    public Produto()
    {
    }

    public Produto(String nome,
                   String descricao,
                   double preco,
                   int quantidade,
                   String imageUrl)
    {	this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imageUrl = imageUrl;
    }

    // ********* Métodos do Tipo Get *********

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="ID")
    public Long getId()
    {	return id;
    }
    @Column(name="NOME")
    public String getNome()
    {	return nome;
    }

    @Column(name="DESCRICAO")
    public String getDescricao()
    {	return descricao;
    }

    @Column(name="PRECO")
    public double getPreco()
    {	return preco;
    }

    @Column(name="QUANTIDADE")
    public int getQuantidade()
    {	return quantidade;
    }

    @Column(name="IMAGEURL")
    public String getImageUrl()
    {	return imageUrl;
    }

    // ********* Métodos do Tipo Set *********

    private void setId(Long id)
    {	this.id = id;
    }

    public void setNome(String nome)
    {	this.nome = nome;
    }

    public void setDescricao(String descricao)
    {	this.descricao = descricao;
    }

    public void setPreco(double preco)
    {	this.preco = preco;
    }

    public void setQuantidade(int quantidade)
    {	this.quantidade = quantidade;
    }
    public void setImageUrl(String imageUrl)
    {	this.imageUrl = imageUrl;
    }
}
