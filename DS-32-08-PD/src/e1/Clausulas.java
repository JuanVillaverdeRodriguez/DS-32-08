package e1;

public abstract class Clausulas extends ElementoDeBusqueda {
    private ElementoDeBusqueda elemetoUno;
    private ElementoDeBusqueda elemetoDos;
    public Clausulas(String clausula, ElementoDeBusqueda elemento1, ElementoDeBusqueda elemento2) {
        super(clausula);
        this.elemetoUno = elemento1;
        this.elemetoDos = elemento2;
    }

}
