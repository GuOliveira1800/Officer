package Cadastro;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JLabel;

public class Tela_logar {

	 JFrame frame2;
	 private JTextField text_login;
	 private JTextField text_senha;
	 private JButton btn_logar_voltar;
	 Connect_Banco conect_banco = new Connect_Banco();
	 String teste_login="";
	 String teste_senha="";
	 int id_para_pessoa=0;
	 boolean check;
	 String sql;
	 
	 private JLabel labe;
	 private JLabel lblSenha;
	 private JLabel lblNome;
	 private JLabel lblCpf;
	 private JLabel lblCep;
	 private JLabel lblRg;
	 private JLabel lblEndereco;
	 private JLabel lblNumero;
	 private JTextField textField_login;
	 private JTextField textField_senha;
	 private JTextField textField_Nome;
	 private JTextField textField_CPF;
	 private JTextField textField_CEP;
	 private JTextField textField_RG;
	 private JTextField textField_Endereco;
	 private JTextField textField_Numero;
	 private JTextField textField_UF;
	 private JTextField textField_cidade;
	 private JTextField textField_Complemento;
	 private JTextField textField_Bairro;
	 private JLabel lblBairro;
	 private JLabel lblComplemento;
	 private JLabel lblCidade;
	 private JLabel lblUf;
	 
