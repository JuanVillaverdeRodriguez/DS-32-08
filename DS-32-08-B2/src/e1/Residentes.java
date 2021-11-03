package e1;

enum Casas {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}

public class Residentes extends Integrantes {
    private String casa;
    Casas hogar;

    public Residentes (String nombre, String apellido, int edad, String inputCasa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        try {
            hogar = Casas.valueOf(inputCasa);
            this.casa = inputCasa;
        } catch (IllegalArgumentException ex) {
            System.out.println("Esta casa no existe");
        }

    }

    public String getCasa() {
        return this.casa;
    }

}
