package Utiles;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class JTextFieldCarnet extends JTextField {

	public JTextFieldCarnet() {
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// Verificar límite de caracteres
				if(limite > 0 && getText().length() >= limite) {
					e.consume();
					return;
				}

				// Solo permitir letras (incluyendo ñ, Ñ y acentos) y espacios
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE)) {
					e.consume();
				}
			}
		});
	}

	private int limite = -1;

	public int getLimite() {
		return this.limite;
	}

	public void setLimite(int limite) {
		if(limite >= -1)
			this.limite = limite;
	}
}
