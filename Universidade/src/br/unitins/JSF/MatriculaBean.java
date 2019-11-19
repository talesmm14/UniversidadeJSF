package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.AlunoEJB;
import br.unitins.EJB.DisciplinaOfertadaEJB;
import br.unitins.EJB.MatriculaEJB;
import br.unitins.model.Aluno;
import br.unitins.model.DisciplinaOfertada;
import br.unitins.model.Matricula;

@Named
@SessionScoped
public class MatriculaBean implements Serializable {
	@EJB
	private MatriculaEJB matriculaEJB;
	private AlunoEJB alunoEJB;
	private DisciplinaOfertadaEJB disciplinaOfertadaEJB;

	private Matricula matricula;
	
	private Aluno aluno;
	private Integer idAluno;
	private DisciplinaOfertada disciplinaOfertada;
	private Integer idDisciplinaOfertada;

	private List<Matricula> matriculas;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		matriculas = matriculaEJB.findAll();
	}

	public String inserir() {
		aluno = alunoEJB.load(idAluno);
		disciplinaOfertada = disciplinaOfertadaEJB.load(idDisciplinaOfertada);
		matricula.setAluno(aluno);
		matricula.setDisciplina(disciplinaOfertada);
		matriculaEJB.insert(matricula);
		novo();
		return null;
	}

	public String alterar(Matricula aux) {
		matricula = aux;
		matriculaEJB.update(matricula);
		alterar = true;
		return "cadastroMatricula.xhtml?faces-redirect=true";
	}

	public String voltar() {
		matriculaEJB.update(matricula);
		alterar = false;
		return "matricula.xhtml?faces-redirect=true";
	}

	public String apagar(Matricula aux) {
		matricula = aux;
		matriculaEJB.delete(matricula);
		return null;
	}

	public String novo() {
		matricula = new Matricula();
		return null;
	}

	public MatriculaEJB getMatriculaEJB() {
		return matriculaEJB;
	}

	public void setMatriculaEJB(MatriculaEJB matriculaEJB) {
		this.matriculaEJB = matriculaEJB;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public DisciplinaOfertada getDisciplinaOfertada() {
		return disciplinaOfertada;
	}

	public void setDisciplinaOfertada(DisciplinaOfertada disciplinaOfertada) {
		this.disciplinaOfertada = disciplinaOfertada;
	}

	public Integer getIdDisciplinaOfertada() {
		return idDisciplinaOfertada;
	}

	public void setIdDisciplinaOfertada(Integer idDisciplinaOfertada) {
		this.idDisciplinaOfertada = idDisciplinaOfertada;
	}
	
}
