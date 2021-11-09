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
        listadoRecompensas.append("La recompensa total del Colegio Hogwarts es de ").append(sumaRecompensas).append(" galeones");

        return listadoRecompensas.toString();
    }

    public String imprimirSalarios() {
        int sumaSalarios = 0;
        StringBuilder listadoSalarios = new StringBuilder();

        for (Integrantes f : x) {
            sumaSalarios += f.getSalario();
            listadoSalarios.append(f.getImprimirSalarios());
        }
        listadoSalarios.append("El gasto de Hogwarts en personal es de ").append(sumaSalarios).append(" galeones");

        return listadoSalarios.toString();
    }

}

