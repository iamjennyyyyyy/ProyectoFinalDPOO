package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import Inicializadora.Inicializar;
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

import Utiles.Colores;
import Utiles.JTextFieldMejorado;
import Utiles.JTextFieldCarnet;
import Utiles.MiPersonalizacion;

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
	private int pos = -1;
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
	private JLabel labelPenalizaciones;

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
					GestionUsuario frame = new GestionUsuario();
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
	public GestionUsuario() {
		setBounds(338, 159, 1026, 562);
		setUndecorated(true);
		setModal(true);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.setBackground(Color.WHITE);
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
		contentPanel.add(getLabelPenalizaciones());
		contentPanel.add(getLabel());
		modelo.setlstUsuarios(Biblioteca.getInstancia().getUsuarios());
		list.setSelectedIndex(0);
	}

	//BOTONES
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setBorder(null);
			btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
			btnSalir.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSalir.setIcon(new ImageIcon("src/images/iconos/otroLogoBorrar50x50.png"));
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setForeground(Color.WHITE);
			btnSalir.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 25));
			btnSalir.setBounds(966, 11, 50, 50);
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
			btnConfirmar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					UsuarioAcreditado u = agregarUsuario();

					if(u != null){
						UsuarioAcreditado user = Biblioteca.getInstancia().buscarUsuarioPorId(u.getId());
						if(user == null){
							list.clearSelection();
							u.inicializarPrestamos();
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

							txtpnOperacion.setVisible(false);
							txtpnOperacion.setText("");

							lblSexo.setText("Sexo: ");
							lblEdad.setText("Edad: ");

							reiniciarComponentes();

							list.setSelectedIndex(modelo.getSize() - 1);

							lblNombre.setForeground(Color.BLACK);
							lblCi.setForeground(Color.BLACK);

							textFieldNombreUsuario.setEnabled(false);
							textFieldId.setEnabled(false);
						}
						else{
							JOptionPane.showMessageDialog(null, "El usuario ya está registrado", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			btnConfirmar.setBackground(Colores.getBeigetabla());
			btnConfirmar.setBounds(700, 439, 151, 32);
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

					list.setEnabled(true);

					txtpnOperacion.setVisible(false);
					txtpnOperacion.setText("");

					textFieldNombreUsuario.setEnabled(false);
					textFieldId.setEnabled(false);

					lblSexo.setForeground(Color.BLACK);
					lblEdad.setForeground(Color.BLACK);
					lblNombre.setForeground(Color.BLACK);
					lblCi.setForeground(Color.BLACK);

					textPaneError.setVisible(false);

					if(btnConfirmar.isVisible()){
						list.setSelectedIndex(0);
						cargarComponentes(0);
					}
					if(btnGuardar.isVisible()){
						list.setSelectedIndex(pos);
						cargarComponentes(pos);
					}

					lblSexo.setForeground(Color.BLACK);
					lblEdad.setForeground(Color.BLACK);
				}
			});
			btnCancelar.setToolTipText("Reiniciar formulario");
			btnCancelar.setBorder(null);
			btnCancelar.setIcon(new ImageIcon("src/images/iconos/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(874, 441, 30, 30);
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

					labelPenalizaciones.setText("Penalización:     - ");

					reiniciarComponentes();

					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);
					btnConfirmar.setVisible(true);
					btnCancelar.setVisible(true);

					list.setEnabled(false);

					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Agregar");

					lblSexo.setText("Sexo: ");
					lblEdad.setText("Edad: ");
				}
			});
			btnAgregar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnAgregar.setBackground(Colores.getBeigetabla());
			btnAgregar.setBounds(633, 420, 92, 32);
		}
		return btnAgregar;
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBackground(Colores.getBeigetabla());
			btnEditar.setVisible(false);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					//Activar confirmacion
					btnGuardar.setVisible(true);
					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(true);

					textFieldNombreUsuario.setEnabled(true);
					textFieldId.setEnabled(false);

					txtpnOperacion.setVisible(true);
					txtpnOperacion.setText("Editar");

					list.setEnabled(false);
				}
			});
			btnEditar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnEditar.setBounds(748, 420, 92, 32);
		}
		return btnEditar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBackground(Colores.getBeigetabla());
			btnEliminar.setVisible(false);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pos = list.getSelectedIndex();
					eliminarUsuario();
				}
			});
			btnEliminar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnEliminar.setBounds(864, 420, 100, 32);
		}
		return btnEliminar;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.setBackground(Colores.getBeigetabla());
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


						list.setSelectedIndex(indice);
						cargarComponentes(indice);

						textFieldNombreUsuario.setEnabled(false);
						textFieldId.setEnabled(false);

						lblSexo.setForeground(Color.BLACK);
						lblEdad.setForeground(Color.BLACK);

						list.setEnabled(true);
					}
				}
			});
			btnGuardar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnGuardar.setBounds(700, 439, 151, 32);
			btnGuardar.setVisible(false);
		}
		return btnGuardar;
	}

	public void cargarComponentes(int p){

		UsuarioAcreditado u = modelo.getUsuarioAt(p);

		textFieldNombreUsuario.setText(u.getNombreCompleto());
		lblEdad.setText("Edad: " + u.getEdad());
		lblSexo.setText("Sexo: " + u.getSexo());
		textFieldId.setText(u.getId());
		if(u.getFechaPenalizacion() == null){
			labelPenalizaciones.setForeground(Color.BLACK);
			labelPenalizaciones.setText("Penalización: No hay");
		}
		else{
			labelPenalizaciones.setForeground(Color.RED);
			labelPenalizaciones.setText("Penalización: " + u.getFechaPenalizacion());
		}
	}

	//OTROS COMPONENTES
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Lista usuarios:");
			lblNewLabel.setBounds(56, 34, 138, 27);
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 19));
		}
		return lblNewLabel;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblNombre.setBounds(612, 115, 85, 27);
		}
		return lblNombre;
	}

	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblEdad.setBounds(633, 231, 114, 27);
		}
		return lblEdad;
	}

	private JLabel getLblCi() {
		if (lblCi == null) {
			lblCi = new JLabel("CI:");
			lblCi.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblCi.setBounds(658, 173, 40, 27);
		}
		return lblCi;
	}

	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblSexo.setBounds(633, 287, 114, 27);
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
			scrollPane.setBounds(56, 71, 486, 442);
			list.setSelectedIndices(new int[] {1});
			list.setToolTipText("Lista de usuarios actualmente registrados");
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int indice = list.getSelectedIndex();

					if (indice > -1) {

						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						UsuarioAcreditado u = modelo.getUsuarioAt(indice);

						textFieldNombreUsuario.setText(u.getNombreCompleto());
						lblEdad.setText("Edad: " + u.getEdad());
						lblSexo.setText("Sexo: " + u.getSexo());
						textFieldId.setText(u.getId());
						if(u.getFechaPenalizacion() == null){
							labelPenalizaciones.setForeground(Color.BLACK);
							labelPenalizaciones.setText("Penalización: No hay");
						}
						else{
							labelPenalizaciones.setForeground(Color.RED);
							labelPenalizaciones.setText("Penalización: " + u.getFechaPenalizacion());
						}
					}
				}
			});
			list.setFont(new Font("SansSerif", Font.PLAIN, 17));
			list.setModel(modelo);
			list.setSelectedIndex(0);
			scrollPane.setViewportView(list);
		}
		return scrollPane;
	}

	public void eliminarUsuario() {

		if(!list.isSelectionEmpty()){

			UsuarioAcreditado u = list.getSelectedValue();

			if(u != null){

				if(Biblioteca.getInstancia().usuarioEliminable(u)){

					if(Biblioteca.getInstancia().getUsuarios().size() != 1){

						int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al usuario?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (option == JOptionPane.YES_OPTION) {

							if(u.getPrestamos().size() == 0){

								modelo.removeUsuario(pos);

								JOptionPane.showMessageDialog(null, "Usuario " + u.getNombreCompleto() + " ha sido eliminado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								if(pos > 0){
									list.setSelectedIndex(pos - 1);
									cargarComponentes(pos - 1);
								}
								else{
									list.setSelectedIndex(pos);
									cargarComponentes(pos);
								}
								pos = -1;
							}
							else
								JOptionPane.showMessageDialog(null, "Usuario " + u.getNombreCompleto() + " tiene actualmente " + u.getPrestamos().size() + " préstamos activos, no puede ser eliminado", "Información", JOptionPane.WARNING_MESSAGE);
						}
					}
					else
						JOptionPane.showMessageDialog(null, "No puede eliminar a todos los usuarios de la biblioteca", "Información", JOptionPane.WARNING_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Usuario " + u.getNombreCompleto() + " tiene un historial de préstamos, no puede ser eliminado", "Información", JOptionPane.WARNING_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "Seleccione un usuario a eliminar", "Información", JOptionPane.WARNING_MESSAGE);
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
			label.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			label.setBounds(597, 71, 394, 442);
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		return label;
	}
	private JTextPane getTxtpnOperacion() {
		if (txtpnOperacion == null) {
			txtpnOperacion = new JTextPane();
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setEnabled(false);
			txtpnOperacion.setBackground(Color.WHITE);
			txtpnOperacion.setVisible(false);
			txtpnOperacion.setBounds(633, 56, 85, 32);
		}
		return txtpnOperacion;
	}
	private JTextFieldMejorado getTextFieldNombreUsuario() {
		if (textFieldNombreUsuario == null) {
			textFieldNombreUsuario = new JTextFieldMejorado();
			textFieldNombreUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldNombreUsuario.setBorder(null);
			textFieldNombreUsuario.setBounds(702, 115, 262, 30);
			textFieldNombreUsuario.putClientProperty("JTextField.placeholderText", "Ingrese su nombre");
			textFieldNombreUsuario.setEnabled(false);
		}
		return textFieldNombreUsuario;
	}
	private JTextFieldCarnet getTextFieldId() {
		if (textFieldId == null) {
			textFieldId = new JTextFieldCarnet();
			textFieldId.setFont(new Font("Sylfaen", Font.PLAIN, 17));
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
			textFieldId.setBounds(700, 173, 264, 30);
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
			textPaneError.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			textPaneError.setText("Datos inv\u00E1lidos");
			textPaneError.setBounds(826, 493, 138, 34);
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
			separator.setBounds(702, 145, 262, 27);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(700, 203, 264, 27);
		}
		return separator_1;
	}
	private JLabel getLabelPenalizaciones() {
		if (labelPenalizaciones == null) {
			labelPenalizaciones = new JLabel("Penalizaci\u00F3n:");
			labelPenalizaciones.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			labelPenalizaciones.setBounds(633, 347, 229, 27);
		}
		return labelPenalizaciones;
	}
}
