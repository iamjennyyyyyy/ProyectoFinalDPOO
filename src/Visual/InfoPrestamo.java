package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.SystemColor;

public class InfoPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane txtpnLaBibliotecaSolo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InfoPrestamo dialog = new InfoPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InfoPrestamo() {
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/iconos/libros.png"));
		setTitle("Informaci\u00F3n para realizar un pr\u00E9stamo");
		setBounds(400, 130, 599, 454);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTxtpnLaBibliotecaSolo());
	}
	private JTextPane getTxtpnLaBibliotecaSolo() {
		if (txtpnLaBibliotecaSolo == null) {
			txtpnLaBibliotecaSolo = new JTextPane();
			txtpnLaBibliotecaSolo.setFont(new Font("Segoe UI", Font.PLAIN, 17));
			txtpnLaBibliotecaSolo.setText("La biblioteca solo conceder\u00E1 en pr\u00E9stamo las publicaciones \r\nde las que disponga de m\u00E1s de 2 ejemplares. En todo momento \r\nla biblioteca conservar\u00E1 en sus instalaciones al menos 2 \r\nejemplares de las publicaciones que puede conceder en pr\u00E9stamo. \r\n\r\nUn usuario puede tener simult\u00E1neamente hasta \r\ntres publicaciones en pr\u00E9stamo, si trata de solicitar alguno m\u00E1s,\r\ndebe neg\u00E1rsele. \r\n\r\nSolo se podr\u00E1 conceder como pr\u00F3rroga la mitad del tiempo \r\nm\u00E1ximo de pr\u00E9stamo. Un usuario no puede solicitar en pr\u00E9stamo \r\nla misma bibliograf\u00EDa sin que hayan transcurrido dos semanas \r\ndesde que la devolvi\u00F3. Si la devoluci\u00F3n se hace fuera del plazo \r\notorgado, se aplica una penalizaci\u00F3n que impide al usuario solicitar \r\nun pr\u00E9stamo durante tres veces del tiempo de retraso. ");
			txtpnLaBibliotecaSolo.setFocusable(false);
			txtpnLaBibliotecaSolo.setEditable(false);
			txtpnLaBibliotecaSolo.setBackground(SystemColor.menu);
			txtpnLaBibliotecaSolo.setBounds(27, 25, 523, 380);
		}
		return txtpnLaBibliotecaSolo;
	}
}
