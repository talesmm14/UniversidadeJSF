package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.ProfessorEJB;
import br.unitins.model.Professor;

@Named
@SessionScoped
public class ProfessorBean implements Serializable {
	@EJB
	private ProfessorEJB professorEJB;

	private Professor professor;

	private List<Professor> professors;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		professors = professorEJB.findAll();
	}

	public String inserir() {
		professorEJB.insert(professor);
		novo();
		return null;
	}

	public String alterar(Professor aux) {
		professor = aux;
		alterar = true;
		return "cadastroProfessor.xhtml?faces-redirect=true";
	}

	public String voltar() {
		professorEJB.update(professor);
		alterar = false;
		return "professor.xhtml?faces-redirect=true";
	}

	public String apagar(Professor aux) {
		professor = aux;
		professorEJB.delete(professor);
		return null;
	}

	public String novo() {
		professor = new Professor();
		return null;
	}

	public ProfessorEJB getProfessorEJB() {
		return professorEJB;
	}

	public void setProfessorEJB(ProfessorEJB professorEJB) {
		this.professorEJB = professorEJB;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getProfessors() {
		return professors;
	}

	public void setProfessors(List<Professor> professors) {
		this.professors = professors;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}
