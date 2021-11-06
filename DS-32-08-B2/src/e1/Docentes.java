package e1;

public class Docentes extends Personal {
    enum Asignaturas {Historia, Transformaciones, Defensa, Herbologia, Pociones};
    private final static int galeonesPorHorrocruxes = 50;

    private String asignatura;
    Asignaturas clase;

    public Docentes (String nombre, String apellido, int edad, Asignaturas inputAsignatura, int horrocruxesDestruidos) {
        super(nombre, apellido, edad);
        this.asignatura = inputAsignatura.toString();

        if (this.asignatura.compareTo("Defensa") == 0) {
            this.salario = 500;
        }
        else if (this.asignatura.compareTo("Transformaciones") == 0) {
            this.salario = 400;
        }
        else if (this.asignatura.compareTo("Pociones") == 0) {
            this.salario = 350;
        }
        else if (this.asignatura.compareTo("Herbologia") == 0) {
            this.salario = 250;
        }
        else {
            this.salario = 200;
        }
        this.horrocruxes = horrocruxesDestruidos;

        if (this.asignatura.compareTo("Defensa") == 0) {
            this.recompensa += galeonesPorHorrocruxes - (0.25 * galeonesPorHorrocruxes) * horrocruxesDestruidos;
        }
        else {
            this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        }
    }

    public String integrante() {
        return "Docente de " + this.asignatura;
    }

    public String getImprimirSalarios() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + "): " + this.getSalario() + " galeones\n";
    }

    public String getImprimirRecompensas() {
        return this.nombre + " " + this.apellido + "(" + this.integrante() + "," + this.horrocruxes + " horrocruxes): " + this.recompensa + " galeones\n";
    }

}
