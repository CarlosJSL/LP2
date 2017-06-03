package models;

public class ArvoreBinaria {
	private NoArvoreBinaria raiz;
	private ArvoreBinaria arvoreEsquerda;
	private ArvoreBinaria arvoreDireita;

	public ArvoreBinaria() {
	}

	public ArvoreBinaria getArvoreDireita() {
		return arvoreDireita;
	}

	public void setArvoreDireita(ArvoreBinaria arvoreDireita) {
		this.arvoreDireita = arvoreDireita;
	}

	public ArvoreBinaria getArvoreEsquerda() {
		return arvoreEsquerda;
	}

	public void setArvoreEsquerda(ArvoreBinaria arvoreEsquerda) {
		this.arvoreEsquerda = arvoreEsquerda;
	}

	public NoArvoreBinaria getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvoreBinaria raiz) {
		this.raiz = raiz;
	}

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
			}
		}

	}

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

}
