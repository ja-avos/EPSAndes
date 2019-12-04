package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import uniandes.isis2304.epsAndes.interfazApp.adminDatos.PanelAdmin;
import uniandes.isis2304.epsAndes.negocio.Afiliado;
import uniandes.isis2304.epsAndes.negocio.EPSAndes;
import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Medico;
import uniandes.isis2304.epsAndes.negocio.Rol;
import uniandes.isis2304.epsAndes.negocio.ServicioSalud;
import uniandes.isis2304.epsAndes.negocio.TipoID;
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
	
	private static final String ADMIN = "Administrador de Datos";
	
	private static final String GERENTE = "Gerente";
	
	private static final String RECEPCIONISTA = "Recepcionista IPS";
	
	private static final String MEDICO = "Medico";
	
	private static final String AFILIADO = "Afiliado";
	
	private static final String LOGIN = "Log In";

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
	
	private JPanel vistas;
	
	public InterfazApp()
	{
		setTitle("EPSAndes");
		setSize(300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setLayout(new BorderLayout());
		
		eps = new EPSAndes();
		
		loginPanel = new LoginPanel(this);
		pAdmin = new PanelAdmin(this);
		
		vistas = new JPanel(new CardLayout());
		vistas.add(loginPanel, LOGIN);
		vistas.add(pAdmin, ADMIN);
		
		changeView(LOGIN);
		
		add(vistas, BorderLayout.CENTER);
		
	}
	
	public void changeView(String view)
	{
		CardLayout cl = (CardLayout) vistas.getLayout();
		cl.show(vistas, view);
	}
	
	public void login(String mail)
	{
		try {
			Usuario user = eps.getUserByEmail(mail);
			switch ((int)user.getRol()) {
			//switch (Integer.valueOf(mail)) {
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
				pAdmin.actualizarUsuario(user);
				changeView(ADMIN);
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
	
	public List<IPS> getIPSs()
	{
		return eps.getIPSs();
	}
	
	public IPS addIPS(String nombre, String localizacion)
	{
		return eps.addIPS(localizacion, nombre);
	}
	
	public void deleteIPS(long id)
	{
		eps.deleteIPS(id);
	}
	
	public ServicioSalud getServicioSaludByID(long id)
	{
		return eps.getServicioSaludById(id);
	}
	
	public Rol getRolByID(long id)
	{
		return eps.getRolByID(id);
	}
	
	public List<Rol> getRoles()
	{
		return eps.darRoles();
	}
	
	public TipoID getTipoIDByID(long id)
	{
		return eps.getTipoIDByID(id);
	}
	
	public List<TipoID> getTiposID()
	{
		return eps.darTiposID();
	}
	
	public Usuario getUsuarioByID(long id)
	{
		return eps.getUsuarioByID(id);
	}
	
	public Usuario getUsuarioByMail(String mail)
	{
		try {
			return eps.getUserByEmail(mail);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> getUsers()
	{
		return eps.getUsers();
	}
	
	public void addUsuario(String nombre, String correo, long documento, long idTipo, long idRol)
	{
		eps.addUsuario(nombre, correo, documento, idTipo, idRol);
	}
	
	public void deleteUsuario(long id)
	{
		eps.deleteUsuario(id);
	}
	
	public List<ServicioSalud> getServiciosSalud()
	{
		return eps.getServiciosSalud();
	}
	
	public Afiliado addAfiliado(Date fecha, long idUser)
	{
		return eps.addAfiliado(Timestamp.from(fecha.toInstant()), idUser);
	}
	
	public void deleteAfiliado(long id)
	{
		eps.deleteAfiliado(id);
	}
	
	public List<Medico> getMedicos()
	{
		return eps.getMedicos();
	}
	
	public List<Afiliado> getAfiliados()
	{
		return eps.getAfiliados();
	}
	
	public Medico addMedico(long regMed, String espe, long idUser)
	{
		return eps.addMedico(regMed, espe, idUser);
	}
	
	public void deleteMedico(long id)
	{
		eps.deleteMedico(id);
	}
	
	public void addHorario(long ips, long servicio, long capacidad, long dia, Timestamp inicio, Timestamp fin)
	{
		eps.addHorario(ips, servicio, capacidad, dia, inicio, fin, null);
	}
	
	public List<Horario> getHorariosByIPS(long id)
	{
		//return eps.getHorariosByIPS(id);
		return eps.getHorarios();
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
