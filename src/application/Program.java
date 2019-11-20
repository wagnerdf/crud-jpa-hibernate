package application;


import java.util.Scanner;

//import entities.Cliente;
import entities.OperacoesCrud;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		OperacoesCrud ocrud = new OperacoesCrud();
		
		Long consulta = 0L;
		Long id = 0L;
		int opcao = 0;
		String nome;
		Integer idade;
		String sexo;
		String profissao;
		do {
			System.out.println("-----------Sistema de Gestão de Clientes----------");
			System.out.println("--------------------------------------------------");
			System.out.println("----------------Escolha uma opção:----------------");
			System.out.println("--------------------------------------------------");
			System.out.println("--( 1 ) - Cadastrar cliente ----------------------");
			System.out.println("--( 2 ) - Deletar cliente ------------------------");
			System.out.println("--( 3 ) - Consulta cliente -----------------------");
			System.out.println("--( 4 ) - Editar cliente -------------------------");
			System.out.println("--------------------------------------------------");
			System.out.println("--( 5 ) - Sair do sistema ------------------------");
			System.out.println("--------------------------------------------------");
			System.out.print("--Digite uma opção: ");
			
			opcao = sc.nextInt();
			
			
			switch (opcao) {
			case 1:
				sc.nextLine();
				System.out.print("Informe o NOME do cliente: ");
				nome = sc.nextLine();
				System.out.print("Informe a IDADE do cliente: ");
				idade = sc.nextInt();
				sc.nextLine();
				System.out.print("Informe a Profissão do cliente: ");
				profissao = sc.nextLine();
				System.out.print("Informe o SEXO [M] Masculino e [F] Feminino: ");
				sexo = sc.nextLine();
				ocrud.create(nome, idade, profissao, sexo);
				System.out.println("Cliente Criado");
				break;
			case 2:
				System.out.print("Informe o ID do cliente: ");
				id = sc.nextLong();
				ocrud.delete(id);
				break;
			case 3:
				System.out.print("Informe o ID do cliente: ");
				consulta = sc.nextLong();
				ocrud.read(consulta);
				System.out.println("Consulta Finalizada");
				break;
			case 4:
				System.out.println("Cliente Editado");
				break;
			case 5:
				System.out.println("Opção escolhida - Sair do sistema");
				break;
			default:
				System.out.println("Opção invalida! Escolha a opção apresentada no MENU");

			}
		} while (opcao != 5);
		
		ocrud.closeEntityManager();
		
		sc.close();
		System.out.println("Programa finalizado");
	}
}
