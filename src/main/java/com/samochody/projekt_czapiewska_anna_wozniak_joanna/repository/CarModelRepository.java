package com.samochody.projekt_czapiewska_anna_wozniak_joanna.repository;

import com.samochody.projekt_czapiewska_anna_wozniak_joanna.model.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {
}
