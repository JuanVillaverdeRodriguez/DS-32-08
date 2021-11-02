package e1;

enum Casas {Gryffindor, Hufflepuff, Ravenclaw, Slytherin};

public class Residentes extends Integrantes {
    private String casa;
    Casas hogar;

    public String getCasa() {
        return this.casa;
    }
    public void setCasa(String inputCasa) {
        try {
            hogar = Casas.valueOf(inputCasa);
            this.casa = inputCasa;
        } catch (IllegalArgumentException ex) {
            System.out.println("Esta casa no existe");
        }
    }
}
