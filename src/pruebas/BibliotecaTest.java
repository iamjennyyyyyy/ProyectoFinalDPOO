package pruebas;

import Logica.*;

import org.junit.*;
import java.time.LocalDate;
import java.util.ArrayList;

// Primeros test completados en la clase Biblioteca
// se corrige un error a la hora de crear un usuario acreditado

public class BibliotecaTest {

    private Biblioteca biblioteca;

    @Before
    public void setUp() {
        biblioteca = Biblioteca.getInstancia();
        // Limpia las colecciones si es necesario, dependiendo del patrón singleton
        biblioteca.setTrabajadores(new ArrayList<Trabajador>());
        biblioteca.setUsuarios(new ArrayList<UsuarioAcreditado>());
        biblioteca.setPrestamosTotales(new ArrayList<Prestamo>());
        biblioteca.getPublicaciones().clear();
    }

    @Test
    public void testCrearUsuarioAcreditado() {
        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("05021768483", "Juan Pérez");
        Assert.assertNotNull(usuario);
        Assert.assertEquals("05021768483", usuario.getId());
        Assert.assertEquals("Juan Pérez", usuario.getNombreCompleto());
        Assert.assertTrue(biblioteca.getUsuarios().contains(usuario));
    }

    @Test
    public void testAgregarLibro() {
        biblioteca.agregarLibro("L1", "1984", "Literatura", 300, 5, "Orwell", "Planeta");
        Publicacion libro = biblioteca.buscarPublicacionPorId("L1");
        Assert.assertNotNull(libro);
        Assert.assertEquals("1984", libro.getTitulo());
    }

    @Test
    public void testSolicitarPrestamo_Exito() {
        biblioteca.agregarLibro("L2", "El Quijote", "Literatura", 500, 5, "Cervantes", "Espasa");
        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("05021768480", "Maria Lopez");
        Trabajador trabajador = new Trabajador("05021768484", "Ana", "Lic.", "Auxiliar");
        Publicacion libro = biblioteca.buscarPublicacionPorId("L2");

        Prestamo prestamo = biblioteca.solicitarPrestamo(usuario, libro, trabajador);
        Assert.assertNotNull(prestamo);
        Assert.assertEquals(usuario, prestamo.getUser());
        Assert.assertEquals(libro, prestamo.getPub());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSolicitarPrestamo_FallaPorStock() {
        biblioteca.agregarLibro("L3", "Sin Stock", "Literatura", 200, 2, "Autor", "Ed");
        UsuarioAcreditado usuario = biblioteca.crearUsuarioAcreditado("05021768481", "Carlos Soto");
        Trabajador trabajador = new Trabajador("T2", "Luis", "Lic.", "Auxiliar");
        Publicacion libro = biblioteca.buscarPublicacionPorId("L3");

        biblioteca.solicitarPrestamo(usuario, libro, trabajador);
    }

    // Puedes seguir agregando tests para los métodos más críticos, como devolverPublicacion, buscarPrestamoPorPosicion, etc.

}