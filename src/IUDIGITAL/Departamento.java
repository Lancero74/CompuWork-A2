package IUDIGITAL;

import javax.swing.*;
import java.util.ArrayList;

// Clase que representa un departamento
public class Departamento {
    private String nombre;
    private ArrayList<Empleado> empleados;

    // Constructor
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    // Método para agregar un empleado al departamento
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // Método para visualizar empleados en el departamento
    public void visualizarEmpleados() {
        StringBuilder sb = new StringBuilder("Empleados en " + nombre + ":\n");
        if (empleados.isEmpty()) {
            sb.append("No hay empleados asignados.");
        } else {
            for (Empleado empleado : empleados) {
                sb.append(empleado.toString()).append("\n");
            }
        }
        // Muestra la lista de empleados
        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
