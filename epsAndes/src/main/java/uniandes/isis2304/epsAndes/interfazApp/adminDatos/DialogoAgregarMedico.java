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
import uniandes.isis2304.epsAndes.negocio.Usuario;

@SuppressWarnings("serial")
public class DialogoAgregarMedico extends JDialog implements ActionListener
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

	private JLabel lblRegMed;
	
	private JLabel lblEspecialidad;

	private JLabel lblUsuario;
	
	private JComboBox comboUsuario;

	private JTextField txtRegMed;
	
	private JTextField txtEspecialidad;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del di�logo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoAgregarMedico(InterfazApp ventanaPrincipal) 
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		principal = ventanaPrincipal;
		setSize(400, 350);
		setTitle( "Agregar usuario a EPS");
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout( new GridLayout( 6, 2 ) );
		panelAuxiliar.setBorder( BorderFactory.createTitledBorder( "Datos del usuario" ) );

		lblRegMed = new JLabel("Registro Medico: ");
		lblEspecialidad = new JLabel("Especialidad: ");
		lblUsuario = new JLabel("Usuario: ");

		txtRegMed = new JTextField( "" );
		txtEspecialidad = new JTextField( "" );
		comboUsuario = new JComboBox( );
		comboUsuario.setEditable(true);

		inicializarCombos();

		btnInternar = new JButton( "Agregar" );
		btnInternar.setActionCommand( AGREGAR );
		btnInternar.addActionListener( this );

		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.setActionCommand( CANCELAR );
		btnCancelar.addActionListener( this );


		panelAuxiliar.add( lblRegMed);
		panelAuxiliar.add( txtRegMed );

		panelAuxiliar.add( lblEspecialidad );
		panelAuxiliar.add( txtEspecialidad );

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
			if(users.get(i).getRol() == 2)
				comboUsuario.addItem( users.get(i).getCorreo() );
		}
	}

	private Usuario parsearCorreo(String correo)
	{
		return principal.getUsuarioByMail(correo);
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
			String espe = txtEspecialidad.getText();
			long regMed = Long.valueOf(txtRegMed.getText());
			Usuario user = parsearCorreo((String)comboUsuario.getSelectedItem());
			if(user==null) {
				JOptionPane.showMessageDialog(this, "Correo invalido");
				dispose();
				return;
			}
			long idUser = user.getId_Usuario();
			try {
				principal.addMedico(regMed, espe, idUser);
				JOptionPane.showMessageDialog(this, "Agregado correctamente!");
				dispose();
			} catch ( Exception e )
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error agregando el Medico", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if( comando.equals( CANCELAR ) )
		{
			dispose();
		}
	}


}
