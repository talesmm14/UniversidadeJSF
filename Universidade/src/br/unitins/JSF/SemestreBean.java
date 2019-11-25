package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.SemestreEJB;
import br.unitins.model.Semestre;

@Named
@SessionScoped
public class SemestreBean implements Serializable {
	@EJB
	private SemestreEJB semestreEJB;

	private Semestre semestre;

	private List<Semestre> semestres;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		semestres = semestreEJB.findAll();
	}

	public String inserir() {
		semestreEJB.insert(semestre);
		novo();
		return null;
	}

	public String alterar(Semestre aux) {
		semestre = aux;
		alterar = true;
		semestreEJB.update(semestre);
		return "cadastroSemestre.xhtml?faces-redirect=true";
	}

	public String voltar() {
		semestreEJB.update(semestre);
		alterar = false;
		return "semestre.xhtml?faces-redirect=true";
	}

	public String apagar(Semestre aux) {
		semestre = aux;
		semestreEJB.delete(semestre);
		return null;
	}

	public String novo() {
		semestre = new Semestre();
		return null;
	}

	public SemestreEJB getSemestreEJB() {
		return semestreEJB;
	}

	public void setSemestreEJB(SemestreEJB semestreEJB) {
		this.semestreEJB = semestreEJB;
	}

	public Semestre getSemestre() {
		if(semestre == null)
			semestre = new Semestre();
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public List<Semestre> getSemestres() {
		if (semestres == null)
			semestres = new ArrayList<>();
		semestres = semestreEJB.findAll();
		return semestres;
	}

	public void setSemestres(List<Semestre> semestres) {
		this.semestres = semestres;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}
