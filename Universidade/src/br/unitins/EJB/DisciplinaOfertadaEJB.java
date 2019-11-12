package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.DisciplinaOfertada;

@Stateful
public class DisciplinaOfertadaEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(DisciplinaOfertada disciplinaOfertada) {
		em.persist(disciplinaOfertada);
	}

	public void update(DisciplinaOfertada disciplinaOfertada) {
		em.merge(disciplinaOfertada);
	}

	public void delete(DisciplinaOfertada disciplinaOfertada) {
		System.out.println("Objeto: " + disciplinaOfertada.getId());
		disciplinaOfertada = load(disciplinaOfertada.getId());
		em.remove(disciplinaOfertada);
	}

	public DisciplinaOfertada load(Integer id) {
		return em.find(DisciplinaOfertada.class, id);
	}

	public List<DisciplinaOfertada> findAll() {
		return em.createQuery("select d from DisciplinaOfertada d", DisciplinaOfertada.class).getResultList();
	}
}