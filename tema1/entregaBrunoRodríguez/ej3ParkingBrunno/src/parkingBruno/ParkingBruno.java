package parkingBruno;

public interface ParkingBruno {

    public boolean hayPlaza();

    public void aparcaCoche(VehiculoBruno vBruno);

    public void sacaCoche(VehiculoBruno vBruno);

    public double getFactura(VehiculoBruno vBruno) throws Exception;
    
}
