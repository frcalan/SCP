package scp.model.service;

import java.util.List;

import scp.model.domain.Fornecedor;

public interface FornecedorService {

	List<Fornecedor> getFornecedores();

	Fornecedor salvar(Fornecedor fornecedor);

	void atualizar(Fornecedor fornecedor);

	void excluir(Fornecedor fornecedor);

}