package Cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;



import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Tela_Inicial {

	JFrame frame;
	
	

	static Connect_Banco conect = new Connect_Banco();
	
	static Tela_Inicial window;
	 JTextField textField;

	Crud_Cadastro banc_Con = new Crud_Cadastro(); 
	Tela_logar tela_logar = new Tela_logar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		
		
		try {
			conect.conexao();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 window = new Tela_Inicial();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
	}

	/**
	 * Create the application.
	 */
	public Tela_Inicial() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 468, 204);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		


		
		JButton btn_logar = new JButton("Logar");
		
		btn_logar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				tela_logar.frame2.setVisible(true);	
				
			}
		});
		btn_logar.setBounds(60, 70, 117, 41);
		frame.getContentPane().add(btn_logar);
		
		JButton btn_Cadastrar = new JButton("Cadastrar");
		btn_Cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				
				banc_Con.frame.setVisible(true);
			
				
				
//			try {
//				cadastro.cadastrar();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			
			
			}
		});
		btn_Cadastrar.setBounds(259, 70, 117, 41);
		frame.getContentPane().add(btn_Cadastrar);
		
		
	}
}
