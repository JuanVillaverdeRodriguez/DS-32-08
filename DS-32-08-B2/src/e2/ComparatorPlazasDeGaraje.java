package e2;

import java.util.Comparator;

public class ComparatorPlazasDeGaraje implements Comparator <Apartamento> {
    public int compare(Apartamento A1, Apartamento A2) {
        if (A1.numeroPlazasDeGaraje < A2.numeroPlazasDeGaraje) {
            return -1;
        }
        else if (A1.numeroPlazasDeGaraje > A2.numeroPlazasDeGaraje) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
