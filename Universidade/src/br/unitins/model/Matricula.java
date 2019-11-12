package br.unitins.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "matricula")

public class Matricula implements Serializable{
	private static final long serialVersionUID = -2055328496120318009L;
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty
	private Aluno aluno;
	
	@NotEmpty
	private DisciplinaOfertada disciplina;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public DisciplinaOfertada getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaOfertada disciplina) {
		this.disciplina = disciplina;
	}
	
}
