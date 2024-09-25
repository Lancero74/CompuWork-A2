import java.util.ArrayList;

public class Departamento {
    private int idDepartamento;
    private String nombre;
    private ArrayList<Empleado> listaEmpleados;

    public Departamento(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void asignarEmpleado(Empleado empleado) {
        listaEmpleados.add(empleado);
        empleado.asignarDepartamento(this);
    }

    public void eliminarEmpleado(Empleado empleado) {
        listaEmpleados.remove(empleado);
    }

    public void visualizarEmpleados() {
        System.out.println("Empleados en el departamento " + nombre + ":");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado);
        }
    }
}
