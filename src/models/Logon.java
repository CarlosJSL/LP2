package models;

public class Logon extends Atividade {
	String activity;
	

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return activity;
	}

}
