package models;

import java.util.ArrayList;
import java.util.List;

/**Classe para objetos do tipo General Tree, onde serão contidos, valores e métodos para a mesma.
 * @author Carlos José
 * @author Judson Matheus
 */
public class GeneralTree {
	private String data;
	private Device filhoDevice;
	private Http filhoHttp;
	private Logon filhoLogon;
	
	/**
	  * Construtor que ao ser chamado cria no segundo nivel da árvore filhos do tipo:
	  * Device, Http e Logon
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public GeneralTree(){
		super();
		filhoDevice = new Device();
		filhoHttp = new Http();
		filhoLogon = new Logon();
	}
	
	/**
	  * Retorn o nó do tipo Device que contém todos os devices
	  * 
	  * @return 		   Nó do tipo Device
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Device getFilhoDevice() {
		return filhoDevice;
	}
	
	/**
	  * Seta o nó do tipo Device que contém todos os devices
	  * 
	  * @param 	filhoDevice	Device -Nó do tipo Device
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setFilhoDevice(Device filhoDevice) {
		this.filhoDevice = filhoDevice;
	}
	
	/**
	  * Retorn o nó do tipo Http que contém todos os http's
	  * 
	  * @return Http -     Nó do tipo Http
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Http getFilhoHttp() {
		return filhoHttp;
	}
	
	/**
	  * Seta o nó do tipo Http que contém todos os http's
	  * 
	  * @param 	filhoHttp Http - Nó do tipo Http
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setFilhoHttp(Http filhoHttp) {
		this.filhoHttp = filhoHttp;
	}
	
	/**
	  * Retorna o nó do tipo Logon que contém todos os logon's
	  * 
	  * @return Logon -    Nó do tipo Logon
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Logon getFilhoLogon() {
		return filhoLogon;
	}
	
	/**
	  * Seta o nó do tipo Logon que contém todos os logon's
	  * 
	  * @param filhoLogon Logon -Nó do tipo Logon
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setFilhoLogon(Logon filhoLogon) {
		this.filhoLogon = filhoLogon;
	}
	
	/**
	  * Retorna o número de devices da lista
	  * 
	  * @return int -      Numero total de devices
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getNumeroDevice(){
		return filhoDevice.getTamanho();
	}
	
	/**
	  * Retorna o número de http's da lista
	  * 
	  * @return int -      Numero total de http's
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getNumeroHttp(){
		return filhoHttp.getTamanho();
	}
	
	/**
	  * Retorna o número de logon's da lista
	  * 
	  * @return int -      Numero total de logon's
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getNumeroLogon(){
		return filhoLogon.getTamanho();
	}
	
	/**
	  * Adiciona uma atividade na lislta de acordo com o tipo da classe que recebe no parametro
	  * 
	  * @param 	newFilho Atividade - Atividade a ser adicionada na lista
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void addFilho(Atividade newFilho){
	
		if(newFilho instanceof Device)
			filhoDevice.addAtividade(((Device) newFilho));
		
		if(newFilho instanceof Http)
			filhoHttp.addAtividade(((Http) newFilho));
		
		if(newFilho instanceof Logon)
			filhoLogon.addAtividade(((Logon) newFilho));
	}
	
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

}