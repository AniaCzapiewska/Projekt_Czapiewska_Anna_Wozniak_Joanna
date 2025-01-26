package com.samochody.projekt_czapiewska_anna_wozniak_joanna.controller;

import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarBrand;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.service.CarBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carbrands")
public class CarBrandController {
    private final CarBrandService carBrandService;

    public CarBrandController(CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    // Pobierz listę wszystkich marek
    @GetMapping
    public String listCarBrands(Model model) {
        model.addAttribute("carBrands", carBrandService.findAll());
        return "carbrands/list";  // Ścieżka do widoku listy
    }

    // Formularz do tworzenia nowej marki
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("carBrand", new CarBrand());
        return "carbrands/form";  // Ścieżka do formularza
    }

    // Zapisz nową markę
    @PostMapping("/save")
    public String save(@ModelAttribute CarBrand carBrand) {
        carBrandService.save(carBrand);
        return "redirect:/carbrands";  // Przekierowanie po zapisaniu
    }

    // Usuń markę po ID
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carBrandService.deleteById(id);
        return "redirect:/carbrands";  // Przekierowanie po usunięciu
    }
}
