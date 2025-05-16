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
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTree;

public class AgregarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JSpinner spinner;
	private JLabel lblEdad;
	private JLabel lblSexo;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnM;
	private JRadioButton rdbtnI;
	private JCheckBoxMenuItem chckbxmntmNewCheckItem;
	private JComboBox comboBox;

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
		
		setBounds(100, 100, 493, 501);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
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
			lblLosCamposMarcados.setBounds(33, 53, 234, 14);
			contentPanel.add(lblLosCamposMarcados);
		}
		{
			textField = new JTextField();
			textField.setBounds(33, 131, 409, 29);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNombreCompleto = new JLabel("Nombre completo:");
			lblNombreCompleto.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblNombreCompleto.setBounds(33, 91, 234, 29);
			contentPanel.add(lblNombreCompleto);
		}
		contentPanel.add(getSpinner());
		contentPanel.add(getLblEdad());
		contentPanel.add(getLblSexo());
		contentPanel.add(getRdbtnNewRadioButton());
		contentPanel.add(getRdbtnM());
		contentPanel.add(getRdbtnI());
		contentPanel.add(getChckbxmntmNewCheckItem());
		contentPanel.add(getComboBox());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
			spinner.setBounds(103, 188, 49, 22);
		}
		return spinner;
	}
	private JLabel getLblEdad() {
		if (lblEdad == null) {
			lblEdad = new JLabel("Edad:");
			lblEdad.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblEdad.setBounds(33, 182, 62, 29);
		}
		return lblEdad;
	}
	private JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Sexo:");
			lblSexo.setFont(new Font("SansSerif", Font.PLAIN, 18));
			lblSexo.setBounds(222, 182, 62, 29);
		}
		return lblSexo;
	}
	private JRadioButton getRdbtnNewRadioButton() {
		if (rdbtnNewRadioButton == null) {
			rdbtnNewRadioButton = new JRadioButton("F");
			rdbtnNewRadioButton.setBounds(289, 188, 38, 23);
		}
		return rdbtnNewRadioButton;
	}
	private JRadioButton getRdbtnM() {
		if (rdbtnM == null) {
			rdbtnM = new JRadioButton("M");
			rdbtnM.setBounds(346, 188, 38, 23);
		}
		return rdbtnM;
	}
	private JRadioButton getRdbtnI() {
		if (rdbtnI == null) {
			rdbtnI = new JRadioButton("I");
			rdbtnI.setBounds(404, 188, 38, 23);
		}
		return rdbtnI;
	}
	private JCheckBoxMenuItem getChckbxmntmNewCheckItem() {
		if (chckbxmntmNewCheckItem == null) {
			chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Materia");
			chckbxmntmNewCheckItem.setOpaque(true);
			chckbxmntmNewCheckItem.setBounds(33, 249, 89, 22);
		}
		return chckbxmntmNewCheckItem;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			String[] materias = {"Generos literarios (Ficcion)", "Informativos/Educativos", "Academicos/Cientificos", "Publicaciones Populares/Divulgacion", "Generos Hibridos", "Temas Emergentes"};
			JComboBox<String> comboBox = new JComboBox<String>(materias);
			comboBox.setBounds(261, 249, 28, 20);
		}
		return comboBox;
	}
}
