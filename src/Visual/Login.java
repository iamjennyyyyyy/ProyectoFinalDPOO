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
	private JLabel lblBibliotecaNacionalHabana;

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
		setBounds(0, 0, 1366, 768);
		setUndecorated(true);
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
		contentPanel.add(getLblBibliotecaNacionalHabana());
	}

	public static Trabajador obtenerAdmin(){
		Trabajador t = new Trabajador("3", "Amelia Ramos", 35, "F", "Universitario", "Bibliotecario Jefe");
		return t;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(850, 0, 516, 768);
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jenny\\Desktop\\Eclipse\\ProyectoFinal\\src\\images\\login3.jpg"));
		}
		return lblNewLabel;
	}
	private JLabel getLblIniciarSesion() {
		if (lblIniciarSesion == null) {
			lblIniciarSesion = new JLabel("INICIAR SESION");
			lblIniciarSesion.setBounds(76, 167, 571, 55);
			lblIniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);
			lblIniciarSesion.setFont(new Font("Britannic Bold", Font.PLAIN, 33));
		}
		return lblIniciarSesion;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setBounds(76, 242, 571, 55);
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
			lblContrasea.setBounds(76, 434, 571, 55);
		}
		return lblContrasea;
	}
	private JTextField getTxtIngreseUnNombre() {
		if (txtIngreseUnNombre == null) {
			txtIngreseUnNombre = new JTextField();
			txtIngreseUnNombre.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					txtIngreseUnNombre.setText("");
					txtIngreseUnNombre.setForeground(Color.BLACK);
				}
				public void mouseExited(MouseEvent arg0) {
					if(txtIngreseUnNombre.getText().isEmpty()){
						txtIngreseUnNombre.setForeground(Color.LIGHT_GRAY);
						txtIngreseUnNombre.setText("Ingrese su nombre de usuario");
					}
				}
			});
			txtIngreseUnNombre.setFont(new Font("SansSerif", Font.PLAIN, 19));
			txtIngreseUnNombre.setText("Ingrese su nombre de usuario");
			txtIngreseUnNombre.setForeground(Color.LIGHT_GRAY);
			txtIngreseUnNombre.setBorder(new CompoundBorder());
			txtIngreseUnNombre.setBounds(76, 308, 576, 48);
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
			separator.setBounds(76, 308, 571, 49);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setOpaque(true);
			separator_1.setForeground(Color.BLACK);
			separator_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_1.setBounds(76, 517, 571, 49);
		}
		return separator_1;
	}
	private JButton getBtnIniciarSesion() {
		if (btnIniciarSesion == null) {
			btnIniciarSesion = new JButton("Entrar");
			btnIniciarSesion.setForeground(Color.BLACK);
			btnIniciarSesion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnIniciarSesion.setBackground(Colores.getColorbotonclarologinexited());
				}
				public void mouseExited(MouseEvent arg0) {
					btnIniciarSesion.setBackground(Colores.getColorbotonclarologin());
				}
			});
			btnIniciarSesion.setBackground(Colores.getColorbotonclarologin());
			btnIniciarSesion.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnIniciarSesion.setFont(new Font("SansSerif", Font.PLAIN, 22));
			btnIniciarSesion.setBounds(157, 637, 138, 48);
		}
		return btnIniciarSesion;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setForeground(Color.BLACK);
			btnSalir.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnSalir.setBackground(Colores.getColorbotonclarologinexited());
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnSalir.setBackground(Colores.getColorbotonclarologin());
				}
			});
			btnSalir.setBackground(Colores.getColorbotonclarologin());
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
			btnSalir.setFont(new Font("SansSerif", Font.PLAIN, 22));
			btnSalir.setBounds(404, 637, 138, 48);
		}
		return btnSalir;
	}
	private JPasswordField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setBorder(null);
			passwordField.setBounds(76, 517, 571, 48);
		}
		return passwordField;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Jenny\\Desktop\\Eclipse\\ProyectoFinal\\src\\images\\logochiquitito.jpg"));
			lblNewLabel_1.setIgnoreRepaint(true);
			lblNewLabel_1.setBounds(76, 34, 108, 95);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblBibliotecaNacionalHabana() {
		if (lblBibliotecaNacionalHabana == null) {
			lblBibliotecaNacionalHabana = new JLabel("Biblioteca de La Habana");
			lblBibliotecaNacionalHabana.setHorizontalAlignment(SwingConstants.LEFT);
			lblBibliotecaNacionalHabana.setFont(new Font("Britannic Bold", Font.PLAIN, 40));
			lblBibliotecaNacionalHabana.setBounds(210, 48, 463, 55);
		}
		return lblBibliotecaNacionalHabana;
	}
}
