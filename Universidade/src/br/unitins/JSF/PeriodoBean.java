package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.DisciplinaEJB;
import br.unitins.EJB.PeriodoEJB;
import br.unitins.model.Disciplina;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class PeriodoBean implements Serializable {
	@EJB
	private PeriodoEJB periodoEJB;
	private DisciplinaEJB disciplinaEJB;

	private Periodo periodo;
	
	private List<Disciplina> disciplinas;
	
	private List<Periodo> periodos;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		periodos = periodoEJB.findAll();
	}

	public String inserir() {
		periodo.setDisciplinas(disciplinas);
		periodoEJB.insert(periodo);
		novo();
		return null;
	}

	public String alterar(Periodo aux) {
		periodo = aux;
		alterar = true;
		periodoEJB.update(periodo);
		return "cadastroPeriodo.xhtml?faces-redirect=true";
	}
	
	public String cadastrarDisciplinas(Disciplina aux) {
		disciplinas.add(disciplinaEJB.load(aux.getId()));
		System.out.println("add : " + disciplinas);
		return null;
	}

	public String voltar() {
		periodoEJB.update(periodo);
		alterar = false;
		return "periodo.xhtml?faces-redirect=true";
	}

	public String apagar(Periodo aux) {
		periodo = aux;
		periodoEJB.delete(periodo);
		return null;
	}

	public String novo() {
		periodo = new Periodo();
		return null;
	}

	public PeriodoEJB getPeriodoEJB() {
		return periodoEJB;
	}

	public void setPeriodoEJB(PeriodoEJB periodoEJB) {
		this.periodoEJB = periodoEJB;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public List<Periodo> getPeriodos() {
		if (periodos == null)
			periodos = new ArrayList<Periodo>();
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}

	public DisciplinaEJB getDisciplinaEJB() {
		return disciplinaEJB;
	}

	public void setDisciplinaEJB(DisciplinaEJB disciplinaEJB) {
		this.disciplinaEJB = disciplinaEJB;
	}

	public List<Disciplina> getDisciplinas() {
		if (disciplinas == null)
			disciplinas = new ArrayList<Disciplina>();
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
}
