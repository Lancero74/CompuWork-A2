public abstract class Empleado {
    protected int idEmpleado;
    protected String nombre;
    protected String apellido;  // Nuevo atributo
    protected String tipoEmpleado;
    protected Departamento departamento;

    public Empleado(int idEmpleado, String nombre, String apellido, String tipoEmpleado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;  // Asignación del apellido
        this.tipoEmpleado = tipoEmpleado;
    }

    public void asignarDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public void cambiarDepartamento(Departamento nuevoDepartamento) {
        this.departamento = nuevoDepartamento;
    }

    public abstract void generarReporteDesempeño();

    @Override
    public String toString() {
        return "ID: " + idEmpleado + ", Nombre: " + nombre + " " + apellido + ", Tipo: " + tipoEmpleado + ", Departamento: " + (departamento != null ? departamento.getNombre() : "Sin departamento");
    }
}

class EmpleadoPermanente extends Empleado {
    private double salario;

    public EmpleadoPermanente(int idEmpleado, String nombre, String apellido, double salario) {
        super(idEmpleado, nombre, apellido, "Permanente");
        this.salario = salario;
    }

    @Override
    public void generarReporteDesempeño() {
        System.out.println("Generar reporte de desempeño para empleado permanente.");
    }
}

class EmpleadoTemporal extends Empleado {
    private double tarifaPorHora;

    public EmpleadoTemporal(int idEmpleado, String nombre, String apellido, double tarifaPorHora) {
        super(idEmpleado, nombre, apellido, "Temporal");
        this.tarifaPorHora = tarifaPorHora;
    }

    @Override
    public void generarReporteDesempeño() {
        System.out.println("Generar reporte de desempeño para empleado temporal.");
    }
}
