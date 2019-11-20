package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OperacoesCrud {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	EntityManager em = emf.createEntityManager();
	
	public void create() {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Marcio Mello");
		cliente.setIdade(37);
		cliente.setProfissao("Segurança");
		cliente.setSexo("M");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Dados Salvos ;)");
	}
	
	
	
	
	
	
	
	public void closeEntityManager() {
		em.close();
	}
}
