package com.samochody.projekt_czapiewska_anna_wozniak_joanna.controller;

import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarBrand;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarModel;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.service.CarBrandService;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.service.CarModelService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carmodels")
public class CarModelController {

    private final CarModelService carModelService;
    private final CarBrandService carBrandService;

    public CarModelController(CarModelService carModelService, CarBrandService carBrandService) {
        this.carModelService = carModelService;
        this.carBrandService = carBrandService;
    }

    // Pobierz listę wszystkich modeli
    @GetMapping
    public String listCarModels(Model model) {
        model.addAttribute("carModels", carModelService.findAll());
        return "carmodels/list";  // Ścieżka do widoku listy
    }

    // Formularz do tworzenia nowego modelu
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("carModel", new CarModel());
        model.addAttribute("carBrands", carBrandService.findAll());
        model.addAttribute("brand", new CarBrand());
        return "carmodels/form";  // Ścieżka do formularza
    }

    // Zapisz nowy model
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute CarModel carModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            // Jeśli występują błędy walidacji, wróć do formularza z komunikatami błędów
            model.addAttribute("CarModel", carModel);
            return "carmodels/form";
        }
        carModelService.save(carModel);
        return "redirect:/carmodels";  // Przekierowanie po zapisaniu
    }

    // Usuń model po ID
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        carModelService.deleteById(id);
        return "redirect:/carmodels";  // Przekierowanie po usunięciu
    }
}
