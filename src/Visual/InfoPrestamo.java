package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;

public class InfoPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextPane txtpnInformacinATener;

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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/iconoInfo40x40.png"));
		setTitle("Informaci\u00F3n");
		setModal(true);
		setBounds(450, 200, 530, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.menu);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getTxtpnInformacinATener());
	}
	private JTextPane getTxtpnInformacinATener() {
		if (txtpnInformacinATener == null) {
			txtpnInformacinATener = new JTextPane();
			txtpnInformacinATener.setEditable(false);
			txtpnInformacinATener.setBackground(SystemColor.menu);
			txtpnInformacinATener.setFont(new Font("SansSerif", Font.PLAIN, 15));
			txtpnInformacinATener.setText("Informaci\u00F3n a tener en cuenta sobre la realizaci\u00F3n de pr\u00E9stamos:\r\n\r\nSolo podr\u00E1n solicitar pr\u00E9stamos los usuarios acreditados en la biblioteca. \r\nLa biblioteca solo conceder\u00E1 en pr\u00E9stamo las publicaciones de las que disponga de m\u00E1s \r\nde 2 ejemplares.\r\n \r\nUn usuario puede tener simult\u00E1neamente hasta tres publicaciones en pr\u00E9stamo, por lo que, si trata de solicitar alguno m\u00E1s, debe neg\u00E1rsele. Un usuario no puede solicitar en pr\u00E9stamo la misma bibliograf\u00EDa sin que hayan transcurrido dos semanas desde que la devolvi\u00F3.\r\n\r\nUna vez que un pr\u00E9stamo es concedido se conservar\u00E1 la informaci\u00F3n necesaria para la gesti\u00F3n de este. La informaci\u00F3n consta de la fecha del pr\u00E9stamo, fecha de plazo m\u00E1ximo para la devoluci\u00F3n, publicaci\u00F3n prestada, usuario y bibliotecario que efectu\u00F3 el pr\u00E9stamo.");
			txtpnInformacinATener.setBounds(10, 11, 494, 353);
		}
		return txtpnInformacinATener;
	}
}
