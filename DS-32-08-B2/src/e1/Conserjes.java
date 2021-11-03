package e1;

public class Conserjes extends Personal {
    private final static int galeonesPorHorrocruxes = 65;

    public Conserjes (String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.recompensa = 0;
        this.salario = 0;
    }

    public void setRecompensa (int horrocruxesDestruidos) {
        this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;

    }

    public void setSalario (int nocturnidades) {
        this.salario = 150 + (10 * nocturnidades);
    }
}
