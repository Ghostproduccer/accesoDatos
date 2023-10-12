package institutoBruno;

public class AlumnoBruno extends PersonaBruno {
    private int iNota;

    public AlumnoBruno(String sNombre, int iEdad, String aulaAsignada, int iNota) {
        super(sNombre, iEdad, aulaAsignada);
        this.iNota = iNota;
    }

    public int getNota() {
        return iNota;
    }

    public void setNota(int nota) {
        this.iNota = iNota;
    }
}
