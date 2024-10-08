package IUDIGITAL;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Clase principal
public class Main extends JFrame {
    private ArrayList<Empleado> listaEmpleados;
    private ArrayList<Departamento> listaDepartamentos;
    private ArrayList<ReporteDesempenio> listaReportes;
    private int contadorReportes = 1; // Contador para los reportes

    // Constructor
    public Main() {
        listaEmpleados = new ArrayList<>();
        listaDepartamentos = new ArrayList<>();
        listaReportes = new ArrayList<>();
        inicializarUI();
    }

    // Inicializa la interfaz de usuario
    private void inicializarUI() {
        setTitle("Sistema de Gestión de Recursos Humanos");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botones para gestionar empleados, departamentos y generar reportes
        JButton btnGestionarEmpleados = new JButton("Gestionar Empleados");
        JButton btnGestionarDepartamentos = new JButton("Gestionar Departamentos");
        JButton btnGenerarReporte = new JButton("Generar Reporte");
        JButton btnVisualizarReportes = new JButton("Visualizar Reportes");

        // Agregar acción a los botones
        btnGestionarEmpleados.addActionListener(e -> gestionarEmpleados());
        btnGestionarDepartamentos.addActionListener(e -> gestionarDepartamentos());
        btnGenerarReporte.addActionListener(e -> generarReporte());
        btnVisualizarReportes.addActionListener(e -> visualizarReportesEmpleado());

        // Añadir botones a la ventana
        add(btnGestionarEmpleados);
        add(btnGestionarDepartamentos);
        add(btnGenerarReporte);
        add(btnVisualizarReportes);
    }

    // Método para gestionar empleados
    private void gestionarEmpleados() {
        String[] opciones = {"Crear Empleado", "Visualizar Empleados"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione una opción:", "Gestión de Empleados",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            crearEmpleado();
        } else if (seleccion == 1) {
            visualizarEmpleados();
        }
    }

    // Método para crear un empleado
    private void crearEmpleado() {
        int idEmpleado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del empleado:"));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del empleado:");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del empleado:");
        String tipo = JOptionPane.showInputDialog("¿Es un empleado permanente o temporal? (P/T)");

        if (tipo.equalsIgnoreCase("P")) {
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario:"));
            listaEmpleados.add(new EmpleadoPermanente(idEmpleado, nombre, apellido, salario));
        } else if (tipo.equalsIgnoreCase("T")) {
            double tarifaPorHora = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tarifa por hora:"));
            listaEmpleados.add(new EmpleadoTemporal(idEmpleado, nombre, apellido, tarifaPorHora));
        }

        // Asignar el empleado a un departamento
        asignarEmpleadoADepartamento(idEmpleado);

