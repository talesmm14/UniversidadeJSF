package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.PeriodoEJB;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class PeriodoBean implements Serializable {
	@EJB
	private PeriodoEJB periodoEJB;

	private Periodo periodo;

	private List<Periodo> Periodos;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		Periodos = periodoEJB.findAll();
	}

	public String inserir() {
		periodoEJB.insert(periodo);
		novo();
		return null;
	}

	public String alterar(Periodo aux) {
		periodo = aux;
		alterar = true;
		return "cadastroPeriodo.xhtml?faces-redirect=true";
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
		return Periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		Periodos = periodos;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}
