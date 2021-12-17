package e1;

public class ClausulaOR extends Clausulas {
    private ElementoDeBusqueda elementoUno;
    private ElementoDeBusqueda elementoDos;

    public ClausulaOR(String clausula, ElementoDeBusqueda elementoUno, ElementoDeBusqueda elementoDos) {
        super(clausula, elementoUno, elementoDos);
        this.elementoUno = elementoUno;
        this.elementoDos = elementoDos;
    }

    @Override
    public boolean filtrar(Billete billete) {
        return elementoUno.filtrar(billete) || elementoDos.filtrar(billete);
    }
}
