package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import Logica.Biblioteca;
import Logica.Prestamo;
import Visual.GestionUsuario;
import Logica.UsuarioAcreditado;
import Utiles.Colores;
import Utiles.PrestamoTableModel;
import Utiles.UsuarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.UIManager;
import javax.swing.SpinnerNumberModel;

public class AgregarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNombreUsuario;
	private JSpinner spinner;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JComboBox comboBox;
	private JComboBox comboBox_Materia;
	ButtonGroup group = new ButtonGroup();
	private JLabel lblSeleccioneSuGenero;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private int idUsuario = 1000;
	private JComboBox comboBox_Sexo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AgregarUsuario() {

		this.setResizable(false);
		setBounds(440, 130, 493, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(UIManager.getColor("CheckBox.background"));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblRegistroUsuario = new JLabel("Registro Usuario");
			lblRegistroUsuario.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblRegistroUsuario.setBounds(170, 11, 141, 36);
			contentPanel.add(lblRegistroUsuario);
		}
		{
			JLabel lblLosCamposMarcados = new JLabel("Los campos marcados en rojo * son obligatorios");
			lblLosCamposMarcados.setForeground(new Color(128, 0, 0));
			lblLosCamposMarcados.setBounds(33, 53, 294, 14);
			contentPanel.add(lblLosCamposMarcados);
		}
		{
			textFieldNombreUsuario = new JTextField();
			textFieldNombreUsuario.setToolTipText("");
			textFieldNombreUsuario.setBounds(33, 118, 409, 29);
			contentPanel.add(textFieldNombreUsuario);
			textFieldNombreUsuario.setColumns(10);
		}
		{
			JLabel lblNombreCompleto = new JLabel("Nombre completo:");
			lblNombreCompleto.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblNombreCompleto.setBounds(33, 78, 234, 29);
			contentPanel.add(lblNombreCompleto);
		}
		contentPanel.add(getSpinner());
		contentPanel.add(getLblEdad());
		contentPanel.add(getLblSexo());
		contentPanel.add(getComboBox_Materia());
		contentPanel.add(getLblSeleccioneSuGenero());
		contentPanel.add(getLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
		contentPanel.add(getComboBox_Sexo());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton registrarButton = new JButton("Registrar");
				registrarButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						String nombre = textFieldNombreUsuario.getText();
						int edad = (Integer) spinner.getValue();
						String sexo = comboBox_Sexo.getSelectedItem().toString();
						idUsuario++;
						String id = "" + idUsuario;

						if(nombre.isEmpty())
							JOptionPane.showMessageDialog(null, "Error. Nombre vacío.");
						else if (edad < 18|| edad > 110){
							if(edad < 18)
								JOptionPane.showMessageDialog(null, "Lectores menores de edad no pueden registrarse.");
							else
								JOptionPane.showMessageDialog(null, "Edad no admitida.");
						}
						else{
							JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
							Biblioteca.getInstancia().crearUsuarioAcreditado(id, nombre, edad, sexo);
							dispose();
						}
					}
				});

				registrarButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						registrarButton.setBackground(Colores.getcolorBotonVerde());
					}
					@Override
					public void mouseExited(MouseEvent arg0) {
						registrarButton.setBackground(Colores.getcolorBotonClaro());
					}
				});
				registrarButton.setActionCommand("OK");
				buttonPane.add(registrarButton);
				getRootPane().setDefaultButton(registrarButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setBackground(Colores.getcolorBotonClaro());
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(new Integer(18), null, null, new Integer(1)));
			spinner.setBounds(103, 175, 49, 22);
		}
		return spinner;
	}
	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblEdad.setBounds(33, 169, 62, 29);
		}
		return lblEdad;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblSexo.setBounds(272, 168, 62, 29);
		}
		return lblSexo;
	}

	private JComboBox getComboBox_Materia() {
		if (comboBox_Materia == null) {
			String[] categorias = {
					"Literatura",
					"Informativos/Educativos)",
					"Académicos/Científicos",
					"Revistas Populares/Divulgación",
					"Géneros Especializados",
					"Temas Emergentes"
			};
			comboBox_Materia = new JComboBox(categorias);
			comboBox_Materia.setBounds(33, 260, 141, 22);
		}
		return comboBox_Materia;
	}
	private JLabel getLblSeleccioneSuGenero() {
		if (lblSeleccioneSuGenero == null) {
			lblSeleccioneSuGenero = new JLabel("Seleccione una categoria:");
			lblSeleccioneSuGenero.setToolTipText("Su preferencia como lector, que ser\u00E1 tomada en cuenta\r\npara una recomendaci\u00F3n personalizada");
			lblSeleccioneSuGenero.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblSeleccioneSuGenero.setBounds(33, 220, 215, 29);
		}
		return lblSeleccioneSuGenero;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("*");
			label.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label.setForeground(new Color(128, 0, 0));
			label.setBounds(182, 78, 19, 14);
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("*");
			label_1.setForeground(new Color(128, 0, 0));
			label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_1.setBounds(82, 168, 19, 14);
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("*");
			label_2.setForeground(new Color(128, 0, 0));
			label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			label_2.setBounds(321, 167, 19, 14);
		}
		return label_2;
	}

	private JComboBox getComboBox_Sexo() {
		if (comboBox_Sexo == null) {
			String[] sexos = {"F","M","I"};
			comboBox_Sexo = new JComboBox(sexos);
			comboBox_Sexo.setBounds(344, 175, 49, 22);
		}
		return comboBox_Sexo;
	}
}