package e1;

enum Asignaturas {Historia, Transformaciones, Defensa, Herbologia, Pociones};

public class Docentes extends Personal {
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
    }

    public String getAsignatura () {
        return this.asignatura;
    }
}
