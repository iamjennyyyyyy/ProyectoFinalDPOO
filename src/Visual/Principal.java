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
import Logica.Publicacion;
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
import java.util.ArrayList;
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
	private JButton btnSesion;
	private JLabel lblNewLabel;
	private JButton btnGestion;
	private JButton btnReportes;
	private JButton btnAcerca;
	private JButton btnAjustes;
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
	private JTextPane txtpnLaAdministracinDe;
	private JTextPane txtpnLaGeneracinDe;
	private JLabel lblLibro;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel labelFecha;
	private JLabel labelDia;
	private JPopupMenu popupMenuReportes;
	private JMenuItem mntmMateriasAs;
	private JMenuItem mntmPrstamosPrximosA;
	private JMenuItem mntmHistorialDePrstamos;
	private JMenuItem mntmUsuariosMsConcurrentes;
	private JButton btnGaleria;
	private JLabel lblGalera;
	private JLabel labelRuta;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JPopupMenu popupMenuSesion;
	private JMenuItem mntmCerrarSesin;
	private JMenuItem mntmSalir;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Principal() {
		setBackground(new Color(245, 245, 220));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/icons8-literature-50.png"));
		setTitle("BiblioTech Corp.");
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
			panelLateral.add(getLabel_4());
			panelLateral.add(getLabel_7());
			panelLateral.add(getLabel_8());
			panelLateral.add(getLabel_5());
			panelLateral.add(getLabel_6());
			panelLateral.add(getLabel_3());
			panelLateral.add(getLblGalera());
			panelLateral.add(getLblAjustes());
			panelLateral.add(getLblAcercaDe());
			panelLateral.add(getLblReportes());
			panelLateral.add(getLblGestin());
			panelLateral.add(getLblNewLabel());
			panelLateral.add(getBtnSesion());
			panelLateral.add(getBtnGestion());
			panelLateral.add(getBtnReportes());
			panelLateral.add(getBtnAcerca());
			panelLateral.add(getBtnAjustes());
			panelLateral.add(getLblNewLabel_1());
			panelLateral.add(getLblBiblio());
			panelLateral.add(getLblNewLabel_2());
			panelLateral.add(getBtnGaleria());
		}
		return panelLateral;
	}

	private JButton getBtnSesion() {
		if (btnSesion == null) {
			btnSesion = new JButton("");
			btnSesion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int x = btnSesion.getWidth() + 1;
				    int y = 0;
					popupMenuSesion.show(btnSesion, x, y);
				}
			});
			btnSesion.setBackground(Colores.getBeigetabla());
			btnSesion.setBorder(null);
			btnSesion.setFont(new Font("SansSerif", Font.PLAIN, 20));
			btnSesion.setBounds(0, 185, 338, 70);
			addPopup(btnSesion, getPopupMenuSesion());
		}
		return btnSesion;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Sesi\u00F3n");
			lblNewLabel.setForeground(Color.BLACK);
			lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblNewLabel.setBounds(70, 203, 112, 40);
		}
		return lblNewLabel;
	}
	private JButton getBtnGestion() {
		if (btnGestion == null) {
			btnGestion = new JButton("");
			btnGestion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int x = btnGestion.getWidth() + 1;
				    int y = 0;
					popupMenuGestion.show(btnGestion, x, y);
				}
			});
			btnGestion.setFont(new Font("SansSerif", Font.PLAIN, 20));
			btnGestion.setBorder(null);
			btnGestion.setBackground(Colores.getBeigetabla());
			btnGestion.setBounds(0, 253, 338, 70);
			addPopup(btnGestion, getPopupMenuGestion());
		}
		return btnGestion;
	}
	private JButton getBtnReportes() {
		if (btnReportes == null) {
			btnReportes = new JButton("");
			btnReportes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int x = btnReportes.getWidth() + 1;
				    int y = 0;
					popupMenuReportes.show(btnReportes, x, y);
				}
			});
			btnReportes.setFont(new Font("SansSerif", Font.PLAIN, 20));
			btnReportes.setBorder(null);
			btnReportes.setBackground(Colores.getBeigetabla());
			btnReportes.setBounds(0, 320, 338, 70);
			addPopup(btnReportes, getPopupMenuReportes());
		}
		return btnReportes;
	}
	private JButton getBtnAcerca() {
		if (btnAcerca == null) {
			btnAcerca = new JButton("");
			btnAcerca.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					labelRuta.setText("Acerca de Nosotros");
					lblAcercaDe.setForeground(Colores.getCruds());
					AcercaDe a = new AcercaDe();
					a.setVisible(true);
					labelRuta.setText("");
					lblAcercaDe.setForeground(Color.BLACK);
				}
			});
			btnAcerca.setFont(new Font("SansSerif", Font.PLAIN, 20));
			btnAcerca.setBorder(null);
			btnAcerca.setBackground(Colores.getBeigetabla());
			btnAcerca.setBounds(0, 458, 338, 70);
		}
		return btnAcerca;
	}
	private JButton getBtnAjustes() {
		if (btnAjustes == null) {
			btnAjustes = new JButton("");
			btnAjustes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblAjustes.setForeground(Colores.getCruds());
					JOptionPane.showMessageDialog(null, "Esta es la sección de ajustes. Se planea implementarla en un futuro, con algo más de tiempo. Lamentamos las molestias", "Información", JOptionPane.INFORMATION_MESSAGE);
					lblAjustes.setForeground(Color.BLACK);
				}
			});
			btnAjustes.setFont(new Font("SansSerif", Font.PLAIN, 20));
			btnAjustes.setBorder(null);
			btnAjustes.setBackground(Colores.getBeigetabla());
			btnAjustes.setBounds(0, 527, 338, 70);
		}
		return btnAjustes;
	}
	private JLabel getLblGestin() {
		if (lblGestin == null) {
			lblGestin = new JLabel("Gesti\u00F3n");
			lblGestin.setForeground(Color.BLACK);
			lblGestin.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblGestin.setBounds(70, 270, 112, 40);
		}
		return lblGestin;
	}
	private JLabel getLblReportes() {
		if (lblReportes == null) {
			lblReportes = new JLabel("Reportes");
			lblReportes.setForeground(Color.BLACK);
			lblReportes.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblReportes.setBounds(70, 338, 112, 40);
		}
		return lblReportes;
	}
	private JLabel getLblAcercaDe() {
		if (lblAcercaDe == null) {
			lblAcercaDe = new JLabel("Acerca de");
			lblAcercaDe.setForeground(Color.BLACK);
			lblAcercaDe.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblAcercaDe.setBounds(70, 475, 141, 40);
		}
		return lblAcercaDe;
	}
	private JPanel getPanelSup() {
		if (panelSup == null) {
			panelSup = new JPanel();
			panelSup.setBorder(new LineBorder(new Color(0, 0, 0)));
			panelSup.setBackground(Colores.getFondo());
			panelSup.setBounds(338, 0, 1028, 138);
			panelSup.setLayout(null);
			panelSup.add(getLabelFecha());
			panelSup.add(getLabelDia());
			panelSup.add(getLabelRuta());
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
			mntmUsuario_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmUsuario_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					labelRuta.setText("Gestión / Usuario");
					lblGestin.setForeground(Colores.getCruds());
					GestionUsuario m = new GestionUsuario();
					m.setVisible(true);
					lblGestin.setForeground(Color.BLACK);
					labelRuta.setText("");
				}
			});
		}
		return mntmUsuario_1;
	}
	private JMenuItem getMntmTrabajador_1() {
		if (mntmTrabajador_1 == null) {
			mntmTrabajador_1 = new JMenuItem("Trabajador");
			mntmTrabajador_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmTrabajador_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblGestin.setForeground(Colores.getCruds());
					labelRuta.setText("Gestión / Trabajador");
					GestionTrabajador2 u = new GestionTrabajador2();
					u.setVisible(true);
					lblGestin.setForeground(Color.BLACK);
				}
			});
		}
		return mntmTrabajador_1;
	}
	private JMenuItem getMntmPublicacin() {
		if (mntmPublicacin == null) {
			mntmPublicacin = new JMenuItem("Publicaci\u00F3n");
			mntmPublicacin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmPublicacin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblGestin.setForeground(Colores.getCruds());
					labelRuta.setText("Gestión / Publicación");
					GestionPublicacion p = new GestionPublicacion();
					p.setVisible(true);
					lblGestin.setForeground(Color.BLACK);
					labelRuta.setText("");
				}
			});
		}
		return mntmPublicacin;
	}
	private JMenuItem getMntmPrstamo() {
		if (mntmPrstamo == null) {
			mntmPrstamo = new JMenuItem("Pr\u00E9stamo");
			mntmPrstamo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmPrstamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					labelRuta.setText("Gestión / Préstamo");
					lblGestin.setForeground(Colores.getCruds());
					GestionPrestamo g = new GestionPrestamo();
					g.setVisible(true);
					labelRuta.setText("");
					lblGestin.setForeground(Color.BLACK);
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
			lblNewLabel_1.setBounds(147, 78, 127, 70);
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
			lblNewLabel_2.setVisible(false);
			lblNewLabel_2.setBackground(Colores.getBeigetabla());
			lblNewLabel_2.setIcon(new ImageIcon("src/images/iconos/l2.jpg"));
			lblNewLabel_2.setBounds(29, 97, 150, 95);
		}
		return lblNewLabel_2;
	}
	private JLabel getLblAjustes() {
		if (lblAjustes == null) {
			lblAjustes = new JLabel("Ajustes");
			lblAjustes.setForeground(Color.BLACK);
			lblAjustes.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblAjustes.setBounds(70, 539, 141, 40);
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
			labelFecha.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			labelFecha.setBounds(551, 11, 346, 57);
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
			labelDia.setFont(new Font("Segoe UI", Font.ITALIC, 30));
			labelDia.setBounds(672, 53, 346, 57);
		}
		return labelDia;
	}
	private JPopupMenu getPopupMenuReportes() {
		if (popupMenuReportes == null) {
			popupMenuReportes = new JPopupMenu();
			popupMenuReportes.add(getMntmMateriasAs());
			popupMenuReportes.add(getMntmPrstamosPrximosA());
			popupMenuReportes.add(getMntmHistorialDePrstamos());
			popupMenuReportes.add(getMntmUsuariosMsConcurrentes());
		}
		return popupMenuReportes;
	}
	private JMenuItem getMntmMateriasAs() {
		if (mntmMateriasAs == null) {
			mntmMateriasAs = new JMenuItem("Materias m\u00E1s solicitadas");
			mntmMateriasAs.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmMateriasAs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					labelRuta.setText("Reportes / Materias más solicitadas");
					lblReportes.setForeground(Colores.getCruds());
					Reporte1GraficoMaterias r = new Reporte1GraficoMaterias();
					r.setVisible(true);
					labelRuta.setText("");
					lblReportes.setForeground(Color.BLACK);
				}
			});
		}
		return mntmMateriasAs;
	}
	private JMenuItem getMntmPrstamosPrximosA() {
		if (mntmPrstamosPrximosA == null) {
			mntmPrstamosPrximosA = new JMenuItem("Pr\u00E9stamos pr\u00F3ximos a vencer");
			mntmPrstamosPrximosA.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmPrstamosPrximosA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblReportes.setForeground(Colores.getCruds());
					labelRuta.setText("Reportes / Préstamos próximos a vencer");
					Reporte2PlazoDias r = new Reporte2PlazoDias();
					r.setVisible(true);
					labelRuta.setText("");
					lblReportes.setForeground(Color.BLACK);
				}
			});
		}
		return mntmPrstamosPrximosA;
	}
	private JMenuItem getMntmHistorialDePrstamos() {
		if (mntmHistorialDePrstamos == null) {
			mntmHistorialDePrstamos = new JMenuItem("Historial de pr\u00E9stamos");
			mntmHistorialDePrstamos.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmHistorialDePrstamos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblReportes.setForeground(Colores.getCruds());
					labelRuta.setText("Reportes / Historial de préstamos");
					Reporte3PrestamoRango p = new Reporte3PrestamoRango();
					p.setVisible(true);
					labelRuta.setText("");
					lblReportes.setForeground(Color.BLACK);
				}
			});
		}
		return mntmHistorialDePrstamos;
	}
	private JMenuItem getMntmUsuariosMsConcurrentes() {
		if (mntmUsuariosMsConcurrentes == null) {
			mntmUsuariosMsConcurrentes = new JMenuItem("Usuarios con m\u00E1s pr\u00E9stamos");
			mntmUsuariosMsConcurrentes.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmUsuariosMsConcurrentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lblReportes.setForeground(Colores.getCruds());
					labelRuta.setText("Reportes / Usuarios con más préstamos");
					Reporte4UsuariosMasPrestamos i = new Reporte4UsuariosMasPrestamos(null, Biblioteca.obtenerTop5UsuariosConMasPrestamos());
					i.setVisible(true);
					labelRuta.setText("");
					lblReportes.setForeground(Color.BLACK);
				}
			});
		}
		return mntmUsuariosMsConcurrentes;
	}
	private JButton getBtnGaleria() {
		if (btnGaleria == null) {
			btnGaleria = new JButton("");
			btnGaleria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					labelRuta.setText("Galería");
					lblGalera.setForeground(Colores.getCruds());
					ArrayList<Publicacion> publicaciones = Biblioteca.getInstancia().getPublicaciones();
					GaleriaDialog dialog = new GaleriaDialog(null, publicaciones);
					dialog.setVisible(true);
					labelRuta.setText("");
					lblGalera.setForeground(Color.BLACK);
				}
			});
			btnGaleria.setFont(new Font("SansSerif", Font.PLAIN, 20));
			btnGaleria.setBorder(null);
			btnGaleria.setBackground(new Color(209, 184, 148));
			btnGaleria.setBounds(0, 389, 338, 70);
		}
		return btnGaleria;
	}
	private JLabel getLblGalera() {
		if (lblGalera == null) {
			lblGalera = new JLabel("Galer\u00EDa");
			lblGalera.setForeground(Color.BLACK);
			lblGalera.setFont(new Font("Sylfaen", Font.PLAIN, 30));
			lblGalera.setBounds(70, 406, 141, 40);
		}
		return lblGalera;
	}
	private JLabel getLabelRuta() {
		if (labelRuta == null) {
			labelRuta = new JLabel();
			labelRuta.setFont(new Font("Sylfaen", Font.PLAIN, 27));
			labelRuta.setBounds(30, 85, 453, 42);
		}
		return labelRuta;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon("src/images/iconos/Home.png"));
			label_3.setBounds(22, 203, 38, 38);
		}
		return label_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon("src/images/iconos/Edit.png"));
			label_4.setBounds(22, 270, 38, 38);
		}
		return label_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
			label_5.setIcon(new ImageIcon("src/images/iconos/book.png"));
			label_5.setBounds(22, 338, 38, 38);
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel("");
			label_6.setIcon(new ImageIcon("src/images/iconos/Picture.png"));
			label_6.setBounds(22, 406, 38, 38);
		}
		return label_6;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
			label_7.setIcon(new ImageIcon("src/images/iconos/About.png"));
			label_7.setBounds(22, 475, 38, 38);
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
			label_8.setIcon(new ImageIcon("src/images/iconos/Settings.png"));
			label_8.setBounds(22, 539, 38, 38);
		}
		return label_8;
	}
	private JPopupMenu getPopupMenuSesion() {
		if (popupMenuSesion == null) {
			popupMenuSesion = new JPopupMenu();
			popupMenuSesion.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			popupMenuSesion.add(getMntmCerrarSesin());
			popupMenuSesion.add(getMntmSalir());
		}
		return popupMenuSesion;
	}
	private JMenuItem getMntmCerrarSesin() {
		if (mntmCerrarSesin == null) {
			mntmCerrarSesin = new JMenuItem("Cerrar sesi\u00F3n");
			mntmCerrarSesin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					Login g = new Login();
					g.setVisible(true);
				}
			});
			mntmCerrarSesin.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		}
		return mntmCerrarSesin;
	}
	private JMenuItem getMntmSalir() {
		if (mntmSalir == null) {
			mntmSalir = new JMenuItem("Salir");
			mntmSalir.setFont(new Font("Segoe UI", Font.PLAIN, 15));
			mntmSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return mntmSalir;
	}
	
}
