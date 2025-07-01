package Visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Articulo;
import Logica.Libro;
import Logica.Publicacion;
import Logica.Revista;
import Utiles.Colores;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import java.awt.CardLayout;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class InfoPublicacionTablaPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel labelImagen;
	private JTextPane txtpnTtulo;
	private JTextPane textPaneId;
	private JTextPane txtpnMateria;
	private JTextPane txtpnPginas;
	private JTextPane txtpnEjemplares;
	private JTextPane textPaneOtroAtributo;
	private JTextPane textPaneOotroAtributo;
	private JTextPane textPaneTipo;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JTextPane txtpnLosDerechosDe;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InfoPublicacionTablaPrestamo(Publicacion p) {
		setTitle("Informaci\u00F3n Publicación");
		setModal(true);
		setBounds(150, 20, 799, 494);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Colores.getFondo());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLabelImagen());
		labelImagen.setIcon(p.getImage());
		contentPanel.add(getTxtpnTtulo());
		contentPanel.add(getTextPaneId());
		contentPanel.add(getTxtpnMateria());
		contentPanel.add(getTextPane_2_1());
		contentPanel.add(getTextPane_3_1());
		contentPanel.add(getTextPaneOtroAtributo());
		contentPanel.add(getTextPaneOotroAtributo());
		txtpnTtulo.setText("Título: " + p.getTitulo());
		textPaneId.setText("Identificador: " + p.getId());
		txtpnMateria.setText("Materia: " + p.getMateria());
		txtpnPginas.setText("Páginas: " + p.getNumPaginas());
		txtpnEjemplares.setText("Ejemplares: " + p.getCantEjemplares());
		contentPanel.add(getTextPaneTipo());
		contentPanel.add(getLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
		contentPanel.add(getLabel_3());
		contentPanel.add(getLabel_4());
		contentPanel.add(getLabel_5());
		contentPanel.add(getLabel_6());
		contentPanel.add(getLabel_7());
		contentPanel.add(getLabel_8());
		contentPanel.add(getTxtpnLosDerechosDe());
		if(p instanceof Libro){
			textPaneTipo.setText("Libro");
			textPaneOtroAtributo.setText("Autor: " + ((Libro)p).getAutores().get(0));
			textPaneOotroAtributo.setText("Editorial: " + ((Libro)p).getEditorial());
		}
		else if(p instanceof Revista){
			textPaneTipo.setText("Revista");
			textPaneOtroAtributo.setText("Año de publicación: " + ((Revista)p).getAnno());
			textPaneOotroAtributo.setText("Número de revista" + ((Revista)p).getNum());
		}
		else if(p instanceof Articulo){
			textPaneTipo.setText("Artículo");
			textPaneOtroAtributo.setText("Autor: " + ((Articulo)p).getAutores().get(0));
			textPaneOotroAtributo.setText("Árbitro: " + ((Articulo)p).getArbitros().get(0));
		}
	}
	private JLabel getLabelImagen() {
		if (labelImagen == null) {
			labelImagen = new JLabel("");
			labelImagen.setBorder(new LineBorder(Colores.getCruds()));
			labelImagen.setBounds(445, 18, 312, 412);
		}
		return labelImagen;
	}
	private JTextPane getTxtpnTtulo() {
		if (txtpnTtulo == null) {
			txtpnTtulo = new JTextPane();
			txtpnTtulo.setText("T\u00EDtulo:");
			txtpnTtulo.setFocusable(false);
			txtpnTtulo.setBackground(Colores.getFondo());
			txtpnTtulo.setEditable(false);
			txtpnTtulo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			txtpnTtulo.setBounds(60, 59, 351, 37);
		}
		return txtpnTtulo;
	}
	private JTextPane getTextPaneId() {
		if (textPaneId == null) {
			textPaneId = new JTextPane();
			textPaneId.setText("Identificador:");
			textPaneId.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			textPaneId.setFocusable(false);
			textPaneId.setEditable(false);
			textPaneId.setBackground(Colores.getFondo());
			textPaneId.setBounds(60, 107, 351, 37);
		}
		return textPaneId;
	}
	private JTextPane getTxtpnMateria() {
		if (txtpnMateria == null) {
			txtpnMateria = new JTextPane();
			txtpnMateria.setText("Materia:");
			txtpnMateria.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			txtpnMateria.setFocusable(false);
			txtpnMateria.setEditable(false);
			txtpnMateria.setBackground(Colores.getFondo());
			txtpnMateria.setBounds(60, 155, 355, 37);
		}
		return txtpnMateria;
	}
	private JTextPane getTextPane_2_1() {
		if (txtpnPginas == null) {
			txtpnPginas = new JTextPane();
			txtpnPginas.setText("P\u00E1ginas:");
			txtpnPginas.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			txtpnPginas.setFocusable(false);
			txtpnPginas.setEditable(false);
			txtpnPginas.setBackground(Colores.getFondo());
			txtpnPginas.setBounds(60, 203, 169, 37);
		}
		return txtpnPginas;
	}
	private JTextPane getTextPane_3_1() {
		if (txtpnEjemplares == null) {
			txtpnEjemplares = new JTextPane();
			txtpnEjemplares.setText("Ejemplares:");
			txtpnEjemplares.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			txtpnEjemplares.setFocusable(false);
			txtpnEjemplares.setEditable(false);
			txtpnEjemplares.setBackground(Colores.getFondo());
			txtpnEjemplares.setBounds(246, 203, 169, 37);
		}
		return txtpnEjemplares;
	}
	private JTextPane getTextPaneOtroAtributo() {
		if (textPaneOtroAtributo == null) {
			textPaneOtroAtributo = new JTextPane();
			textPaneOtroAtributo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			textPaneOtroAtributo.setFocusable(false);
			textPaneOtroAtributo.setEditable(false);
			textPaneOtroAtributo.setBackground(Colores.getFondo());
			textPaneOtroAtributo.setBounds(60, 251, 351, 37);
		}
		return textPaneOtroAtributo;
	}
	private JTextPane getTextPaneOotroAtributo() {
		if (textPaneOotroAtributo == null) {
			textPaneOotroAtributo = new JTextPane();
			textPaneOotroAtributo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			textPaneOotroAtributo.setFocusable(false);
			textPaneOotroAtributo.setEditable(false);
			textPaneOotroAtributo.setBackground(Colores.getFondo());
			textPaneOotroAtributo.setBounds(60, 299, 351, 37);
		}
		return textPaneOotroAtributo;
	}
	private JTextPane getTextPaneTipo() {
		if (textPaneTipo == null) {
			textPaneTipo = new JTextPane();
			textPaneTipo.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			textPaneTipo.setFocusable(false);
			textPaneTipo.setEditable(false);
			textPaneTipo.setBackground(Colores.getFondo());
			textPaneTipo.setBounds(60, 11, 351, 37);
		}
		return textPaneTipo;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setBounds(20, 18, 30, 30);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setBounds(20, 66, 30, 30);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
			label_2.setBounds(20, 114, 30, 30);
		}
		return label_2;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setBounds(20, 162, 30, 30);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setBounds(20, 210, 30, 30);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setBounds(246, 210, 30, 30);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setBounds(20, 258, 30, 30);
		}
		return label_6;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setBounds(20, 306, 30, 30);
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
			label_8.setIcon(new ImageIcon("src/images/iconos/Info.png"));
			label_8.setBounds(20, 376, 38, 38);
		}
		return label_8;
	}
	private JTextPane getTxtpnLosDerechosDe() {
		if (txtpnLosDerechosDe == null) {
			txtpnLosDerechosDe = new JTextPane();
			txtpnLosDerechosDe.setText("Los derechos de la portada pertenecen a sus respectivos due\u00F1os");
			txtpnLosDerechosDe.setFont(new Font("Sylfaen", Font.PLAIN, 18));
			txtpnLosDerechosDe.setFocusable(false);
			txtpnLosDerechosDe.setEditable(false);
			txtpnLosDerechosDe.setBackground(Colores.getFondo());
			txtpnLosDerechosDe.setBounds(60, 373, 355, 54);
		}
		return txtpnLosDerechosDe;
	}
}
