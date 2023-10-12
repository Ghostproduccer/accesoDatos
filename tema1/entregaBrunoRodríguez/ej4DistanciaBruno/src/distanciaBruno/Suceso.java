package distanciaBruno;

public class Suceso extends Punto3D {
    private String descripcion;
    private long tiempo;

    public Suceso(int x, int y, int z, long tiempo, String descripcion) {
        super(x, y, z);
        this.tiempo = tiempo;
        this.descripcion = descripcion;
    }

    public long getTiempo() {
        return tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //metodo equals para sucesos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        Suceso otroSuceso = (Suceso) obj;
        return tiempo == otroSuceso.tiempo && descripcion.equals(otroSuceso.descripcion);
    }
}
