package e1;

enum Asignaturas {Historia, Transformaciones, Defensa, Herbologia, Pociones};

public class Docentes extends Personal {
    private final static int galeonesPorHorrocruxes = 50;

    private String asignatura;
    Asignaturas clase;

    public Docentes (String nombre, String apellido, int edad, String inputAsignatura ) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        try {
            clase = Asignaturas.valueOf(inputAsignatura);
            this.asignatura = inputAsignatura;
        } catch (IllegalArgumentException ex) {
            System.out.println("Esta asignatura no existe o ya la esta impartiendo un docente");
        }
        this.salario = 0;
        this.recompensa = 0;
    }

    public String getAsignatura () {
        return this.asignatura;
    }



    public void setRecompensa (int horrocruxesDestruidos) {
        if (this.getAsignatura().compareTo("Defensa") == 0) {
            this.recompensa += galeonesPorHorrocruxes - (0.25 * galeonesPorHorrocruxes) * horrocruxesDestruidos;
        }
        else {
            this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        }
    }

    public void setSalario () {
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
    }
}
