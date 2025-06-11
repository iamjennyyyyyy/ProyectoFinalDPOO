package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.Libro;
import Logica.UsuarioAcreditado;
import Utiles.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Font;

public class GestionPublicacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JList<Libro> list;
	private JComboBox comboBox;
	private JLabel lblTipoDePublicacin;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionPublicacion() {

		setBounds(500, 100, 820, 583);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnSalir());
		contentPanel.add(getComboBox());
		contentPanel.add(getLblTipoDePublicacin());
//		contentPanel.add(getList());
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBounds(631, 167, 109, 32);
		}
		return btnSalir;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"Libro", "Revista", "Articulo"}));
			comboBox.setBounds(631, 121, 83, 20);
		}
		return comboBox;
	}
	private JLabel getLblTipoDePublicacin() {
		if (lblTipoDePublicacin == null) {
			lblTipoDePublicacin = new JLabel("Tipo de publicaci\u00F3n:");
			lblTipoDePublicacin.setFont(new Font("SansSerif", Font.PLAIN, 14));
			lblTipoDePublicacin.setBounds(631, 74, 155, 32);
		}
		return lblTipoDePublicacin;
	}
}
