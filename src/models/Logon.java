package models;

import java.util.ArrayList;
import java.util.List;

/**Classe para objetos do tipo Logon que estende de Atividade, onde serão contidos, valores e métodos para a mesma.
 * @author Carlos José
 * @author Judson Matheus
 */
public class Logon extends Atividade {
	List<Atividade> atividade;
	private int[] histograma = new int[24];
	
	/**
	  * Construtor que herda da classe atividade e constroi uma nova lista de 24 posições
	  *  
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Logon(){
		super();
		atividade = new ArrayList<Atividade>();
		for(int i = 0; i < 24; i++){
			histograma[i] = 0;
		}	
	}
	
	/**
	  * Retorna uma lista com todas as atividades realizadas do tipo Logon
	  * 
	  * @return  Atividade  lista com todas as atividades realizadas do tipo Logon 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public List<Atividade> getAtividade() {
		return atividade;
	}
	
	/**
	  * Seta uma lista com todas as atividades realizadas do tipo Logon
	  * 
	  * @param activity Atividade - Lista  com atividades realizadas do tipo Logon 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setAtividade(List<Atividade> activity) {
		this.atividade = activity;
	}
	
	/**
	  * Adiciona uma nova atividade do tipo Llogon na lista de atividade
	  * 
	  * @param newAtividade Atividade - Nova atividade a ser adicionada na lista
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void addAtividade(Atividade newAtividade){
		this.atividade.add(newAtividade);
	}
	
	/**
	  * Função que retorna o tamanho da lista de logon
	  * 
	  * @return  int -     O tamanho da lista que contem as atividades logon
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getTamanho() {
		return atividade.size();
	}
	
	/**
	  * Carrega o histograma a partir da lista de atividade relacionando a hora 
	  * com a quantidade de acessos a aquela atividade
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void carregarHistograma(){
		for(int i = 0; i < this.atividade.size(); i++){
			String substring = atividade.get(i).getDate().substring(11, 13);
			histograma[Integer.parseInt(substring)]++;
		}
	}
	
	/**
	  * Printa na tela o histograma da atividade do tipo logon
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void imprimirHistograma(){
		for(int i = 0; i<24;i++){
			System.out.println(i + " = " + histograma[i]);
		}
	}
	
	/**
	  * Busca a quantidade de atividades realizadas a partir de uma hora do dia
	  * 
	  * @param	hora int - Hora do dia	
	  * @return int -      Quantidade de atividades realizadas naquele dia
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int buscaPorIntervalo(int hora){
		return histograma[hora];
	}
}
