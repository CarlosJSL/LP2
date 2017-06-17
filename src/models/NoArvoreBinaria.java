package models;

/**Classe para objetos do tipo NoArvoreBinaria, onde serão contidos, valores e métodos para a mesma.
 * @author Carlos José
 * @author Judson Matheus
 */
public class NoArvoreBinaria {
	private Usuario usuario;
	
	/**
	  * Construtor que seta o usuario no nó
	  * 
	  * @param	usuario Usuario - Usuario a ser inserido no nó	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public NoArvoreBinaria(Usuario usuario) {
		this.usuario = usuario;
	}
	
	/**
	  * Retorna o usuário que está inserido naquele nó
	  * 
	  * @return	Usuario -  Usuario que está presente no nó	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	  * Seta o usuário que está inserido naquele nó
	  * 
	  * @param	usuario Usuario - Usuario a ser setado no nó
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "NoArvoreBinaria [usuario=" + usuario + "]";
	}

}
