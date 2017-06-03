package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ArquivoCSV {

	public Stack lerCSV(String nomeArquivo) {

		String arquivoCSV = nomeArquivo;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		Stack <Usuario> usuarios = new Stack<Usuario>();

		Usuario teste = new Usuario();

		int pularPrimeiraLinhaCSV = 0;

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				if (pularPrimeiraLinhaCSV != 0) {

					Usuario novoUsuario = new Usuario();

					String[] atributos = linha.split(csvDivisor);

					novoUsuario.setEmployee_name(atributos[0]);
					novoUsuario.setUser_id(atributos[1]);
					novoUsuario.setDomain(atributos[2]);
					novoUsuario.setEmail(atributos[3]);
					novoUsuario.setRole(atributos[4]);


					usuarios.push(novoUsuario);
				} else {
					pularPrimeiraLinhaCSV = 1;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			usuarios = null;
			return usuarios;
		} finally {
			if (br != null) {
				try {
					br.close();
					return usuarios;
				} catch (IOException e) {
					e.printStackTrace();
					usuarios = null;
					return usuarios;
				}
			}
		}

		return usuarios;
	}

	public ArvoreBinaria gravarCSV(Stack usuarios) {

		String arquivoCSV = "logUsuario";
		BufferedWriter StrW = null;
		String linha = "";
		String csvDivisor = ",";

		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

		Usuario teste = new Usuario();
		NoArvoreBinaria noUsuarioTeste = new NoArvoreBinaria(teste);
		int pularPrimeiraLinhaCSV = 0;

		try {

			StrW = new BufferedWriter(new FileWriter(arquivoCSV));
			StrW.write("employee_name,user_id,Domain,Email,Role\n");

			while (!usuarios.isEmpty()) {
				Usuario novoUsuario = new Usuario();
				novoUsuario =  (Usuario) usuarios.pop();
				StrW.write(novoUsuario.getEmployee_name() + "," + novoUsuario.user_id + "," + novoUsuario.getDomain()
						+ "," + novoUsuario.getEmail() + "," + novoUsuario.getRole() + "\n");
				 
				NoArvoreBinaria noUsuario = new NoArvoreBinaria(novoUsuario);
				 arvoreBinaria.inserir(noUsuario);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			arvoreBinaria = null;
			return arvoreBinaria;
			
		} finally {

			if (StrW != null) {
				try {

					StrW.close();
					return arvoreBinaria;
				} catch (IOException e) {

					e.printStackTrace();
					arvoreBinaria = null;
					return arvoreBinaria;
				}
			}
		}

		return arvoreBinaria;
	}

}
