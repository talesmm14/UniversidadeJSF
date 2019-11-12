package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Curso;

@Stateful
public class CursoEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Curso curso) {
		em.persist(curso);
	}

	public void update(Curso curso) {
       em.merge(curso);
	}

	public void delete(Curso curso) {
		System.out.println("Objeto: " + curso.getId());		
		curso = load(curso.getId());
		em.remove(curso);
	}

	public Curso load(Integer id) {
		return em.find(Curso.class, id);
	}
	public List<Curso> findAll() {
		return em.createQuery("select c from Curso c", Curso.class).getResultList();
	}
}
