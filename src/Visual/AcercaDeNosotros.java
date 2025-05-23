package Visual;

import javax.swing.JPanel;
import java.awt.CardLayout;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

public class AcercaDeNosotros extends JPanel {

	private static boolean acercaDeNosotros;
	private JPanel acercaCentro = new JPanel();
	private JPanel acercaNosotros = new JPanel();
	private JLabel lblBibliotecaMunicipal;
	private static AcercaDeNosotros instancia; // Singleton

	/**
	 * Create the panel.
	 */

	public static boolean isAcercaDeNosotros() {
		return acercaDeNosotros;
	}

	public static void setAcercaDeNosotros(boolean acercaDeNosotros) {
		AcercaDeNosotros.acercaDeNosotros = acercaDeNosotros;
	}

	// Singleton patron
	public static AcercaDeNosotros getInstancia() {
		if (instancia == null) {
			instancia = new AcercaDeNosotros();
		}
		return instancia;
	}

	public AcercaDeNosotros() {
		
		setVisible(true);
		setLayout(new CardLayout(0, 0));
		add(getAcercaNosotros(), "name_459844940477400");
		setLayout(new CardLayout(0, 0));
		setLayout(new CardLayout(0, 0));
		setLayout(new CardLayout(0, 0));
		add(getAcercaCentro(), "name_454690496245400");
		add(getAcercaNosotros(), "name_461525054406300");
		if(acercaDeNosotros){
			acercaNosotros.setVisible(true);
			acercaCentro.setVisible(false);
		}
		else{
			acercaNosotros.setVisible(false);
			acercaCentro.setVisible(true);
		}
	}

	private JPanel getAcercaCentro() {
		if (acercaCentro == null) {
			acercaCentro = new JPanel();
			acercaCentro.setBackground(Color.YELLOW);
			acercaCentro.add(getLblBibliotecaMunicipal(), "name_461582992669300");
		}
		return acercaCentro;
	}
	private JLabel getLblBibliotecaMunicipal() {
		if (lblBibliotecaMunicipal == null) {
			lblBibliotecaMunicipal = new JLabel("Biblioteca Municipal");
			lblBibliotecaMunicipal.setFont(new Font("SansSerif", Font.PLAIN, 19));
		}
		return lblBibliotecaMunicipal;
	}
	private JPanel getAcercaNosotros() {
		if (acercaNosotros == null) {
			acercaNosotros = new JPanel();
			acercaNosotros.setBackground(Color.MAGENTA);
		}
		return acercaNosotros;
	}
}
