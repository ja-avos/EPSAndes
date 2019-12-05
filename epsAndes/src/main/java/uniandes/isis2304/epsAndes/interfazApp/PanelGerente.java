package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.lang.reflect.Method;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class PanelGerente extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ruta al archivo de configuración de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/gerente.json"; 
	
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuración de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Menú de la aplicación
     */
    private JMenuBar menuBar;
    
 // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------
	/**
	 * Área de texto con barras de deslizamiento
	 */
	private JTextArea textArea;
	
	private InterfazApp main;

	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicación. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public PanelGerente( InterfazApp p )
    {
    	main = p;
        // Carga la configuración de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
    	String path = guiConfig.get("bannerPath").getAsString();
        JPanel panelDatos = new JPanel ( );
        
        panelDatos.setBorder (new TitledBorder ("Panel de información"));
        panelDatos.setLayout( new BorderLayout( ) );
        
        textArea = new JTextArea("Aquí sale el resultado de las operaciones solicitadas");
        textArea.setEditable(false);
        panelDatos.add (new JScrollPane(textArea), BorderLayout.CENTER);

        setLayout (new BorderLayout());
        JPanel aux = new JPanel(new BorderLayout());
        add(menuBar, BorderLayout.NORTH);
        aux.add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        aux.add( panelDatos, BorderLayout.CENTER );
        add(aux, BorderLayout.CENTER);
    }
    
    /* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuración para la aplicació, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuración deseada
     * @param archConfig - Archivo Json que contiene la configuración
     * @return Un objeto JSON con la configuración del tipo especificado
     * 			NULL si hay un error en el archivo.
     */
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();		
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Gerente View", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }

    /**
     * Método para crear el menú de la aplicación con base em el objeto JSON leído
     * Genera una barra de menú y los menús con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los menùs deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }	
    }
    
    //########################################################################################
    //########################################################################################
    //########################################################################################
    
    public void rfc1( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc1();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC1\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc2( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc2();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC2\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc3( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc3();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC3\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc4( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc4();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC4\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc5( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc5();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC5\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc6( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc6();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC6\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc7( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc7();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC7\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc8( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc8();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC8\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc9( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc9();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC9\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc10( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc10();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC10\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc11( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc11();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC11\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    public void rfc12( )
    {
    	try 
    	{
    		//String nombreTipo = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Adicionar tipo de bebida", JOptionPane.QUESTION_MESSAGE);
    		if (true)
    		{
    			//main.rfc12();
        		/*if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de bebida con nombre: " + nombreTipo);
        		}*/
        		String resultado = "RFC12\n\t";
        		resultado += "Resultado de la consulta: " + "";
    			resultado += "\n Operación terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			actualizarInterfaz(resultado);
		}
    }
    
    private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y epsandes.log para más detalles";
		return resultado;
	}
    
    private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}
    
    /**
     * Actualiza el panel con la información recibida por parámetro.
     * @param texto El texto con el que actualiza el área
     */
    public void actualizarInterfaz (String texto)
    {
    	textArea.setText(texto);
    }

    /* ****************************************************************
	 * 			Métodos de la Interacción
	 *****************************************************************/
    /**
     * Método para la ejecución de los eventos que enlazan el menú con los métodos de negocio
     * Invoca al método correspondiente según el evento recibido
     * @param pEvento - El evento del usuario
     */
    @Override
	public void actionPerformed(ActionEvent pEvento)
	{
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = PanelGerente.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
	}
	
}
