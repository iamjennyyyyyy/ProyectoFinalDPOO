//package Inicializadora;
//
//import Logica.Biblioteca;
//import Logica.Articulo;
//import Logica.Libro;
//import Logica.Prestamo;
//import Logica.Publicacion;
//import Logica.Trabajador;
//import Logica.Revista;
//import Logica.UsuarioAcreditado;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class Inicializar {
//
//    public static void Inicio() {
//
//    	
//        Biblioteca.getInstancia().agregarTrabajador("1","Alejandra Lima", 35, "F", "Universitario", "Bibliotecario Jefe");
//        Biblioteca.getInstancia().agregarTrabajador("2","Jose Machado",28, "M", "Técnico Medio", "Auxiliar de Biblioteca");
//
//        // 2. Crear y agregar usuarios acreditados
//        Biblioteca.getInstancia().crearUsuarioAcreditado("101","Lucia Guevara", 25, "F");
//        Biblioteca.getInstancia().crearUsuarioAcreditado("102","Pedro Gutierrez" , 30, "M");
//        Biblioteca.getInstancia().crearUsuarioAcreditado("103","Amara Batista", 19, "F");
//        Biblioteca.getInstancia().crearUsuarioAcreditado("104","Juan Lopez" , 20, "M");
//        Biblioteca.getInstancia().crearUsuarioAcreditado("105","Lorenzo Torres", 21, "M");
//        Biblioteca.getInstancia().crearUsuarioAcreditado("106","Liana Castillo" , 45, "F");
//
//        // 3. Crear y agregar libros
//        ArrayList<String> autores1 = new ArrayList<>();
//        autores1.add("Gabriel García Márquez");
//        Biblioteca.getInstancia().agregarLibro("1001", "Cien años de soledad", "Novela", 432, 3, false, autores1, "Sudamericana");
//
//        ArrayList<String> autores2 = new ArrayList<>();
//        autores2.add("Patrick Rothfuss");
//        Biblioteca.getInstancia().agregarLibro("1002", "El nombre del viento", "Fantasía", 462, 4, false, autores2, "Plaza Janes");
//
//        // 4. Crear y agregar revistas
//        Biblioteca.getInstancia().agregarRevista("2001", "National Geographic", "Ciencia", 100, 10, false);
//        Biblioteca.getInstancia().agregarRevista("2002", "Muy Interesante", "Divulgación", 80, 8, false);
//
//        // 5. Crear y agregar artículos
//        ArrayList<String> autoresArt1 = new ArrayList<>();
//        autoresArt1.add("Dr. Alan Turing");
//        ArrayList<String> arbitros1 = new ArrayList<>();
//        arbitros1.add("Dr. John McCarthy");
//        Biblioteca.getInstancia().agregarArticulo("3001", "Machine Learning aplicado a diagnóstico médico", "Tecnología", 15, 2, false, autoresArt1, arbitros1);
//
//        ArrayList<String> autoresArt2 = new ArrayList<>();
//        autoresArt2.add("Dra. Sylvia Earle");
//        ArrayList<String> arbitros2 = new ArrayList<>();
//        arbitros2.add("Dr. James Hansen");
//        Biblioteca.getInstancia().agregarArticulo("3002", "Impacto del cambio climático en ecosistemas marinos", "Ecología", 20, 3, false, autoresArt2, arbitros2);
//        
//        //6. Crear Prestamos
//        Publicacion pub = Biblioteca.getInstancia().buscarPublicacionPorId("1001");
//        UsuarioAcreditado user = Biblioteca.getInstancia().buscarUsuarioPorId("101");
//        LocalDate fPrest = LocalDate.of(2025, 5, 10);
//        LocalDate fMax = fPrest.plusDays(pub.tiempoMaximoPrestamo());
//        LocalDate fDev = LocalDate.of(2025, 05, 22);
//        Biblioteca.getInstancia().agregarPrestamo(fPrest, fMax, fDev, pub, user, Biblioteca.getInstancia().getAdmin());
//        //2025-05-24
//        
//        
//        Publicacion pub2 = Biblioteca.getInstancia().buscarPublicacionPorId("1002");
//        UsuarioAcreditado user2 = Biblioteca.getInstancia().buscarUsuarioPorId("102");
//        LocalDate fPrest2 = LocalDate.of(2025, 5, 26);
//        LocalDate fMax2 = fPrest.plusDays(pub2.tiempoMaximoPrestamo());
//        LocalDate fDev2 = LocalDate.of(2025, 05, 27);
//        Biblioteca.getInstancia().agregarPrestamo(fPrest2, fMax2, fDev2, pub2, user2, Biblioteca.getInstancia().getAdmin());
//        //2025-05-27
//        
//        
//        Publicacion pub3 = Biblioteca.getInstancia().buscarPublicacionPorId("2001");
//        UsuarioAcreditado user3 = Biblioteca.getInstancia().buscarUsuarioPorId("103");
//        LocalDate fPrest3 = LocalDate.of(2025, 5, 23);
//        LocalDate fMax3 = fPrest.plusDays(pub3.tiempoMaximoPrestamo());
//        Biblioteca.getInstancia().agregarPrestamo(fPrest3, fMax3, pub3, user3, Biblioteca.getInstancia().getAdmin());
//        //2025-05-30
//        
//        
//        Publicacion pub4 = Biblioteca.getInstancia().buscarPublicacionPorId("2002");
//        UsuarioAcreditado user4 = Biblioteca.getInstancia().buscarUsuarioPorId("104");
//        LocalDate fPrest4 = LocalDate.of(2025, 5, 19);
//        LocalDate fMax4 = fPrest.plusDays(pub4.tiempoMaximoPrestamo());
//        LocalDate fDev4 = LocalDate.of(2025, 05, 24);
//        Biblioteca.getInstancia().agregarPrestamo(fPrest4, fMax4, fDev4, pub4, user4, Biblioteca.getInstancia().getAdmin());
//        //2025-05-26
//        
//        
//        Publicacion pub5 = Biblioteca.getInstancia().buscarPublicacionPorId("3001");
//        UsuarioAcreditado user5 = Biblioteca.getInstancia().buscarUsuarioPorId("105");
//        LocalDate fPrest5 = LocalDate.of(2025, 5, 27);
//        LocalDate fMax5 = fPrest5.plusDays(pub5.tiempoMaximoPrestamo());
//        Biblioteca.getInstancia().agregarPrestamo(fPrest5, fMax5, pub5, user5, Biblioteca.getInstancia().getAdmin());
//        //2025-05-29
//        
//        
//        Publicacion pub6 = Biblioteca.getInstancia().buscarPublicacionPorId("3002");
//        UsuarioAcreditado user6 = Biblioteca.getInstancia().buscarUsuarioPorId("106");
//        LocalDate fPrest6 = LocalDate.of(2025, 5, 21);
//        LocalDate fDev6 = LocalDate.of(2025, 05, 22);
//        LocalDate fMax6 = fPrest6.plusDays(pub6.tiempoMaximoPrestamo());
//        Biblioteca.getInstancia().agregarPrestamo(fPrest6, fMax6, fDev6, pub6, user6, Biblioteca.getInstancia().getAdmin());
//        //2025-05-24
//        
//        for(Prestamo p : Biblioteca.getInstancia().getPrestamosTotales()){
//        	System.out.println("Prestamos activos: " + p.getUser().getId() + " " + p.getFechaMax());
//        }
////        
////        
////        for(Prestamo pOrdenado : Biblioteca.getInstancia().guardarPrestProximosAVencerse(4)){
////        	System.out.println("Prestamos que vencen en 4 dias: " + pOrdenado.getUser().getId() + " " + pOrdenado.getFechaMax());
////        }
//    }
//}

