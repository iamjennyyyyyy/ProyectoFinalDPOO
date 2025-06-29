package Visual;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class PanelInicio extends JPanel {

	private final JPanel contentPanel;
	private JLabel lblNewLabel_3;
	private JTextPane txtpnbienvenidoAlSistema;
	private JTextPane txtpnOptimizacinControlY;
	private JTextPane txtpnEsteSistemaHa;
	private JTextPane txtpnElFlujoDe;
	private JTextPane txtpnElRegistroY;
	private PanelUsuario p;
	private JTextPane txtpnLaAdministracinDe;
	private JTextPane txtpnLaGeneracinDe;
	private JLabel lblLibro;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Create the panel.
	 */
	public PanelInicio() {

		contentPanel = new JPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBounds(338, 138, 1028, 559);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNewLabel_3());
		contentPanel.add(getTxtpnbienvenidoAlSistema());
		contentPanel.add(getTxtpnOptimizacinControlY());
		contentPanel.add(getTxtpnEsteSistemaHa());
		contentPanel.add(getTxtpnElFlujoDe());
		contentPanel.add(getTxtpnElRegistroY());
		contentPanel.add(getTxtpnLaAdministracinDe());
		contentPanel.add(getTxtpnLaGeneracinDe());
		contentPanel.add(getLblLibro());
		contentPanel.add(getLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
	}
	private JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setIcon(new ImageIcon("src/images/iconos/persona3.jpg"));
			lblNewLabel_3.setBounds(625, 49, 393, 460);
		}
		return lblNewLabel_3;
	}
	private JTextPane getTxtpnbienvenidoAlSistema() {
		if (txtpnbienvenidoAlSistema == null) {
			txtpnbienvenidoAlSistema = new JTextPane();
			txtpnbienvenidoAlSistema.setFocusable(false);
			txtpnbienvenidoAlSistema.setBackground(Color.WHITE);
			txtpnbienvenidoAlSistema.setEditable(false);
			txtpnbienvenidoAlSistema.setText("\u00A1Bienvenido al Sistema de Gesti\u00F3n Bibliotecaria!");
			txtpnbienvenidoAlSistema.setFont(new Font("Sylfaen", Font.PLAIN, 28));
			txtpnbienvenidoAlSistema.setBounds(39, 32, 574, 62);
		}
		return txtpnbienvenidoAlSistema;
	}
	private JTextPane getTxtpnOptimizacinControlY() {
		if (txtpnOptimizacinControlY == null) {
			txtpnOptimizacinControlY = new JTextPane();
			txtpnOptimizacinControlY.setFocusable(false);
			txtpnOptimizacinControlY.setBackground(Color.WHITE);
			txtpnOptimizacinControlY.setEditable(false);
			txtpnOptimizacinControlY.setFont(new Font("Sylfaen", Font.ITALIC, 19));
			txtpnOptimizacinControlY.setText("Optimizaci\u00F3n, control y acceso eficiente al conocimiento.");
			txtpnOptimizacinControlY.setBounds(39, 100, 562, 39);
		}
		return txtpnOptimizacinControlY;
	}
	private JTextPane getTxtpnEsteSistemaHa() {
		if (txtpnEsteSistemaHa == null) {
			txtpnEsteSistemaHa = new JTextPane();
			txtpnEsteSistemaHa.setFocusable(false);
			txtpnEsteSistemaHa.setBackground(Color.WHITE);
			txtpnEsteSistemaHa.setEditable(false);
			txtpnEsteSistemaHa.setText("Este sistema ha sido dise\u00F1ado para modernizar y facilitar la administraci\u00F3n de las bibliotecas municipales en todo el pa\u00EDs.\nAqu\u00ED podr\u00E1 gestionar de manera r\u00E1pida, intuitiva y segura:");
			txtpnEsteSistemaHa.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnEsteSistemaHa.setBounds(39, 150, 562, 104);
		}
		return txtpnEsteSistemaHa;
	}
	private JTextPane getTxtpnElFlujoDe() {
		if (txtpnElFlujoDe == null) {
			txtpnElFlujoDe = new JTextPane();
			txtpnElFlujoDe.setFocusable(false);
			txtpnElFlujoDe.setBackground(Color.WHITE);
			txtpnElFlujoDe.setEditable(false);
			txtpnElFlujoDe.setText("El flujo de pr\u00E9stamos, pr\u00F3rrogas y devoluciones");
			txtpnElFlujoDe.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnElFlujoDe.setBounds(74, 252, 470, 32);
		}
		return txtpnElFlujoDe;
	}
	private JTextPane getTxtpnElRegistroY() {
		if (txtpnElRegistroY == null) {
			txtpnElRegistroY = new JTextPane();
			txtpnElRegistroY.setFocusable(false);
			txtpnElRegistroY.setBackground(Color.WHITE);
			txtpnElRegistroY.setEditable(false);
			txtpnElRegistroY.setText("El registro y control de usuarios acreditados");
			txtpnElRegistroY.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnElRegistroY.setBounds(74, 305, 470, 32);
		}
		return txtpnElRegistroY;
	}
	private JTextPane getTxtpnLaAdministracinDe() {
		if (txtpnLaAdministracinDe == null) {
			txtpnLaAdministracinDe = new JTextPane();
			txtpnLaAdministracinDe.setFocusable(false);
			txtpnLaAdministracinDe.setBackground(Color.WHITE);
			txtpnLaAdministracinDe.setEditable(false);
			txtpnLaAdministracinDe.setText("La administraci\u00F3n de publicaciones, trabajadores y recursos");
			txtpnLaAdministracinDe.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnLaAdministracinDe.setBounds(74, 367, 535, 32);
		}
		return txtpnLaAdministracinDe;
	}
	private JTextPane getTxtpnLaGeneracinDe() {
		if (txtpnLaGeneracinDe == null) {
			txtpnLaGeneracinDe = new JTextPane();
			txtpnLaGeneracinDe.setFocusable(false);
			txtpnLaGeneracinDe.setBackground(Color.WHITE);
			txtpnLaGeneracinDe.setEditable(false);
			txtpnLaGeneracinDe.setText("La generaci\u00F3n de reportes detallados y estad\u00EDsticas");
			txtpnLaGeneracinDe.setFont(new Font("Sylfaen", Font.PLAIN, 19));
			txtpnLaGeneracinDe.setBounds(74, 430, 470, 32);
		}
		return txtpnLaGeneracinDe;
	}
	private JLabel getLblLibro() {
		if (lblLibro == null) {
			lblLibro = new JLabel("");
			lblLibro.setIcon(new ImageIcon("src/images/iconos/libros.png"));
			lblLibro.setBounds(39, 259, 25, 25);
		}
		return lblLibro;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("src/images/iconos/libroa.png"));
			label.setBounds(39, 312, 25, 25);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("src/images/iconos/gente.png"));
			label_1.setBounds(39, 374, 25, 25);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon("src/images/iconos/aumento.png"));
			label_2.setBounds(39, 437, 25, 25);
		}
		return label_2;
	}

}
