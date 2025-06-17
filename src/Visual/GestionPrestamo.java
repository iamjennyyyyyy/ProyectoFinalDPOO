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
import Logica.Publicacion;
import Logica.UsuarioAcreditado;
import Utiles.PrestamoTableModel;
import Utiles.Colores;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class GestionPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static JTable table;
	private JScrollPane scrollPane_1;
	private JButton btnAgregarPrestamo;
	private JComboBox comboBox;
	private JLabel label;
	private JLabel lblUsuario;
	private JLabel lblPublicacin;
	private JComboBox comboBox_1;
	private JButton button;
	private JButton btnDevolver;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private ArrayList<Publicacion> publicaciones = Biblioteca.getInstancia().getPublicaciones();
	private ArrayList<UsuarioAcreditado> usuarios = Biblioteca.getInstancia().getUsuarios();
	private JTextPane txtpnRealizarPrstamo;

	
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
		contentPanel.add(getTxtpnRealizarPrstamo());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getBtnAgregarPrestamo());
		contentPanel.add(getComboBox());
		contentPanel.add(getLblUsuario());
		contentPanel.add(getLblPublicacin());
		contentPanel.add(getComboBox_1());
		contentPanel.add(getButton());
		contentPanel.add(getBtnDevolver());
		contentPanel.add(getBtnConfirmar());
		contentPanel.add(getLabel());
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
			scrollPane_1.setBounds(58, 88, 478, 451);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JButton getBtnAgregarPrestamo() {
		if (btnAgregarPrestamo == null) {
			btnAgregarPrestamo = new JButton("Registrar");
			btnAgregarPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comboBox.setEnabled(true);
					comboBox_1.setEnabled(true);
					btnConfirmar.setVisible(true);
					btnCancelar.setVisible(true);
					btnAgregarPrestamo.setVisible(false);
					btnDevolver.setVisible(false);
				}
			});
			btnAgregarPrestamo.setBounds(585, 419, 85, 29);
		}
		return btnAgregarPrestamo;
	}
	private JComboBox getComboBox() {
		
		String[] nombresPub = new String[publicaciones.size()];
		
		for(int i = 0; i < publicaciones.size(); i++){
			nombresPub[i] = publicaciones.get(i).getTitulo();
		}
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(nombresPub));
			comboBox.setBounds(608, 261, 149, 25);
			comboBox.setEnabled(false);
		}
		return comboBox;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(576, 89, 219, 292);
		}
		return label;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 17));
			lblUsuario.setBounds(608, 136, 79, 20);
		}
		return lblUsuario;
	}
	private JLabel getLblPublicacin() {
		if (lblPublicacin == null) {
			lblPublicacin = new JLabel("Publicaci\u00F3n:");
			lblPublicacin.setFont(new Font("SansSerif", Font.PLAIN, 17));
			lblPublicacin.setBounds(608, 223, 112, 20);
		}
		return lblPublicacin;
	}
	private JComboBox getComboBox_1() {
		
		String[] nombresUsuarios = new String[usuarios.size()];
		
		for(int i = 0; i < usuarios.size(); i++){
			nombresUsuarios[i] = usuarios.get(i).getNombreCompleto();
		}
		
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox();
			comboBox_1.setBounds(608, 175, 149, 25);
			comboBox_1.setModel(new DefaultComboBoxModel(nombresUsuarios));
			comboBox_1.setEnabled(false);
		}
		return comboBox_1;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			button.setHorizontalTextPosition(SwingConstants.CENTER);
			button.setForeground(Color.WHITE);
			button.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
			button.setBorder(null);
			button.setBackground(Color.WHITE);
			button.setAlignmentX(0.5f);
			button.setIcon(new ImageIcon("src/images/otroLogoBorrar50x50.png"));
			button.setBounds(760, 11, 50, 50);
		}
		return button;
	}
	private JButton getBtnDevolver() {
		if (btnDevolver == null) {
			btnDevolver = new JButton("Devolver");
			btnDevolver.setBounds(697, 419, 85, 29);
		}
		return btnDevolver;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int idIndexUsuario = comboBox_1.getSelectedIndex();
					int idIndexPub = comboBox.getSelectedIndex();
					
					UsuarioAcreditado u = usuarios.get(idIndexUsuario);
					Publicacion p = publicaciones.get(idIndexPub);
					
					Biblioteca.getInstancia().solicitarPrestamo(u, p, Login.obtenerAdmin());
					
					JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
					
					cargarTablaPrestamos();
					
					comboBox.setSelectedIndex(0);
					comboBox.setEnabled(false);
					comboBox_1.setSelectedIndex(0);
					comboBox_1.setEnabled(false);
					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(false);
					btnAgregarPrestamo.setVisible(true);
					btnDevolver.setVisible(true);
				}
			});
			btnConfirmar.setBounds(608, 320, 105, 29);
			btnConfirmar.setVisible(false);
		}
		return btnConfirmar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.setVisible(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					comboBox.setSelectedIndex(0);
					comboBox.setEnabled(false);
					comboBox_1.setSelectedIndex(0);
					comboBox_1.setEnabled(false);
					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(false);
					btnAgregarPrestamo.setVisible(true);
					btnDevolver.setVisible(true);
				}
			});
			btnCancelar.setToolTipText("Reiniciar formulario");
			btnCancelar.setBorder(null);
			btnCancelar.setIcon(new ImageIcon("src/images/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(735, 320, 30, 30);
		}
		return btnCancelar;
	}
	private JTextPane getTxtpnRealizarPrstamo() {
		if (txtpnRealizarPrstamo == null) {
			txtpnRealizarPrstamo = new JTextPane();
			txtpnRealizarPrstamo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			txtpnRealizarPrstamo.setText("Realizar pr\u00E9stamo");
			txtpnRealizarPrstamo.setBounds(592, 74, 157, 29);
		}
		return txtpnRealizarPrstamo;
	}
}
