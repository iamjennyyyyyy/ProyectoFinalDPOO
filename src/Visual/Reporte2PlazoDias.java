package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.UsuarioAcreditado;
import Utiles.Colores;
import Utiles.PrestamoReporte2TableModel;
import Utiles.PrestamoTableModel;
import Utiles.UsuarioTableModel;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class Reporte2PlazoDias extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblCantidadDeDas;
	private JSpinner spinner;
	private JButton btnMostrar;
	private JLabel lblPrestamosActivos;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Reporte2PlazoDias() {
		setBounds(500, 100, 820, 583);
		setUndecorated(true);
		setModal(true);
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getLblCantidadDeDas());
		contentPanel.add(getSpinner());
		contentPanel.add(getBtnMostrar());
		contentPanel.add(getLblPrestamosActivos());
		contentPanel.add(getBtnSalir());
		cargarTablaPrestamosActivos();
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(Colores.getColorbeige());
			table.setForeground(Colores.getColoroscuro());
			table.setFont(new Font("Tahoma", Font.PLAIN, 13));
			table.setGridColor(Color.WHITE);
			table.setRowHeight(20);
		}
		return table;
	}

	public static void cargarTablaReporte2(int cantDias){

		Prestamo[] tabla = Biblioteca.getInstancia().guardarPrestProximosAVencerse(cantDias);
		
		PrestamoReporte2TableModel modelo = new PrestamoReporte2TableModel(tabla);
		table.setModel(modelo);
		table.repaint();
	}

	public static void cargarTablaPrestamosActivos(){

		ArrayList<Prestamo> prestamos = Biblioteca.getInstancia().guardarPrestamosActivos();
		Prestamo[] tabla = new Prestamo[prestamos.size()];

		for(int i=0;i<tabla.length;i++){
			tabla[i] = prestamos.get(i);
		}
		PrestamoTableModel modelo = new PrestamoTableModel(tabla, false);
		table.setModel(modelo);
		table.repaint();
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setForeground(Colores.getColoroscuro());
			scrollPane_1.setBackground(Colores.getColorbeige());
			scrollPane_1.setBounds(50, 70, 493, 427);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JLabel getLblCantidadDeDas() {
		if (lblCantidadDeDas == null) {
			lblCantidadDeDas = new JLabel("Cantidad de d\u00EDas:");
			lblCantidadDeDas.setBounds(606, 100, 100, 23);
		}
		return lblCantidadDeDas;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(716, 101, 48, 20);
		}
		return spinner;
	}
	private JButton getBtnMostrar() {
		if (btnMostrar == null) {
			btnMostrar = new JButton("Mostrar");
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblPrestamosActivos.setVisible(false);
					int cantDias = (Integer) spinner.getValue();
					cargarTablaReporte2(cantDias);
				}
			});
			btnMostrar.setBounds(621, 167, 135, 34);
		}
		return btnMostrar;
	}
	private JLabel getLblPrestamosActivos() {
		if (lblPrestamosActivos == null) {
			lblPrestamosActivos = new JLabel("Prestamos activos");
			lblPrestamosActivos.setFont(new Font("SansSerif", Font.PLAIN, 22));
			lblPrestamosActivos.setBounds(209, 11, 194, 34);
		}
		return lblPrestamosActivos;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			btnSalir.setBounds(621, 230, 135, 34);
		}
		return btnSalir;
	}
}
