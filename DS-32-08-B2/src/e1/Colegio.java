package e1;

import java.util.ArrayList;
import java.util.List;

public class Colegio {
    List<Integrantes> x;

    public Colegio() {
        x = new ArrayList<>();
    }

    public String imprimirRecompensas() {
        float sumaRecompensas = 0;
        StringBuilder listadoRecompensas = new StringBuilder();

        for (Integrantes f: x) {
            sumaRecompensas += f.getRecompensa();
            listadoRecompensas.append(f.getImprimirRecompensas());
        }
        listadoRecompensas.append("La recompensa total del Colegio Hogwarts es de ").append(sumaRecompensas).append("\n");

        return listadoRecompensas.toString();
    }

    public String imprimirSalarios() {
        float sumaSalarios = 0;
        StringBuilder listadoSalarios = new StringBuilder();

        for (Integrantes f : x) {
            sumaSalarios += f.getSalario();
            listadoSalarios.append(f.getImprimirSalarios());
        }
        listadoSalarios.append("El gasto de Hogwarts en personal es de ").append(sumaSalarios).append(" galeones");

        return listadoSalarios.toString();
    }
    /*
    public static void main(String[] args) {
        Colegio c1 = new Colegio();
        Integrantes i1 = new Conserjes("pepe", "manuel", 18, 1, 2);
        Integrantes i2 = new Conserjes("paco", "mermela", 23, 1, 2);
        Integrantes i3 = new Guardabosques("pepa", "pig", 46, 5,4);
        Integrantes i4 = new Fantasmas("maria", "umpajote", 46, Residentes.Casas.Gryffindor,2);
        Integrantes i5 = new Estudiantes("laura", "ciii", 46, Residentes.Casas.Gryffindor,0);
        Integrantes i6 = new Docentes("pepito", "grillo", 2,Docentes.Asignaturas.Herbologia ,3);


        c1.x.add(i1);
        c1.x.add(i2);
        c1.x.add(i3);
        c1.x.add(i4);
        c1.x.add(i5);
        c1.x.add(i6);

        System.out.println(c1.imprimirRecompensas());
        //System.out.println(c1.imprimirSalarios());

    }*/

}

