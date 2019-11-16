package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.FrequenciaEJB;
import br.unitins.model.Frequencia;

@Named
@SessionScoped
public class FrequenciaBean implements Serializable {
	@EJB
	private FrequenciaEJB frequenciaEJB;

	private Frequencia frequencia;

	private List<Frequencia> frequencias;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		frequencias = frequenciaEJB.findAll();
	}

	public String inserir() {
		frequenciaEJB.insert(frequencia);
		novo();
		return null;
	}

	public String alterar(Frequencia aux) {
		frequencia = aux;
		alterar = true;
		return "cadastroFrequencia.xhtml?faces-redirect=true";
	}

	public String voltar() {
		frequenciaEJB.update(frequencia);
		alterar = false;
		return "frequencia.xhtml?faces-redirect=true";
	}

	public String apagar(Frequencia aux) {
		frequencia = aux;
		frequenciaEJB.delete(frequencia);
		return null;
	}

	public String novo() {
		frequencia = new Frequencia();
		return null;
	}

	public FrequenciaEJB getFrequenciaEJB() {
		return frequenciaEJB;
	}

	public void setFrequenciaEJB(FrequenciaEJB frequenciaEJB) {
		this.frequenciaEJB = frequenciaEJB;
	}

	public Frequencia getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<Frequencia> frequencias) {
		this.frequencias = frequencias;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}
