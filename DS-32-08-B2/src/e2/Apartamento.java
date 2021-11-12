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
}
