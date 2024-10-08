package IUDIGITAL;

import java.util.ArrayList;

public abstract class Empleado {
    protected int idEmpleado;
    protected String nombre;
    protected String apellido;
    protected String tipoEmpleado; // Permanente o Temporal
    protected ArrayList<ReporteDesempenio> listaReportes; // Lista de reportes de desempeño

    // Constructor
    public Empleado(int idEmpleado, String nombre, String apellido, String tipoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoEmpleado = tipoEmpleado;
        this.listaReportes = new ArrayList<>(); // Inicializamos la lista de reportes
    }

    // Agregar un reporte a la lista de reportes
    public void agregarReporte(ReporteDesempenio reporte) {
        listaReportes.add(reporte);
    }

    // Obtener la lista de reportes
    public ArrayList<ReporteDesempenio> getListaReportes() {
        return listaReportes;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    // Método abstracto para generar el reporte de desempeño
    public abstract void generarReporteDesempeño();
}
