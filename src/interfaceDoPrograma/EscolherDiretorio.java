
package interfaceDoPrograma;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import models.ArquivoCSV;

/**Classe que contém métodos responsáveis por escolher um arquivo para o usuário
 * @author Carlos José
 * @author Judson Matheus
 */
public class EscolherDiretorio extends JPanel implements ActionListener {
	static private final String novaLinha = "\n";
	JButton openButton, saveButton;
	JTextArea log;
	JFileChooser fc;
	
	/**
	  * Construtor que quando chama serve para que o
	  * usuário escolha o seu arquivo que deseja abrir e cadastrar
	  * 
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public EscolherDiretorio() {
		super(new BorderLayout());

		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 500, 500));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		fc = new JFileChooser();

		openButton = new JButton("Open a File...");
		openButton.addActionListener(this);

		saveButton = new JButton("Save a File...");
		saveButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(openButton);
		buttonPanel.add(saveButton);

		add(buttonPanel, BorderLayout.PAGE_START);
		add(logScrollPane, BorderLayout.CENTER);
	}
	
	/**
	  * Função que escuta um evento que é disparado quando o usuário
	  * aperta o botão
	  * 
	  * @param	e ActionEvent -	Evento de clique
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == openButton) {
			int returnVal = fc.showOpenDialog(EscolherDiretorio.this);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				log.append("Arquivo aberto agora: " + file.getName() + "." + novaLinha);

			} else {
				log.append("Comando cancelado pelo usuario." + novaLinha);

			}
			log.setCaretPosition(log.getDocument().getLength());

		} else if (e.getSource() == saveButton) {
			File file = fc.getSelectedFile();

			Stack informacao = new Stack();
			ArquivoCSV newArquivo = new ArquivoCSV();

			informacao = newArquivo.lerCSV(file.getName());
			newArquivo.gravarCSV(informacao);
			
			log.append("Salvo: " + file.getName() + "." + novaLinha);
			log.setCaretPosition(log.getDocument().getLength());
		}
	}

}