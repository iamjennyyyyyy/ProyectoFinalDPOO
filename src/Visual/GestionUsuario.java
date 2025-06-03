package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import Logica.Biblioteca;
import Logica.UsuarioAcreditado;
import Utiles.ModelUsuario;
import Utiles.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Utiles.Colores;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Component;

import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class GestionUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JList<UsuarioAcreditado> list = new JList<UsuarioAcreditado>();
	private ModelUsuario modelo = new ModelUsuario();
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextField textFieldNombreUsuario;
	private JLabel lblNombre;
	private JSpinner spinner;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JComboBox comboBox_Sexo;
	private int idUsuario = 15;
	private JCheckBox chckbxAgregar;
	private JCheckBox chckbxEditar;
	private JCheckBox chckbxEliminar;
	private JButton btnConfirmar;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionUsuario() {
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
		contentPanel.add(getTextFieldNombreUsuario());
		contentPanel.add(getLblNombre());
		contentPanel.add(getSpinner());
		contentPanel.add(getLblEdad());
		contentPanel.add(getLblSexo());
		contentPanel.add(getComboBox_Sexo());
		contentPanel.add(getChckbxAgregar());
		contentPanel.add(getChckbxEditar());
		contentPanel.add(getChckbxEliminar());
		contentPanel.add(getBtnConfirmar());
		contentPanel.add(getBtnCancelar());
		modelo.setListaUsuarios(Biblioteca.getInstancia().getUsuarios());
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(637, 486, 91, 32);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}
	private JList getList() {
		if (list == null) {
			list = new JList();
			list.setBounds(89, 87, 478, 451);
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return list;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Lista usuarios:");
			lblNewLabel.setBounds(58, 41, 138, 27);
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
		}
		return lblNewLabel;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setToolTipText("hola");
			scrollPane.setBounds(58, 100, 460, 451);
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent arg0) {
					chckbxAgregar.setSelected(false);
					chckbxEditar.setSelected(false);
					chckbxEliminar.setSelected(false);
					
					UsuarioAcreditado u = list.getSelectedValue();
					
					textFieldNombreUsuario.setText(u.getNombreCompleto());
					spinner.setValue(u.getEdad());
					comboBox_Sexo.setSelectedItem(u.getSexo());
				}
			});
			list.setFont(new Font("SansSerif", Font.PLAIN, 17));
			list.setModel(modelo);
			scrollPane.setViewportView(list);
		}
		return scrollPane;
	}
	private JTextField getTextFieldNombreUsuario() {
		if (textFieldNombreUsuario == null) {
			textFieldNombreUsuario = new JTextField();
			textFieldNombreUsuario.setBounds(571, 137, 209, 27);
			textFieldNombreUsuario.setColumns(10);
			textFieldNombreUsuario.setEnabled(false);
		}
		return textFieldNombreUsuario;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 17));
			lblNombre.setBounds(571, 103, 114, 20);
		}
		return lblNombre;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(18), null, null, new Integer(1)));
			spinner.setBounds(648, 205, 50, 20);
			spinner.setEnabled(false);
		}
		return spinner;
	}
	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 17));
			lblEdad.setBounds(571, 205, 54, 20);
		}
		return lblEdad;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 17));
			lblSexo.setBounds(571, 273, 54, 20);
		}
		return lblSexo;
	}
	private JComboBox getComboBox_Sexo() {
		if (comboBox_Sexo == null) {
			comboBox_Sexo = new JComboBox();
			comboBox_Sexo.setModel(new DefaultComboBoxModel(new String[] {"M", "F", "I"}));
			comboBox_Sexo.setBounds(648, 273, 50, 20);
			comboBox_Sexo.setEnabled(false);
		}
		return comboBox_Sexo;
	}
	private JCheckBox getChckbxAgregar() {
		if (chckbxAgregar == null) {
			chckbxAgregar = new JCheckBox("Agregar");
			chckbxAgregar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					chckbxEditar.setSelected(false);
					chckbxEliminar.setSelected(false);
					
					list.clearSelection();
					
					textFieldNombreUsuario.setEnabled(true);
					spinner.setEnabled(true);
					comboBox_Sexo.setEnabled(true);
					
					textFieldNombreUsuario.setText("");
					spinner.setValue(18);
					comboBox_Sexo.setSelectedIndex(18);
				}
			});
			chckbxAgregar.setBounds(571, 327, 97, 23);
		}
		return chckbxAgregar;
	}
	private JCheckBox getChckbxEditar() {
		if (chckbxEditar == null) {
			chckbxEditar = new JCheckBox("Editar");
			chckbxEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					chckbxAgregar.setSelected(false);
					chckbxEliminar.setSelected(false);
					
					textFieldNombreUsuario.setEnabled(true);
					spinner.setEnabled(true);
					comboBox_Sexo.setEnabled(true);
					
					textFieldNombreUsuario.setText(list.getSelectedValue().getNombreCompleto());
					spinner.setValue(list.getSelectedValue().getEdad());
					comboBox_Sexo.setSelectedItem(list.getSelectedValue().getSexo());
				}
			});
			chckbxEditar.setBounds(700, 327, 97, 23);
		}
		return chckbxEditar;
	}
	private JCheckBox getChckbxEliminar() {
		if (chckbxEliminar == null) {
			chckbxEliminar = new JCheckBox("Eliminar");
			chckbxEliminar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					chckbxAgregar.setSelected(false);
					chckbxEditar.setSelected(false);
					textFieldNombreUsuario.setText(list.getSelectedValue().getNombreCompleto());
					spinner.setValue(list.getSelectedValue().getEdad());
					comboBox_Sexo.setSelectedItem(list.getSelectedValue().getSexo());
				}
			});
			chckbxEliminar.setBounds(637, 372, 97, 23);
		}
		return chckbxEliminar;
	}
	
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(chckbxAgregar.isSelected()){
						registrarUsuario();
						modelo.setListaUsuarios(Biblioteca.getInstancia().getUsuarios());
					}
					else if(chckbxEditar.isSelected()){
						
					}
				}
			});
			btnConfirmar.setBounds(571, 428, 89, 32);
		}
		return btnConfirmar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(700, 428, 89, 32);
		}
		return btnCancelar;
	}
	
	public void registrarUsuario(){
		
		String nombre = textFieldNombreUsuario.getText();
		int edad = (Integer) spinner.getValue();
		String sexo = comboBox_Sexo.getSelectedItem().toString();
		idUsuario++;
		String id = "" + idUsuario;

		if(nombre.isEmpty())
			JOptionPane.showMessageDialog(null, "Error. Nombre vacío.");
		else if (edad < 18|| edad > 110){
			if(edad < 18)
				JOptionPane.showMessageDialog(null, "Lectores menores de edad no pueden registrarse.");
			else
				JOptionPane.showMessageDialog(null, "Edad no admitida.");
		}
		else{
			JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
			Biblioteca.getInstancia().crearUsuarioAcreditado(id, nombre, edad, sexo);
			modelo.setListaUsuarios(Biblioteca.getInstancia().getUsuarios());
		}
	}
}
