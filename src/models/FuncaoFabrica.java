package models;

/**Classe fábrica que contem métodos que retornam um tipo de atividade de acordo com o seu parâmetro
 * @author Carlos José
 * @author Judson Matheus
 */
public class FuncaoFabrica {
	
	/**
	  * Retorna uma atividade baseada no tipo de atributo que a função recebe
	  * 
	  * @param atributos String	- String contendo o atributo que definirá o tipo de retorno
	  * @return Atividade - Retorna uma atividade ou null se o arquivo estiver fora do padrão
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Atividade tipoDeAtividade(String[] atributos) {
		if (atributos[4].compareTo("Connect") == 0 || atributos[4].compareTo("Disconnect") == 0) {
			Device device = new Device();
			device.setId(atributos[0]);
			device.setDate(atributos[1]);
			device.setId_user(atributos[2]);
			device.setPc(atributos[3]);
			device.setActivity(atributos[4]);
			return device;
		}

		if (atributos[4].compareTo("Logon") == 0 || atributos[4].compareTo("Logoff") == 0) {
			Logon logon = new Logon();

			logon.setId(atributos[0]);
			logon.setDate(atributos[1]);
			logon.setId_user(atributos[2]);
			logon.setPc(atributos[3]);
			logon.setActivity(atributos[4]);
			return logon;
		}
		if (atributos[4].contains("http://")) {
			Http http = new Http();

			http.setId(atributos[0]);
			http.setDate(atributos[1]);
			http.setId_user(atributos[2]);
			http.setPc(atributos[3]);
			http.setActivity(atributos[4]);

			return http;
		}

		return null;
	}
}
