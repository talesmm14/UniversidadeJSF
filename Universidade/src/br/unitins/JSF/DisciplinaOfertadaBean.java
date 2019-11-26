package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.DisciplinaEJB;
import br.unitins.EJB.DisciplinaOfertadaEJB;
import br.unitins.EJB.ProfessorEJB;
import br.unitins.EJB.SemestreEJB;
import br.unitins.model.Disciplina;
import br.unitins.model.DisciplinaOfertada;
import br.unitins.model.Professor;
import br.unitins.model.Semestre;

@Named
@SessionScoped
public class DisciplinaOfertadaBean implements Serializable {
	@EJB
	private DisciplinaOfertadaEJB disciplinaOfertadaEJB;
	@EJB
	private SemestreEJB semestreEJB;
	@EJB
	private DisciplinaEJB disciplinaEJB;
	@EJB
	private ProfessorEJB professorEJB;

	private DisciplinaOfertada disciplinaOfertada;
	
	private Semestre semestre;
	private Integer idSemestre;
	private Disciplina disciplina;
	private Integer idDisciplina;
	private Professor professor;
	private Integer idProfessor;

	private List<DisciplinaOfertada> disciplinaOfertadas;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		disciplinaOfertadas = disciplinaOfertadaEJB.findAll();
	}

	public String inserir() {
		disciplinaOfertada.setDisciplina(disciplinaEJB.load(idDisciplina));
		disciplinaOfertada.setSemestre(semestreEJB.load(idSemestre));
		disciplinaOfertada.setProfessor(professorEJB.load(idProfessor));
		disciplinaOfertadaEJB.insert(disciplinaOfertada);
		novo();
		return null;
	}

	public String alterar(DisciplinaOfertada aux) {
		disciplinaOfertada = aux;
		alterar = true;
		disciplinaOfertadaEJB.update(disciplinaOfertada);
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
		if (disciplinaOfertadas == null)
			disciplinaOfertadas = new ArrayList<>();
		disciplinaOfertadas = disciplinaOfertadaEJB.findAll();
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

	public SemestreEJB getSemestreEJB() {
		return semestreEJB;
	}

	public void setSemestreEJB(SemestreEJB semestreEJB) {
		this.semestreEJB = semestreEJB;
	}

	public DisciplinaEJB getDisciplinaEJB() {
		return disciplinaEJB;
	}

	public void setDisciplinaEJB(DisciplinaEJB disciplinaEJB) {
		this.disciplinaEJB = disciplinaEJB;
	}

	public ProfessorEJB getProfessorEJB() {
		return professorEJB;
	}

	public void setProfessorEJB(ProfessorEJB professorEJB) {
		this.professorEJB = professorEJB;
	}

	public Semestre getSemestre() {
		if(semestre == null)
			semestre = new Semestre();
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Integer getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(Integer idSemestre) {
		this.idSemestre = idSemestre;
	}

	public Disciplina getDisciplina() {
		if(disciplina == null)
			disciplina = new Disciplina();
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Integer getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Integer idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public Professor getProfessor() {
		if(professor == null)
			professor = new Professor();
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}
	
}