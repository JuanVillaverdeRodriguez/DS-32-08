package e2;

import java.util.Comparator;

public class ComparatorPrecioTotal implements Comparator<Apartamento> {
    public int compare(Apartamento A1, Apartamento A2) {
        if (A1.precioTotal < A2.precioTotal) {
            return -1;
        }
        else if (A1.precioTotal > A2.precioTotal) {
            return 1;
        }
        else {
            return 0;
        }
    }




}
