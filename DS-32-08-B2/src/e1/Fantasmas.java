package e1;

public class Fantasmas extends Residentes {
    private final static int galeonesPorHorrocruxes = 80;

    public Fantasmas(String nombre, String apellido, int edad, String inputCasa) {
        super(nombre, apellido, edad, inputCasa);
        this.recompensa = 0;
    }

    public void setRecompensa (int horrocruxesDestruidos) {
        if (this.getCasa().compareTo("Slytherin") == 0) {
            this.recompensa += 2*galeonesPorHorrocruxes * horrocruxesDestruidos;
        }
        else {
            this.recompensa += galeonesPorHorrocruxes * horrocruxesDestruidos;
        }

    }
}
