package Visual;

import java.awt.EventQueue;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import Inicializadora.Inicializar;
import Logica.Biblioteca;
import Logica.UsuarioAcreditado;
import Utiles.Colores;
import Utiles.MiPersonalizacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.CardLayout;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;

import sun.applet.Main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ComponentOrientation;

import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;

public class Principal extends JFrame {

	private JPanel contentPane;
	Biblioteca b = Biblioteca.getInstancia();
	private JPanel panelLateral;
	private JButton button_2;
	private JLabel lblNewLabel;
	private JButton button;
	private JButton button_1;
	private JButton button_3;
	private JButton button_4;
	private JLabel lblGestin;
	private JLabel lblReportes;
	private JLabel lblAcercaDe;
	private JPanel panelSup;
	private JPopupMenu popupMenuGestion;
	private JMenuItem mntmUsuario_1;
	private JMenuItem mntmTrabajador_1;
	private JMenuItem mntmPublicacin;
	private JMenuItem mntmPrstamo;
	private JMenu mnNewMenu;
	private JMenuItem mntmUsuario_2;
	private JMenuItem mntmTrabajador_2;
	private JMenuItem mntmPublicacin_1;
	private JMenuItem mntmPrstamo_1;
	private JLabel lblNewLabel_1;
	private JLabel lblBiblio;
	private JLabel lblNewLabel_2;
	private JLabel lblAjustes;
	private JPanel panelInicio;
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
	private JLabel labelFecha;
	private JLabel labelDia;

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
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Principal() {

		//		// Personalizar cursor (después de inicializar los componentes)
		//		try {
		//			Image cursorImg = new ImageIcon("src/images/iconos/Cursorr32x32.png").getImage();
		//			Point hotspot = new Point(5, 5); // Ajusta según tu imagen
		//			Cursor customCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		//					cursorImg, hotspot, "Custom");
		//
		//			// Aplicar a todo el JDialog
		//			setCursor(customCursor);
		//
		//			// Opcional: Restaurar cursor predeterminado al salir
		//			addWindowListener(new WindowAdapter() {
		//				public void windowClosed(WindowEvent e) {
		//					setCursor(Cursor.getDefaultCursor());
		//				}
		//			});
		//		} catch (Exception e) {
		//			System.err.println("Error al cargar cursor personalizado");
		//		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setLayout(null);
		contentPane.add(getPanelLateral());
		contentPane.add(getPanelSup());
		contentPane.add(getPanelInicio());
		setBounds(0, 0, 1382, 747);
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanelLateral());
		contentPane.add(getPanelSup());
		contentPane.add(getMnNewMenu());
	}
	private JPanel getPanelLateral() {
		if (panelLateral == null) {
			panelLateral = new JPanel();
			panelLateral.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelLateral.setBounds(0, 0, 339, 699);
			panelLateral.setBackground(Colores.getBeigetabla());
			panelLateral.setLayout(null);
			panelLateral.add(getLblAjustes());
			panelLateral.add(getLblAcercaDe());
			panelLateral.add(getLblReportes());
			panelLateral.add(getLblGestin());
			panelLateral.add(getLblNewLabel());
			panelLateral.add(getButton_2());
			panelLateral.add(getButton());
			panelLateral.add(getButton_1());
			panelLateral.add(getButton_3());
			panelLateral.add(getButton_4());
			panelLateral.add(getLblNewLabel_1());
			panelLateral.add(getLblBiblio());
			panelLateral.add(getLblNewLabel_2());
		}
		return panelLateral;
	}

	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton("");
			button_2.setBackground(Colores.getBeigetabla());
			button_2.setBorder(null);
			button_2.setFont(new Font("SansSerif", Font.PLAIN, 20));
			button_2.setBounds(0, 203, 338, 70);
		}
		return button_2;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sesi\u00F3n");
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblNewLabel.setBounds(58, 221, 112, 40);
		}
		return lblNewLabel;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int xPos = button.getWidth() - popupMenuGestion.getPreferredSize().width;
					int yPos = popupMenuGestion.getPreferredSize().height;
					popupMenuGestion.show(button, xPos, yPos);
				}
			});
			button.setFont(new Font("SansSerif", Font.PLAIN, 20));
			button.setBorder(null);
			button.setBackground(Colores.getBeigetabla());
			button.setBounds(0, 271, 338, 70);
			addPopup(button, getPopupMenuGestion());
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("");
			button_1.setFont(new Font("SansSerif", Font.PLAIN, 20));
			button_1.setBorder(null);
			button_1.setBackground(Colores.getBeigetabla());
			button_1.setBounds(0, 338, 338, 70);
		}
		return button_1;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("");
			button_3.setFont(new Font("SansSerif", Font.PLAIN, 20));
			button_3.setBorder(null);
			button_3.setBackground(Colores.getBeigetabla());
			button_3.setBounds(0, 406, 338, 70);
		}
		return button_3;
	}
	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("");
			button_4.setFont(new Font("SansSerif", Font.PLAIN, 20));
			button_4.setBorder(null);
			button_4.setBackground(Colores.getBeigetabla());
			button_4.setBounds(0, 475, 338, 70);
		}
		return button_4;
	}
	private JLabel getLblGestin() {
		if (lblGestin == null) {
			lblGestin = new JLabel("Gesti\u00F3n");
			lblGestin.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblGestin.setBounds(58, 288, 112, 40);
		}
		return lblGestin;
	}
	private JLabel getLblReportes() {
		if (lblReportes == null) {
			lblReportes = new JLabel("Reportes");
			lblReportes.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblReportes.setBounds(58, 356, 112, 40);
		}
		return lblReportes;
	}
	private JLabel getLblAcercaDe() {
		if (lblAcercaDe == null) {
			lblAcercaDe = new JLabel("Acerca de");
			lblAcercaDe.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblAcercaDe.setBounds(58, 423, 141, 40);
		}
		return lblAcercaDe;
	}
	private JPanel getPanelSup() {
		if (panelSup == null) {
			panelSup = new JPanel();
			panelSup.setBorder(new LineBorder(new Color(0, 0, 0)));
			//panelSup.setBackground(Colores.getcolorPaneles());
			panelSup.setBackground(Colores.getFondo());
			panelSup.setBounds(338, 0, 1028, 138);
			panelSup.setLayout(null);
			panelSup.add(getLabelFecha());
			panelSup.add(getLabelDia());
		}
		return panelSup;
	}
	private JPopupMenu getPopupMenuGestion() {
		if (popupMenuGestion == null) {
			popupMenuGestion = new JPopupMenu();
			popupMenuGestion.setAlignmentY(Component.BOTTOM_ALIGNMENT);
			popupMenuGestion.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			popupMenuGestion.setLocation(new Point(339, 0));
			popupMenuGestion.setVisible(true);
			popupMenuGestion.add(getMntmUsuario_1());
			popupMenuGestion.add(getMntmTrabajador_1());
			popupMenuGestion.add(getMntmPublicacin());
			popupMenuGestion.add(getMntmPrstamo());
		}
		return popupMenuGestion;
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private JMenuItem getMntmUsuario_1() {
		if (mntmUsuario_1 == null) {
			mntmUsuario_1 = new JMenuItem("Usuario");
			mntmUsuario_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionUsuario m = new GestionUsuario();
					m.setVisible(true);
				}
			});
		}
		return mntmUsuario_1;
	}
	private JMenuItem getMntmTrabajador_1() {
		if (mntmTrabajador_1 == null) {
			mntmTrabajador_1 = new JMenuItem("Trabajador");
			mntmTrabajador_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionTrabajador2 u = new GestionTrabajador2();
					u.setVisible(true);
				}
			});
		}
		return mntmTrabajador_1;
	}
	private JMenuItem getMntmPublicacin() {
		if (mntmPublicacin == null) {
			mntmPublicacin = new JMenuItem("Publicaci\u00F3n");
			mntmPublicacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionPublicacion p = new GestionPublicacion();
					p.setVisible(true);
				}
			});
		}
		return mntmPublicacin;
	}
	private JMenuItem getMntmPrstamo() {
		if (mntmPrstamo == null) {
			mntmPrstamo = new JMenuItem("Pr\u00E9stamo");
			mntmPrstamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionPrestamo g = new GestionPrestamo();
					g.setVisible(true);
				}
			});
		}
		return mntmPrstamo;
	}
	private JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("New menu");
			mnNewMenu.setBounds(0, 238, 339, 70);
			mnNewMenu.add(getMntmUsuario_2());
			mnNewMenu.add(getMntmTrabajador_2());
			mnNewMenu.add(getMntmPublicacin_1());
			mnNewMenu.add(getMntmPrstamo_1());
		}
		return mnNewMenu;
	}
	private JMenuItem getMntmUsuario_2() {
		if (mntmUsuario_2 == null) {
			mntmUsuario_2 = new JMenuItem("Usuario");
		}
		return mntmUsuario_2;
	}
	private JMenuItem getMntmTrabajador_2() {
		if (mntmTrabajador_2 == null) {
			mntmTrabajador_2 = new JMenuItem("Trabajador");
		}
		return mntmTrabajador_2;
	}
	private JMenuItem getMntmPublicacin_1() {
		if (mntmPublicacin_1 == null) {
			mntmPublicacin_1 = new JMenuItem("Publicaci\u00F3n");
		}
		return mntmPublicacin_1;
	}
	private JMenuItem getMntmPrstamo_1() {
		if (mntmPrstamo_1 == null) {
			mntmPrstamo_1 = new JMenuItem("Pr\u00E9stamo");
		}
		return mntmPrstamo_1;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Tech");
			lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 53));
			lblNewLabel_1.setBounds(189, 79, 127, 70);
		}
		return lblNewLabel_1;
	}
	private JLabel getLblBiblio() {
		if (lblBiblio == null) {
			lblBiblio = new JLabel("BIBLIO");
			lblBiblio.setFont(new Font("Segoe UI", Font.PLAIN, 48));
			lblBiblio.setBounds(58, 11, 153, 70);
		}
		return lblBiblio;
	}
	private JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("");
			lblNewLabel_2.setBackground(Colores.getBeigetabla());
			lblNewLabel_2.setIcon(new ImageIcon("src/images/iconos/l2.jpg"));
			lblNewLabel_2.setBounds(29, 97, 150, 95);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblAjustes() {
		if (lblAjustes == null) {
			lblAjustes = new JLabel("Ajustes");
			lblAjustes.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblAjustes.setBounds(58, 487, 141, 40);
		}
		return lblAjustes;
	}
	private JPanel getPanelInicio() {
		if (panelInicio == null) {
			panelInicio = new JPanel();
			panelInicio.setBackground(Color.WHITE);
			panelInicio.setBounds(340, 138, 1026, 559);
			panelInicio.setLayout(null);
			panelInicio.add(getLblNewLabel_3());
			panelInicio.add(getTxtpnbienvenidoAlSistema());
			panelInicio.add(getTxtpnOptimizacinControlY());
			panelInicio.add(getTxtpnEsteSistemaHa());
			panelInicio.add(getTxtpnElFlujoDe());
			panelInicio.add(getTxtpnElRegistroY());
			panelInicio.add(getTxtpnLaAdministracinDe());
			panelInicio.add(getTxtpnLaGeneracinDe());
			panelInicio.add(getLblLibro());
			panelInicio.add(getLabel());
			panelInicio.add(getLabel_1());
			panelInicio.add(getLabel_2());
		}
		return panelInicio;
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
			txtpnbienvenidoAlSistema.setBounds(62, 32, 574, 62);
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
			txtpnOptimizacinControlY.setBounds(62, 100, 562, 39);
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
			txtpnEsteSistemaHa.setBounds(62, 150, 562, 104);
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
			txtpnElFlujoDe.setBounds(97, 252, 470, 32);
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
			txtpnElRegistroY.setBounds(97, 305, 470, 32);
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
			txtpnLaAdministracinDe.setBounds(97, 367, 535, 32);
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
			txtpnLaGeneracinDe.setBounds(97, 430, 470, 32);
		}
		return txtpnLaGeneracinDe;
	}
	private JLabel getLblLibro() {
		if (lblLibro == null) {
			lblLibro = new JLabel("");
			lblLibro.setIcon(new ImageIcon("src/images/iconos/libros.png"));
			lblLibro.setBounds(62, 259, 25, 25);
		}
		return lblLibro;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("src/images/iconos/libroa.png"));
			label.setBounds(62, 312, 25, 25);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon("src/images/iconos/gente.png"));
			label_1.setBounds(62, 374, 25, 25);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon("src/images/iconos/aumento.png"));
			label_2.setBounds(62, 437, 25, 25);
		}
		return label_2;
	}

	private JLabel getLabelFecha() {
		if (labelFecha == null) {
			labelFecha = new JLabel();
			String dia = obtenerDiaEnEspanol(LocalDate.now().getDayOfWeek().toString());
			labelFecha.setText("Hoy es " + dia);
			labelFecha.setFont(new Font("Sylfaen", Font.PLAIN, 32));
			labelFecha.setBounds(103, 11, 346, 57);
		}
		return labelFecha;
	}
	
	public String obtenerDiaEnEspanol(String dia){
		String diaa = "";
		
		if(dia.equals("MONDAY"))
			diaa = "lunes";
		else if(dia.equals("TUESDAY"))
			diaa = "martes";
		else if(dia.equals("WEDNESDAY"))
			diaa = "miércoles";
		else if(dia.equals("THURSDAY"))
			diaa = "jueves";
		else if(dia.equals("FRIDAY"))
			diaa = "viernes";
		else if(dia.equals("SATURDAY"))
			diaa = "sábado";
		else if(dia.equals("SUNDAY"))
			diaa = "domingo";
		return diaa;
	}
	
	public String obtenerMesEnEspanol(String mess){
		String mes = "";
		
		if(mess.equals("JANUARY"))
			mes = "enero";
		if(mess.equals("FEBRUARY"))
			mes = "febrero";
		if(mess.equals("MARCH"))
			mes = "marzo";
		if(mess.equals("APRIL"))
			mes = "abril";
		if(mess.equals("MAY"))
			mes = "mayo";
		if(mess.equals("JUNE"))
			mes = "junio";
		if(mess.equals("JULY"))
			mes = "julio";
		if(mess.equals("AUGUST"))
			mes = "agosto";
		if(mess.equals("SEPTEMBER"))
			mes = "septiembre";
		if(mess.equals("OCTOBER"))
			mes = "octubre";
		if(mess.equals("NOVEMBER"))
			mes = "noviembre";
		if(mess.equals("DECEMBER"))
			mes = "diciembre";
		return mes;
	}
	
	
	private JLabel getLabelDia() {
		if (labelDia == null) {
			labelDia = new JLabel();
			String mes = obtenerMesEnEspanol(LocalDate.now().getMonth().toString());
			labelDia.setText(LocalDate.now().getDayOfMonth() + " de " + mes + " del " + LocalDate.now().getYear());
			labelDia.setFont(new Font("Segoe UI", Font.ITALIC, 32));
			labelDia.setBounds(224, 53, 346, 57);
		}
		return labelDia;
	}
}
