package interfaceDoPrograma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.ArquivoCSV;


public class InterfaceAddLog extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel controle;
	private JButton botaoAddLog;
	private JTextField textAddLog;
	
	public InterfaceAddLog() {
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());
		
		controle = new JPanel();
		controle.setLayout(new GridLayout(2, 1));
		
		botaoAddLog = new JButton("Adicionar");
		textAddLog = new JTextField();
		controle.add(textAddLog);
		controle.add(botaoAddLog);
		
		container.add(BorderLayout.CENTER, controle);
		botaoAddLog.addActionListener(this);
		
		//JFrame addLog = new JFrame("Adicionar aquivo de log");
		
		setSize(200,100);
		setResizable(false);
		setTitle("Adicionar aquivo de log");
				
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botaoAddLog){
			String arquivo = textAddLog.getText();
			textAddLog.setText(" ");
			//System.out.println(arquivo);
			//A função de lerCSV e gravarCSV deve ficar aqui!
			Stack informacao = new Stack();
			ArquivoCSV newArquivo = new ArquivoCSV();
			
			informacao = newArquivo.lerCSV(arquivo);
			newArquivo.gravarCSV(informacao);
			dispose();
			//Deve usar o nome do arquivo digitado no textFild para chamar o a função lerCSV e passar o resultado para gravarCSV
		}
		
	}
}
