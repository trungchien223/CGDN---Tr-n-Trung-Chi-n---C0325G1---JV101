package casestudy.model;

public class Trainer extends Person{
    private String specialty;
    private int age;
    private int experience;

    public Trainer() {
    }

    public Trainer(String id, String name, String specialty, String phone, int age, String gender, int experience) {
        super(id, name, phone, gender);
        this.specialty = specialty;
        this.age = age;
        this.experience = experience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Trainer{" + super.toString() +
                ", specialty='" + specialty + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                '}';
    }
}
