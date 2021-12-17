package e2;

import java.util.ArrayList;
import java.util.List;

public class ListaDeTareas {
    List <Tarea> tareas;

    public ListaDeTareas() {
        tareas = new ArrayList<>();
    }
    public void addTarea(Tarea tarea) {
        tareas.add(tarea);
    }
    public void deleteTarea(Tarea tarea) {
        tareas.remove(tarea);
    }
    public Tarea verTarea(int i) {
        return tareas.get(i);
    }
}
