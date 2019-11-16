package br.unitins.JSF;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.AlunoEJB;
import br.unitins.model.Aluno;

@Named
@SessionScoped
public class DisciplinaBean implements Serializable {
	@EJB
	private AlunoEJB disciplinaEJB;

	private Aluno disciplina;

	private List<Aluno> disciplinas;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		disciplinas = disciplinaEJB.findAll();
	}

	public String inserir() {
		disciplinaEJB.insert(disciplina);
		novo();
		return null;
	}

	public String alterar(Aluno aux) {
		disciplina = aux;
		alterar = true;
		return "cadastroAluno.xhtml?faces-redirect=true";
	}

	public String voltar() {
		disciplinaEJB.update(disciplina);
		alterar = false;
		return "disciplina.xhtml?faces-redirect=true";
	}

	public String apagar(Aluno aux) {
		disciplina = aux;
		disciplinaEJB.delete(disciplina);
		return null;
	}

	public String novo() {
		disciplina = new Aluno();
		return null;
	}

	public AlunoEJB getDisciplinaEJB() {
		return disciplinaEJB;
	}

	public void setDisciplinaEJB(AlunoEJB disciplinaEJB) {
		this.disciplinaEJB = disciplinaEJB;
	}

	public Aluno getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Aluno disciplina) {
		this.disciplina = disciplina;
	}

	public List<Aluno> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Aluno> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}