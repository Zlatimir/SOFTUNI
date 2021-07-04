package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product extends BaseEntity{

    private String name;
    private Double quantity;
    private BigDecimal price;
    private Set<Sale> sale;

    public Product() {
        this.sale = new HashSet<>();
    }

    @Column(name = "name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "quantity")
    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    // Will create Sale when persisting Product         Will delete Sale when deleting Product
    public Set<Sale> getSale() {
        return sale;
    }

    public void setSale(Set<Sale> sale) {
        this.sale = sale;
    }
}
