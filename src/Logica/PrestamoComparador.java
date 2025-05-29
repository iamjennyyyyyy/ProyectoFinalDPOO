package Logica;

import java.util.Comparator;

public class PrestamoComparador implements Comparator<Prestamo> {

	@Override
    public int compare(Prestamo p1, Prestamo p2) {
		if (p1 == p2) return 0;
        if (p1 == null) return -1;
        if (p2 == null) return 1;
        
        // Manejo seguro de fechas nulas
        if (p1.getFechaMax() == null && p2.getFechaMax() == null) return 0;
        if (p1.getFechaMax() == null) return -1;
        if (p2.getFechaMax() == null) return 1;
        
        // Comparación segura
        return p1.getFechaMax().compareTo(p2.getFechaMax());
    }
}
