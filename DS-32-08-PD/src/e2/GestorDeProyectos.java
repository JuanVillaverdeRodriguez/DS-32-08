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

    public static void main(String[] args) {
        OrdenDependenciaFuerte ODF = new OrdenDependenciaFuerte();
        GestorDeProyectos gestor = new GestorDeProyectos(ODF);
        ListaDeTareas lista = new ListaDeTareas();
        DependenciasEntreTareas Dependencias = new DependenciasEntreTareas();

        Tarea A = new Tarea('A');
        Tarea B = new Tarea('B');
        Tarea C = new Tarea('C');
        Tarea D = new Tarea('D');
        Tarea E = new Tarea('E');
        Tarea F = new Tarea('F');
        Tarea G = new Tarea('G');
        Tarea H = new Tarea('H');
        Tarea J = new Tarea('J');

        lista.addTarea(A);
        lista.addTarea(B);
        lista.addTarea(C);
        lista.addTarea(D);
        lista.addTarea(E);
        lista.addTarea(F);
        lista.addTarea(G);
        lista.addTarea(H);
        lista.addTarea(J);

        Dependencias.setDependencia(A, C);
        Dependencias.setDependencia(F, C);
        Dependencias.setDependencia(B, A);
        Dependencias.setDependencia(D, A);
        Dependencias.setDependencia(E, B);
        Dependencias.setDependencia(E, D);
        Dependencias.setDependencia(E, F);
        Dependencias.setDependencia(F, G);
        Dependencias.setDependencia(H, G);
        Dependencias.setDependencia(J, F);
        Dependencias.setDependencia(J, H);

        System.out.println(Dependencias.dependeDe(E,A));

        gestor.ordena(lista, Dependencias);


    }

}
