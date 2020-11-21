package source;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaPrepararBanco extends JFrame {

	private JPanel panel_main;
	private JTextField Tuser;
	private JPasswordField Password;
	private JTextField Tnome;
	private JPasswordField Password1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrepararBanco frame = new TelaPrepararBanco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrepararBanco() {
		setTitle("Preparar BD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 300, 300);
		panel_main = new JPanel();
		panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel_main);
		panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(panel_main.getLayout());
		
		JPanel panel00 = new JPanel();
		panel_main.add(panel00, "0");
		panel00.setLayout(null);
		
		JPanel panel10 = new JPanel();
		panel_main.add(panel10, "1");
		panel10.setLayout(null);
		
		
		
		JLabel Luser = new JLabel("User do Banco:");
		Luser.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Luser.setBounds(25, 10, 150, 30);
		panel00.add(Luser);
		
		JLabel Lsenha = new JLabel("Senha do Banco:");
		Lsenha.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lsenha.setBounds(25, 80, 150, 30);
		panel00.add(Lsenha);
		
		Tuser = new JTextField();
		Tuser.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Tuser.setBounds(25, 40, 226, 30);
		panel00.add(Tuser);
		Tuser.setColumns(10);
		
		Password = new JPasswordField();
		Password.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Password.setBounds(25, 110, 226, 30);
		panel00.add(Password);
		
		JButton Bcriar = new JButton("Criar");
		Bcriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CriarBanco.setUser(Tuser.getText());
					CriarBanco.setPassword(String.valueOf(Password.getPassword()));
					FabricaConexao.setUser(Tuser.getText());
					FabricaConexao.setPassword(String.valueOf(Password.getPassword()));
					CriarBanco.main();			
					CriarTabelas.main();
					int input = JOptionPane.showConfirmDialog(null, "Banco Criado com Sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (input == 0) {
						cl.show(panel_main, "1");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		Bcriar.addKeyListener(new KeyAdapter() {
			//quando aperta ENTER enquanto o botão estiver selecionado
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
		        if (keyCode == KeyEvent.VK_ENTER) {
					try {
						CriarBanco.setUser(Tuser.getText());
						CriarBanco.setPassword(String.valueOf(Password.getPassword()));
						FabricaConexao.setUser(Tuser.getText());
						FabricaConexao.setPassword(String.valueOf(Password.getPassword()));
						CriarBanco.main();			
						CriarTabelas.main();
						int input = JOptionPane.showConfirmDialog(null, "Banco Criado com Sucesso!", "Confirmação", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (input == 0) {
							cl.show(panel_main, "1");
						}
					} catch (SQLException ev) {
						// TODO Auto-generated catch block
						ev.printStackTrace();
					}
		        }
			}
		});
		Bcriar.setToolTipText("Cria o Banco. Clique aqui");
		Bcriar.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Bcriar.setBounds(75, 165, 119, 50);
		panel00.add(Bcriar);
		
		
		
		
		JLabel Luser1 = new JLabel("Nome:");
		Luser1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Luser1.setBounds(25, 10, 92, 30);
		panel10.add(Luser1);
		
		Tnome = new JTextField();
		Tnome.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Tnome.setColumns(10);
		Tnome.setBounds(25, 40, 226, 30);
		panel10.add(Tnome);
		
		JLabel Lsenha1 = new JLabel("Senha:");
		Lsenha1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lsenha1.setBounds(25, 80, 92, 30);
		panel10.add(Lsenha1);
		
		Password1 = new JPasswordField();
		Password1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Password1.setBounds(25, 110, 226, 30);
		panel10.add(Password1);
		
		JButton Bcriar1 = new JButton("Criar Login");
		Bcriar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					CriarTabelas.criarlogin(Tnome.getText(), String.valueOf(Password1.getPassword()));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Bcriar1.setToolTipText("Cria o Banco. Clique aqui");
		Bcriar1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Bcriar1.setBounds(70, 166, 139, 50);
		panel10.add(Bcriar1);
	}
}
