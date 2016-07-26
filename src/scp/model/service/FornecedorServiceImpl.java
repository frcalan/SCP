package scp.model.service;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.transaction.Transactional;

import scp.model.dao.FornecedorDao;
import scp.model.domain.Fornecedor;

@Default
public class FornecedorServiceImpl implements FornecedorService {

	@Inject
	private FornecedorDao fornecedorDao;
	
	/* (non-Javadoc)
	 * @see scp.model.service.FornecedorService#getFornecedores()
	 */
	@Override
	public List<Fornecedor> getFornecedores() {
		return fornecedorDao.getFornecedores();
	}

	/* (non-Javadoc)
	 * @see scp.model.service.FornecedorService#salvar(scp.model.domain.Fornecedor)
	 */
	@Override
	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor) {
		return fornecedorDao.salvar(fornecedor);
	}

	/* (non-Javadoc)
	 * @see scp.model.service.FornecedorService#atualizar(scp.model.domain.Fornecedor)
	 */
	@Override
	@Transactional
	public void atualizar(Fornecedor fornecedor) {
		fornecedorDao.atualizar(fornecedor);
		
	}

	/* (non-Javadoc)
	 * @see scp.model.service.FornecedorService#excluir(scp.model.domain.Fornecedor)
	 */
	@Override
	@Transactional
	public void excluir(Fornecedor fornecedor) {
		fornecedorDao.excluir(fornecedor);
		
	}

}
