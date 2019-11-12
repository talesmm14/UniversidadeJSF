package br.unitins.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "periodo")

public class Periodo implements Serializable{
	private static final long serialVersionUID = -553520297996640891L;

	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String nome;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "periodo_disciplinas", 
	joinColumns = {@JoinColumn(name = "fk_periodo")}, 
	inverseJoinColumns = {@JoinColumn(name = "fk_disciplinas")} )
	private List <Disciplina> disciplinas;

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

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	

}
