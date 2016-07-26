package scp.model.dao;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import scp.model.domain.Produto;

@Default
public class ProdutoDaoImpl implements ProdutoDao {

	@PersistenceContext(unitName="SCPPU")
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see scp.model.dao.ProdutoDao#getprodutos()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Produto> getprodutos() {
		javax.persistence.Query query = entityManager.createQuery("from Produto");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see scp.model.dao.ProdutoDao#salvar(scp.model.domain.Produto)
	 */
	@Override
	public Produto salvar(Produto produto) {
		entityManager.persist(produto);
		return produto;
	}

	/* (non-Javadoc)
	 * @see scp.model.dao.ProdutoDao#excluir(scp.model.domain.Produto)
	 */
	@Override
	public void excluir(Produto produto) {
		Produto produtoMerge = entityManager.merge(produto);
		entityManager.remove(produtoMerge);
	}

	/* (non-Javadoc)
	 * @see scp.model.dao.ProdutoDao#atualizar(scp.model.domain.Produto)
	 */
	@Override
	public void atualizar(Produto produto) {
		Produto produtoMerge = entityManager.merge(produto);
		entityManager.persist(produtoMerge);
		
	}

}
