package institutoBruno;

public class ProfesorBruno extends PersonaBruno {
    private String sMateria;

    public ProfesorBruno(String nombre, int edad, String sAulaAsignada, String sMateria) {
        super(nombre, edad, sAulaAsignada);
        this.sMateria = sMateria;
    }

    public String getMateria() {
        return sMateria;
    }

    public void setMateria(String paramMateria) {
        this.sMateria = paramMateria;
    }
}

