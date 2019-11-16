package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.DisciplinaOfertadaEJB;
import br.unitins.model.DisciplinaOfertada;

@Named
@SessionScoped
public class DisciplinaOfertadaBean implements Serializable {
	@EJB
	private DisciplinaOfertadaEJB disciplinaOfertadaEJB;

	private DisciplinaOfertada disciplinaOfertada;

	private List<DisciplinaOfertada> disciplinaOfertadas;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		disciplinaOfertadas = disciplinaOfertadaEJB.findAll();
	}

	public String inserir() {
		disciplinaOfertadaEJB.insert(disciplinaOfertada);
		novo();
		return null;
	}

	public String alterar(DisciplinaOfertada aux) {
		disciplinaOfertada = aux;
		alterar = true;
		return "cadastroDisciplinaOfertada.xhtml?faces-redirect=true";
	}

	public String voltar() {
		disciplinaOfertadaEJB.update(disciplinaOfertada);
		alterar = false;
		return "disciplinaOfertada.xhtml?faces-redirect=true";
	}

	public String apagar(DisciplinaOfertada aux) {
		disciplinaOfertada = aux;
		disciplinaOfertadaEJB.delete(disciplinaOfertada);
		return null;
	}

	public String novo() {
		disciplinaOfertada = new DisciplinaOfertada();
		return null;
	}

	public DisciplinaOfertadaEJB getDisciplinaOfertadaEJB() {
		return disciplinaOfertadaEJB;
	}

	public void setDisciplinaOfertadaEJB(DisciplinaOfertadaEJB disciplinaOfertadaEJB) {
		this.disciplinaOfertadaEJB = disciplinaOfertadaEJB;
	}

	public DisciplinaOfertada getDisciplinaOfertada() {
		return disciplinaOfertada;
	}

	public void setDisciplinaOfertada(DisciplinaOfertada disciplinaOfertada) {
		this.disciplinaOfertada = disciplinaOfertada;
	}

	public List<DisciplinaOfertada> getDisciplinaOfertadas() {
		return disciplinaOfertadas;
	}

	public void setDisciplinaOfertadas(List<DisciplinaOfertada> disciplinaOfertadas) {
		this.disciplinaOfertadas = disciplinaOfertadas;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}