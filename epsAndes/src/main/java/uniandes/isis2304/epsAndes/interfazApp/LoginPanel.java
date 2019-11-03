package uniandes.isis2304.epsAndes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
		add(titulo, BorderLayout.NORTH);
		
		JPanel aux = new JPanel();
		aux.setLayout(new BoxLayout(aux, BoxLayout.PAGE_AXIS));
		
		lblLog = new JLabel("Ingresar");
		aux.add(lblLog);
		
		txtEmail = new JTextField();
		txtEmail.setMaximumSize(new Dimension(300, 20));
		aux.add(txtEmail);
		
		btnLog = new JButton("Log in");
		btnLog.setActionCommand(LOGIN);
		btnLog.addActionListener(this);
		aux.add(btnLog);
		
		add(aux, BorderLayout.CENTER);
		
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
