package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.UsuarioAcreditado;
import Utiles.ModelUsuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Component;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import com.toedter.calendar.JDateChooser;

public class GestionUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JList<UsuarioAcreditado> list = new JList<UsuarioAcreditado>();
	private ModelUsuario modelo = new ModelUsuario();
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNombre;
	private int idUsuario = 15;
	private boolean agregar = false;
	private boolean eliminar = false;
	private JPanel panelDatosPrestamo;
	private JLabel lblPublicacin;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNombreTrabajador;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private JPanel panelDatosFechas;
	private JDateChooser dateChooser;
	private JDateChooser dateChooser_1;
	private JLabel lblInicioPrstamo;
	private JLabel lblFechaMxima;
	private JLabel lblFechaDevolucin;
	private JDateChooser dateChooser_2;
	private JButton btnNuevo;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnConfirmar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionUsuarios() {
		setBounds(500, 100, 820, 583);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getTabbedPane());
		contentPanel.add(getBtnNuevo());
		contentPanel.add(getBtnEliminar());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getBtnConfirmar());
		modelo.setlstUsuarios(Biblioteca.getInstancia().getUsuarios());
	}

	//BOTONES
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setBorder(null);
			btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSalir.setIcon(new ImageIcon("src/images/otroLogoBorrar50x50.png"));
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
			btnSalir.setBounds(765, 11, 50, 50);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}

	//OTROS COMPONENTES
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Lista usuarios:");
			lblNewLabel.setBounds(58, 41, 138, 27);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
		}
		return lblNewLabel;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Identificador usuario:");
			lblNombre.setBounds(56, 27, 177, 25);
			lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return lblNombre;
	}

	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(89, 87, 478, 451);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return list;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(58, 100, 397, 451);
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
//			list.addListSelectionListener(new ListSelectionListener() {
//				public void valueChanged(ListSelectionEvent e) {
//					int indice = list.getSelectedIndex();
//
//					if (indice > -1) {
//						UsuarioAcreditado u = modelo.getUsuarioAt(indice);
//
//						textFieldNombreUsuario.setText(u.getNombreCompleto());
//						textFieldEdad.setText("" + u.getEdad());
//						textFieldSexo.setText(u.getSexo());
//						textFieldId.setText(u.getId());
//					}
//				}
//			});
			list.setFont(new Font("SansSerif", Font.PLAIN, 17));
			list.setModel(modelo);
			scrollPane.setViewportView(list);
		}
		return scrollPane;
	}

	//METODOS CRUD
	public boolean registrarUsuario() {

		boolean agregado = false;

//		String nombre = textFieldNombreUsuario.getText();
//		int edad = Integer.parseInt(textFieldEdad.getText());
//		String sexo = textFieldSexo.getText();
//		String iddUsuario = "" + idUsuario;

//		if (nombre.isEmpty()) {
//			JOptionPane.showMessageDialog(null, "Introduzca el nombre", "Error", JOptionPane.ERROR_MESSAGE);		}
//		if (edad < 18 || edad > 110) {
//			if(edad < 18)
//				JOptionPane.showMessageDialog(null, "Lectores menores de edad no pueden registrarse", "Error", JOptionPane.ERROR_MESSAGE);			
//			else if(edad > 110)
//				JOptionPane.showMessageDialog(null, "Edad no admitida", "Error", JOptionPane.ERROR_MESSAGE);
//		}

//		list.clearSelection();
//		UsuarioAcreditado u = Biblioteca.getInstancia().crearUsuarioAcreditado(iddUsuario, nombre, edad, sexo);
//		if(u != null){
//			modelo.addUsuario(u);
//			agregado = true;
//		}

		return agregado;
	}

