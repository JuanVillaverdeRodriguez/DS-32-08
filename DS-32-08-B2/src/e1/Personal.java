package e1;

public class Personal extends Integrantes {
    int salario;

    public Personal (String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    public int getSalario() {
        return this.salario;
    }

}
