package e1;

public class Fantasmas extends Residentes {
    private final static int galeonesPorHorrocruxes = 80;

    public Fantasmas(String nombre, String apellido, int edad, Casas inputCasa, int horrocruxesDestruidos) {
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
        return "Fantasma de " + this.getCasa();
    }

    public String getImprimirSalarios() {
        return "";
    }

    public String getImprimirRecompensas() {
        return this.getNombre() + " " + this.getApellido() + "(" + this.integrante() + " ," + this.getHorrocruxes() + " horrocruxes): " + this.getRecompensa() + " galeones\n";
    }
}
