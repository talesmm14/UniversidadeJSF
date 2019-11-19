package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.AlunoEJB;
import br.unitins.model.Aluno;

@Named
@SessionScoped
public class AlunoBean implements Serializable {
	@EJB
	private AlunoEJB alunoEJB;

	private Aluno aluno;

	private List<Aluno> alunos;
	private Boolean alterar = false;

	@PostConstruct
	public void init() {
		alunos = alunoEJB.findAll();
	}

	public String inserir() {
		alunoEJB.insert(aluno);
		novo();
		return null;
	}

	public String alterar(Aluno aux) {
		aluno = aux;
		alterar = true;
		return "cadastroAluno.xhtml?faces-redirect=true";
	}

	public String voltar() {
		alunoEJB.update(aluno);
		alterar = false;
		return "aluno.xhtml?faces-redirect=true";
	}

	public String apagar(Aluno aux) {
		aluno = aux;
		alunoEJB.delete(aluno);
		return null;
	}

	public String novo() {
		aluno = new Aluno();
		return null;
	}

	public AlunoEJB getAlunoEJB() {
		return alunoEJB;
	}

	public void setAlunoEJB(AlunoEJB alunoEJB) {
		this.alunoEJB = alunoEJB;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public List<Aluno> getAlunos() {
		if (alunos == null)
			alunos = new ArrayList<Aluno>();
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Boolean getAlterar() {
		return alterar;
	}

	public void setAlterar(Boolean alterar) {
		this.alterar = alterar;
	}
	
}
