package HMSystem;

public class Staff {
    private int id;
    private String name;
    private String role;
    private String contactNumber;

    public Staff(int id, String name, String role, String contactNumber) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.contactNumber = contactNumber;
    }

    public Staff(String name, String role, String contactNumber) {
        this.name = name;
        this.role = role;
        this.contactNumber = contactNumber;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return "Staff [id=" + id + ", name=" + name + ", role=" + role + ", contactNumber=" + contactNumber + "]";
    }
}