//	public boolean editarUsuario() {
//
//		boolean editado = false;
//
//		if (list.isSelectionEmpty()) {
//			JOptionPane.showMessageDialog(null, "Seleccione un usuario a modificar", "Error", JOptionPane.ERROR_MESSAGE);
//		}
//		else{
//
//			int indice = list.getSelectedIndex();
//			UsuarioAcreditado u = list.getSelectedValue();
//
////			if (textFieldNombreUsuario.getText().isEmpty()) {
////				JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Error", JOptionPane.ERROR_MESSAGE);
////			}
//////			if(textFieldId.getText().isEmpty()){
////				JOptionPane.showMessageDialog(null, "Introduzca un carnet", "Error", JOptionPane.ERROR_MESSAGE);
////			}
////			else{
////				u.setNombreCompleto(textFieldNombreUsuario.getText());
////				u.setEdad(Integer.parseInt(textFieldEdad.getText()));
////				u.setSexo(textFieldSexo.getText());
////				u.setId(textFieldId.getText());
//
//				modelo.updateUsuario(indice, u);
//				JOptionPane.showMessageDialog(null, "Usuario modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
//				editado = true;
//			}
//		}
//		return editado;
//	}

	public void eliminarUsuario() {

		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleccione un usuario a eliminar");
		}
		if(!list.isSelectionEmpty()){

			UsuarioAcreditado u = list.getSelectedValue();
			int indice = list.getSelectedIndex();

			Biblioteca.getInstancia().eliminarUsuario(u);
			modelo.removeUsuario(indice);

			JOptionPane.showMessageDialog(null, "Usuario " + u.getNombreCompleto() + " ha sido eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void reiniciarComponentes(){
		
//		textFieldNombreUsuario.setText("");
//		textFieldId.setText("");
//		textFieldEdad.setText("18");
//		textFieldSexo.setText("M");
		
		agregar = false;
		eliminar = false;
		
	}
	private JPanel getPanelDatosPrestamo() {
		if (panelDatosPrestamo == null) {
			panelDatosPrestamo = new JPanel();
			panelDatosPrestamo.setLayout(null);
			panelDatosPrestamo.add(getLblNombre());
			panelDatosPrestamo.add(getLblPublicacin());
			panelDatosPrestamo.add(getTextField_2());
			panelDatosPrestamo.add(getTextField_3());
			panelDatosPrestamo.add(getLabel_2());
			panelDatosPrestamo.add(getTextField_1());
		}
		return panelDatosPrestamo;
	}
	private JLabel getLblPublicacin() {
		if (lblPublicacin == null) {
			lblPublicacin = new JLabel("Identificador publicaci\u00F3n:");
			lblPublicacin.setBounds(56, 140, 222, 25);
			lblPublicacin.setFont(new Font("SansSerif", Font.PLAIN, 19));
		}
		return lblPublicacin;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setBounds(56, 73, 222, 33);
			textField_2.setColumns(10);
		}
		return textField_2;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setBounds(56, 185, 222, 33);
			textField_3.setColumns(10);
		}
		return textField_3;
	}
	private JLabel getLabel_2() {
		if (lblNombreTrabajador == null) {
			lblNombreTrabajador = new JLabel("Identificador trabajador:");
			lblNombreTrabajador.setBounds(56, 250, 222, 25);
			lblNombreTrabajador.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return lblNombreTrabajador;
	}
	private JTextField getTextField_1() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(56, 292, 222, 33);
			textField.setColumns(10);
		}
		return textField;
	}
	private JTabbedPane getTabbedPane() {
		if (tabbedPane == null) {
			tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(Color.WHITE);
			tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 17));
			tabbedPane.setBounds(479, 67, 341, 408);
			tabbedPane.addTab("Datos ID", null, getPanelDatosPrestamo(), null);
			tabbedPane.addTab("Fechas", null, getPanelDatosFechas(), null);
		}
		return tabbedPane;
	}
	private JPanel getPanelDatosFechas() {
		if (panelDatosFechas == null) {
			panelDatosFechas = new JPanel();
			panelDatosFechas.setLayout(null);
			panelDatosFechas.add(getDateChooser());
			panelDatosFechas.add(getDateChooser_1());
			panelDatosFechas.add(getLblInicioPrstamo());
			panelDatosFechas.add(getLblFechaMxima());
			panelDatosFechas.add(getLblFechaDevolucin());
			panelDatosFechas.add(getDateChooser_2());
		}
		return panelDatosFechas;
	}
	private JDateChooser getDateChooser() {
		if (dateChooser == null) {
			dateChooser = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
			dateChooser.setBounds(46, 101, 99, 33);
		}
		return dateChooser;
	}
	private JDateChooser getDateChooser_1() {
		if (dateChooser_1 == null) {
			dateChooser_1 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
			dateChooser_1.setBounds(46, 224, 99, 33);
		}
		return dateChooser_1;
	}
	private JLabel getLblInicioPrstamo() {
		if (lblInicioPrstamo == null) {
			lblInicioPrstamo = new JLabel("Fecha pr\u00E9stamo:");
			lblInicioPrstamo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblInicioPrstamo.setBounds(46, 53, 145, 25);
		}
		return lblInicioPrstamo;
	}
	private JLabel getLblFechaMxima() {
		if (lblFechaMxima == null) {
			lblFechaMxima = new JLabel("Fecha m\u00E1xima:");
			lblFechaMxima.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblFechaMxima.setBounds(46, 175, 127, 25);
		}
		return lblFechaMxima;
	}
	private JLabel getLblFechaDevolucin() {
		if (lblFechaDevolucin == null) {
			lblFechaDevolucin = new JLabel("Fecha devoluci\u00F3n:");
			lblFechaDevolucin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblFechaDevolucin.setBounds(46, 290, 167, 25);
		}
		return lblFechaDevolucin;
	}
	private JDateChooser getDateChooser_2() {
		if (dateChooser_2 == null) {
			dateChooser_2 = new JDateChooser("dd/MM/yyyy", "##/##/####", '_');
			dateChooser_2.setBounds(46, 339, 99, 33);
		}
		return dateChooser_2;
	}
	private JButton getBtnNuevo() {
		if (btnNuevo == null) {
			btnNuevo = new JButton("Nuevo");
			btnNuevo.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnNuevo.setBounds(549, 486, 92, 32);
		}
		return btnNuevo;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnEliminar.setBounds(662, 486, 92, 32);
		}
		return btnEliminar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.setVisible(false);
			btnCancelar.setToolTipText("Reiniciar formulario");
			btnCancelar.setBorder(null);
			btnCancelar.setIcon(new ImageIcon("src/images/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(724, 496, 30, 30);
		}
		return btnCancelar;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setVisible(false);
			btnConfirmar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnConfirmar.setBounds(549, 496, 151, 32);
		}
		return btnConfirmar;
	}
}
