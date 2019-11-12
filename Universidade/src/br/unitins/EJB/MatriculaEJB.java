package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Matricula;

@Stateful
public class MatriculaEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Matricula matricula) {
		em.persist(matricula);
	}

	public void update(Matricula matricula) {
		em.merge(matricula);
	}

	public void delete(Matricula matricula) {
		System.out.println("Objeto: " + matricula.getId());
		matricula = load(matricula.getId());
		em.remove(matricula);
	}

	public Matricula load(Integer id) {
		return em.find(Matricula.class, id);
	}

	public List<Matricula> findAll() {
		return em.createQuery("select m from Matricula m", Matricula.class).getResultList();
	}
}