package institutoBruno;

public class PersonaBruno {
    String sNombre;
    int iEdad;
    String sAulaAsignada;
    
    public PersonaBruno (String paramNombre, int paramEdad, String paramAulaAsignada){ //Constructor clase Persona

        this.sNombre=paramNombre;
        this.iEdad=paramEdad;
        this.sAulaAsignada=paramAulaAsignada;
    }


    // Getters y Setters
    public String getsNombre() {
        return sNombre;
    }
 
    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public int getiEdad() {
        return iEdad;
    }

    public void setiEdad(int iEdad) {
        this.iEdad = iEdad;
    }

    public String getsAulaAsignada() {
        return sAulaAsignada;
    }

    public void setsAulaAsignada(String sAulaAsignada) {
        this.sAulaAsignada = sAulaAsignada;
    }

     @Override
    public String toString() { //
         return "Persona [sNombre=" + sNombre + ", iEdad=" + iEdad + ", sAulaAsignada=" + sAulaAsignada + "]";
    }


    

    
}
