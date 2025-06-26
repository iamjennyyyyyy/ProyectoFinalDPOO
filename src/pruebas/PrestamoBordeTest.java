package pruebas;

import Logica.*;

import org.junit.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class PrestamoBordeTest {

    private Libro libro;
    private UsuarioAcreditado usuario;
    private Trabajador trabajador;

    @Before
    public void setUp() {
        libro = new Libro("L1", "LimiteLibro", "Ensayo", 50, 3, "Autor", "Editorial");
        usuario = new UsuarioAcreditado("99060112345", "Borde Usuario");
        trabajador = new Trabajador("99070112345", "Borde Trabajador", "Lic.", "Auxiliar");
    }

    // 1. Préstamo con fecha de préstamo y fecha máxima iguales
    @Test
    public void testFechaPrestamoIgualFechaMaxima() {
        LocalDate fecha = LocalDate.now();
        Prestamo p = new Prestamo(fecha, fecha, libro, usuario, trabajador);
        assertEquals(fecha, p.getFechaP());
        assertEquals(fecha, p.getFechaMax());
        assertNull(p.getFechaDevolucion());
    }

    // 2. Préstamo con fecha de devolución exactamente en fecha máxima (no hay penalización)
    @Test
    public void testDevolucionEnFechaMaximaSinPenalizacion() {
        LocalDate fechaPrestamo = LocalDate.now().minusDays(7);
        LocalDate fechaMax = LocalDate.now();
        Prestamo p = new Prestamo(fechaPrestamo, fechaMax, fechaMax, libro, usuario, trabajador);
        assertNull(usuario.getFechaPenalizacion());
    }

    // 3. Préstamo con fecha de devolución justo un día después de la fecha máxima
    @Test
    public void testDevolucionUnDiaTardePenalizacionMinima() {
        LocalDate fechaPrestamo = LocalDate.now().minusDays(8);
        LocalDate fechaMax = LocalDate.now().minusDays(1);
        LocalDate fechaDev = LocalDate.now();
        Prestamo p = new Prestamo(fechaPrestamo, fechaMax, fechaDev, libro, usuario, trabajador);
        // Penalización debe ser 3 días después de devolución
        LocalDate esperado = fechaDev.plusDays(3);
        assertEquals(esperado, usuario.getFechaPenalizacion());
    }

    // 4. Prórroga sobre préstamo con fecha máxima justo antes de overflow de mes
    @Test
    public void testProrrogaCercaDeCambioDeMes() {
        LocalDate fechaPrestamo = LocalDate.of(2025, 1, 30);
        LocalDate fechaMax = LocalDate.of(2025, 1, 31);
        Prestamo p = new Prestamo(fechaPrestamo, fechaMax, libro, usuario, trabajador);
        int dias = libro.tiempoMaximoPrestamo();
        p.concederProrroga();
        LocalDate esperado = fechaMax.plusDays(dias / 2);
        assertEquals(esperado, p.getFechaMax());
    }

    // 5. Préstamo con fecha de devolución anterior a fecha máxima (devolución anticipada)
    @Test
    public void testDevolucionAnticipadaSinPenalizacion() {
        LocalDate fechaPrestamo = LocalDate.now().minusDays(5);
        LocalDate fechaMax = LocalDate.now().plusDays(10);
        LocalDate fechaDev = LocalDate.now();
        Prestamo p = new Prestamo(fechaPrestamo, fechaMax, fechaDev, libro, usuario, trabajador);
        assertNull(usuario.getFechaPenalizacion());
    }

    // 6. equals: préstamos con mismo usuario, libro y fecha de préstamo pero distinta fecha máxima
    @Test
    public void testEqualsMismaFechaPrestamoYUsuarioYLlbro() {
        LocalDate fechaPrestamo = LocalDate.now();
        Prestamo p1 = new Prestamo(fechaPrestamo, fechaPrestamo.plusDays(5), libro, usuario, trabajador);
        Prestamo p2 = new Prestamo(fechaPrestamo, fechaPrestamo.plusDays(10), libro, usuario, trabajador);
        assertEquals(p1, p2); // equals ignora fechaMax
    }

    // 7. equals: préstamos con diferente usuario pero todo lo demás igual
    @Test
    public void testNotEqualsUsuarioDistinto() {
        UsuarioAcreditado otroUsuario = new UsuarioAcreditado("99060154321", "Otro Usuario");
        LocalDate fechaPrestamo = LocalDate.now();
        Prestamo p1 = new Prestamo(fechaPrestamo, fechaPrestamo.plusDays(5), libro, usuario, trabajador);
        Prestamo p2 = new Prestamo(fechaPrestamo, fechaPrestamo.plusDays(5), libro, otroUsuario, trabajador);
        assertNotEquals(p1, p2);
    }

    // 8. equals: préstamos con diferente libro pero todo lo demás igual
    @Test
    public void testNotEqualsLibroDistinto() {
        Libro otroLibro = new Libro("L2", "LimiteLibro2", "Ensayo", 60, 4, "Autor", "Editorial");
        LocalDate fechaPrestamo = LocalDate.now();
        Prestamo p1 = new Prestamo(fechaPrestamo, fechaPrestamo.plusDays(5), libro, usuario, trabajador);
        Prestamo p2 = new Prestamo(fechaPrestamo, fechaPrestamo.plusDays(5), otroLibro, usuario, trabajador);
        assertNotEquals(p1, p2);
    }

    // 9. Creación de préstamo con fechas muy antiguas (año 1900)
    @Test
    public void testPrestamoConFechasAntiguas() {
        LocalDate fechaPrestamo = LocalDate.of(1900, 1, 1);
        LocalDate fechaMax = LocalDate.of(1900, 1, 15);
        Prestamo p = new Prestamo(fechaPrestamo, fechaMax, libro, usuario, trabajador);
        assertEquals(fechaPrestamo, p.getFechaP());
        assertEquals(fechaMax, p.getFechaMax());
    }

    // 10. Setters: cambiar publicación, usuario y trabajador varias veces
    @Test
    public void testSettersMultiples() {
        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(10), libro, usuario, trabajador);
        Libro libro2 = new Libro("L3", "Libro3", "Drama", 20, 5, "NuevoAutor", "NuevaEd");
        UsuarioAcreditado usuario2 = new UsuarioAcreditado("99060212345", "Segundo Usuario");
        Trabajador trabajador2 = new Trabajador("99070212345", "Segundo Trabajador", "Lic.", "Aux");
        p.setPub(libro2);
        p.setUser(usuario2);
        p.setTrabPrestamo(trabajador2);
        assertEquals(libro2, p.getPub());
        assertEquals(usuario2, p.getUser());
        assertEquals(trabajador2, p.getTrabPrestamo());
    }

}
