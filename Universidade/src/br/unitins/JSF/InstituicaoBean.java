package br.unitins.JSF;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.EJB.InstituicaoEJB;
import br.unitins.model.Instituicao;

@Named
@SessionScoped
public class InstituicaoBean implements Serializable {
	@EJB
	private InstituicaoEJB instituicaoEJB;
	
	private boolean alterar = false;
	
	private Instituicao instituicao;
	
	private List<Instituicao> instituicoes;
	
	@PostConstruct
	public void init() {
		instituicoes = instituicaoEJB.findAll();
	}

	public String inserir() {
		instituicaoEJB.insert(instituicao);
		novo();
		return null;
	}

	public String alterar(Instituicao aux) {
		instituicao = aux;
		alterar = true;
		return "cadastroInstituicao.xhtml?faces-redirect=true";
	}

	public String voltar() {
		instituicaoEJB.update(instituicao);
		alterar = false;
		return "instituicao.xhtml?faces-redirect=true";
	}

	public String apagar(Instituicao aux) {
		instituicao = aux;
		instituicaoEJB.delete(instituicao);
		return null;
	}

	public String novo() {
		instituicao = new Instituicao();
		return null;
	}

	public boolean isAlterar() {
		return alterar;
	}

	public void setAlterar(boolean alterar) {
		this.alterar = alterar;
	}

	public InstituicaoEJB getInstituicaoEJB() {
		return instituicaoEJB;
	}

	public void setInstituicaoEJB(InstituicaoEJB instituicaoEJB) {
		this.instituicaoEJB = instituicaoEJB;
	}

	public Instituicao getInstituicao() {
		if(instituicao == null)
			instituicao = new Instituicao();
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public List<Instituicao> getInstituicoes() {
		if(instituicoes == null)
			instituicoes = new ArrayList<>();
		instituicoes = instituicaoEJB.findAll();
		return instituicoes;
	}

	public void setInstituicoes(List<Instituicao> instituicoes) {
		this.instituicoes = instituicoes;
	}
	
}
	