import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Clase SistemaGestionRRHH para gestionar Empleados y Departamentos
    public static class SistemaGestionRRHH {
        private ArrayList<Empleado> listaEmpleados;
        private ArrayList<Departamento> listaDepartamentos;

        public SistemaGestionRRHH() {
            listaEmpleados = new ArrayList<>();
            listaDepartamentos = new ArrayList<>();
        }

        public void gestionarEmpleados() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Gestión de empleados:");
            System.out.println("1. Crear empleado");
            System.out.println("2. Visualizar empleados");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            switch (opcion) {
                case 1:
                    crearEmpleado();
                    break;
                case 2:
                    visualizarEmpleados();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        public void gestionarDepartamentos() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Gestión de departamentos:");
            System.out.println("1. Crear departamento");
            System.out.println("2. Visualizar empleados en departamento");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            switch (opcion) {
                case 1:
                    crearDepartamento();
                    break;
                case 2:
                    visualizarEmpleadosEnDepartamento();
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }

        private void crearEmpleado() {
            Scanner scanner = new Scanner(System.in);

            // Ingresar ID de empleado
            System.out.println("Ingrese el ID del empleado:");
            int idEmpleado = scanner.nextInt();
            scanner.nextLine(); // Consume el salto de línea

            // Ingresar nombre y apellido
            System.out.println("Ingrese el nombre del empleado:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el apellido del empleado:");
            String apellido = scanner.nextLine();

            // Elegir tipo de empleado
            System.out.println("¿Es un empleado permanente o temporal? (1: Permanente, 2: Temporal)");
            int tipo = scanner.nextInt();

            if (tipo == 1) {
                System.out.println("Ingrese el salario:");
                double salario = scanner.nextDouble();
                Empleado nuevoEmpleado = new EmpleadoPermanente(idEmpleado, nombre, apellido, salario);
                listaEmpleados.add(nuevoEmpleado);
            } else if (tipo == 2) {
                System.out.println("Ingrese la tarifa por hora:");
                double tarifaPorHora = scanner.nextDouble();
                Empleado nuevoEmpleado = new EmpleadoTemporal(idEmpleado, nombre, apellido, tarifaPorHora);
                listaEmpleados.add(nuevoEmpleado);
            }

            System.out.println("Empleado creado con éxito.");
        }

        private void visualizarEmpleados() {
            System.out.println("Lista de empleados:");
            for (Empleado empleado : listaEmpleados) {
                System.out.println(empleado);
            }
        }

        private void crearDepartamento() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el nombre del departamento:");
            String nombre = scanner.nextLine();
            Departamento nuevoDepartamento = new Departamento(listaDepartamentos.size() + 1, nombre);
            listaDepartamentos.add(nuevoDepartamento);
            System.out.println("Departamento creado con éxito.");
        }

        private void visualizarEmpleadosEnDepartamento() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el ID del departamento:");
            int idDepartamento = scanner.nextInt();

            Departamento departamento = listaDepartamentos.get(idDepartamento - 1);
            departamento.visualizarEmpleados();
        }
    }

    // Método main
    public static void main(String[] args) {
        SistemaGestionRRHH sistema = new SistemaGestionRRHH();

        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("Sistema de Gestión de RRHH:");
            System.out.println("1. Gestionar empleados");
            System.out.println("2. Gestionar departamentos");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    sistema.gestionarEmpleados();
                    break;
                case 2:
                    sistema.gestionarDepartamentos();
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        System.out.println("Saliendo del sistema...");
    }
}
