package br.unitins.EJB;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Aluno;

@Stateful
public class AlunoEJB {
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Aluno aluno) {
		em.persist(aluno);
	}

	public void update(Aluno aluno) {
       em.merge(aluno);
	}

	public void delete(Aluno aluno) {
		System.out.println("Objeto: " + aluno.getId());		
		aluno = load(aluno.getId());
		em.remove(aluno);
	}

	public Aluno load(Integer id) {
		return em.find(Aluno.class, id);
	}
	
	public List<Aluno> findAll() {
		return em.createQuery("select a from Aluno a", Aluno.class).getResultList();
	}
}