package Inicializadora;

import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.Publicacion;
import Logica.Trabajador;
import Logica.UsuarioAcreditado;

import java.awt.List;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Inicializar {

	private static final Random random = new Random();

	public static void Inicio() {
		// 1. Trabajadores (15 instancias)
		inicializarTrabajadores();

		// 2. Usuarios acreditados (15 instancias)
		inicializarUsuarios();

		// 3. Publicaciones (15 libros, 15 revistas, 15 artículos)
		inicializarPublicaciones();

		// 4. Préstamos (15 instancias)
		inicializarPrestamos();

	}

	private static void inicializarTrabajadores() {
		String[][] trabajadores = {
				{"1","Alejandra Lima", "35", "F", "Universitario", "Bibliotecario Jefe"},
				{"2","Jose Machado", "28", "M", "Técnico Medio", "Auxiliar de Biblioteca"},
				{"3","María Rodríguez", "42", "F", "Master", "Jefa de Adquisiciones"},
				{"4","Carlos Sánchez", "31", "M", "Universitario", "Catalogador"},
				{"5","Laura Méndez", "29", "F", "Técnico Superior", "Asistente de Referencia"},
				{"6","Roberto Jiménez", "45", "M", "Doctorado", "Director Técnico"},
				{"7","Ana Contreras", "38", "F", "Universitario", "Archivista"},
				{"8","Pedro Vargas", "33", "M", "Técnico Medio", "Digitador"},
				{"9","Sofía Castro", "27", "F", "Universitario", "Asistente de Circulación"},
				{"10","Miguel Ángel Díaz", "50", "M", "Master", "Jefe de Sistemas"},
				{"11","Elena Ruiz", "39", "F", "Universitario", "Conservadora"},
				{"12","Fernando Morales", "44", "M", "Técnico Superior", "Restaurador"},
				{"13","Patricia Núñez", "36", "F", "Universitario", "Bibliotecaria Infantil"},
				{"14","Ricardo Soto", "41", "M", "Master", "Coordinador de Servicios"},
				{"15","Diana Paredes", "30", "F", "Universitario", "Referencista"}
		};

		for(String[] datos : trabajadores) {
			Biblioteca.getInstancia().agregarTrabajador(
					datos[0], datos[1], Integer.parseInt(datos[2]), 
					datos[3], datos[4], datos[5]
					);
		}
	}

	private static void inicializarUsuarios() {
		String[][] usuarios = {
				{"101","Lucia Guevara", "25", "F"},
				{"102","Pedro Gutierrez", "30", "M"},
				{"103","Amara Batista", "19", "F"},
				{"104","Juan Lopez", "20", "M"},
				{"105","Lorenzo Torres", "21", "M"},
				{"106","Liana Castillo", "45", "F"},
				{"107","Mario Benedetti", "22", "M"},
				{"108","Silvia Plath", "28", "F"},
				{"109","Ernesto Sábato", "35", "M"},
				{"110","Isabel Allende", "40", "F"},
				{"111","Julio Cortázar", "29", "M"},
				{"112","Gabriela Mistral", "33", "F"},
				{"113","Pablo Neruda", "27", "M"},
				{"114","Clarice Lispector", "31", "F"},
				{"115","Jorge Luis Borges", "50", "M"}
		};

		for(String[] datos : usuarios) {
			Biblioteca.getInstancia().crearUsuarioAcreditado(
					datos[0], datos[1], Integer.parseInt(datos[2]), datos[3]
					);
		}
	}

	private static void inicializarPublicaciones() {
		// Libros (15 instancias)
		String[][] libros = {
				{"1001", "Cien años de soledad", "Literatura", "432", "3", "Gabriel García Márquez", "Sudamericana"},
				{"1002", "El nombre del viento", "Literatura Fantástica", "462", "4", "Patrick Rothfuss", "Plaza Janes"},
				{"1003", "Rayuela", "Literatura", "600", "2", "Julio Cortázar", "Alfaguara"},
				{"1004", "1984", "Literatura Fantástica", "328", "5", "George Orwell", "Debolsillo"},
				{"1005", "Crónica de una muerte anunciada", "Literatura", "120", "3", "Gabriel García Márquez", "Sudamericana"},
				{"1006", "El Hobbit", "Literatura Fantástica", "310", "4", "J.R.R. Tolkien", "Minotauro"},
				{"1007", "Ficciones", "Literatura", "180", "2", "Jorge Luis Borges", "Emecé"},
				{"1008", "La sombra del viento", "Literatura", "480", "3", "Carlos Ruiz Zafón", "Planeta"},
				{"1009", "Los juegos del hambre", "Literatura Fantástica", "374", "5", "Suzanne Collins", "Molino"},
				{"1010", "El amor en los tiempos del cólera", "Literatura", "464", "3", "Gabriel García Márquez", "Sudamericana"},
				{"1011", "El señor de los anillos", "Literatura Fantástica", "1200", "2", "J.R.R. Tolkien", "Minotauro"},
				{"1012", "La ciudad y los perros", "Literatura", "350", "4", "Mario Vargas Llosa", "Alfaguara"},
				{"1013", "Rebelión en la granja", "Literatura Fantástica", "140", "3", "George Orwell", "Debolsillo"},
				{"1014", "Pedro Páramo", "Literatura", "128", "2", "Juan Rulfo", "FCE"},
				{"1015", "La casa de los espíritus", "Literatura", "432", "3", "Isabel Allende", "Plaza & Janés"}
		};

		for(String[] datos : libros) {
			ArrayList<String> autores = new ArrayList<>();
			autores.add(datos[5]);

			Biblioteca.getInstancia().agregarLibro(
					datos[0], datos[1], datos[2], 
					Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), 
					false, autores, datos[6]
					);
		}

		// Revistas (15 instancias)
		String[][] revistas = {
				{"2001", "National Geographic", "Ciencias Naturales", "100", "10"},
				{"2002", "Muy Interesante", "Divulgación Científica", "80", "8"},
				{"2003", "Science", "Ciencias Exactas", "120", "5"},
				{"2004", "Nature", "Ciencias Exactas", "150", "7"},
				{"2005", "Time", "Actualidad", "60", "12"},
				{"2006", "The Economist", "Economía", "90", "6"},
				{"2007", "Scientific American", "Divulgación Científica", "110", "4"},
				{"2008", "New Scientist", "Divulgación Científica", "95", "9"},
				{"2009", "Discover", "Divulgación Científica", "85", "3"},
				{"2010", "Popular Science", "Tecnología", "75", "11"},
				{"2011", "Wired", "Tecnología", "65", "8"},
				{"2012", "National Geographic History", "Historia", "100", "6"},
				{"2013", "Psychology Today", "Ciencias Sociales", "90", "7"},
				{"2014", "MIT Technology Review", "Tecnología", "110", "5"},
				{"2015", "Archaeology", "Historia", "95", "4"}
		};

		for(String[] datos : revistas) {
			Biblioteca.getInstancia().agregarRevista(
					datos[0], datos[1], datos[2], 
					Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), false
					);
		}

		// Artículos (15 instancias)
		String[][] articulos = {
				{"3001", "Machine Learning aplicado a diagnóstico médico", "Tecnología", "15", "2", "Dr. Alan Turing", "Dr. John McCarthy"},
				{"3002", "Impacto del cambio climático en ecosistemas marinos", "Ciencias Naturales", "20", "3", "Dra. Sylvia Earle", "Dr. James Hansen"},
				{"3003", "Avances en superconductividad a temperatura ambiente", "Ciencias Exactas", "25", "1", "Dr. Miguel José Yacamán", "Dr. Carlos Frenk"},
				{"3004", "Nuevos enfoques en la enseñanza de matemáticas", "Ciencias Sociales", "18", "2", "Dra. María Montessori", "Dr. Howard Gardner"},
				{"3005", "Nanotecnología aplicada a la medicina", "Tecnología", "22", "3", "Dr. Eric Drexler", "Dr. Richard Smalley"},
				{"3006", "Teoría de cuerdas y la unificación de fuerzas", "Ciencias Exactas", "30", "1", "Dr. Edward Witten", "Dr. Brian Greene"},
				{"3007", "Inteligencia artificial en la creación artística", "Tecnología", "16", "2", "Dra. Fei-Fei Li", "Dr. Yoshua Bengio"},
				{"3008", "Biodiversidad en la Amazonía", "Ciencias Naturales", "24", "3", "Dra. Jane Goodall", "Dr. E.O. Wilson"},
				{"3009", "Neuroplasticidad y aprendizaje", "Ciencias Sociales", "19", "2", "Dr. Michael Merzenich", "Dr. Norman Doidge"},
				{"3010", "Energías renovables en países en desarrollo", "Tecnología", "21", "3", "Dr. Daniel Kammen", "Dr. Jeffrey Sachs"},
				{"3011", "CRISPR y edición genética", "Ciencias Naturales", "28", "1", "Dra. Jennifer Doudna", "Dr. Emmanuelle Charpentier"},
				{"3012", "Arqueología subacuática en el Mediterráneo", "Historia", "17", "2", "Dr. George Bass", "Dr. Robert Ballard"},
				{"3013", "Psicología de las redes sociales", "Ciencias Sociales", "20", "3", "Dr. Sherry Turkle", "Dr. Mihaly Csikszentmihalyi"},
				{"3014", "Materiales 2D y sus aplicaciones", "Ciencias Exactas", "23", "2", "Dr. Andre Geim", "Dr. Konstantin Novoselov"},
				{"3015", "Exoplanetas y la búsqueda de vida", "Ciencias Exactas", "26", "1", "Dr. Sara Seager", "Dr. Michel Mayor"}
		};

		for(String[] datos : articulos) {
			ArrayList<String> autores = new ArrayList<>();
			autores.add(datos[5]);

			ArrayList<String> arbitros = new ArrayList<>();
			arbitros.add(datos[6]);

			Biblioteca.getInstancia().agregarArticulo(
					datos[0], datos[1], datos[2], 
					Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), 
					false, autores, arbitros
					);
		}

		/*
		    Literatura (9 libros)

			Literatura Fantástica (6 libros)

			Ciencias Naturales (3 revistas + 3 artículos)

			Tecnología (2 revistas + 4 artículos)

			Ciencias Exactas (2 revistas + 5 artículos)

			Divulgación Científica (4 revistas)

			Ciencias Sociales (1 revista + 3 artículos)

			Historia (2 revistas + 1 artículo)

			Economía (1 revista)

			Actualidad (1 revista)
		 */
	}

	private static void inicializarPrestamos() {
		// Asegurarse que hay un administrador
		Trabajador admin = Biblioteca.getInstancia().getAdmin();
		if(admin == null) {
			admin = Biblioteca.getInstancia().getTrabajadores().get(0);
		}

		// Contador para préstamos próximos a vencer
		int prestamosProximosAVencer = 0;
		final int PRESTAMOS_PROXIMOS_OBJETIVO = 5;
		final int DIAS_PROXIMOS_A_VENCER = 10; // Próximos 3 días

		// Crear 15 préstamos con validación
		for(int i = 1; i <= 15; i++) {
			try {
				Publicacion pub = obtenerPublicacionAleatoriaValida();
				if(pub == null) continue;

				UsuarioAcreditado user = obtenerUsuarioAleatorioValido();
				if(user == null) continue;

				LocalDate fPrest;
				LocalDate fMax;
				LocalDate fDev = null;

				// Generar fechas especiales para los primeros 5 préstamos próximos a vencer
				if(prestamosProximosAVencer < PRESTAMOS_PROXIMOS_OBJETIVO) {
					// Crear préstamos que vencen pronto (1-3 días)
					fPrest = LocalDate.now().minusDays(pub.tiempoMaximoPrestamo() - (random.nextInt(DIAS_PROXIMOS_A_VENCER) + 1));
					fMax = fPrest.plusDays(pub.tiempoMaximoPrestamo());
					prestamosProximosAVencer++;
				} else {
					// Fechas normales para otros préstamos
					fPrest = LocalDate.now().minusDays(random.nextInt(30));
					fMax = fPrest.plusDays(pub.tiempoMaximoPrestamo());

					// 50% de probabilidad de tener fecha de devolución
					if(random.nextBoolean()) {
						fDev = fPrest.plusDays(random.nextInt(pub.tiempoMaximoPrestamo()));
					}
				}

				// Registrar préstamo
				if(fDev != null) {
					Biblioteca.getInstancia().agregarPrestamo(fPrest, fMax, fDev, pub, user, admin);
				} else {
					Biblioteca.getInstancia().agregarPrestamo(fPrest, fMax, pub, user, admin);
				}

			} catch(Exception e) {
				System.err.println("Error creando préstamo #" + i + ": " + e.getMessage());
			}
		}

		// Verificación (para debug)
		System.out.println("Préstamos próximos a vencer creados: " + prestamosProximosAVencer);
	}

	// Métodos auxiliares
	private static Publicacion obtenerPublicacionAleatoriaValida() {
		ArrayList<Publicacion> publicaciones = new ArrayList<>();
		publicaciones.addAll(Biblioteca.getInstancia().getLibros());
		publicaciones.addAll(Biblioteca.getInstancia().getRevistas());
		publicaciones.addAll(Biblioteca.getInstancia().getArticulos());

		return publicaciones.isEmpty() ? null : 
			publicaciones.get(random.nextInt(publicaciones.size()));
	}

	private static UsuarioAcreditado obtenerUsuarioAleatorioValido() {
		ArrayList<UsuarioAcreditado> usuarios = Biblioteca.getInstancia().getUsuarios();
		return usuarios.isEmpty() ? null : 
			usuarios.get(random.nextInt(usuarios.size()));
	}
}
