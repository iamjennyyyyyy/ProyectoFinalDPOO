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
import Utiles.PrestamoTableModel;

import javax.swing.JLabel;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JSlider;


public class AgregarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel lblNuevoPrstamo;
	private JLabel lblIngreseUsuario;
	private JTextField textFieldIdUsuario;
	private JLabel lblIngreseElId;
	private JTextField textFieldIdPub;
	Prestamo prestamoRealizado;
	Biblioteca b = Biblioteca.getInstancia();
	UsuarioAcreditado u;
	Trabajador t = b.getAdmin();
	Publicacion p;
	private PrestamoTableModel tableModel = new PrestamoTableModel();
	private JTable table_1;
	private ArrayList<Prestamo> nuevosPrestamos = new ArrayList<Prestamo>();
	private ArrayList<Prestamo> prestamosBiblioteca = b.getPrestamosTotales();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Biblioteca b = Biblioteca.getInstancia();
			AgregarPrestamo dialog = new AgregarPrestamo(b);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public AgregarPrestamo(final Biblioteca b) {

		this.setResizable(false);
		setBounds(440, 130, 485, 447);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Colores.getcolorPaneles());
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblNuevoPrstamo());
		contentPanel.add(getLblIngreseUsuario());
		contentPanel.add(getTextFieldIdUsuario());
		contentPanel.add(getLblIngreseElId());
		contentPanel.add(getTextFieldIdPub());
		contentPanel.add(getTable_1());
		mostrarPrestamos();
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
						prestamoRealizado = crearPrestamo();					
						if(prestamoRealizado != null){
							b.agregarPrestamo(prestamoRealizado);
							prestamosBiblioteca.add(prestamoRealizado);
							JOptionPane.showMessageDialog(null, "El préstamo ha sido realizado con éxito!");
						};
						getRootPane().setDefaultButton(okButton);
					}
					{
						JButton cancelButton = new JButton("Cancel");
						cancelButton.setBackground(Colores.getcolorBotonClaro());
						cancelButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								dispose();
							}
						});
						cancelButton.setActionCommand("Cancel");
						buttonPane.add(cancelButton);

					};
				});
			}
		}

	}
	private JLabel getLblNuevoPrstamo() {
		if (lblNuevoPrstamo == null) {
			lblNuevoPrstamo = new JLabel("Nuevo Pr\u00E9stamo");
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
			lblIngreseElId = new JLabel("Ingrese el id de la publicaci\u00F3n:");
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

	public Prestamo crearPrestamo(){

		String idUsuario = textFieldIdUsuario.getText();
		String idPublicacion = textFieldIdPub.getText();
		u = b.buscarUsuarioPorId(idUsuario);
		p = b.buscarPublicacionPorId(idPublicacion);
		if(u == null) {
			JOptionPane.showMessageDialog(this, "Usuario no encontrado.\nIntente de nuevo");
			return null;
		}
		if(p == null) {
			JOptionPane.showMessageDialog(this, "Publicación no encontrada.\nIntente de nuevo");
			return null;
		}

		return b.solicitarPrestamo(u, p, t);
	}

	private JTable getTable_1() {
		if (table_1 == null) {
			table_1 = new JTable();
			table_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
			table_1.setToolTipText("Tabla ");
			table_1.setForeground(Color.DARK_GRAY);
			table_1.setBackground(Color.WHITE);
			table_1.setBounds(33, 263, 407, 111);
			setResizable(false);
			table_1.setVisible(true);
		}
		return table_1;
	}
	public void mostrarPrestamos(){

		tableModel = new PrestamoTableModel();
		table_1.setModel(tableModel);
		
		//table_1.add(ColumnNames) tienes que importar ColumNames para agregarlo en la tabla
		//como primer
		//				for(Prestamo p : nuevosPrestamos){
		//					((PrestamoTableModel)table_1.getModel()).adicionar(p.getUser().getId(), 
		//							p.getPub().getId(), 
		//							String.valueOf(p.getFechaP()), 
		//							String.valueOf(p.getFechaMax()), 
		//							String.valueOf(p.getFechaDevolucion()));
		//}

		for(Prestamo p : prestamosBiblioteca){
			((PrestamoTableModel)table_1.getModel()).adicionar(p.getUser().getId(), 
					p.getPub().getId(), 
					String.valueOf(p.getFechaP()), 
					String.valueOf(p.getFechaMax()), 
					String.valueOf(p.getFechaDevolucion()));
		}
	}
}