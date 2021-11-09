package e1;

public class Conserjes extends Personal {
    private final static int galeonesPorHorrocruxes = 65;

    public Conserjes (String nombre, String apellido, int edad, int horrocruxesDestruidos, int nocturnidades) {
        super(nombre, apellido, edad);
        this.horrocruxes = horrocruxesDestruidos;
        this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        this.salario = 150 + (10 * nocturnidades);
    }

    public String integrante() {
        return "Conserje";
    }

    public String getImprimirSalarios() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + "): " + this.getSalario() + " galeones\n";
    }

    public String getImprimirRecompensas() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + " ," + this.getHorrocruxes() + " horrocruxes): " + this.getRecompensa() + " galeones\n";
    }

}
