package e2;

import java.util.List;

public class GestorDeProyectos {
    AlgoritmosOrdenRealizacion ALG;
    public GestorDeProyectos(AlgoritmosOrdenRealizacion ALG) {
        this.ALG = ALG;
    }

    public void ordena(ListaDeTareas lista, DependenciasEntreTareas dependencias) {
        ALG.algOrdenRealizacion(lista, dependencias);
    }
}
