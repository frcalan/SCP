package scp.model.facade.rs;

import java.util.List;

import javax.ws.rs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import scp.model.domain.Produto;
import scp.model.service.ProdutoService;

@Path("/produto")
@Produces({MediaType.APPLICATION_JSON,
	   MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoFacede {
	
	@Inject
	private ProdutoService produtoService;

	@GET
	public List<Produto> getProdutos() {
		return produtoService.getProdutos();
	}

	@POST
	public Produto salvar(Produto produto) {
		return produtoService.salvar(produto);
	}

	@PUT
	public void atualizar(Produto produto) {
		produtoService.atualizar(produto);
	}
	
	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") Integer id) {
		Produto produto = new Produto();
		produto.setCodigo(id);
		produtoService.excluir(produto);
	}

}
