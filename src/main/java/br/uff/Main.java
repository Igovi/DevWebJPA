package br.uff;

import br.uff.dao.ProdutoDAO;
import br.uff.excecao.ProdutoNaoEncontradoExeception;
import br.uff.modelo.Produto;
import br.uff.util.FabricaDeDAOs;
import br.uff.util.Util;
import corejava.Console;

import java.security.Principal;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
        {


            String nome;
            String descricao;
            double preco;
            int quantidade;
            String imageUrl;
            Produto umProduto;

            ProdutoDAO produtoDAO = FabricaDeDAOs.getDAO(ProdutoDAO.class);

            boolean continua = true;
            while (continua)
            {	System.out.println('\n' + "O que você deseja fazer?");
                System.out.println('\n' + "1. Cadastrar um produto");
                System.out.println("2. Alterar um produto");
                System.out.println("3. Remover um produto");
                System.out.println("4. Listar todos os produtos");
                System.out.println("5. Sair");

                int opcao = Console.readInt('\n' +
                        "Digite um número entre 1 e 5:");

                switch (opcao)
                {	case 1:
                {
                    nome = Console.readLine('\n' +
                            "Informe o nome do produto: ");
                    descricao = Console.readLine('\n' +
                            "Informe a descricao do produto: ");
                    preco = Console.readDouble(
                            "Informe o valor do preco: ");
                    quantidade = Console.readInt(("Informe a quantidade do produto: "));
                    imageUrl = Console.readLine(
                            "Informe a url da imagem do produto: ");

                    umProduto = new Produto(nome, descricao, preco,quantidade,imageUrl);


                    System.out.println(produtoDAO.inclui(umProduto));

                    System.out.println('\n' + "Produto número " +
                            umProduto.getId() + umProduto.getNome() + umProduto.getPreco() + umProduto.getQuantidade() + " incluído com sucesso!");

                    break;
                }

                    case 2:
                    {	int resposta = Console.readInt('\n' +
                            "Digite o número do produto que você deseja alterar: ");

                        try
                        {
                            umProduto = produtoDAO.recuperaUmProduto(resposta);
                        }
                        catch(ProdutoNaoEncontradoExeception e)
                        {	System.out.println('\n' + e.getMessage());
                            break;
                        }

                        System.out.println('\n' +
                                "Número = " + umProduto.getId() +
                                "    Nome = " + umProduto.getNome() +
                                "    Preco = " + umProduto.getPreco() +
                                "    Descricao = " + umProduto.getDescricao() +
                                "    Quantidade = " + umProduto.getQuantidade() +
                                "    ImageUrl = " + umProduto.getImageUrl());

                        System.out.println('\n' + "O que você deseja alterar?");
                        System.out.println('\n' + "1. Nome");
                        System.out.println("2. Preco");
                        System.out.println("3. Descricao");
                        System.out.println("4. Quantidade");
                        System.out.println("5. ImageUrl");

                        int opcaoAlteracao = Console.readInt('\n' +
                                "Digite um número de 1 a 5:");

                        switch (opcaoAlteracao)
                        {	case 1:
                            String novoNome = Console.
                                    readLine("Digite o novo nome: ");

                            umProduto.setNome(novoNome);

                            try
                            {
                                produtoDAO.altera(umProduto);

                                System.out.println('\n' +
                                        "Alteração de nome efetuada com sucesso!");
                            }
                            catch(ProdutoNaoEncontradoExeception e)
                            {	System.out.println('\n' + e.getMessage());
                            }

                            break;

                            case 2:
                                double novoPreco = Console.
                                        readDouble("Digite o novo preco: ");

                                umProduto.setPreco(novoPreco);

                                try
                                {
                                    produtoDAO.altera(umProduto);

                                    System.out.println('\n' +
                                            "Alteração de preco efetuada " +
                                            "com sucesso!");
                                }
                                catch(ProdutoNaoEncontradoExeception e)
                                {	System.out.println('\n' + e.getMessage());
                                }

                                break;
                            case 3:
                                String novaDescricao = Console.readLine("Digite a nova descricao: ");

                                umProduto.setDescricao(novaDescricao);

                                try{
                                    produtoDAO.altera(umProduto);
                                    System.out.println('\n' +
                                            "Alteração de preco efetuada " +
                                            "com sucesso!");
                                }
                                catch (ProdutoNaoEncontradoExeception e){
                                    System.out.println('\n' + e.getMessage());
                                }
                                break;
                            case 4:
                                int novaQuantidade = Console.readInt("Digite a nova quantidade: ");

                                umProduto.setQuantidade(novaQuantidade);
                                try{
                                    produtoDAO.altera(umProduto);
                                    System.out.println('\n' +
                                            "Alteração de preco efetuada " +
                                            "com sucesso!");
                                }
                                catch (ProdutoNaoEncontradoExeception e){
                                    System.out.println('\n' + e.getMessage());
                                }
                                break;
                            case 5:
                                String novaImageUrl = Console.readLine("Digite a nova url da imagem: ");
                                umProduto.setImageUrl(novaImageUrl);
                                try{
                                    produtoDAO.altera(umProduto);
                                    System.out.println('\n' +
                                            "Alteração de imagem efetuada " +
                                            "com sucesso!");
                                }
                                catch (ProdutoNaoEncontradoExeception e){
                                    System.out.println('\n' + e.getMessage());
                                }
                                break;
                            default:
                                System.out.println('\n' + "Opção inválida!");
                        }

                        break;
                    }

                    case 3:
                    {	int resposta = Console.readInt('\n' +
                            "Digite o número do produto que você deseja remover: ");

                        try
                        {
                            umProduto = produtoDAO.recuperaUmProduto(resposta);
                        }
                        catch(ProdutoNaoEncontradoExeception e)
                        {	System.out.println('\n' + e.getMessage());
                            break;
                        }

                        System.out.println('\n' +
                                "Número = " + umProduto.getId() +
                                "    Nome = " + umProduto.getNome() +
                                "    Descricao = " + umProduto.getDescricao());

                        String resp = Console.readLine('\n' +
                                "Confirma a remoção do produto?");

                        if(resp.equals("s"))
                        {	try
                        {
                            produtoDAO.exclui (umProduto.getId());
                            System.out.println('\n' +
                                    "Produto removido com sucesso!");
                        }
                        catch(ProdutoNaoEncontradoExeception e)
                        {	System.out.println('\n' + e.getMessage());
                        }
                        }
                        else
                        {	System.out.println('\n' + "Produto não removido.");
                        }

                        break;
                    }

                    case 4:
                    {
                        List<Produto> produtos = produtoDAO.recuperaProdutos();

                        for (Produto produto : produtos)
                        {
                            System.out.println('\n' +
                                    "Id = " + produto.getId() +
                                    "  Nome = " + produto.getNome() +
                                    "  Preco = " + Util.doubleToStr(produto.getPreco()) +
                                    "  Descricao = " + produto.getDescricao() +
                                    "  Quantidade = " + produto.getQuantidade()+
                                    "  ImageUrl = "+ produto.getImageUrl());
                        }

                        break;
                    }

                    case 5:
                    {	continua = false;
                        break;
                    }

                    default:
                        System.out.println('\n' + "Opção inválida!");
                }
            }
    }
}