package br.edrone.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import br.edrone.model.Produto;

@Stateless
@LocalBean
public class Carrinho implements Serializable {

	private static final long serialVersionUID = -1L;

	List<Produto> produtos = new ArrayList<Produto>();

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void addProduto(Produto p) {
		produtos.add(p);
	}

	public void limpar() {
	}
}