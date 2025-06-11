package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Logica.Biblioteca;
import Logica.Prestamo;
import Utiles.PrestamoTableModel;

import Utiles.Colores;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnAgregarPrestamo;
	private JButton btnCerrar;
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionPrestamo() {
		setBounds(500, 100, 820, 583);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setModal(true);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getBtnAgregarPrestamo());
		contentPanel.add(getBtnCerrar());
		cargarTablaPrestamos();
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setEnabled(false);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(Colores.getColorbeige());
			table.setForeground(new Color(0, 0, 0));
			table.setFont(new Font("Tahoma", Font.PLAIN, 13));
			table.setGridColor(Color.WHITE);
			table.setRowHeight(20);
		}
		return table;
	}
	
	public static void cargarTablaPrestamos(){
		
		ArrayList<Prestamo> prestamos = Biblioteca.getInstancia().getPrestamosTotales();
		Prestamo[] tabla = new Prestamo[prestamos.size()];
		
		for(int i=0;i<tabla.length;i++){
			tabla[i] = prestamos.get(i);
		}
		PrestamoTableModel modelo = new PrestamoTableModel(tabla, true);
		table.setModel(modelo);
		table.repaint();
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(58, 46, 478, 451);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JButton getBtnAgregarPrestamo() {
		if (btnAgregarPrestamo == null) {
			btnAgregarPrestamo = new JButton("Agregar Prestamo");
			btnAgregarPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AgregarPrestamo p = new AgregarPrestamo();
					p.setVisible(true);
				}
			});
			btnAgregarPrestamo.setBounds(619, 93, 128, 29);
		}
		return btnAgregarPrestamo;
	}
	private JButton getBtnCerrar() {
		if (btnCerrar == null) {
			btnCerrar = new JButton("Cerrar");
			btnCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnCerrar.setBounds(619, 154, 128, 29);
		}
		return btnCerrar;
	}
}
