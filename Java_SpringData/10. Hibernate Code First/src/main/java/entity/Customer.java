package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity{

    private String name;
    private String email;
    private String creditCardNumber;
    private Set<Sale> sale;

    @OneToMany(mappedBy = "customer")
    public Set<Sale> getSale() {
        return sale;
    }

    public void setSale(Set<Sale> sale) {
        this.sale = sale;
    }


    public Customer() {
        this.sale = new HashSet<>();
    }
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name = "credit_card_number")
    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
