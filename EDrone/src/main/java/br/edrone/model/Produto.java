package br.edrone.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javafx.scene.control.TextArea;
import java.math.BigDecimal;
import br.edrone.model.Categoria;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "produto")
@XmlRootElement
public class Produto implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column(length = 200, name = "produto_descricao", nullable = false)
	private String descricao;

	@Column(name = "produto_caracteristica")
	private String caracteristicas;

	@Column(name = "produto_complemento")
	private String complemento;

	@Column(name = "produto_valor")
	private BigDecimal valor;

	@ManyToOne
	private Categoria categoria;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Produto)) {
			return false;
		}
		Produto other = (Produto) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (descricao != null && !descricao.trim().isEmpty())
			result += "descricao: " + descricao;
		if (caracteristicas != null && !caracteristicas.trim().isEmpty())
			result += ", caracteristicas: " + caracteristicas;
		if (complemento != null && !complemento.trim().isEmpty())
			result += ", complemento: " + complemento;
		return result;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(final Categoria categoria) {
		this.categoria = categoria;
	}
}