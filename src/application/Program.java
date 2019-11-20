package application;


import java.util.Scanner;

import entities.OperacoesCrud;


public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		OperacoesCrud ocrud = new OperacoesCrud();
		

		int opcao = 0;
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
			
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1:
				ocrud.create();
				System.out.println("Cliente Criado");
				break;
			case 2:
				System.out.println("Cliente Deletado");
				break;
			case 3:
				System.out.println("Cliente Consultado");
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
