package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.MatriculaEJB;
import br.unitins.EJB.NotaEJB;
import br.unitins.model.Matricula;
import br.unitins.model.Nota;

@Named
@SessionScoped
public class NotaBean implements Serializable {
	@EJB
	private NotaEJB notaEJB;
	@EJB
	private MatriculaEJB matriculaEJB;

	private Nota nota;
	
	private Matricula matricula;
	private Integer idMatricula;

	private List<Nota> notas;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		notas = notaEJB.findAll();
	}

	public String inserir() {
		matricula = matriculaEJB.load(idMatricula);
		nota.setMatricula(matricula);
		notaEJB.insert(nota);
		novo();
		return null;
	}

	public String alterar(Nota aux) {
		nota = aux;
		alterar = true;
		notaEJB.update(nota);
		return "cadastroNota.xhtml?faces-redirect=true";
	}

	public String voltar() {
		notaEJB.update(nota);
		alterar = false;
		return "nota.xhtml?faces-redirect=true";
	}

	public String apagar(Nota aux) {
		nota = aux;
		notaEJB.delete(nota);
		return null;
	}

	public String novo() {
		nota = new Nota();
		return null;
	}

	public NotaEJB getNotaEJB() {
		return notaEJB;
	}

	public void setNotaEJB(NotaEJB notaEJB) {
		this.notaEJB = notaEJB;
	}

	public Nota getNota() {
		if(nota == null)
			nota = new Nota();
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}

	public List<Nota> getNotas() {
		if (notas == null)
			notas = new ArrayList<>();
		notas = notaEJB.findAll();
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
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
