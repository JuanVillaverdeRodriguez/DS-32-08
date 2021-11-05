package e1;

public class Guardabosques extends Personal {
    private final static int galeonesPorHorrocruxes = 75;

    public Guardabosques (String nombre, String apellido, int edad, int horrocruxesDestruidos, int nocturnidades) {
        super(nombre, apellido, edad);
        this.horrocruxes = horrocruxesDestruidos;
        this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        this.salario = 170 + (10 * nocturnidades);
    }

    public String integrante() {
        return "Guardabosques";
    }

    public String getImprimirSalarios() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + "): " + this.getSalario() + " galeones\n";
    }




}
