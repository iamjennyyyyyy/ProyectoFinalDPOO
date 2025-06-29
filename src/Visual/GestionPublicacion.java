package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Inicializadora.Inicializar;
import Logica.Articulo;
import Logica.Biblioteca;
import Logica.Libro;
import Logica.Publicacion;
import Logica.Revista;
import Logica.UsuarioAcreditado;
import Utiles.Colores;
import Utiles.MiPersonalizacion;
import Utiles.ModelArticulo;
import Utiles.ModelLibro;
import Utiles.ModelPublicacion;
import Utiles.ModelRevista;
import Utiles.ModelUsuario;
import Utiles.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTabbedPane;

import Utiles.JTextFieldMejorado;

import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.SwingConstants;

import Utiles.JTextFieldCarnet;

import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JSpinner;

import java.awt.CardLayout;

import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;

public class GestionPublicacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JList<Publicacion> listPub = new JList<Publicacion>();
	private ModelPublicacion modelo = new ModelPublicacion();
	private ModelLibro modeloL = new ModelLibro();
	private ModelRevista modeloR = new ModelRevista();
	private ModelArticulo modeloA = new ModelArticulo();
	private String[] materias = new String[] {"Actualidad", "Ciencias Exactas", "Ciencias Naturales", "Ciencias Sociales", "Divulgaci\u00F3n Cient\u00EDfica", "Econom\u00EDa", "Historia", "Literatura", "Literatura Fant\u00E1stica", "Tecnolog\u00EDa"};
	private JButton btnSalir;
	private JTabbedPane tabbedPane;
	private ButtonGroup rdbtns;
	private JPanel panel;
	private JPanel panelRevista;
	private JPanel panelArticulo;
	private JScrollPane scrollPane;
	private JTextField textFieldTitulo;
	private JTextFieldCarnet textFieldCarnet;
	private JComboBox comboBoxMateria;
	private JLabel lblNumPag;
	private JLabel lblEjemplares;
	private JLabel labelMateria;
	private JLabel lblIdentificador;
	private JLabel labelTitulo;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	private JButton btnGuardar;
	private JSpinner spinnerPag;
	private JSpinner spinnerEjemp;
	private JPanel panelLibro;
	private JTextField textFieldAutor;
	private JTextField textFieldEditorial;
	private JLabel lblLibroAutor;
	private JLabel lblEditorial;
	private JLabel labelRevistaAnno;
	private JSpinner spinnerAnno;
	private JLabel lblNmero;
	private JSpinner spinnerNum;
	private JTextField textFieldAutorArt;
	private JLabel labelAutorArticulo;
	private JTextField textFieldArbitro;
	private JLabel labelArbitroArticulo;
	private JRadioButton rdbtnLibros;
	private JRadioButton rdbtnRevistas;
	private JRadioButton rdbtnArticulos;
	private JRadioButton rdbtnTodos;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JTextPane textPaneTipo;
	private JLabel lblNewLabel;
	private JTextPane textPaneError;
	private JTextPane textPaneOperacion;
	private JPanel panelCRUD;
	private JLabel label;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MiPersonalizacion.aplicarTema();
				Inicializar.Inicio();
				GestionPublicacion frame = new GestionPublicacion();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public GestionPublicacion() {

//		setBounds(215, 80, 1149, 639);
		setBounds(338, 159, 1026, 562);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTextPaneError());
		contentPanel.add(getBtnSalir());
		contentPanel.add(getScrollPane());
		contentPanel.add(getRdbtnLibros());
		contentPanel.add(getRdbtnRevistas());
		contentPanel.add(getRdbtnArticulos());
		contentPanel.add(getRdbtnTodos());
		rdbtns = new ButtonGroup();
		rdbtns.add(getRdbtnArticulos());
		rdbtns.add(getRdbtnLibros());
		rdbtns.add(getRdbtnRevistas());
		rdbtns.add(getRdbtnTodos());
		contentPanel.add(getPanelCRUD());
		contentPanel.add(getTextPaneTipo());
		contentPanel.add(getTextPane_1());
		modelo.setlstPub(Biblioteca.getInstancia().getPublicaciones());
		modeloL.setlstLibro(Biblioteca.getInstancia().obtenerLibros());
		modeloR.setlstRevista(Biblioteca.getInstancia().obtenerRevistas());
		modeloA.setlstArticulo(Biblioteca.getInstancia().obtenerArticulos());
	}

	//Componentes
	private JList getList() {
		if (listPub == null) {
			listPub = new JList();
			listPub.setBounds(89, 87, 478, 451);
			listPub.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return listPub;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(47, 59, 443, 453);
			listPub.setToolTipText("Lista de publicaciones actualmente registradas");
			listPub.setBorder(new LineBorder(new Color(0, 0, 0)));
			listPub.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			listPub.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			listPub.setBackground(Colores.getFondo());
			listPub.setModel(modelo);
			listPub.setSelectedIndex(0);
			listPub.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int indice = listPub.getSelectedIndex();
					int pos = -1;
					if (indice > -1) {
						if(!btnConfirmar.isVisible() && !btnGuardar.isVisible()){

							Publicacion p = listPub.getSelectedValue();

							textPaneTipo.setVisible(true);

							if(p instanceof Libro){

								textPaneTipo.setText("Libro");

								panelLibro.setVisible(true);
								panelRevista.setVisible(false);
								panelArticulo.setVisible(false);

								Libro l = null;
								if(rdbtnLibros.isSelected())
									l = modeloL.getLibroAt(indice);
								else if(rdbtnTodos.isSelected()){
									l = (Libro) modelo.getPubAt(indice);
								}

								textFieldTitulo.setText(l.getTitulo());
								textFieldCarnet.setText(l.getId());
								spinnerPag.setValue(l.getNumPaginas());
								spinnerEjemp.setValue(l.getCantEjemplares());
								for(int i = 0; i < materias.length; i++){
									if(l.getMateria().equals(materias[i]))
										pos = i;
								}
								comboBoxMateria.setSelectedIndex(pos);

								panelLibro.setVisible(true);
								panelRevista.setVisible(false);
								panelArticulo.setVisible(false);

								textFieldEditorial.setText(l.getEditorial());
								textFieldAutor.setText(l.getAutores().get(0));
							}
							else if(p instanceof Revista){

								textPaneTipo.setText("Revista");

								panelLibro.setVisible(false);
								panelRevista.setVisible(true);
								panelArticulo.setVisible(false);

								Revista r = null; 
								if(rdbtnRevistas.isSelected())
									r = modeloR.getRevistaAt(indice);
								else if(rdbtnTodos.isSelected()){
									r = (Revista) modelo.getPubAt(indice);
								}
								textFieldTitulo.setText(r.getTitulo());
								textFieldCarnet.setText(r.getId());
								spinnerPag.setValue(r.getNumPaginas());
								spinnerEjemp.setValue(r.getCantEjemplares());
								for(int i = 0; i < materias.length; i++){
									if(r.getMateria().equals(materias[i]))
										pos = i;
								}
								comboBoxMateria.setSelectedIndex(pos);
								panelLibro.setVisible(false);
								panelRevista.setVisible(true);
								panelArticulo.setVisible(false);
								spinnerAnno.setValue(r.getAnno());
								spinnerNum.setValue(r.getNum());
							}
							else if(p instanceof Articulo){

								textPaneTipo.setText("Artículo");

								panelLibro.setVisible(false);
								panelRevista.setVisible(false);
								panelArticulo.setVisible(true);

								Articulo a = null;

								if(rdbtnArticulos.isSelected()){
									a = modeloA.getArticuloAt(indice);
								}
								if(rdbtnTodos.isSelected()){
									a = (Articulo) modelo.getPubAt(indice);
								}
								modeloA.getArticuloAt(indice);
								textFieldTitulo.setText(a.getTitulo());
								textFieldCarnet.setText(a.getId());
								spinnerPag.setValue(a.getNumPaginas());
								spinnerEjemp.setValue(a.getCantEjemplares());
								for(int i = 0; i < materias.length; i++){
									if(a.getMateria().equals(materias[i]))
										pos = i;
								}
								comboBoxMateria.setSelectedIndex(pos);
								panelLibro.setVisible(false);
								panelRevista.setVisible(false);
								panelArticulo.setVisible(true);
								textFieldAutorArt.setText(a.getAutores().get(0));
								textFieldArbitro.setText(a.getArbitros().get(0));
							}

							btnEditar.setVisible(true);
							btnEliminar.setVisible(true);
						}
					}
				}
			});
			scrollPane.setViewportView(listPub);
		}
		return scrollPane;
	}

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
			btnSalir.setBounds(978, 11, 38, 38);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(11, 241, 422, 136);
			panel.setBackground(Colores.getFondo());
			panel.setLayout(new CardLayout(0, 0));
			panel.add(getPanelRevista(), "name_3150780082776200");
			panel.add(getPanelArticulo(), "name_3150780096820200");
			panel.add(getPanelLibro(), "name_3150802498080200");
		}
		return panel;
	}
	private JPanel getPanelRevista() {
		if (panelRevista == null) {
			panelRevista = new JPanel();
			panelRevista.setVisible(false);
			panelRevista.setBackground(Colores.getFondo());
			panelRevista.setLayout(null);
			panelRevista.add(getLabelRevistaAnno());
			panelRevista.add(getSpinnerAnno());
			panelRevista.add(getLblNmero());
			panelRevista.add(getSpinnerNum());
		}
		return panelRevista;
	}
	private JPanel getPanelArticulo() {
		if (panelArticulo == null) {
			panelArticulo = new JPanel();
			panelArticulo.setVisible(false);
			panelArticulo.setBackground(Colores.getFondo());
			panelArticulo.setLayout(null);
			panelArticulo.add(getTextFieldAutorArt());
			panelArticulo.add(getLabelAutorArticulo());
			panelArticulo.add(getTextFieldArbitro());
			panelArticulo.add(getLabelArbitroArticulo());
			panelArticulo.add(getSeparator_2());
			panelArticulo.add(getSeparator_3());
		}
		return panelArticulo;
	}
	private JTextField getTextFieldTitulo() {
		if (textFieldTitulo == null) {
			textFieldTitulo = new JTextField();
			textFieldTitulo.setBackground(Colores.getFondo());
			textFieldTitulo.setBorder(null);
			textFieldTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldTitulo.setBounds(104, 23, 307, 35);
			textFieldTitulo.setEnabled(false);
			textFieldTitulo.setColumns(10);
			textFieldTitulo.putClientProperty("JTextField.placeholderText", "Ingrese el titulo");
		}
		return textFieldTitulo;
	}
	private JComboBox getComboBoxMateria() {
		if (comboBoxMateria == null) {
			comboBoxMateria = new JComboBox();
			comboBoxMateria.setBounds(104, 142, 307, 35);
			comboBoxMateria.setEnabled(false);
			comboBoxMateria.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			comboBoxMateria.setModel(new DefaultComboBoxModel(materias));
		}
		return comboBoxMateria;
	}
	private JLabel getLblNumPag() {
		if (lblNumPag == null) {
			lblNumPag = new JLabel("P\u00E1ginas:");
			lblNumPag.setBounds(256, 197, 91, 28);
			lblNumPag.setFont(new Font("Sylfaen", Font.PLAIN, 19));
		}
		return lblNumPag;
	}
	private JLabel getLblEjemplares() {
		if (lblEjemplares == null) {
			lblEjemplares = new JLabel("Ejemplares:");
			lblEjemplares.setBounds(43, 197, 94, 28);
			lblEjemplares.setFont(new Font("Sylfaen", Font.PLAIN, 19));
		}
		return lblEjemplares;
	}
	private JLabel getLabelMateria() {
		if (labelMateria == null) {
			labelMateria = new JLabel("Materia:");
			labelMateria.setBounds(11, 147, 83, 24);
			labelMateria.setHorizontalAlignment(SwingConstants.TRAILING);
			labelMateria.setFont(new Font("Sylfaen", Font.PLAIN, 19));
		}
		return labelMateria;
	}
	private JLabel getLblIdentificador() {
		if (lblIdentificador == null) {
			lblIdentificador = new JLabel("ID:");
			lblIdentificador.setBounds(10, 82, 84, 35);
			lblIdentificador.setHorizontalAlignment(SwingConstants.TRAILING);
			lblIdentificador.setFont(new Font("Sylfaen", Font.PLAIN, 19));
		}
		return lblIdentificador;
	}
	private JLabel getLabelTitulo() {
		if (labelTitulo == null) {
			labelTitulo = new JLabel("T\u00EDtulo:");
			labelTitulo.setBounds(11, 32, 83, 27);
			labelTitulo.setHorizontalAlignment(SwingConstants.TRAILING);
			labelTitulo.setFont(new Font("Sylfaen", Font.PLAIN, 19));
		}
		return labelTitulo;
	}
	private JTextFieldCarnet getTextFieldCarnet() {
		if (textFieldCarnet == null) {
			textFieldCarnet = new JTextFieldCarnet();
			textFieldCarnet.setBackground(Colores.getFondo());
			textFieldCarnet.setBorder(null);
			textFieldCarnet.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldCarnet.putClientProperty("JTextField.placeholderText", "Ingrese el identificador");
			textFieldCarnet.setBounds(105, 81, 306, 35);
			textFieldCarnet.setEnabled(false);
		}
		return textFieldCarnet;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(42, 383, 105, 35);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					if(!rdbtnTodos.isSelected()){

						reiniciarComponentes();

						textFieldCarnet.setEnabled(true);

						rdbtnLibros.setEnabled(false);
						rdbtnRevistas.setEnabled(false);
						rdbtnArticulos.setEnabled(false);

						textFieldTitulo.setEnabled(true);
						textFieldCarnet.setEnabled(true);
						spinnerPag.setEnabled(true);
						spinnerEjemp.setEnabled(true);
						comboBoxMateria.setEnabled(true);

						textPaneTipo.setVisible(true);

						textPaneOperacion.setVisible(true);
						textPaneOperacion.setText(" -     Agregar");

						//Articulo
						if(panelArticulo.isVisible()){
							textFieldAutorArt.setEnabled(true);
							textFieldArbitro.setEnabled(true);
							textPaneTipo.setText("Artículo");
						}

						//Revista
						else if(panelRevista.isVisible()){
							spinnerAnno.setEnabled(true);
							spinnerNum.setEnabled(true);
							textPaneTipo.setText("Revista");
						}

						//Libro
						else if(panelLibro.isVisible()){
							textFieldAutor.setEnabled(true);
							textFieldEditorial.setEnabled(true);
							textPaneTipo.setText("Libro");
						}

						//Desactivar CRUD
						btnAgregar.setVisible(false);
						btnEditar.setVisible(false);
						btnEliminar.setVisible(false);

						//Activar confirmacion
						btnConfirmar.setVisible(true);
						btnCancelar.setVisible(true);

						//Desactivar lista
						listPub.setEnabled(false);
					}
					else{
						JOptionPane.showMessageDialog(null, "Seleccione el tipo de publicación que desea agregar", "Información", JOptionPane.WARNING_MESSAGE);
					}
				}
			});
			btnAgregar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		}
		return btnAgregar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setBounds(172, 383, 105, 35);
			btnEditar.setVisible(false);
			btnEditar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){

					Publicacion p = listPub.getSelectedValue();

					if(!textFieldTitulo.getText().isEmpty()){

						rdbtnLibros.setEnabled(false);
						rdbtnRevistas.setEnabled(false);
						rdbtnArticulos.setEnabled(false);
						rdbtnTodos.setEnabled(false);

						//Desactivar CRUD
						btnAgregar.setVisible(false);
						btnEditar.setVisible(false);
						btnEliminar.setVisible(false);

						textFieldCarnet.setEnabled(false);

						//Activar confirmacion
						btnGuardar.setVisible(true);
						btnConfirmar.setVisible(false);
						btnCancelar.setVisible(true);

						textFieldTitulo.setEnabled(true);
						spinnerPag.setEnabled(true);
						spinnerEjemp.setEnabled(true);
						comboBoxMateria.setEnabled(true);

						listPub.setEnabled(false);

						textPaneOperacion.setVisible(true);
						textPaneOperacion.setText(" -     Editar");

						if(p instanceof Libro){
							textPaneTipo.setText("Libro");
							textFieldAutor.setEnabled(true);
							textFieldEditorial.setEnabled(true);
						}
						else if(p instanceof Revista){
							textPaneTipo.setText("Revista");
							spinnerAnno.setEnabled(true);
							spinnerNum.setEnabled(true);
						}
						else if(p instanceof Articulo){
							textPaneTipo.setText("Artículo");
							textFieldAutorArt.setEnabled(true);
							textFieldArbitro.setEnabled(true);
						}
					}
					else
						JOptionPane.showMessageDialog(null, "Seleccione una publicación a editar", "Información", JOptionPane.WARNING_MESSAGE);
				}
			});
		}
		return btnEditar;
	}

	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.setBounds(305, 383, 105, 35);
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					eliminarPublicacion();
				}
			});
			btnEliminar.setVisible(false);
			btnEliminar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		}
		return btnEliminar;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.setBounds(136, 383, 105, 35);
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					boolean exito = false;

					if(rdbtnLibros.isSelected()){

						Libro l = agregarLibro();
						if(l != null){
							Publicacion m = Biblioteca.getInstancia().buscarPublicacionPorId(l.getId());
							if(m == null){
								modeloL.addLibro(l);
								Biblioteca.getInstancia().agregarLibro(l.getId(), l.getTitulo(), l.getMateria(), l.getNumPaginas(), l.getCantEjemplares(), l.getAutores().get(0), l.getEditorial());
								JOptionPane.showMessageDialog(null, "Libro " + l.getTitulo() + " agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								exito = true;
								textFieldAutor.setEnabled(false);
								textFieldEditorial.setEnabled(false);
							}
							else{
								JOptionPane.showMessageDialog(null, "Ya existe un libro con este identificador", "Información", JOptionPane.WARNING_MESSAGE);
								exito = false;
							}
						}
					}
					if(rdbtnRevistas.isSelected()){
						Revista r = agregarRevista();
						if(r != null){
							Publicacion m = Biblioteca.getInstancia().buscarPublicacionPorId(r.getId());
							if(m == null){
								modeloR.addRevista(r);
								Biblioteca.getInstancia().agregarRevista(r.getId(), r.getTitulo(), r.getMateria(), r.getNumPaginas(), r.getCantEjemplares(), r.getAnno(), r.getNum());
								JOptionPane.showMessageDialog(null, "Revista " + r.getTitulo() + " agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								exito = true;
								spinnerAnno.setEnabled(false);
								spinnerNum.setEnabled(false);
							}
							else{
								JOptionPane.showMessageDialog(null, "Ya existe un libro con este identificador", "Información", JOptionPane.WARNING_MESSAGE);
								exito = false;
							}
						}
					}
					if(rdbtnArticulos.isSelected()){
						Articulo a = agregarArticulo();
						if(a != null){
							Publicacion m = Biblioteca.getInstancia().buscarPublicacionPorId(a.getId());
							if(m == null){
								modeloA.addArticulo(a);
								Biblioteca.getInstancia().agregarArticulo(a.getId(), a.getTitulo(), a.getMateria(), a.getNumPaginas(), a.getCantEjemplares(), a.getAutores().get(0), a.getArbitros().get(0));
								JOptionPane.showMessageDialog(null, "Articulo " + a.getTitulo() + " agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
								exito = true;
								textFieldArbitro.setEnabled(false);
								textFieldAutorArt.setEnabled(false);
							}
							else{
								JOptionPane.showMessageDialog(null, "Ya existe un libro con este identificador", "Información", JOptionPane.WARNING_MESSAGE);
								exito = false;
							}
						}
					}
					if(exito){

						listPub.setSelectedIndex(0);

						textPaneOperacion.setVisible(false);

						rdbtnLibros.setEnabled(true);
						rdbtnRevistas.setEnabled(true);
						rdbtnArticulos.setEnabled(true);

						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnCancelar.setVisible(false);
						btnConfirmar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						reiniciarComponentes();

						textFieldTitulo.setEnabled(false);
						textFieldAutor.setEnabled(false);
						textFieldEditorial.setEnabled(false);
						textFieldCarnet.setEnabled(false);
						spinnerPag.setEnabled(false);
						spinnerEjemp.setEnabled(false);
						comboBoxMateria.setEnabled(false);

						listPub.setEnabled(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "Algo salió mal", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnConfirmar.setVisible(false);
			btnConfirmar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		}
		return btnConfirmar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.setBounds(287, 388, 30, 30);
			btnCancelar.setBackground(Color.WHITE);
			btnCancelar.setBorder(null);
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					reiniciarComponentes();

					listPub.setSelectedIndex(0);

					textPaneOperacion.setVisible(false);

					listPub.setEnabled(true);

					btnAgregar.setVisible(true);
					btnEditar.setVisible(true);
					btnEliminar.setVisible(true);

					textFieldCarnet.setEnabled(false);

					btnCancelar.setVisible(false);
					btnGuardar.setVisible(false);
					btnConfirmar.setVisible(false);

					labelTitulo.setForeground(Color.BLACK);
					lblEjemplares.setForeground(Color.BLACK);
					labelMateria.setForeground(Color.BLACK);
					lblNumPag.setForeground(Color.BLACK);
					lblEditorial.setForeground(Color.BLACK);
					lblLibroAutor.setForeground(Color.BLACK);
					lblNmero.setForeground(Color.BLACK);
					labelRevistaAnno.setForeground(Color.BLACK);
					labelAutorArticulo.setForeground(Color.BLACK);
					labelArbitroArticulo.setForeground(Color.BLACK);

					textPaneError.setVisible(false);

					textFieldTitulo.setEnabled(false);
					textFieldAutor.setEnabled(false);
					textFieldEditorial.setEnabled(false);
					textFieldCarnet.setEnabled(false);
					spinnerPag.setEnabled(false);
					spinnerEjemp.setEnabled(false);
					comboBoxMateria.setEnabled(false);

					rdbtnLibros.setEnabled(true);
					rdbtnRevistas.setEnabled(true);
					rdbtnArticulos.setEnabled(true);
					rdbtnTodos.setEnabled(true);
				}
			});
			btnCancelar.setVisible(false);
			btnCancelar.setIcon(new ImageIcon("src/images/iconos/reiniciar30x30.png"));
			btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		}
		return btnCancelar;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.setBounds(147, 383, 105, 35);
			btnGuardar.setVisible(false);
			btnGuardar.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					boolean exito = false;

					int indice = listPub.getSelectedIndex();
					Publicacion p = listPub.getSelectedValue();
					int indexPub = Biblioteca.getInstancia().buscarPosPublicacion(p);

					if(p instanceof Libro){
						Libro l = editarLibro(indexPub);
						if(l != null){
							modeloL.updateLibro(indice, l);
							modelo.updatePublicacion(indice, l);
							JOptionPane.showMessageDialog(null, "Libro " + l.getTitulo() + " modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
							textFieldAutor.setEnabled(false);
							textFieldEditorial.setEnabled(false);
							textPaneTipo.setBounds(630, 49, 80, 38);
						}
					}
					else if(p instanceof Revista){
						Revista r = editarRevista(indexPub);
						if(r != null){
							modeloR.updateRevista(indice, r);
							modelo.updatePublicacion(indice, r);
							JOptionPane.showMessageDialog(null, "Revista " + r.getTitulo() + " modificada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
							spinnerAnno.setEnabled(false);
							spinnerNum.setEnabled(false);
						}
					}
					else if(p instanceof Articulo){
						Articulo a = editarArticulo(indexPub);
						if(a != null){
							modeloA.updateArticulo(indice, a);
							modelo.updatePublicacion(indice, a);
							JOptionPane.showMessageDialog(null, "Artículo " + a.getTitulo() + " modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
							textFieldArbitro.setEnabled(false);
							textFieldAutorArt.setEnabled(false);
						}
					}

					if(exito){

						textPaneOperacion.setVisible(false);

						listPub.setSelectedIndex(0);

						textFieldCarnet.setEnabled(false);

						rdbtnLibros.setEnabled(true);
						rdbtnRevistas.setEnabled(true);
						rdbtnArticulos.setEnabled(true);
						rdbtnTodos.setEnabled(true);


						//Esconder confirmacion
						btnGuardar.setVisible(false);
						btnCancelar.setVisible(false);

						//Aparecer CRUD
						btnAgregar.setVisible(true);
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);

						reiniciarComponentes();

						textFieldTitulo.setEnabled(false);
						textFieldAutor.setEnabled(false);
						textFieldEditorial.setEnabled(false);
						textFieldCarnet.setEnabled(false);
						spinnerPag.setEnabled(false);
						spinnerEjemp.setEnabled(false);
						comboBoxMateria.setEnabled(false);

						listPub.setEnabled(true);
					}
				}
			});
		}
		return btnGuardar;
	}

	public void reiniciarComponentes(){

		textFieldTitulo.setText("");
		textFieldAutor.setText("");
		textFieldEditorial.setText("");
		textFieldCarnet.setText("");
		spinnerPag.setValue(0);
		spinnerEjemp.setValue(0);
		comboBoxMateria.setSelectedIndex(0);

		if(panelLibro.isVisible()){
			textFieldAutor.setText("");
			textFieldEditorial.setText("");
		}
		else if(panelRevista.isVisible()){
			spinnerAnno.setValue(2010);
			spinnerNum.setValue(0);
		}
		else if(panelArticulo.isVisible()){
			textFieldArbitro.setText("");
			textFieldAutorArt.setText("");
		}
	}

	//METODOS EDITAR
	public Libro editarLibro(int indice){

		boolean editado = true;
		Libro l = (Libro)Biblioteca.getInstancia().getPublicaciones().get(indice);
		listPub.setEnabled(false);

		String titulo = textFieldTitulo.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		String editorial = textFieldEditorial.getText();
		String autor = textFieldAutor.getText();

		try{
			l.setTitulo(titulo);
			textPaneError.setVisible(false);
			labelTitulo.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			textPaneError.setVisible(true);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			l.setCantEjemplares(cantE);
			textPaneError.setVisible(false);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			textPaneError.setVisible(true);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			l.setMateria(materia);
			textPaneError.setVisible(false);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			textPaneError.setVisible(true);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			l.setNumPaginas(numPag);
			textPaneError.setVisible(false);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			textPaneError.setVisible(true);
			spinnerPag.setValue(0);
			editado = false;
		}
		try{
			l.setEditorial(editorial);
			textPaneError.setVisible(false);
			lblEditorial.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEditorial.setForeground(Color.RED);
			textPaneError.setVisible(true);
			editado = false;
			textFieldEditorial.setText("");
		}
		try{
			l.setAutores(autor);
			textPaneError.setVisible(false);
			lblLibroAutor.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblLibroAutor.setForeground(Color.RED);
			textPaneError.setVisible(true);
			textFieldAutor.setText("");
			editado = false;
		}
		if(!editado){
			l = null;
		}
		return l;
	}

	public Revista editarRevista(int indice){

		boolean editado = true;
		Revista r = (Revista)Biblioteca.getInstancia().getPublicaciones().get(indice);
		listPub.setEnabled(false);

		String titulo = textFieldTitulo.getText();
		String id = textFieldCarnet.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		int num = (Integer)spinnerNum.getValue();
		int anno = (Integer)spinnerAnno.getValue();

		try{
			r.setTitulo(titulo);
			textPaneError.setVisible(false);
			labelTitulo.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			textPaneError.setVisible(true);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			r.setId(id);
			textPaneError.setVisible(false);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textPaneError.setVisible(true);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			r.setCantEjemplares(cantE);
			textPaneError.setVisible(false);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			textPaneError.setVisible(true);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			r.setMateria(materia);
			textPaneError.setVisible(false);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			r.setNumPaginas(numPag);
			textPaneError.setVisible(false);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			r.setNum(num);
			textPaneError.setVisible(false);
			lblNmero.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNmero.setForeground(Color.RED);
			editado = false;
			textPaneError.setVisible(true);
			spinnerNum.setValue(0);
		}
		try{
			r.setAnno(anno);
			textPaneError.setVisible(false);
			labelRevistaAnno.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelRevistaAnno.setForeground(Color.RED);
			spinnerAnno.setValue(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		if(!editado){
			r = null;
		}
		return r;
	}

	public Articulo editarArticulo(int indice){

		boolean editado = true;
		Articulo a = (Articulo)Biblioteca.getInstancia().getPublicaciones().get(indice);
		listPub.setEnabled(false);

		String titulo = textFieldTitulo.getText();
		String id = textFieldCarnet.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		String autor = textFieldAutorArt.getText();
		String arbitro = textFieldArbitro.getText();

		try{
			a.setTitulo(titulo);
			textPaneError.setVisible(false);
			labelTitulo.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textPaneError.setVisible(true);
			textFieldTitulo.setText("");
		}
		try{
			a.setId(id);
			textPaneError.setVisible(false);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textFieldCarnet.setText("");
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			a.setCantEjemplares(cantE);
			textPaneError.setVisible(false);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			textPaneError.setVisible(true);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			a.setMateria(materia);
			textPaneError.setVisible(false);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			a.setNumPaginas(numPag);
			textPaneError.setVisible(false);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			a.agregarArbitro(arbitro);
			textPaneError.setVisible(false);
			labelArbitroArticulo.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelArbitroArticulo.setForeground(Color.RED);
			editado = false;
			textPaneError.setVisible(true);
			textFieldArbitro.setText("");
		}
		try{
			a.agregarAutor(autor);
			textPaneError.setVisible(false);
			labelAutorArticulo.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			textPaneError.setVisible(true);
			labelAutorArticulo.setForeground(Color.RED);
			textFieldAutorArt.setText("");
			editado = false;
		}
		if(!editado){
			a = null;
		}
		return a;
	}

	// METODOS AGREGAR
	public Libro agregarLibro(){

		boolean editado = true;
		Libro l = new Libro();
		listPub.setEnabled(false);

		String titulo = textFieldTitulo.getText();
		String id = textFieldCarnet.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		String editorial = textFieldEditorial.getText();
		String autor = textFieldAutor.getText();

		try{
			l.setTitulo(titulo);
			labelTitulo.setForeground(Color.BLACK);
			textPaneError.setVisible(false);
		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			textPaneError.setVisible(true);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			l.setId(id);
			textPaneError.setVisible(false);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textPaneError.setVisible(true);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			l.setCantEjemplares(cantE);
			textPaneError.setVisible(false);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			textPaneError.setVisible(true);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			l.setMateria(materia);
			textPaneError.setVisible(false);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			textPaneError.setVisible(true);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			l.setNumPaginas(numPag);
			textPaneError.setVisible(false);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			l.setEditorial(editorial);
			textPaneError.setVisible(false);
			lblEditorial.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEditorial.setForeground(Color.RED);
			editado = false;
			textPaneError.setVisible(true);
			textFieldEditorial.setText("");
		}
		try{
			l.setAutores(autor);
			textPaneError.setVisible(false);
			lblLibroAutor.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblLibroAutor.setForeground(Color.RED);
			textFieldAutor.setText("");
			textPaneError.setVisible(true);
			editado = false;
		}
		if(!editado){
			l = null;
		}
		return l;
	}

	public Revista agregarRevista(){

		boolean editado = true;
		Revista r = new Revista();
		listPub.setEnabled(false);

		String titulo = textFieldTitulo.getText();
		String id = textFieldCarnet.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		int num = (Integer)spinnerNum.getValue();
		int anno = (Integer)spinnerAnno.getValue();

		try{
			r.setTitulo(titulo);
			textPaneError.setVisible(false);
			labelTitulo.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textPaneError.setVisible(true);
			textFieldTitulo.setText("");
		}
		try{
			r.setId(id);
			textPaneError.setVisible(false);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textPaneError.setVisible(true);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			r.setCantEjemplares(cantE);
			textPaneError.setVisible(false);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			spinnerEjemp.setValue(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			r.setMateria(materia);
			textPaneError.setVisible(false);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			r.setNumPaginas(numPag);
			textPaneError.setVisible(false);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			textPaneError.setVisible(true);
			editado = false;
		}
		try{
			r.setNum(num);
			textPaneError.setVisible(false);
			lblNmero.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNmero.setForeground(Color.RED);
			editado = false;
			textPaneError.setVisible(true);
			spinnerNum.setValue(0);
		}
		try{
			r.setAnno(anno);
			textPaneError.setVisible(false);
			labelRevistaAnno.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelRevistaAnno.setForeground(Color.RED);
			textPaneError.setVisible(true);
			spinnerAnno.setValue(0);
			editado = false;
		}
		if(!editado){
			r = null;
		}
		return r;
	}

	public Articulo agregarArticulo(){

		boolean editado = true;
		Articulo a = new Articulo();
		listPub.setEnabled(false);

		String titulo = textFieldTitulo.getText();
		String id = textFieldCarnet.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		String autor = textFieldAutorArt.getText();
		String arbitro = textFieldArbitro.getText();

		try{
			a.setTitulo(titulo);
			labelTitulo.setForeground(Color.BLACK);
			labelTitulo.repaint();
		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			a.setId(id);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			a.setCantEjemplares(cantE);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			a.setMateria(materia);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			a.setNumPaginas(numPag);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			editado = false;
		}
		try{
			a.agregarArbitro(arbitro);
			labelArbitroArticulo.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelArbitroArticulo.setForeground(Color.RED);
			editado = false;
			textFieldArbitro.setText("");
		}
		try{
			a.agregarAutor(autor);
			labelAutorArticulo.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelAutorArticulo.setForeground(Color.RED);
			textFieldAutorArt.setText("");
			editado = false;
		}
		if(!editado){
			a = null;
		}
		return a;
	}

	private JSpinner getSpinnerPag() {
		if (spinnerPag == null) {
			spinnerPag = new JSpinner();
			spinnerPag.setEnabled(false);
			spinnerPag.setBackground(Color.WHITE);
			spinnerPag.setBounds(335, 198, 76, 32);
			spinnerPag.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		}
		return spinnerPag;
	}
	private JSpinner getSpinnerEjemp() {
		if (spinnerEjemp == null) {
			spinnerEjemp = new JSpinner();
			spinnerEjemp.setBackground(Color.WHITE);
			spinnerEjemp.setEnabled(false);
			spinnerEjemp.setBounds(147, 198, 76, 32);
			spinnerEjemp.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		}
		return spinnerEjemp;
	}
	private JPanel getPanelLibro() {
		if (panelLibro == null) {
			panelLibro = new JPanel();
			panelLibro.setVisible(false);
			panelLibro.setBackground(Colores.getFondo());
			panelLibro.setLayout(null);
			panelLibro.add(getTextFieldAutor());
			panelLibro.add(getTextFieldEditorial());
			panelLibro.add(getLblLibroAutor());
			panelLibro.add(getLblEditorial());
			panelLibro.add(getSeparator_4());
			panelLibro.add(getSeparator_5());
		}
		return panelLibro;
	}
	private JTextField getTextFieldAutor() {
		if (textFieldAutor == null) {
			textFieldAutor = new JTextField();
			textFieldAutor.setBackground(Colores.getFondo());
			textFieldAutor.setBorder(null);
			textFieldAutor.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldAutor.setEnabled(false);
			textFieldAutor.setColumns(10);
			textFieldAutor.putClientProperty("JTextField.placeholderText", "Ingrese el autor");
			textFieldAutor.setBounds(99, 11, 301, 30);
		}
		return textFieldAutor;
	}
	private JTextField getTextFieldEditorial() {
		if (textFieldEditorial == null) {
			textFieldEditorial = new JTextField();
			textFieldEditorial.setBackground(Colores.getFondo());
			textFieldEditorial.setBorder(null);
			textFieldEditorial.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldEditorial.setEnabled(false);
			textFieldEditorial.setColumns(10);
			textFieldEditorial.setBounds(99, 68, 301, 30);
			textFieldEditorial.putClientProperty("JTextField.placeholderText", "Ingrese la editorial");
		}
		return textFieldEditorial;
	}
	private JLabel getLblLibroAutor() {
		if (lblLibroAutor == null) {
			lblLibroAutor = new JLabel("Autor:");
			lblLibroAutor.setHorizontalAlignment(SwingConstants.TRAILING);
			lblLibroAutor.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblLibroAutor.setBounds(0, 10, 89, 30);
		}
		return lblLibroAutor;
	}
	private JLabel getLblEditorial() {
		if (lblEditorial == null) {
			lblEditorial = new JLabel("Editorial:");
			lblEditorial.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEditorial.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblEditorial.setBounds(0, 67, 89, 30);
		}
		return lblEditorial;
	}
	private JLabel getLabelRevistaAnno() {
		if (labelRevistaAnno == null) {
			labelRevistaAnno = new JLabel("A\u00F1o:");
			labelRevistaAnno.setHorizontalAlignment(SwingConstants.TRAILING);
			labelRevistaAnno.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			labelRevistaAnno.setBounds(39, 12, 80, 30);
		}
		return labelRevistaAnno;
	}
	private JSpinner getSpinnerAnno() {
		if (spinnerAnno == null) {
			spinnerAnno = new JSpinner();
			spinnerAnno.setEnabled(false);
			spinnerAnno.setBackground(Color.WHITE);
			spinnerAnno.setModel(new SpinnerNumberModel(new Integer(2010), null, null, new Integer(5)));
			spinnerAnno.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			spinnerAnno.setBounds(133, 13, 76, 30);
		}
		return spinnerAnno;
	}
	private JLabel getLblNmero() {
		if (lblNmero == null) {
			lblNmero = new JLabel("N\u00FAmero:");
			lblNmero.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNmero.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNmero.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			lblNmero.setBounds(231, 11, 80, 30);
		}
		return lblNmero;
	}
	private JSpinner getSpinnerNum() {
		if (spinnerNum == null) {
			spinnerNum = new JSpinner();
			spinnerNum.setEnabled(false);
			spinnerNum.setBackground(Color.WHITE);
			spinnerNum.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			spinnerNum.setBounds(324, 12, 76, 30);
		}
		return spinnerNum;
	}
	private JTextField getTextFieldAutorArt() {
		if (textFieldAutorArt == null) {
			textFieldAutorArt = new JTextField();
			textFieldAutorArt.setBackground(Colores.getFondo());
			textFieldAutorArt.setBorder(null);
			textFieldAutorArt.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldAutorArt.setEnabled(false);
			textFieldAutorArt.setColumns(10);
			textFieldAutorArt.setBounds(100, 11, 300, 30);
			textFieldAutorArt.putClientProperty("JTextField.placeholderText", "Ingrese el autor");
		}
		return textFieldAutorArt;
	}
	private JLabel getLabelAutorArticulo() {
		if (labelAutorArticulo == null) {
			labelAutorArticulo = new JLabel("Autor:");
			labelAutorArticulo.setHorizontalAlignment(SwingConstants.TRAILING);
			labelAutorArticulo.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			labelAutorArticulo.setBounds(-10, 11, 100, 30);
		}
		return labelAutorArticulo;
	}
	private JTextField getTextFieldArbitro() {
		if (textFieldArbitro == null) {
			textFieldArbitro = new JTextField();
			textFieldArbitro.setBorder(null);
			textFieldArbitro.setBackground(Colores.getFondo());
			textFieldArbitro.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			textFieldArbitro.setEnabled(false);
			textFieldArbitro.setColumns(10);
			textFieldArbitro.setBounds(100, 62, 300, 30);
			textFieldArbitro.putClientProperty("JTextField.placeholderText", "Ingrese el arbitro");
		}
		return textFieldArbitro;
	}
	private JLabel getLabelArbitroArticulo() {
		if (labelArbitroArticulo == null) {
			labelArbitroArticulo = new JLabel("\u00C1rbitro:");
			labelArbitroArticulo.setHorizontalAlignment(SwingConstants.TRAILING);
			labelArbitroArticulo.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			labelArbitroArticulo.setBounds(-10, 63, 100, 30);
		}
		return labelArbitroArticulo;
	}
	private JRadioButton getRdbtnLibros() {
		if (rdbtnLibros == null) {
			rdbtnLibros = new JRadioButton("Libros");
			rdbtnLibros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciarComponentes();
					listPub.setModel(modeloL);
					textPaneTipo.setVisible(true);
					textPaneTipo.setText("Libro");
					panelLibro.setVisible(true);
					panelRevista.setVisible(false);
					panelArticulo.setVisible(false);	
				}

			});
			rdbtnLibros.setBorder(null);
			rdbtnLibros.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			rdbtnLibros.setBackground(Color.WHITE);
			rdbtnLibros.setBounds(68, 19, 85, 30);
		}
		return rdbtnLibros;
	}
	private JRadioButton getRdbtnRevistas() {
		if (rdbtnRevistas == null) {
			rdbtnRevistas = new JRadioButton("Revistas");
			rdbtnRevistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciarComponentes();
					listPub.setModel(modeloR);
					textPaneTipo.setVisible(true);
					textPaneTipo.setText("Revista");
					panelLibro.setVisible(false);
					panelRevista.setVisible(true);
					panelArticulo.setVisible(false);
				}
			});
			rdbtnRevistas.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			rdbtnRevistas.setBorder(null);
			rdbtnRevistas.setBackground(Color.WHITE);
			rdbtnRevistas.setBounds(154, 19, 85, 30);
		}
		return rdbtnRevistas;
	}
	private JRadioButton getRdbtnArticulos() {
		if (rdbtnArticulos == null) {
			rdbtnArticulos = new JRadioButton("Art\u00EDculos");
			rdbtnArticulos.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			rdbtnArticulos.setBorder(null);
			rdbtnArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciarComponentes();
					listPub.setModel(modeloA);
					textPaneTipo.setVisible(true);
					textPaneTipo.setText("Artículo");
					panelLibro.setVisible(false);
					panelRevista.setVisible(false);
					panelArticulo.setVisible(true);
				}
			});
			rdbtnArticulos.setBackground(Color.WHITE);
			rdbtnArticulos.setBounds(263, 19, 91, 30);
		}
		return rdbtnArticulos;
	}
	private JRadioButton getRdbtnTodos() {
		if (rdbtnTodos == null) {
			rdbtnTodos = new JRadioButton("Todos");
			rdbtnTodos.setSelected(true);
			rdbtnTodos.setFont(new Font("Sylfaen", Font.PLAIN, 17));
			rdbtnTodos.setBorder(null);
			rdbtnTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listPub.setModel(modelo);
					if(rdbtnTodos.isSelected()){
						listPub.setModel(modelo);
					}
				}
			});
			rdbtnTodos.setBackground(Color.WHITE);
			rdbtnTodos.setBounds(384, 19, 85, 30);
		}
		return rdbtnTodos;
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator.setBounds(436, 84, 0, 2);
		}
		return separator;
	}
	private JSeparator getSeparator_1() {
		if (separator_1 == null) {
			separator_1 = new JSeparator();
			separator_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_1.setBounds(441, 82, -256, 4);
		}
		return separator_1;
	}
	private JSeparator getSeparator_2() {
		if (separator_2 == null) {
			separator_2 = new JSeparator();
			separator_2.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_2.setBounds(100, 12, 300, 30);
		}
		return separator_2;
	}
	private JSeparator getSeparator_3() {
		if (separator_3 == null) {
			separator_3 = new JSeparator();
			separator_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_3.setBounds(100, 63, 300, 30);
		}
		return separator_3;
	}
	private JSeparator getSeparator_4() {
		if (separator_4 == null) {
			separator_4 = new JSeparator();
			separator_4.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_4.setBounds(99, 12, 301, 30);
		}
		return separator_4;
	}
	private JSeparator getSeparator_5() {
		if (separator_5 == null) {
			separator_5 = new JSeparator();
			separator_5.setBorder(new LineBorder(new Color(0, 0, 0)));
			separator_5.setBounds(99, 69, 301, 30);
		}
		return separator_5;
	}

	public void eliminarPublicacion() {

		if(!listPub.isSelectionEmpty()){

			if(!textFieldTitulo.getText().isEmpty()){

				String tipo = "";
				Publicacion p = listPub.getSelectedValue();
				if(p instanceof Libro)
					tipo = "Libro ";
				if(p instanceof Revista)
					tipo = "Revista ";
				if(p instanceof Articulo)
					tipo = "Artículo ";

				if(Biblioteca.getInstancia().publicacionEliminable(p)){

					int option = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar esta publicación?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (option == JOptionPane.YES_OPTION) {				

						int indice = listPub.getSelectedIndex();

						if(!rdbtnTodos.isSelected()){
							Biblioteca.getInstancia().eliminarPublicacionPorId(p.getId());
							if(rdbtnLibros.isSelected())
								modeloL.removeLibro(indice);
							else if(rdbtnRevistas.isSelected())
								modeloR.removeRevista(indice);
							else if(rdbtnArticulos.isSelected())
								modeloA.removeArticulo(indice);
						}
						else{
							modelo.removePublicacion(indice);
						}

						JOptionPane.showMessageDialog(null,tipo + p.getTitulo() + " ha sido eliminado/a con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
						reiniciarComponentes();
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Esta publicación tiene un historial de préstamos, no puede ser eliminada", "Información", JOptionPane.WARNING_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Seleccione una publicación que desee borrar", "Información", JOptionPane.WARNING_MESSAGE);		
		}
		else {
			JOptionPane.showMessageDialog(null, "Seleccione una publicación que desee borrar", "Información", JOptionPane.WARNING_MESSAGE);
		}
	}
	private JTextPane getTextPaneTipo() {
		if (textPaneTipo == null) {
			textPaneTipo = new JTextPane();
			textPaneTipo.setBackground(Color.WHITE);
			textPaneTipo.setFocusable(false);
			textPaneTipo.setEditable(false);
			textPaneTipo.setBounds(567, 11, 98, 38);
			textPaneTipo.setVisible(false);
			textPaneTipo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		}
		return textPaneTipo;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
			lblNewLabel.setBounds(105, 81, 306, 36);
		}
		return lblNewLabel;
	}
	private JTextPane getTextPaneError() {
		if (textPaneError == null) {
			textPaneError = new JTextPane();
			textPaneError.setEditable(false);
			textPaneError.setFocusable(false);
			textPaneError.setVisible(false);
			textPaneError.setForeground(Color.RED);
			textPaneError.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneError.setText("Datos inv\u00E1lidos");
			textPaneError.setBounds(784, 496, 137, 34);
		}
		return textPaneError;
	}
	private JTextPane getTextPane_1() {
		if (textPaneOperacion == null) {
			textPaneOperacion = new JTextPane();
			textPaneOperacion.setBackground(Color.WHITE);
			textPaneOperacion.setFocusable(false);
			textPaneOperacion.setEditable(false);
			textPaneOperacion.setBounds(668, 11, 123, 38);
			textPaneOperacion.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			textPaneOperacion.setVisible(false);
		}
		return textPaneOperacion;
	}
	private JPanel getPanelCRUD() {
		if (panelCRUD == null) {
			panelCRUD = new JPanel();
			panelCRUD.setBackground(Colores.getFondo());
			panelCRUD.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelCRUD.setBounds(525, 59, 443, 453);
			panelCRUD.setLayout(null);
			panelCRUD.add(getLabelMateria());
			panelCRUD.add(getLblEjemplares());//
			panelCRUD.add(getLblIdentificador());//
			panelCRUD.add(getLabelTitulo());//
			panelCRUD.add(getTextFieldTitulo());//
			panelCRUD.add(getComboBoxMateria());//
			panelCRUD.add(getTextFieldCarnet());
			panelCRUD.add(getLblNumPag());
			panelCRUD.add(getSpinnerPag());
			panelCRUD.add(getSpinnerEjemp());
			panelCRUD.add(getSeparator());
			panelCRUD.add(getSeparator_1());
			panelCRUD.add(getLblNewLabel());
			panelCRUD.add(getBtnAgregar());
			panelCRUD.add(getBtnEditar());
			panelCRUD.add(getBtnEliminar());
			panelCRUD.add(getBtnConfirmar());
			panelCRUD.add(getBtnGuardar());
			panelCRUD.add(getLabel());
			panelCRUD.add(getBtnCancelar());
			panelCRUD.add(getPanel());
		}
		return panelCRUD;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBorder(new LineBorder(new Color(0, 0, 0)));
			label.setBounds(104, 23, 307, 36);
		}
		return label;
	}
}
