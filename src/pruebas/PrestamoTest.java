package pruebas;
import Logica.*;

import org.junit.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PrestamoTest {

    private Libro libro;
    private UsuarioAcreditado usuario;
    private Trabajador trabajador;

    @Before
    public void setUp() {
        libro = new Libro("L1", "TestLibro", "Novela", 100, 5, "Autor", "Editorial");
        usuario = new UsuarioAcreditado("99030112345", "Juan Pérez");
        trabajador = new Trabajador("99030212345", "Ana López", "Lic.", "Auxiliar");
    }

    // 1. Constructor exitoso
    @Test
    public void testConstructorExitoso() {
        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, usuario, trabajador);
        assertNotNull(p);
        assertEquals(libro, p.getPub());
        assertEquals(usuario, p.getUser());
        assertEquals(trabajador, p.getTrabPrestamo());
    }

    // 2. Constructor con parámetros nulos lanza excepción
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_PubNull() {
        new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), null, usuario, trabajador);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_UserNull() {
        new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, null, trabajador);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testConstructor_TrabajadorNull() {
        new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, usuario, null);
    }

    // 3. Penalización por devolución tardía
    @Test
    public void testPenalizacionPorDevolucionTardia() {
        LocalDate fechaPrestamo = LocalDate.now().minusDays(10);
        LocalDate fechaMax = LocalDate.now().minusDays(5);
        LocalDate fechaDev = LocalDate.now();
        Prestamo p = new Prestamo(fechaPrestamo, fechaMax, fechaDev, libro, usuario, trabajador);
        // Penalización: (fechaDev - fechaMax).getDays() * 3 días
        int diasRetraso = (int) java.time.temporal.ChronoUnit.DAYS.between(fechaMax, fechaDev);
        LocalDate fechaPenalizacionEsperada = fechaDev.plusDays(diasRetraso * 3);
        assertEquals(fechaPenalizacionEsperada, usuario.getFechaPenalizacion());
    }

    // 4. Setters de validación
    @Test(expected = IllegalArgumentException.class)
    public void testSetPubNull() {
        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, usuario, trabajador);
        p.setPub(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetUserNull() {
        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, usuario, trabajador);
        p.setUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetTrabPrestamoNull() {
        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, usuario, trabajador);
        p.setTrabPrestamo(null);
    }

    // 5. Prórroga
    @Test
    public void testConcederProrroga() {
        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(10), libro, usuario, trabajador);
        int tiempoOriginal = libro.tiempoMaximoPrestamo();
        LocalDate fechaMaxAnt = p.getFechaMax();
        p.concederProrroga();
        assertEquals(fechaMaxAnt.plusDays(tiempoOriginal / 2), p.getFechaMax());
    }

    // 6. equals
    @Test
    public void testEquals() {
        Prestamo p1 = new Prestamo(LocalDate.of(2025,6,26), LocalDate.of(2025,7,3), libro, usuario, trabajador);
        Prestamo p2 = new Prestamo(LocalDate.of(2025,6,26), LocalDate.of(2025,7,3), libro, usuario, trabajador);
        assertEquals(p1, p2);
    }

    @Test
    public void testNotEquals() {
        Prestamo p1 = new Prestamo(LocalDate.of(2025,6,26), LocalDate.of(2025,7,3), libro, usuario, trabajador);
        Libro libro2 = new Libro("L2", "OtroLibro", "Novela", 120, 3, "OtroAutor", "OtraEditorial");
        Prestamo p2 = new Prestamo(LocalDate.of(2025,6,26), LocalDate.of(2025,7,3), libro2, usuario, trabajador);
        assertNotEquals(p1, p2);
    }
}