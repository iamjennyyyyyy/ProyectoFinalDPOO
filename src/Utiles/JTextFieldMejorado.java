package Utiles;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

public class JTextFieldMejorado extends JTextField {
	public JTextFieldMejorado() {
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
                if(!(Character.isLetter(c) || c == ' ' || c == KeyEvent.VK_BACK_SPACE)) {
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
