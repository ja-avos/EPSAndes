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
public class DialogoAgregarIPS extends JDialog implements ActionListener
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
	
	private JLabel lblLocalizacion;

	private JTextField txtNombre;
	
	private JTextField txtLocalizacion;
	
	private boolean finished;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del di�logo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoAgregarIPS(InterfazApp ventanaPrincipal) 
	{
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		principal = ventanaPrincipal;
		setSize(400, 350);
		setTitle( "Agregar IPS a EPS");
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout( new GridLayout( 6, 2 ) );
		panelAuxiliar.setBorder( BorderFactory.createTitledBorder( "Datos de la IPS" ) );

		lblNombre = new JLabel("Nombre: ");
		lblLocalizacion = new JLabel("Localizacion: ");

		txtNombre = new JTextField( "" );
		txtLocalizacion = new JTextField( "" );

		btnInternar = new JButton( "Agregar" );
		btnInternar.setActionCommand( AGREGAR );
		btnInternar.addActionListener( this );

		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.setActionCommand( CANCELAR );
		btnCancelar.addActionListener( this );


		panelAuxiliar.add( lblNombre);
		panelAuxiliar.add( txtNombre );

		panelAuxiliar.add( lblLocalizacion );
		panelAuxiliar.add( txtLocalizacion );

		panelAuxiliar.add( btnInternar );
		panelAuxiliar.add( btnCancelar );

		add(panelAuxiliar);
		finished = false;
	}

	// -----------------------------------------------------------------
	// M�todos
	// -----------------------------------------------------------------
	
	public boolean isFinished()
	{
		return finished;
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
			String localizacion = txtLocalizacion.getText();
			try {
				IPS result = principal.addIPS(nombre, localizacion);
				if(result != null)
					JOptionPane.showMessageDialog(this, "Agregado correctamente!");
				else
					throw new Exception("No se creo la IPS");
				dispose();
			} catch ( Exception e )
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error agregando la IPS", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if( comando.equals( CANCELAR ) )
		{
			dispose();
		}
		finished = true;
	}


}
