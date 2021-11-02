package e1;

enum Asignaturas {Historia, Transformaciones, Defensa, Herbologia, Pociones};

public class Docentes extends Personal {
    private String asignatura;
    Asignaturas clase;

    public String getAsignatura () {
        return this.asignatura;
    }

    public void setAsignatura (String inputAsignatura){
        try {
            clase = Asignaturas.valueOf(inputAsignatura);
            this.asignatura = inputAsignatura;
        } catch (IllegalArgumentException ex) {
            System.out.println("Esta asignatura no existe");
        }
    }
}
