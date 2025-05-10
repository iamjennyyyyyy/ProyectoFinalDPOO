import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {

		// 1. Crear trabajadores
		ArrayList<Trabajador> trabajadores = new ArrayList<Trabajador>();
		Trabajador trabajador1 = new Trabajador(
				1, 
				"Ana López García", 
				35, 
				'F', 
				LocalDate.of(1988, 5, 15), 
				"Universitario", 
				"Bibliotecario Jefe"
				);
		Trabajador trabajador2 = new Trabajador(
				2, 
				"Carlos Martínez Ruiz", 
				28, 
				'M', 
				LocalDate.of(1995, 10, 22), 
				"Técnico Medio", 
				"Auxiliar de Biblioteca"
				);
		trabajadores.add(trabajador1);
		trabajadores.add(trabajador2);

		// 2. Crear usuarios acreditados
		ArrayList<UsuarioAcreditado> usuarios = new ArrayList<UsuarioAcreditado>();
		UsuarioAcreditado usuario1 = new UsuarioAcreditado(
				101, 
				"María Fernández Sánchez", 
				25, 
				'F', 
				LocalDate.of(1998, 3, 10), 
				1001, 
				LocalDate.of(2023, 1, 15)
				);
		UsuarioAcreditado usuario2 = new UsuarioAcreditado(
				102, 
				"Juan Pérez López", 
				30, 
				'M', 
				LocalDate.of(1993, 7, 5), 
				1002, 
				LocalDate.of(2023, 2, 20)
				);
		usuarios.add(usuario1);
		usuarios.add(usuario2);

		// 3. Crear libros
		ArrayList<Libro> libros = new ArrayList<Libro>();
		ArrayList<String> autores = new ArrayList<String>();
		autores.add("Gabriel García Márquez");
		Libro libro1 = new Libro(
				1001, 
				"Cien años de soledad", 
				"Novela", 
				432, 
				3, 
				false, 
				autores, 
				"Sudamericana"
				);
		ArrayList<String> autores2 = new ArrayList<String>();
		autores2.add("Patrick Rothfuss");
		Libro libro2 = new Libro(
				1002, 
				"El nombre del viento", 
				"Fantasía", 
				462, 
				4, 
				false, 
				autores2, 
				"Plaza Janes"
				);
		libros.add(libro1);
		libros.add(libro2);

		// 4. Crear revistas (nota: se necesitan añadir anno y num después)
		ArrayList<Revista> revistas = new ArrayList<Revista>();
		Revista revista1 = new Revista(
				2001, 
				"National Geographic", 
				"Ciencia", 
				100, 
				10, 
				false
				);
		// Suponiendo que existen estos métodos setters
		revista1.setAnno(2023);
		revista1.setNum(5);

		Revista revista2 = new Revista(
				2002, 
				"Muy Interesante", 
				"Divulgación", 
				80, 
				8, 
				false
				);
		revista2.setAnno(2023);
		revista2.setNum(6);

		revistas.add(revista1);
		revistas.add(revista2);

		// 5. Crear artículos
		ArrayList<Articulo> articulos = new ArrayList<Articulo>();
		ArrayList<String> autores3 = new ArrayList<String>();
		autores3.add("Dr. Alan Turing");
		ArrayList<String> arbitros = new ArrayList<String>();
		arbitros.add("Dr. John McCarthy");
		Articulo articulo1 = new Articulo(
				3001, 
				"Machine Learning aplicado a diagnóstico médico", 
				"Tecnología", 
				15, 
				2, 
				false, 
				autores3, 
				arbitros
				);
		ArrayList<String> autores4 = new ArrayList<String>();
		autores4.add("Dra. Sylvia Earle");
		ArrayList<String> arbitros2 = new ArrayList<String>();
		arbitros2.add("Dr. James Hansen");
		Articulo articulo2 = new Articulo(
				3002, 
				"Impacto del cambio climático en ecosistemas marinos", 
				"Ecología", 
				20, 
				3, 
				false, 
				autores4, 
				arbitros2
				);
		articulos.add(articulo1);
		articulos.add(articulo2);

		// 6. Crear préstamos
		ArrayList<Prestamo> prestamosTotales = new ArrayList<Prestamo>();

		// Primer préstamo (libro)
		LocalDateTime fechaPrestamo1 = LocalDateTime.of(2023, 5, 1, 10, 30);
		LocalDateTime fechaMaxDevolucion1 = fechaPrestamo1.plusDays(15);
		Prestamo prestamo1 = new Prestamo(
				fechaPrestamo1, 
				fechaMaxDevolucion1, 
				libro1, 
				usuario1, 
				trabajador1
				);
		prestamosTotales.add(prestamo1);
		libro1.setEstaPrestado(true);

		// Segundo préstamo (revista)
		LocalDateTime fechaPrestamo2 = LocalDateTime.of(2023, 5, 3, 16, 15);
		LocalDateTime fechaMaxDevolucion2 = fechaPrestamo2.plusDays(7);
		Prestamo prestamo2 = new Prestamo(
				fechaPrestamo2, 
				fechaMaxDevolucion2, 
				revista1, 
				usuario2, 
				trabajador2
				);
		prestamosTotales.add(prestamo2);
		revista1.setEstaPrestado(true);

		// 7. Crear la biblioteca
		Biblioteca biblioteca = new Biblioteca(
				1, 
				"Biblioteca Municipal Central", 
				"Barcelona", 
				"Barcelona", 
				"09:00-21:00 L-V, 10:00-14:00 S", 
				"Laura González Martínez", 
				5, 
				trabajadores, 
				usuarios, 
				libros, 
				revistas, 
				articulos,
				prestamosTotales
				);

		// 8. Mostrar información de prueba
		System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");
		System.out.println("\nBiblioteca: " + biblioteca.getNombre());
		System.out.println("Ubicación: " + biblioteca.getMunicipio() + ", " + biblioteca.getProvincia());
		System.out.println("Horario: " + biblioteca.getHorario());
		System.out.println("Administrador: " + biblioteca.getNombreCompletoAdmin() + 
				" (" + biblioteca.getAnnosEnCargo() + " años en el cargo)");

		System.out.println("\nPersonal (" + trabajadores.size() + "):");
		for (Trabajador t : trabajadores) {
			System.out.println(" - " + t.getNombreCompleto() + " (" + t.getCargo() + ")");
		}

		System.out.println("\nUsuarios registrados (" + usuarios.size() + "):");
		for (UsuarioAcreditado u : usuarios) {
			System.out.println(" - " + u.getNombreCompleto() + " (Nº " + u.getNumUsuario() + 
					", acreditado desde " + u.getFecha() + ")");
		}

		biblioteca.devolverPublicacion(101, libro1);

		
		System.out.println("\nPréstamos activos (" + biblioteca.contarPrestamosActivos() + "):");
		for (Prestamo p : prestamosTotales) {
			if(p.getFechaDevolucion() == null){
				System.out.println(" - " + p.getPub().getTitulo() + 
						"\n   Prestado a: " + p.getUser().getNombreCompleto() +
						"\n   Fecha préstamo: " + p.getFechaP() +
						"\n   Devolución antes de: " + p.getFechaMax() +
						"\n   Devuelta el dia: " + p.getFechaDevolucion() +
						"\n   Gestor: " + p.getTrabPrestamo().getNombreCompleto());
			}
		}

		System.out.println("\nInventario:");
		System.out.println(" - Libros: " + libros.size() + " títulos");
		System.out.println(" - Revistas: " + revistas.size() + " títulos");
		System.out.println(" - Artículos: " + articulos.size() + " títulos");

		Prestamo nuevoP = biblioteca.solicitarPrestamo(101, libro1, trabajador1);
		biblioteca.devolverPublicacion(101, libro1);

		String mensajeR;
		
		if(nuevoP != null){
			nuevoP.concederProrroga();
			mensajeR = "Prestamo realizado - Prorroga concedida \n" + nuevoP.toString();
		}
		else
			mensajeR = "No fue posible realizar el prestamo";
		System.out.println(mensajeR);

	}
}
