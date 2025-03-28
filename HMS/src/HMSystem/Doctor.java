package HMSystem;

public class Doctor {
    private int id;
    private String name;
    private String speciality;
    private String contact;

    public Doctor(int id, String name, String speciality, String contact) {
        this.id = id;
        this.name = name;
        this.speciality = speciality;
        this.contact = contact;
    }

    public Doctor(String name, String speciality, String contact) {
        this.name = name;
        this.speciality = speciality;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Doctor [id=" + id + ", name=" + name + ", speciality=" + speciality + ", contact=" + contact + "]";
    }
}
