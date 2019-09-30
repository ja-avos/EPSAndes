package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import uniandes.isis2304.epsAndes.negocio.EPSAndes;
import uniandes.isis2304.epsAndes.negocio.Rol;

public class InterfazApp extends JFrame {
	
	//Atributos interfaz
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel titulo;
	
	private JTextField emailTxt;
	
	private JComboBox<Rol> rolCmb;
	
	private PanelAfiliado pAfiliado;
	
	private PanelGerente pGerente;
	
	private PanelAdmin pAdmin;
	
	private PanelRecepcionista pRecepcion;
	
	private PanelMedico pMedico;
	
	private PanelOpciones panelOpciones;
	
	private PanelDatos panellDatos;
	
	private EPSAndes eps;
	
	public InterfazApp()
	{
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		eps = new EPSAndes();
		
		JPanel up = new JPanel(new GridLayout(2, 1));
		
		titulo = new JLabel("EPSAndes", SwingConstants.CENTER);
		titulo.setFont(new Font("Verdana", Font.BOLD, 20));
		up.add(titulo);
		
		JPanel div = new JPanel(new GridLayout(1, 4));
		
		emailTxt = new JTextField();
		div.add(new JLabel("Email"));
		div.add(emailTxt);
		
		rolCmb = new JComboBox<Rol>( (Rol[])eps.darRoles().toArray());
		div.add(new JLabel("Rol"));
		div.add(rolCmb);
		
		up.add(div);
		add(up, BorderLayout.NORTH);
		
		
	}
	
	public void actualizar()
	{
		rolCmb = new JComboBox<Rol>( (Rol[])eps.darRoles().toArray());
	}
	
	public void registrar()
	{
		eps.addRol(JOptionPane.showInputDialog(null, "Crear Rol"));
		actualizar();
	}
	

	public static void main(String[] args) {
		
		InterfazApp i = new InterfazApp();
		i.setVisible(true);

	}

}
