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
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

import java.awt.SystemColor;

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
	private JLabel numPrestamosUsuario;
	private JLabel numEjempPub;


	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionPrestamo() {
		getContentPane().setBackground(Color.WHITE);
		
		setBounds(0, 80, 1367, 639);
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
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(Colores.getColorbeige());
			table.setForeground(new Color(0, 0, 0));
			table.setFont(new Font("SansSerif", Font.PLAIN, 15));
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
			            	
			            	
			            	int posUser = Biblioteca.getInstancia().buscarPosUsuario(u);
			            	int posPub = Biblioteca.getInstancia().buscarPosPublicacion(p);
			            	
			            	comboBoxUsuario.setSelectedIndex(posUser);
			            	comboBoxPub.setSelectedIndex(posPub);
			                
//			                UsuarioAcreditado u = Biblioteca.getInstancia().buscarUsuarioPorId(valor);
			            	
			            	numPrestamosUsuario.setVisible(true);
			                numEjempPub.setVisible(true);
			                
			                numPrestamosUsuario.setText("Préstamos: " + u.getPrestamos().size());
			                numEjempPub.setText("Ejemplares: " + p.getCantEjemplares());
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
			scrollPane_1.setBounds(58, 88, 585, 451);
			scrollPane_1.setViewportView(getTable());
		}
		return scrollPane_1;
	}
	private JButton getBtnAgregarPrestamo() {
		if (btnAgregarPrestamo == null) {
			btnAgregarPrestamo = new JButton("Registrar");
			btnAgregarPrestamo.setFont(new Font("SansSerif", Font.PLAIN, 18));
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
			btnAgregarPrestamo.setBounds(855, 479, 115, 40);
		}
		return btnAgregarPrestamo;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(816, 102, 465, 339);
		}
		return label;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblUsuario.setBounds(865, 165, 93, 29);
		}
		return lblUsuario;
	}
	private JLabel getLblPublicacin() {
		if (lblPublicacin == null) {
			lblPublicacin = new JLabel("Publicaci\u00F3n:");
			lblPublicacin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblPublicacin.setBounds(865, 273, 119, 24);
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
			button.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
			button.setBorder(null);
			button.setBackground(Color.WHITE);
			button.setAlignmentX(0.5f);
			button.setIcon(new ImageIcon("src/images/otroLogoBorrar50x50.png"));
			button.setBounds(1289, 25, 50, 50);
		}
		return button;
	}
	private JButton getBtnDevolver() {
		if (btnDevolver == null) {
			btnDevolver = new JButton("Devolver");
			btnDevolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UsuarioAcreditado u = Biblioteca.getInstancia().buscarUsuarioPorNombre(comboBoxUsuario.getSelectedItem().toString());
					Publicacion p = Biblioteca.getInstancia().buscarPublicacionPorNombre(comboBoxPub.getSelectedItem().toString());
					Prestamo prest = Biblioteca.getInstancia().buscarPrestamoPorPublicacion(u, p);
					Biblioteca.getInstancia().devolverPublicacion(prest);
				}
			});
			btnDevolver.setFont(new Font("SansSerif", Font.PLAIN, 18));
			btnDevolver.setBounds(998, 479, 115, 40);
		}
		return btnDevolver;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setFont(new Font("SansSerif", Font.PLAIN, 18));
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
			btnConfirmar.setBounds(918, 366, 150, 34);
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
			JOptionPane.showMessageDialog(null, mensaje, "Info", JOptionPane.INFORMATION_MESSAGE);
		}
		return realizado;
	}
	
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
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
			btnCancelar.setIcon(new ImageIcon("src/images/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(1118, 366, 30, 30);
		}
		return btnCancelar;
	}
	private JTextPane getTxtpnRealizarPrstamo() {
		if (txtpnRealizarPrstamo == null) {
			txtpnRealizarPrstamo = new JTextPane();
			txtpnRealizarPrstamo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			txtpnRealizarPrstamo.setText("Realizar pr\u00E9stamo");
			txtpnRealizarPrstamo.setBounds(884, 88, 157, 29);
		}
		return txtpnRealizarPrstamo;
	}
	private JButton getBtnInfo() {
		if (btnInfo == null) {
			btnInfo = new JButton("");
			btnInfo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					InfoPrestamo i = new InfoPrestamo();
					i.setVisible(true);
				}
			});
			btnInfo.setIcon(new ImageIcon("src/images/iconoInfo45x45.png"));
			btnInfo.setBounds(1217, 27, 45, 45);
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
			comboBoxUsuario.setBounds(855, 210, 280, 35);
			comboBoxUsuario.addItemListener(new ItemListener() {
			    @Override
			    public void itemStateChanged(ItemEvent e) {
			        if (e.getStateChange() == ItemEvent.SELECTED) {
//			            Object itemSeleccionado = comboBox.getSelectedItem();
			            
			            UsuarioAcreditado u = Biblioteca.getInstancia().buscarUsuarioPorNombre(comboBoxUsuario.getSelectedItem().toString());
			            numPrestamosUsuario.setText("Préstamos: " + u.getPrestamos().size());
			        }
			    }
			});
			comboBoxUsuario.setModel(new DefaultComboBoxModel(nombresUsuarios));
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
			comboBoxPub.setBounds(855, 315, 280, 35);
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
			btnProrroga.setFont(new Font("SansSerif", Font.PLAIN, 18));
			btnProrroga.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			btnProrroga.setBounds(1140, 479, 115, 40);
		}
		return btnProrroga;
	}
	private JLabel getNumPrestamosUsuario() {
		if (numPrestamosUsuario == null) {
			numPrestamosUsuario = new JLabel("");
			numPrestamosUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
			numPrestamosUsuario.setBounds(1072, 160, 105, 34);
		}
		return numPrestamosUsuario;
	}
	private JLabel getNumEjempPub() {
		if (numEjempPub == null) {
			numEjempPub = new JLabel("");
			numEjempPub.setFont(new Font("SansSerif", Font.PLAIN, 18));
			numEjempPub.setBounds(1072, 273, 138, 34);
		}
		return numEjempPub;
	}
}
