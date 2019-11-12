package br.unitins.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "curso")

public class Curso implements Serializable{
	private static final long serialVersionUID = 5051762621751069468L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String nome;
	
	@OneToOne	
	@JoinColumn(name = "instituicao_id_fk")
	private Instituicao instituicao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}
	
	
}
