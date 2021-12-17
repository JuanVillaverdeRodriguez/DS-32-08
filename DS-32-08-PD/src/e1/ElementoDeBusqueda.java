package e1;

public abstract class ElementoDeBusqueda {
    private String criterio;
    public ElementoDeBusqueda(String criterio) {
        this.criterio = criterio;
    }
    public abstract boolean filtrar(Billete billete);


}
