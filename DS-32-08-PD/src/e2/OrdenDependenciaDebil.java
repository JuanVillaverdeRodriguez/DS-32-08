package e2;

import java.util.ArrayList;
import java.util.List;

public class OrdenDependenciaDebil implements AlgoritmosOrdenRealizacion {
    List<Tarea> noDependendientes;
    List <Character> ordenRealizacion;

    public OrdenDependenciaDebil() {
        noDependendientes = new ArrayList<>();
        ordenRealizacion = new ArrayList<>();
    }

    @Override
    public void algOrdenRealizacion(ListaDeTareas lista, DependenciasEntreTareas dependencias) {
        Tarea menor;
        do {
            for (Tarea tarea: lista.tareas) {
                if (dependencias.noDependeDeNadie(tarea) && !tarea.estaMarcada() || (dependencias.todasSusDependenciasMarcadas(tarea) && !tarea.estaMarcada())) {
                    noDependendientes.add(tarea);
                    tarea.setMarcada();
                }
            }
            if (!noDependendientes.isEmpty()) {
                menor = noDependendientes.get(0);
                for (Tarea noDependendiente : noDependendientes) {
                    if (noDependendiente.getTarea() < menor.getTarea()) {
                        menor = noDependendiente;
                    }
                }
                ordenRealizacion.add(menor.getTarea());
                noDependendientes.remove(menor);
            }
        } while (!noDependendientes.isEmpty());
        System.out.println(ordenRealizacion);
    }
}
