package br.edrone.model.control;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import br.edrone.model.Produto;
import br.edrone.model.Venda;
import br.edrone.rest.ProdutoEndpoint;
import br.edrone.service.Carrinho;

public class CarrinhoControle {

	@Inject
	private Carrinho carrinhno;

	@Inject
	private ProdutoEndpoint produtoEP;

	@Path("/adicionar/{id:[0-9][0-9]*}")
	public void adicionaProduto(@PathParam("id") long id) {
		Produto p = produtoEP.findById(id).readEntity(Produto.class);
		
		carrinhno.addProduto(p);
		
	}
	
	public List<> buscarProdutos(){
		
	}

	public void limpar(){
		carrinhno.limpar();
	}
	
	public void finalizar() {
		
		Venda venda = new Venda();
		
		vendaEP.create(carrinhno);
		
	}
	
	
}
