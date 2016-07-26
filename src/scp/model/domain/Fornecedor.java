package scp.model.domain;

import java.io.Serializable;
//import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
@Model
@XmlRootElement
@Entity
@Table(name="FORNECEDOR")
public class Fornecedor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer codigo;
	
	@Column(name="nome", length=30, nullable=false)
	private String nome;
	/*
	@OneToMany(mappedBy="fornecedor")
	private List<Produto> produtos;
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	*/
	public Fornecedor(){
		
	}
	/*
	public List<Produto> getProdutos() {
		return produtos;
	}*/
	
	public Fornecedor(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}	
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
