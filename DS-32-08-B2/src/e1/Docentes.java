package e1;

public class Docentes extends Personal {
    enum Asignaturas {Historia(200), Transformaciones(400), Defensa(500), Herbologia(250), Pociones(350);
        private int salario;

        public int getSalario() {
            return this.salario;
        }
        Asignaturas (int salario) {
            this.salario = salario;
        }
    };

    private final static int galeonesPorHorrocruxes = 50;

    Asignaturas clase;

    public Docentes (String nombre, String apellido, int edad, Asignaturas inputAsignatura, int horrocruxesDestruidos) {
        super(nombre, apellido, edad);
        this.asignatura = inputAsignatura.toString();
        this.salario = inputAsignatura.getSalario();
        this.horrocruxes = horrocruxesDestruidos;

        if (this.asignatura.compareTo("Defensa") == 0) {
            this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos - (0.25 * galeonesPorHorrocruxes * horrocruxesDestruidos);
        }
        else {
            this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        }
    }

    public String integrante() {
        return "Docente de " + this.getAsignatura();
    }

    public String getImprimirSalarios() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + "): " + this.getSalario() + " galeones\n";
    }

    public String getImprimirRecompensas() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + " ," + this.getHorrocruxes() + " horrocruxes): " + this.getRecompensa() + " galeones\n";
    }

}
