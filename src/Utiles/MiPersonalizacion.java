package Utiles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.formdev.flatlaf.util.UIScale;

public class MiPersonalizacion extends FlatLightLaf {

	public static void aplicarTema() {
		// Configurar el tema base
		FlatMacLightLaf.setup();

		// Paleta de colores
		Color beigeClaro = new Color(0xE6D5B8);
		Color grisClaro = new Color(0xE0E0E0);
		Color grisMuyClaro = new Color(0xF0F0F0);
		Color grisBorde = new Color(0xD0D0D0);
		Color blanco = Color.WHITE;

		// Configuración general
		UIManager.put("@baseTheme", "MacLight");

		// Botones
		UIManager.put("Button.arc", 199);
		UIManager.put("Button.background", Colores.getColorbeige());
		UIManager.put("Component.arc", 199);

		// Combobox
		UIManager.put("ComboBox.buttonStyle", "button");

		// Campos de contraseña
		UIManager.put("PasswordField.showCapsLock", true);
		UIManager.put("PasswordField.showRevealButton", true);
		UIManager.put("PasswordField.capsLockIcon", 
				MiPersonalizacion.class.getResource("/com/myapp/icons/caps_warning.png"));

		// Barra de menú
		UIManager.put("MenuBar.hoverBackground", grisClaro);

		UIManager.put( "JDateChooser.background", Color.WHITE);
		UIManager.put( "JDateChooser.foreground", Color.BLACK);
		UIManager.put( "JDateChooser.border", BorderFactory.createLineBorder(new Color(0xcccccc)));
		UIManager.put( "JDateChooser.font", new Font("Segoe UI", Font.PLAIN, 12));

		UIManager.put("Component.arc", 199);
        
		UIManager.put("List.background", Color.WHITE);
		UIManager.put("List.selectionBackground", new Color(51, 153, 255));
		UIManager.put("List.selectionForeground", Color.WHITE);
		
        // Configuración de fuente
        Font optionPaneFont = new Font("Segoe UI", Font.PLAIN, 13);
        UIManager.put("OptionPane.font", optionPaneFont);
        
        // Configuración de botones
        UIManager.put("OptionPane.background", Color.WHITE);
        
        // Textos personalizados para botones
        UIManager.put("OptionPane.yesButtonText", "Confirmar");
        UIManager.put("OptionPane.noButtonText", "Cancelar");
        UIManager.put("OptionPane.okButtonText", "Aceptar");
		
		// Barra de progreso
		UIManager.put("ProgressBar.arc", 199);

		// Tooltips
		UIManager.put("ToolTip.background", new Color(0xF2F4F6));

		// Listas
		UIManager.put("List.font", new Font("Segoe UI", Font.PLAIN, 13));

		// Tablas
		UIManager.put("Table.background", blanco);
		UIManager.put("Table.gridColor", grisClaro);
		UIManager.put("TableHeader.cellBorder", BorderFactory.createMatteBorder(0, 0, 1, 0, grisBorde));
		UIManager.put("Table.cellMargins", new Insets(4, 8, 4, 8));
		UIManager.put("Table.showVerticalLines", true);
		UIManager.put("Table.intercellSpacing", new Dimension(0, 0));
		UIManager.put("Table.rowHeight", 22);

		// Escritorio (MDI)
		UIManager.put("Desktop.background", grisMuyClaro);
		UIManager.put("DesktopIcon.background", grisClaro);
		UIManager.put("DesktopIcon.border", BorderFactory.createDashedBorder(grisBorde, 1, 1, 1, false));

		// Actualizar la UI
		FlatMacLightLaf.updateUI();
	}

	// Método para cargar recursos (iconos)
	private static ImageIcon loadIcon(String path) {
		return new ImageIcon(MiPersonalizacion.class.getResource(path));
	}
}
