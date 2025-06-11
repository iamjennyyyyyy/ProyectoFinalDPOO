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

public class GestionUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JList<UsuarioAcreditado> list = new JList<UsuarioAcreditado>();
	private ModelUsuario modelo = new ModelUsuario();
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTextField textFieldNombreUsuario;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JTextField textFieldId;
	private JLabel lblCi;
	private int idUsuario = 15;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private boolean agregar = false;
	private boolean eliminar = false;
	private boolean editar = false;
	private JButton btnGuardar;
	private JTextField textFieldEdad;
	private JTextField textFieldSexo;
	private JLabel label;
	private JTextPane txtpnOperacion;

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
		contentPanel.add(getTxtpnOperacion());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getTextFieldNombreUsuario());
		contentPanel.add(getLblNombre());
		contentPanel.add(getLblEdad());
		contentPanel.add(getLblSexo());
		contentPanel.add(getBtnConfirmar());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getTextFieldId());
		contentPanel.add(getLblCi());
		contentPanel.add(getBtnAgregar());
		contentPanel.add(getBtnEditar());
		contentPanel.add(getBtnEliminar());
		contentPanel.add(getBtnGuardar());
		contentPanel.add(getTextFieldEdad());
		contentPanel.add(getTextFieldSexo());
		contentPanel.add(getLabel());
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

	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setVisible(false);
			btnConfirmar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(agregar){
						boolean agregado = registrarUsuario();

						while(!agregado){
							agregado = registrarUsuario();
						}
						
						JOptionPane.showMessageDialog(null, "Usuario ha sido registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnConfirmar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

					}
					else if(eliminar){

						eliminarUsuario();

						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnConfirmar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);
					}
					list.setEnabled(false);
					reiniciarComponentes();
					
					txtpnOperacion.setVisible(false);
					txtpnOperacion.setText("");
				}
			});
			btnConfirmar.setBounds(551, 479, 151, 32);
		}
		return btnConfirmar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.setVisible(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					btnAgregar.setVisible(true);
					btnEditar.setVisible(true);
					btnEliminar.setVisible(true);

					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(false);
					btnGuardar.setVisible(false);

					reiniciarComponentes();

					list.setEnabled(false);
					
					txtpnOperacion.setVisible(false);
					txtpnOperacion.setText("");

				}
			});
			btnCancelar.setToolTipText("Reiniciar formulario");
			btnCancelar.setBorder(null);
			btnCancelar.setIcon(new ImageIcon("src/images/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(725, 481, 30, 30);
		}
		return btnCancelar;
	}

	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Nuevo");
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					reiniciarComponentes();
					
					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					//Activar confirmacion
					btnConfirmar.setVisible(true);
					btnCancelar.setVisible(true);

					//Activar booleano
					agregar = true;

					//Desactivar lista
					list.setEnabled(false);
					
					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Agregar");
				}
			});
			btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnAgregar.setBounds(505, 460, 92, 32);
		}
		return btnAgregar;
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					//Activar confirmacion
					btnGuardar.setVisible(true);
					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(true);

					//Activar booleano
					editar = true;

					//Activar lista
					list.setEnabled(true);
					
					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Editar");
				}
			});
			btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnEditar.setBounds(610, 460, 92, 32);
		}
		return btnEditar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					//Activar confirmacion
					btnConfirmar.setVisible(true);
					btnCancelar.setVisible(true);

					//Activar booleano
					eliminar = true;

					//Activar lista
					list.setEnabled(true);
					
					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Eliminar");
				}
			});
			btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnEliminar.setBounds(715, 460, 92, 32);
		}
		return btnEliminar;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(editar){
						boolean editado = false;

						while(!editado){
							editado = editarUsuario();
						}
						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						//Reiniciar operacion
						editar = false;
						
						txtpnOperacion.setText("");
						txtpnOperacion.setVisible(false);
						
						reiniciarComponentes();
					}
				}
			});
			btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 16));
			btnGuardar.setBounds(551, 479, 151, 32);
			btnGuardar.setVisible(false);
		}
		return btnGuardar;
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
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblNombre.setBounds(525, 140, 114, 27);
		}
		return lblNombre;
	}

	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblEdad.setBounds(525, 335, 54, 27);
		}
		return lblEdad;
	}

	private JLabel getLblCi() {
		if (lblCi == null) {
			lblCi = new JLabel("CI:");
			lblCi.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblCi.setBounds(525, 235, 101, 27);
		}
		return lblCi;
	}

	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblSexo.setBounds(525, 396, 54, 27);
		}
		return lblSexo;
	}

	private JTextField getTextFieldEdad() {
		if (textFieldEdad == null) {
			textFieldEdad = new JTextField();
			textFieldEdad.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldEdad.setBounds(602, 338, 30, 24);
			textFieldEdad.setColumns(10);
			//			textFieldEdad.setEditable(false);
			textFieldEdad.setText("18");

		}
		return textFieldEdad;
	}
	private JTextField getTextFieldSexo() {
		if (textFieldSexo == null) {
			textFieldSexo = new JTextField();
			textFieldSexo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldSexo.setColumns(10);
			textFieldSexo.setBounds(602, 399, 30, 24);
			//			textFieldSexo.setEditable(false);
			textFieldSexo.setText("M");
		}
		return textFieldSexo;
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
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int indice = list.getSelectedIndex();

					if (indice > -1) {
						UsuarioAcreditado u = modelo.getUsuarioAt(indice);

						textFieldNombreUsuario.setText(u.getNombreCompleto());
						textFieldEdad.setText("" + u.getEdad());
						textFieldSexo.setText(u.getSexo());
						textFieldId.setText(u.getId());
					}
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
			textFieldNombreUsuario.setBounds(525, 178, 203, 30);
			textFieldNombreUsuario.setColumns(10);
			textFieldNombreUsuario.putClientProperty("JTextField.placeholderText", "Ingrese su nombre de usuario");
		}
		return textFieldNombreUsuario;
	}

	private JTextField getTextFieldId() {
		if (textFieldId == null) {
			textFieldId = new JTextField();
			textFieldId.setColumns(10);
			textFieldId.setBounds(525, 273, 203, 30);
			textFieldId.putClientProperty("JTextField.placeholderText", "Ingrese su carnet");
		}
		return textFieldId;
	}

	//METODOS CRUD
	public boolean registrarUsuario() {

		boolean agregado = false;

		String nombre = textFieldNombreUsuario.getText();
		int edad = Integer.parseInt(textFieldEdad.getText());
		String sexo = textFieldSexo.getText();
		String iddUsuario = "" + idUsuario;

		if (nombre.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Introduzca el nombre", "Error", JOptionPane.ERROR_MESSAGE);		}
		if (edad < 18 || edad > 110) {
			if(edad < 18)
				JOptionPane.showMessageDialog(null, "Lectores menores de edad no pueden registrarse", "Error", JOptionPane.ERROR_MESSAGE);			
			else if(edad > 110)
				JOptionPane.showMessageDialog(null, "Edad no admitida", "Error", JOptionPane.ERROR_MESSAGE);
		}

		list.clearSelection();
		UsuarioAcreditado u = Biblioteca.getInstancia().crearUsuarioAcreditado(iddUsuario, nombre, edad, sexo);
		if(u != null){
			modelo.addUsuario(u);
			agregado = true;
		}

		return agregado;
	}

	public boolean editarUsuario() {

		boolean editado = false;

		if (list.isSelectionEmpty()) {
			JOptionPane.showMessageDialog(null, "Seleccione un usuario a modificar", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{

			int indice = list.getSelectedIndex();
			UsuarioAcreditado u = list.getSelectedValue();

			if (textFieldNombreUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Introduzca un nombre", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if(textFieldId.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Introduzca un carnet", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				u.setNombreCompleto(textFieldNombreUsuario.getText());
				u.setEdad(Integer.parseInt(textFieldEdad.getText()));
				u.setSexo(textFieldSexo.getText());
				u.setId(textFieldId.getText());

				modelo.updateUsuario(indice, u);
				JOptionPane.showMessageDialog(null, "Usuario modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				editado = true;
			}
		}
		return editado;
	}

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
		
		textFieldNombreUsuario.setText("");
		textFieldId.setText("");
		textFieldEdad.setText("18");
		textFieldSexo.setText("M");
		
		agregar = false;
		editar = false;
		eliminar = false;
		
	}
	
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(479, 100, 336, 451);
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		return label;
	}
	private JTextPane getTxtpnOperacion() {
		if (txtpnOperacion == null) {
			txtpnOperacion = new JTextPane();
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setFont(new Font("SansSerif", Font.PLAIN, 18));
//			txtpnOperacion.setEditable(false);
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setEnabled(false);
			txtpnOperacion.setBackground(Color.WHITE);
			txtpnOperacion.setVisible(false);
			txtpnOperacion.setBounds(505, 85, 85, 32);
		}
		return txtpnOperacion;
	}
}
