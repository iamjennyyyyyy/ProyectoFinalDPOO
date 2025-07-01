package Visual ;
import Logica.Biblioteca;
import Logica.Prestamo;
import Utiles.Colores;
import Utiles.PrestamoReporte3TableModel;
import Utiles.PrestamoTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;

public class Reporte3PrestamoRango extends JDialog {

	private JDateChooser fechaInicio;
	private JDateChooser fechaFin;
	private static JTable table;
	private JScrollPane scrollPane;

	public Reporte3PrestamoRango() {

		setTitle("Seleccionar Fecha");
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(null);
		getContentPane().add(getScrollPane());

		setBounds(338, 159, 1026, 562);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		fechaInicio  = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaInicio.setBounds(215, 76, 125, 26);
		getContentPane().add(fechaInicio);

		fechaFin  = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaFin.setBounds(489, 76, 125, 26);
		getContentPane().add(fechaFin);

		Label inferior = new Label("Entre :");
		inferior.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		inferior.setBounds(136, 76, 52, 27);
		getContentPane().add(inferior);

		Label label_1 = new Label("Y");
		label_1.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		label_1.setBounds(404, 75, 17, 27);
		getContentPane().add(label_1);

		Label label_2 = new Label("Prestamos Realizados ");
		label_2.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		label_2.setBounds(279, 34, 214, 27);
		getContentPane().add(label_2);

		final JButton buscarButton = new JButton("Buscar");
		buscarButton.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		buscarButton.setBounds(777, 135, 117, 35);
		buscarButton.setBackground(Colores.getBeigetabla());
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date fechaInferior = fechaInicio.getDate();			
				Date fechaSuperior = fechaFin.getDate();
				if(fechaSuperior == null || fechaInferior == null){
					JOptionPane.showMessageDialog(null, "Seleccione un rango de fechas correcto", "Información", JOptionPane.WARNING_MESSAGE);
				}
				else{
					if (fechaSuperior.before(fechaInferior)){
						JOptionPane.showMessageDialog(null, "Error. Revise el orden de las fechas.");
					}
					else { 
						Prestamo[] prestamosEnRango  = Biblioteca.getInstancia().rangoPrestamo(fechaInferior, fechaSuperior);
						cargarTablaPrestamos(prestamosEnRango);
					}	
				}
			}
		});
		getContentPane().add(buscarButton);
		getContentPane().add(getScrollPane());

		JButton btnSalir = new JButton("");
		btnSalir.setBorder(null);
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setIcon(new ImageIcon("src/images/iconos/otroLogoBorrar50x50.png"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(956, 11, 60, 50);
		getContentPane().add(btnSalir);
	}

	private static JTable getTable() {
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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(136, 135, 581, 365);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}

	public static void cargarTablaPrestamos(Prestamo[] prestamos){

		PrestamoReporte3TableModel modelo = new PrestamoReporte3TableModel(prestamos);
		getTable().setModel(modelo);
		getTable().repaint();
	}
}