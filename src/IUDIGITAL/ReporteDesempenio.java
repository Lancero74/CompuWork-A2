package IUDIGITAL;

import java.util.Date;

public class ReporteDesempenio {
    private int idReporte;
    private Empleado empleado;
    private Date fechaGeneracion;
    private String metricas;

    // Constructor
    public ReporteDesempenio(int idReporte, Empleado empleado, String metricas) {
        this.idReporte = idReporte;
        this.empleado = empleado;
        this.fechaGeneracion = new Date();
        this.metricas = metricas;
    }

    // Método para generar el reporte individual
    public void generarReporteIndividual() {
        System.out.println("Reporte de desempeño para: " + empleado.getNombre() + " " + empleado.getApellido());
        System.out.println("Fecha: " + fechaGeneracion);
        System.out.println("Métricas: " + metricas);
    }

    // Método para obtener el reporte en formato de cadena (para visualización)
    @Override
    public String toString() {
        return "Reporte ID: " + idReporte + "\n" +
                "Empleado: " + empleado.getNombre() + " " + empleado.getApellido() + "\n" +
                "Fecha de generación: " + fechaGeneracion + "\n" +
                "Métricas: " + metricas + "\n";
    }
}
