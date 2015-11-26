package br.edrone.beans;

import java.io.Serializable;

import br.edrone.model.Produto;

public class ItensCarrinho implements Serializable {

	private static final long serialVersionUID = 1L;

	Produto produto;
	short quantidade;

	public ItensCarrinho(Produto p) {
		this.produto = p;
		quantidade = 1;
	}

	public Produto getProduto() {
		return produto;
	}

	public short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(short quantidade) {
		this.quantidade = quantidade;
	}

	public void adcionarQuantidade() {
		quantidade++;
	}

	public void diminuiQuantidade() {
		quantidade--;
	}

	public double getTotal() {
		double total = 0;
		total = (this.getQuantidade() * produto.getPreco());
		return total;
	}
}