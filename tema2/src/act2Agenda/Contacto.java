package act2Agenda;

public class Contacto implements Comparable<Contacto> {
    private String name;
    private String phone;

    public Contacto(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public int compareTo(Contacto other) {
        return name.compareTo(other.name);
    }
}
