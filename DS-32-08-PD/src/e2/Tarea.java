package e2;

import java.util.ArrayList;
import java.util.List;

public class Tarea {
    Character c;
    boolean marcada;
    List<Tarea> DependenciasDeTarea;
    public Tarea(Character c) {
        this.c = c;
        DependenciasDeTarea = new ArrayList<>();
    }

    public Character getTarea() {
        return this.c;
    }
    public List <Tarea> getDependencias() {
        return this.DependenciasDeTarea;
    }
    public boolean estaMarcada() {
        return this.marcada;
    }
    public void setMarcada() {
        this.marcada = true;
    }


}
