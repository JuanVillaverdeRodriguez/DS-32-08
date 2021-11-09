package e1;

import java.util.ArrayList;
import java.util.List;

public abstract class Integrantes  {
    String nombre;
    String apellido;
    int edad;
    float recompensa;
    int horrocruxes;
    int salario = 0;
    String asignatura;

    public abstract String integrante();

    public abstract String getImprimirSalarios();

    public abstract String getImprimirRecompensas();

    public String getAsignatura() {
        return this.asignatura;
    }

    public int getSalario() {
        return this.salario;
    }

    public int getHorrocruxes() {
        return this.horrocruxes;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public int getEdad() {
        return this.edad;
    }

    public float getRecompensa() {
        return this.recompensa;
    }

}
