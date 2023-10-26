package tiendapc;
public class Ordenador {

    private static int iContador = 0;
    private int iCodigo;
    private int iRam;
    private String sCpu;

    public Ordenador(int iRam, String sCpu) {
        this.iRam = iRam;
        this.sCpu = sCpu;
        incrementariContador();
        this.iCodigo = iContador;
    }

    public static void incrementariContador() {
        iContador++;
    }

    public int getiCodigo() {
        return iCodigo;
    }

    public int getiRam() {
        return iRam;
    }

    public void setiRam(int iRam) {
        this.iRam = iRam;
    }

    public String getsCpu() {
        return sCpu;
    }

    public void setsCpu(String sCpu) {
        this.sCpu = sCpu;
    }

    public String getCaracterísticas() {
        return "RAM: " + this.iRam + " gb. CPU: " + this.sCpu + ".";
    }

    @Override
    public String toString() {
        return "Ordenador [iCodigo=" + iCodigo + ", iRam=" + iRam + ", sCpu=" + sCpu + "]";
    }

}
