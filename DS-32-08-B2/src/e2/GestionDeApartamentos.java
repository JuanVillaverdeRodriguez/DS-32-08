package e2;

import java.util.ArrayList;
import java.util.List;

public class GestionDeApartamentos {
    List<Apartamento> listaApartamentos; //Lista de apartamentos
    CriterioDeComparacion CC;

    public GestionDeApartamentos() {
        listaApartamentos = new ArrayList<>();
        CC = new CriterioDeComparacion();
    }


}
