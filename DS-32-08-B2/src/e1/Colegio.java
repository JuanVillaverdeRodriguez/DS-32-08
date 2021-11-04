package e1;

import java.util.ArrayList;
import java.util.List;

public class Colegio {
    List<Integrantes> x;
    ArrayList <String> a;

    public Colegio() {
        x = new ArrayList<>();
    }

    public String imprimirRecompensas() {
        int i = 0;
        String listadoRecompensas = null;
        for (Integrantes f: x) {
            String info = f.getNombre() + " " + f.getApellido() + "(" + f.integrante() + "," + f.horrocruxes + " horrocruxes):" + f.getRecompensa() + " galeones\n";
            if (i == 0) {
                listadoRecompensas = info;
            }
            else {
                listadoRecompensas = listadoRecompensas + info;
            }
            i++;
        }
        listadoRecompensas = listadoRecompensas + "La recompensa total del Colegio Hogwarts es de" + 
        return listadoRecompensas;
    }

    public String imprimirSalarios() {
        String listadoSalarios = "LOL";
        return listadoSalarios;
    }

    public static void main(String[] args) {
        Colegio c1 = new Colegio();
        Integrantes i1 = new Conserjes("pepe", "manuel", 18, 4, 5);
        Integrantes i2 = new Conserjes("pepe", "manuel", 18, 5, 5);
        c1.x.add(i1);
        c1.x.add(i2);
        System.out.println(c1.imprimirRecompensas());

    }

}

