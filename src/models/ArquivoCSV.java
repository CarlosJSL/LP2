package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Stack;

/**Classe que contém métodos para leitura e gravação em arquivos csv
 * @author Carlos José
 * @author Judson Matheus
 */
public class ArquivoCSV {
	
	/**
	  * Retorna uma pilha contendo atividades ou usuários dependendo do arquivo csv lido.
	  * 
	  * @param nomeArquivo String - Nome do arquivo a ser lido
	  * @return Stack -  Pilha contendo todas as atividades ou usuarios do csv lido 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public Stack lerCSV(String nomeArquivo) {
		String arquivoCSV = nomeArquivo;
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		Stack pilha = new Stack<>();
		Atividade atividade;
		FuncaoFabrica funcaoFabrica = new FuncaoFabrica();
		int pularPrimeiraLinhaCSV = 0;

		try {
			try {
				br = new BufferedReader(new FileReader(arquivoCSV));
				
			} catch (FileNotFoundException e) {
//				 e.printStackTrace();
				return pilha;
				
			}
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
	
	/**
	  * Grava as informações lidas anteriormente num arquivo csv
	  * 
	  * @param informacao Stack -  Pilha contendo as informações a serem gravados no arquivo
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void gravarCSV(Stack informacao) {
		BufferedWriter StrW = null;
		String arquivoCSV = "";

		try {
			if (informacao.peek() instanceof Usuario) {
				File file = new File("backup/usuarios.csv");
				
				if (file.exists()) {
					arquivoCSV = "backup/usuarios.csv";
					StrW = new BufferedWriter(new FileWriter(arquivoCSV, true));
					
				} else {
					arquivoCSV = "backup/usuarios.csv";
					StrW = new BufferedWriter(new FileWriter(arquivoCSV, false));
					String tipoDeSistema = System.getProperty("os.name");
					
					if (tipoDeSistema.contains("Windows")) {
						StrW.write("employee_name,user_id,Domain,Email,Role\r\n");
						
					} else {
						StrW.write("employee_name,user_id,Domain,Email,Role\n");
						
					}
				}
				while (!informacao.isEmpty()) {
					Usuario novoUsuario = new Usuario();
					novoUsuario = (Usuario) informacao.pop();
					
					String tipoDeSistema = System.getProperty("os.name");
					
					if (tipoDeSistema.contains("Windows")) {
						StrW.write(novoUsuario.getEmployee_name() + "," + novoUsuario.getUser_id() + ","
								+ novoUsuario.getDomain() + "," + novoUsuario.getEmail() + "," + novoUsuario.getRole()
								+ "\r\n");
						
					} else {
						StrW.write(novoUsuario.getEmployee_name() + "," + novoUsuario.getUser_id() + ","
								+ novoUsuario.getDomain() + "," + novoUsuario.getEmail() + "," + novoUsuario.getRole()
								+ "\n");
						
					}
				}
			} else {
				if (informacao.peek() instanceof Http) {

					File file = new File("backup/http.csv");
					if (file.exists()) {
						arquivoCSV = "backup/http.csv";
						StrW = new BufferedWriter(new FileWriter(arquivoCSV, true));
						
					} else {
						arquivoCSV = "backup/http.csv";
						StrW = new BufferedWriter(new FileWriter(arquivoCSV, false));
						String tipoDeSistema = System.getProperty("os.name");
						
						if (tipoDeSistema.contains("Windows")) {
							StrW.write("id,date,user,pc,url\r\n");
							
						} else {
							StrW.write("id,date,user,pc,url\n");
							
						}
					}

				} else if (informacao.peek() instanceof Device) {
					File file = new File("backup/device.csv");
					
					if (file.exists()) {
						arquivoCSV = "backup/device.csv";
						StrW = new BufferedWriter(new FileWriter(arquivoCSV, true));
						
					} else {
						arquivoCSV = "backup/device.csv";
						StrW = new BufferedWriter(new FileWriter(arquivoCSV, false));
						String tipoDeSistema = System.getProperty("os.name");
						
						if (tipoDeSistema.contains("Windows")) {
							StrW.write("id,date,user,pc,activy\r\n");
							
						} else {
							StrW.write("id,date,user,pc,activy\n");
							
						}
					}
				} else {
					File file = new File("backup/logon.csv");
					if (file.exists()) {
						arquivoCSV = "backup/logon.csv";
						StrW = new BufferedWriter(new FileWriter(arquivoCSV, true));
					} else {
						arquivoCSV = "backup/logon.csv";
						StrW = new BufferedWriter(new FileWriter(arquivoCSV, false));
						String tipoDeSistema = System.getProperty("os.name");
						if (tipoDeSistema.contains("Windows")) {
							StrW.write("id,date,user,pc,activy\r\n");
						} else {
							StrW.write("id,date,user,pc,activy\n");
						}
					}

				}

				while (!informacao.isEmpty()) {
					Atividade atividade = new Atividade();
					atividade = (Atividade) informacao.pop();

					String tipoDeSistema = System.getProperty("os.name");
					
					if (tipoDeSistema.contains("Windows")) {
						StrW.write(atividade.getId() + "," + atividade.getDate() + "," + atividade.getId_user() + ","
								+ atividade.getPc() + "," + atividade.getActivity() + "\r\n");
						
					} else {
						StrW.write(atividade.getId() + "," + atividade.getDate() + "," + atividade.getId_user() + ","
								+ atividade.getPc() + "," + atividade.getActivity() + "\n");
						
					}
				}
			}
		} catch (EmptyStackException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			if (StrW != null) {
				try {
					StrW.close();

				} catch (IOException e) {
					e.printStackTrace();

				}
			}
		}
	}
	
	/**
	  * Lê os arquivos csv's gravados e guarda as informações na arvore binaria
	  * 
	  * @param usuarioCSV  String - CSV contendo a lista usuários
	  * @param DeviceCSV   String - CSV contendo atividades do tipo device  	
	  * @param HttpCSV	   String- CSV contendo atividades do tipo logon	
	  * @param LogonCSV	   String - CSV contendo atividades do tipo http
	  * @return	ArvoreBinaria -  arvoreBinaria - arvore binaria contendo os usuarios cadastrados relacionados com suas respectivas atividades	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public ArvoreBinaria recuperarEstadoAnterior(String usuarioCSV, String DeviceCSV, String HttpCSV, String LogonCSV) {
		Stack usuarios = new Stack<>();
		Stack pilhaAtividade = new Stack<>();

		usuarios = lerCSV(usuarioCSV);
		ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

		while (!usuarios.isEmpty()) {
			GeneralTree arvoreGenerica = new GeneralTree();
			NoArvoreBinaria noUsuario = new NoArvoreBinaria((Usuario) usuarios.pop());
			noUsuario.getUsuario().setTree(arvoreGenerica);
			arvoreBinaria.inserir(noUsuario);
			
		}

		pilhaAtividade = lerCSV(DeviceCSV);

		while (!pilhaAtividade.isEmpty()) {
			Atividade atividade = new Atividade();

			atividade = (Atividade) pilhaAtividade.pop();

			Usuario usuarioJaCadastrado = new Usuario();
			usuarioJaCadastrado = arvoreBinaria.busca(atividade.getId_user().substring(5));
			if (usuarioJaCadastrado != null) {

				usuarioJaCadastrado.getTree().addFilho(atividade);

				NoArvoreBinaria no = new NoArvoreBinaria(usuarioJaCadastrado);
				arvoreBinaria.inserir(no);
			}

		}

		pilhaAtividade = lerCSV(HttpCSV);

		while (!pilhaAtividade.isEmpty()) {
			Atividade atividade = new Atividade();

			atividade = (Atividade) pilhaAtividade.pop();

			Usuario usuarioJaCadastrado = new Usuario();
			usuarioJaCadastrado = arvoreBinaria.busca(atividade.getId_user().substring(5));
			
			if (usuarioJaCadastrado != null) {
				usuarioJaCadastrado.getTree().addFilho(atividade);

				NoArvoreBinaria no = new NoArvoreBinaria(usuarioJaCadastrado);
				arvoreBinaria.inserir(no);
				
			}
		}
		pilhaAtividade = lerCSV(LogonCSV);

		while (!pilhaAtividade.isEmpty()) {
			Atividade atividade = new Atividade();

			atividade = (Atividade) pilhaAtividade.pop();

			Usuario usuarioJaCadastrado = new Usuario();
			usuarioJaCadastrado = arvoreBinaria.busca(atividade.getId_user().substring(5));
			
			if (usuarioJaCadastrado != null) {
				usuarioJaCadastrado.getTree().addFilho(atividade);

				NoArvoreBinaria no = new NoArvoreBinaria(usuarioJaCadastrado);
				arvoreBinaria.inserir(no);
				
			}
		}
		return arvoreBinaria;
	}
}
