package e1;

public class Billete  {
    private String origen;
    private String destino;
    private int precio;
    private String fecha;

    public Billete(String origen, String destino, int precio, String fecha) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getPrecio() {
        return precio;
    }

    public String getFecha() {
        return fecha;
    }
}