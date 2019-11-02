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
package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Di�logo para ingresar un paciente a una unidad.
 */
public class DialogoInternarPaciente extends JDialog implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------

	/**
	 * Comando para ingresar un paciente.
	 */
	private static final String INTERNAR = "INTERNAR";
	
	/**
	 * Comando para cancelar el ingreso de un paciente.
	 */
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

	/**
	 * Etiqueta con el nombre del paciente.
	 */
	private JLabel lblNombre;

	/**
	 * Etiqueta con el apellido del paciente.
	 */
	private JLabel lblApellido;

	/**
	 * Etiqueta con el n�mero de identificaci�n del paciente.
	 */
	private JLabel lblNumeroIdentificacion;
	
	/**
	 * Etiqueta con la edad del paciente.
	 */
	private JLabel lblEdad;

	/**
	 * Etiqueta con el motivo de ingreso del paciente.
	 */
	private JLabel lblMotivoIngreso;

	/**
	 * Etiqueta con los d�as de hospitalizaci�n del paciente.
	 */
	private JLabel lblDiasHospitalizacion;

	/**
	 * Etiqueta con el diagn�stico del paciente
	 */
	private JLabel lblDiagnostico;

	/**
	 * Etiqueta con la unidad donde se ingresar� el paciente.
	 */
	private JLabel lblUnidad;

	/**
	 * Campo de texto con el nombre del paciente.
	 */
	private JTextField txtNombre;

	/**
	 * Campo de texto con el apellido del paciente.
	 */
	private JTextField txtApellido;

	/**
	 * Campo de texto con el n�mero de identificaci�n del paciente.
	 */
	private JTextField txtNumeroIdentificacion;

	/**
	 * Campo de texto con la edad del paciente.
	 */
	private JTextField txtEdad;

	/**
	 * Campo de texto con el di�gnostico del paciente.
	 */
	private JTextField txtDiagnostico;

	/**
	 * Campo de texto con los d�as de hospitalizaci�n del paciente.
	 */
	private JTextField txtDiasHospitalizacion;

	/**
	 * Combo donde aparecen los motivos de ingreso del paciente.
	 */
	private JComboBox comboMotivoIngreso;

	/**
	 * Combo donde aparecen las unidades del hospital.
	 */
	private JComboBox comboUnidad;



	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------
	/**
	 * Constructor del di�logo.
	 * @param ventanaPrincipal Ventana principal. ventanaPrincipal != null.
	 */
	public DialogoInternarPaciente(InterfazApp ventanaPrincipal) 
	{
		principal = ventanaPrincipal;
		setSize(400, 350);
		setTitle( "Internar paciente");
		JPanel panelAuxiliar= new JPanel();
		panelAuxiliar.setLayout( new GridLayout( 9, 2 ) );
		panelAuxiliar.setBorder( BorderFactory.createTitledBorder( "Datos del paciente" ) );

		lblNombre = new JLabel( "Nombre:" );
		lblApellido = new JLabel( "Apellido:" );
		lblNumeroIdentificacion = new JLabel( "N�mero de identificaci�n:" );
		lblEdad = new JLabel("Edad:");
		lblDiasHospitalizacion = new JLabel( "D�as hospitalizaci�n:" );
		lblDiagnostico = new JLabel( "Diagn�stico:" );
		lblUnidad = new JLabel( "Unidad:" );
		lblMotivoIngreso = new JLabel( "Motivo ingreso:" );

		txtNombre = new JTextField( "" );
		txtApellido = new JTextField( "" );
		txtNumeroIdentificacion = new JTextField( "" );
		txtEdad = new JTextField("");
		txtDiasHospitalizacion = new JTextField( "" );
		txtDiagnostico = new JTextField( "" );
		comboUnidad = new JComboBox( );
		comboMotivoIngreso = new JComboBox( );

		inicializarCombos();

		btnInternar = new JButton( "Internar" );
		btnInternar.setActionCommand( INTERNAR );
		btnInternar.addActionListener( this );

		btnCancelar = new JButton( "Cancelar" );
		btnCancelar.setActionCommand( CANCELAR );
		btnCancelar.addActionListener( this );


		panelAuxiliar.add( lblNombre );
		panelAuxiliar.add( txtNombre );

		panelAuxiliar.add( lblApellido );
		panelAuxiliar.add( txtApellido );

		panelAuxiliar.add( lblNumeroIdentificacion );
		panelAuxiliar.add( txtNumeroIdentificacion );

		panelAuxiliar.add( lblEdad );
		panelAuxiliar.add( txtEdad );

		panelAuxiliar.add( lblDiasHospitalizacion );
		panelAuxiliar.add( txtDiasHospitalizacion );

		panelAuxiliar.add( lblDiagnostico );
		panelAuxiliar.add( txtDiagnostico );

		panelAuxiliar.add( lblUnidad );
		panelAuxiliar.add( comboUnidad );

		panelAuxiliar.add( lblMotivoIngreso );
		panelAuxiliar.add( comboMotivoIngreso );

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
		Unidad[] unidades = principal.obtenerUnidades();
		for( int i = 0; i < unidades.length; i++ )
		{
			comboUnidad.addItem( unidades[ i ].darNombre( )+ " - " + parsearTipo(unidades[ i ].darTipo( )) );
		}	

		String[] motivos = { "Accidente", "Cirug�a", "Infecci�n", "Parto", "Tratamiento" };
		for( int i = 0; i < motivos.length; i++ )
		{
			comboMotivoIngreso.addItem( motivos[ i ] );
		}
	}

	/**
	 * Cambia el tipo de la unidad de Tipo a String.
	 * @param pTipo tipo de la unidad.
	 * @return Tipo de la unidad como cadena de caracteres.
	 */
	private String parsearTipo (Tipo pTipo)
	{
		String rta = "Cuidados intensivos";
		if(pTipo==Tipo.CUIDADOS_INTERMEDIOS)
		{
			rta= "Cuidados intermedios";
		}
		else if(pTipo == Tipo.PEDIATRIA)
		{
			rta= "Pediatr�a";
		}
		else if(pTipo == Tipo.MATERNIDAD)
		{
			rta= "Maternidad";
		}
		else if (pTipo == Tipo.GERIATRIA)
		{
			rta= "Geriatr�a";
		}
		else if (pTipo == Tipo.OBSERVACION)
		{
			rta = "Observaci�n";
		}
		return rta;
	}
	
	/**
	 * Manejo de los eventos de los botones.
	 * @param e Evento asociado al click en un bot�n. e != null.
	 */
	public void actionPerformed( ActionEvent evento )
	{
		String comando = evento.getActionCommand( );

		if( comando.equals( INTERNAR ) )
		{
			String nombre = txtNombre.getText();
			String apellido = txtApellido.getText();
			String numeroIdentificacionStr = txtNumeroIdentificacion.getText();
			String edadStr = txtEdad.getText();
			String diagnostico = txtDiagnostico.getText();
			String diasHospitalizacionStr = txtDiasHospitalizacion.getText();
			if( nombre == null || nombre.equals( "" ) )
			{
				JOptionPane.showMessageDialog( this, "El nombre no es v�lido.", "Error", JOptionPane.ERROR_MESSAGE );
			}
			else if( apellido == null || apellido.equals( "" ) )
			{
				JOptionPane.showMessageDialog( this, "El apellido no es v�lido.", "Error", JOptionPane.ERROR_MESSAGE );
			}
			else if( numeroIdentificacionStr == null || numeroIdentificacionStr.equals( "" ) )
			{
				JOptionPane.showMessageDialog( this, "El n�mero de identificaci�n no es v�lido.", "Error", JOptionPane.ERROR_MESSAGE );
			}
			else if( diagnostico == null || diagnostico.equals( "" ) )
			{
				JOptionPane.showMessageDialog( this, "El diagn�stico no es v�lido.", "Error", JOptionPane.ERROR_MESSAGE );
			}
			else if( diasHospitalizacionStr == null || diasHospitalizacionStr.equals( "" ) )
			{
				JOptionPane.showMessageDialog( this, "Los d�as de hospitalizaci�n no son v�lidos.", "Error", JOptionPane.ERROR_MESSAGE );
			}
			else 
			{
				try
				{
					int numeroIdentificacion = Integer.parseInt(numeroIdentificacionStr);
					
					if(numeroIdentificacion > 0)
					{
						try
						{
							int edad = Integer.parseInt(edadStr);
							if(edad >= 0)
							{
								try
								{
									int diasHospitalizacion = Integer.parseInt(diasHospitalizacionStr);
									if(diasHospitalizacion>=0)
									{
										String motivoIngresoStr = (String) comboMotivoIngreso.getSelectedItem();
										Motivo motivoIngreso = Motivo.ACCIDENTE;
										if(motivoIngresoStr.equals("Cirug�a"))
										{
											motivoIngreso = Motivo.CIRUGIA;
										}
										else if(motivoIngresoStr.equals("Infecci�n"))
										{
											motivoIngreso = Motivo.INFECCION;
										}
										else if(motivoIngresoStr.equals("Parto"))
										{
											motivoIngreso = Motivo.PARTO;
										}
										else if(motivoIngresoStr.equals("Tratamiento"))
										{
											motivoIngreso = Motivo.TRATAMIENTO;
										}
										
										
										String unidad = ( String )comboUnidad.getSelectedItem( );
								        String elegida = unidad.substring( 0, unidad.indexOf( " - " ) );
								        boolean internado = principal.internarNuevoPaciente(elegida, nombre, apellido, numeroIdentificacion, edad, diagnostico, diasHospitalizacion, motivoIngreso);
								        
								        if (internado == true) 
								        {
								        	dispose();
										}
									}
									else
									{
										JOptionPane.showMessageDialog( this, "Los d�as de hospitalizaci�n no pueden ser negativos.", "Error", JOptionPane.ERROR_MESSAGE );
									}
									
							    }
								catch (Exception ex)
								{
									JOptionPane.showMessageDialog( this, "Los d�as de hospitalizaci�n no deben tener letras.", "Error", JOptionPane.ERROR_MESSAGE );
								}
							}
							else
							{
								JOptionPane.showMessageDialog( this, "La edad no puede ser negativa", "Error", JOptionPane.ERROR_MESSAGE );	
							}
							
						}
						catch (Exception ex)
						{
							if(edadStr.equals(""))
							{
								JOptionPane.showMessageDialog( this, "Debe ingresar la edad.", "Error", JOptionPane.ERROR_MESSAGE );
							}
							else
							{
								JOptionPane.showMessageDialog( this, "La edad no debe tener letras.", "Error", JOptionPane.ERROR_MESSAGE );	
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog( this, "El n�mero de identificaci�n debe ser mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE );
					}
					
				}
				catch (Exception ex)
				{
					JOptionPane.showMessageDialog( this, "El n�mero de identificaci�n no debe tener letras.", "Error", JOptionPane.ERROR_MESSAGE );
				}
			}

		}
		else if( comando.equals( CANCELAR ) )
		{
			dispose();
		}
	}


}
