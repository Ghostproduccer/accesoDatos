package act2Agenda;

public class ContactoBruno implements Comparable<ContactoBruno> {
    private String name;
    private String phone;

    public ContactoBruno(String name, String phone) {
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
    public int compareTo(ContactoBruno other) {
        return name.compareTo(other.name);
    }
}
