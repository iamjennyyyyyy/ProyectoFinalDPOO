package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Logica.Biblioteca;
import Logica.UsuarioAcreditado;
import Utiles.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Utiles.Colores;

import javax.swing.JScrollPane;

public class GestionUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GestionUsuario dialog = new GestionUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GestionUsuario() {
		setBounds(100, 100, 820, 583);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getBtnNewButton());
		cargarTablaUsuarios();
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(Colores.getColorbeige());
			table.setForeground(new Color(0, 0, 0));
			table.setFont(new Font("Tahoma", Font.PLAIN, 13));
			table.setGridColor(Color.WHITE);
			table.setRowHeight(20);
		}
		return table;
	}
	
	public static void cargarTablaUsuarios(){
		
		ArrayList<UsuarioAcreditado> usuarios = Biblioteca.getInstancia().getUsuarios();
		UsuarioAcreditado[] tabla = new UsuarioAcreditado[usuarios.size()];
		
		for(int i=0;i<tabla.length;i++){
			tabla[i] = usuarios.get(i);
		}
		UsuarioTableModel modelo = new UsuarioTableModel(tabla);
		table.setModel(modelo);
		table.repaint();
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(50, 46, 428, 451);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Agregar Usuario");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AgregarUsuario formulario = new AgregarUsuario();
					formulario.setVisible(true);
					cargarTablaUsuarios();
				}
			});
			btnNewButton.setBounds(575, 82, 89, 23);
		}
		return btnNewButton;
	}
	
	
}
