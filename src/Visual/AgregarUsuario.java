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

import Utiles.Colores;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JSpinner spinner;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnI;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	String[] categorias = {
            "Literatura",
            "Informativos/Educativos)",
            "Académicos/Científicos",
            "Revistas Populares/Divulgación",
            "Géneros Especializados",
            "Temas Emergentes"
        };
	private JLabel lblSeleccioneSuGenero;
	private JLabel lblDescripcin;
	private JTextField textField_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AgregarUsuario dialog = new AgregarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AgregarUsuario() {
		
		this.setResizable(false);
		setBounds(440, 130, 493, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Colores.getcolorPaneles());
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
			textField = new JTextField();
			textField.setToolTipText("");
			textField.setBounds(33, 118, 409, 29);
			contentPanel.add(textField);
			textField.setColumns(10);
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
		contentPanel.add(getRdbtnNewRadioButton());
		contentPanel.add(getRdbtnM());
		contentPanel.add(getRdbtnI());
		contentPanel.add(getComboBox_1());
		contentPanel.add(getLblSeleccioneSuGenero());
		contentPanel.add(getLblDescripcin());
		contentPanel.add(getTextField_1());
		contentPanel.add(getLabel());
		contentPanel.add(getLabel_1());
		contentPanel.add(getLabel_2());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				final JButton registrarButton = new JButton("Registrar");
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
			lblSexo.setBounds(222, 169, 62, 29);
		}
		return lblSexo;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("F");
			rdbtnNewRadioButton.setOpaque(false);
			rdbtnNewRadioButton.setBounds(289, 175, 38, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnM() {
		if (rdbtnM == null) {
			rdbtnM = new JRadioButton("M");
			rdbtnM.setOpaque(false);
			rdbtnM.setBounds(346, 175, 38, 23);
		}
		return rdbtnM;
	}
	private JRadioButton getRdbtnI() {
		if (rdbtnI == null) {
			rdbtnI = new JRadioButton("I");
			rdbtnI.setOpaque(false);
			rdbtnI.setBounds(404, 175, 38, 23);
		}
		return rdbtnI;
	}
	private JComboBox getComboBox_1() {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox(categorias);
			comboBox_1.setBounds(33, 260, 141, 22);
		}
		return comboBox_1;
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
	private JLabel getLblDescripcin() {
		if (lblDescripcin == null) {
			lblDescripcin = new JLabel("Descripci\u00F3n:");
			lblDescripcin.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblDescripcin.setBounds(33, 293, 215, 29);
		}
		return lblDescripcin;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setToolTipText("Descripci\u00F3n opcional de tus gustos y preferencias como usuario");
			textField_1.setBounds(33, 333, 409, 54);
			textField_1.setColumns(10);
		}
		return textField_1;
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
			label_2.setBounds(271, 168, 19, 14);
		}
		return label_2;
	}
}
