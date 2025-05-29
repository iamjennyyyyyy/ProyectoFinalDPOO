package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.Publicacion;
import Logica.Trabajador;
import Logica.UsuarioAcreditado;
import Utiles.Colores;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;


public class AgregarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNuevoPrstamo;
	private JLabel lblIngreseUsuario;
	private JTextField textFieldIdUsuario;
	private JLabel lblIngreseElId;
	private JTextField textFieldIdPub;
	Prestamo prestamoRealizado;
	UsuarioAcreditado u;
	Trabajador t = Biblioteca.getInstancia().getAdmin();
	Publicacion p;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Biblioteca b = Biblioteca.getInstancia();
			AgregarPrestamo dialog = new AgregarPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */

	public AgregarPrestamo() {

		this.setResizable(false);
		setBounds(440, 130, 485, 351);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.WHITE);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNuevoPrstamo());
		contentPanel.add(getLblIngreseUsuario());
		contentPanel.add(getTextFieldIdUsuario());
		contentPanel.add(getLblIngreseElId());
		contentPanel.add(getTextFieldIdPub());
		{
			final JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						okButton.setBackground(Colores.getcolorBotonVerde());
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						okButton.setBackground(Colores.getcolorBotonClaro());
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Prestamo prest;

						String idUsuario = textFieldIdUsuario.getText();
						String idPublicacion = textFieldIdPub.getText();
						
						u = Biblioteca.getInstancia().buscarUsuarioPorId(idUsuario);
						p = Biblioteca.getInstancia().buscarPublicacionPorId(idPublicacion);

						if(u == null)
							JOptionPane.showMessageDialog(null, "Usuario no encontrado.\nIntente de nuevo");
						else if(p == null)
							JOptionPane.showMessageDialog(null, "Publicación no encontrada.\nIntente de nuevo");
						else{
							Biblioteca.getInstancia().solicitarPrestamo(u, p, t);					
							JOptionPane.showMessageDialog(null, "El prestamo ha sido realizado con éxito!");
							dispose();
						}
					};
				});
			}
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBackground(Colores.getcolorBotonClaro());
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelButton.setActionCommand("Cancel");
			buttonPane.add(cancelButton);

		}
	}

	private JLabel getLblNuevoPrstamo() {
		if (lblNuevoPrstamo == null) {
			lblNuevoPrstamo = new JLabel("Nuevo Préstamo");
			lblNuevoPrstamo.setFont(new Font("SansSerif", Font.PLAIN, 20));
			lblNuevoPrstamo.setBounds(168, 20, 155, 29);
		}
		return lblNuevoPrstamo;
	}
	private JLabel getLblIngreseUsuario() {
		if (lblIngreseUsuario == null) {
			lblIngreseUsuario = new JLabel("Ingrese el id del usuario:");
			lblIngreseUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblIngreseUsuario.setBounds(33, 70, 205, 29);
		}
		return lblIngreseUsuario;
	}
	private JTextField getTextFieldIdUsuario() {
		if (textFieldIdUsuario == null) {
			textFieldIdUsuario = new JTextField();
			textFieldIdUsuario.setBounds(33, 110, 407, 29);
			textFieldIdUsuario.setColumns(10);
		}
		return textFieldIdUsuario;
	}
	private JLabel getLblIngreseElId() {
		if (lblIngreseElId == null) {
			lblIngreseElId = new JLabel("Ingrese el id de la publicación:");
			lblIngreseElId.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblIngreseElId.setBounds(31, 170, 252, 29);
		}
		return lblIngreseElId;
	}
	private JTextField getTextFieldIdPub() {
		if (textFieldIdPub == null) {
			textFieldIdPub = new JTextField();
			textFieldIdPub.setColumns(10);
			textFieldIdPub.setBounds(33, 210, 407, 29);
		}
		return textFieldIdPub;
	}
}