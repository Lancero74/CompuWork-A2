package IUDIGITAL;

public class Departamento {
    private int idDepartamento;
    private String Nombre;
    private String ListaEmpleados;

// constructor
public Departamento(int idDepartamento, String nombre, String listaEmpleados) {
        this.idDepartamento = idDepartamento;
        this.Nombre = nombre;
        this.ListaEmpleados = listaEmpleados;

    }
// constructor vacio
    public Departamento() {
    }
    
 // getters  and setters
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getListaEmpleados() {
        return ListaEmpleados;
    }

    public void setListaEmpleados(String listaEmpleados) {
        ListaEmpleados = listaEmpleados;
    }
}
