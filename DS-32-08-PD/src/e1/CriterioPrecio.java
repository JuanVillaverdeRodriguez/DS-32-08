package e1;

public class CriterioPrecio extends ElementoDeBusqueda {
    private int precio;
    public CriterioPrecio(int criterioPrecio) {
        super(Integer.toString(criterioPrecio));
        this.precio = criterioPrecio;
    }

    @Override
    public boolean filtrar(Billete billete) {
        return this.precio >= billete.getPrecio();
    }
}

