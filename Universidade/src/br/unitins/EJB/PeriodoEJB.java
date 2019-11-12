package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Periodo;

@Stateful
public class PeriodoEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Periodo periodo) {
		em.persist(periodo);
	}

	public void update(Periodo periodo) {
		em.merge(periodo);
	}

	public void delete(Periodo periodo) {
		System.out.println("Objeto: " + periodo.getId());
		periodo = load(periodo.getId());
		em.remove(periodo);
	}

	public Periodo load(Integer id) {
		return em.find(Periodo.class, id);
	}

	public List<Periodo> findAll() {
		return em.createQuery("select p from Periodo p", Periodo.class).getResultList();
	}
}