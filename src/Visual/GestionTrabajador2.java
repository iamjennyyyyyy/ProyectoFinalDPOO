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
import Logica.Trabajador;
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
import Utiles.ModelTrabajador;

import javax.swing.JSeparator;

import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GestionTrabajador2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JList<Trabajador> list = new JList<Trabajador>();
	private ModelTrabajador modelo = new ModelTrabajador();
	private String[] niveles = {
			"Primaria",
			"Secundaria",
			"Bachillerato",
			"T�cnico Medio",
			"T�cnico Superior",
			"Universitario",
			"Master",
			"Doctorado"
	};
	private String[] cargos = {
			"Bibliotecario Jefe",
			"Auxiliar de Biblioteca",
			"Jefa de Adquisiciones",
			"Catalogador",
			"Asistente de Referencia",
			"Director T�cnico",
			"Archivista",
			"Digitador",
			"Asistente de Circulaci�n",
			"Jefe de Sistemas",
			"Conservadora",
			"Restaurador",
			"Bibliotecaria Infantil",
			"Coordinador de Servicios",
			"Referencista"
	};
	private int pos = -1;
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
	private JLabel lblCargo;
	private JLabel lblNivelEscolar;
	private JComboBox comboBoxCargo;
	private JComboBox comboBoxNivel;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public GestionTrabajador2() {
		setBounds(338, 159, 1026, 562);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		contentPanel.add(getLblCargo());
		contentPanel.add(getLblNivelEscolar());
		contentPanel.add(getComboBoxCargo());
		contentPanel.add(getComboBoxNivel());
		contentPanel.add(getLabel());
		modelo.setlstTrabajadores(Biblioteca.getInstancia().getTrabajadores());
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

					Trabajador t = agregarTrabajador();

					if(t != null){
						Trabajador trab = Biblioteca.getInstancia().buscarTrabajadorPorId(t.getId());
						if(trab == null){
							list.clearSelection();
							modelo.addTrabajador(t);
							JOptionPane.showMessageDialog(null, "Trabajador registrado con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);

							btnGuardar.setVisible(false);
							btnConfirmar.setVisible(false);
							btnCancelar.setVisible(false);

							comboBoxCargo.setEnabled(false);
							comboBoxNivel.setEnabled(false);

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

							list.setSelectedIndex(modelo.getSize() - 1);
						}
						else{
							JOptionPane.showMessageDialog(null, "El trabajador ya est� registrado", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});
			btnConfirmar.setBackground(Colores.getBeigetabla());
			btnConfirmar.setBounds(710, 443, 132, 34);
		}
		return btnConfirmar;
	}

	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnCancelar.setVisible(false);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					btnAgregar.setVisible(true);

					comboBoxCargo.setEnabled(false);
					comboBoxNivel.setEnabled(false);

					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(false);
					btnGuardar.setVisible(false);

					reiniciarComponentes();
					if(btnConfirmar.isVisible()){
						list.setSelectedIndex(0);
						cargarComponentes(0);
					}
					if(btnGuardar.isVisible()){
						list.setSelectedIndex(pos);
						cargarComponentes(pos);
					}

					list.setEnabled(true);

					txtpnOperacion.setVisible(false);
					txtpnOperacion.setText("");

					textFieldNombreUsuario.setEnabled(false);
					textFieldId.setEnabled(false);

					lblSexo.setText("Sexo: ");
					lblEdad.setText("Edad: ");

					lblSexo.setForeground(Color.BLACK);
					lblEdad.setForeground(Color.BLACK);
					lblNombre.setForeground(Color.BLACK);
					lblCi.setForeground(Color.BLACK);

					textPaneError.setVisible(false);

					lblSexo.setForeground(Color.BLACK);
					lblEdad.setForeground(Color.BLACK);
				}
			});
			btnCancelar.setToolTipText("Reiniciar formulario");
			btnCancelar.setBorder(null);
			btnCancelar.setIcon(new ImageIcon("src/images/iconos/reiniciar30x30.png"));
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBounds(860, 447, 30, 30);
		}
		return btnCancelar;
	}

	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Nuevo");
			btnAgregar.setBackground(Colores.getBeigetabla());
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					textFieldNombreUsuario.setEnabled(true);
					textFieldId.setEnabled(true);

					comboBoxCargo.setEnabled(true);
					comboBoxNivel.setEnabled(true);

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
			btnAgregar.setBounds(614, 425, 106, 34);
		}
		return btnAgregar;
	}
	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setVisible(false);
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					comboBoxCargo.setEnabled(true);
					comboBoxNivel.setEnabled(true);

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
			btnEditar.setBackground(Colores.getBeigetabla());
			btnEditar.setBounds(736, 425, 106, 34);
		}
		return btnEditar;
	}
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setVisible(false);
			btnEliminar.setBackground(Colores.getBeigetabla());
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					pos = list.getSelectedIndex();
					eliminarTrabajador();
				}
			});
			btnEliminar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnEliminar.setBounds(860, 426, 106, 34);
		}
		return btnEliminar;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.setBackground(Colores.getBeigetabla());
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					Trabajador t = editarTrabajador();
					int indice = list.getSelectedIndex();
					if(t != null){
						modelo.updateTrabajador(indice, t);
						JOptionPane.showMessageDialog(null, "Trabajador modificado con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
						lblSexo.setText("Sexo: ");
						lblEdad.setText("Edad: ");

						comboBoxCargo.setEnabled(false);
						comboBoxNivel.setEnabled(false);

						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);

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
			btnGuardar.setBounds(710, 444, 132, 32);
			btnGuardar.setVisible(false);
		}
		return btnGuardar;
	}

	public void cargarComponentes(int p){

		Trabajador u = modelo.getTrabajadorAt(p);

		textFieldNombreUsuario.setText(u.getNombreCompleto());
		lblEdad.setText("Edad: " + u.getEdad());
		lblSexo.setText("Sexo: " + u.getSexo());
		textFieldId.setText(u.getId());
		int posNivel = -1;
		for(int i = 0; i < niveles.length && posNivel == -1; i++){
			if(u.getNivelEscolar().equals(niveles[i])){
				posNivel = i;
			}
		}
		comboBoxNivel.setSelectedIndex(pos);

		int posCargo = -1;
		for(int i = 0; i < cargos.length && posCargo == -1; i++){
			if(u.getCargo().equals(cargos[i]))
				posCargo = i;
		}
		comboBoxCargo.setSelectedIndex(posCargo);
	}

	//OTROS COMPONENTES
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Lista trabajadores:");
			lblNewLabel.setBounds(58, 34, 166, 27);
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		}
		return lblNewLabel;
	}

	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Nombre:");
			lblNombre.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			lblNombre.setBounds(600, 115, 85, 27);
		}
		return lblNombre;
	}

	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			lblEdad.setBounds(625, 235, 114, 27);
		}
		return lblEdad;
	}

	private JLabel getLblCi() {
		if (lblCi == null) {
			lblCi = new JLabel("CI:");
			lblCi.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			lblCi.setBounds(646, 170, 40, 27);
		}
		return lblCi;
	}

	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			lblSexo.setBounds(808, 235, 114, 27);
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
			scrollPane.setBounds(58, 71, 460, 442);
			list.setToolTipText("Lista de trabajadores actualmente registrados");
			list.setBorder(new LineBorder(new Color(0, 0, 0)));
			list.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int indice = list.getSelectedIndex();

					if (indice > -1) {

						Trabajador t = modelo.getTrabajadorAt(indice);

						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						textFieldNombreUsuario.setText(t.getNombreCompleto());
						lblEdad.setText("Edad: " + t.getEdad());
						lblSexo.setText("Sexo: " + t.getSexo());
						textFieldId.setText(t.getId());
						int pos = -1;
						for(int i = 0; i < niveles.length; i++){
							if(t.getNivelEscolar().equals(niveles[i])){
								pos = i;
							}
						}
						comboBoxNivel.setSelectedIndex(pos);

						int pos2 = -1;
						for(int i = 0; i < cargos.length; i++){
							if(t.getCargo().equals(cargos[i]))
								pos2 = i;
						}
						comboBoxCargo.setSelectedIndex(pos2);
					}
				}
			});
			list.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			list.setModel(modelo);
			list.setSelectedIndex(0);
			scrollPane.setViewportView(list);
		}
		return scrollPane;
	}

	public void eliminarTrabajador() {

		if(!list.isSelectionEmpty()){

			Trabajador t = list.getSelectedValue();

			if(t != null){

				if(Biblioteca.getInstancia().trabajadorEliminable(t)){

					if(Biblioteca.getInstancia().getTrabajadores().size() != 1){

						int option = JOptionPane.showConfirmDialog(null, "�Est� seguro que desea eliminar al trabajador?", "Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (option == JOptionPane.YES_OPTION) {
							modelo.removeTrabajador(pos);

							JOptionPane.showMessageDialog(null, "Trabajador " + t.getNombreCompleto() + " ha sido eliminado con �xito", "�xito", JOptionPane.INFORMATION_MESSAGE);
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
					}
					else
						JOptionPane.showMessageDialog(null, "No puede eliminar a todos los trabajadores de la biblioteca", "Informaci�n", JOptionPane.WARNING_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Trabajador " + t.getNombreCompleto() + " tiene un historial de pr�stamos, no puede ser eliminado", "Informaci�n", JOptionPane.WARNING_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(null, "Seleccione un trabajador a eliminar", "Informaci�n", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	public void reiniciarComponentes(){

		textFieldNombreUsuario.setText("");
		textFieldId.setText("");	
		lblSexo.setText("Sexo: ");
		lblEdad.setText("Edad: ");
		comboBoxCargo.setSelectedIndex(0);
		comboBoxNivel.setSelectedIndex(0);
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(584, 71, 407, 431);
			label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		}
		return label;
	}
	private JTextPane getTxtpnOperacion() {
		if (txtpnOperacion == null) {
			txtpnOperacion = new JTextPane();
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			txtpnOperacion.setDisabledTextColor(Color.BLACK);
			txtpnOperacion.setEnabled(false);
			txtpnOperacion.setBackground(Color.WHITE);
			txtpnOperacion.setVisible(false);
			txtpnOperacion.setBounds(600, 34, 85, 32);
		}
		return txtpnOperacion;
	}
	private JTextFieldMejorado getTextFieldNombreUsuario() {
		if (textFieldNombreUsuario == null) {
			textFieldNombreUsuario = new JTextFieldMejorado();
			textFieldNombreUsuario.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldNombreUsuario.setBorder(null);
			textFieldNombreUsuario.setBounds(691, 112, 273, 30);
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
					// Vac�o porque no lo uso
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
			textFieldId.setBounds(689, 167, 275, 30);
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
			textPaneError.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			textPaneError.setText("Datos inv\u00E1lidos");
			textPaneError.setBounds(832, 479, 135, 34);
		}
		return textPaneError;
	}

	//M�todos CRUD
	public Trabajador agregarTrabajador(){
		boolean agregado = true;

		list.setEnabled(false);
		String nombre = textFieldNombreUsuario.getText();
		String idUsuario = textFieldId.getText();

		Trabajador u = new Trabajador();

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

		u.setCargo(comboBoxCargo.getSelectedItem().toString());
		u.setNivelEscolar(comboBoxNivel.getSelectedItem().toString());

		if(!agregado){
			u = null;
		}
		return u;
	}
	public Trabajador editarTrabajador(){

		boolean editado = true;

		Trabajador u = list.getSelectedValue();

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

		u.setCargo(comboBoxCargo.getSelectedItem().toString());
		u.setNivelEscolar(comboBoxNivel.getSelectedItem().toString());

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

		// Validar d�gito del siglo (7mo d�gito)
		int sigloDigito = cadena[6] - '0';
		if (sigloDigito < 0 || sigloDigito > 9) {
			esCorrecta = false;
		}

		// Ajustar a�o seg�n siglo
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
			separator.setBounds(691, 142, 273, 27);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setForeground(Color.BLACK);
			separator_1.setBounds(689, 197, 275, 27);
		}
		return separator_1;
	}
	private JLabel getLblCargo() {
		if (lblCargo == null) {
			lblCargo = new JLabel("Cargo:");
			lblCargo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			lblCargo.setBounds(610, 292, 76, 27);
		}
		return lblCargo;
	}
	private JLabel getLblNivelEscolar() {
		if (lblNivelEscolar == null) {
			lblNivelEscolar = new JLabel("Nivel Escolar:");
			lblNivelEscolar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			lblNivelEscolar.setBounds(610, 355, 124, 27);
		}
		return lblNivelEscolar;
	}
	private JComboBox getComboBoxCargo() {
		if (comboBoxCargo == null) {
			comboBoxCargo = new JComboBox();
			comboBoxCargo.setEnabled(false);
			comboBoxCargo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			comboBoxCargo.setModel(new DefaultComboBoxModel(cargos));
			comboBoxCargo.setSelectedIndex(0);
			comboBoxCargo.setBounds(677, 289, 287, 32);
		}
		return comboBoxCargo;
	}
	private JComboBox getComboBoxNivel() {
		if (comboBoxNivel == null) {
			comboBoxNivel = new JComboBox();
			comboBoxNivel.setEnabled(false);
			comboBoxNivel.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			comboBoxNivel.setModel(new DefaultComboBoxModel(niveles));
			comboBoxNivel.setSelectedIndex(0);
			comboBoxNivel.setBounds(736, 354, 228, 32);
		}
		return comboBoxNivel;
	}
}
