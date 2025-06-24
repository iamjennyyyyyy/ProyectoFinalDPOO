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

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import Inicializadora.Inicializar;
import Logica.Biblioteca;
import Utiles.Colores;
import Utiles.MiPersonalizacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.io.IOException;
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

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu botonSesion;
	private JMenu botonReportes;
	private JMenu botonInfo;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmReporte;
	private JMenuItem mntmReporte_1;
	private JMenuItem mntmReporte_2;
	private JMenuItem mntmReporte_3;
	Biblioteca b = Biblioteca.getInstancia();
	private JMenuItem mntmNosotros;
	private JMenuItem mntmCentro;
	private JMenuItem mntmCerrar;
	private JMenu mnVer;
	private JMenuItem mntmVerUsuario;
	private JMenuItem mntmTrabajador;
	private JMenuItem mntmPublicacion;
	private JMenuItem mntmPrestamo;
	private JLabel label;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */

	public Principal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(0, 0, 1382, 747);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getMenuBar_1());
		contentPane.add(getLabel());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBorderPainted(false);
			menuBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			menuBar.setBackground(new Color(255, 250, 250));
			menuBar.setForeground(Colores.getColoroscuro());
			menuBar.setBounds(0, 0, 1367, 61);
			menuBar.add(getBotonSesion());
			menuBar.add(getMnVer());
			menuBar.add(getBotonReportes());
			menuBar.add(getBotonInfo());
		}
		return menuBar;
	}
	private JMenu getBotonSesion() {
		if (botonSesion == null) {
			botonSesion = new JMenu("Cerrar Sesion");
			botonSesion.setBackground(SystemColor.menu);
			botonSesion.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
			botonSesion.add(getMntmUsuario());
			botonSesion.add(getMntmCerrar());
		}
		return botonSesion;
	}
	private JMenu getBotonReportes() {
		if (botonReportes == null) {
			botonReportes = new JMenu("Reportes");
			botonReportes.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
			botonReportes.add(getMntmReporte());
			botonReportes.add(getMntmReporte_1());
			botonReportes.add(getMntmReporte_2());
			botonReportes.add(getMntmReporte_3());
		}
		return botonReportes;
	}
	private JMenu getBotonInfo() {
		if (botonInfo == null) {
			botonInfo = new JMenu("Acerca de");
			botonInfo.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
			botonInfo.add(getMntmNosotros());
			botonInfo.add(getMntmCentro());
		}
		return botonInfo;
	}
	private JMenuItem getMntmUsuario() {
		if (mntmUsuario == null) {
			mntmUsuario = new JMenuItem("Sesion Usuario");
		}
		return mntmUsuario;
	}
	private JMenuItem getMntmReporte() {
		if (mntmReporte == null) {
			mntmReporte = new JMenuItem("Materias m\u00E1s solicitadas");
			mntmReporte.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Reporte1GraficoMaterias r = new Reporte1GraficoMaterias();
					r.setVisible(true);
				}
			});
		}
		return mntmReporte;
	}
	private JMenuItem getMntmReporte_1() {
		if (mntmReporte_1 == null) {
			mntmReporte_1 = new JMenuItem("Prestamos proximos a vencer");
			mntmReporte_1.setBackground(new Color(245, 245, 245));
			mntmReporte_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Reporte2PlazoDias r = new Reporte2PlazoDias();
					r.setVisible(true);
				}
			});
		}
		return mntmReporte_1;
	}
	private JMenuItem getMntmReporte_2() {
		if (mntmReporte_2 == null) {
			mntmReporte_2 = new JMenuItem("Prestamos en rango");
			mntmReporte_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Reporte3PrestamoRango r = new Reporte3PrestamoRango();
					r.setVisible(true);
				}
			});
		}
		return mntmReporte_2;
	}
	private JMenuItem getMntmReporte_3() {
		if (mntmReporte_3 == null) {
			mntmReporte_3 = new JMenuItem("Reporte 4");
		}
		return mntmReporte_3;
	}

	private JMenuItem getMntmNosotros() {
		if (mntmNosotros == null) {
			mntmNosotros = new JMenuItem("Nosotros");
			mntmNosotros.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					AcercaDeNosotros.setAcercaDeNosotros(true); // true para mostrar panel sobre nosotros
//					AcercaDeNosotros panel = AcercaDeNosotros.getInstancia();
//					panel.setVisible(true);
				}
			});
		}
		return mntmNosotros;
	}
	private JMenuItem getMntmCentro() {
		if (mntmCentro == null) {
			mntmCentro = new JMenuItem("Centro");
			mntmCentro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
//					AcercaDeNosotros.setAcercaDeNosotros(false); // false para mostrar panel sobre el centro	
//					AcercaDeNosotros panel = AcercaDeNosotros.getInstancia();
//					panel.setVisible(true);
				}
			});
		}
		return mntmCentro;
	}
	private JMenuItem getMntmCerrar() {
		if (mntmCerrar == null) {
			mntmCerrar = new JMenuItem("Cerrar");
			mntmCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					int option = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir?","Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (option == JOptionPane.YES_OPTION) {
						dispose();
					}
				}
			});
		}
		return mntmCerrar;
	}
	private JMenu getMnVer() {
		if (mnVer == null) {
			mnVer = new JMenu("Gesti\u00F3n");
			mnVer.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
			mnVer.add(getMntmVerUsuario());
			mnVer.add(getMntmTrabajador());
			mnVer.add(getMntmPublicacion());
			mnVer.add(getMntmPrestamo());
		}
		return mnVer;
	}
	private JMenuItem getMntmVerUsuario() {
		if (mntmVerUsuario == null) {
			mntmVerUsuario = new JMenuItem("Usuario");
			mntmVerUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						GestionUsuario dialog = new GestionUsuario();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
		}
		return mntmVerUsuario;
	}
	private JMenuItem getMntmTrabajador() {
		if (mntmTrabajador == null) {
			mntmTrabajador = new JMenuItem("Trabajador");
		}
		return mntmTrabajador;
	}
	private JMenuItem getMntmPublicacion() {
		if (mntmPublicacion == null) {
			mntmPublicacion = new JMenuItem("Publicaci\u00F3n");
			mntmPublicacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionPublicacion g = new GestionPublicacion();
					g.setVisible(true);
				}
			});
		}
		return mntmPublicacion;
	}
	private JMenuItem getMntmPrestamo() {
		if (mntmPrestamo == null) {
			mntmPrestamo = new JMenuItem("Prestamo");
			mntmPrestamo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GestionPrestamo p = new GestionPrestamo();
					p.setVisible(true);
				}
			});
		}
		return mntmPrestamo;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
			label.setIcon(new ImageIcon("src/images/Sin t\u00EDtulo.png"));
			label.setBounds(0, 58, 1367, 639);
		}
		return label;
	}
}
