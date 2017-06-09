package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class ArquivoCSV {

	@SuppressWarnings("rawtypes")
	public Stack lerCSV(String nomeArquivo) {

		String arquivoCSV = nomeArquivo;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		Stack pilha = new Stack<>();
		Atividade atividade;
		FuncaoFabrica funcaoFabrica = new FuncaoFabrica();
		Usuario teste = new Usuario();

		int pularPrimeiraLinhaCSV = 0;

		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				if (pularPrimeiraLinhaCSV != 0) {
					String[] atributos = linha.split(csvDivisor);
					atividade = funcaoFabrica.tipoDeAtividade(atributos);

					if (atividade == null) {
						Usuario novoUsuario = new Usuario();
						novoUsuario.setEmployee_name(atributos[0]);
						novoUsuario.setUser_id(atributos[1]);
						novoUsuario.setDomain(atributos[2]);
						novoUsuario.setEmail(atributos[3]);
						novoUsuario.setRole(atributos[4]);
						pilha.push(novoUsuario);
					} else {
						pilha.push(atividade);
					}

				} else {
					pularPrimeiraLinhaCSV = 1;
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			pilha = null;
			return pilha;
		} finally {
			if (br != null) {
				try {
					br.close();
					return pilha;
				} catch (IOException e) {
					e.printStackTrace();
					pilha = null;
					return pilha;
				}
			}
		}

		return pilha;
	}


	public ArvoreBinaria gravarCSV(Stack informacao) {

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
			
			if(informacao.peek() instanceof Usuario){
				StrW.write("employee_name,user_id,Domain,Email,Role\n");
			}else if (informacao.peek() instanceof Device ){
				
			}else if (informacao.peek() instanceof Http){
				
			}else if (informacao.peek() instanceof Logon){
				
			}
		

			while (!informacao.isEmpty()) {
					
				
				StrW.write("");

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
