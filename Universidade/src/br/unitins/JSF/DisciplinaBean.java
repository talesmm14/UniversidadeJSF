package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.DisciplinaEJB;
import br.unitins.model.Disciplina;

@Named
@SessionScoped
public class DisciplinaBean implements Serializable {
	@EJB
	private DisciplinaEJB disciplinaEJB;

	private Disciplina disciplina;

	private List<Disciplina> disciplinas;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		disciplinas = disciplinaEJB.findAll();
	}

	public String inserir() {
		disciplinaEJB.insert(disciplina);
		novo();
		return null;
	}

	public String alterar(Disciplina aux) {
		disciplina = aux;
		alterar = true;
		disciplinaEJB.update(disciplina);
		return "cadastroDisciplina.xhtml?faces-redirect=true";
	}

	public String voltar() {
		disciplinaEJB.update(disciplina);
		alterar = false;
		return "disciplina.xhtml?faces-redirect=true";
	}

	public String apagar(Disciplina aux) {
		disciplina = aux;
		disciplinaEJB.delete(disciplina);
		return null;
	}

	public String novo() {
		disciplina = new Disciplina();
		return null;
	}

	public DisciplinaEJB getDisciplinaEJB() {
		return disciplinaEJB;
	}

	public void setDisciplinaEJB(DisciplinaEJB disciplinaEJB) {
		this.disciplinaEJB = disciplinaEJB;
	}

	public Disciplina getDisciplina() {
		if(disciplina == null)
			disciplina = new Disciplina();
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		if (disciplinas == null) 
			disciplinas = new ArrayList<>();
		disciplinas = disciplinaEJB.findAll();
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}