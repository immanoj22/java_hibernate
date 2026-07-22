package org.example.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "car_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "company")
    private String car_Company;

    @Column(name="modelNumber")
    private String car_model;

    @Column(name = "carNumber")
    private int car_number;

    @Column(name = "carDistrict")
    private String carDistrict;

    @ManyToOne(cascade = CascadeType.ALL)
    private  Persion persion;

    public Car(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarDistrict() {
        return carDistrict;
    }

    public void setCarDistrict(String carDistrict) {
        this.carDistrict = carDistrict;
    }

    public int getCar_number() {
        return car_number;
    }

    public void setCar_number(int car_number) {
        this.car_number = car_number;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_Company() {
        return car_Company;
    }

    public void setCar_Company(String car_Company) {
        this.car_Company = car_Company;
    }

    public Persion getPersion() {
        return persion;
    }

    public void setPersion(Persion persion) {
        this.persion = persion;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", car_Company='" + car_Company + '\'' +
                ", car_model='" + car_model + '\'' +
                ", car_number=" + car_number +
                ", carDistrict='" + carDistrict + '\'' +
                '}';
    }
}
