//baixar o zip do swingX no link: http://www.java2s.com/Code/Jar/s/Downloadswingxall164jar.htm
//extrair o jar
//adicionar o jar no eclipse 
//(eu adicionei pelo JRE System Library, do mesmo jeito q adicionei o jar da conexão com o BD)

package source;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;



public class TelaRelatorio extends JFrame {
	private ArrayList lista_cliente;
	private String conta;
	
	private JPanel Panel_cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRelatorio frame = new TelaRelatorio();
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
	public TelaRelatorio() {
		setTitle("Relatório");
		setResizable(false);
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		
		JPanel Panel_main = new JPanel();
		Panel_main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Panel_main);
		Panel_main.setLayout(new CardLayout(0, 0));
		CardLayout cl = (CardLayout)(Panel_main.getLayout());
		
		JPanel Panel_init = new JPanel();
		Panel_main.add(Panel_init, "0");
		Panel_init.setLayout(null);
		
		
		
		
		//tela inicial
		JLabel Ltitle = new JLabel("Tipo de Relat\u00F3rio");
		Ltitle.setHorizontalAlignment(SwingConstants.CENTER);
		Ltitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		Ltitle.setBounds(10, 21, 554, 47);
		Panel_init.add(Ltitle);
		
		JButton Binitcliente = new JButton("Relat\u00F3rio Cliente");
		Binitcliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel_main, "1");
			}
		});
		Binitcliente.setFont(new Font("Times New Roman", Font.BOLD, 26));
		Binitcliente.setBounds(165, 161, 247, 71);
		Panel_init.add(Binitcliente);
		
		JButton Binitcontador = new JButton("Relat\u00F3rio Contador");
		Binitcontador.setFont(new Font("Times New Roman", Font.BOLD, 25));
		Binitcontador.setBounds(165, 303, 247, 71);
		Panel_init.add(Binitcontador);
		
		JLabel Lbcliente = new JLabel("Busque por um cliente e conta espec\u00EDfica.\r\n");
		Lbcliente.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lbcliente.setBounds(87, 122, 406, 28);
		Panel_init.add(Lbcliente);
		
		JLabel Lbcontador = new JLabel("Cadastros realizados nos \u00FAltimos 10 dias.");
		Lbcontador.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Lbcontador.setBounds(95, 265, 398, 28);
		Panel_init.add(Lbcontador);
		
		
		
		
		
		//tela "relatorio cliente"
		Panel_cliente = new JPanel();
		Panel_main.add(Panel_cliente, "1");
		Panel_cliente.setLayout(null);
		
		JLabel Lcliente = new JLabel("Nome do Cliente:");
		Lcliente.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lcliente.setBounds(20, 10, 167, 27);
		Panel_cliente.add(Lcliente);	    
		
		JLabel Lsla = new JLabel("Mostra os dados");
	    Lsla.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Lsla.setBounds(177, 263, 231, 27);
	    Panel_cliente.add(Lsla);
		
		AutoCompleteDecorator decorator;
	    JComboBox combobox;
	    //cria arraylist com o get, da coluna "cliente" e "rgi"
		lista_cliente = new ArrayList();
	    try {
			//lista_cliente = get("cliente", "nome_cli");	    		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    combobox = new JComboBox();
	    combobox.addItem(""); combobox.addItem("abacate"); combobox.addItem("abacaxi"); combobox.addItem("amarelo"); combobox.addItem("amanda"); combobox.addItem("amor");
	    //adiciona cada item do arraylist no combobox
	    for (int i = 0; i < lista_cliente.size(); i++) {
	    	combobox.addItem(lista_cliente.get(i));
	    }
	    combobox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    AutoCompleteDecorator.decorate(combobox);
	    combobox.setBounds(20, 40, 510, 39);
	    Panel_cliente.add(combobox);	    
	    //evento que ocorre quando a combobox muda
	    combobox.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {
	    		int i = lista_cliente.indexOf(combobox.getSelectedItem());
	    		
	    	}
	    });
	    
	    JLabel Lmes = new JLabel("M\u00EAs da conta:");
	    Lmes.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Lmes.setBounds(20, 95, 167, 27);
	    Panel_cliente.add(Lmes);
	    
	    String[] meses = {"", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
	    JComboBox combobox_1 = new JComboBox(meses);
	    combobox_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    combobox_1.setBounds(20, 125, 174, 39);
	    Panel_cliente.add(combobox_1);
	    AutoCompleteDecorator.decorate(combobox_1);
	    
	    JRadioButton Ragua = new JRadioButton("\u00C1gua");
		Ragua.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				conta = "a";
			}
		});
	    Ragua.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Ragua.setBounds(292, 130, 91, 35);
	    Panel_cliente.add(Ragua);
	    
	    JRadioButton Rluz = new JRadioButton("Luz");
	    Rluz.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				conta = "l";
			}
		});
	    Rluz.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Rluz.setBounds(416, 130, 91, 35);
	    Panel_cliente.add(Rluz);
	    
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(Ragua);
		buttongroup.add(Rluz);
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(Panel_main, "0");
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton.setBounds(88, 380, 130, 50);
		Panel_cliente.add(btnNewButton);
		
		JButton btnGerarPdf = new JButton("Gerar PDF");
		btnGerarPdf.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnGerarPdf.setBounds(370, 380, 130, 50);
		Panel_cliente.add(btnGerarPdf);
		
		JLabel lblNewLabel = new JLabel("*ultimas 6 contas do cliente selecionado");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(322, 430, 231, 22);
		Panel_cliente.add(lblNewLabel);
		

	}
	

	private void setDefaultCloseOperation(Object dispose) {
		// TODO Auto-generated method stub
	}
	
	public static ArrayList get(String tabela, String coluna) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement  pegar = con.prepareStatement("SELECT * FROM " + tabela);
			ResultSet resultado = pegar.executeQuery();
		
			ArrayList array = new ArrayList();
			while (resultado.next()) {
				array.add(resultado.getString(coluna));
			}
		
			System.out.println("Get finalizado");
			return array;
		}
		catch (Exception e) {
			System.out.println("erro no get " + e);
		}
		return null;
	}
}
