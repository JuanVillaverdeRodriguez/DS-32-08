package e1;

import java.util.ArrayList;
import java.util.List;

public class GestionDeBilletes {
    List <Billete> listaBilletes;

    public GestionDeBilletes() {
        listaBilletes = new ArrayList<>();
    }
    public void addBillete(Billete billete) {
        listaBilletes.add(billete);
    }

    public String verBilletesDisponibles(Clausulas clausulas, List <Billete> lista) {
        String BilleteString = "";
        for (Billete bill: lista) {
            if(clausulas.filtrar(bill)) {
                BilleteString = BilleteString.concat("Origen: ").concat(bill.getOrigen()).concat(" Destino: ").concat(bill.getDestino())
                        .concat(" Precio: ").concat(String.valueOf(bill.getPrecio())).concat(" Fecha: ").concat(bill.getFecha()).concat("\n");
            }
        }
        return BilleteString.trim();
    }
}
