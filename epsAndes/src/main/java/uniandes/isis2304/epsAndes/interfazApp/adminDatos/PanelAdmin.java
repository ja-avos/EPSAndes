package uniandes.isis2304.epsAndes.interfazApp.adminDatos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.isis2304.epsAndes.interfazApp.InterfazApp;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Usuario;

public class PanelAdmin extends JFrame implements ActionListener{
	
	private static final String CMDUSER = "USUARIOS";
	
	private static final String CMDIPS = "IPS";
	
	private static final String CMDMED= "MEDICOS";
	
	private static final String CMDAFIL = "AFILIADOS";
	
	private static final String CMDSERV = "SERVICIOS";
	
	private JLabel lblAdmin;
	
	private JLabel lblWelcome;
	
	private JPanel botones;
	
	private JButton btnUsuarios;
	
	//private PanelAdminUser panelUsuarios;
	
	private JButton btnIPS;
	
	//private PanelAdminIPS panelIPS;
	
	private JButton btnMedico;
	
	//private PanelAdminMed panelMedicos;
	
	private JButton btnAfiliado;
	
	//private PanelAdminAfil panelAfiliados;
	
	private JButton btnServicoIPS;
	
	private PanelAdminSerIPS panelServicios;
	
	private InterfazApp main;
	
	public PanelAdmin(InterfazApp p, Usuario u)
	{
		setLayout(new BorderLayout());
		setSize(500, 500);
		
		lblAdmin = new JLabel("Administrador de Datos");
		add(lblAdmin, BorderLayout.NORTH);
		
		botones = new JPanel(new GridLayout(6, 1));
		
		lblWelcome = new JLabel("Bienvenido, " + u.getNombre());
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
		
		add(botones, BorderLayout.CENTER);
		
	}
	
	public void homeAdmin()
	{
		add(botones, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case CMDUSER:
			break;
		case CMDIPS:
			break;
		case CMDMED:
			break;
		case CMDAFIL:
			break;
		case CMDSERV:
			try
			{
				long idIPS = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la IPS a editar: "));
				IPS ips = main.getIPSByID(idIPS);
				panelServicios = new PanelAdminSerIPS(main, this, ips);
				add(panelServicios, BorderLayout.CENTER);
				revalidate();
				repaint();
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

}
