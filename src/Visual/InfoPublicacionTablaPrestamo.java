package Visual;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Articulo;
import Logica.Libro;
import Logica.Publicacion;
import Logica.Revista;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;

import java.awt.SystemColor;
import java.awt.CardLayout;

public class InfoPublicacionTablaPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNewLabel;
	private JTextPane textPaneTitulo;
	private JLabel lblCarnetUsuario;
	private JLabel lblPenalizacin;
	private JTextPane textPaneId;
	private JTextPane textPaneMateria;
	private JLabel lblEdad;
	private JTextPane textPanePag;
	private JLabel lblSexo;
	private JTextPane textPaneEjemp;
	private JPanel panelLibro;
	private JTextPane textPaneAutor;
	private JLabel lblAutor;
	private JTextPane textPaneEditorial;
	private JLabel lblEditorial;
	private JPanel panel_1;
	private JPanel panelRevista;
	private JTextPane textPane_2;
	private JTextPane textPane_3;
	private JLabel lblAutor_1;
	private JLabel lblrbitro;
	private JPanel panel;
	private JLabel lblAo;
	private JTextPane textPaneAnnio;
	private JLabel lblNmero;
	private JTextPane textPaneNum;
	private JLabel labelTipo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InfoPublicacionTablaPrestamo(Publicacion p) {
		setTitle("Informaci\u00F3n Usuario");
		setModal(true);
		setBounds(450, 100, 948, 520);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTextPaneTitulo());
		contentPanel.add(getLblCarnetUsuario());
		contentPanel.add(getLblPenalizacin());
		contentPanel.add(getTextPaneId());
		contentPanel.add(getTextPaneMateria());
		contentPanel.add(getLblEdad());
		contentPanel.add(getTextPanePag());
		contentPanel.add(getLblSexo());
		contentPanel.add(getTextPaneEjemp());
		contentPanel.add(getPanel_1());
		textPaneTitulo.setText(p.getTitulo());
		textPaneId.setText(p.getId());
		textPanePag.setText("" + p.getNumPaginas());
		textPaneEjemp.setText("" + p.getCantEjemplares());
		if(p instanceof Libro){
			panelLibro.setVisible(true);
			textPaneAutor.setText(((Libro)p).getAutores().get(0));
			textPaneEditorial.setText(((Libro)p).getEditorial());
		}
		else if(p instanceof Revista){
			panelRevista.setVisible(true);
			textPaneAnnio.setText("" + ((Revista)p).getAnno());
			textPaneNum.setText("" + ((Revista)p).getNum());
		}
		else if(p instanceof Articulo){
			panelRevista.setVisible(true);
			textPane_2.setText(((Articulo)p).getAutores().get(0));
			textPaneNum.setText(((Articulo)p).getArbitros().get(0));
		}
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("T\u00EDtulo:");
			lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblNewLabel.setBounds(51, 93, 159, 32);
		}
		return lblNewLabel;
	}
	private JTextPane getTextPaneTitulo() {
		if (textPaneTitulo == null) {
			textPaneTitulo = new JTextPane();
			textPaneTitulo.setForeground(SystemColor.infoText);
			textPaneTitulo.setEditable(false);
			textPaneTitulo.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneTitulo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneTitulo.setBounds(51, 136, 363, 32);
		}
		return textPaneTitulo;
	}
	private JLabel getLblCarnetUsuario() {
		if (lblCarnetUsuario == null) {
			lblCarnetUsuario = new JLabel("Identificador");
			lblCarnetUsuario.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblCarnetUsuario.setBounds(51, 193, 159, 32);
		}
		return lblCarnetUsuario;
	}
	private JLabel getLblPenalizacin() {
		if (lblPenalizacin == null) {
			lblPenalizacin = new JLabel("Materia:");
			lblPenalizacin.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblPenalizacin.setBounds(51, 358, 110, 32);
		}
		return lblPenalizacin;
	}
	private JTextPane getTextPaneId() {
		if (textPaneId == null) {
			textPaneId = new JTextPane();
			textPaneId.setForeground(SystemColor.infoText);
			textPaneId.setEditable(false);
			textPaneId.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneId.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneId.setBounds(51, 236, 363, 32);
		}
		return textPaneId;
	}
	private JTextPane getTextPaneMateria() {
		if (textPaneMateria == null) {
			textPaneMateria = new JTextPane();
			textPaneMateria.setForeground(SystemColor.infoText);
			textPaneMateria.setEditable(false);
			textPaneMateria.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneMateria.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneMateria.setBounds(51, 401, 363, 32);
		}
		return textPaneMateria;
	}
	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("P\u00E1ginas:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblEdad.setBounds(51, 299, 97, 32);
		}
		return lblEdad;
	}
	private JTextPane getTextPanePag() {
		if (textPanePag == null) {
			textPanePag = new JTextPane();
			textPanePag.setForeground(SystemColor.infoText);
			textPanePag.setEditable(false);
			textPanePag.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPanePag.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPanePag.setBounds(138, 299, 55, 32);
		}
		return textPanePag;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Ejemplares:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblSexo.setBounds(236, 299, 110, 32);
		}
		return lblSexo;
	}
	private JTextPane getTextPaneEjemp() {
		if (textPaneEjemp == null) {
			textPaneEjemp = new JTextPane();
			textPaneEjemp.setForeground(SystemColor.infoText);
			textPaneEjemp.setEditable(false);
			textPaneEjemp.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneEjemp.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneEjemp.setBounds(348, 299, 66, 32);
		}
		return textPaneEjemp;
	}
	private JPanel getPanelLibro() {
		if (panelLibro == null) {
			panelLibro = new JPanel();
			panelLibro.setBackground(Color.WHITE);
			panelLibro.setLayout(null);
			panelLibro.add(getTextPaneAutor());
			panelLibro.add(getLblAutor());
			panelLibro.add(getTextPaneEditorial());
			panelLibro.add(getLblEditorial());
			panelLibro.setVisible(false);
		}
		return panelLibro;
	}
	private JTextPane getTextPaneAutor() {
		if (textPaneAutor == null) {
			textPaneAutor = new JTextPane();
			textPaneAutor.setText((String) null);
			textPaneAutor.setForeground(Color.BLACK);
			textPaneAutor.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneAutor.setEditable(false);
			textPaneAutor.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneAutor.setBounds(21, 54, 363, 32);
		}
		return textPaneAutor;
	}
	private JLabel getLblAutor() {
		if (lblAutor == null) {
			lblAutor = new JLabel("Autor:");
			lblAutor.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblAutor.setBounds(21, 11, 159, 32);
		}
		return lblAutor;
	}
	private JTextPane getTextPaneEditorial() {
		if (textPaneEditorial == null) {
			textPaneEditorial = new JTextPane();
			textPaneEditorial.setText((String) null);
			textPaneEditorial.setForeground(Color.BLACK);
			textPaneEditorial.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneEditorial.setEditable(false);
			textPaneEditorial.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneEditorial.setBounds(21, 154, 363, 32);
		}
		return textPaneEditorial;
	}
	private JLabel getLblEditorial() {
		if (lblEditorial == null) {
			lblEditorial = new JLabel("Editorial:");
			lblEditorial.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblEditorial.setBounds(21, 111, 159, 32);
		}
		return lblEditorial;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(463, 81, 405, 211);
			panel_1.setLayout(new CardLayout(0, 0));
			panel_1.add(getPanelLibro(), "name_3391828322917800");
			panel_1.add(getPanelRevista(), "name_3391892751200100");
			panel_1.add(getPanel(), "name_3391964751124700");
		}
		return panel_1;
	}
	private JPanel getPanelRevista() {
		if (panelRevista == null) {
			panelRevista = new JPanel();
			panelRevista.setBackground(Color.WHITE);
			panelRevista.setLayout(null);
			panelRevista.add(getTextPane_2());
			panelRevista.add(getTextPane_3());
			panelRevista.add(getLblAutor_1());
			panelRevista.add(getLblrbitro());
			panelRevista.setVisible(false);
		}
		return panelRevista;
	}
	private JTextPane getTextPane_2() {
		if (textPane_2 == null) {
			textPane_2 = new JTextPane();
			textPane_2.setText((String) null);
			textPane_2.setForeground(Color.BLACK);
			textPane_2.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPane_2.setEditable(false);
			textPane_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPane_2.setBounds(21, 54, 363, 32);
		}
		return textPane_2;
	}
	private JTextPane getTextPane_3() {
		if (textPane_3 == null) {
			textPane_3 = new JTextPane();
			textPane_3.setText((String) null);
			textPane_3.setForeground(Color.BLACK);
			textPane_3.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPane_3.setEditable(false);
			textPane_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPane_3.setBounds(21, 153, 363, 32);
		}
		return textPane_3;
	}
	private JLabel getLblAutor_1() {
		if (lblAutor_1 == null) {
			lblAutor_1 = new JLabel("Autor:");
			lblAutor_1.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblAutor_1.setBounds(21, 11, 110, 32);
		}
		return lblAutor_1;
	}
	private JLabel getLblrbitro() {
		if (lblrbitro == null) {
			lblrbitro = new JLabel("\u00C1rbitro:");
			lblrbitro.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblrbitro.setBounds(21, 110, 110, 32);
		}
		return lblrbitro;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.add(getLblAo());
			panel.add(getTextPaneAnnio());
			panel.add(getLblNmero());
			panel.add(getTextPaneNum());
			panel.setVisible(false);
		}
		return panel;
	}
	private JLabel getLblAo() {
		if (lblAo == null) {
			lblAo = new JLabel("A\u00F1o de publicaci\u00F3n:");
			lblAo.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblAo.setBounds(21, 10, 238, 32);
		}
		return lblAo;
	}
	private JTextPane getTextPaneAnnio() {
		if (textPaneAnnio == null) {
			textPaneAnnio = new JTextPane();
			textPaneAnnio.setText((String) null);
			textPaneAnnio.setForeground(Color.BLACK);
			textPaneAnnio.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneAnnio.setEditable(false);
			textPaneAnnio.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneAnnio.setBounds(21, 53, 340, 32);
		}
		return textPaneAnnio;
	}
	private JLabel getLblNmero() {
		if (lblNmero == null) {
			lblNmero = new JLabel("N\u00FAmero de revista:");
			lblNmero.setFont(new Font("SansSerif", Font.PLAIN, 19));
			lblNmero.setBounds(21, 109, 176, 32);
		}
		return lblNmero;
	}
	private JTextPane getTextPaneNum() {
		if (textPaneNum == null) {
			textPaneNum = new JTextPane();
			textPaneNum.setText((String) null);
			textPaneNum.setForeground(Color.BLACK);
			textPaneNum.setFont(new Font("SansSerif", Font.PLAIN, 18));
			textPaneNum.setEditable(false);
			textPaneNum.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			textPaneNum.setBounds(21, 152, 340, 32);
		}
		return textPaneNum;
	}
	private JLabel getLabelTipo() {
		if (labelTipo == null) {
			labelTipo = new JLabel("");
			labelTipo.setFont(new Font("SansSerif", Font.PLAIN, 19));
			labelTipo.setBounds(51, 22, 159, 32);
		}
		return labelTipo;
	}
}
