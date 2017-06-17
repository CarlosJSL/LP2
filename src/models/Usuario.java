package models;

/**Classe para objetos do tipo Usuario, onde serão contidos, valores e métodos para a mesma.
 * @author Carlos José
 * @author Judson Matheus
 */
public class Usuario {

	String user_id;
	String employee_name;
	String email;
	String domain;
	String role;
	GeneralTree tree;
	
	/**
	  * Retorna o id do usuário 
	  * 
	  * @return	String -   Id do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getUser_id() {
		return user_id;
	}
	
	/**
	  * Seta o id do usuário 
	  * 
	  * @param	user_id	String - Id do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	/**
	  * Retorna o nome do usuário 
	  * 
	  * @return	String -   Nome do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getEmployee_name() {
		return employee_name;
	}
	
	/**
	  * Seta o nome do usuário 
	  * 
	  * @param	employee_name String - Nome do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	
	/**
	  * Retorna o email do usuário 
	  * 
	  * @return	String -   Email do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getEmail() {
		return email;
	}
	
	/**
	  * Seta o email do usuário 
	  * 
	  * @param	email String - Email do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	  * Retorna o dominio do usuário 
	  * 
	  * @return	String -   Dominio do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getDomain() {
		return domain;
	}
	
	/**
	  * Seta o domínio do usuário 
	  * 
	  * @param domain String - Domínio do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	
	/**
	  * Retorna a função do usuário 
	  * 
	  * @return	String -   Função do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public String getRole() {
		return role;
	}
	
	/**
	  * Seta a função do usuário 
	  * 
	  * @param	role String - Função do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setRole(String role) {
		this.role = role;
	}
	
	/**
	  * Retorna a arvore genérica do usuário 
	  * 
	  * @return	GeneralTree - Árvore genérica do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public GeneralTree getTree() {
		return tree;
	}
	
	/**
	  * Seta a árvore genérica do usuário 
	  * 
	  * @param tree	GeneralTree - Árvore do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setTree(GeneralTree tree) {
		this.tree = tree;
	}
	
	/**
	  * Retorna o número total de devices desse usuário
	  * 
	  * @return	int -      Número total de devices do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getNumeroDevice(){	
		return tree.getNumeroDevice();
	}
	
	/**
	  * Retorna o número total de http's desse usuário
	  * 
	  * @return	int -	   Número total de http's do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getNumeroHttp(){
		return tree.getNumeroHttp();
	}
	
	/**
	  * Retorna o número total de devices desse usuário
	  * 
	  * @return	int -	   Número total de logon's do usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getNumeroLogon(){
		return tree.getNumeroLogon();
	}

	@Override
	public String toString() {
		return "Usuario [user_id=" + user_id + ", employee_name=" + employee_name + ", email=" + email + ", domain="
				+ domain + ", role=" + role + ", tree=" + tree + "]";
	}

}
