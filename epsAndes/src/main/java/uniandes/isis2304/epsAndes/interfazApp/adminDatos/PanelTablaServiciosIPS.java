package uniandes.isis2304.epsAndes.interfazApp.adminDatos;

import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import uniandes.isis2304.epsAndes.interfazApp.InterfazApp;
import uniandes.isis2304.epsAndes.negocio.Horario;

@SuppressWarnings("serial")
public class PanelTablaServiciosIPS extends JPanel implements MouseListener
{

	/**
	 * Encabezados de la tabla.
	 */
	public final static String[] ENCABEZADOS = {"Identificacion", "IPS", "Servicio", "Capacidad", "Dia", "Hora Inicio", "Hora Fin"};
	
	/**
	 * Tabla de servicios.
	 */
	private JTable tablaServicios;
	
	/**
	 * Modelo para presentar la tabla.
	 */
	private DefaultTableModel modelo;
	
	/**
	 * Clase principal de la interfaz.
	 */
	private InterfazApp principal;
	
	public PanelTablaServiciosIPS(InterfazApp principal) 
	{
		this.principal = principal;
		setLayout(new GridLayout(1, 1));
		tablaServicios = new JTable();
		
		modelo = new DefaultTableModel(ENCABEZADOS, 0);
		tablaServicios.setModel(modelo);
		tablaServicios.addMouseListener(this);
		
		JScrollPane scroll = new JScrollPane(tablaServicios);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroll);
	}
	
	/**
	 * Actualiza la tabla con los elementos que llegan como par�metro.
	 * @param elementos
	 */
	public void actualizar(List<Horario> servicios)
	{
		String[] fila;
		modelo = new DefaultTableModel(ENCABEZADOS, 0)
				{
					public boolean isCellEditable(int row, int column) 
					{
						return false;
					};
				};
				
		for(int i = 0; i < servicios.size(); i++)
		{
			Horario actual = servicios.get(i);
			fila = new String[7];
			fila[0] = actual.getIPS() + "";
			fila[1] = actual.getId_Horario() + "";
			fila[2] = principal.getServicioSaludByID(actual.getServicio()).getNombre();
			fila[3] = actual.getCapacidad() + "";
			fila[4] = actual.getDia() + "";
			fila[5] = actual.getHora_Inicio().getHours() + ":" + actual.getHora_Inicio().getMinutes();
			fila[6] = actual.getHora_Fin().getHours() + ":" + actual.getHora_Fin().getMinutes();
			modelo.addRow(fila);
		}
		tablaServicios.setModel(modelo);
	}
	
	/**
	 * Retorna el identificador del elemento que actualmente se encuentra seleccionado.
	 * @return
	 */
	public String darIdentificadorSeleccionado()
	{
		if(modelo.getRowCount() != 0)
		{
			int col = 1;
			int fila = tablaServicios.getSelectedRow();
			if(fila != -1)
			{
				String identificador = (String) tablaServicios.getValueAt(fila, col);
				return identificador;
			}
		}
		return null;
	}
	
	/**
	 * Acci�n que se ejecuta al hacer clic sobre la tabla.
	 * @param e
	 */
	public void mouseClicked(MouseEvent e) {
		String identificadorSeleccionado = darIdentificadorSeleccionado();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// No es necesario implementarlo
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// No es necesario implementarlo
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// No es necesario implementarlo
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// No es necesario implementarlo
		
	}

}
