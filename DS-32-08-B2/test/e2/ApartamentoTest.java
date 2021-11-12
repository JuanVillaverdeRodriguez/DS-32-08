package e2;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class ApartamentoTest {

    @Test
    public void test() {
        //INSTANCIACION DE COMPARATORS
        Comparator<Apartamento> comparatorPlazasDeGaraje = new ComparatorPlazasDeGaraje();
        Comparator<Apartamento> comparatorTamano = new ComparatorTamano();
        Comparator<Apartamento> comparatorPrecioBase = new ComparatorPrecioBase();
        Comparator<Apartamento> comparatorPrecioTotal = new ComparatorPrecioTotal();

        //INSTANCIACION DE GESTORES DE APARTAMENTOS
        GestionDeApartamentos g1 = new GestionDeApartamentos(comparatorPlazasDeGaraje);
        GestionDeApartamentos g2 = new GestionDeApartamentos(comparatorTamano);
        GestionDeApartamentos g3 = new GestionDeApartamentos(comparatorPrecioBase);
        GestionDeApartamentos g4 = new GestionDeApartamentos(comparatorPrecioTotal);

        //INSTANCIACION DE APARTAMENTOS
        Apartamento a1 = new Apartamento(10, 36121, 2, "2D", "San Jorge", 23400, 1, 600, 2000, 4000);
        Apartamento a2 = new Apartamento(10, 36121, 3, "2D", "San Pedro", 1000, 2, 240, 800);
        Apartamento a3 = new Apartamento(40, 36100, 2, "2I", "Rua Nova", 1000,3, 240);
        Apartamento a4 = new Apartamento(50, 36100, 6, "3D", "Alfonso Molina", 30000,4);
        Apartamento a5 = new Apartamento(100, 36100, 1, "2I", "Insua Rivas", 1000000,5, 100, 50, 0);

        //AÑADIR APARTAMENTOS A LA LISTA G1
        g1.listaApartamentos.add(a2);
        g1.listaApartamentos.add(a1);
        g1.listaApartamentos.add(a3);
        g1.listaApartamentos.add(a5);
        g1.listaApartamentos.add(a4);


        //COMPROBAR DESORDEN (EN FUNCION DEL ORDEN DE ADICION A LA LISTA)
        assertEquals(2 ,g1.listaApartamentos.get(0).numeroReferencia);
        assertEquals(1 ,g1.listaApartamentos.get(1).numeroReferencia);
        assertEquals(3 ,g1.listaApartamentos.get(2).numeroReferencia);
        assertEquals(5 ,g1.listaApartamentos.get(3).numeroReferencia);
        assertEquals(4 ,g1.listaApartamentos.get(4).numeroReferencia);

        //COMPARAR POR ORDEN NATURAL (COMPARABLE)
        Collections.sort(g1.listaApartamentos);
        assertEquals(1 ,g1.listaApartamentos.get(0).numeroReferencia);
        assertEquals(2 ,g1.listaApartamentos.get(1).numeroReferencia);
        assertEquals(3 ,g1.listaApartamentos.get(2).numeroReferencia);
        assertEquals(4 ,g1.listaApartamentos.get(3).numeroReferencia);
        assertEquals(5 ,g1.listaApartamentos.get(4).numeroReferencia);

        //COMPARAR EN FUNCION DEL COMPARATOR
        //COMPARADOR POR PLAZAS DE GARAJE
        Collections.sort(g1.listaApartamentos, g1.C);
        assertEquals(0 ,g1.listaApartamentos.get(0).numeroPlazasDeGaraje);
        assertEquals(1 ,g1.listaApartamentos.get(1).numeroPlazasDeGaraje);
        assertEquals(2 ,g1.listaApartamentos.get(2).numeroPlazasDeGaraje);
        assertEquals(3 ,g1.listaApartamentos.get(3).numeroPlazasDeGaraje);
        assertEquals(3 ,g1.listaApartamentos.get(4).numeroPlazasDeGaraje);

        g2.listaApartamentos.add(a2);
        g2.listaApartamentos.add(a1);
        g2.listaApartamentos.add(a3);
        g2.listaApartamentos.add(a5);
        g2.listaApartamentos.add(a4);

        //COMPARADOR POR TAMAÑO APARTAMENTO
        Collections.sort(g2.listaApartamentos, g2.C);
        assertEquals(10 ,g2.listaApartamentos.get(0).tamano);
        assertEquals(10 ,g2.listaApartamentos.get(1).tamano);
        assertEquals(40 ,g2.listaApartamentos.get(2).tamano);
        assertEquals(50 ,g2.listaApartamentos.get(3).tamano);
        assertEquals(100 ,g2.listaApartamentos.get(4).tamano);

        g3.listaApartamentos.add(a2);
        g3.listaApartamentos.add(a1);
        g3.listaApartamentos.add(a3);
        g3.listaApartamentos.add(a5);
        g3.listaApartamentos.add(a4);

        //COMPARADOR POR PRECIO BASE
        Collections.sort(g3.listaApartamentos, g3.C);
        assertEquals(1000 ,g3.listaApartamentos.get(0).precioBase);
        assertEquals(1000 ,g3.listaApartamentos.get(1).precioBase);
        assertEquals(23400 ,g3.listaApartamentos.get(2).precioBase);
        assertEquals(30000 ,g3.listaApartamentos.get(3).precioBase);
        assertEquals(1000000 ,g3.listaApartamentos.get(4).precioBase);

        g4.listaApartamentos.add(a2);
        g4.listaApartamentos.add(a1);
        g4.listaApartamentos.add(a3);
        g4.listaApartamentos.add(a5);
        g4.listaApartamentos.add(a4);

        //COMPARADOR POR PRECIO TOTAL
        Collections.sort(g4.listaApartamentos, g4.C);
        assertEquals(1240 ,g4.listaApartamentos.get(0).precioTotal);
        assertEquals(2040 ,g4.listaApartamentos.get(1).precioTotal);
        assertEquals(30000,g4.listaApartamentos.get(2).precioTotal);
        assertEquals(30000 ,g4.listaApartamentos.get(3).precioTotal);
        assertEquals(1000150 ,g4.listaApartamentos.get(4).precioTotal);
    }
}