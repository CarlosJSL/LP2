package interfaceDoPrograma;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.ArvoreBinaria;
import models.Usuario;

/**Classe que cria um componente para realizar a busca de um usuário
 * @author Carlos José
 * @author Judson Matheus
 */
public class BuscaUsuario extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel controle;
	private JButton botaoAddLog;

	private JTextField textAddLog;

	private ArvoreBinaria arvoreUsuario = null;
	
	/**
	  * Construtor que a partir de uma árvore binária, busca um usuário.
	  * 
	  * @param arvore ArvoreBinaria - Árvore Binária cuja se deseja buscar o usuário	
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	public BuscaUsuario(ArvoreBinaria arvore) {
		arvoreUsuario = arvore;
		Container container = this.getContentPane();
		container.setLayout(new BorderLayout());

		controle = new JPanel();
		controle.setLayout(new GridLayout(2, 1));

		botaoAddLog = new JButton("Buscar");

		textAddLog = new JTextField();

		controle.add(textAddLog);
		controle.add(botaoAddLog);

		container.add(BorderLayout.CENTER, controle);
		botaoAddLog.addActionListener(this);

		setSize(400, 100);
		setResizable(false);
		setTitle("Buscar Usuario");

	}
	
	/**
	  * Função que escuta um evento e realiza a busca do usuário
	  * 
	  * @param	evento ActionEvent - Evento a ser escutado
	  * @author            Carlos José
	  * @author            Judson Matheus
	  */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource() == botaoAddLog) {
			String idUsuario = textAddLog.getText();
			Usuario usuario = new Usuario();

			usuario = arvoreUsuario.busca(idUsuario);

			if (usuario == null) {
				textAddLog.setText("Usuario n�o existe!");

			} else {
				new Grafico(usuario, usuario.getTree().getFilhoDevice()).setVisible(true);
				new Grafico(usuario, usuario.getTree().getFilhoLogon()).setVisible(true);
				new Grafico(usuario, usuario.getTree().getFilhoHttp()).setVisible(true);
				
			}
		}
	}
}
