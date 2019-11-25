package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.FrequenciaEJB;
import br.unitins.EJB.MatriculaEJB;
import br.unitins.model.Frequencia;
import br.unitins.model.Matricula;

@Named
@SessionScoped
public class FrequenciaBean implements Serializable {
	@EJB
	private FrequenciaEJB frequenciaEJB;
	private MatriculaEJB matriculaEJB;
	
	private Frequencia frequencia;
	
	private Matricula matricula;
	private Integer idMatricula;
	
	private List<Frequencia> frequencias;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		frequencias = frequenciaEJB.findAll();
	}

	public String inserir() {
		matricula = matriculaEJB.load(idMatricula);
		frequencia.setMatricula(matricula);
		frequenciaEJB.insert(frequencia);
		novo();
		return null;
	}

	public String alterar(Frequencia aux) {
		frequencia = aux;
		alterar = true;
		frequenciaEJB.update(frequencia);
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
		if(frequencia == null)
			frequencia = new Frequencia();
		return frequencia;
	}

	public void setFrequencia(Frequencia frequencia) {
		this.frequencia = frequencia;
	}

	public List<Frequencia> getFrequencias() {
		if (frequencias == null) 
			frequencias = new ArrayList<>();
		frequencias = frequenciaEJB.findAll();
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

	public MatriculaEJB getMatriculaEJB() {
		return matriculaEJB;
	}

	public void setMatriculaEJB(MatriculaEJB matriculaEJB) {
		this.matriculaEJB = matriculaEJB;
	}

	public Matricula getMatricula() {
		if(matricula == null)
			matricula = new Matricula();
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}
	
}
