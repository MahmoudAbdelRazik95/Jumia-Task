package jumia.models;

import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String phone;

    @Transient
    private String country;

    @Transient
    private String state;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() { return country; }

    public String getState() { return state; }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setState(String state) { this.state = state; }

    public void setName(String name) { this.name = name; }

    public void setPhone(String phone) { this.phone = phone; }
}
