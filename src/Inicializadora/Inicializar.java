package Inicializadora;

import Logica.Biblioteca;
import Logica.Articulo;
import Logica.Libro;
import Logica.Trabajador;
import Logica.Revista;
import java.util.ArrayList;

public class Inicializar {

    public static void Inicio() {

    	
        Biblioteca.getInstancia().agregarTrabajador(new Trabajador("1","Alejandra Lima", 35, "F", "Universitario", "Bibliotecario Jefe"));
        Biblioteca.getInstancia().agregarTrabajador(new Trabajador("2","Jose Machado",28, "M", "Técnico Medio", "Auxiliar de Biblioteca"));

        // 2. Crear y agregar usuarios acreditados
        Biblioteca.getInstancia().crearUsuarioAcreditado("101","Lucia Guevara", 25, "F");
        Biblioteca.getInstancia().crearUsuarioAcreditado("102","Pedro Gutierrez" , 30, "M");
        Biblioteca.getInstancia().crearUsuarioAcreditado("103","Amara Batista", 19, "F");
        Biblioteca.getInstancia().crearUsuarioAcreditado("104","Juan Lopez" , 20, "M");
        Biblioteca.getInstancia().crearUsuarioAcreditado("105","Lorenzo Torres", 21, "M");
        Biblioteca.getInstancia().crearUsuarioAcreditado("106","Liana Castillo" , 45, "F");

        // 3. Crear y agregar libros
        ArrayList<String> autores1 = new ArrayList<>();
        autores1.add("Gabriel García Márquez");
        Biblioteca.getInstancia().agregarLibro(new Libro("1001", "Cien años de soledad", "Novela", 432, 3, false, autores1, "Sudamericana"));

        ArrayList<String> autores2 = new ArrayList<>();
        autores2.add("Patrick Rothfuss");
        Biblioteca.getInstancia().agregarLibro(new Libro("1002", "El nombre del viento", "Fantasía", 462, 4, false, autores2, "Plaza Janes"));

        // 4. Crear y agregar revistas
        Revista revista1 = new Revista("2001", "National Geographic", "Ciencia", 100, 10, false);
        revista1.setAnno(2023);
        revista1.setNum(5);
        Biblioteca.getInstancia().agregarRevista(revista1);

        Revista revista2 = new Revista("2002", "Muy Interesante", "Divulgación", 80, 8, false);
        revista2.setAnno(2023);
        revista2.setNum(6);
        Biblioteca.getInstancia().agregarRevista(revista2);

        // 5. Crear y agregar artículos
        ArrayList<String> autoresArt1 = new ArrayList<>();
        autoresArt1.add("Dr. Alan Turing");
        ArrayList<String> arbitros1 = new ArrayList<>();
        arbitros1.add("Dr. John McCarthy");
        Biblioteca.getInstancia().agregarArticulo(new Articulo("3001", "Machine Learning aplicado a diagnóstico médico", "Tecnología", 15, 2, false, autoresArt1, arbitros1));

        ArrayList<String> autoresArt2 = new ArrayList<>();
        autoresArt2.add("Dra. Sylvia Earle");
        ArrayList<String> arbitros2 = new ArrayList<>();
        arbitros2.add("Dr. James Hansen");
        Biblioteca.getInstancia().agregarArticulo(new Articulo("3002", "Impacto del cambio climático en ecosistemas marinos", "Ecología", 20, 3, false, autoresArt2, arbitros2));
        
    }
}
