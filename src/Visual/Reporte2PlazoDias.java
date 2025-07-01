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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
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
		setBounds(338, 159, 1026, 562);
		setUndecorated(true);
		setModal(true);
		setBackground(Color.WHITE);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTxtpnDatosPrstamo());
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
		contentPanel.add(getLabel());
		cargarTablaPrestamosActivos();
		mostrarDatos(mostrarPrestActivos);
	}

	//BOTONES
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setBorder(null);
			btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSalir.setIcon(new ImageIcon("src/images/iconos/otroLogoBorrar50x50.png"));
			btnSalir.setBounds(966, 11, 50, 50);
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
			btnMostrar.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnMostrar.setBackground(Colores.getBeigetabla());
			btnMostrar.setBounds(764, 475, 123, 32);
		}
		return btnMostrar;
	}

	//LABELS
	private JLabel getLblPrestamosActivos() {
		if (lblPrestamosActivos == null) {
			lblPrestamosActivos = new JLabel("Prestamos activos");
			lblPrestamosActivos.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblPrestamosActivos.setBounds(222, 27, 194, 34);
		}
		return lblPrestamosActivos;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(655, 178, 319, 277);
		}
		return label;
	}

	private JLabel getLblNombreUsuario() {
		if (lblNombreUsuario == null) {
			lblNombreUsuario = new JLabel("Usuario:");
			lblNombreUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblNombreUsuario.setBounds(685, 215, 137, 23);
		}
		return lblNombreUsuario;
	}

	private JLabel getLblNombrePublicacin() {
		if (lblNombrePublicacin == null) {
			lblNombrePublicacin = new JLabel("Publicaci\u00F3n:");
			lblNombrePublicacin.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblNombrePublicacin.setBounds(685, 297, 177, 23);
		}
		return lblNombrePublicacin;
	}

	private JLabel getLblTrabajador() {
		if (lblTrabajador == null) {
			lblTrabajador = new JLabel("Trabajador:");
			lblTrabajador.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblTrabajador.setBounds(685, 376, 137, 23);
		}
		return lblTrabajador;
	}

	private JLabel getLblCantidadDeDas() {
		if (lblCantidadDeDas == null) {
			lblCantidadDeDas = new JLabel("Cantidad de d\u00EDas:");
			lblCantidadDeDas.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblCantidadDeDas.setBounds(685, 67, 129, 23);
		}
		return lblCantidadDeDas;
	}

	private JLabel getLblTipoDePublicacin() {
		if (lblTipoDePublicacin == null) {
			lblTipoDePublicacin = new JLabel("Tipo de \r\npublicaci\u00F3n:");
			lblTipoDePublicacin.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblTipoDePublicacin.setBounds(666, 121, 149, 23);
		}
		return lblTipoDePublicacin;
	}

	//COMPONENTES
	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			table.setRowHeight(28);
			table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			table.setGridColor(new Color(220, 200, 180));
			table.setSelectionBackground(new Color(181, 149, 110));
			table.setSelectionForeground(Color.WHITE);
			table.setShowGrid(false);
			table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
				@Override
				public Component getTableCellRendererComponent(JTable table, Object value,
						boolean isSelected, boolean hasFocus, int row, int column) {

					Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

					if (!isSelected) {
						if (row % 2 == 0) {
							c.setBackground(Colores.getBeigetabla()); // Fondo pastel claro
						} else {
							c.setBackground(Colores.getContrastetabla()); // Otro tono pastel
						}
						c.setForeground(Color.DARK_GRAY);
					}
					return c;
				}
			});
			table.setGridColor(Color.WHITE);
			table.setRowHeight(20);
		}
		return table;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setForeground(Color.BLACK);
			scrollPane_1.setBackground(Colores.getBeigetabla());
			scrollPane_1.setBounds(70, 70, 484, 454);
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
			comboBoxTipo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Todas", "Libro", "Revista", "Articulo"}));
			comboBoxTipo.setBounds(825, 121, 106, 24);
		}
		return comboBoxTipo;
	}

	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setFont(new Font("Sylfaen", Font.PLAIN, 17));
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
			spinner.setBounds(869, 68, 62, 26);
		}
		return spinner;
	}

	//TEXTPANE
	private JTextPane getTxtpnDatosPrstamo() {
		if (txtpnDatosPrstamo == null) {
			txtpnDatosPrstamo = new JTextPane();
			txtpnDatosPrstamo.setText("Datos pr\u00E9stamo");
			txtpnDatosPrstamo.setDisabledTextColor(Color.BLACK);
			txtpnDatosPrstamo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			txtpnDatosPrstamo.setDisabledTextColor(Color.BLACK);
			txtpnDatosPrstamo.setEnabled(false);
			txtpnDatosPrstamo.setBackground(Color.WHITE);
			txtpnDatosPrstamo.setBounds(685, 161, 137, 32);
		}
		return txtpnDatosPrstamo;
	}

	private JTextPane getTextPanePub() {
		if (textPanePub == null) {
			textPanePub = new JTextPane();
			textPanePub.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textPanePub.setBounds(681, 324, 250, 25);
			textPanePub.setEditable(false);
			textPanePub.setBackground(Color.WHITE);
		}
		return textPanePub;
	}

	private JTextPane getTextPaneNombreUsuario() {
		if (textPaneNombreUsuario == null) {
			textPaneNombreUsuario = new JTextPane();
			textPaneNombreUsuario.setBackground(Color.WHITE);
			textPaneNombreUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textPaneNombreUsuario.setBounds(681, 242, 250, 25);
			textPaneNombreUsuario.setEditable(false);
		}
		return textPaneNombreUsuario;
	}

	private JTextPane getTextPaneTrabajador() {
		if (textPaneTrabajador == null) {
			textPaneTrabajador = new JTextPane();
			textPaneTrabajador.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textPaneTrabajador.setBounds(681, 403, 250, 25);
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
