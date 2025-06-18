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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.Component;

import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.Period;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

import com.toedter.calendar.JTextFieldDateEditor;

import Utiles.JTextFieldMejorado;
import Utiles.JTextFieldCarnet;
import javax.swing.JSeparator;
import java.awt.SystemColor;

public class GestionUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JList<UsuarioAcreditado> list = new JList<UsuarioAcreditado>();
	private ModelUsuario modelo = new ModelUsuario();
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNombre;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JLabel lblCi;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	private JLabel label;
	private JTextPane txtpnOperacion;
	private JTextFieldMejorado textFieldNombreUsuario;
	private JTextFieldCarnet textFieldId;
	private JTextPane textPaneError;
	private JSeparator separator;
	private JSeparator separator_1;

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
		contentPanel.add(getTextPaneError());
		contentPanel.add(getTxtpnOperacion());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getLblNombre());
		contentPanel.add(getLblEdad());
		contentPanel.add(getLblSexo());
		contentPanel.add(getBtnConfirmar());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getLblCi());
		contentPanel.add(getBtnAgregar());
		contentPanel.add(getBtnEditar());
		contentPanel.add(getBtnEliminar());
		contentPanel.add(getBtnGuardar());
		contentPanel.add(getTextFieldNombreUsuario());
		contentPanel.add(getTextFieldId());
		contentPanel.add(getSeparator());
		contentPanel.add(getSeparator_1());
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

					UsuarioAcreditado u = agregarUsuario();

					if(u != null){
						list.clearSelection();
						modelo.addUsuario(u);
						JOptionPane.showMessageDialog(null, "Usuario registrado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);

						btnGuardar.setVisible(false);
						btnConfirmar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						textFieldNombreUsuario.setEnabled(false);
						textFieldId.setEnabled(false);
						list.setEnabled(true);
						reiniciarComponentes();

						txtpnOperacion.setVisible(false);
						txtpnOperacion.setText("");

						lblSexo.setText("Sexo: ");
						lblEdad.setText("Edad: ");

						reiniciarComponentes();
						lblNombre.setForeground(Color.BLACK);
						lblCi.setForeground(Color.BLACK);

						textFieldNombreUsuario.setEnabled(false);
						textFieldId.setEnabled(false);
					}
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

					list.setEnabled(true);

					txtpnOperacion.setVisible(false);
					txtpnOperacion.setText("");

					textFieldNombreUsuario.setEnabled(false);
					textFieldId.setEnabled(false);

					lblSexo.setText("Sexo: ");
					lblEdad.setText("Edad: ");
					
					lblSexo.setForeground(Color.BLACK);
					lblEdad.setForeground(Color.BLACK);
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

					textFieldNombreUsuario.setEnabled(true);
					textFieldId.setEnabled(true);

					reiniciarComponentes();

					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					//Activar confirmacion
					btnConfirmar.setVisible(true);
					btnCancelar.setVisible(true);

					//Desactivar lista
					list.setEnabled(false);

					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Agregar");

					lblSexo.setText("Sexo: ");
					lblEdad.setText("Edad: ");
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

					textFieldNombreUsuario.setEnabled(true);
					textFieldId.setEnabled(true);

					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Editar");

					list.setEnabled(false);
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
					eliminarUsuario();
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

					UsuarioAcreditado u = editarUsuario();
					int indice = list.getSelectedIndex();
					if(u != null){
						modelo.updateUsuario(indice, u);
						JOptionPane.showMessageDialog(null, "Usuario modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						lblSexo.setText("Sexo: ");
						lblEdad.setText("Edad: ");

						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						txtpnOperacion.setText("");
						txtpnOperacion.setVisible(false);

						reiniciarComponentes();

						textFieldNombreUsuario.setEnabled(false);
						textFieldId.setEnabled(false);
						
						lblSexo.setForeground(Color.BLACK);
						lblEdad.setForeground(Color.BLACK);
						
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
			lblNombre.setBounds(505, 176, 85, 27);
		}
		return lblNombre;
	}

	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblEdad.setBounds(525, 329, 114, 27);
		}
		return lblEdad;
	}

	private JLabel getLblCi() {
		if (lblCi == null) {
			lblCi = new JLabel("CI:");
			lblCi.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblCi.setBounds(551, 254, 40, 27);
		}
		return lblCi;
	}

	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblSexo.setBounds(525, 392, 114, 27);
		}
		return lblSexo;
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
			list.setSelectedIndices(new int[] {1});
			list.setToolTipText("Lista de usuarios actualmente registrados");
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int indice = list.getSelectedIndex();

					if (indice > -1) {

						UsuarioAcreditado u = modelo.getUsuarioAt(indice);

						textFieldNombreUsuario.setText(u.getNombreCompleto());
						lblEdad.setText("Edad: " + u.getEdad());
						lblSexo.setText("Sexo: " + u.getSexo());
						textFieldId.setText(u.getId());
					}
				}
			});
			list.setFont(new Font("SansSerif", Font.PLAIN, 17));
			list.setModel(modelo);
			list.setSelectedIndex(1);
			scrollPane.setViewportView(list);
		}
		return scrollPane;
	}

	public void eliminarUsuario() {

		if(!list.isSelectionEmpty()){

			int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al usuario?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (option == JOptionPane.YES_OPTION) {

				UsuarioAcreditado u = list.getSelectedValue();
				int indice = list.getSelectedIndex();

				Biblioteca.getInstancia().eliminarUsuario(u);
				modelo.removeUsuario(indice);

				JOptionPane.showMessageDialog(null, "Usuario " + u.getNombreCompleto() + " ha sido eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				reiniciarComponentes();
			}
		}
	}

	public void reiniciarComponentes(){

		textFieldNombreUsuario.setText("");
		textFieldId.setText("");	
		lblSexo.setText("Sexo: ");
		lblEdad.setText("Edad: ");
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
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setEnabled(false);
			txtpnOperacion.setBackground(Color.WHITE);
			txtpnOperacion.setVisible(false);
			txtpnOperacion.setBounds(505, 85, 85, 32);
		}
		return txtpnOperacion;
	}
	private JTextFieldMejorado getTextFieldNombreUsuario() {
		if (textFieldNombreUsuario == null) {
			textFieldNombreUsuario = new JTextFieldMejorado();
			textFieldNombreUsuario.setFont(new Font("SansSerif", Font.PLAIN, 14));
			textFieldNombreUsuario.setBorder(null);
			textFieldNombreUsuario.setBounds(600, 173, 193, 30);
			textFieldNombreUsuario.putClientProperty("JTextField.placeholderText", "Ingrese su nombre");
			textFieldNombreUsuario.setEnabled(false);
		}
		return textFieldNombreUsuario;
	}
	private JTextFieldCarnet getTextFieldId() {
		if (textFieldId == null) {
			textFieldId = new JTextFieldCarnet();
			textFieldId.setFont(new Font("SansSerif", Font.PLAIN, 14));
			textFieldId.setBorder(null);
			textFieldId.getDocument().addDocumentListener(new DocumentListener() {
				@Override
				public void insertUpdate(DocumentEvent e) {
					handleTextChange();
				}
				@Override
				public void removeUpdate(DocumentEvent e) {
					handleTextChange();
				}
				@Override
				public void changedUpdate(DocumentEvent e) {
					// Vacío porque no lo uso
				}
				private void handleTextChange() {
					char[] cadena = textFieldId.getText().toCharArray();

					if(textFieldId.getText().length() >= 7){
						LocalDate fecha = obtenerFechaNacimiento(cadena);
						if(fecha != null){
							LocalDate hoy = LocalDate.now();
							int edad = Period.between(fecha, hoy).getYears();
							lblEdad.setText("Edad: " + edad);
							if(edad < 18 || edad > 110)
								lblEdad.setForeground(Color.RED);
							else
								lblEdad.setForeground(Color.BLACK);
							if(textFieldId.getText().length() >= 10){
								boolean esHombre = esHombre(cadena);
								if(esHombre){
									lblSexo.setText("Sexo: M");
								}
								else
									lblSexo.setText("Sexo: F");
							}
						}
					}
					else{
						textPaneError.setVisible(false);
					}
						
				}
			});
			textFieldId.setEnabled(false);
			textFieldId.setBounds(598, 251, 196, 30);
			textFieldId.setLimite(11);
			textFieldId.putClientProperty("JTextField.placeholderText", "Ingrese su carnet");
		}
		return textFieldId;
	}
	private JTextPane getTextPaneError() {
		if (textPaneError == null) {
			textPaneError = new JTextPane();
			textPaneError.setVisible(false);
			textPaneError.setForeground(Color.RED);
			textPaneError.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneError.setText("Datos inv\u00E1lidos");
			textPaneError.setBounds(649, 534, 145, 34);
		}
		return textPaneError;
	}

	//Métodos CRUD
	public UsuarioAcreditado agregarUsuario(){
		boolean agregado = true;

		list.setEnabled(false);
		String nombre = textFieldNombreUsuario.getText();
		String idUsuario = textFieldId.getText();

		UsuarioAcreditado u = new UsuarioAcreditado();

		try{
			lblNombre.setForeground(Color.BLACK);
			u.setNombreCompleto(nombre);
			textPaneError.setVisible(false);
		}catch(IllegalArgumentException e){
			lblNombre.setForeground(Color.RED);
			textPaneError.setVisible(true);
			agregado = false;
			textFieldNombreUsuario.setText("");
		}
		try{
			textPaneError.setVisible(false);
			lblCi.setForeground(Color.BLACK);
			u.setId(idUsuario);
		}catch(IllegalArgumentException e){
			lblCi.setForeground(Color.RED);
			textPaneError.setVisible(true);
			textFieldId.setText("");
			agregado = false;
		}
		if(!agregado){
			u = null;
		}
		return u;
	}
	public UsuarioAcreditado editarUsuario(){

		boolean editado = true;
		UsuarioAcreditado u = list.getSelectedValue();
		list.setEnabled(false);

		String nombre = textFieldNombreUsuario.getText();
		String id = textFieldId.getText();

		try{
			lblNombre.setForeground(Color.BLACK);
			u.setNombreCompleto(nombre);
			textPaneError.setVisible(false);
		}catch(IllegalArgumentException e){
			lblNombre.setForeground(Color.RED);
			textPaneError.setVisible(true);
			editado = false;
			textFieldNombreUsuario.setText("");
		}
		try{
			textPaneError.setVisible(false);
			lblCi.setForeground(Color.BLACK);
			u.setId(id);
		}catch(IllegalArgumentException e){
			lblCi.setForeground(Color.RED);
			textPaneError.setVisible(true);
			textFieldId.setText("");
			editado = false;
		}
		if(!editado){
			u = null;
		}
		return u;
	}

	public LocalDate obtenerFechaNacimiento(char[] cadena){

		boolean esCorrecta = true;
		// Extraer componentes de fecha
		int anio = (cadena[0] - '0') * 10 + (cadena[1] - '0'); 
		int mes = (cadena[2] - '0') * 10 + (cadena[3] - '0');
		int dia = (cadena[4] - '0') * 10 + (cadena[5] - '0');

		// Validar dígito del siglo (7mo dígito)
		int sigloDigito = cadena[6] - '0';
		if (sigloDigito < 0 || sigloDigito > 9) {
			esCorrecta = false;
		}

		// Ajustar año según siglo
		if (sigloDigito == 9) {
			anio += 1800; // Siglo XIX
		} else if (sigloDigito <= 5) {
			anio += 1900; // Siglo XX
		} else {
			anio += 2000; // Siglo XXI
		}

		// Validar rango de fecha (sin try-catch)
		if (mes < 1 || mes > 12) {
			esCorrecta = false;
		}
		if (dia < 1 || dia > 31) {
			esCorrecta = false;
		}
		if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
			esCorrecta = false;
		}
		if (mes == 2) {
			boolean esBisiesto = (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0));
			if (dia > (esBisiesto ? 29 : 28)) {
				esCorrecta = false;
			}
		}
		LocalDate fechaNacimiento = null;

		if(esCorrecta)
			fechaNacimiento = LocalDate.of(anio, mes, dia);

		return fechaNacimiento;
	}

	public boolean esHombre(char[] cadena){

		boolean esHombre = false;

		int digitoSexo = cadena[9] - '0';

		if(digitoSexo % 2 == 0)
			esHombre = true;

		return esHombre;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setForeground(Color.BLACK);
			separator.setBounds(600, 203, 194, 27);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(598, 281, 194, 27);
		}
		return separator_1;
	}
}
