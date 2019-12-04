package uniandes.isis2304.epsAndes.interfazApp.adminDatos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.isis2304.epsAndes.interfazApp.InterfazApp;
import uniandes.isis2304.epsAndes.negocio.IPS;

public class PanelAdminSerIPS extends JPanel implements ActionListener{
	
	private static final String REGRESAR = "Regresar";
	
	private static final String AGREGAR = "Agregar";
	
	private static final String ELIMINAR = "Eliminar";
	
	private JLabel lblSerIPS;
	
	private InterfazApp main;
	
	private IPS ips;
	
	private PanelAdmin parent;
	
	private PanelTablaServiciosIPS tabla;
	
	private JPanel opciones;
	
	private JButton btnRegresar;
	
	private JButton btnAgregar;
	
	private JButton btnEliminar;
	
	public PanelAdminSerIPS(InterfazApp i, PanelAdmin p)
	{
		setLayout(new BorderLayout());
		
		main = i;
		parent = p;
		
		lblSerIPS = new JLabel("Servicios de Salud por IPS");
		add(lblSerIPS, BorderLayout.NORTH);
		
		tabla = new PanelTablaServiciosIPS(main);
		add(tabla, BorderLayout.CENTER);
		
		opciones = new JPanel(new GridLayout(1, 3));
		
		btnRegresar = new JButton(REGRESAR);
		btnRegresar.setActionCommand(REGRESAR);
		btnRegresar.addActionListener(this);
		opciones.add(btnRegresar);
		
		btnAgregar = new JButton(AGREGAR);
		btnAgregar.setActionCommand(AGREGAR);
		btnAgregar.addActionListener(this);
		opciones.add(btnAgregar);
		
		btnEliminar = new JButton(ELIMINAR);
		btnEliminar.setActionCommand(ELIMINAR);
		btnEliminar.addActionListener(this);
		opciones.add(btnEliminar);
		
		add(opciones, BorderLayout.SOUTH);
				
	}
	
	public void actualizarIPS(IPS ip)
	{
		ips = ip;
		tabla.actualizar(main.getHorariosByIPS(ips.getId_IPS()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case REGRESAR:
			parent.homeAdmin();
			break;
		case AGREGAR:
			DialogoAgregarServicioIPS d = new DialogoAgregarServicioIPS(main, ips);
			d.setVisible(true);
			actualizarIPS(ips);
			break;
		case ELIMINAR:
			long idDel = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID del servicio a eliminar: "));
			main.deleteHorarioByID(idDel);
			actualizarIPS(ips);
			break;
		default:
			break;
		}
		
	}

}
