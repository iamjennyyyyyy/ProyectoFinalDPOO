package Inicializadora;

import Logica.Biblioteca;
import Logica.Prestamo;
import Logica.Publicacion;
import Logica.Trabajador;
import Logica.UsuarioAcreditado;
import Visual.Login;

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

		// 3. Publicaciones (15 libros, 15 revistas, 15 art�culos)
		inicializarPublicaciones();

		// 4. Pr�stamos (15 instancias)
		inicializarPrestamos();
		
		inicializarUsuariosConPenalizaciones();

	}

	private static void inicializarTrabajadores() {
		String[][] trabajadores = {
				{"65101251234","Alejandra Lima", "Universitario", "Bibliotecario Jefe"},
				{"82071522345","Jose Machado", "T�cnico Medio", "Auxiliar de Biblioteca"},
				{"93022833456","Mar�a Rodr�guez", "Master", "Jefa de Adquisiciones"},
				{"75030944567","Carlos S�nchez", "Universitario", "Catalogador"},
				{"88052155678","Laura M�ndez", "T�cnico Superior", "Asistente de Referencia"},
				{"69110406789","Roberto Jim�nez", "Doctorado", "Director T�cnico"},
				{"95061717890","Ana Contreras", "Universitario", "Archivista"},
				{"72082028901","Pedro Vargas", "T�cnico Medio", "Digitador"},
				{"83090339012","Sof�a Castro", "Universitario", "Asistente de Circulaci�n"},
				{"91112640123","Miguel �ngel D�az", "Master", "Jefe de Sistemas"},
				{"78040951234","Elena Ruiz", "Universitario", "Conservadora"},
				{"85052222345","Fernando Morales", "T�cnico Superior", "Restaurador"},
				{"99030533456","Patricia N��ez", "Universitario", "Bibliotecaria Infantil"},
				{"71061824567","Ricardo Soto", "Master", "Coordinador de Servicios"},
				{"86072115678","Diana Paredes", "Universitario", "Referencista"}
		};

		for(String[] datos : trabajadores) {
			Biblioteca.getInstancia().agregarTrabajador(datos[0], datos[1], datos[2], datos[3]);
		}
	}

	private static void inicializarUsuarios() {
		String[][] usuarios = {
				{"94021406789","Lucia Guevara"},
				{"77052717890","Pedro Gutierrez"},
				{"89063028901","Amara Batista"},
				{"92081339012","Juan Lopez"},
				{"80091640123","Lorenzo Torres"},
				{"97022851234","Liana Castillo"},
				{"74031212345","Mario Benedetti"},
				{"98102523456","Silvia Plath"},
				{"73040834567","Ernesto S�bato"},
				{"84051125678","Isabel Allende"},
				{"90062416789","Julio Cort�zar"},
				{"79070717890","Gabriela Mistral"},
				{"85081048901","Pablo Neruda"},
				{"91091339012","Clarice Lispector"},
				{"78010640123","Jorge Luis Borges"}
		};

		for(String[] datos : usuarios) {
			Biblioteca.getInstancia().crearUsuarioAcreditado(datos[0], datos[1]);
		}
	}

	private static void inicializarPublicaciones() {
		// Libros (15 instancias)
		String[][] libros = {
				{"1001", "Cien a�os de soledad", "Literatura", "432", "3", "Gabriel Garc�a M�rquez", "Sudamericana"},
				{"1002", "El nombre del viento", "Literatura Fant�stica", "462", "4", "Patrick Rothfuss", "Plaza Janes"},
				{"1003", "Rayuela", "Literatura", "600", "2", "Julio Cort�zar", "Alfaguara"},
				{"1004", "The 1984", "Literatura Fant�stica", "328", "5", "George Orwell", "Debolsillo"},
				{"1005", "Cr�nica de una muerte anunciada", "Literatura", "120", "3", "Gabriel Garc�a M�rquez", "Sudamericana"},
				{"1006", "El Hobbit", "Literatura Fant�stica", "310", "4", "J.R.R. Tolkien", "Minotauro"},
				{"1007", "Ficciones", "Literatura", "180", "2", "Jorge Luis Borges", "Emec�"},
				{"1008", "La sombra del viento", "Literatura", "480", "3", "Carlos Ruiz Zaf�n", "Planeta"},
				{"1009", "Los juegos del hambre", "Literatura Fant�stica", "374", "5", "Suzanne Collins", "Molino"},
				{"1010", "El amor en los tiempos del c�lera", "Literatura", "464", "3", "Gabriel Garc�a M�rquez", "Sudamericana"},
				{"1011", "El se�or de los anillos", "Literatura Fant�stica", "1200", "2", "J.R.R. Tolkien", "Minotauro"},
				{"1012", "La ciudad y los perros", "Literatura", "350", "4", "Mario Vargas Llosa", "Alfaguara"},
				{"1013", "Rebeli�n en la granja", "Literatura Fant�stica", "140", "3", "George Orwell", "Debolsillo"},
				{"1014", "Pedro P�ramo", "Literatura", "128", "2", "Juan Rulfo", "FCE"},
				{"1015", "La casa de los esp�ritus", "Literatura", "432", "3", "Isabel Allende", "Plaza & Jan�s"}
		};

		for(String[] datos : libros) {
			ArrayList<String> autores = new ArrayList<>();
			autores.add(datos[5]);

			Biblioteca.getInstancia().agregarLibro(
					datos[0], datos[1], datos[2], 
					Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), 
					datos[5], datos[6]
					);
		}

		// Revistas (15 instancias)
		String[][] revistas = {
				{"R001", "National Geographic", "Ciencias Naturales", "100", "50", "2001", "10"},
				{"R002", "Muy Interesante", "Divulgaci�n Cient�fica", "80", "40", "2002", "8"},
				{"R003", "Science", "Ciencias Exactas", "120", "30", "2003", "5"},
				{"R004", "Nature", "Ciencias Exactas", "150", "35", "2004", "7"},
				{"R005", "Time", "Actualidad", "60", "60", "2005", "12"},
				{"R006", "The Economist", "Econom�a", "90", "40", "2006", "6"},
				{"R007", "Scientific American", "Divulgaci�n Cient�fica", "110", "38", "2007", "4"},
				{"R008", "New Scientist", "Divulgaci�n Cient�fica", "95", "42", "2008", "9"},
				{"R009", "Discover", "Divulgaci�n Cient�fica", "85", "36", "2009", "3"},
				{"R010", "Popular Science", "Tecnolog�a", "75", "32", "2010", "11"},
				{"R011", "Wired", "Tecnolog�a", "65", "28", "2011", "8"},
				{"R012", "National Geographic History", "Historia", "100", "25", "2012", "6"},
				{"R013", "Psychology Today", "Ciencias Sociales", "90", "27", "2013", "7"},
				{"R014", "MIT Technology Review", "Tecnolog�a", "110", "29", "2014", "5"},
				{"R015", "Archaeology", "Historia", "95", "23", "2015", "4"}
		};

		for(String[] datos : revistas) {
			Biblioteca.getInstancia().agregarRevista(
					datos[0], datos[1], datos[2], 
					Integer.parseInt(datos[3]), Integer.parseInt(datos[4]),
					Integer.parseInt(datos[5]), Integer.parseInt(datos[6]));
		}

		// Art�culos (15 instancias)
		String[][] articulos = {
				{"3001", "Machine Learning aplicado a diagn�stico m�dico", "Tecnolog�a", "15", "2", "Dr. Alan Turing", "Dr. John McCarthy"},
				{"3002", "Impacto del cambio clim�tico en ecosistemas marinos", "Ciencias Naturales", "20", "3", "Dra. Sylvia Earle", "Dr. James Hansen"},
				{"3003", "Avances en superconductividad a temperatura ambiente", "Ciencias Exactas", "25", "1", "Dr. Miguel Jos� Yacam�n", "Dr. Carlos Frenk"},
				{"3004", "Nuevos enfoques en la ense�anza de matem�ticas", "Ciencias Sociales", "18", "2", "Dra. Mar�a Montessori", "Dr. Howard Gardner"},
				{"3005", "Nanotecnolog�a aplicada a la medicina", "Tecnolog�a", "22", "3", "Dr. Eric Drexler", "Dr. Richard Smalley"},
				{"3006", "Teor�a de cuerdas y la unificaci�n de fuerzas", "Ciencias Exactas", "30", "1", "Dr. Edward Witten", "Dr. Brian Greene"},
				{"3007", "Inteligencia artificial en la creaci�n art�stica", "Tecnolog�a", "16", "2", "Dra. Fei-Fei Li", "Dr. Yoshua Bengio"},
				{"3008", "Biodiversidad en la Amazon�a", "Ciencias Naturales", "24", "3", "Dra. Jane Goodall", "Dr. E.O. Wilson"},
				{"3009", "Neuroplasticidad y aprendizaje", "Ciencias Sociales", "19", "2", "Dr. Michael Merzenich", "Dr. Norman Doidge"},
				{"3010", "Energ�as renovables en pa�ses en desarrollo", "Tecnolog�a", "21", "3", "Dr. Daniel Kammen", "Dr. Jeffrey Sachs"},
				{"3011", "CRISPR y edici�n gen�tica", "Ciencias Naturales", "28", "1", "Dra. Jennifer Doudna", "Dr. Emmanuelle Charpentier"},
				{"3012", "Arqueolog�a subacu�tica en el Mediterr�neo", "Historia", "17", "2", "Dr. George Bass", "Dr. Robert Ballard"},
				{"3013", "Psicolog�a de las redes sociales", "Ciencias Sociales", "20", "3", "Dr. Sherry Turkle", "Dr. Mihaly Csikszentmihalyi"},
				{"3014", "Materiales 2D y sus aplicaciones", "Ciencias Exactas", "23", "2", "Dr. Andre Geim", "Dr. Konstantin Novoselov"},
				{"3015", "Exoplanetas y la b�squeda de vida", "Ciencias Exactas", "26", "1", "Dr. Sara Seager", "Dr. Michel Mayor"}
		};

		for(String[] datos : articulos) {
			ArrayList<String> autores = new ArrayList<>();
			autores.add(datos[5]);

			ArrayList<String> arbitros = new ArrayList<>();
			arbitros.add(datos[6]);

			Biblioteca.getInstancia().agregarArticulo(
					datos[0], datos[1], datos[2], 
					Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), 
					datos[5], datos[6]);
		}

		/*
		    Literatura (9 libros)

			Literatura Fant�stica (6 libros)

			Ciencias Naturales (3 revistas + 3 art�culos)

			Tecnolog�a (2 revistas + 4 art�culos)

			Ciencias Exactas (2 revistas + 5 art�culos)

			Divulgaci�n Cient�fica (4 revistas)

			Ciencias Sociales (1 revista + 3 art�culos)

			Historia (2 revistas + 1 art�culo)

			Econom�a (1 revista)

			Actualidad (1 revista)
		 */
	}

	private static void inicializarPrestamos() {
		// Asegurarse que hay un administrador
		Trabajador admin = Biblioteca.getInstancia().getAdmin();
		if(admin == null) {
			admin = Biblioteca.getInstancia().getTrabajadores().get(0);
		}

		// Contador para pr�stamos pr�ximos a vencer
		int prestamosProximosAVencer = 0;
		final int PRESTAMOS_PROXIMOS_OBJETIVO = 5;
		final int DIAS_PROXIMOS_A_VENCER = 10; // Pr�ximos 3 d�as

		// Crear 15 pr�stamos con validaci�n
		for(int i = 1; i <= 15; i++) {
			try {
				Publicacion pub = obtenerPublicacionAleatoriaValida();
				if(pub == null) continue;

				UsuarioAcreditado user = obtenerUsuarioAleatorioValido();
				if(user == null) continue;

				LocalDate fPrest;
				LocalDate fMax;
				LocalDate fDev = null;

				// Generar fechas especiales para los primeros 5 pr�stamos pr�ximos a vencer
				if(prestamosProximosAVencer < PRESTAMOS_PROXIMOS_OBJETIVO) {
					// Crear pr�stamos que vencen pronto (1-3 d�as)
					fPrest = LocalDate.now().minusDays(pub.tiempoMaximoPrestamo() - (random.nextInt(DIAS_PROXIMOS_A_VENCER) + 1));
					fMax = fPrest.plusDays(pub.tiempoMaximoPrestamo());
					prestamosProximosAVencer++;
				} else {
					// Fechas normales para otros pr�stamos
					fPrest = LocalDate.now().minusDays(random.nextInt(30));
					fMax = fPrest.plusDays(pub.tiempoMaximoPrestamo());

					// 50% de probabilidad de tener fecha de devoluci�n
					if(random.nextBoolean()) {
						fDev = fPrest.plusDays(random.nextInt(pub.tiempoMaximoPrestamo()));
					}
				}

				// Registrar pr�stamo
				if(fDev != null) {
					Biblioteca.getInstancia().agregarPrestamo(fPrest, fMax, fDev, pub, user, admin);
				} else {
					Biblioteca.getInstancia().agregarPrestamo(fPrest, fMax, pub, user, admin);
				}

			} catch(Exception e) {
				System.err.println("Error creando pr�stamo #" + i + ": " + e.getMessage());
			}
		}

		// Verificaci�n (para debug)
		System.out.println("Pr�stamos pr�ximos a vencer creados: " + prestamosProximosAVencer);
	}

	// M�todos auxiliares
	private static Publicacion obtenerPublicacionAleatoriaValida() {
		ArrayList<Publicacion> publicaciones = Biblioteca.getInstancia().getPublicaciones();
		return publicaciones.isEmpty() ? null : 
			publicaciones.get(random.nextInt(publicaciones.size()));
	}

	private static UsuarioAcreditado obtenerUsuarioAleatorioValido() {
		ArrayList<UsuarioAcreditado> usuarios = Biblioteca.getInstancia().getUsuarios();
		return usuarios.isEmpty() ? null : 
			usuarios.get(random.nextInt(usuarios.size()));
	}
	
	public static void inicializarUsuariosConPenalizaciones(){
		UsuarioAcreditado u = Biblioteca.getInstancia().getUsuarios().get(5);
		Publicacion p = Biblioteca.getInstancia().getPublicaciones().get(8);
		LocalDate fechaP = LocalDate.of(2025, 5, 17);
		LocalDate fechaDev = LocalDate.of(2025, 6, 20);
		int tiempo = p.tiempoMaximoPrestamo();
//		System.out.println("tiempo maximo pub" +tiempo);
		LocalDate fechaMax = fechaP.plusDays(tiempo);
		Biblioteca.getInstancia().agregarPrestamo(fechaP, fechaMax, fechaDev, p, u, Login.obtenerAdmin());
	}
}