	 	static Statement st = null;
		static PreparedStatement prest=null;
		static ResultSet result=null;
		static Connection con=null;
	 
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela_logar window = new Tela_logar();
					window.frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela_logar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame2 = new JFrame();
		frame2.setBounds(100, 100, 568, 432);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);
		
		text_login = new JTextField();
		text_login.setBounds(88, 61, 149, 29);
		frame2.getContentPane().add(text_login);
		text_login.setColumns(10);
		
		text_senha = new JTextField();
		text_senha.setColumns(10);
		text_senha.setBounds(299, 61, 149, 29);
		frame2.getContentPane().add(text_senha);
		
		JButton btn_logar = new JButton("Logar");
		btn_logar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 sql = "Select * from Logar;";
				
				try {
					con = conect_banco.conexao();
					prest = con.prepareStatement(sql);
					result = prest.executeQuery();
					
					while (result.next()) {
						
						teste_login = result.getString("login");
						teste_senha = result.getString("senha");
						
						System.out.println(teste_login+teste_senha+"   ===   "+text_login.getText() +text_senha.getText());
						
						if(teste_login.equalsIgnoreCase(text_login.getText()) && teste_senha.equalsIgnoreCase(text_senha.getText())) {
							
							check = true;
							id_para_pessoa = result.getInt("id_logar");
							
							System.out.println(id_para_pessoa);
							
							prest.close();
							con.close();
							
						}
						
					}
					
				
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				Escrever_Dados();
				
			}
		});
		btn_logar.setBounds(148, 165, 89, 23);
		frame2.getContentPane().add(btn_logar);
		
		btn_logar_voltar = new JButton("Voltar");
		btn_logar_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LimparDados();
				frame2.dispose();
				
			}
		});
		btn_logar_voltar.setBounds(299, 165, 89, 23);
		frame2.getContentPane().add(btn_logar_voltar);
		
		textField_login = new JTextField();
		textField_login.setEditable(false);
		textField_login.setBounds(75, 235, 202, 20);
		frame2.getContentPane().add(textField_login);
		textField_login.setColumns(10);
		
		labe = new JLabel("Login");
		labe.setBounds(10, 238, 46, 14);
		frame2.getContentPane().add(labe);
		
		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 263, 46, 14);
		frame2.getContentPane().add(lblSenha);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 288, 46, 14);
		frame2.getContentPane().add(lblNome);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 313, 46, 14);
		frame2.getContentPane().add(lblCpf);
		
		lblCep = new JLabel("CEP");
		lblCep.setBounds(10, 338, 46, 14);
		frame2.getContentPane().add(lblCep);
		
		lblRg = new JLabel("RG");
		lblRg.setBounds(10, 363, 46, 14);
		frame2.getContentPane().add(lblRg);
		
		lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(287, 338, 46, 14);
		frame2.getContentPane().add(lblEndereco);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setBounds(287, 363, 46, 14);
		frame2.getContentPane().add(lblNumero);
		
		textField_senha = new JTextField();
		textField_senha.setEditable(false);
		textField_senha.setColumns(10);
		textField_senha.setBounds(75, 260, 202, 20);
		frame2.getContentPane().add(textField_senha);
		
		textField_Nome = new JTextField();
		textField_Nome.setEditable(false);
		textField_Nome.setColumns(10);
		textField_Nome.setBounds(75, 285, 202, 20);
		frame2.getContentPane().add(textField_Nome);
		
		textField_CPF = new JTextField();
		textField_CPF.setEditable(false);
		textField_CPF.setColumns(10);
		textField_CPF.setBounds(75, 310, 202, 20);
		frame2.getContentPane().add(textField_CPF);
		
		textField_CEP = new JTextField();
		textField_CEP.setEditable(false);
		textField_CEP.setColumns(10);
		textField_CEP.setBounds(75, 335, 202, 20);
		frame2.getContentPane().add(textField_CEP);
		
		textField_RG = new JTextField();
		textField_RG.setEditable(false);
		textField_RG.setColumns(10);
		textField_RG.setBounds(75, 360, 202, 20);
		frame2.getContentPane().add(textField_RG);
		
		textField_Endereco = new JTextField();
		textField_Endereco.setEditable(false);
		textField_Endereco.setColumns(10);
		textField_Endereco.setBounds(343, 335, 202, 20);
		frame2.getContentPane().add(textField_Endereco);
		
		textField_Numero = new JTextField();
		textField_Numero.setEditable(false);
		textField_Numero.setColumns(10);
		textField_Numero.setBounds(343, 360, 202, 20);
		frame2.getContentPane().add(textField_Numero);
		
		textField_UF = new JTextField();
		textField_UF.setEditable(false);
		textField_UF.setColumns(10);
		textField_UF.setBounds(343, 235, 202, 20);
		frame2.getContentPane().add(textField_UF);
		
		textField_cidade = new JTextField();
		textField_cidade.setEditable(false);
		textField_cidade.setColumns(10);
		textField_cidade.setBounds(343, 260, 202, 20);
		frame2.getContentPane().add(textField_cidade);
		
		textField_Complemento = new JTextField();
		textField_Complemento.setEditable(false);
		textField_Complemento.setColumns(10);
		textField_Complemento.setBounds(343, 285, 202, 20);
		frame2.getContentPane().add(textField_Complemento);
		
		textField_Bairro = new JTextField();
		textField_Bairro.setEditable(false);
		textField_Bairro.setColumns(10);
		textField_Bairro.setBounds(343, 310, 202, 20);
		frame2.getContentPane().add(textField_Bairro);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(287, 313, 46, 14);
		frame2.getContentPane().add(lblBairro);
		
		lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(287, 288, 46, 14);
		frame2.getContentPane().add(lblComplemento);
		
		lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(287, 263, 46, 14);
		frame2.getContentPane().add(lblCidade);
		
		lblUf = new JLabel("UF");
		lblUf.setBounds(287, 238, 46, 14);
		frame2.getContentPane().add(lblUf);
	}
	
	public void Escrever_Dados() {
		//Escreve os dados nos campos depois de ter logado
		if (check==true) {
			
			sql = "select * from Pessoa where pessoa_id = "+id_para_pessoa;
			try {
				con = conect_banco.conexao();
				prest = con.prepareStatement(sql);
				result = prest.executeQuery();
				
				result.next();
			
			String tela_login = result.getString("login");
			String tela_senha = result.getString("senha");
			String tela_nome = result.getString("nome");
			long tela_cpf = result.getLong("cpf");
			int tela_rg = result.getInt("rg");
			int tela_cep = result.getInt("cep");
			String tela_endereco = result.getString("endereco");
			int tela_numero = result.getInt("numero");
			String tela_bairro = result.getString("bairro");
			String tela_complemento = result.getString("complemento");
			String tela_cidade = result.getString("cidade");
			String tela_uf = result.getString("uf");
			
			textField_login.setText(tela_login);
			textField_senha.setText(tela_senha);
			textField_Nome.setText(tela_nome); 
			textField_CPF.setText(String.valueOf(tela_cpf));
			textField_RG.setText(String.valueOf(tela_rg));
			textField_CEP.setText(String.valueOf(tela_cep));
			textField_Endereco.setText(tela_endereco);
			textField_Numero.setText(String.valueOf(tela_numero));
			textField_Bairro.setText(tela_bairro);
			textField_Complemento.setText(tela_complemento);
			textField_cidade.setText(tela_cidade);		
			textField_UF.setText(tela_uf);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				prest.close();		
				con.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}else {
		
		JOptionPane.showMessageDialog(null, "Login ou senha errados");
	}
	
}
	
	public void LimparDados() {
		
		 textField_login.setText("");;
		 textField_senha.setText("");;
		 textField_Nome.setText("");;
		 textField_CPF.setText("");;
		 textField_CEP.setText("");;
		 textField_RG.setText("");;
		 textField_Endereco.setText("");;
		 textField_Numero.setText("");;
		 textField_UF.setText("");;
		 textField_cidade.setText("");;
		 textField_Complemento.setText("");;
		 textField_Bairro.setText("");
		 text_senha.setText("");
		
	}
	
}
