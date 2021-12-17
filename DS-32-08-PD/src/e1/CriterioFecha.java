package e1;

public class CriterioFecha extends ElementoDeBusqueda {
    private String fecha;
    public CriterioFecha(String criterioFecha) {
        super(criterioFecha);
        this.fecha = criterioFecha;
    }

    @Override
    public boolean filtrar(Billete billete) {
        return this.fecha.compareTo(billete.getFecha()) == 0;
    }
}
