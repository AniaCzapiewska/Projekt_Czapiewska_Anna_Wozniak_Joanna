package com.samochody.projekt_czapiewska_anna_wozniak_joanna.controller;

import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarModel;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.service.CarModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carmodels")
public class CarModelController {

    private final CarModelService carModelService;

    public CarModelController(CarModelService carModelService) {
        this.carModelService = carModelService;
    }

    // Pobierz listę wszystkich modeli
    @GetMapping
    public String listCarModels(Model model) {
        model.addAttribute("carmodels", carModelService.findAll());
        return "carmodels/list";  // Ścieżka do widoku listy
    }

    // Formularz do tworzenia nowego modelu
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("CarModel", new CarModel());
        return "carmodels/form";  // Ścieżka do formularza
    }

    // Zapisz nowy model
    @PostMapping("/save")
    public String save(@ModelAttribute CarModel carModel) {
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
