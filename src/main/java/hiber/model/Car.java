package hiber.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GenericGenerator(name="123" , strategy="increment")
    @GeneratedValue(generator="123")
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "car")
    private User user;

    private String name;
    private int series;

    public Car() {
    }

    public Car(String name, int series) {
        this.name = name;
        this.series = series;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
