package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.UsuarioAcreditado;
import Utiles.Colores;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;

public class InfoUsuarioTablaPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane txtpnNombre;
	private JTextPane txtpnCarnet;
	private JTextPane txtpnEdad;
	private JTextPane txtpnSexo;
	private JTextPane txtpnPenalizacin;
	private JTextPane txtpnPrstamosActivos;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InfoUsuarioTablaPrestamo(UsuarioAcreditado u) {
		setTitle("Informaci\u00F3n Usuario");
		setModal(true);
		setBounds(550, 190, 389, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Colores.getFondo());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTxtpnNombre());
		contentPanel.add(getTxtpnCarnet());
		contentPanel.add(getTxtpnEdad());
		contentPanel.add(getTxtpnSexo());
		contentPanel.add(getTxtpnPenalizacin());
		contentPanel.add(getTxtpnPrstamosActivos());
		txtpnNombre.setText("Nombre: " + u.getNombreCompleto());
		txtpnCarnet.setText("Carnet: " + u.getId());
		txtpnEdad.setText("Edad: " + u.getEdad());
		txtpnSexo.setText("Sexo: " + u.getSexo());
		if(u.getFechaPenalizacion() != null){
			txtpnPenalizacin.setForeground(Color.RED);
			txtpnPenalizacin.setText("Penalización: " + u.getFechaPenalizacion().toString());
		}
		else
			txtpnPenalizacin.setText("No está penalizado");
		txtpnPrstamosActivos.setText("Préstamos activos: " + u.getPrestamos().size());
		contentPanel.add(getSeparator());
		contentPanel.add(getSeparator_1());
		contentPanel.add(getSeparator_2());
		
	}
	private JTextPane getTxtpnNombre() {
		if (txtpnNombre == null) {
			txtpnNombre = new JTextPane();
			txtpnNombre.setFocusable(false);
			txtpnNombre.setBackground(Colores.getFondo());
			txtpnNombre.setEditable(false);
			txtpnNombre.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnNombre.setText("Nombre:");
			txtpnNombre.setBounds(34, 34, 309, 32);
		}
		return txtpnNombre;
	}
	private JTextPane getTxtpnCarnet() {
		if (txtpnCarnet == null) {
			txtpnCarnet = new JTextPane();
			txtpnCarnet.setFocusable(false);
			txtpnCarnet.setBackground(Colores.getFondo());
			txtpnCarnet.setEditable(false);
			txtpnCarnet.setText("Carnet:");
			txtpnCarnet.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnCarnet.setBounds(34, 91, 309, 32);
		}
		return txtpnCarnet;
	}
	private JTextPane getTxtpnEdad() {
		if (txtpnEdad == null) {
			txtpnEdad = new JTextPane();
			txtpnEdad.setFocusable(false);
			txtpnEdad.setBackground(Colores.getFondo());
			txtpnEdad.setEditable(false);
			txtpnEdad.setText("Edad:");
			txtpnEdad.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnEdad.setBounds(34, 156, 130, 32);
		}
		return txtpnEdad;
	}
	private JTextPane getTxtpnSexo() {
		if (txtpnSexo == null) {
			txtpnSexo = new JTextPane();
			txtpnSexo.setFocusable(false);
			txtpnSexo.setBackground(Colores.getFondo());
			txtpnSexo.setEditable(false);
			txtpnSexo.setText("Sexo:");
			txtpnSexo.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnSexo.setBounds(187, 156, 130, 32);
		}
		return txtpnSexo;
	}
	private JTextPane getTxtpnPenalizacin() {
		if (txtpnPenalizacin == null) {
			txtpnPenalizacin = new JTextPane();
			txtpnPenalizacin.setFocusable(false);
			txtpnPenalizacin.setBackground(Colores.getFondo());
			txtpnPenalizacin.setEditable(false);
			txtpnPenalizacin.setText("Penalizaci\u00F3n:");
			txtpnPenalizacin.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnPenalizacin.setBounds(34, 218, 309, 32);
		}
		return txtpnPenalizacin;
	}
	private JTextPane getTxtpnPrstamosActivos() {
		if (txtpnPrstamosActivos == null) {
			txtpnPrstamosActivos = new JTextPane();
			txtpnPrstamosActivos.setFocusable(false);
			txtpnPrstamosActivos.setBackground(Colores.getFondo());
			txtpnPrstamosActivos.setEditable(false);
			txtpnPrstamosActivos.setText("Pr\u00E9stamos activos:");
			txtpnPrstamosActivos.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnPrstamosActivos.setBounds(34, 283, 309, 32);
		}
		return txtpnPrstamosActivos;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBorder(new LineBorder(Colores.getCruds()));
			separator.setBounds(112, 35, 230, 32);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBorder(new LineBorder(Colores.getCruds()));
			separator_1.setBounds(101, 92, 242, 32);
		}
		return separator_1;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBorder(new LineBorder(Colores.getCruds()));
			separator_2.setBounds(152, 219, 191, 32);
		}
		return separator_2;
	}
}
