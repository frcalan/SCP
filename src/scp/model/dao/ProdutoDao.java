package scp.model.dao;

import java.util.List;

import scp.model.domain.Produto;

public interface ProdutoDao {

	List<Produto> getprodutos();

	Produto salvar(Produto produto);

	void excluir(Produto produto);

	void atualizar(Produto produto);

}