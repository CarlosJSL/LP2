package models;

public class Usuario {

	String user_id;
	String employee_name;
	String email;
	String domain;
	String role;
	GeneralTree tree;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public GeneralTree getTree() {
		return tree;
	}

	public void setTree(GeneralTree tree) {
		this.tree = tree;
	}

	@Override
	public String toString() {
		return "Usuario [user_id=" + user_id + ", employee_name=" + employee_name + ", email=" + email + ", domain="
				+ domain + ", role=" + role + ", tree=" + tree + "]";
	}

}
