package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton regBut;
	
	private InterfazApp main;
	
	public PanelOpciones(InterfazApp m)
	{
		setLayout(new GridLayout(1, 1));
		
		main = m;
		regBut = new JButton("Registrar");
		regBut.setActionCommand("REG");
		regBut.addActionListener(this);
		add(regBut);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("REG")) {}
			//main.registrar();
		
	}

}
