package e1;

import java.util.ArrayList;
import java.util.List;

public class Colegio {
    List<Integrantes> x;
    List<Personal> y;

    public Colegio() {
        x = new ArrayList<>();
        y = new ArrayList<>();
    }

    public String imprimirRecompensas() {
        int i = 0;
        float sumaRecompensas = 0;
        String listadoRecompensas = null;
        for (Integrantes f: x) {
            sumaRecompensas += f.getRecompensa();
            String info = f.getNombre() + " " + f.getApellido() + "(" + f.integrante() + "," + f.horrocruxes + " horrocruxes): " + f.getRecompensa() + " galeones\n";
            if (i == 0) {
                listadoRecompensas = info;
            }
            else {
                listadoRecompensas = listadoRecompensas + info;
            }
            i++;
        }
        listadoRecompensas = listadoRecompensas + "La recompensa total del Colegio Hogwarts es de " + sumaRecompensas;

        return listadoRecompensas;
    }

    public String imprimirSalarios() {
        int i = 0;
        float sumaSalarios = 0;
        String listadoSalarios = null;
        for (Personal f: y) {
            sumaSalarios += f.getSalario();
            String info = f.getNombre() + " " + f.getApellido() + "(" + f.integrante() + "): " + f.getSalario() + " galeones\n";
            if (i == 0) {
                listadoSalarios = info;
            }
            else {
                listadoSalarios = listadoSalarios + info;
            }
            i++;

        }
        return listadoSalarios;
    }

    public static void main(String[] args) {
        Colegio c1 = new Colegio();
        Integrantes i1 = new Conserjes("pepe", "manuel", 18, 4, 5);
        Integrantes i2 = new Conserjes("paco", "maria", 23, 5, 5);
        Integrantes i3 = new Guardabosques("pepa", "pig", 46, 5,4);
        Integrantes i4 = new Fantasmas("lola", "que", 46, "Slytherin",2);
        Integrantes i5 = new Estudiantes("laura", "ciii", 46, "Gryffindor",0);
        Personal i6 = new Docentes("pepito", "xDDDDD", 2, "Pociones",3);


        c1.x.add(i1);
        c1.x.add(i2);
        c1.x.add(i3);
        c1.x.add(i4);
        c1.x.add(i5);
        c1.y.add(i6);



        System.out.println(c1.imprimirRecompensas());
        System.out.println(c1.imprimirSalarios());


    }

}

