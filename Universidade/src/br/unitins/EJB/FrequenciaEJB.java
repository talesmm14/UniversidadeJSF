package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Frequencia;

@Stateful
public class FrequenciaEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(Frequencia frequencia) {
		em.persist(frequencia);
	}

	public void update(Frequencia frequencia) {
		em.merge(frequencia);
	}

	public void delete(Frequencia frequencia) {
		System.out.println("Objeto: " + frequencia.getId());
		frequencia = load(frequencia.getId());
		em.remove(frequencia);
	}

	public Frequencia load(Integer id) {
		return em.find(Frequencia.class, id);
	}

	public List<Frequencia> findAll() {
		return em.createQuery("select f from Frequencia f", Frequencia.class).getResultList();
	}
}