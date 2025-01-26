package com.samochody.projekt_czapiewska_anna_wozniak_joanna.service;

import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarBrand;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.repository.CarBrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandService {

    private final CarBrandRepository carBrandRepository;

    public CarBrandService(CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    // Pobierz wszystkie marki
    public List<CarBrand> findAll() {
        return carBrandRepository.findAll();
    }

    // Zapisz nową markę
    public CarBrand save(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }

    // Usuń markę po ID
    public void deleteById(Long id) {
        carBrandRepository.deleteById(id);
    }
}