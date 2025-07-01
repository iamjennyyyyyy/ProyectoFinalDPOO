package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.UsuarioAcreditado;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class InfoUsuarioTablaPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane txtpnNombre;
	private JTextPane txtpnCarnet;
	private JTextPane txtpnEdad;
	private JTextPane txtpnSexo;
	private JTextPane txtpnPenalizacin;
	private JTextPane txtpnPrstamosActivos;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InfoUsuarioTablaPrestamo(UsuarioAcreditado u) {
		setTitle("Informaci\u00F3n Usuario");
		setModal(true);
		setBounds(450, 100, 458, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
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
		
	}
	private JTextPane getTxtpnNombre() {
		if (txtpnNombre == null) {
			txtpnNombre = new JTextPane();
			txtpnNombre.setFocusable(false);
			txtpnNombre.setBackground(Color.WHITE);
			txtpnNombre.setEditable(false);
			txtpnNombre.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnNombre.setText("Nombre:");
			txtpnNombre.setBounds(50, 34, 330, 32);
		}
		return txtpnNombre;
	}
	private JTextPane getTxtpnCarnet() {
		if (txtpnCarnet == null) {
			txtpnCarnet = new JTextPane();
			txtpnCarnet.setFocusable(false);
			txtpnCarnet.setBackground(Color.WHITE);
			txtpnCarnet.setEditable(false);
			txtpnCarnet.setText("Carnet:");
			txtpnCarnet.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnCarnet.setBounds(50, 91, 330, 32);
		}
		return txtpnCarnet;
	}
	private JTextPane getTxtpnEdad() {
		if (txtpnEdad == null) {
			txtpnEdad = new JTextPane();
			txtpnEdad.setFocusable(false);
			txtpnEdad.setBackground(Color.WHITE);
			txtpnEdad.setEditable(false);
			txtpnEdad.setText("Edad:");
			txtpnEdad.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnEdad.setBounds(50, 156, 130, 32);
		}
		return txtpnEdad;
	}
	private JTextPane getTxtpnSexo() {
		if (txtpnSexo == null) {
			txtpnSexo = new JTextPane();
			txtpnSexo.setFocusable(false);
			txtpnSexo.setBackground(Color.WHITE);
			txtpnSexo.setEditable(false);
			txtpnSexo.setText("Sexo:");
			txtpnSexo.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnSexo.setBounds(242, 156, 130, 32);
		}
		return txtpnSexo;
	}
	private JTextPane getTxtpnPenalizacin() {
		if (txtpnPenalizacin == null) {
			txtpnPenalizacin = new JTextPane();
			txtpnPenalizacin.setFocusable(false);
			txtpnPenalizacin.setBackground(Color.WHITE);
			txtpnPenalizacin.setEditable(false);
			txtpnPenalizacin.setText("Penalizaci\u00F3n:");
			txtpnPenalizacin.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnPenalizacin.setBounds(50, 218, 322, 32);
		}
		return txtpnPenalizacin;
	}
	private JTextPane getTxtpnPrstamosActivos() {
		if (txtpnPrstamosActivos == null) {
			txtpnPrstamosActivos = new JTextPane();
			txtpnPrstamosActivos.setFocusable(false);
			txtpnPrstamosActivos.setBackground(Color.WHITE);
			txtpnPrstamosActivos.setEditable(false);
			txtpnPrstamosActivos.setText("Pr\u00E9stamos activos:");
			txtpnPrstamosActivos.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnPrstamosActivos.setBounds(50, 283, 322, 32);
		}
		return txtpnPrstamosActivos;
	}
}
