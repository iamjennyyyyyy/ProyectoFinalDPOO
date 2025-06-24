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
	private JLabel lblNewLabel;
	private JTextPane textPaneNombre;
	private JLabel lblCarnetUsuario;
	private JLabel lblPenalizacin;
	private JTextPane textPaneCarnet;
	private JTextPane textPanePenalizacion;
	private JLabel lblEdad;
	private JTextPane textPaneEdad;
	private JLabel lblSexo;
	private JTextPane textPaneSexo;
	private JLabel lblC;
	private JTextPane textPanePrestamo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InfoUsuarioTablaPrestamo(UsuarioAcreditado u) {
		setTitle("Informaci\u00F3n Usuario");
		setModal(true);
		setBounds(450, 100, 458, 567);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTextPaneNombre());
		contentPanel.add(getLblCarnetUsuario());
		contentPanel.add(getLblPenalizacin());
		contentPanel.add(getTextPaneCarnet());
		contentPanel.add(getTextPanePenalizacion());
		contentPanel.add(getLblEdad());
		contentPanel.add(getTextPaneEdad());
		contentPanel.add(getLblSexo());
		contentPanel.add(getTextPaneSexo());
		textPaneNombre.setText(u.getNombreCompleto());
		textPaneCarnet.setText(u.getId());
		contentPanel.add(getLblC());
		contentPanel.add(getTextPanePrestamo());
		if(u.getFechaPenalizacion() != null){
			textPanePenalizacion.setForeground(Color.RED);
			textPanePenalizacion.setText(u.getFechaPenalizacion().toString());
		}
		else{
			textPanePenalizacion.setForeground(SystemColor.infoText);
			textPanePenalizacion.setText("No está penalizado");
		}
		textPaneEdad.setText("" + u.getEdad());
		textPaneSexo.setText(u.getSexo());
		if(u.getPrestamos().size() >= 3){
			textPanePrestamo.setForeground(Color.RED);
			textPanePrestamo.setText("" + u.getPrestamos().size());
		}
		else{
			textPanePrestamo.setForeground(Color.BLACK);
			textPanePrestamo.setText("" + u.getPrestamos().size());
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Nombre usuario:");
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblNewLabel.setBounds(50, 34, 159, 32);
		}
		return lblNewLabel;
	}
	private JTextPane getTextPaneNombre() {
		if (textPaneNombre == null) {
			textPaneNombre = new JTextPane();
			textPaneNombre.setForeground(SystemColor.infoText);
			textPaneNombre.setEditable(false);
			textPaneNombre.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneNombre.setBounds(50, 77, 338, 32);
		}
		return textPaneNombre;
	}
	private JLabel getLblCarnetUsuario() {
		if (lblCarnetUsuario == null) {
			lblCarnetUsuario = new JLabel("Carnet usuario:");
			lblCarnetUsuario.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblCarnetUsuario.setBounds(50, 134, 159, 32);
		}
		return lblCarnetUsuario;
	}
	private JLabel getLblPenalizacin() {
		if (lblPenalizacin == null) {
			lblPenalizacin = new JLabel("Penalizaci\u00F3n:");
			lblPenalizacin.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblPenalizacin.setBounds(50, 299, 159, 32);
		}
		return lblPenalizacin;
	}
	private JTextPane getTextPaneCarnet() {
		if (textPaneCarnet == null) {
			textPaneCarnet = new JTextPane();
			textPaneCarnet.setForeground(SystemColor.infoText);
			textPaneCarnet.setEditable(false);
			textPaneCarnet.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneCarnet.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneCarnet.setBounds(50, 177, 338, 32);
		}
		return textPaneCarnet;
	}
	private JTextPane getTextPanePenalizacion() {
		if (textPanePenalizacion == null) {
			textPanePenalizacion = new JTextPane();
			textPanePenalizacion.setForeground(SystemColor.infoText);
			textPanePenalizacion.setEditable(false);
			textPanePenalizacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPanePenalizacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPanePenalizacion.setBounds(50, 342, 338, 32);
		}
		return textPanePenalizacion;
	}
	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblEdad.setBounds(50, 240, 66, 32);
		}
		return lblEdad;
	}
	private JTextPane getTextPaneEdad() {
		if (textPaneEdad == null) {
			textPaneEdad = new JTextPane();
			textPaneEdad.setForeground(SystemColor.infoText);
			textPaneEdad.setEditable(false);
			textPaneEdad.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneEdad.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneEdad.setBounds(111, 240, 55, 32);
		}
		return textPaneEdad;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblSexo.setBounds(242, 240, 66, 32);
		}
		return lblSexo;
	}
	private JTextPane getTextPaneSexo() {
		if (textPaneSexo == null) {
			textPaneSexo = new JTextPane();
			textPaneSexo.setForeground(SystemColor.infoText);
			textPaneSexo.setEditable(false);
			textPaneSexo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneSexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneSexo.setBounds(303, 240, 66, 32);
		}
		return textPaneSexo;
	}
	private JLabel getLblC() {
		if (lblC == null) {
			lblC = new JLabel("Pr\u00E9stamos activos:");
			lblC.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblC.setBounds(50, 400, 199, 32);
		}
		return lblC;
	}
	private JTextPane getTextPanePrestamo() {
		if (textPanePrestamo == null) {
			textPanePrestamo = new JTextPane();
			textPanePrestamo.setForeground(Color.BLACK);
			textPanePrestamo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPanePrestamo.setEditable(false);
			textPanePrestamo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPanePrestamo.setBounds(50, 443, 338, 32);
		}
		return textPanePrestamo;
	}
}
