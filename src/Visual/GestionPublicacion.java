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

public class GestionPublicacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnNewButton;
	private JButton btnSalir;
	private JList<Libro> list;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionPublicacion() {

		setBounds(400, 100, 820, 583);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 245, 245));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnNewButton());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getList());
	}
	
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar Usuario");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AgregarUsuario formulario = new AgregarUsuario();
					formulario.setVisible(true);
				}
			});
			btnNewButton.setBounds(631, 83, 138, 32);
		}
		return btnNewButton;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBounds(631, 153, 138, 32);
		}
		return btnSalir;
	}
	private JList<Libro> getList() {
		if (list == null) {
			list = new JList<>(Biblioteca.getInstancia().getLibros().toArray(new Libro[0]));
			list.setCellRenderer(new DefaultListCellRenderer() {
				@Override
				public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, 
						int index, boolean isSelected, boolean cellHasFocus) {
					super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					if (value instanceof Libro) {
						setText(((Libro)value).getTitulo()); // Muestra el atributo nombre
					}
					return this;
				}
			});
			list.setBounds(92, 83, 390, 381);
		}
		return list;
	}
}
