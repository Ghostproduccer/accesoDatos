package tiendapc;

public class OrdenadorSobremesa extends Ordenador {

    private String sTipoTorre;

    public OrdenadorSobremesa(int iRam, String sCpu, String sTipoTorre) {
        super(iRam, sCpu);
        this.sTipoTorre = sTipoTorre;
    }

    public String getCaracterísticas() {
        return "RAM: " + super.getiRam() + " gb. CPU: " + super.getsCpu() + ". Tipo de torre: " + this.sTipoTorre;
    }

    @Override
    public String toString() {
        return "OrdenadorSobremesa [iCodigo=" + super.getiCodigo() + ", iRam=" + super.getiRam() + ", sCpu="
                + super.getsCpu() + ", sTipoTorre=" + sTipoTorre + "]";
    }

}
