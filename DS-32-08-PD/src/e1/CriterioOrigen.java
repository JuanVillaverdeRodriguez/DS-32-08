package e1;

public class CriterioOrigen extends ElementoDeBusqueda {
    private String origen;
    public CriterioOrigen(String criterioOrigen) {
        super(criterioOrigen);
        this.origen = criterioOrigen;
    }

    @Override
    public boolean filtrar(Billete billete) {
        return this.origen.compareTo(billete.getOrigen()) == 0;
    }


}
