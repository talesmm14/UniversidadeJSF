package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.CursoEJB;
import br.unitins.EJB.MatrizCurricularEJB;
import br.unitins.EJB.PeriodoEJB;
import br.unitins.model.Curso;
import br.unitins.model.Disciplina;
import br.unitins.model.MatrizCurricular;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class MatrizCurricularBean implements Serializable {
	@EJB
	private MatrizCurricularEJB matrizCurricularEJB;
	private CursoEJB cursoEJB;
	private PeriodoEJB periodoEJB;
	
	private MatrizCurricular matrizCurricular;
	
	private Curso curso;
	private Integer idCurso;
	private List<Periodo> periodos;

	private List<MatrizCurricular> matrizCurriculars;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		matrizCurriculars = matrizCurricularEJB.findAll();
	}

	public String inserir() {
		curso = cursoEJB.load(idCurso);
		matrizCurricular.setCurso(curso);
		matrizCurricular.setPeriodos(periodos);
		matrizCurricularEJB.insert(matrizCurricular);
		novo();
		return null;
	}

	public String alterar(MatrizCurricular aux) {
		matrizCurricular = aux;
		alterar = true;
		matrizCurricularEJB.update(matrizCurricular);
		return "cadastroMatrizCurricular.xhtml?faces-redirect=true";
	}
	
	public String cadastrarPeriodos(Periodo aux) {
		periodos.add(periodoEJB.load(aux.getId()));
		System.out.println("add : " + periodos);
		return null;
	}

	public String voltar() {
		matrizCurricularEJB.update(matrizCurricular);
		alterar = false;
		return "matrizCurricular.xhtml?faces-redirect=true";
	}

	public String apagar(MatrizCurricular aux) {
		matrizCurricular = aux;
		matrizCurricularEJB.delete(matrizCurricular);
		return null;
	}

	public String novo() {
		matrizCurricular = new MatrizCurricular();
		return null;
	}

	public MatrizCurricularEJB getMatrizCurricularEJB() {
		return matrizCurricularEJB;
	}

	public void setMatrizCurricularEJB(MatrizCurricularEJB matrizCurricularEJB) {
		this.matrizCurricularEJB = matrizCurricularEJB;
	}

	public MatrizCurricular getMatrizCurricular() {
		return matrizCurricular;
	}

	public void setMatrizCurricular(MatrizCurricular matrizCurricular) {
		this.matrizCurricular = matrizCurricular;
	}

	public List<MatrizCurricular> getMatrizCurriculars() {
		return matrizCurriculars;
	}

	public void setMatrizCurriculars(List<MatrizCurricular> matrizCurriculars) {
		this.matrizCurriculars = matrizCurriculars;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}

	public CursoEJB getCursoEJB() {
		return cursoEJB;
	}

	public void setCursoEJB(CursoEJB cursoEJB) {
		this.cursoEJB = cursoEJB;
	}

	public PeriodoEJB getPeriodoEJB() {
		return periodoEJB;
	}

	public void setPeriodoEJB(PeriodoEJB periodoEJB) {
		this.periodoEJB = periodoEJB;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
	
}
