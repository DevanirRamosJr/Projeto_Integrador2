//baixar o zip do swingX no link: http://www.java2s.com/Code/Jar/s/Downloadswingxall164jar.htm
//extrair o jar
//adicionar o jar no eclipse 
//(eu adicionei pelo JRE System Library, do mesmo jeito q adicionei o jar da conexão com o BD)

package source;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class TelaRelatorio extends JFrame {
	private ArrayList lista_cliente;
	private ArrayList lista_rgi;
	
	private JPanel contentPane;

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
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Lcliente = new JLabel("Nome:");
		Lcliente.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Lcliente.setBounds(34, 28, 73, 27);
		contentPane.add(Lcliente);	    
		
		JLabel Lrgi = new JLabel("RGI: ");
	    Lrgi.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    Lrgi.setBounds(69, 171, 231, 27);
	    contentPane.add(Lrgi);
		
		AutoCompleteDecorator decorator;
	    JComboBox combobox;
	    //cria arraylist com o get, da coluna "cliente" e "rgi"
		lista_cliente = new ArrayList();
		lista_rgi = new ArrayList();
	    try {
			lista_cliente = get("cliente");	    		
			lista_rgi = get("rgi");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    combobox = new JComboBox();

	    combobox.addItem("");
	    //adiciona cada item do arraylist no combobox
	    for (int i = 0; i < lista_cliente.size(); i++) {
	    	combobox.addItem(lista_cliente.get(i));
	    }
	    combobox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	    AutoCompleteDecorator.decorate(combobox);
	    combobox.setBounds(34, 66, 288, 39);
	    contentPane.add(combobox);
	    //evento que ocorre quando a combobox muda
	    combobox.addItemListener(new ItemListener() {
	    	public void itemStateChanged(ItemEvent arg0) {
	    		int i = lista_cliente.indexOf(combobox.getSelectedItem());
	    		Lrgi.setText("RGI: " + lista_rgi.get(i));
	    	}
	    });

	}
	

	private void setDefaultCloseOperation(Object dispose) {
		// TODO Auto-generated method stub
	}
	
	public static ArrayList get(String coluna) throws Exception{
		try {
			Connection con = FabricaConexao.getConexao();
			PreparedStatement tabela = con.prepareStatement("SELECT * FROM conta_agua");
			ResultSet resultado = tabela.executeQuery();
		
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
