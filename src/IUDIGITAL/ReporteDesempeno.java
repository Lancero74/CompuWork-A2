package IUDIGITAL;

public class ReporteDesempeno {
    private int idReporte;
    private String empleado;
    private String fechaGeneracion;
    private int metricas;

    // constructor
    public ReporteDeDesempeño(int idReporte, String empleado, String fechaGeneracion, int metricas) {
        this.idReporte = idReporte;
        this.empleado = empleado;
        this.fechaGeneracion = fechaGeneracion;
        this.metricas = metricas;
    }
// constructor vacio
    public ReporteDeDesempeño() {
        
    }
    // Getters and Setters

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public String getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(String fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public int getMetricas() {
        return metricas;
    }

    public void setMetricas(int metricas) {
        this.metricas = metricas;
    }
}
