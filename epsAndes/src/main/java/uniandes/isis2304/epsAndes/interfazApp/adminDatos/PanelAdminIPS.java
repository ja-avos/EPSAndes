package uniandes.isis2304.epsAndes.interfazApp.adminDatos;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.isis2304.epsAndes.interfazApp.InterfazApp;
import uniandes.isis2304.epsAndes.negocio.IPS;

public class PanelAdminIPS extends JPanel implements ActionListener{

	private static final String REGRESAR = "Regresar";

	private static final String AGREGAR = "Agregar";

	private static final String ELIMINAR = "Eliminar";

	private JLabel lblIPS;

	private InterfazApp main;

	private PanelAdmin parent;

	private PanelTablaVisualizacion tabla;

	private JPanel opciones;

	private JButton btnRegresar;

	private JButton btnAgregar;

	private JButton btnEliminar;

	public PanelAdminIPS(InterfazApp i, PanelAdmin p)
	{
		setLayout(new BorderLayout());

		main = i;
		parent = p;

		lblIPS = new JLabel("IPS's de la EPS");
		add(lblIPS, BorderLayout.NORTH);

		tabla = new PanelTablaVisualizacion(main);
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

	public void actualizarIPSs()
	{
		tabla.actualizarIPS(main.getIPSs());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand())
		{
		case REGRESAR:
			parent.homeAdmin();
			break;
		case AGREGAR:
			DialogoAgregarIPS d = new DialogoAgregarIPS(main);
			d.setVisible(true);
			actualizarIPSs();
			break;
		case ELIMINAR:
			try {
				long idDel = Long.valueOf(JOptionPane.showInputDialog("Ingrese el ID de la IPS a eliminar: "));
				main.deleteIPS(idDel);
				JOptionPane.showMessageDialog(this, "Eliminado IPS con id " + idDel);
			} catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this, ex.getMessage(), "Error eliminando la IPS", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
			actualizarIPSs();
			break;
		default:
			break;
		}
		actualizarIPSs();
	}

}
