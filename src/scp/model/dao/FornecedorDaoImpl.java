package scp.model.dao;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import scp.model.domain.Fornecedor;

@Default
public class FornecedorDaoImpl implements FornecedorDao {

	@PersistenceContext(unitName="SCPPU")
	private EntityManager entityManager;
	/* (non-Javadoc)
	 * @see scp.model.dao.FornecedorDao#getFornecedores()
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Fornecedor> getFornecedores() {
		Query query = entityManager.createQuery("from Fornecedor");
		return query.getResultList();
	}

	/* (non-Javadoc)
	 * @see scp.model.dao.FornecedorDao#salvar(scp.model.domain.Fornecedor)
	 */
	@Override
	public Fornecedor salvar(Fornecedor fornecedor) {
		entityManager.persist(fornecedor);
		return fornecedor;
	}

	/* (non-Javadoc)
	 * @see scp.model.dao.FornecedorDao#atualizar(scp.model.domain.Fornecedor)
	 */
	@Override
	public void atualizar(Fornecedor fornecedor) {
		Fornecedor fornecedorMerge = entityManager.merge(fornecedor);
		entityManager.persist(fornecedorMerge);
		
	}

	/* (non-Javadoc)
	 * @see scp.model.dao.ProdutoDao#excluir(scp.model.domain.Fornecedor)
	 */
	@Override
	public void excluir(Fornecedor fornecedor) {
		Fornecedor fornecedorMerge = entityManager.merge(fornecedor);
		entityManager.remove(fornecedorMerge);
	}
	

}
