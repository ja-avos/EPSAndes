/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: cupiHospital
 * Autor: Equipo Cupi2 2019
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.isis2304.epsAndes.interfazApp.adminDatos;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import uniandes.isis2304.epsAndes.interfazApp.InterfazApp;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;
import uniandes.isis2304.epsAndes.negocio.Usuario;

@SuppressWarnings("serial")
public class DialogoAgregarAfiliado extends JDialog implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	private static final String AGREGAR = "AGREGAR";

	private static final String CANCELAR = "CANCELAR";

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------

	/**
	 * Ventana principal de la aplicaci�n
	 */
	private InterfazApp principal;

	// -----------------------------------------------------------------
	// Atributos de Interfaz
	// -----------------------------------------------------------------

	/**
	 * Bot�n para ingresar el paciente.
	 */
	private JButton btnInternar;

	/**
	 * Bot�n para cancelar el ingreso del paciente.
	 */
	private JButton btnCancelar;

	private JLabel lblFechaNacimiento;

	private JTextField txtFechaNacimiento;

	private JLabel lblUsuario;

	private JComboBox comboUsuario;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del di�logo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoAgregarAfiliado(InterfazApp ventanaPrincipal) 
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		principal = ventanaPrincipal;
		setSize(400, 350);
		setTitle( "Agregar afiliado a EPS");
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout( new GridLayout( 6, 2 ) );
		panelAuxiliar.setBorder( BorderFactory.createTitledBorder( "Datos del afiliado" ) );

		lblFechaNacimiento = new JLabel("Fecha de nacimiento: ");
		lblUsuario = new JLabel("Usuario: ");
		
		txtFechaNacimiento = new JTextField( "dd/mm/aaaa" );
		comboUsuario = new JComboBox( );
		comboUsuario.setEditable(true);
		
		inicializarCombos();

		btnInternar = new JButton( "Agregar" );
		btnInternar.setActionCommand( AGREGAR );
		btnInternar.addActionListener( this );

		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.setActionCommand( CANCELAR );
		btnCancelar.addActionListener( this );


		panelAuxiliar.add( lblFechaNacimiento );
		panelAuxiliar.add( txtFechaNacimiento );
		
		panelAuxiliar.add( lblUsuario );
		panelAuxiliar.add( comboUsuario );

		panelAuxiliar.add( btnInternar );
		panelAuxiliar.add( btnCancelar );

		add(panelAuxiliar);
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------


	/**
	 * Inicializa los combos del di�logo.
	 */
	public void inicializarCombos()
	{
		List<Usuario> users = principal.getUsers();
		for( int i = 0; i < users.size(); i++ )
		{
			if(users.get(i).getRol() == 1)
				comboUsuario.addItem( users.get(i).getCorreo() );
		}
	}

	private Usuario parsearCorreo(String correo)
	{
		return principal.getUsuarioByMail(correo);
	}
	
	private Date parsearFecha(String fecha)
	{
		Date date = new Date(0);
		String[] fechaP = fecha.split("/");
		date.setYear(Integer.valueOf(fechaP[2]));
		date.setMonth(Integer.valueOf(fechaP[1])-1);
		date.setDate(Integer.valueOf(fechaP[0]));
		return date;
	}

	/**
	 * Manejo de los eventos de los botones.
	 * @param e Evento asociado al click en un bot�n. e != null.
	 */
	public void actionPerformed( ActionEvent evento )
	{
		String comando = evento.getActionCommand( );

		if( comando.equals( AGREGAR ) )
		{
			String fecha = txtFechaNacimiento.getText();
			Usuario user = parsearCorreo((String)comboUsuario.getSelectedItem());
			if(user==null) {
				JOptionPane.showMessageDialog(this, "Correo invalido");
				dispose();
				return;
			}
			long idUser = user.getId_Usuario();
			try {
				principal.addAfiliado(parsearFecha(fecha), idUser);
				JOptionPane.showMessageDialog(this, "Agregado correctamente!");
				dispose();
			} catch ( Exception e )
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error agregando el Afiliado", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if( comando.equals( CANCELAR ) )
		{
			dispose();
		}
	}


}
