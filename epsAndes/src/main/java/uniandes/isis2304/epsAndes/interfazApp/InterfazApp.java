package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.BorderLayout;
import java.sql.Timestamp;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.epsAndes.interfazApp.adminDatos.PanelAdmin;
import uniandes.isis2304.epsAndes.negocio.EPSAndes;
import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;
import uniandes.isis2304.epsAndes.negocio.Usuario;

public class InterfazApp extends JFrame {
	
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(InterfazApp.class.getName());
	
	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json";
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
    /**
     * Objeto JSON con los nombres de las tablas de la base de datos que se quieren utilizar
     */
    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
	private EPSAndes eps;
	
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
	
	private LoginPanel loginPanel;
	
	public InterfazApp()
	{
		setTitle("EPSAndes");
		setSize(600, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		eps = new EPSAndes();
		
		loginPanel = new LoginPanel(this);
		add(loginPanel, BorderLayout.CENTER);
		//pAdmin = new PanelAdmin(this, new Usuario(1, "", "", 2, 1, 1));
		//add(pAdmin, BorderLayout.CENTER);
		
	}
	
	public void login(String mail)
	{
		try {
			//Usuario user = eps.getUserByEmail(mail);
			//switch ((int)user.getRol()) {
			switch (Integer.valueOf(mail)) {
			case 1:
				JOptionPane.showMessageDialog(this, "El ambiente para Afiliado sigue en construccion");
				break;
			case 2:
				JOptionPane.showMessageDialog(this, "El ambiente para Medico sigue en construccion");
				break;
			case 3:
				JOptionPane.showMessageDialog(this, "El ambiente para Recepcionista sigue en construccion");
				break;
			case 4:
				JOptionPane.showMessageDialog(this, "El ambiente para Admin de Datos sigue en construccion");
				pAdmin = new PanelAdmin(this, new Usuario(1, "", "", 2, 1, 1));
				pAdmin.setVisible(true);
				break;
			case 5:
				JOptionPane.showMessageDialog(this, "El ambiente para Gerente sigue en construccion");
				break;
			default:
				throw new Exception("Existe el usuario con error. Comunicarse con IT.");
			}
			
		} catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "El correo que se ha ingresado no existe en el sistema. " + e.getMessage(), "Correo inválido", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	
	public void showHelp()
	{
		String msg = "EPSAndes es un sistema que apoya el funcionamiento "
				+ "de las EPSs colombianas. Esta versión es realizada por \n\t"
				+ " Catalina Alcalá y Juan Avelino. \n"
				+ "Cualquier inquietud comunicarse al correo:\n\t"
				+ " {c.alcala, ja.avelino}@uniandes.edu.co";
		JOptionPane.showMessageDialog(this, msg, "Ayuda", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public IPS getIPSByID(long id)
	{
		return eps.getIPSById(id);
	}
	
	public ServicioSalud getServicioSaludByID(long id)
	{
		return eps.getServicioSaludByID(id);
	}
	
	public List<ServicioSalud> getServiciosSalud()
	{
		return eps.getServiciosSalud();
	}
	
	public void addHorario(long ips, long servicio, int capacidad, int dia, Timestamp inicio, Timestamp fin)
	{
		eps.addHorario(ips, servicio, capacidad, dia, inicio, fin);
	}
	
	public List<Horario> getHorariosByIPS(long id)
	{
		return eps.getHorariosByIPS(id);
	}
	
	public void deleteHorarioByID(long id)
	{
		eps.deleteHorario(id);
	}

	public static void main(String[] args) {
		
		InterfazApp i = new InterfazApp();
		i.setVisible(true);

	}

}
