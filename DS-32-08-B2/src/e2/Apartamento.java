package e2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Apartamento extends GestionDeApartamentos implements Comparable<Apartamento> {
    int tamano, codigoPostal, piso, numeroReferencia, precioBase, precioTotal, numeroPlazasDeGaraje;
    String calle, numeroDePuerta;

    public Apartamento(int tamano, int codigoPostal, int piso, String numeroDePuerta, String calle, int precioApartamento, int numeroReferencia, int ... precioPorPlazaGaraje) {
        this.tamano = tamano;
        this.codigoPostal = codigoPostal;
        this.piso = piso;
        this.numeroDePuerta = numeroDePuerta;
        this.calle = calle;
        this.precioBase = precioApartamento;
        this.precioTotal = precioApartamento;
        for (int i: precioPorPlazaGaraje) {
            this.precioTotal += i;
        }
        this.numeroPlazasDeGaraje = precioPorPlazaGaraje.length;
        this.numeroReferencia = numeroReferencia;
    }

    public int compareTo(Apartamento A) {
        if (this.numeroReferencia < A.numeroReferencia) {
            return -1;
        }
        else if (this.numeroReferencia > A.numeroReferencia) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Comparator<Apartamento> comparator = new ComparatorPlazasDeGaraje();
        GestionDeApartamentos g1 = new GestionDeApartamentos(comparator);

        Apartamento a1 = new Apartamento(10, 36121, 2, "2D", "San Jorge", 30000, 1, 200, 300, 100);
        Apartamento a2 = new Apartamento(10, 36121, 2, "2D", "San Jorge", 70000, 2, 240, 800);
        Apartamento a3 = new Apartamento(40, 36100, 3, "2I", "San Jorge", 40000,3, 240);

        g1.listaApartamentos.add(a2);
        g1.listaApartamentos.add(a1);
        g1.listaApartamentos.add(a3);

        System.out.println("DESORDENADO: ");
        for (int i = 0; i < g1.listaApartamentos.size(); ++i) {
            System.out.println(g1.listaApartamentos.get(i).numeroReferencia);
        }

        System.out.println("COMPARADOR POR ORDEN NATURAL (COMPARABLE): ");
        Collections.sort(g1.listaApartamentos); //COMPARADOR POR ORDEN NATURAL (COMPARABLE)
        for (int i = 0; i < g1.listaApartamentos.size(); ++i) {
            System.out.println(g1.listaApartamentos.get(i).numeroReferencia);
        }

        System.out.println("COMPARADOR POR ARGUMENTO (COMPARATOR): ");
        Collections.sort(g1.listaApartamentos, g1.C); //COMPARADOR POR ARGUMENTO (COMPARATOR)
        for (int i = 0; i < g1.listaApartamentos.size(); ++i) {
            System.out.println(g1.listaApartamentos.get(i).numeroReferencia);
        }
    }
}
