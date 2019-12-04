package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{

	private static final String LOGIN = "LOGIN";
	
	private static final String HELP = "HELP";
	
	private JLabel titulo;
	
	private JLabel lblLog;
	
	private JTextField txtEmail;
	
	private JButton btnLog;
	
	private JButton btnHelp;
	
	private InterfazApp main;
	
	public LoginPanel(InterfazApp p)
	{
		main = p;
		setLayout(new BorderLayout());
		
		titulo = new JLabel("EPSAndes", JLabel.CENTER);
		titulo.setFont(new Font(titulo.getFont().getName(), Font.BOLD, 50));
		add(titulo, BorderLayout.NORTH);
		setAlignmentX(JComponent.CENTER_ALIGNMENT);
		
		JPanel aux = new JPanel(new GridBagLayout());
		Box box = new Box(BoxLayout.Y_AXIS);
		box.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        box.add(aux);
		
        GridBagConstraints c = new GridBagConstraints();
        
		lblLog = new JLabel("    Ingresar    ");
		lblLog.setFont(new Font(titulo.getFont().getName(), Font.PLAIN, 30));
		c.gridy = 0; 
		aux.add(lblLog, c);
		
		c.gridy = 1;
		aux.add(new JLabel(" "), c);
		
		txtEmail = new JTextField();
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		aux.add(txtEmail, c);

		c.gridy = 3;
		aux.add(new JLabel(" "), c);
		
		btnLog = new JButton("Log in");
		btnLog.setActionCommand(LOGIN);
		btnLog.addActionListener(this);
		c.gridy = 4;
		aux.add(btnLog, c);
		
		add(box, BorderLayout.CENTER);
		
		btnHelp = new JButton("Ayuda");
		btnHelp.setActionCommand(HELP);
		btnHelp.addActionListener(this);
		add(btnHelp, BorderLayout.SOUTH);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if(command.equals(LOGIN))
		{
			txtEmail.setEnabled(false);
			btnLog.setEnabled(false);
			main.login(txtEmail.getText());
			txtEmail.setEnabled(true);
			btnLog.setEnabled(true);
		}
		else
			main.showHelp();
	}
	
	

}
