package Visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu botonSesion;
	private JMenu botonUsuario;
	private JMenu botonTrabajador;
	private JMenu botonPublicacion;
	private JMenu botonPrestamo;
	private JMenu botonReportes;
	private JMenu botonInfo;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmAgregarUsuario;
	private JMenuItem mntmModificarUsuario;
	private JMenuItem mntmEliminarUsuario;
	private JMenuItem mntmContratarTrabajador;
	private JMenuItem mntmModificarTrabajador;
	private JMenuItem mntmDespedirTrabajador;
	private JMenu mnInsertarPublicacion;
	private JMenuItem mntmLibro;
	private JMenuItem mntmRevista;
	private JMenuItem mntmArticulo;
	private JMenuItem mntmMostrarInventario;
	private JMenuItem mntmRealizarPrestamo;
	private JMenuItem mntmDevolverPrestamo;
	private JMenuItem mntmReporte;
	private JMenuItem mntmReporte_1;
	private JMenuItem mntmReporte_2;
	private JMenuItem mntmReporte_3;
	private JMenuItem mntmCentro;
	private JMenuItem mntmNosotros;
	private Login l;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
		setBounds(0, 0, 1375, 773);
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
			menuBar.setBounds(10, 11, 654, 59);
			menuBar.add(getBotonSesion());
			menuBar.add(getBotonUsuario());
			menuBar.add(getBotonTrabajador());
			menuBar.add(getBotonPublicacion());
			menuBar.add(getBotonPrestamo());
			menuBar.add(getBotonReportes());
			menuBar.add(getBotonInfo());
		}
		return menuBar;
	}
	private JMenu getBotonSesion() {
		if (botonSesion == null) {
			botonSesion = new JMenu("Cerrar Sesion");
			botonSesion.setFont(new Font("SansSerif", Font.PLAIN, 17));
			botonSesion.add(getMntmCerrarSesion());
		}
		return botonSesion;
	}
	private JMenu getBotonUsuario() {
		if (botonUsuario == null) {
			botonUsuario = new JMenu("Usuario");
			botonUsuario.setFont(new Font("SansSerif", Font.PLAIN, 17));
			botonUsuario.add(getMntmAgregarUsuario());
			botonUsuario.add(getMntmModificarUsuario());
			botonUsuario.add(getMntmEliminarUsuario());
		}
		return botonUsuario;
	}
	private JMenu getBotonTrabajador() {
		if (botonTrabajador == null) {
			botonTrabajador = new JMenu("Trabajador");
			botonTrabajador.setFont(new Font("SansSerif", Font.PLAIN, 17));
			botonTrabajador.add(getMntmContratarTrabajador());
			botonTrabajador.add(getMntmModificarTrabajador());
			botonTrabajador.add(getMntmDespedirTrabajador());
		}
		return botonTrabajador;
	}
	private JMenu getBotonPublicacion() {
		if (botonPublicacion == null) {
			botonPublicacion = new JMenu("Publicacion");
			botonPublicacion.setFont(new Font("SansSerif", Font.PLAIN, 17));
			botonPublicacion.add(getMnInsertarPublicacion());
			botonPublicacion.add(getMntmMostrarInventario());
		}
		return botonPublicacion;
	}
	private JMenu getBotonPrestamo() {
		if (botonPrestamo == null) {
			botonPrestamo = new JMenu("Prestamo");
			botonPrestamo.setFont(new Font("SansSerif", Font.PLAIN, 17));
			botonPrestamo.add(getMntmRealizarPrestamo());
			botonPrestamo.add(getMntmDevolverPrestamo());
		}
		return botonPrestamo;
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
			botonInfo.add(getMntmCentro());
			botonInfo.add(getMntmNosotros());
		}
		return botonInfo;
	}
	private JMenuItem getMntmCerrarSesion() {
		if (mntmCerrarSesion == null) {
			mntmCerrarSesion = new JMenuItem("Cerrar Sesion");
		}
		return mntmCerrarSesion;
	}
	private JMenuItem getMntmAgregarUsuario() {
		if (mntmAgregarUsuario == null) {
			mntmAgregarUsuario = new JMenuItem("Agregar Usuario");
			mntmAgregarUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					AgregarUsuario pantalla = new AgregarUsuario();
					pantalla.setVisible(true);
				}
			});
		}
		return mntmAgregarUsuario;
	}
	private JMenuItem getMntmModificarUsuario() {
		if (mntmModificarUsuario == null) {
			mntmModificarUsuario = new JMenuItem("Modificar Usuario");
		}
		return mntmModificarUsuario;
	}
	private JMenuItem getMntmEliminarUsuario() {
		if (mntmEliminarUsuario == null) {
			mntmEliminarUsuario = new JMenuItem("Eliminar Usuario");
		}
		return mntmEliminarUsuario;
	}
	private JMenuItem getMntmContratarTrabajador() {
		if (mntmContratarTrabajador == null) {
			mntmContratarTrabajador = new JMenuItem("Contratar Personal");
		}
		return mntmContratarTrabajador;
	}
	private JMenuItem getMntmModificarTrabajador() {
		if (mntmModificarTrabajador == null) {
			mntmModificarTrabajador = new JMenuItem("Modificar Trabajador");
		}
		return mntmModificarTrabajador;
	}
	private JMenuItem getMntmDespedirTrabajador() {
		if (mntmDespedirTrabajador == null) {
			mntmDespedirTrabajador = new JMenuItem("Despedir Trabajador");
		}
		return mntmDespedirTrabajador;
	}
	private JMenu getMnInsertarPublicacion() {
		if (mnInsertarPublicacion == null) {
			mnInsertarPublicacion = new JMenu("Insertar Publicacion");
			mnInsertarPublicacion.add(getMntmLibro());
			mnInsertarPublicacion.add(getMntmRevista());
			mnInsertarPublicacion.add(getMntmArticulo());
		}
		return mnInsertarPublicacion;
	}
	private JMenuItem getMntmLibro() {
		if (mntmLibro == null) {
			mntmLibro = new JMenuItem("Libro");
		}
		return mntmLibro;
	}
	private JMenuItem getMntmRevista() {
		if (mntmRevista == null) {
			mntmRevista = new JMenuItem("Revista");
		}
		return mntmRevista;
	}
	private JMenuItem getMntmArticulo() {
		if (mntmArticulo == null) {
			mntmArticulo = new JMenuItem("Articulo");
		}
		return mntmArticulo;
	}
	private JMenuItem getMntmMostrarInventario() {
		if (mntmMostrarInventario == null) {
			mntmMostrarInventario = new JMenuItem("Mostrar Inventario");
		}
		return mntmMostrarInventario;
	}
	private JMenuItem getMntmRealizarPrestamo() {
		if (mntmRealizarPrestamo == null) {
			mntmRealizarPrestamo = new JMenuItem("Realizar Prestamo");
		}
		return mntmRealizarPrestamo;
	}
	private JMenuItem getMntmDevolverPrestamo() {
		if (mntmDevolverPrestamo == null) {
			mntmDevolverPrestamo = new JMenuItem("Devolver Prestamo");
		}
		return mntmDevolverPrestamo;
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
	private JMenuItem getMntmCentro() {
		if (mntmCentro == null) {
			mntmCentro = new JMenuItem("Centro");
		}
		return mntmCentro;
	}
	private JMenuItem getMntmNosotros() {
		if (mntmNosotros == null) {
			mntmNosotros = new JMenuItem("Nosotros");
		}
		return mntmNosotros;
	}
}
