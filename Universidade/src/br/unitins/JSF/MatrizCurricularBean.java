package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.MatrizCurricularEJB;
import br.unitins.model.MatrizCurricular;

@Named
@SessionScoped
public class MatrizCurricularBean implements Serializable {
	@EJB
	private MatrizCurricularEJB matrizCurricularEJB;

	private MatrizCurricular matrizCurricular;

	private List<MatrizCurricular> matrizCurriculars;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		matrizCurriculars = matrizCurricularEJB.findAll();
	}

	public String inserir() {
		matrizCurricularEJB.insert(matrizCurricular);
		novo();
		return null;
	}

	public String alterar(MatrizCurricular aux) {
		matrizCurricular = aux;
		alterar = true;
		return "cadastroMatrizCurricular.xhtml?faces-redirect=true";
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
	
}
