package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.MatrizCurricular;

@Stateful
public class MatrizCurricularEJB {
	@PersistenceContext
	private EntityManager em;

	public void insert(MatrizCurricular matrizCurricular) {
		em.persist(matrizCurricular);
	}

	public void update(MatrizCurricular matrizCurricular) {
		em.merge(matrizCurricular);
	}

	public void delete(MatrizCurricular matrizCurricular) {
		System.out.println("Objeto: " + matrizCurricular.getId());
		matrizCurricular = load(matrizCurricular.getId());
		em.remove(matrizCurricular);
	}

	public MatrizCurricular load(Integer id) {
		return em.find(MatrizCurricular.class, id);
	}

	public List<MatrizCurricular> findAll() {
		return em.createQuery("select m from MatrizCurricular m", MatrizCurricular.class).getResultList();
	}
}