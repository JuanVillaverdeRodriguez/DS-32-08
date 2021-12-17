package e1;

public class CriterioDestino extends ElementoDeBusqueda {
    private String destino;
    public CriterioDestino(String criterioDestino) {
        super(criterioDestino);
        this.destino = criterioDestino;
    }

    @Override
    public boolean filtrar(Billete billete) {
        return this.destino.compareTo(billete.getDestino()) == 0;
    }
}
