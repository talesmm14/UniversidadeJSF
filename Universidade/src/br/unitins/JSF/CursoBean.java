package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.CursoEJB;
import br.unitins.model.Curso;

@Named
@SessionScoped
public class CursoBean implements Serializable{
	@EJB
	private CursoEJB cursoEJB;

	private Curso curso;

	private List<Curso> cursos;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		cursos = cursoEJB.findAll();
	}

	public String inserir() {
		cursoEJB.insert(curso);
		novo();
		return null;
	}

	public String alterar(Curso aux) {
		curso = aux;
		alterar = true;
		return "cadastroCurso.xhtml?faces-redirect=true";
	}

	public String voltar() {
		cursoEJB.update(curso);
		alterar = false;
		return "curso.xhtml?faces-redirect=true";
	}

	public String apagar(Curso aux) {
		curso = aux;
		cursoEJB.delete(curso);
		return null;
	}

	public String novo() {
		curso = new Curso();
		return null;
	}

	public CursoEJB getCursoEJB() {
		return cursoEJB;
	}

	public void setCursoEJB(CursoEJB cursoEJB) {
		this.cursoEJB = cursoEJB;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}
