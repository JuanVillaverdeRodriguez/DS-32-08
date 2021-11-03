package e1;

public class Guardabosques extends Personal {
    private final static int galeonesPorHorrocruxes = 75;

    public Guardabosques (String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.recompensa = 0;
        this.salario = 0;
    }

    public void setRecompensa (int horrocruxesDestruidos) {
        this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;

    }

}
