package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestionDeBilletesTest {
    String resultado1 = """
            Origen: Santiago Destino: Coruña Precio: 15 Fecha: 12/12/2021""";

    String resultado2 = """
            Origen: Santiago Destino: Coruña Precio: 15 Fecha: 12/12/2021
            Origen: Santiago Destino: Coruña Precio: 17 Fecha: 12/12/2021
            Origen: Santiago Destino: Orense Precio: 17 Fecha: 12/12/2021
            Origen: Santiago Destino: Coruña Precio: 15 Fecha: 12/12/2022
            Origen: Orense Destino: Coruña Precio: 14 Fecha: 12/12/2022""";

    @Test
    public void test() {
        GestionDeBilletes G1 = new GestionDeBilletes();
        Billete billete = new Billete("Santiago", "Coruña", 15, "12/12/2021");
        Billete billete2 = new Billete("Santiago", "Coruña", 17, "12/12/2021");
        Billete billete3 = new Billete("Santiago", "Orense", 17, "12/12/2021");
        Billete billete4 = new Billete("Santiago", "Coruña", 15, "12/12/2022");
        Billete billete5 = new Billete("Orense", "Coruña", 14, "12/12/2022");
        Billete billete6 = new Billete("Orense", "Santiago", 17, "12/12/2026");

        G1.addBillete(billete);
        G1.addBillete(billete2);
        G1.addBillete(billete3);
        G1.addBillete(billete4);
        G1.addBillete(billete5);
        G1.addBillete(billete6);

        CriterioOrigen CO = new CriterioOrigen("Santiago");
        CriterioDestino CD = new CriterioDestino("Coruña");
        CriterioPrecio CP = new CriterioPrecio(15);
        CriterioFecha CF = new CriterioFecha("12/12/2021");

        ClausulaAND C_AND = new ClausulaAND("AND", CO, CD);
        ClausulaAND C_AND2 = new ClausulaAND("AND", C_AND, CP);
        ClausulaAND C_AND3 = new ClausulaAND("AND", C_AND2, CF);

        ClausulaOR C_OR = new ClausulaOR("OR", CO, CD);
        ClausulaOR C_OR2 = new ClausulaOR("OR", C_OR, CP);
        ClausulaOR C_OR3 = new ClausulaOR("OR", C_OR2, CF);

        assertEquals(G1.verBilletesDisponibles(C_AND3, G1.listaBilletes), resultado1);
        assertEquals(G1.verBilletesDisponibles(C_OR3, G1.listaBilletes), resultado2);

    }

}