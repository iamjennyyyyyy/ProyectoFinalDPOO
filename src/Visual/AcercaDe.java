package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnSalir;
	private JLabel lblNewLabel;
	private JTextPane txtpnelConocimientoDebe;
	private JTextPane txtpnEsteProyectoHa;
	private JLabel lblalvarotamayo;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setBounds(338, 159, 1026, 562);
		setUndecorated(true);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblbibliotech = new JLabel("@its_jenny126");
			lblbibliotech.setBounds(675, 491, 161, 28);
			lblbibliotech.setFont(new Font("Sylfaen", Font.PLAIN, 21));
			contentPanel.add(lblbibliotech);
		}
		{
			JLabel label = new JLabel("");
			label.setBounds(637, 491, 28, 28);
			label.setIcon(new ImageIcon("src/images/iconos/Instagram.png"));
			contentPanel.add(label);
		}
		{
			JLabel lblSguenosEn = new JLabel("S\u00EDguenos en:");
			lblSguenosEn.setBounds(638, 448, 161, 28);
			lblSguenosEn.setFont(new Font("Sylfaen", Font.PLAIN, 21));
			contentPanel.add(lblSguenosEn);
		}
		contentPanel.add(getBtnSalir());
		contentPanel.add(getLblNewLabel());
		contentPanel.add(getTxtpnelConocimientoDebe());
		contentPanel.add(getTxtpnEsteProyectoHa());
		contentPanel.add(getLblalvarotamayo());
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("");
			btnSalir.setBorder(null);
			btnSalir.setIcon(new ImageIcon("C:\\Users\\Jenny\\Desktop\\Eclipse\\ProyectoFinal\\src\\images\\iconos\\otroLogoBorrar50x50.png"));
			btnSalir.setBackground(Color.WHITE);
			btnSalir.setBounds(957, 11, 50, 50);
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
		}
		return btnSalir;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Jenny\\Desktop\\Eclipse\\ProyectoFinal\\src\\images\\acercadee.jpg"));
			lblNewLabel.setBounds(1, 1, 397, 561);
		}
		return lblNewLabel;
	}
	private JTextPane getTxtpnelConocimientoDebe() {
		if (txtpnelConocimientoDebe == null) {
			txtpnelConocimientoDebe = new JTextPane();
			txtpnelConocimientoDebe.setFont(new Font("Segoe UI", Font.PLAIN, 26));
			txtpnelConocimientoDebe.setText("\u201CEl conocimiento debe ser tan accesible como \r\nun buen libro en una biblioteca abierta.\u201D");
			txtpnelConocimientoDebe.setFocusable(false);
			txtpnelConocimientoDebe.setBackground(Color.WHITE);
			txtpnelConocimientoDebe.setBounds(423, 80, 553, 95);
		}
		return txtpnelConocimientoDebe;
	}
	private JTextPane getTxtpnEsteProyectoHa() {
		if (txtpnEsteProyectoHa == null) {
			txtpnEsteProyectoHa = new JTextPane();
			txtpnEsteProyectoHa.setText("Este proyecto ha sido desarrollado como parte del trabajo final de la asignatura Dise\u00F1o y Programaci\u00F3n Orientada a Objetos (DPOO).\r\n\r\nNos hemos esforzado por ofrecer una soluci\u00F3n automatizada, elegante y funcional para la gesti\u00F3n de esta biblioteca.");
			txtpnEsteProyectoHa.setFont(new Font("Segoe UI", Font.PLAIN, 20));
			txtpnEsteProyectoHa.setFocusable(false);
			txtpnEsteProyectoHa.setBackground(Color.WHITE);
			txtpnEsteProyectoHa.setBounds(423, 203, 584, 193);
		}
		return txtpnEsteProyectoHa;
	}
	private JLabel getLblalvarotamayo() {
		if (lblalvarotamayo == null) {
			lblalvarotamayo = new JLabel("@alvaro_tamayo_");
			lblalvarotamayo.setFont(new Font("Sylfaen", Font.PLAIN, 21));
			lblalvarotamayo.setBounds(826, 491, 181, 28);
		}
		return lblalvarotamayo;
	}
}
