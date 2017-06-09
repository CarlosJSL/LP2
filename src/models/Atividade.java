package models;

public class Atividade {
	String id;
	String date;
	String id_user;
	String pc;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId_user() {
		return id_user;
	}

	public void setId_user(String id_user) {
		this.id_user = id_user;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		return "Atividade [id=" + id + ", date=" + date + ", id_user=" + id_user + ", pc=" + pc + "]";
	}

}
