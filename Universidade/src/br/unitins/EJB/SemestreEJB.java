package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Semestre;

@Stateful
public class SemestreEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Semestre semestre) {
		em.persist(semestre);
	}

	public void update(Semestre semestre) {
		em.merge(semestre);
	}

	public void delete(Semestre semestre) {
		System.out.println("Objeto: " + semestre.getId());
		semestre = load(semestre.getId());
		em.remove(semestre);
	}

	public Semestre load(Integer id) {
		return em.find(Semestre.class, id);
	}

	public List<Semestre> findAll() {
		return em.createQuery("select s from Semestre s", Semestre.class).getResultList();
	}
}