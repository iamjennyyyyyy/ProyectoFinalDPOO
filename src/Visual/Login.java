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
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;

public class Login extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JLabel lblIniciarSesion;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	private JTextField txtIngreseUnNombre;
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnIniciarSesion;
	private JButton btnSalir;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_1;
	private JFrame parentFrame;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Login(JFrame p, boolean modal) {
		super(p, modal);
		this.parentFrame = p;
		setBackground(Color.WHITE);
		setAlwaysOnTop(true);
		setUndecorated(true);
		setTitle("Inicio Sesi\u00F3n");
		setBounds(0, 0, 1366, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getLblIniciarSesion());
		contentPanel.add(getLblUsuario());
		contentPanel.add(getLblContrasea());
		contentPanel.add(getTxtIngreseUnNombre());
		contentPanel.add(getSeparator());
		contentPanel.add(getBtnIniciarSesion());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getPasswordField());
		contentPanel.add(getSeparator_1());
		contentPanel.add(getLblNewLabel_1());
	}

	public static Trabajador obtenerAdmin(){
		Trabajador t = new Trabajador("06071267912", "Jennifer Ramírez", "Universitario", "Bibliotecario Jefe");
		return t;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(0, 0, 540, 768);
			lblNewLabel.setIcon(new ImageIcon("src/images/loginBien.png"));
		}
		return lblNewLabel;
	}
	private JLabel getLblIniciarSesion() {
		if (lblIniciarSesion == null) {
			lblIniciarSesion = new JLabel("INICIAR SESION");
			lblIniciarSesion.setBounds(683, 126, 571, 55);
			lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
			lblIniciarSesion.setFont(new Font("Britannic Bold", Font.PLAIN, 35));
		}
		return lblIniciarSesion;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(656, 245, 571, 55);
			lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
			lblUsuario.setFont(new Font("Britannic Bold", Font.PLAIN, 29));
		}
		return lblUsuario;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a:");
			lblContrasea.setHorizontalAlignment(SwingConstants.LEFT);
			lblContrasea.setFont(new Font("Britannic Bold", Font.PLAIN, 29));
			lblContrasea.setBounds(656, 437, 571, 55);
		}
		return lblContrasea;
	}
	private JTextField getTxtIngreseUnNombre() {
		if (txtIngreseUnNombre == null) {
			txtIngreseUnNombre = new JTextField();
			txtIngreseUnNombre.setFont(new Font("SansSerif", Font.PLAIN, 19));
			txtIngreseUnNombre.putClientProperty("JTextField.placeholderText", "Ingrese su nombre de usuario");
			txtIngreseUnNombre.setForeground(Color.BLACK);
			txtIngreseUnNombre.setBorder(new CompoundBorder());
			txtIngreseUnNombre.setBounds(656, 311, 576, 48);
			txtIngreseUnNombre.setColumns(10);
		}
		return txtIngreseUnNombre;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator.setForeground(Color.BLACK);
			separator.setOpaque(true);
			separator.setBounds(656, 311, 571, 49);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOpaque(true);
			separator_1.setForeground(Color.BLACK);
			separator_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_1.setBounds(656, 520, 571, 49);
		}
		return separator_1;
	}
	private JButton getBtnIniciarSesion() {
		if (btnIniciarSesion == null) {
			btnIniciarSesion = new JButton("Entrar");
			btnIniciarSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					char[] contraseña = passwordField.getPassword();
					char[] contraseñaValida = "jenn006".toCharArray();
					try {
						if(Arrays.equals(contraseña, contraseñaValida) && 
								txtIngreseUnNombre.getText().equals("06071267912"))
						dispose();
						
						else {
							JOptionPane.showMessageDialog(Login.this,"Credenciales incorrectas", "Error",JOptionPane.ERROR_MESSAGE);
						}
					} finally {
						// Limpiar contraseñas de memoria
						Arrays.fill(contraseña, '\0');
						Arrays.fill(contraseñaValida, '\0');
						passwordField.setText("");
					}
				}
			});
			btnIniciarSesion.setForeground(Color.BLACK);
			btnIniciarSesion.setBackground(Colores.getColorBotonLoginNuevo());
			btnIniciarSesion.setFont(new Font("SansSerif", Font.PLAIN, 22));
			btnIniciarSesion.setBounds(744, 640, 138, 48);
		}
		return btnIniciarSesion;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setForeground(Color.BLACK);
			btnSalir.setBackground(Colores.getColorBotonLoginNuevo());
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					parentFrame.dispose();
					dispose();
				}
			});
			btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 22));
			btnSalir.setBounds(991, 640, 138, 48);
		}
		return btnSalir;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setFont(new Font("Tahoma", Font.PLAIN, 19));
			passwordField.setBorder(null);
			passwordField.setBounds(656, 520, 571, 48);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("src/images/logochiquitito.jpg"));
			lblNewLabel_1.setIgnoreRepaint(true);
			lblNewLabel_1.setBounds(629, 37, 108, 95);
		}
		return lblNewLabel_1;
	}
}
