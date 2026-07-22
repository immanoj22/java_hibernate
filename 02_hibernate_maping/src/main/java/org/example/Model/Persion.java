package org.example.Model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "persion")
public class Persion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "persionId")
    private int persionId;

    @Column(name = "persionName")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "persion_id")
    private Set<Car> cars;

    public int getPersionId() {
        return persionId;
    }

    public void setPersionId(int persionId) {
        this.persionId = persionId;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "persionId=" + persionId +
                ", name='" + name + '\'' +
                '}';
    }
}
