package application;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Cliente;


public class Program {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
		EntityManager em = emf.createEntityManager();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Gardenal de Oliveira");
		cliente.setIdade(27);
		cliente.setProfissao("Psicologo");
		cliente.setSexo("M");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		
		
		System.out.println("Dados Salvos ;)");
		
		//em.close();
	}

}
