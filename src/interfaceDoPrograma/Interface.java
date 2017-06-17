package interfaceDoPrograma;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import models.ArquivoCSV;
import models.ArvoreBinaria;

/**Classe que inicia toda a interface do programa
 * @author Carlos José
 * @author Judson Matheus
 */
public class Interface extends JFrame implements ActionListener {

	JMenu logMenu;
	JMenu relaMenu;
	JMenu arvMenu;
	JMenu sairMenu;
	JMenu histograma;

	JMenuItem mItem1;
	JMenuItem mItem2;
	JMenuItem mItem3;
	JMenuItem mItem4;
	JMenuItem mItem5;

	JTextArea painelPrincipal;
	ArvoreBinaria arvore = new ArvoreBinaria();
	
	/**
	  * Construtor que inicia a interface do programa
	  */
	public Interface() {
		ArquivoCSV arquivo = new ArquivoCSV();

		Stack informacao = new Stack();

		setTitle("Projeto LP2");
		setBounds(600, 200, 600, 600);
		this.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		painelPrincipal = new JTextArea();
		painelPrincipal.setEditable(false);
		painelPrincipal.setLineWrap(true);
		painelPrincipal.setSize(290, 290);
		painelPrincipal.setBounds(10, 10, 500, 500);
		this.add(painelPrincipal);
		if (arvore != null) {
			painelPrincipal.setText("Dados registrados no sistema \n" + "Selecione em relatorio o dado desejado");
		}

		logMenu = new JMenu("Cadastrar Logs");
		relaMenu = new JMenu("Relatorios");
		arvMenu = new JMenu("Visualizar");
		histograma = new JMenu("Histograma");
		sairMenu = new JMenu("Sair");

		menuBar.add(logMenu);
		menuBar.add(relaMenu);
		menuBar.add(arvMenu);
		menuBar.add(histograma);
		menuBar.add(sairMenu);

		// definindo os itens de menu
		mItem1 = new JMenuItem("Logs", 69);
		mItem2 = new JMenuItem("Arvore", 70);
		mItem3 = new JMenuItem("Geral");
		mItem5 = new JMenuItem("Selecionar Usu�rio");
		mItem4 = new JMenuItem("Salvar e sair");

		logMenu.add(mItem1);
		arvMenu.add(mItem2);
		relaMenu.add(mItem3);
		sairMenu.add(mItem4);
		histograma.add(mItem5);

		mItem1.addActionListener(this);
		mItem2.addActionListener(this);
		mItem3.addActionListener(this);
		mItem4.addActionListener(this);
		mItem5.addActionListener(this);
	}
	
	/**
	  * Função que espera um evento de clique 
	  * 
	  * @param	evento ActionEvent - Evento que será acionado quando se aperta um botão	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	@Override
	public void actionPerformed(ActionEvent evento) {

		if (evento.getSource() == mItem1) {
			JFrame frame = new JFrame("FileChooserDemo");

			frame.add(new EscolherDiretorio());
			frame.pack();
			frame.setVisible(true);
		}
		if (evento.getSource() == mItem2) {
			ArquivoCSV arquivo = new ArquivoCSV();

			arvore = arquivo.recuperarEstadoAnterior("backup/usuarios.csv", "backup/device.csv", "backup/http.csv",
					"backup/logon.csv");

			if (arvore.getRaiz() != null) {

				TreeGUI tree = new TreeGUI(arvore);

			} else {
				JOptionPane.showMessageDialog(null, "Não existem registros para serem exibidos!");

			}
		}
		if (evento.getSource() == mItem3) {
			ArquivoCSV arquivo = new ArquivoCSV();

			JFrame frame = new JFrame("Loading");

			ImageIcon loading = new ImageIcon("img/loading.gif");
			frame.add(new JLabel("loading... ", loading, JLabel.CENTER));

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setBounds(400, 400, 1200, 200);
			frame.setUndecorated(true);
			frame.getContentPane().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
			frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));

			arvore = arquivo.recuperarEstadoAnterior("backup/usuarios.csv", "backup/device.csv", "backup/http.csv",
					"backup/logon.csv");
			frame.setVisible(false);

			if (arvore.getRaiz() != null) {
				painelPrincipal.setText("Usuarios: " + arvore.contarElementos(arvore) + "\n" + "Devices: "
						+ arvore.contarDevice(arvore) + "\n" + "Http: " + arvore.contarHttp(arvore) + "\n" + "Logon: "
						+ arvore.contarLogon(arvore) + "\n" + "Para atualizar a pagina clique em RELATORIO -> GERAL");

			} else {
				JOptionPane.showMessageDialog(null, "Não existem registros para serem exibidos!");

			}
		}
		if (evento.getSource() == mItem4) {
			System.exit(0);

		}
		if (evento.getSource() == mItem5) {
			ArquivoCSV arquivo = new ArquivoCSV();

			arvore = arquivo.recuperarEstadoAnterior("backup/usuarios.csv", "backup/device.csv", "backup/http.csv",
					"backup/logon.csv");

			BuscaUsuario buscaUsuario = new BuscaUsuario(arvore);
			buscaUsuario.setVisible(true);

		}
	}
}
