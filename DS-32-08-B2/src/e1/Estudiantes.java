package e1;

public class Estudiantes extends Residentes  {
    private final static int galeonesPorHorrocruxes = 90;

    public Estudiantes(String nombre, String apellido, int edad, String inputCasa, int horrocruxesDestruidos) {
        super(nombre, apellido, edad, inputCasa);
        this.horrocruxes = horrocruxesDestruidos;
        if (this.getCasa().compareTo("Slytherin") == 0) {
            this.recompensa += 2*galeonesPorHorrocruxes * horrocruxesDestruidos;
        }
        else {
            this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        }
    }

    public String integrante() {
        return "Estudiante de " + this.getCasa();
    }
}
