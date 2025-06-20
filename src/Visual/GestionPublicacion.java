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

		setBounds(0, 80, 1149, 639);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLabelMateria());
		contentPanel.add(getLblEjemplares());//
		contentPanel.add(getLblIdentificador());//
		contentPanel.add(getLabelTitulo());//
		contentPanel.add(getTextFieldTitulo());//
		contentPanel.add(getComboBoxMateria());//
		contentPanel.add(getTextFieldCarnet());
		contentPanel.add(getLblNumPag());
		contentPanel.add(getBtnAgregar());//
		contentPanel.add(getBtnEditar());//
		contentPanel.add(getBtnEliminar());//
		contentPanel.add(getBtnConfirmar());//
		contentPanel.add(getBtnCancelar());//
		contentPanel.add(getBtnGuardar());
		contentPanel.add(getPanel());
		contentPanel.add(getScrollPane());
		contentPanel.add(getSpinnerPag());
		contentPanel.add(getSpinnerEjemp());
		contentPanel.add(getRdbtnLibros());
		contentPanel.add(getRdbtnRevistas());
		contentPanel.add(getRdbtnArticulos());
		contentPanel.add(getRdbtnTodos());
		rdbtns = new ButtonGroup();
		rdbtns.add(getRdbtnArticulos());
		rdbtns.add(getRdbtnLibros());
		rdbtns.add(getRdbtnRevistas());
		rdbtns.add(getRdbtnTodos());
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
			scrollPane.setBounds(47, 66, 526, 520);
			listPub.setSelectedIndices(new int[] {1});
			listPub.setToolTipText("Lista de publicaciones actualmente registradas");
			listPub.setBorder(new LineBorder(new Color(0, 0, 0)));
			listPub.setFont(new Font("SansSerif", Font.PLAIN, 17));
	        listPub.setBorder(new LineBorder(new Color(0, 0, 0), 1));
	        listPub.setBackground(Color.WHITE);
			listPub.setModel(modelo);
			listPub.setSelectedIndex(1);
			listPub.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					int indice = listPub.getSelectedIndex();
					int pos = -1;
					
					if (indice > -1) {
						btnEditar.setVisible(false);
						btnEliminar.setVisible(true);
						
						if(rdbtnLibros.isSelected()){
							Libro l = modeloL.getLibroAt(indice);
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
						if(rdbtnRevistas.isSelected()){
							Revista r = modeloR.getRevistaAt(indice);
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
						if(rdbtnArticulos.isSelected()){
							Articulo a = modeloA.getArticuloAt(indice);
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
						else if(rdbtnTodos.isSelected()){
							Publicacion p = modelo.getPubAt(indice);
							textFieldTitulo.setText(p.getTitulo());
							textFieldCarnet.setText(p.getId());
							spinnerPag.setValue(p.getNumPaginas());
							spinnerEjemp.setValue(p.getCantEjemplares());
							for(int i = 0; i < materias.length; i++){
								if(p.getMateria().equals(materias[i]))
									pos = i;
							}
							comboBoxMateria.setSelectedIndex(pos);
						}
						btnEditar.setVisible(true);
						btnEliminar.setVisible(true);


//						if(rdbtnLibros.isSelected()){
//							listPub.setModel(modeloL);
//							panelLibro.setVisible(true);
//							panelRevista.setVisible(false);
//							panelArticulo.setVisible(false);	
//						}
//						if(rdbtnRevistas.isSelected()){
//							listPub.setModel(modeloR);
//							panelLibro.setVisible(false);
//							panelRevista.setVisible(true);
//							panelArticulo.setVisible(false);
//						}
//						if(rdbtnArticulos.isSelected()){
//							listPub.setModel(modeloA);
//							panelLibro.setVisible(false);
//							panelRevista.setVisible(false);
//							panelArticulo.setVisible(true);
//						}
//						if(rdbtnTodos.isSelected()){
//							listPub.setModel(modelo);
//						}
					}
				}
			});
			scrollPane.setViewportView(listPub);
		}
		return scrollPane;
	}

	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.setBounds(1091, 11, 48, 45);
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
			panel.setBounds(671, 330, 415, 136);
			panel.setBackground(Color.WHITE);
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
			panelRevista.setBackground(Color.WHITE);
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
			panelArticulo.setBackground(Color.WHITE);
			panelArticulo.setLayout(null);
			panelArticulo.add(getTextFieldAutorArt());
			panelArticulo.add(getLabelAutorArticulo());
			panelArticulo.add(getTextFieldArbitro());
			panelArticulo.add(getLabelArbitroArticulo());
		}
		return panelArticulo;
	}
	private JTextField getTextFieldTitulo() {
		if (textFieldTitulo == null) {
			textFieldTitulo = new JTextField();
			textFieldTitulo.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textFieldTitulo.setBounds(793, 105, 274, 30);
			textFieldTitulo.setEnabled(false);
			textFieldTitulo.setColumns(10);
			textFieldTitulo.putClientProperty("JTextField.placeholderText", "Ingrese el titulo");
		}
		return textFieldTitulo;
	}
	private JComboBox getComboBoxMateria() {
		if (comboBoxMateria == null) {
			comboBoxMateria = new JComboBox();
			comboBoxMateria.setBounds(785, 281, 282, 30);
			comboBoxMateria.setEnabled(false);
			comboBoxMateria.setFont(new Font("SansSerif", Font.PLAIN, 16));
			comboBoxMateria.setModel(new DefaultComboBoxModel(materias));
		}
		return comboBoxMateria;
	}
	private JLabel getLblNumPag() {
		if (lblNumPag == null) {
			lblNumPag = new JLabel("P\u00E1ginas:");
			lblNumPag.setBounds(708, 225, 80, 30);
			lblNumPag.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return lblNumPag;
	}
	private JLabel getLblEjemplares() {
		if (lblEjemplares == null) {
			lblEjemplares = new JLabel("Ejemplares:");
			lblEjemplares.setBounds(887, 225, 104, 30);
			lblEjemplares.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return lblEjemplares;
	}
	private JLabel getLabelMateria() {
		if (labelMateria == null) {
			labelMateria = new JLabel("Materia:");
			labelMateria.setBounds(674, 280, 100, 30);
			labelMateria.setHorizontalAlignment(SwingConstants.TRAILING);
			labelMateria.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return labelMateria;
	}
	private JLabel getLblIdentificador() {
		if (lblIdentificador == null) {
			lblIdentificador = new JLabel("Identificador:");
			lblIdentificador.setBounds(656, 165, 123, 30);
			lblIdentificador.setHorizontalAlignment(SwingConstants.TRAILING);
			lblIdentificador.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return lblIdentificador;
	}
	private JLabel getLabelTitulo() {
		if (labelTitulo == null) {
			labelTitulo = new JLabel("T\u00EDtulo:");
			labelTitulo.setBounds(682, 105, 100, 30);
			labelTitulo.setHorizontalAlignment(SwingConstants.TRAILING);
			labelTitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
		}
		return labelTitulo;
	}
	private JTextFieldCarnet getTextFieldCarnet() {
		if (textFieldCarnet == null) {
			textFieldCarnet = new JTextFieldCarnet();
			textFieldCarnet.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textFieldCarnet.setBounds(792, 165, 275, 30);
			textFieldCarnet.setEnabled(false);
		}
		return textFieldCarnet;
	}
	private JButton getBtnAgregar() {
		if (btnAgregar == null) {
			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(691, 473, 106, 30);
			btnAgregar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					textFieldTitulo.setEnabled(true);
					textFieldCarnet.setEnabled(true);
					spinnerPag.setEnabled(true);
					spinnerEjemp.setEnabled(true);
					comboBoxMateria.setEnabled(true);

					//Articulo
					textFieldAutorArt.setEnabled(true);
					textFieldArbitro.setEnabled(true);

					//Revista
					spinnerAnno.setEnabled(true);
					spinnerNum.setEnabled(true);

					//Libro
					textFieldAutor.setEnabled(true);
					textFieldEditorial.setEnabled(true);

					reiniciarComponentes();

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
			});
			btnAgregar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		}
		return btnAgregar;
	}

	private JButton getBtnEditar() {
		if (btnEditar == null) {
			btnEditar = new JButton("Editar");
			btnEditar.setVisible(false);
			btnEditar.setBounds(837, 473, 106, 30);
			btnEditar.setFont(new Font("SansSerif", Font.PLAIN, 17));
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0){
					
					Publicacion p = listPub.getSelectedValue();
					//Desactivar CRUD
					btnAgregar.setVisible(false);
					btnEditar.setVisible(false);
					btnEliminar.setVisible(false);

					//Activar confirmacion
					btnGuardar.setVisible(true);
					btnConfirmar.setVisible(false);
					btnCancelar.setVisible(true);

					textFieldTitulo.setEnabled(true);
					textFieldAutor.setEnabled(true);
					textFieldEditorial.setEnabled(true);
					textFieldCarnet.setEnabled(true);
					spinnerPag.setEnabled(true);
					spinnerEjemp.setEnabled(true);
					comboBoxMateria.setEnabled(true);

					int selectedIndex = listPub.getSelectedIndex();
	                
	                System.out.println("DEBUG: Índice seleccionado: " + selectedIndex);
	                System.out.println("DEBUG: Publicación seleccionada: " + p);
					
					if(p instanceof Libro){
						textFieldAutor.setEnabled(true);
						textFieldEditorial.setEnabled(true);
					}
					else if(p instanceof Revista){
						spinnerAnno.setEnabled(true);
						spinnerNum.setEnabled(true);
					}
					else if(p instanceof Articulo){
						textFieldAutorArt.setEnabled(true);
						textFieldArbitro.setEnabled(true);
					}
					listPub.setEnabled(false);
				}
			});
		}
		return btnEditar;
	}
	
	private JButton getBtnEliminar() {
		if (btnEliminar == null) {
			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int indice = listPub.getSelectedIndex();
					if(rdbtnLibros.isSelected())
						modeloL.removeLibro(indice);
					else if(rdbtnRevistas.isSelected())
						modeloR.removeRevista(indice);
					else if(rdbtnArticulos.isSelected())
						modeloA.removeArticulo(indice);
					else if(rdbtnTodos.isSelected())
						modelo.removePublicacion(indice);
				}
			});
			btnEliminar.setVisible(false);
			btnEliminar.setBounds(980, 473, 106, 30);
			btnEliminar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		}
		return btnEliminar;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Libro l = null;
					Revista r = null;
					Articulo a = null;

					boolean exito = false;

					if(rdbtnLibros.isSelected()){
						l = agregarLibro();
						if(l != null){
							modeloL.addLibro(l);
							JOptionPane.showMessageDialog(null, "Libro " + l.getTitulo() + " agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
						}
					}
					if(rdbtnRevistas.isSelected()){
						r = agregarRevista();
						if(r != null){
							modeloR.addRevista(r);
							JOptionPane.showMessageDialog(null, "Revista " + l.getTitulo() + " agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
						}
					}
					if(rdbtnArticulos.isSelected()){
						a = agregarArticulo();
						if(a != null){
							modeloA.addArticulo(a);
							JOptionPane.showMessageDialog(null, "Articulo " + l.getTitulo() + " agregado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
						}
					}

					if(exito){
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
					}
					else{
						JOptionPane.showMessageDialog(null, "Algo salió mal", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
			btnConfirmar.setVisible(false);
			btnConfirmar.setBounds(760, 496, 106, 30);
			btnConfirmar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		}
		return btnConfirmar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					reiniciarComponentes();
					listPub.setEnabled(true);
					textFieldTitulo.setEnabled(false);
					textFieldAutor.setEnabled(false);
					textFieldEditorial.setEnabled(false);
					textFieldCarnet.setEnabled(false);
					spinnerPag.setEnabled(false);
					spinnerEjemp.setEnabled(false);
					comboBoxMateria.setEnabled(false);
					
				}
			});
			btnCancelar.setVisible(false);
			btnCancelar.setBounds(903, 496, 30, 30);
			btnCancelar.setIcon(new ImageIcon("src/images/reiniciar30x30.png"));
			btnCancelar.setFont(new Font("SansSerif", Font.PLAIN, 17));
		}
		return btnCancelar;
	}
	private JButton getBtnGuardar() {
		if (btnGuardar == null) {
			btnGuardar = new JButton("Guardar");
			btnGuardar.setVisible(false);
			btnGuardar.setBounds(766, 496, 106, 30);
			btnGuardar.setFont(new Font("SansSerif", Font.PLAIN, 17));
			btnGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {

					boolean exito = false;

					int indice = listPub.getSelectedIndex();
					Publicacion p = listPub.getSelectedValue();
					int indexPub = Biblioteca.getInstancia().buscarPosPublicacion(p);
					
					if(p instanceof Libro){
						Libro l = editarLibro(indexPub);
						System.out.println("entro a editar libro");
						if(l != null){
							modeloL.updateLibro(indice, l);
							modelo.updatePublicacion(indice, l);
							JOptionPane.showMessageDialog(null, "Libro " + l.getTitulo() + " modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
						}
					}
					else if(p instanceof Revista){
						Revista r = editarRevista(indexPub);
						if(r != null){
							modeloR.updateRevista(indice, r);
							modelo.updatePublicacion(indice, r);
							JOptionPane.showMessageDialog(null, "Revista " + r.getTitulo() + " modificada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
						}
					}
					else if(p instanceof Articulo){
						Articulo a = editarArticulo(indexPub);
						if(a != null){
							modeloA.updateArticulo(indice, a);
							modelo.updatePublicacion(indice, a);
							JOptionPane.showMessageDialog(null, "Artículo " + a.getTitulo() + " modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
							exito = true;
						}
					}

					if(exito){
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
		
		System.out.println(l.getTitulo());

		String titulo = textFieldTitulo.getText();
		String id = textFieldCarnet.getText();
		int cantE = (Integer)spinnerEjemp.getValue();
		int numPag = (Integer)spinnerPag.getValue();
		String materia = comboBoxMateria.getSelectedItem().toString();
		String editorial = textFieldEditorial.getText();
		String autor = textFieldAutor.getText();

		try{
			l.setTitulo(titulo);
			System.out.println("setTitulo" + titulo);
			labelTitulo.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			System.out.println("ERROR en setTitulo" + titulo);
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			l.setId(id);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			l.setCantEjemplares(cantE);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			l.setMateria(materia);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			l.setNumPaginas(numPag);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			editado = false;
		}
		try{
			l.setEditorial(editorial);
			lblEditorial.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEditorial.setForeground(Color.RED);
			editado = false;
			textFieldEditorial.setText("");
		}
		try{
			l.setAutores(autor);
			lblLibroAutor.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblLibroAutor.setForeground(Color.RED);
			textFieldAutor.setText("");
			editado = false;
		}
		if(!editado){
			l = null;
			System.out.println("Hola " + titulo);
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
			labelTitulo.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			r.setId(id);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			r.setCantEjemplares(cantE);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			r.setMateria(materia);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			r.setNumPaginas(numPag);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			editado = false;
		}
		try{
			r.setNum(num);
			lblNmero.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNmero.setForeground(Color.RED);
			editado = false;
			spinnerNum.setValue(0);
		}
		try{
			r.setAnno(anno);
			labelRevistaAnno.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelRevistaAnno.setForeground(Color.RED);
			spinnerAnno.setValue(0);
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
		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			l.setId(id);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			l.setCantEjemplares(cantE);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			l.setMateria(materia);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			l.setNumPaginas(numPag);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			editado = false;
		}
		try{
			l.setEditorial(editorial);
			lblEditorial.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEditorial.setForeground(Color.RED);
			editado = false;
			textFieldEditorial.setText("");
		}
		try{
			l.setAutores(autor);
			lblLibroAutor.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblLibroAutor.setForeground(Color.RED);
			textFieldAutor.setText("");
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
			labelTitulo.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelTitulo.setForeground(Color.RED);
			editado = false;
			textFieldTitulo.setText("");
		}
		try{
			r.setId(id);
			lblIdentificador.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblIdentificador.setForeground(Color.RED);
			textFieldCarnet.setText("");
			editado = false;
		}
		try{
			r.setCantEjemplares(cantE);
			lblEjemplares.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblEjemplares.setForeground(Color.RED);
			spinnerEjemp.setValue(0);
			editado = false;
		}
		try{
			r.setMateria(materia);
			labelMateria.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			labelMateria.setForeground(Color.RED);
			comboBoxMateria.setSelectedIndex(0);
			editado = false;
		}
		try{
			r.setNumPaginas(numPag);
			lblNumPag.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNumPag.setForeground(Color.RED);
			spinnerPag.setValue(0);
			editado = false;
		}
		try{
			r.setNum(num);
			lblNmero.setForeground(Color.BLACK);
		}catch(IllegalArgumentException e){
			lblNmero.setForeground(Color.RED);
			editado = false;
			spinnerNum.setValue(0);
		}
		try{
			r.setAnno(anno);
			labelRevistaAnno.setForeground(Color.BLACK);

		}catch(IllegalArgumentException e){
			labelRevistaAnno.setForeground(Color.RED);
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
			spinnerPag.setBounds(792, 224, 73, 30);
			spinnerPag.setFont(new Font("SansSerif", Font.PLAIN, 16));
		}
		return spinnerPag;
	}
	private JSpinner getSpinnerEjemp() {
		if (spinnerEjemp == null) {
			spinnerEjemp = new JSpinner();
			spinnerEjemp.setBounds(994, 225, 73, 30);
			spinnerEjemp.setFont(new Font("SansSerif", Font.PLAIN, 16));
		}
		return spinnerEjemp;
	}
	private JPanel getPanelLibro() {
		if (panelLibro == null) {
			panelLibro = new JPanel();
			panelLibro.setVisible(false);
			panelLibro.setBackground(Color.WHITE);
			panelLibro.setLayout(null);
			panelLibro.add(getTextFieldAutor());
			panelLibro.add(getTextFieldEditorial());
			panelLibro.add(getLblLibroAutor());
			panelLibro.add(getLblEditorial());
		}
		return panelLibro;
	}
	private JTextField getTextFieldAutor() {
		if (textFieldAutor == null) {
			textFieldAutor = new JTextField();
			textFieldAutor.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textFieldAutor.setEnabled(false);
			textFieldAutor.setColumns(10);
			textFieldAutor.setBounds(114, 11, 275, 30);
		}
		return textFieldAutor;
	}
	private JTextField getTextFieldEditorial() {
		if (textFieldEditorial == null) {
			textFieldEditorial = new JTextField();
			textFieldEditorial.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textFieldEditorial.setEnabled(false);
			textFieldEditorial.setColumns(10);
			textFieldEditorial.setBounds(114, 68, 275, 30);
			textFieldEditorial.putClientProperty("JTextField.placeholderText", "Ingrese la editorial");
		}
		return textFieldEditorial;
	}
	private JLabel getLblLibroAutor() {
		if (lblLibroAutor == null) {
			lblLibroAutor = new JLabel("Autor:");
			lblLibroAutor.setHorizontalAlignment(SwingConstants.TRAILING);
			lblLibroAutor.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblLibroAutor.setBounds(4, 11, 100, 30);
		}
		return lblLibroAutor;
	}
	private JLabel getLblEditorial() {
		if (lblEditorial == null) {
			lblEditorial = new JLabel("Editorial:");
			lblEditorial.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEditorial.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblEditorial.setBounds(4, 68, 100, 30);
		}
		return lblEditorial;
	}
	private JLabel getLabelRevistaAnno() {
		if (labelRevistaAnno == null) {
			labelRevistaAnno = new JLabel("A\u00F1o:");
			labelRevistaAnno.setHorizontalAlignment(SwingConstants.TRAILING);
			labelRevistaAnno.setFont(new Font("SansSerif", Font.PLAIN, 18));
			labelRevistaAnno.setBounds(24, 10, 80, 30);
		}
		return labelRevistaAnno;
	}
	private JSpinner getSpinnerAnno() {
		if (spinnerAnno == null) {
			spinnerAnno = new JSpinner();
			spinnerAnno.setModel(new SpinnerNumberModel(new Integer(2010), null, null, new Integer(5)));
			spinnerAnno.setFont(new Font("SansSerif", Font.PLAIN, 16));
			spinnerAnno.setBounds(114, 11, 80, 30);
		}
		return spinnerAnno;
	}
	private JLabel getLblNmero() {
		if (lblNmero == null) {
			lblNmero = new JLabel("N\u00FAmero:");
			lblNmero.setHorizontalAlignment(SwingConstants.TRAILING);
			lblNmero.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNmero.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblNmero.setBounds(230, 10, 80, 30);
		}
		return lblNmero;
	}
	private JSpinner getSpinnerNum() {
		if (spinnerNum == null) {
			spinnerNum = new JSpinner();
			spinnerNum.setFont(new Font("SansSerif", Font.PLAIN, 16));
			spinnerNum.setBounds(324, 11, 70, 30);
		}
		return spinnerNum;
	}
	private JTextField getTextFieldAutorArt() {
		if (textFieldAutorArt == null) {
			textFieldAutorArt = new JTextField();
			textFieldAutorArt.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textFieldAutorArt.setEnabled(false);
			textFieldAutorArt.setColumns(10);
			textFieldAutorArt.setBounds(114, 11, 275, 30);
			textFieldAutorArt.putClientProperty("JTextField.placeholderText", "Ingrese el autor");
		}
		return textFieldAutorArt;
	}
	private JLabel getLabelAutorArticulo() {
		if (labelAutorArticulo == null) {
			labelAutorArticulo = new JLabel("Autor:");
			labelAutorArticulo.setHorizontalAlignment(SwingConstants.TRAILING);
			labelAutorArticulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			labelAutorArticulo.setBounds(4, 11, 100, 30);
		}
		return labelAutorArticulo;
	}
	private JTextField getTextFieldArbitro() {
		if (textFieldArbitro == null) {
			textFieldArbitro = new JTextField();
			textFieldArbitro.setFont(new Font("SansSerif", Font.PLAIN, 16));
			textFieldArbitro.setEnabled(false);
			textFieldArbitro.setColumns(10);
			textFieldArbitro.setBounds(114, 68, 275, 30);
			textFieldArbitro.putClientProperty("JTextField.placeholderText", "Ingrese el arbitro");
		}
		return textFieldArbitro;
	}
	private JLabel getLabelArbitroArticulo() {
		if (labelArbitroArticulo == null) {
			labelArbitroArticulo = new JLabel("\u00C1rbitro:");
			labelArbitroArticulo.setHorizontalAlignment(SwingConstants.TRAILING);
			labelArbitroArticulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			labelArbitroArticulo.setBounds(4, 63, 100, 30);
		}
		return labelArbitroArticulo;
	}
	private JRadioButton getRdbtnLibros() {
		if (rdbtnLibros == null) {
			rdbtnLibros = new JRadioButton("Libros");
			rdbtnLibros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listPub.setModel(modeloL);
				}
			});
			rdbtnLibros.setBorder(null);
			rdbtnLibros.setFont(new Font("SansSerif", Font.PLAIN, 17));
			rdbtnLibros.setBackground(Color.WHITE);
			rdbtnLibros.setBounds(210, 25, 80, 23);
		}
		return rdbtnLibros;
	}
	private JRadioButton getRdbtnRevistas() {
		if (rdbtnRevistas == null) {
			rdbtnRevistas = new JRadioButton("Revistas");
			rdbtnRevistas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listPub.setModel(modeloR);
				}
			});
			rdbtnRevistas.setFont(new Font("SansSerif", Font.PLAIN, 17));
			rdbtnRevistas.setBorder(null);
			rdbtnRevistas.setBackground(Color.WHITE);
			rdbtnRevistas.setBounds(295, 25, 80, 23);
		}
		return rdbtnRevistas;
	}
	private JRadioButton getRdbtnArticulos() {
		if (rdbtnArticulos == null) {
			rdbtnArticulos = new JRadioButton("Art\u00EDculos");
			rdbtnArticulos.setFont(new Font("SansSerif", Font.PLAIN, 17));
			rdbtnArticulos.setBorder(null);
			rdbtnArticulos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listPub.setModel(modeloA);
				}
			});
			rdbtnArticulos.setBackground(Color.WHITE);
			rdbtnArticulos.setBounds(392, 25, 98, 23);
		}
		return rdbtnArticulos;
	}
	private JRadioButton getRdbtnTodos() {
		if (rdbtnTodos == null) {
			rdbtnTodos = new JRadioButton("Todos");
			rdbtnTodos.setSelected(true);
			rdbtnTodos.setFont(new Font("SansSerif", Font.PLAIN, 17));
			rdbtnTodos.setBorder(null);
			rdbtnTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					listPub.setModel(modelo);
				}
			});
			rdbtnTodos.setBackground(Color.WHITE);
			rdbtnTodos.setBounds(493, 25, 80, 23);
		}
		return rdbtnTodos;
	}
}
