package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Professor;

@Stateful
public class ProfessorEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Professor professor) {
		em.persist(professor);
	}

	public void update(Professor professor) {
		em.merge(professor);
	}

	public void delete(Professor professor) {
		System.out.println("Objeto: " + professor.getId());
		professor = load(professor.getId());
		em.remove(professor);
	}

	public Professor load(Integer id) {
		return em.find(Professor.class, id);
	}

	public List<Professor> findAll() {
		return em.createQuery("select p from Professor p", Professor.class).getResultList();
	}
}