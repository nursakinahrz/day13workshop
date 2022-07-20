package sg.edu.nus.iss.day13workshop.models;

//unique number
import java.util.UUID;

public class Contact {
    private final String id;
    private String name;
    private String email;
    private String phone;

    //no argument constructor
    public Contact() {
        this.id = UUID.randomUUID().toString().substring(0, 8);
    }
    
    public Contact(String id) {
        this.id = id;
    }

    public String getID() { return this.id; 
    }
    //getter & setter is always public
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact [email=" + email + ", id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }

    
   
}
