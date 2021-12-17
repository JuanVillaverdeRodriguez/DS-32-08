package e2;

import java.util.List;

public class DependenciasEntreTareas {

    public void setDependencia(Tarea a, Tarea b) {
        a.DependenciasDeTarea.add(b);
    }

    public boolean todasSusDependenciasMarcadas(Tarea a) {
        int j = 0;
        for (int i = 0; i < a.DependenciasDeTarea.size(); i++) {
            if (a.DependenciasDeTarea.get(i).estaMarcada()) j++;
        }
        return j == a.DependenciasDeTarea.size();
    }

    public boolean todasLasTareasAnterioresHechas(Tarea a, DependenciasEntreTareas dependencias) {
        for (int i = 0; i < a.DependenciasDeTarea.size(); i++) {
            if (!a.getDependencias().isEmpty()) {
                if (!a.DependenciasDeTarea.get(i).estaMarcada()) return false;
                dependencias.todasLasTareasAnterioresHechas(a.DependenciasDeTarea.get(i), dependencias);
            }
        }
        return true;
    }

    public boolean dependeDe(Tarea a, Tarea b) {
        return a.DependenciasDeTarea.contains(b);
    }

    public boolean noDependeDeNadie(Tarea a) {
        return a.DependenciasDeTarea.isEmpty();
    }
}
