package com.samochody.projekt_czapiewska_anna_wozniak_joanna.service;

import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarModel;
import com.samochody.projekt_czapiewska_anna_wozniak_joanna.repository.CarModelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelService {

    private final CarModelRepository carModelRepository;

    public CarModelService(CarModelRepository carModelRepository) {
        this.carModelRepository = carModelRepository;
    }

    // Pobierz wszystkie modele
    public List<CarModel> findAll() {
        return carModelRepository.findAll();
    }

    // Zapisz nowy model
    public CarModel save(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    // Usuń model po ID
    public void deleteById(Long id) {
        carModelRepository.deleteById(id);
    }
}
