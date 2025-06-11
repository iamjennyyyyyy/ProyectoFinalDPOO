package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import Logica.Articulo;
import Logica.Biblioteca;
import Logica.Libro;
import Logica.Prestamo;
import Logica.Revista;
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
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Reporte2PlazoDias extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JScrollPane scrollPane_1;
	private JLabel lblCantidadDeDas;
	private JSpinner spinner;
	private JLabel lblPrestamosActivos;
	private JButton btnSalir;
	private JLabel label;
	private JTextPane txtpnDatosPrstamo;
	private JLabel lblNombreUsuario;
	private JTextPane textPaneNombreUsuario;
	private JLabel lblNombrePublicacin;
	private JTextPane textPanePub;
	private JLabel lblTrabajador;
	private JTextPane textPaneTrabajador;
	private JButton btnMostrar;
	private static boolean mostrarPrestActivos = true;
	private JLabel lblTipoDePublicacin;
	private static JComboBox comboBoxTipo;
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
		contentPanel.add(getTxtpnDatosPrstamo());
		contentPanel.add(getLabel());
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getLblCantidadDeDas());
		contentPanel.add(getSpinner());
		contentPanel.add(getLblPrestamosActivos());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNombreUsuario());
		contentPanel.add(getTextPaneNombreUsuario());
		contentPanel.add(getLblNombrePublicacin());
		contentPanel.add(getTextPanePub());
		contentPanel.add(getLblTrabajador());
		contentPanel.add(getTextPaneTrabajador());
		contentPanel.add(getBtnMostrar());
		contentPanel.add(getLblTipoDePublicacin());
		contentPanel.add(getComboBoxTipo());
		cargarTablaPrestamosActivos();
		mostrarDatos(mostrarPrestActivos);
	}

	//BOTONES
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setBorder(null);
			btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSalir.setIcon(new ImageIcon("src/images/otroLogoBorrar50x50.png"));
			btnSalir.setBounds(760, 11, 50, 50);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}

	private JButton getBtnMostrar() {
		if (btnMostrar == null) {
			btnMostrar = new JButton("Mostrar");
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(table.getSelectedRow() >= 0){
						mostrarDatos(mostrarPrestActivos);
					}
					else{
						JOptionPane.showMessageDialog(null, "Debe seleccionar un préstamo", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});
			btnMostrar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnMostrar.setBounds(615, 492, 123, 32);
		}
		return btnMostrar;
	}

	//LABELS
	private JLabel getLblPrestamosActivos() {
		if (lblPrestamosActivos == null) {
			lblPrestamosActivos = new JLabel("Prestamos activos");
			lblPrestamosActivos.setFont(new Font("SansSerif", Font.PLAIN, 22));
			lblPrestamosActivos.setBounds(208, 0, 194, 34);
		}
		return lblPrestamosActivos;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(555, 178, 244, 286);
		}
		return label;
	}

	private JLabel getLblNombreUsuario() {
		if (lblNombreUsuario == null) {
			lblNombreUsuario = new JLabel("Usuario:");
			lblNombreUsuario.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblNombreUsuario.setBounds(574, 215, 137, 23);
		}
		return lblNombreUsuario;
	}

	private JLabel getLblNombrePublicacin() {
		if (lblNombrePublicacin == null) {
			lblNombrePublicacin = new JLabel("Publicaci\u00F3n:");
			lblNombrePublicacin.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblNombrePublicacin.setBounds(574, 297, 177, 23);
		}
		return lblNombrePublicacin;
	}

	private JLabel getLblTrabajador() {
		if (lblTrabajador == null) {
			lblTrabajador = new JLabel("Trabajador:");
			lblTrabajador.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblTrabajador.setBounds(574, 376, 137, 23);
		}
		return lblTrabajador;
	}

	private JLabel getLblCantidadDeDas() {
		if (lblCantidadDeDas == null) {
			lblCantidadDeDas = new JLabel("Cantidad de d\u00EDas:");
			lblCantidadDeDas.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblCantidadDeDas.setBounds(555, 70, 129, 23);
		}
		return lblCantidadDeDas;
	}

	private JLabel getLblTipoDePublicacin() {
		if (lblTipoDePublicacin == null) {
			lblTipoDePublicacin = new JLabel("Tipo de \r\npublicaci\u00F3n:");
			lblTipoDePublicacin.setFont(new Font("SansSerif", Font.PLAIN, 16));
			lblTipoDePublicacin.setBounds(555, 121, 149, 23);
		}
		return lblTipoDePublicacin;
	}

	//COMPONENTES
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

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setForeground(Colores.getColoroscuro());
			scrollPane_1.setBackground(Colores.getColorbeige());
			scrollPane_1.setBounds(50, 70, 452, 454);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}

	private JComboBox getComboBoxTipo() {
		if (comboBoxTipo == null) {
			comboBoxTipo = new JComboBox();
			comboBoxTipo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					if(mostrarPrestActivos){
						cargarTablaPrestamosActivos();
					}
					else if(!mostrarPrestActivos){
						int cantDias = (Integer)spinner.getValue();
						cargarTablaReporte2(cantDias);
					}
				}
			});
			comboBoxTipo.setFont(new Font("SansSerif", Font.PLAIN, 14));
			comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Todas", "Libro", "Revista", "Articulo"}));
			comboBoxTipo.setBounds(714, 125, 85, 20);
		}
		return comboBoxTipo;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {

					textPaneNombreUsuario.setText("");
					textPanePub.setText("");
					textPaneTrabajador.setText("");

					int cantDias = (Integer)spinner.getValue();
					mostrarPrestActivos = false;
					cargarTablaReporte2(cantDias);
				}
			});
			spinner.setBounds(714, 72, 48, 24);
		}
		return spinner;
	}

	//TEXTPANE
	private JTextPane getTxtpnDatosPrstamo() {
		if (txtpnDatosPrstamo == null) {
			txtpnDatosPrstamo = new JTextPane();
			txtpnDatosPrstamo.setText("Datos pr\u00E9stamo");
			txtpnDatosPrstamo.setDisabledTextColor(Color.BLACK);
			txtpnDatosPrstamo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			txtpnDatosPrstamo.setDisabledTextColor(Color.BLACK);
			txtpnDatosPrstamo.setEnabled(false);
			txtpnDatosPrstamo.setBackground(Color.WHITE);
			txtpnDatosPrstamo.setBounds(574, 161, 137, 32);
		}
		return txtpnDatosPrstamo;
	}

	private JTextPane getTextPanePub() {
		if (textPanePub == null) {
			textPanePub = new JTextPane();
			textPanePub.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textPanePub.setBounds(570, 331, 189, 25);
			textPanePub.setEditable(false);
			textPanePub.setBackground(Color.WHITE);
		}
		return textPanePub;
	}

	private JTextPane getTextPaneNombreUsuario() {
		if (textPaneNombreUsuario == null) {
			textPaneNombreUsuario = new JTextPane();
			textPaneNombreUsuario.setBackground(Color.WHITE);
			textPaneNombreUsuario.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textPaneNombreUsuario.setBounds(570, 249, 189, 25);
			textPaneNombreUsuario.setEditable(false);
		}
		return textPaneNombreUsuario;
	}

	private JTextPane getTextPaneTrabajador() {
		if (textPaneTrabajador == null) {
			textPaneTrabajador = new JTextPane();
			textPaneTrabajador.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textPaneTrabajador.setBounds(570, 410, 189, 25);
			textPaneTrabajador.setEditable(false);
			textPaneTrabajador.setBackground(Color.WHITE);
		}
		return textPaneTrabajador;
	}

	//METODOS
	public static void cargarTablaPrestamosActivos() {
		ArrayList<Prestamo> prestamos = Biblioteca.getInstancia().guardarPrestamosActivos();
		Prestamo[] tabla = new Prestamo[prestamos.size()];
		for(int i=0; i<tabla.length; i++) {
			tabla[i] = prestamos.get(i);
		}

		String tipo = comboBoxTipo.getSelectedItem().toString();
		PrestamoTableModel modelo = null;

		if(tipo.equals("Todas")) {
			modelo = new PrestamoTableModel(tabla, false);
		} else {
			// Aqui contamos cuántos elementos cumplen el criterio
			int count = 0;
			for(Prestamo p : tabla) {
				if((tipo.equals("Libro") && p.getPub() instanceof Libro) || (tipo.equals("Revista") && p.getPub() instanceof Revista) || (tipo.equals("Articulo") && p.getPub() instanceof Articulo)) {
					count++;
				}
			}

			// Luego creamos el array
			Prestamo[] tablaFiltrada = new Prestamo[count];
			int index = 0;
			for(Prestamo p : tabla) {
				if((tipo.equals("Libro") && p.getPub() instanceof Libro) || (tipo.equals("Revista") && p.getPub() instanceof Revista) || (tipo.equals("Articulo") && p.getPub() instanceof Articulo)) {
					tablaFiltrada[index++] = p;
				}
			}
			modelo = new PrestamoTableModel(tablaFiltrada, false);
		}

		table.setModel(modelo);
		table.repaint();
		mostrarPrestActivos = true;
	}

	public void mostrarDatos(boolean mostrarPActivos){

		if(table.getSelectedRow() >= 0){

			int indice = table.getSelectedRow();
			Prestamo p = null;

			int cantDias = (Integer)spinner.getValue();

			if(!mostrarPActivos){
				String tipo = comboBoxTipo.getSelectedItem().toString();
				Prestamo[] tabla = Biblioteca.getInstancia().guardarPrestProximosAVencerse(cantDias, tipo);
				if(indice < tabla.length)
					p = tabla[indice];
			}
			else if(mostrarPActivos){
				ArrayList<Prestamo> prestamosActivos = Biblioteca.getInstancia().guardarPrestamosActivos();
				if(indice < prestamosActivos.size())
					p = prestamosActivos.get(indice);
			}

			if(p!= null){
				textPaneNombreUsuario.setText(p.getUser().getNombreCompleto());
				textPanePub.setText(p.getPub().getTitulo());
				textPaneTrabajador.setText(p.getTrabPrestamo().getNombreCompleto());
			}
		}
	}

	public static void cargarTablaReporte2(int cantDias){
		String tipo = comboBoxTipo.getSelectedItem().toString();
		Prestamo[] tabla = Biblioteca.getInstancia().guardarPrestProximosAVencerse(cantDias, tipo);
		PrestamoReporte2TableModel modelo = new PrestamoReporte2TableModel(tabla);
		table.setModel(modelo);
		table.repaint();
	}
}
