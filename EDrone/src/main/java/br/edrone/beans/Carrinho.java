package br.edrone.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import br.edrone.model.Produto;

@SessionScoped
public class Carrinho implements Serializable {

	private static final long serialVersionUID = 1L;

	List<ItensCarrinho> itens;
	int quantidadeDoItem;
	double total;

	public Carrinho() {
		itens = new ArrayList<ItensCarrinho>();
		quantidadeDoItem = 0;
		total = 0;
	}

	public synchronized void addItem(Produto p) {

		boolean novoItem = true;

		for (ItensCarrinho item : itens) {

			if (item.getProduto().getId() == p.getId()) {

				novoItem = false;
				item.adcionarQuantidade();
			}
		}

		if (novoItem) {
			ItensCarrinho item = new ItensCarrinho(p);
			itens.add(item);
		}
	}

	public synchronized void update(Produto p, String quantidade) {

		short qty = -1;

		qty = Short.parseShort(quantidade);

		if (qty >= 0) {

			ItensCarrinho itemAlterar = null;

			for (ItensCarrinho item : itens) {

				if (item.getProduto().getId() == p.getId()) {

					if (qty != 0) {
						item.setQuantidade(qty);
					} else {
						itemAlterar = item;
						break;
					}
				}
			}

			if (itemAlterar != null) {
				itens.remove(itemAlterar);
			}
		}
	}
	public synchronized List<ItensCarrinho> getItems() {
		return itens;
	}

	public synchronized int getNumberOfItems() {

		quantidadeDoItem = 0;

		for (ItensCarrinho item : itens) {

			quantidadeDoItem += item.getQuantidade();
		}

		return quantidadeDoItem;
	}

	public synchronized double getSubtotal() {

		double amount = 0;

		for (ItensCarrinho item : itens) {

			Produto produto = (Produto) item.getProduto();
			amount += (item.getQuantidade() * produto.getPreco());
		}

		return amount;
	}

	public synchronized void calcularTotal(String surcharge) {

		double amount = 0;

		double s = Double.parseDouble(surcharge);

		amount = this.getSubtotal();
		amount += s;

		total = amount;
	}

	public synchronized double getTotal() {
		return total;
	}

	public synchronized void clear() {
		itens.clear();
		quantidadeDoItem = 0;
		total = 0;
	}

}