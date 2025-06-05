package casestudy.model;

public class Trainer {
    private String id;
    private String name;
    private String specialty;
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Trainer() {
    }

    public Trainer(String id, String name, String specialty, String phone) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Trainer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
