package pruebas;

import Logica.*;

import org.junit.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class BibliotecaFuerteTest {
	

	    private Biblioteca biblioteca;

	    @Before
	    public void setUp() {
	        biblioteca = Biblioteca.getInstancia();
	        biblioteca.setTrabajadores(new ArrayList<Trabajador>());
	        biblioteca.setUsuarios(new ArrayList<UsuarioAcreditado>());
	        biblioteca.setPrestamosTotales(new ArrayList<Prestamo>());
	        biblioteca.getPublicaciones().clear();
	    }

	    // 1. Préstamo con stock insuficiente (<3 ejemplares)
	    @Test(expected = IllegalArgumentException.class)
	    public void testSolicitarPrestamo_StockInsuficiente() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99030112345", "Juan Pérez");
	        Trabajador trabajador = new Trabajador("212345", "Ana López", "Lic.", "Auxiliar");
	        Publicacion libroPocoStock = new Libro("L2", "Sin Stock", "Literatura", 200, 2, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libroPocoStock);
	        biblioteca.solicitarPrestamo(usuario, libroPocoStock, trabajador);
	    }

	    // 2. Préstamo a usuario penalizado
	    @Test(expected = IllegalArgumentException.class)
	    public void testSolicitarPrestamo_UsuarioPenalizado() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99030312345", "Maria Penalizada");
	        Trabajador trabajador = new Trabajador("99030412345", "Ana López", "Lic.", "Auxiliar");
	        Publicacion libro = new Libro("L3", "Penalización", "Literatura", 300, 5, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libro);
	        usuario.setFechaPenalizacion(LocalDate.now().plusDays(3));
	        biblioteca.solicitarPrestamo(usuario, libro, trabajador);
	    }

	    // 3. Préstamo con usuario con 3 préstamos activos
	    @Test(expected = IllegalArgumentException.class)
	    public void testSolicitarPrestamo_UsuarioCon3Prestamos() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99030512345", "Saturado");
	        Trabajador trabajador = new Trabajador("99030612345", "Auxiliar", "Lic.", "Auxiliar");
	        for (int i = 0; i < 3; i++) {
	            Publicacion pub = new Libro("L"+(i+10), "Libro"+i, "Literatura", 100, 5, "Autor", "Ed");
	            biblioteca.getPublicaciones().add(pub);
	            Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), pub, usuario, trabajador);
	            usuario.agregarPrestamo(p);
	            biblioteca.getPrestamosTotales().add(p);
	        }
	        Publicacion libro = new Libro("L20", "Extra", "Literatura", 150, 5, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libro);
	        biblioteca.solicitarPrestamo(usuario, libro, trabajador);
	    }

	    // 4. Préstamo duplicado (ya tiene préstamo activo de esa publicación)
	    @Test(expected = IllegalArgumentException.class)
	    public void testSolicitarPrestamo_RepetidoSinDevolver() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99030712345", "Duplicado");
	        Trabajador trabajador = new Trabajador("99030812345", "Auxiliar", "Lic.", "Auxiliar");
	        Publicacion libro = new Libro("L30", "Duplicado", "Literatura", 300, 5, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libro);
	        Prestamo p = new Prestamo(LocalDate.now(), LocalDate.now().plusDays(7), libro, usuario, trabajador);
	        usuario.agregarPrestamo(p);
	        biblioteca.getPrestamosTotales().add(p);
	        biblioteca.solicitarPrestamo(usuario, libro, trabajador);
	    }

	    // 5. Préstamo antes de esperar 2 semanas desde la última devolución
	    @Test(expected = IllegalArgumentException.class)
	    public void testSolicitarPrestamo_RepetidoSinEsperar2Semanas() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99030912345", "Impaciente");
	        Trabajador trabajador = new Trabajador("99031012345", "Auxiliar", "Lic.", "Auxiliar");
	        Publicacion libro = new Libro("L40", "Pronto", "Literatura", 300, 5, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libro);
	        Prestamo p = new Prestamo(LocalDate.now().minusDays(15), LocalDate.now().minusDays(8), libro, usuario, trabajador);
	        p.setFechaDevolucion(LocalDate.now().minusDays(8)); // devuelto hace 8 días
	        usuario.agregarPrestamo(p);
	        biblioteca.getPrestamosTotales().add(p);
	        biblioteca.solicitarPrestamo(usuario, libro, trabajador);
	    }

	    // 6. Devolver una publicación ya devuelta
	    @Test(expected = IllegalArgumentException.class)
	    public void testDevolverPublicacion_YaDevuelta() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99031112345", "Devolvedor");
	        Trabajador trabajador = new Trabajador("99031212345", "Auxiliar", "Lic.", "Auxiliar");
	        Publicacion libro = new Libro("L50", "Devuelto", "Literatura", 300, 5, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libro);
	        Prestamo p = new Prestamo(LocalDate.now().minusDays(10), LocalDate.now().minusDays(3), libro, usuario, trabajador);
	        p.setFechaDevolucion(LocalDate.now());
	        biblioteca.getPrestamosTotales().add(p);
	        biblioteca.devolverPublicacion(p);
	    }

	    // 7. Prórroga sobre préstamo no activo
	    @Test(expected = IllegalArgumentException.class)
	    public void testRealizarProrroga_PrestamoNoActivo() {
	        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("99031312345", "Prorroga");
	        Trabajador trabajador = new Trabajador("99031412345", "Auxiliar", "Lic.", "Auxiliar");
	        Publicacion libro = new Libro("L60", "Prorroga", "Literatura", 300, 5, "Autor", "Ed");
	        biblioteca.getPublicaciones().add(libro);
	        Prestamo p = new Prestamo(LocalDate.now().minusDays(10), LocalDate.now().minusDays(3), libro, usuario, trabajador);
	        p.setFechaDevolucion(LocalDate.now());
	        biblioteca.realizarProrroga(p);
	    }

	    // 8. Prórroga sobre null
	    @Test(expected = IllegalArgumentException.class)
	    public void testRealizarProrroga_PrestamoNull() {
	        biblioteca.realizarProrroga(null);
	    }
	}