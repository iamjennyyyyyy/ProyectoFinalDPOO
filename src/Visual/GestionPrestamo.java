package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Inicializadora.Inicializar;
import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.Publicacion;
import Logica.UsuarioAcreditado;
import Utiles.MiPersonalizacion;
import Utiles.PrestamoTableModel;
import Utiles.Colores;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JMenuItem;

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
	private JButton btnInfo;
	private JComboBox comboBoxUsuario;
	private JComboBox comboBoxPub;
	private JButton btnProrroga;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDetallesDelUsuario;
	private JMenuItem mntmDetallesDeLa;
	private JLabel numPrestamosUsuario;
	private JLabel numEjempPub;


	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MiPersonalizacion.aplicarTema();
					Inicializar.Inicio();
//					Login frame = new Login();
					GestionPrestamo frame = new GestionPrestamo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the dialog.
	 */
	public GestionPrestamo() {
		getContentPane().setBackground(Color.WHITE);

		setBounds(338, 159, 1026, 562);
		getContentPane().setLayout(new BorderLayout());
		setUndecorated(true);
		setModal(true);
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		addPopup(contentPanel, getPopupMenu());
		contentPanel.add(getTxtpnRealizarPrstamo());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getScrollPane_1());
		contentPanel.add(getBtnAgregarPrestamo());
		contentPanel.add(getLblPublicacin());
		contentPanel.add(getButton());
		contentPanel.add(getBtnDevolver());
		contentPanel.add(getBtnConfirmar());
		contentPanel.add(getBtnInfo());
		contentPanel.add(getComboBoxUsuario());
		contentPanel.add(getComboBoxPub());
		contentPanel.add(getLblUsuario());
		contentPanel.add(getBtnProrroga());
		contentPanel.add(getNumPrestamosUsuario());
		contentPanel.add(getNumEjempPub());
		contentPanel.add(getLabel());
		cargarTablaPrestamos();
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setToolTipText("Lista de pr\u00E9stamos");
			table.setEnabled(true);
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent e) {
					if (e.isPopupTrigger()) { // Verifica si es clic derecho
						int fila = table.rowAtPoint(e.getPoint()); // Obtiene la fila bajo el cursor
						if (fila != -1) {
							table.setRowSelectionInterval(fila, fila); // Selecciona la fila
							popupMenu.show(table, e.getX(), e.getY()); // Muestra el menú
							btnDevolver.setVisible(true);
							btnProrroga.setVisible(true);
						}
						else{
							btnDevolver.setVisible(false);
							btnProrroga.setVisible(false);
						}
					}
				}
			});
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Segoe UI", Font.PLAIN, 14));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(new Color(250, 245, 240)); // Color pastel claro
			table.setForeground(new Color(60, 40, 20));    // Texto oscuro
			table.setFont(new Font("Sylfaen", Font.PLAIN, 17));
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
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					if (!e.getValueIsAdjusting()) {

						int filaSeleccionada = table.getSelectedRow();

						if (filaSeleccionada != -1) {

							String idUser = (String) table.getValueAt(filaSeleccionada, 0); // Columna 0
							String idPub = (String) table.getValueAt(filaSeleccionada, 1); // Columna 0

							UsuarioAcreditado u = Biblioteca.getInstancia().buscarUsuarioPorId(idUser);
							Publicacion p = Biblioteca.getInstancia().buscarPublicacionPorId(idPub);

							if(u != null && p != null){

								int posUser = Biblioteca.getInstancia().buscarPosUsuario(u);
								int posPub = Biblioteca.getInstancia().buscarPosPublicacion(p);

								comboBoxUsuario.setSelectedIndex(posUser);
								comboBoxPub.setSelectedIndex(posPub);

								numPrestamosUsuario.setVisible(true);
								numEjempPub.setVisible(true);
								numPrestamosUsuario.setForeground(Color.BLACK);
								numEjempPub.setForeground(Color.BLACK);
								numPrestamosUsuario.setText("Préstamos: " + u.getPrestamos().size());
								numEjempPub.setText("Ejemplares: " + p.getCantEjemplares());
							}
						}
					}
				}
			});
		}
		return table;
	}

	public static void cargarTablaPrestamos(){

		ArrayList<Prestamo> prestamos = Biblioteca.getInstancia().getPrestamosTotales();
		Prestamo[] tabla = new Prestamo[prestamos.size()];

		for(int i=0;i<tabla.length;i++){
			tabla[i] = prestamos.get(i);
		}
		PrestamoTableModel modelo = new PrestamoTableModel(tabla, true) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(modelo);
		table.repaint();
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setFont(new Font("SansSerif", Font.PLAIN, 18));
			scrollPane_1.setBounds(51, 47, 523, 456);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JButton getBtnAgregarPrestamo() {
		if (btnAgregarPrestamo == null) {
			btnAgregarPrestamo = new JButton("Registrar");
			btnAgregarPrestamo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnAgregarPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					comboBoxPub.setEnabled(true);
					comboBoxUsuario.setEnabled(true);

					table.setEnabled(false);

					btnConfirmar.setVisible(true);
					btnCancelar.setVisible(true);

					btnAgregarPrestamo.setVisible(false);
					btnProrroga.setVisible(false);
					btnDevolver.setVisible(false);

				}
			});
			btnAgregarPrestamo.setBounds(634, 473, 106, 30);
		}
		return btnAgregarPrestamo;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(650, 86, 333, 353);
		}
		return label;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblUsuario.setBounds(684, 131, 93, 29);
		}
		return lblUsuario;
	}
	private JLabel getLblPublicacin() {
		if (lblPublicacin == null) {
			lblPublicacin = new JLabel("Publicaci\u00F3n:");
			lblPublicacin.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			lblPublicacin.setBounds(684, 244, 119, 24);
		}
		return lblPublicacin;
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
			button.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			button.setBorder(null);
			button.setBackground(Color.WHITE);
			button.setAlignmentX(0.5f);
			button.setIcon(new ImageIcon("src/images/iconos/otroLogoBorrar50x50.png"));
			button.setBounds(966, 11, 50, 50);
		}
		return button;
	}
	private JButton getBtnDevolver() {
		if (btnDevolver == null) {
			btnDevolver = new JButton("Devolver");
			btnDevolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int indice = table.getSelectedRow();
					if(indice != -1){
						Prestamo p = Biblioteca.getInstancia().buscarPrestamoPorPosicion(indice);
						if(p != null){
							boolean devuelta = true;
							try{
								Biblioteca.getInstancia().devolverPublicacion(p);
							}
							catch(IllegalArgumentException e){
								JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
								devuelta = false;
							}
							if(devuelta){
								cargarTablaPrestamos();
								numPrestamosUsuario.setText("Préstamos: " + p.getUser().getPrestamos().size());
								numEjempPub.setText("Ejemplares: " + p.getPub().getCantEjemplares());
								JOptionPane.showMessageDialog(null, "Se ha devuelto la publicación correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Seleccione un préstamo a devolver", "Información", JOptionPane.WARNING_MESSAGE);
				}
			});
			btnDevolver.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnDevolver.setBounds(760, 474, 106, 29);
		}
		return btnDevolver;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					boolean prestamoRealizable = realizarPrestamo();

					if(prestamoRealizable){

						JOptionPane.showMessageDialog(null, "Préstamo realizado con éxito", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
						cargarTablaPrestamos();

						comboBoxPub.setEnabled(false);
						comboBoxUsuario.setEnabled(false);

						table.setEnabled(true);

						btnConfirmar.setVisible(false);
						btnCancelar.setVisible(false);

						btnAgregarPrestamo.setVisible(true);
						btnProrroga.setVisible(true);
						btnDevolver.setVisible(true);
					}
				}
			});
			btnConfirmar.setBounds(702, 360, 132, 34);
			btnConfirmar.setVisible(false);
		}
		return btnConfirmar;
	}

	public boolean realizarPrestamo(){

		boolean realizado = true;

		int idIndexUsuario = comboBoxUsuario.getSelectedIndex();
		int idIndexPub = comboBoxPub.getSelectedIndex();

		UsuarioAcreditado u = usuarios.get(idIndexUsuario);
		Publicacion p = publicaciones.get(idIndexPub);

		try{
			if(u.getPrestamos().size() >= 3)
				numPrestamosUsuario.setForeground(Color.RED);
			else
				numPrestamosUsuario.setForeground(Color.BLACK);
			if(p.getCantEjemplares() < 3)
				numEjempPub.setForeground(Color.RED);
			else
				numEjempPub.setForeground(Color.BLACK);
			Biblioteca.getInstancia().solicitarPrestamo(u, p, Login.obtenerAdmin());
			numPrestamosUsuario.setForeground(Color.BLACK);
			numPrestamosUsuario.setForeground(Color.BLACK);
		}
		catch(IllegalArgumentException e){
			realizado = false;
			String mensaje = e.getMessage();
			JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		return realizado;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnCancelar.setVisible(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					comboBoxPub.setEnabled(false);
					comboBoxUsuario.setEnabled(false);

					table.setEnabled(true);

					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(false);

					btnAgregarPrestamo.setVisible(true);
					btnProrroga.setVisible(true);
					btnDevolver.setVisible(true);

					numEjempPub.setVisible(false);
					numPrestamosUsuario.setVisible(false);
				}
			});
			btnCancelar.setToolTipText("Reiniciar formulario");
			btnCancelar.setBorder(null);
			btnCancelar.setIcon(new ImageIcon("src/images/iconos/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(873, 364, 30, 30);
		}
		return btnCancelar;
	}
	private JTextPane getTxtpnRealizarPrstamo() {
		if (txtpnRealizarPrstamo == null) {
			txtpnRealizarPrstamo = new JTextPane();
			txtpnRealizarPrstamo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			txtpnRealizarPrstamo.setText("Realizar pr\u00E9stamo");
			txtpnRealizarPrstamo.setBounds(650, 46, 157, 29);
		}
		return txtpnRealizarPrstamo;
	}
	private JButton getBtnInfo() {
		if (btnInfo == null) {
			btnInfo = new JButton("");
			btnInfo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InfoPrestamo i = new InfoPrestamo();
					i.setVisible(true);
				}
			});
			btnInfo.setIcon(new ImageIcon("src/images/iconos/iconoInfo45x45.png"));
			btnInfo.setBounds(1032, 115, 45, 45);
			btnInfo.setHorizontalTextPosition(SwingConstants.CENTER);
			btnInfo.setForeground(Color.WHITE);
			btnInfo.setBorder(null);
			btnInfo.setBackground(Color.WHITE);
			btnInfo.setAlignmentX(0.5f);
		}
		return btnInfo;
	}
	private JComboBox getComboBoxUsuario() {

		String[] nombresUsuarios = new String[usuarios.size()];

		for(int i = 0; i < usuarios.size(); i++){
			nombresUsuarios[i] = usuarios.get(i).getNombreCompleto();
		}
		if (comboBoxUsuario == null) {
			comboBoxUsuario = new JComboBox();
			comboBoxUsuario.setBounds(688, 170, 280, 35);
			comboBoxUsuario.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						UsuarioAcreditado u = Biblioteca.getInstancia().buscarUsuarioPorNombre(comboBoxUsuario.getSelectedItem().toString());
						if(u != null)
							numPrestamosUsuario.setText("Préstamos: " + u.getPrestamos().size());
					}
				}
			});
			comboBoxUsuario.setModel(new DefaultComboBoxModel(nombresUsuarios));
			comboBoxUsuario.setFont(new Font("SansSerif", Font.PLAIN, 16));
			comboBoxUsuario.setEnabled(false);
		}
		return comboBoxUsuario;
	}
	private JComboBox getComboBoxPub() {
		String[] nombresPub = new String[publicaciones.size()];

		for(int i = 0; i < publicaciones.size(); i++){
			nombresPub[i] = publicaciones.get(i).getTitulo();
		}
		if (comboBoxPub == null) {
			comboBoxPub = new JComboBox();
			comboBoxPub.setBounds(688, 282, 280, 35);
			comboBoxPub.setFont(new Font("SansSerif", Font.PLAIN, 16));
			comboBoxPub.setModel(new DefaultComboBoxModel(nombresPub));
			comboBoxPub.addItemListener(new ItemListener() {
				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {

						Publicacion p = Biblioteca.getInstancia().buscarPublicacionPorNombre(comboBoxPub.getSelectedItem().toString());
						numEjempPub.setText("Ejemplares: " + p.getCantEjemplares());
					}
				}
			});
			comboBoxPub.setEnabled(false);
		}
		return comboBoxPub;
	}
	private JButton getBtnProrroga() {
		if (btnProrroga == null) {
			btnProrroga = new JButton("Pr\u00F3rroga");
			btnProrroga.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			btnProrroga.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int indice = table.getSelectedRow();
					if(indice != -1){
						boolean realizado = true;
						Prestamo p = Biblioteca.getInstancia().buscarPrestamoPorPosicion(indice);
						try{
							Biblioteca.getInstancia().realizarProrroga(p);
						}
						catch(IllegalArgumentException e){
							realizado = false;
							JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						if(realizado){
							JOptionPane.showMessageDialog(null, "Prórroga concedida", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							cargarTablaPrestamos();
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Seleccione un préstamo al cual realizar la prórroga", "Información", JOptionPane.WARNING_MESSAGE);
				}
			});
			btnProrroga.setBounds(887, 474, 106, 29);
		}
		return btnProrroga;
	}
	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			popupMenu.add(getMntmDetallesDelUsuario());
			popupMenu.add(getMntmDetallesDeLa());
		}
		return popupMenu;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmDetallesDelUsuario() {
		if (mntmDetallesDelUsuario == null) {
			mntmDetallesDelUsuario = new JMenuItem("Detalles del usuario");
			mntmDetallesDelUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmDetallesDelUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int indice = table.getSelectedRow();
					Prestamo p = Biblioteca.getInstancia().buscarPrestamoPorPosicion(indice);
					InfoUsuarioTablaPrestamo i = new InfoUsuarioTablaPrestamo(p.getUser());
					i.setVisible(true);
				}
			});
		}
		return mntmDetallesDelUsuario;
	}
	private JMenuItem getMntmDetallesDeLa() {
		if (mntmDetallesDeLa == null) {
			mntmDetallesDeLa = new JMenuItem("Detalles de la publicaci\u00F3n");
			mntmDetallesDeLa.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmDetallesDeLa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int indice = table.getSelectedRow();
					Prestamo p = Biblioteca.getInstancia().buscarPrestamoPorPosicion(indice);
					InfoPublicacionTablaPrestamo i = new InfoPublicacionTablaPrestamo(p.getPub());
					i.setVisible(true);
				}
			});
		}
		return mntmDetallesDeLa;
	}
	private JLabel getNumPrestamosUsuario() {
		if (numPrestamosUsuario == null) {
			numPrestamosUsuario = new JLabel("");
			numPrestamosUsuario.setVisible(false);
			numPrestamosUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			numPrestamosUsuario.setBounds(797, 131, 144, 29);
		}
		return numPrestamosUsuario;
	}
	private JLabel getNumEjempPub() {
		if (numEjempPub == null) {
			numEjempPub = new JLabel("");
			numEjempPub.setVisible(false);
			numEjempPub.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			numEjempPub.setBounds(797, 244, 157, 29);
		}
		return numEjempPub;
	}
}
