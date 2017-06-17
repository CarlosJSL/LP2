package models;

import java.util.ArrayList;
import java.util.List;

/**Classe para objetos do tipo Atividade, onde serão contidos, valores e métodos para a mesma.
 * @author Carlos José
 * @author Judson Matheus
 */
public class Atividade {
	String id;
	String date;
	String id_user;
	String pc;
	String activity;
	
	/**
	  * Construtor vazio
	  * 
	  */
	public Atividade(){
		
	}
	
	/**
	  * Retorna uma String de activity
	  * 
	  * @return String -   Total de devices que a ávore possui	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getActivity() {
		return activity;
	}
	
	/**
	  * Seta uma String para o atributo activity
	  * 
	  * @param atividade String -   Total de devices que a ávore possui	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setActivity(String atividade) {
		this.activity = atividade;
	}
	
	/**
	  * Retorna o id daquela atividade
	  * 
	  * @return String -   Id da atividade	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getId() {
		return id;
	}
	
	/**
	  * Seta o id daquela atividade
	  * 
	  * @param  id	String -   Id da atividade	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	  * Retorna o id daquela atividade
	  * 
	  * @return  String -  Id da atividade	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getDate() {
		return date;
	}
	
	/**
	  * Seta data em que aquela atividade foi realizada
	  * 
	  * @param date String - Data da atividade	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setDate(String date) {
		this.date = date;
	}
	
	/**
	  * Retorna o id do usuário relacionado àquela atividade
	  * 
	  * @return  String -  Id do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getId_user() {
		return id_user;
	}
	
	/**
	  * Seta o id do usuário relacionado àquela atividade
	  * 
	  * @param  id_user String - Id do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	
	/**
	  * Retorna o pc em que aconteceu àquela atividade
	  * 
	  * @return String -   Nome do pc
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getPc() {
		return pc;
	}
	
	/**
	  * Seta o pc em que aconteceu àquela atividade
	  * 
	  * @param  pc String - Nome do pc	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setPc(String pc) {
		this.pc = pc;
	}
	
	
	@Override
	public String toString() {
		return "Atividade [id=" + id + ", date=" + date + ", id_user=" + id_user + ", pc=" + pc + "]";
	}

}
