package tiendapc;

public class OrdenadorPortatil extends Ordenador {

    private double dPeso;

    public OrdenadorPortatil(int iRam, String sCpu, double dPeso) {
        super(iRam, sCpu);
        this.dPeso = dPeso;

    }

    public String getCaracterísticas() {
        return "RAM: " + super.getiRam() + " gb. CPU: " + super.getsCpu() + ". Peso: " + this.dPeso;
    }

    @Override
    public String toString() {
        return "OrdenadorPortatil [iCodigo=" + super.getiCodigo() + ", iRam=" + super.getiRam() + ", sCpu="
                + super.getsCpu() + ", dPeso=" + dPeso + "]";
    }

}
