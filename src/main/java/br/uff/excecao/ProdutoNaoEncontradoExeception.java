package br.uff.excecao;

public class ProdutoNaoEncontradoExeception extends Throwable {
    private final static long serialVersionUID = 1;

    private int codigo;

    public ProdutoNaoEncontradoExeception(String msg)
    {	super(msg);
    }

    public ProdutoNaoEncontradoExeception(int codigo, String msg)
    {	super(msg);
        this.codigo = codigo;
    }

    public int getCodigoDeErro()
    {	return codigo;
    }
}