        JOptionPane.showMessageDialog(this, "Empleado creado y asignado a un departamento con éxito.");
    }

    // Método para asignar empleado a un departamento
    private void asignarEmpleadoADepartamento(int idEmpleado) {
        if (listaDepartamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay departamentos creados. Cree un departamento primero.");
            return;
        }

        StringBuilder sb = new StringBuilder("Departamentos disponibles:\n");
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            sb.append((i + 1)).append(". ").append(listaDepartamentos.get(i).getNombre()).append("\n");
        }

        String input = JOptionPane.showInputDialog(sb.toString() + "Seleccione el número del departamento al que desea asignar el empleado:");
        int indiceDepartamento = Integer.parseInt(input) - 1;

        if (indiceDepartamento >= 0 && indiceDepartamento < listaDepartamentos.size()) {
            Departamento departamentoSeleccionado = listaDepartamentos.get(indiceDepartamento);

            // Buscar empleado por ID
            Empleado empleado = null;
            for (Empleado e : listaEmpleados) {
                if (e.idEmpleado == idEmpleado) {
                    empleado = e;
                    break;
                }
            }

            if (empleado != null) {
                departamentoSeleccionado.agregarEmpleado(empleado);
                JOptionPane.showMessageDialog(this, "Empleado asignado al departamento: " + departamentoSeleccionado.getNombre());
            } else {
                JOptionPane.showMessageDialog(this, "Empleado no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Departamento no válido.");
        }
    }

    // Método para visualizar empleados
    private void visualizarEmpleados() {
        StringBuilder sb = new StringBuilder("Lista de empleados:\n");
        for (Empleado empleado : listaEmpleados) {
            sb.append(empleado.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString());
    }

    // Método para gestionar departamentos
    private void gestionarDepartamentos() {
        String[] opciones = {"Crear Departamento", "Visualizar Empleados en Departamento"};
        int seleccion = JOptionPane.showOptionDialog(this, "Seleccione una opción:", "Gestión de Departamentos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) {
            crearDepartamento();
        } else if (seleccion == 1) {
            visualizarEmpleadosEnDepartamento();
        }
    }

    // Método para crear un departamento
    private void crearDepartamento() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del departamento:");
        listaDepartamentos.add(new Departamento(nombre));
        JOptionPane.showMessageDialog(this, "Departamento creado con éxito.");
    }

    // Método para visualizar empleados en un departamento
    private void visualizarEmpleadosEnDepartamento() {
        if (listaDepartamentos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay departamentos creados.");
            return;
        }

        StringBuilder sb = new StringBuilder("Departamentos disponibles:\n");
        for (int i = 0; i < listaDepartamentos.size(); i++) {
            sb.append((i + 1)).append(". ").append(listaDepartamentos.get(i).getNombre()).append("\n");
        }

        String input = JOptionPane.showInputDialog(sb.toString() + "Seleccione el número del departamento:");
        int indice = Integer.parseInt(input) - 1;

        if (indice >= 0 && indice < listaDepartamentos.size()) {
            listaDepartamentos.get(indice).visualizarEmpleados();
        } else {
            JOptionPane.showMessageDialog(this, "Departamento no válido.");
        }
    }

    // Método para generar reportes
    private void generarReporte() {
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados registrados.");
            return;
        }

        // Mostrar lista de empleados disponibles
        StringBuilder sb = new StringBuilder("Empleados disponibles:\n");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            sb.append((i + 1)).append(". ").append(listaEmpleados.get(i).getNombre()).append(" ").append(listaEmpleados.get(i).getApellido()).append("\n");
        }

        // Seleccionar empleado
        String input = JOptionPane.showInputDialog(sb.toString() + "Seleccione el número del empleado:");
        int indice = Integer.parseInt(input) - 1;

        if (indice >= 0 && indice < listaEmpleados.size()) {
            Empleado empleadoSeleccionado = listaEmpleados.get(indice);

            // Pedir las métricas del reporte
            String metricas = JOptionPane.showInputDialog("Ingrese las métricas del desempeño:");

            // Crear un nuevo reporte de desempeño
            ReporteDesempenio nuevoReporte = new ReporteDesempenio(listaReportes.size() + 1, empleadoSeleccionado, metricas);

            // Agregar el reporte a la lista del empleado seleccionado
            empleadoSeleccionado.agregarReporte(nuevoReporte);

            // Agregar el reporte a la lista general de reportes (opcional)
            listaReportes.add(nuevoReporte);

            JOptionPane.showMessageDialog(this, "Reporte generado correctamente para " + empleadoSeleccionado.getNombre() + " " + empleadoSeleccionado.getApellido());
        } else {
            JOptionPane.showMessageDialog(this, "Empleado no válido.");
        }
    }


    // Método para visualizar reportes de un empleado
    private void visualizarReportesEmpleado() {
        if (listaEmpleados.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay empleados registrados.");
            return;
        }

        StringBuilder sb = new StringBuilder("Empleados disponibles:\n");
        for (int i = 0; i < listaEmpleados.size(); i++) {
            sb.append((i + 1)).append(". ").append(listaEmpleados.get(i).getNombre()).append(" ").append(listaEmpleados.get(i).getApellido()).append("\n");
        }

        String input = JOptionPane.showInputDialog(sb.toString() + "Seleccione el número del empleado:");
        int indice = Integer.parseInt(input) - 1;

        if (indice >= 0 && indice < listaEmpleados.size()) {
            Empleado empleadoSeleccionado = listaEmpleados.get(indice);

            if (empleadoSeleccionado.getListaReportes().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El empleado no tiene reportes disponibles.");
                return;
            }

            StringBuilder reporteSb = new StringBuilder("Reportes del empleado:\n");
            for (ReporteDesempenio reporte : empleadoSeleccionado.getListaReportes()) {
                reporteSb.append(reporte.toString()).append("\n");
            }

            JOptionPane.showMessageDialog(this, reporteSb.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Empleado no válido.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main mainApp = new Main();
            mainApp.setVisible(true);
        });
    }
}
