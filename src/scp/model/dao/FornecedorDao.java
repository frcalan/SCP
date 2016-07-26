package scp.model.dao;

import java.util.List;

import scp.model.domain.Fornecedor;

public interface FornecedorDao {

	List<Fornecedor> getFornecedores();

	Fornecedor salvar(Fornecedor fornecedor);

	void atualizar(Fornecedor fornecedor);

	void excluir(Fornecedor fornecedor);

}