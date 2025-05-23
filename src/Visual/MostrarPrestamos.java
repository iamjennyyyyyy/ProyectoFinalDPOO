package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import Logica.Biblioteca;
import Logica.Prestamo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MostrarPrestamos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnMostrarPrest;
	Biblioteca b = Biblioteca.getInstancia();
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			MostrarPrestamos dialog = new MostrarPrestamos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public MostrarPrestamos() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(getTextArea());
		{

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.add(getBtnMostrarPrest());
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
	private JButton getBtnMostrarPrest() {
		if (btnMostrarPrest == null) {
			btnMostrarPrest = new JButton("Mostrar prest");
			btnMostrarPrest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					StringBuilder info = new StringBuilder();
			        for (Prestamo prest : b.getPrestamosTotales()) {
			            info.append(prest.toString()).append("\n");
			        }
			        getTextArea().setText(info.toString());
				}
			});
		}
		return btnMostrarPrest;
	}
	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
}
