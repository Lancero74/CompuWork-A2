import java.util.Date;

public class ReporteDesempeño {
    private int idReporte;
    private Empleado empleado;
    private Date fechaGeneracion;
    private String metricas;

    public ReporteDesempeño(int idReporte, Empleado empleado, String metricas) {
        this.idReporte = idReporte;
        this.empleado = empleado;
        this.fechaGeneracion = new Date();
        this.metricas = metricas;
    }

    public void generarReporteIndividual() {
        System.out.println("Reporte para: " + empleado.nombre);
        System.out.println("Métricas: " + metricas);
    }
}
