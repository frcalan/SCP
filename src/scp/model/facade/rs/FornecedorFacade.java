package scp.model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import scp.model.domain.Fornecedor;
import scp.model.service.FornecedorService;

@Path("/fornecedor")
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class FornecedorFacade {
	
	@Inject
	private FornecedorService fornecedorService;
	
	@GET
	public List<Fornecedor> getFornecedors() {
		return fornecedorService.getFornecedores();
	}

	@POST
	public Fornecedor salvar(Fornecedor fornecedor) {
		return fornecedorService.salvar(fornecedor);
	}

	@PUT
	public void atualizar(Fornecedor fornecedor) {
		fornecedorService.atualizar(fornecedor);
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") Integer id) {
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setCodigo(id);
		fornecedorService.excluir(fornecedor);
	}
}
