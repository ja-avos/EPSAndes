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
import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;
import uniandes.isis2304.epsAndes.negocio.TipoID;

@SuppressWarnings("serial")
public class DialogoAgregarUsuario extends JDialog implements ActionListener
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

	private JLabel lblNombre;
	
	private JLabel lblCorreo;

	private JLabel lblDocumento;

	private JLabel lblTipoID;

	private JLabel lblRol;

	private JComboBox comboTipoID;
	
	private JComboBox comboRol;

	private JTextField txtNombre;
	
	private JTextField txtCorreo;
	
	private JTextField txtDocumento;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del di�logo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoAgregarUsuario(InterfazApp ventanaPrincipal) 
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		principal = ventanaPrincipal;
		setSize(400, 350);
		setTitle( "Agregar usuario a EPS");
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout( new GridLayout( 6, 2 ) );
		panelAuxiliar.setBorder( BorderFactory.createTitledBorder( "Datos del usuario" ) );

		lblNombre = new JLabel("Nombre: ");
		lblCorreo = new JLabel("Correo: ");
		lblDocumento = new JLabel("Num. de Doc: ");
		lblTipoID = new JLabel("Tipo de Doc: ");
		lblRol = new JLabel("Rol: ");

		txtNombre = new JTextField( "" );
		txtCorreo = new JTextField( "" );
		txtDocumento = new JTextField( "" );
		comboTipoID = new JComboBox( );
		comboRol = new JComboBox( );

		inicializarCombos();

		btnInternar = new JButton( "Agregar" );
		btnInternar.setActionCommand( AGREGAR );
		btnInternar.addActionListener( this );

		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.setActionCommand( CANCELAR );
		btnCancelar.addActionListener( this );


		panelAuxiliar.add( lblNombre);
		panelAuxiliar.add( txtNombre );

		panelAuxiliar.add( lblCorreo );
		panelAuxiliar.add( txtCorreo );

		panelAuxiliar.add( lblDocumento );
		panelAuxiliar.add( txtDocumento );

		panelAuxiliar.add( lblTipoID );
		panelAuxiliar.add( comboTipoID );

		panelAuxiliar.add( lblRol );
		panelAuxiliar.add( comboRol );

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
		List<TipoID> tipos = principal.getTiposID();
		for( int i = 0; i < tipos.size(); i++ )
		{
			comboTipoID.addItem( tipos.get(i).getNombre() );
		}	
		
		List<Rol> roles = principal.getRoles();
		for( int i = 0; i < roles.size(); i++ )
		{
			comboRol.addItem( roles.get(i).getRol() );
		}
	}

	private long parsearTipo (String nombre)
	{
		for(TipoID s :  principal.getTiposID())
			if(nombre.equals(s.getNombre()))
				return s.getId_Tipo();
		return -1;
	}
	
	private long parsearRol (String nombre)
	{
		for(Rol s :  principal.getRoles())
			if(nombre.equals(s.getRol()))
				return s.getId_Rol();
		return -1;
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
			String nombre = txtNombre.getText();
			String correo = txtCorreo.getText();
			long documento = Long.valueOf(txtDocumento.getText());
			long idTipo = parsearTipo((String) comboTipoID.getSelectedItem());
			long idRol = parsearRol((String) comboRol.getSelectedItem());
			try {
				principal.addUsuario(nombre, correo, documento, idTipo, idRol);
				JOptionPane.showMessageDialog(this, "Agregado correctamente!");
				dispose();
			} catch ( Exception e )
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error agregando el Usuario", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if( comando.equals( CANCELAR ) )
		{
			dispose();
		}
	}


}
