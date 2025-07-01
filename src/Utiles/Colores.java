package Utiles;

import java.awt.Color;

public class Colores {
	private static final Color beigeTabla = new Color(209,184,148);//(177,149,113);//(255, 217, 194);//255, 220, 187);//(213, 184, 149);
	private static final Color contrasteTabla = new Color(229, 222, 199);
	private static final Color fondo = new Color(215,208,182);//(250, 245, 240);      // fondo general (pastel beige)
	private static final Color cruds = new Color(245, 245, 220);
 	
	public static Color getCruds() {
		return cruds;
	}
	
	public static Color getFondo() {
		return fondo;
	}

	public static Color getBeigetabla() {
		return beigeTabla;
	}

	public static Color getContrastetabla() {
		return contrasteTabla;
	}
}