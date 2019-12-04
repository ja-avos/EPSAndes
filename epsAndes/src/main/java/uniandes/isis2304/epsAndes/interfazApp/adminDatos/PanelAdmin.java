package uniandes.isis2304.epsAndes.interfazApp.adminDatos;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.isis2304.epsAndes.interfazApp.InterfazApp;
import uniandes.isis2304.epsAndes.interfazApp.PanelMedico;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Usuario;

public class PanelAdmin extends JPanel implements ActionListener{
	
	public static final String CMDUSER = "USUARIOS";
	
	public static final String CMDIPS = "IPS";
	
	public static final String CMDMED= "MEDICOS";
	
	public static final String CMDAFIL = "AFILIADOS";
	
	public static final String CMDSERV = "SERVICIOS";
	
	private static final String BOTONES = "Botones";
	
	private static final String P_SERVICIOS = "Panel Servicios";
	
	private static final String P_USERS = "Panel Usuarios";
	
	private static final String P_IPSS = "Panel IPS's";
	
	private static final String P_AFILIADOS = "Panel Afiliados";
	
	private static final String P_MEDICOS = "Panel Medicos";
	
	private JLabel lblAdmin;
	
	private JLabel lblWelcome;
	
	private JPanel botones;
	
	private JButton btnUsuarios;
	
	private JButton btnIPS;
	
	private PanelAdminIPS panelIPS;
	
	private JButton btnMedico;
	
	private PanelAdminMeds panelMedicos;
	
	private JButton btnAfiliado;
	
	private PanelAdminAfis panelAfiliados;
	
	private JButton btnServicoIPS;
	
	private PanelAdminSerIPS panelServicios;
	
	private PanelAdminUsers panelUsers;
	
	private InterfazApp main;
	
	private Usuario admin;
	
	private JPanel vistas;
	
	public PanelAdmin(InterfazApp p)
	{
		main = p;
		setLayout(new BorderLayout());
		setSize(500, 500);
		
		lblAdmin = new JLabel("Administrador de Datos");
		add(lblAdmin, BorderLayout.NORTH);
		
		botones = new JPanel(new GridLayout(6, 1));
		
		lblWelcome = new JLabel("Bienvenido");
		botones.add(lblWelcome);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.setActionCommand(CMDUSER);
		btnUsuarios.addActionListener(this);
		botones.add(btnUsuarios);
		
		btnIPS = new JButton("IPSs");
		btnIPS.setActionCommand(CMDIPS);
		btnIPS.addActionListener(this);
		botones.add(btnIPS);
		
		btnMedico = new JButton("Medicos");
		btnMedico.setActionCommand(CMDMED);
		btnMedico.addActionListener(this);
		botones.add(btnMedico);
		
		btnAfiliado = new JButton("Afiliados");
		btnAfiliado.setActionCommand(CMDAFIL);
		btnAfiliado.addActionListener(this);
		botones.add(btnAfiliado);
		
		btnServicoIPS = new JButton("Servicios por IPS");
		btnServicoIPS.setActionCommand(CMDSERV);
		btnServicoIPS.addActionListener(this);
		botones.add(btnServicoIPS);
		
		panelServicios = new PanelAdminSerIPS(main, this);
		panelUsers = new PanelAdminUsers(main, this);
		panelIPS = new PanelAdminIPS(main, this);
		panelMedicos = new PanelAdminMeds(main, this);
		panelAfiliados = new PanelAdminAfis(main, this);
		
		vistas = new JPanel(new CardLayout());
		vistas.add(botones, BOTONES);
		vistas.add(panelServicios, P_SERVICIOS);
		vistas.add(panelUsers, P_USERS);
		vistas.add(panelIPS, P_IPSS);
		vistas.add(panelMedicos, P_MEDICOS);
		vistas.add(panelAfiliados, P_AFILIADOS);
		
		add(vistas, BorderLayout.CENTER);
		
		changeView(BOTONES);
		
	}
	
	public void homeAdmin()
	{
		changeView(BOTONES);
	}
	
	public void actualizarUsuario(Usuario u)
	{
		admin = u;
		lblWelcome.setText("Bienvenido " + u.getNombre().split(" ")[0]);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case CMDUSER:
			try
			{
				panelUsers.actualizarUsers();
				changeView(P_USERS);
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Error abriendo ventana de Usuarios");
				ex.printStackTrace();
			}
			break;
		case CMDIPS:
			try
			{
				panelIPS.actualizarIPSs();
				changeView(P_IPSS);
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Error abriendo ventana de IPS's");
				ex.printStackTrace();
			}
			break;
		case CMDMED:
			try
			{
				panelMedicos.actualizarMedicos();
				changeView(P_MEDICOS);
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Error abriendo ventana de Medicos");
				ex.printStackTrace();
			}
			break;
		case CMDAFIL:
			try
			{
				panelAfiliados.actualizarAfiliados();
				changeView(P_AFILIADOS);
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Error abriendo ventana de Afiliados");
				ex.printStackTrace();
			}
			break;
		case CMDSERV:
			try
			{
				long idIPS = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la IPS a editar: "));
				IPS ips = main.getIPSByID(idIPS);
				panelServicios.actualizarIPS(ips);
				changeView(P_SERVICIOS);
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "Error abriendo ventana de Servicios por IPS");
				ex.printStackTrace();
			}
			break;
		default:
			break;
		}
	}
	
	public void changeView(String view)
	{
		CardLayout cl = (CardLayout) vistas.getLayout();
		cl.show(vistas, view);
	}

}
