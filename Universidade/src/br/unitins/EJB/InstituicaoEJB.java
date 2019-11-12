package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Instituicao;

@Stateful
public class InstituicaoEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Instituicao instituicao) {
		em.persist(instituicao);
	}

	public void update(Instituicao instituicao) {
		em.merge(instituicao);
	}

	public void delete(Instituicao instituicao) {
		System.out.println("Objeto: " + instituicao.getId());
		instituicao = load(instituicao.getId());
		em.remove(instituicao);
	}

	public Instituicao load(Integer id) {
		return em.find(Instituicao.class, id);
	}

	public List<Instituicao> findAll() {
		return em.createQuery("select i from Instituicao i", Instituicao.class).getResultList();
	}
}