package tiendapc;

public class OrdenadorTestBruno {
    public static void main(String[] args) throws Exception {

        // creamos un objeto Portatil y un objeto sobremesa
        OrdenadorPortatil portatil1 = new OrdenadorPortatil(8, "Intel Core i5", 3);
        OrdenadorSobremesa sobremesa1 = new OrdenadorSobremesa(16, "Intel Core i7", "Torre con luces RGB");

        // vemos sus características
        String sPortatil1 = portatil1.toString();
        String sSobremesa1 = sobremesa1.toString();
        System.out.println(sPortatil1 + " " + sSobremesa1);
    }
}
