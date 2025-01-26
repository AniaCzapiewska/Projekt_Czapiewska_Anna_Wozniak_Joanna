package com.samochody.projekt_czapiewska_anna_wozniak_joanna.model;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarBrand;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.service.CarBrandService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private final CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;

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


    // Zapisz nową markę
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute CarBrand carBrand, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Jeśli występują błędy walidacji, wróć do formularza z komunikatami błędów
            model.addAttribute("CarBrand", carBrand);
            return "carbrands/form";
        }
        carBrandService.save(carBrand);
        return "redirect:/carbrands";  // Przekierowanie po zapisaniu

    public CarBrand getCarBrand() {

    }

    public void setCarBrand(CarBrand carBrand) {
        this.carBrand = carBrand;
    }
}
