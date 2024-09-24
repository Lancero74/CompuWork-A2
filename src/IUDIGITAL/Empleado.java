package IUDIGITAL;

public class Empleado {
    private int id_Empleado;
    private String Nombre;
    private String Apellido;
    private String Tipo_Empleado;
    private String Fecha_Contratacion;

// constructor
    public Empleado(int id_Empleado, String nombre,String Apellido,String Tipo_Empleado) {
        this.id_Empleado = id_Empleado;
        this.Nombre = nombre;
        this.Apellido = Apellido;
        this.Tipo_Empleado = Tipo_Empleado;
        this.Fecha_Contratacion = Fecha_Contratacion;

    }
// constructor vacio
    public Empleado() {

    }
    // Getters and Setters

    public int getId_Empleado() {
        return id_Empleado;
    }

    public void setId_Empleado(int id_Empleado) {
        this.id_Empleado = id_Empleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getTipo_Empleado() {
        return Tipo_Empleado;
    }

    public void setTipo_Empleado(String tipo_Empleado) {
        Tipo_Empleado = tipo_Empleado;
    }

    public String getFecha_Contratacion() {
        return Fecha_Contratacion;
    }

    public void setFecha_Contratacion(String fecha_Contratacion) {
        Fecha_Contratacion = fecha_Contratacion;
    }

}
