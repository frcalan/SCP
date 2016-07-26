package scp.model.service;

import java.util.List;

import scp.model.domain.Produto;

public interface ProdutoService {

	List<Produto> getProdutos();

	Produto salvar(Produto produto);

	void atualizar(Produto produto);

	void excluir(Produto produto);

}