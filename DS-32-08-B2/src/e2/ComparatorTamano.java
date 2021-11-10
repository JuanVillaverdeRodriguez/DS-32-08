package e2;

import java.util.Comparator;

public class ComparatorTamano implements Comparator<Apartamento> {
    public int compare(Apartamento A1, Apartamento A2) {
        if (A1.tamano < A2.tamano) {
            return -1;
        }
            else if (A1.tamano > A2.tamano) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
