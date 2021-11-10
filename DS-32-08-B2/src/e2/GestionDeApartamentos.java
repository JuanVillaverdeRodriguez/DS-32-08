package e2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GestionDeApartamentos {
    List<Apartamento> listaApartamentos; //Lista de apartamentos
    Comparator<Apartamento> C;

    public GestionDeApartamentos() {
        listaApartamentos = new ArrayList<>();
    }

    public GestionDeApartamentos(Comparator<Apartamento> comparator) {
        listaApartamentos = new ArrayList<>();
        C = comparator;

    }
}
