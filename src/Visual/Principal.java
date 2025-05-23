package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import Inicializadora.Inicializar;
import Logica.Biblioteca;
import Utiles.Colores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JToggleButton;

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
	private Login l;
	private AgregarPrestamo nuevo;
	Biblioteca b = Biblioteca.getInstancia();
	private JMenuItem mntmNosotros;
	private JMenuItem mntmCentro;
	private JMenuItem mntmCerrar;
	private JMenu mnVer;
	private JMenuItem mntmVerUsuario;
	private JMenuItem mntmTrabajador;
	private JMenuItem mntmPublicacion;
	private JMenuItem mntmPrestamo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicializar.Inicio();
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

		l = new Login(this);
		l.setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel()
		{
			public void paintComponent(Graphics g){
				Image img = Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/images/fondoS.jpg"));
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getMenuBar_1());
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setFont(new Font("SansSerif", Font.PLAIN, 14));
			menuBar.setBackground(new Color(222, 184, 135));
			menuBar.setBounds(0, 0, 1367, 65);
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
			botonSesion.setFont(new Font("SansSerif", Font.PLAIN, 17));
			botonSesion.add(getMntmUsuario());
			botonSesion.add(getMntmCerrar());
		}
		return botonSesion;
	}
	private JMenu getBotonReportes() {
		if (botonReportes == null) {
			botonReportes = new JMenu("Reportes");
			botonReportes.setFont(new Font("SansSerif", Font.PLAIN, 17));
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
			botonInfo.setFont(new Font("SansSerif", Font.PLAIN, 17));
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
			mntmReporte = new JMenuItem("Reporte 1");
		}
		return mntmReporte;
	}
	private JMenuItem getMntmReporte_1() {
		if (mntmReporte_1 == null) {
			mntmReporte_1 = new JMenuItem("Reporte 2");
		}
		return mntmReporte_1;
	}
	private JMenuItem getMntmReporte_2() {
		if (mntmReporte_2 == null) {
			mntmReporte_2 = new JMenuItem("Reporte 3");
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
					AcercaDeNosotros.setAcercaDeNosotros(true); // true para mostrar panel sobre nosotros
					AcercaDeNosotros panel = AcercaDeNosotros.getInstancia();
					panel.setVisible(true);
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
					AcercaDeNosotros.setAcercaDeNosotros(false); // false para mostrar panel sobre el centro	
					AcercaDeNosotros panel = AcercaDeNosotros.getInstancia();
					panel.setVisible(true);
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
					dispose();
				}
			});
		}
		return mntmCerrar;
	}
	private JMenu getMnVer() {
		if (mnVer == null) {
			mnVer = new JMenu("Gesti\u00F3n");
			mnVer.setFont(new Font("SansSerif", Font.PLAIN, 17));
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
		}
		return mntmPublicacion;
	}
	private JMenuItem getMntmPrestamo() {
		if (mntmPrestamo == null) {
			mntmPrestamo = new JMenuItem("Prestamo");
		}
		return mntmPrestamo;
	}
}
