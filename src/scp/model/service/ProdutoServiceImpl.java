package scp.model.service;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.transaction.Transactional;

import scp.model.dao.ProdutoDao;
import scp.model.domain.Produto;

@Default
public class ProdutoServiceImpl implements ProdutoService {
	
	@Inject
	private ProdutoDao produtoDao;

	/* (non-Javadoc)
	 * @see scp.model.service.ProdutoService#getProdutos()
	 */
	@Override
	public List<Produto> getProdutos() {
		return produtoDao.getprodutos();
	}

	/* (non-Javadoc)
	 * @see scp.model.service.ProdutoService#salvar(scp.model.domain.Produto)
	 */
	@Override
	@Transactional
	public Produto salvar(Produto produto) {
		return produtoDao.salvar(produto);
	}

	/* (non-Javadoc)
	 * @see scp.model.service.ProdutoService#atualizar(scp.model.domain.Produto)
	 */
	@Override
	@Transactional
	public void atualizar(Produto produto) {
		produtoDao.atualizar(produto);
		
	}

	/* (non-Javadoc)
	 * @see scp.model.service.ProdutoService#excluir(scp.model.domain.Produto)
	 */
	@Override
	@Transactional
	public void excluir(Produto produto) {
		 produtoDao.excluir(produto);
		
	}

}
