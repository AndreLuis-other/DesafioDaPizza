package Pizzaria;

/**
 * Classe para criar uma pizza
 * @author André
 * 
 */

public class Pizza {

	private double valor;
	private String nome;
	private double tamanho;
	/**
	 * Cria a pizza e define seus atirbutos inicialmente
	 * @param valor
	 * @param nome
	 * @param tamanho
	 */
	public Pizza(double valor, String nome, double tamanho) {
		this.valor = valor;
		this.nome = nome;
		this.tamanho = tamanho;
	}
	
	/**
	 * 
	 * @return custo beneficio da pizza em preço por cm3
	 */
	public double getCustoBeneficio(){
		double cm3 = Math.PI*Math.pow((tamanho/2), 2);
		return valor/cm3;
	}
	
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getTamanho() {
		return tamanho;
	}
	public void setTamanho(double tamanho) {
		this.tamanho = tamanho;
	}

	
	/**
	 * 
	 * @return
	 * 
	 */
	public String getInfo() {
		int tamNome = nome.length();
		int tamTamanho = (""+tamanho).length();
		int tamValor = (""+valor).length();
		String saida = ""+nome;
		for (int i = tamNome; i < 15; i++) {
			saida+=" ";
		}
		saida+="|";
		saida+=""+tamanho;
		for (int i = tamTamanho; i < 10; i++) {
			saida+=" ";
		}
		saida+="|";
		saida+="R$"+valor;
		for (int i = tamValor; i < 12; i++) {
			saida+=" ";
		}
		saida+="|";
		
		return saida;
	}
	
	/**
	 * Organiza a lista com base no custo beneficio da pizza, em orgem decrecente de custo beneficio
	 * @param lista
	 * @param inicio
	 * @param fim
	 * @return array de pizza em ordem decrescente de custo beneficio
	 */
	
	
	public static Pizza[] organizarLista(Pizza[] lista,int inicio,int fim) {
		
		for (int i = inicio; i < fim; i++) {
			if (lista[i].getCustoBeneficio()<lista[fim].getCustoBeneficio()) {
				Pizza temp = lista[i];
				lista[i] = lista[inicio];
				lista[inicio] = temp;
				
				inicio++;
			}
		}
		Pizza temp = lista[fim];
		lista[fim] = lista[inicio];
		lista[inicio] = temp;
		if (inicio>0) {
			lista=organizarLista(lista, 0, inicio-1);			
		}
		if(inicio<fim) {
			lista=organizarLista(lista, inicio+1, fim);
		}
		return lista;
	}
	
	
	
	
}
