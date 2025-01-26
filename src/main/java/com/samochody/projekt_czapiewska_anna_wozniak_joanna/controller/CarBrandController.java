package com.samochody.projekt_czapiewska_anna_wozniak_joanna.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{carmodel.name.notblank}")
    @Size(min = 1, max = 25, message = "{carmodel.name.size}")
    private String name;

    private Integer car_year;

    @NotNull(message = "{carmodel.carbrand.notnull}")
    @ManyToOne
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    // Konstruktor bezargumentowy
    public CarModel() {
    }

    // Gettery i Settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getcar_yearr() {
        return car_year;
    }

    public void setcar_year(Integer car_year) {
        this.car_year = car_year;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }
}
