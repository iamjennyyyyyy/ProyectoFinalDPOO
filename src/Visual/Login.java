package Visual;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Logica.Biblioteca;
import Logica.Trabajador;
import Utiles.Colores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import javax.swing.JPasswordField;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblUsuario;
	private JTextField textField;
	private JLabel lblContrasea;
	private JLabel lblBienvenido;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
		
			Principal p = new Principal();
			Login dialog = new Login(p);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login(Principal p) {
		super(p,"Inicio Sesion", true);
		setBounds(500, 200, 361, 410);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(210, 180, 140));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblUsuario());
		contentPanel.add(getTextField());
		contentPanel.add(getLblContrasea());
		contentPanel.add(getLblBienvenido());
		contentPanel.add(getPasswordField());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				okButton.setBackground(Colores.getcolorBotonClaro());
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						okButton.setBackground(Colores.getcolorBotonVerde());
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						okButton.setBackground(Colores.getcolorBotonClaro());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBackground(Colores.getcolorBotonClaro());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 19));
			lblUsuario.setBounds(57, 83, 116, 24);
		}
		return lblUsuario;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(54, 118, 218, 24);
			textField.setColumns(10);
		}
		return textField;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setFont(new Font("Segoe UI", Font.PLAIN, 19));
			lblContrasea.setBounds(57, 185, 116, 24);
		}
		return lblContrasea;
	}
	private JLabel getLblBienvenido() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido!");
			lblBienvenido.setFont(new Font("Segoe UI", Font.PLAIN, 19));
			lblBienvenido.setBounds(119, 11, 116, 24);
		}
		return lblBienvenido;
	}
	
	public static Trabajador obtenerAdmin(){
		Trabajador t = new Trabajador("3", "Amelia Ramos", 35, "F", "Universitario", "Bibliotecario Jefe");
		return t;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBounds(57, 232, 215, 24);
		}
		return passwordField;
	}
}
