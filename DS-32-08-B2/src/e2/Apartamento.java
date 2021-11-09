package e2;

import java.util.ArrayList;
import java.util.List;

public class Apartamento extends GestionDeApartamentos {
    int tamano, codigoPostal, piso, numeroReferencia;
    String calle, numeroDePuerta;
    Precio precio;

    public Apartamento(int tamano, int codigoPostal, int piso, String numeroDePuerta, String calle, int numeroReferencia) {
        this.tamano = tamano;
        this.codigoPostal = codigoPostal;
        this.piso = piso;
        this.numeroDePuerta = numeroDePuerta;
        this.calle = calle;
        this.numeroReferencia = numeroReferencia;

    }



    public static void main(String[] args) {
        GestionDeApartamentos g1 = new GestionDeApartamentos();

        Apartamento a1 = new Apartamento(10, 36121, 2, "2D", "San Jorge", 1);
        Apartamento a2 = new Apartamento(10, 36121, 2, "2D", "San Jorge", 2);
        Apartamento a3 = new Apartamento(40, 36100, 3, "2I", "San Jorge", 3);

        g1.listaApartamentos.add(0, a1);
        g1.listaApartamentos.add(0, a2);
        g1.listaApartamentos.add(0, a3);

    }

}
