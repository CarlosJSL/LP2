package models;


/**Classe para objetos do tipo Arvore Binária, onde serão contidos, valores e métodos para a mesma.
 * @author Carlos José
 * @author Judson Matheus
 */
public class ArvoreBinaria {
	private int numeroDeElementos;
	private NoArvoreBinaria raiz;
	private ArvoreBinaria arvoreEsquerda;
	private ArvoreBinaria arvoreDireita;
	
	/**
	 * Constructor vazio
	 */
	public ArvoreBinaria() {
	}
	
	/**
	  * Retorna a sub arvore da direita de uma arvore binaria
	  * 
	  * @return ArvoreBinaria -  Uma nova arvore binaria 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public ArvoreBinaria getArvoreDireita() {
		return arvoreDireita;
	}
	
	/**
	  * Seta a sub arvore da direita de uma arvore binaria
	  * 
	  * @param arvoreDireita ArvoreBinaria - arvore binaria a ser setada
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setArvoreDireita(ArvoreBinaria arvoreDireita) {
		this.arvoreDireita = arvoreDireita;
	}
	
	/**
	  * Retorna a sub arvore da esquerda de uma arvore binaria
	  * 
	  * @return ArvoreBinaria - Uma nova arvore binaria 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public ArvoreBinaria getArvoreEsquerda() {
		return arvoreEsquerda;
	}
	
	/**
	  * Seta a sub arvore da esquerda de uma arvore binaria
	  * 
	  * @param arvoreEsquerda ArvoreBinaria - arvore binaria a ser setada
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setArvoreEsquerda(ArvoreBinaria arvoreEsquerda) {
		this.arvoreEsquerda = arvoreEsquerda;
	}
	
	/**
	  * Retorna o nó raiz de uma arvore binaria
	  * 
	  * @return NoArvoreBinaria -  Arvore binaria que possui aquele nó raiz
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public NoArvoreBinaria getRaiz() {
		return raiz;
	}
	
	/**
	  * Seta o nó raiz de uma arvore binaria
	  * 
	  * @param raiz  NoArvoreBinaria - Arvore binaria cuja se deseja setar o valor
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void setRaiz(NoArvoreBinaria raiz) {
		this.raiz = raiz;
	}
	
	/**
	  * Insere um nó em uma arvore binária de acordo com as regras de árvore binária
	  * O id do usuário foi usado para definir as posições dos nós.
	  * 
	  * @param  no NoArvoreBinaria -  Nó que será inserido na arvore
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void inserir(NoArvoreBinaria no) {

		if (this.raiz == null) {
			this.raiz = no;

		} else {

			if (no.getUsuario().getUser_id().compareTo(this.raiz.getUsuario().getUser_id()) > 0) {

				if (this.arvoreDireita == null) {
					this.arvoreDireita = new ArvoreBinaria();
				}
				this.arvoreDireita.inserir(no);
			} else if (no.getUsuario().getUser_id().compareTo(this.raiz.getUsuario().getUser_id()) < 0) {

				if (this.arvoreEsquerda == null) {
					this.arvoreEsquerda = new ArvoreBinaria();
				}
				this.arvoreEsquerda.inserir(no);
			}else if (no.getUsuario().getUser_id().compareTo(this.raiz.getUsuario().getUser_id()) == 0){
					this.raiz = no;
			}
		}

	}
	
	/**
	  * Percorre a árvore binária em ordem e imprime os valores
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void percorrerInOrder() {
		if (this.raiz == null) {
			return;
		}
		
		if (this.arvoreEsquerda != null) {
			this.arvoreEsquerda.percorrerInOrder();
		}

		System.out.println("Employee Name: " + this.raiz.getUsuario().employee_name + "User_id: "
				+ this.raiz.getUsuario().user_id + "Domain: " + this.raiz.getUsuario().domain + "Email: "
				+ this.raiz.getUsuario().email + "Role: " + this.raiz.getUsuario().role);

		if (this.arvoreDireita != null) {
			this.arvoreDireita.percorrerInOrder();
		}
	}
	
	/**
	  * Percorre a árvore binária em pré-ordem e imprime os valores
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void percorrerPreOrder() {
		if (this.raiz == null) {
			return;
		}

		System.out.println("Employee Name: " + this.raiz.getUsuario().employee_name + "User_id: "
				+ this.raiz.getUsuario().user_id + "Domain: " + this.raiz.getUsuario().domain + "Email: "
				+ this.raiz.getUsuario().email + "Role: " + this.raiz.getUsuario().role);

		if (this.arvoreEsquerda != null) {
			this.arvoreEsquerda.percorrerPreOrder();
		}

		if (this.arvoreDireita != null) {
			this.arvoreDireita.percorrerPreOrder();
		}
	}
	
	/**
	  * Percorre a árvore binária em pós-ordem e imprime os valores
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void percorrerPostOrder() {
		if (this.raiz == null) {
			return;
		}

		if (this.arvoreEsquerda != null) {
			this.arvoreEsquerda.percorrerPostOrder();
		}

		if (this.arvoreDireita != null) {
			this.arvoreDireita.percorrerPostOrder();
		}
		System.out.println("Employee Name: " + this.raiz.getUsuario().employee_name + "User_id: "
				+ this.raiz.getUsuario().user_id + "Domain: " + this.raiz.getUsuario().domain + "Email: "
				+ this.raiz.getUsuario().email + "Role: " + this.raiz.getUsuario().role);

	}
	
	/**
	  * Buscar um usuário na árvore a partir do id.
	  * 
	  * @param user_id Usuario - Id do usuário
	  * @return  Usuario - Usuário que será retorna da busca. Retonar null caso o usuário não esteja na árvore
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Usuario busca(String user_id) {
		if (this.raiz == null) {
			return null;
		} else {
			if (user_id.equals(this.raiz.getUsuario().getUser_id())) {
				return this.raiz.getUsuario();
			} else {
				if (user_id.compareTo(this.raiz.getUsuario().getUser_id()) > 0) {
					if (this.arvoreDireita == null) {
						return null;
					}
					return this.arvoreDireita.busca(user_id);
				} else {
					if (this.arvoreEsquerda == null) {
						return null;
					}
					return this.arvoreEsquerda.busca(user_id);
				}
			}
		}
	}
	
	/**
	  * Retorna a altura da árvore
	  * 
	  * @param	root ArvoreBinaria -  Árvore binária cujo se deseja saber a altura
	  * @return int -  Altura da árvore
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int getAltura(ArvoreBinaria root) {
		if (root == null)
			return 0;
		return Math.max(getAltura(root.getArvoreEsquerda()), getAltura(root.getArvoreDireita())) + 1;
	}
	
	
	/**
	  * Conta o número de usuários que a ávore possui
	  * 
	  * @param 	raiz ArvoreBinaria - Árvore que se deseja saber o número total de usuários
	  * @return  int -     Total de usuários que a ávore possui	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int contarElementos(ArvoreBinaria raiz) {
		
		if (raiz != null) {
			numeroDeElementos = this.contarElementos(raiz.getArvoreEsquerda())+this.contarElementos(raiz.getArvoreDireita())+1;
			return numeroDeElementos;
		}else{
			return 0;
		}
	}
	
	/**
	  * Conta o número de atividades do tipo device que a ávore possui
	  * 
	  * @param 	raiz ArvoreBinaria -  Árvore que se deseja saber o número total de devices
	  * @return  int -     Total de devices que a ávore possui	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int contarDevice(ArvoreBinaria raiz){
		if (raiz != null) {
			numeroDeElementos = this.contarDevice(raiz.getArvoreEsquerda())+this.contarDevice(raiz.getArvoreDireita()) + 
					raiz.getRaiz().getUsuario().getNumeroDevice();
			return numeroDeElementos;
		}else{
			return 0;
		}
	}
	
	/**
	  * Conta o número de atividades do tipo http que a ávore possui
	  * 
	  * @param 	raiz ArvoreBinaria - Árvore que se deseja saber o número total de http's
	  * @return int -      Total de http's que a ávore possui	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int contarHttp(ArvoreBinaria raiz){
		if (raiz != null) {
			numeroDeElementos = this.contarHttp(raiz.getArvoreEsquerda())+this.contarHttp(raiz.getArvoreDireita()) + 
					raiz.getRaiz().getUsuario().getNumeroHttp();
			return numeroDeElementos;
		}else{
			return 0;
		}
	}
	
	/**
	  * Conta o número de atividades do tipo logon que a ávore possui
	  * 
	  * @param 	raiz ArvoreBinaria - Árvore que se deseja saber o número total de logon's
	  * @return int -      Total de logon's que a ávore possui	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public int contarLogon(ArvoreBinaria raiz){
		if (raiz != null) {
			numeroDeElementos = this.contarLogon(raiz.getArvoreEsquerda())+this.contarLogon(raiz.getArvoreDireita()) + 
					raiz.getRaiz().getUsuario().getNumeroLogon();
			return numeroDeElementos;
		}else{
			return 0;
		}
	}

	@Override
	public String toString() {
		return "ArvoreBinaria [raiz=" + raiz + ", arvoreEsquerda=" + arvoreEsquerda + ", arvoreDireita=" + arvoreDireita
				+ "]";
	}

}
