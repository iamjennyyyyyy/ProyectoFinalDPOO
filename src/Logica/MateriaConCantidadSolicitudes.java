package Logica;

public class MateriaConCantidadSolicitudes implements Comparable<MateriaConCantidadSolicitudes> {
    private String materia;
    private int cant;

    public MateriaConCantidadSolicitudes(String materia, int cant) {
        this.materia = materia;
        this.cant = cant;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    @Override
    public int compareTo(MateriaConCantidadSolicitudes instancia) {
        return Integer.compare(instancia.getCant(), this.cant); //ordeno de mayor a menor(mas solicitadas a menos)
        // Para orden ascendente: return Integer.compare(this.cant, instancia.getCant());
    }
}