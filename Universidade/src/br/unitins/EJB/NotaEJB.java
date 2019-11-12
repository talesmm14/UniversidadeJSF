package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Nota;

@Stateful
public class NotaEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Nota nota) {
		em.persist(nota);
	}

	public void update(Nota nota) {
		em.merge(nota);
	}

	public void delete(Nota nota) {
		System.out.println("Objeto: " + nota.getId());
		nota = load(nota.getId());
		em.remove(nota);
	}

	public Nota load(Integer id) {
		return em.find(Nota.class, id);
	}

	public List<Nota> findAll() {
		return em.createQuery("select n from Nota n", Nota.class).getResultList();
	}
}