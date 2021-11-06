package e1;


public abstract class Residentes extends Integrantes {
    enum Casas {Gryffindor, Hufflepuff, Ravenclaw, Slytherin}

    private final String casa;

    public Residentes (String nombre, String apellido, int edad, Casas inputCasa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.casa = inputCasa.toString();
        /*
        try {
            hogar = Casas.valueOf(inputCasa);
            this.casa = inputCasa;
        } catch (IllegalArgumentException ex) {
            System.out.println("La casa proporcionada no existe");
        }*/
    }

    public String getCasa() {
        return this.casa;
    }

}
