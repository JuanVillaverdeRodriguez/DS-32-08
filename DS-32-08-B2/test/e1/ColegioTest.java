package e1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ColegioTest {
    String resultadoImprimirRecompensas = """
            Cristobal Colon(Conserje ,1 horrocruxes): 65.0 galeones
            Pepa Pig(Guardabosques ,5 horrocruxes): 375.0 galeones
            Maria Maestro(Fantasma de Slytherin ,2 horrocruxes): 320.0 galeones
            Laura Villaverde(Estudiante de Gryffindor ,0 horrocruxes): 0.0 galeones
            Pepito Grillo(Docente de Herbologia ,3 horrocruxes): 150.0 galeones
            Paco Garcia(Docente de Defensa ,2 horrocruxes): 75.0 galeones
            La recompensa total del Colegio Hogwarts es de 985.0 galeones""";

    String resultadoImprimirSalarios = """
            Cristobal Colon(Conserje): 170 galeones
            Pepa Pig(Guardabosques): 210 galeones
            Pepito Grillo(Docente de Herbologia): 250 galeones
            Paco Garcia(Docente de Defensa): 500 galeones
            El gasto de Hogwarts en personal es de 1130 galeones""";


    @Test
    public void imprimirRecompensas() {
        Colegio c1 = new Colegio();

        Integrantes i1 = new Conserjes("Cristobal", "Colon", 18, 1, 2); //Correcto
        Integrantes i2 = new Guardabosques("Pepa", "Pig", 46, 5,4); //Correcto
        Integrantes i3 = new Fantasmas("Maria", "Maestro", 46, Residentes.Casas.Slytherin,2); //Correcto, tiene descuento por vivir en Slytherin
        Integrantes i4 = new Estudiantes("Laura", "Villaverde", 46, Residentes.Casas.Gryffindor,0); //Correcto
        Integrantes i5 = new Docentes("Pepito", "Grillo", 2, Docentes.Asignaturas.Herbologia,3); //Correcto
        Integrantes i6 = new Docentes("Paco", "Garcia", 2, Docentes.Asignaturas.Defensa,2); //Correcto

        c1.x.add(i1);
        c1.x.add(i2);
        c1.x.add(i3);
        c1.x.add(i4);
        c1.x.add(i5);
        c1.x.add(i6);

        assertEquals(resultadoImprimirRecompensas, c1.imprimirRecompensas());

    }
    @Test
    public void imprimirSalarios() {
        Colegio c1 = new Colegio();

        Integrantes i1 = new Conserjes("Cristobal", "Colon", 18, 1, 2); //Correcto
        Integrantes i2 = new Guardabosques("Pepa", "Pig", 46, 5,4); //Correcto
        Integrantes i3 = new Fantasmas("Maria", "Maestro", 46, Residentes.Casas.Slytherin,2); //Correcto, tiene descuento por vivir en Slytherin
        Integrantes i4 = new Estudiantes("Laura", "Villaverde", 46, Residentes.Casas.Gryffindor,0); //Correcto
        Integrantes i5 = new Docentes("Pepito", "Grillo", 2, Docentes.Asignaturas.Herbologia,3); //Correcto
        Integrantes i6 = new Docentes("Paco", "Garcia", 2, Docentes.Asignaturas.Defensa,2); //Correcto

        c1.x.add(i1);
        c1.x.add(i2);
        c1.x.add(i3);
        c1.x.add(i4);
        c1.x.add(i5);
        c1.x.add(i6);

        assertEquals(resultadoImprimirSalarios, c1.imprimirSalarios());

    }


}