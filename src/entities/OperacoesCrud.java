package entities;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OperacoesCrud {
	
	Scanner sc2 = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemploPU");
	EntityManager em = emf.createEntityManager();
	Cliente cliente = new Cliente();
	
	public void create(String nome, Integer idade, String profissao, String sexo) {
		
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
		cliente = em.find(Cliente.class, consulta);
		
		if(cliente != null) {
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("Idade: "+cliente.getIdade());
			System.out.println("Profissão: "+cliente.getProfissao());
			System.out.println("Sexo: "+cliente.getSexo());
		}else {
			System.out.println("Cliente não encontrado");
		}
	}
	
	public void delete(Long id) {
		cliente = em.find(Cliente.class, id);
		
		if(cliente != null) {
			System.out.println("Nome: "+cliente.getNome());
			System.out.println("Idade: "+cliente.getIdade());
			System.out.println("Profissão: "+cliente.getProfissao());
			System.out.println("Sexo: "+cliente.getSexo());
			
			System.out.print("Você deseja realmente excluir esse cliente? [s]sim ou [n]não: ");
			char cancelar = sc2.next().charAt(0);
			
			
			if (cancelar == 's') {
				try {
					em.getTransaction().begin();
					em.remove(cliente);
					em.getTransaction().commit();
					System.out.println("Cliente Deletado");
				}
				catch (RuntimeException e) {
					System.out.println("Cliente não pode ser excluido - possui uma FOREIGN KEY em outra tabela");
				}
				
			}else {
				System.out.println("Exclusão cancelada");
			}
		}else {
			System.out.println("Cliente não existe na base de dados");
		}
	}
	
	public void closeEntityManager() {
		em.close();
		
		
	}
}
