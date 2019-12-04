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
import uniandes.isis2304.epsAndes.negocio.Afiliado;
import uniandes.isis2304.epsAndes.negocio.Horario;
import uniandes.isis2304.epsAndes.negocio.IPS;
import uniandes.isis2304.epsAndes.negocio.Medico;
import uniandes.isis2304.epsAndes.negocio.Usuario;

@SuppressWarnings("serial")
public class PanelTablaVisualizacion extends JPanel implements MouseListener
{

	/**
	 * Encabezados de la tabla.
	 */
	public String[][] encabezados = {
			{"Identificacion", "IPS", "Servicio", "Capacidad", "Dia", "Hora Inicio", "Hora Fin"}, //Horarios
			{"Identificacion", "Nombre", "Correo", "Documento", "Tipo ID", "Rol"}, //Usuarios
			{"Identificacion", "Nombre", "Localizacion"}, //IPS
			{"Identificacion", "Registro Medico", "Especialidad", "Usuario"}, //Medicos
			{"Identificacion", "Fecha de Nacimiento", "Usuario"}, //Afiliados
	};
	
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
	
	public PanelTablaVisualizacion(InterfazApp principal) 
	{
		this.principal = principal;
		setLayout(new GridLayout(1, 1));
		tablaServicios = new JTable();
		
		modelo = new DefaultTableModel(encabezados[0], 0);
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
	public void actualizarHorarios(List<Horario> servicios)
	{
		String[] fila;
		modelo = new DefaultTableModel(encabezados[0], 0)
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
	 * Actualiza la tabla con los elementos que llegan como par�metro.
	 * @param elementos
	 */
	public void actualizarIPS(List<IPS> ipss)
	{
		String[] fila;
		modelo = new DefaultTableModel(encabezados[2], 0)
				{
					public boolean isCellEditable(int row, int column) 
					{
						return false;
					};
				};
				
		for(int i = 0; i < ipss.size(); i++)
		{
			IPS actual = ipss.get(i);
			fila = new String[3];
			fila[0] = actual.getId_IPS() + "";
			fila[1] = actual.getNombre() + "";
			fila[2] = actual.getLocalizacion();
			modelo.addRow(fila);
		}
		tablaServicios.setModel(modelo);
	}
	
	/**
	 * Actualiza la tabla con los elementos que llegan como par�metro.
	 * @param elementos
	 */
	public void actualizarUsuarios(List<Usuario> usuarios)
	{
		String[] fila;
		modelo = new DefaultTableModel(encabezados[1], 0)
				{
					public boolean isCellEditable(int row, int column) 
					{
						return false;
					};
				};
				
		for(int i = 0; i < usuarios.size(); i++)
		{
			Usuario actual = usuarios.get(i);
			fila = new String[6];
			fila[0] = actual.getId_Usuario() + "";
			fila[1] = actual.getNombre() + "";
			fila[2] = actual.getCorreo();
			fila[3] = actual.getId() + "";
			fila[4] = principal.getTipoIDByID(actual.getTipo_ID()).getNombre();
			fila[5] = principal.getRolByID(actual.getRol()).getRol();
			modelo.addRow(fila);
		}
		tablaServicios.setModel(modelo);
	}
	
	/**
	 * Actualiza la tabla con los elementos que llegan como par�metro.
	 * @param elementos
	 */
	public void actualizarMedicos(List<Medico> medicos)
	{
		String[] fila;
		modelo = new DefaultTableModel(encabezados[3], 0)
				{
					public boolean isCellEditable(int row, int column) 
					{
						return false;
					};
				};
				
		for(int i = 0; i < medicos.size(); i++)
		{
			Medico actual = medicos.get(i);
			fila = new String[4];
			fila[0] = actual.getId_Medico() + "";
			fila[1] = actual.getRegistro_Medico() + "";
			fila[2] = actual.getEspecialidad();
			fila[3] = actual.getUsuario() + "";
			modelo.addRow(fila);
		}
		tablaServicios.setModel(modelo);
	}
	
	/**
	 * Actualiza la tabla con los elementos que llegan como par�metro.
	 * @param elementos
	 */
	public void actualizarAfiliados(List<Afiliado> afiliados)
	{
		String[] fila;
		modelo = new DefaultTableModel(encabezados[4], 0)
				{
					public boolean isCellEditable(int row, int column) 
					{
						return false;
					};
				};
				
		for(int i = 0; i < afiliados.size(); i++)
		{
			Afiliado actual = afiliados.get(i);
			fila = new String[3];
			fila[0] = actual.getId_Afiliado() + "";
			fila[1] = actual.getFecha_Nacimiento() == null ? "Error en fecha" : actual.getFecha_Nacimiento().toString();
			fila[2] = actual.getUsuario() + "";
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
