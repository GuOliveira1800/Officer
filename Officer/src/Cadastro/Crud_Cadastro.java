package Cadastro;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Crud_Cadastro {

	 JFrame frame;
	JTextField textField;
	JTextField tela_login;
	JTextField tela_nome;
	JTextField tela_rg;
	JTextField tela_cep;
	JTextField tela_endereco;
	JTextField tela_numero;
	JTextField tela_bairro;
	JTextField tela_complemento;
	JTextField tela_cidade;
	JTextField tela_uf;
	JTextField login_frame3;
	JTextField senha_frame3;
	JPasswordField passwordCPF;
	JPasswordField passwordSenha;
	
	String banc_login;
	String banc_senha;
	String banc_nome ;
	String banc_cpf ;
	String banc_cep ;
	String banc_numero ;
	String banc_rg ;
	String banc__endereco ;
	String banc_bairro  ;
	String banc_cidade ;
	String banc_uf ;
	String banc_complemento ;
	
	boolean check=true;
	
	Connect_Banco Con_banco = new Connect_Banco();
	
	static Statement st;
	static PreparedStatement prest;
	static ResultSet result;
	static Connection con;
	
	
	
	
	
		
	

	
	public static void main(String[] args) {
		
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crud_Cadastro window = new Crud_Cadastro();
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
	public Crud_Cadastro() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 573, 471);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tela_login = new JTextField();
		tela_login.setBounds(132, 10, 415, 20);
		frame.getContentPane().add(tela_login);
		tela_login.setColumns(10);
		
		
		
		tela_nome = new JTextField();
		tela_nome.setColumns(10);
		tela_nome.setBounds(132, 60, 415, 20);
		frame.getContentPane().add(tela_nome);
		
		tela_rg = new JTextField();
		tela_rg.setColumns(10);
		tela_rg.setBounds(132, 110, 415, 20);
		frame.getContentPane().add(tela_rg);
		
		tela_cep = new JPasswordField();
		tela_cep.setColumns(10);
		tela_cep.setBounds(132, 135, 415, 20);
		frame.getContentPane().add(tela_cep);
		
		tela_endereco = new JTextField();
		tela_endereco.setColumns(10);
		tela_endereco.setBounds(132, 160, 415, 20);
		frame.getContentPane().add(tela_endereco);
		
		tela_numero = new JTextField();
		tela_numero.setColumns(10);
		tela_numero.setBounds(132, 185, 415, 20);
		frame.getContentPane().add(tela_numero);
		
		tela_bairro = new JTextField();
		tela_bairro.setColumns(10);
		tela_bairro.setBounds(132, 210, 415, 20);
		frame.getContentPane().add(tela_bairro);
		
		tela_complemento = new JTextField();
		tela_complemento.setColumns(10);
		tela_complemento.setBounds(132, 235, 415, 20);
		frame.getContentPane().add(tela_complemento);
		
		tela_cidade = new JTextField();
		tela_cidade.setColumns(10);
		tela_cidade.setBounds(132, 260, 415, 20);
		frame.getContentPane().add(tela_cidade);
		
		tela_uf = new JTextField();
		tela_uf.setColumns(10);
		tela_uf.setBounds(132, 285, 415, 20);
		frame.getContentPane().add(tela_uf);
		
		passwordCPF = new JPasswordField();
		passwordCPF.setColumns(10);
		passwordCPF.setBounds(132, 85, 415, 20);
		frame.getContentPane().add(passwordCPF);
		
		passwordSenha = new JPasswordField();
		passwordSenha.setColumns(10);
		passwordSenha.setBounds(132, 35, 415, 20);
		frame.getContentPane().add(passwordSenha);
		
		JButton btn_salvar = new JButton("Salvar");
		btn_salvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				banc_login = tela_login.getText();
				banc_senha = passwordSenha.getText();
				banc_nome = tela_nome.getText();
				banc_cpf = passwordCPF.getText();
				banc_cep = tela_cep.getText();
				banc_numero = tela_numero.getText();
				banc_rg = tela_rg.getText();
				banc__endereco = tela_endereco.getText();
				banc_bairro = tela_bairro.getText();
				banc_cidade = tela_cidade.getText();
				banc_uf = tela_uf.getText();
				banc_complemento = tela_complemento.getText();
				
					try {
						TesteDadosRepetidos();
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					cadastrar();
					
				
				
			
			}
			
			
		});
		btn_salvar.setBounds(221, 316, 89, 23);
		frame.getContentPane().add(btn_salvar);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 13, 112, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 15));
		lblSenha.setBounds(10, 38, 112, 17);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNome.setBounds(10, 63, 112, 17);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCpf.setBounds(10, 88, 112, 17);
		frame.getContentPane().add(lblCpf);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCep.setBounds(10, 136, 112, 17);
		frame.getContentPane().add(lblCep);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Arial", Font.PLAIN, 15));
		lblRg.setBounds(10, 111, 112, 17);
		frame.getContentPane().add(lblRg);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEndereco.setBounds(10, 163, 112, 17);
		frame.getContentPane().add(lblEndereco);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Arial", Font.PLAIN, 15));
		lblComplemento.setBounds(10, 236, 112, 17);
		frame.getContentPane().add(lblComplemento);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 15));
		lblCidade.setBounds(10, 261, 112, 17);
		frame.getContentPane().add(lblCidade);
		
		JLabel lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Arial", Font.PLAIN, 15));
		lblUf.setBounds(10, 286, 112, 17);
		frame.getContentPane().add(lblUf);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNumero.setBounds(10, 186, 112, 17);
		frame.getContentPane().add(lblNumero);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBairro.setBounds(10, 211, 112, 17);
		frame.getContentPane().add(lblBairro);
		
		JButton btn_voltar = new JButton("Voltar");
		btn_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limparCampos();
				frame.dispose();
				
			}
		});
		btn_voltar.setBounds(336, 316, 89, 23);
		frame.getContentPane().add(btn_voltar);
		
	}
	
	
	
	public void TesteDadosRepetidos() throws NumberFormatException, SQLException {
		
		con = Con_banco.conexao();
		String consulta_CPF = "SELECT cpf,login,senha from Pessoa;";
		banc_cpf = passwordCPF.getText();
		
		
		
		
		
		try {
			prest = con.prepareStatement(consulta_CPF);
			
			result = prest.executeQuery();
			
			while (result.next()) {
				
				long teste_CPF = result.getLong("cpf");
				String teste_login = result.getString("login");
				String teste_senha = result.getString("senha");
				
				
				
				if (teste_CPF == Long.parseLong(banc_cpf) ) {
					
					check=false;
					
				}else if (teste_login.equalsIgnoreCase(banc_login)){
					check=false;
					
				}else if (teste_senha.equalsIgnoreCase(banc_senha)) {
					check=false;
					
				}
			}
		}catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	
	private void cadastrar() {
		
		//Metodo para cadastrar os dados no banco
		// TODO Auto-generated method stub
		
		
		if(check==false) {
			JOptionPane.showMessageDialog(null, "Ja existe um cadastro com esse CPF,login ou senha, por favor insira outro.");
			check=true;
			}else {
				try {
					con = Con_banco.conexao();
					prest = null;
					
					String sql2=("insert into Pessoa (login,senha,nome,cpf,rg,cep,endereco,numero,bairro,complemento,cidade,uf) values (?,?,?,?,?,?,?,?,?,?,?,?)");
					
//					
					
					prest = con.prepareStatement(sql2);
					prest.setString(1, banc_login);
					prest.setNString(2, banc_senha);
					prest.setNString(3, banc_nome);
					prest.setLong(4, Long.parseLong( banc_cpf));
					prest.setInt(5,Integer.parseInt(banc_rg));
					prest.setInt(6,Integer.parseInt(banc_cep));
					prest.setString(7, banc__endereco);
					prest.setInt(8, Integer.parseInt(banc_numero));
					prest.setString(9,banc_bairro);
					prest.setString(10, banc_complemento);
					prest.setString(11, banc_cidade);
					prest.setString(12, banc_uf);
					
					prest.execute();
					
					sql2=("insert into Logar (login,senha) values (?,?)");
					prest = con.prepareStatement(sql2);
					
					prest.setString(1, banc_login);
					prest.setNString(2, banc_senha);
					
					prest.execute();

					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
				
			
			JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso");
			check=true;
			limparCampos();
			
							
				
	}
		
	}
		
		
//		
//	}
	
public void limparCampos() {
	
	banc_login="";
	banc_senha="";
	banc_nome="";
	banc_rg="";
	banc__endereco="";
	banc_numero="";
	banc_bairro="";
	banc_complemento="";
	banc_cidade="";
	banc_uf="";
	banc_cpf="";
	banc_cep="";
	
	tela_login.setText(banc_login);
	tela_nome.setText(banc_nome);
	tela_rg.setText(banc_rg);
	tela_cep.setText(banc_cep);
	tela_endereco.setText(banc__endereco);
	tela_numero.setText(banc_numero);
	tela_bairro.setText(banc_bairro);
	tela_complemento.setText(banc_complemento);
	tela_cidade.setText(banc_cidade);
	tela_uf.setText(banc_uf);
	passwordCPF.setText(banc_cpf);
	passwordSenha.setText(banc_senha);
		
		
		
	}
	

}
