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
	 * Ruta al archivo de configuraci�n de la interfaz
	 */
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/gerente.json"; 
	
	/* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    /**
     * Objeto JSON con la configuraci�n de interfaz de la app.
     */
    private JsonObject guiConfig;
    
    /**
     * Men� de la aplicaci�n
     */
    private JMenuBar menuBar;
    
 // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------
	/**
	 * �rea de texto con barras de deslizamiento
	 */
	private JTextArea textArea;
	
	private InterfazApp main;

	/* ****************************************************************
	 * 			M�todos
	 *****************************************************************/
    /**
     * Construye la ventana principal de la aplicaci�n. <br>
     * <b>post:</b> Todos los componentes de la interfaz fueron inicializados.
     */
    public PanelGerente( InterfazApp p )
    {
    	main = p;
        // Carga la configuraci�n de la interfaz desde un archivo JSON
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
    	String path = guiConfig.get("bannerPath").getAsString();
        JPanel panelDatos = new JPanel ( );
        
        panelDatos.setBorder (new TitledBorder ("Panel de informaci�n"));
        panelDatos.setLayout( new BorderLayout( ) );
        
        textArea = new JTextArea("Aqu� sale el resultado de las operaciones solicitadas");
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
	 * 			M�todos de configuraci�n de la interfaz
	 *****************************************************************/
    /**
     * Lee datos de configuraci�n para la aplicaci�, a partir de un archivo JSON o con valores por defecto si hay errores.
     * @param tipo - El tipo de configuraci�n deseada
     * @param archConfig - Archivo Json que contiene la configuraci�n
     * @return Un objeto JSON con la configuraci�n del tipo especificado
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
			JOptionPane.showMessageDialog(null, "No se encontr� un archivo de configuraci�n de interfaz v�lido: " + tipo, "Gerente View", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }

    /**
     * M�todo para crear el men� de la aplicaci�n con base em el objeto JSON le�do
     * Genera una barra de men� y los men�s con sus respectivas opciones
     * @param jsonMenu - Arreglo Json con los men�s deseados
     */
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creaci�n de la barra de men�s
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creaci�n de cada uno de los men�s
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creaci�n de cada una de las opciones del men�
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
    			resultado += "\n Operaci�n terminada";
    			actualizarInterfaz(resultado);
    		}
    		else
    		{
    			actualizarInterfaz("Operaci�n cancelada por el usuario");
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
		String resultado = "************ Error en la ejecuci�n\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y epsandes.log para m�s detalles";
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
     * Actualiza el panel con la informaci�n recibida por par�metro.
     * @param texto El texto con el que actualiza el �rea
     */
    public void actualizarInterfaz (String texto)
    {
    	textArea.setText(texto);
    }

    /* ****************************************************************
	 * 			M�todos de la Interacci�n
	 *****************************************************************/
    /**
     * M�todo para la ejecuci�n de los eventos que enlazan el men� con los m�todos de negocio
     * Invoca al m�todo correspondiente seg�n el evento recibido
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
