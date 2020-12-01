package Pizzaria;

import java.util.Scanner;

public class Tela {
	
	public static void main(String[] args) {
		Pizza[] pizzas = new Pizza[0];
		Scanner in = new Scanner(System.in);
		char opc;

		//pizzas usadas de exemplo, desmarque para usar de teste.
		/*
		pizzas = aumentarArray(pizzas);
		pizzas[pizzas.length-1] = new Pizza(25.242, "Broto", 15);
		pizzas = aumentarArray(pizzas);
		pizzas[pizzas.length-1] = new Pizza(35.211233, "Pequena", 25);
		pizzas = aumentarArray(pizzas);
		pizzas[pizzas.length-1] = new Pizza(40.532243422, "Media", 35);
		*/
		
		System.out.println("teste");
		do {
			System.out.println("Informe o nome da Pizza");
			in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String nome = in.nextLine();
			System.out.println("Informe o valor da Pizza");
			double valor = in.nextDouble();
			System.out.println("Informe o tamanho da Pizza");
			double tamanho = in.nextDouble();
			pizzas = aumentarArray(pizzas);
			pizzas[pizzas.length-1] = new Pizza(valor, nome, tamanho);
			
			System.out.println("Deseja informar outra pizza? Sim ou N�o");
			opc = in.next().toLowerCase().charAt(0);
			
		} while (opc=='s');
		
		System.out.println("\n\n");
		System.out.println("Nome           |Tamanho   |Pre�o         |Custo Beneficio");
		pizzas = Pizza.organizarLista(pizzas, 0, pizzas.length-1);
		for (int i = 0; i < pizzas.length; i++) {
			double base = pizzas[0].getCustoBeneficio();
			double porcentoMaior;
			porcentoMaior = ((pizzas[i].getCustoBeneficio()-base)/base)*100;  
			System.out.print(pizzas[i].getInfo());
			System.out.printf("%.2f %s",porcentoMaior,"% \n");
		}
		
	}

	
	private static Pizza[] aumentarArray(Pizza[] lista) {
		Pizza[] novoArray = new Pizza[lista.length+1]; 
		for (int i = 0; i < lista.length; i++) {
			novoArray[i] = lista[i];
		}
		return novoArray;
	}
	
}
