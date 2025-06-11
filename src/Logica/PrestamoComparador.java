package Logica;

import java.util.Comparator;

public class PrestamoComparador implements Comparator<Prestamo> {

	int i = 0;
	
	@Override
    public int compare(Prestamo p1, Prestamo p2) {
		if (p1 == p2) i = 0;
        if (p1 == null) i = -1;
        if (p2 == null) i = 1;
        
        // Manejo seguro de fechas nulas
        if (p1.getFechaMax() == null && p2.getFechaMax() == null) i = 0;
        if (p1.getFechaMax() == null) i = -1;
        if (p2.getFechaMax() == null) i = 1;
        
        // Comparación segura
        i = p1.getFechaMax().compareTo(p2.getFechaMax());
        
        return i;
    }
}
