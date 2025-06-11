package Visual ;
import Logica.Biblioteca;
import Logica.Prestamo;
import Utiles.Colores;
import Utiles.PrestamoReporte3TableModel;
import Utiles.PrestamoTableModel;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

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

		setBounds(500, 100, 773, 583);
		setBackground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		fechaInicio  = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaInicio.setBounds(130, 79, 125, 26);
		getContentPane().add(fechaInicio);

		fechaFin  = new JDateChooser("dd/MM/yyyy","##/##/####",'_');
		fechaFin.setBounds(352, 79, 125, 26);
		getContentPane().add(fechaFin);

		Label inferior = new Label("Entre :");
		inferior.setFont(new Font("SansSerif", Font.PLAIN, 14));
		inferior.setBounds(46, 78, 52, 27);
		getContentPane().add(inferior);

		Label label_1 = new Label("Y");
		label_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		label_1.setBounds(298, 79, 17, 27);
		getContentPane().add(label_1);

		Label label_2 = new Label("Prestamos Realizados ");
		label_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		label_2.setBounds(217, 29, 214, 27);
		getContentPane().add(label_2);

		final JButton buscarButton = new JButton("Buscar");
		buscarButton.setBounds(619, 150, 117, 35);
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Date fechaInferior = fechaInicio.getDate();			
				Date fechaSuperior = fechaFin.getDate();
				if (fechaSuperior.before(fechaInferior)){
					JOptionPane.showMessageDialog(null, "Error. Revise el orden de las fechas.");
				}
				else { 
					Prestamo[] prestamosEnRango  = Biblioteca.getInstancia().rangoPrestamo(fechaInferior, fechaSuperior);
					cargarTablaPrestamos(prestamosEnRango);
				}	
			}
		});
		getContentPane().add(buscarButton);
		getContentPane().add(getScrollPane());

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSalir.setBounds(619, 220, 117, 35);
		getContentPane().add(btnSalir);
	}

	private static JTable getTable() {
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

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(49, 138, 522, 315);
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