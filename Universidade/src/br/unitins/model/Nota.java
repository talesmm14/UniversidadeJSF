package br.unitins.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nota")

public class Nota implements Serializable{
	private static final long serialVersionUID = -3466138600277485464L;

	@Id
	@GeneratedValue
	private Integer id;
	
	private Double nota1;
	
	private Double nota2;
	
	private Double exame;
	
	private Matricula matricula;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getNota1() {
		return nota1;
	}

	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}

	public Double getNota2() {
		return nota2;
	}

	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}

	public Double getExame() {
		return exame;
	}

	public void setExame(Double exame) {
		this.exame = exame;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
	
}
