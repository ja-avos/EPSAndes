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

import java.awt.GridLayout;
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

@SuppressWarnings("serial")
public class DialogoAgregarServicioIPS extends JDialog implements ActionListener
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
	
	private IPS ips;

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

	private JLabel lblServicio;
	
	private JLabel lblCapacidad;

	private JLabel lblDia;

	private JLabel lblHoraInicio;

	private JLabel lblHoraFin;

	private JComboBox comboServicio;

	private JTextField txtCapacidad;
	
	private JComboBox comboDia;
	
	private JSpinner sHoraInicio;
	
	private JSpinner sHoraFin;



	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del di�logo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoAgregarServicioIPS(InterfazApp ventanaPrincipal, IPS ips) 
	{
		principal = ventanaPrincipal;
		this.ips = ips;
		setSize(400, 350);
		setTitle( "Agregar servicio a IPS");
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout( new GridLayout( 6, 2 ) );
		panelAuxiliar.setBorder( BorderFactory.createTitledBorder( "Datos del servicio" ) );

		lblServicio = new JLabel("Servicio: ");
		lblCapacidad = new JLabel("Capacidad: ");
		lblDia = new JLabel("Dia: ");
		lblHoraInicio = new JLabel("Hora Inicio: ");
		lblHoraFin = new JLabel("Hora Fin: ");

		txtCapacidad = new JTextField( "" );
		comboServicio = new JComboBox( );
		comboDia = new JComboBox( );
		
		sHoraInicio = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(sHoraInicio, "HH:mm");
		sHoraInicio.setEditor(timeEditor);
		sHoraInicio.setValue(new Date());
		
		sHoraFin = new JSpinner( new SpinnerDateModel() );
		JSpinner.DateEditor timeEditor2 = new JSpinner.DateEditor(sHoraFin, "HH:mm");
		sHoraFin.setEditor(timeEditor2);
		sHoraFin.setValue(new Date());


		inicializarCombos();

		btnInternar = new JButton( "Agregar" );
		btnInternar.setActionCommand( AGREGAR );
		btnInternar.addActionListener( this );

		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.setActionCommand( CANCELAR );
		btnCancelar.addActionListener( this );


		panelAuxiliar.add( lblServicio );
		panelAuxiliar.add( comboServicio );

		panelAuxiliar.add( lblCapacidad );
		panelAuxiliar.add( txtCapacidad );

		panelAuxiliar.add( lblDia );
		panelAuxiliar.add( comboDia );

		panelAuxiliar.add( lblHoraInicio );
		panelAuxiliar.add( sHoraInicio );

		panelAuxiliar.add( lblHoraFin );
		panelAuxiliar.add( sHoraFin );

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
		List<ServicioSalud> servicios = principal.getServiciosSalud();
		for( int i = 0; i < servicios.size(); i++ )
		{
			comboServicio.addItem( servicios.get(i).getNombre() );
		}	

		String[] dias = { "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo" };
		for( int i = 0; i < dias.length; i++ )
		{
			comboDia.addItem( dias[ i ] );
		}
	}

	private long parsearServicio (String nombre)
	{
		for(ServicioSalud s :  principal.getServiciosSalud())
			if(nombre.equals(s.getNombre()))
				return s.getId_Servicio();
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
			long idServicio = parsearServicio((String) comboServicio.getSelectedItem());
			int capacidad = Integer.valueOf(txtCapacidad.getText());
			int dia = comboDia.getSelectedIndex();
			Date horaInicio = (Date) sHoraInicio.getValue();
			Date horaFin = (Date) sHoraFin.getValue();
			try {
				principal.addHorario(ips.getId_IPS(), idServicio, capacidad, dia, new Timestamp(horaInicio.getTime()), new Timestamp(horaFin.getTime()));
			} catch ( Exception e )
			{
				JOptionPane.showMessageDialog(this, e.getMessage(), "Error agregando el servicio", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else if( comando.equals( CANCELAR ) )
		{
			dispose();
		}
	}


}
