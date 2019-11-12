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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "matrizcurricular")

public class MatrizCurricular implements Serializable{
	private static final long serialVersionUID = 7888703280919271934L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private Integer ch;
	
	@OneToOne	
	@JoinColumn(name = "curso_id_fk")
	private Curso curso;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "matrizcurricular_periodo", 
	joinColumns = {@JoinColumn(name = "fk_matrizcurricular")}, 
	inverseJoinColumns = {@JoinColumn(name = "fk_periodo")} )
	private List <Periodo> periodos;

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

	public Integer getCh() {
		return ch;
	}

	public void setCh(Integer ch) {
		this.ch = ch;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
	
}
