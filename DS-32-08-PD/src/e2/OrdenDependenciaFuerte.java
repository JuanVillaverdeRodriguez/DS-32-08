package e2;

import java.util.ArrayList;
import java.util.List;

public class OrdenDependenciaFuerte implements AlgoritmosOrdenRealizacion {
    List <Tarea> noDependendientes;
    List <Character> ordenRealizacion;

    public OrdenDependenciaFuerte() {
        noDependendientes = new ArrayList<>();
        ordenRealizacion = new ArrayList<>();
    }

    @Override
    public void algOrdenRealizacion(ListaDeTareas lista, DependenciasEntreTareas dependencias) {
        Tarea menor;
        do {
            for (Tarea tarea: lista.tareas) {
                if (dependencias.todasLasTareasAnterioresHechas(tarea, dependencias)) {
                    noDependendientes.add(tarea);
                    System.out.println(tarea.getTarea());
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
    }
}
