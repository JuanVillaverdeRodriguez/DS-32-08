package e2;

import java.util.Comparator;

public class ComparatorPrecioBase implements Comparator<Apartamento> {
    public int compare(Apartamento A1, Apartamento A2) {
        if (A1.precioBase < A2.precioBase) {
            return -1;
        }
        else if (A1.precioBase > A2.precioBase) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
