package Visual;

import javax.swing.*;

import Logica.Articulo;
import Logica.Libro;
import Logica.Publicacion;
import Logica.Revista;
import Utiles.WrapLayout;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.border.LineBorder;

public class GaleriaDialog extends JDialog {

	public GaleriaDialog(JFrame parent, ArrayList<Publicacion> publicaciones) {
		super(parent, "Galería de Publicaciones", true);
		setUndecorated(true);
		setBounds(338, 159, 1026, 562);

		JPanel contenido = new JPanel(new BorderLayout());
		contenido.setBorder(new LineBorder(new Color(0, 0, 0)));
		contenido.setBackground(new Color(250, 245, 240));

		GaleriaPanell galeria = new GaleriaPanell(publicaciones);
		JScrollPane scroll = new JScrollPane(galeria);

		JButton btnNewButton = new JButton("Cerrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		galeria.add(btnNewButton);
		scroll.getVerticalScrollBar().setUnitIncrement(16);
		scroll.setBorder(null);

		contenido.add(scroll, BorderLayout.CENTER);
		setContentPane(contenido);
	}
}

// Clase auxiliar: GaleriaPanel
class GaleriaPanell extends JPanel {

	public GaleriaPanell(ArrayList<Publicacion> publicaciones) {
		setLayout(new WrapLayout(FlowLayout.LEFT, 20, 20));
		setBackground(new Color(250, 245, 240));

		for (Publicacion p : publicaciones) {
			add(crearTarjeta(p));
		}
	}

	private JPanel crearTarjeta(final Publicacion pub) {
		JPanel tarjeta = new JPanel();
		tarjeta.setLayout(new BorderLayout());
		tarjeta.setPreferredSize(new Dimension(220, 320));
		tarjeta.setBackground(Color.WHITE);
		tarjeta.setBorder(BorderFactory.createLineBorder(new Color(181, 149, 110), 2, true));

		ImageIcon iconoOriginal = pub.getImage();
		Image imgEscalada = iconoOriginal.getImage().getScaledInstance(200, 240, Image.SCALE_SMOOTH);
		JLabel imagen = new JLabel(new ImageIcon(imgEscalada));
		imagen.setHorizontalAlignment(JLabel.CENTER);

		JLabel titulo = new JLabel(pub.getTitulo(), SwingConstants.CENTER);
		titulo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		titulo.setHorizontalAlignment(JLabel.CENTER);

		tarjeta.add(imagen, BorderLayout.CENTER);
		tarjeta.add(titulo, BorderLayout.SOUTH);

		tarjeta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

//				String mensaje = "Título: " + pub.getTitulo() + 
//						"\nIdentificador: " + pub.getId() + 
//						"\nMateria: " + pub.getMateria() +
//						"\nEjemplares: " + pub.getCantEjemplares() + "      Páginas: " + pub.getNumPaginas();
//
//				if(pub instanceof Libro){
//					JOptionPane.showMessageDialog(null, mensaje +
//							"\nAutor: " + ((Libro)pub).getAutores().get(0) + 
//							"\nEditorial: " + ((Libro)pub).getEditorial(),
//							"Detalles del Libro", JOptionPane.INFORMATION_MESSAGE);
//				}
//				if(pub instanceof Revista){
//					JOptionPane.showMessageDialog(null, mensaje +
//							"\nAño: " + ((Revista)pub).getAnno() + "      Número: " + ((Revista)pub).getNum(),
//							"Detalles de la Revista", JOptionPane.INFORMATION_MESSAGE);
//				}
//				if(pub instanceof Articulo){
//					JOptionPane.showMessageDialog(null, mensaje + 
//							"\nAutor: " + ((Articulo)pub).getAutores().get(0) + 
//							"\nÁrbtiro: " + ((Articulo)pub).getArbitros().get(0),
//							"Detalles del Artículo", JOptionPane.INFORMATION_MESSAGE);
//				}

				InfoPublicacionTablaPrestamo p = new InfoPublicacionTablaPrestamo(pub);
				p.setVisible(true);
			}
		});

		return tarjeta;
	}
}
