package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OperacoesCrud {
	
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	EntityManager em = emf.createEntityManager();
	
	public void create(String nome, Integer idade, String profissao, String sexo) {
		
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setIdade(idade);
		cliente.setProfissao(profissao);
		cliente.setSexo(sexo);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		System.out.println("Dados Salvos ;)");
	}
	
	public void read(Long consulta) {
		Cliente cliente = em.find(Cliente.class, consulta);
		
		if(cliente != null) {
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("Idade: "+cliente.getIdade());
			System.out.println("Profissão: "+cliente.getProfissao());
			System.out.println("Sexo: "+cliente.getSexo());
		}else {
			System.out.println("Cliente não encontrado");
		}
		
	}
	
	
	
	
	
	public void closeEntityManager() {
		em.close();
	}
}
