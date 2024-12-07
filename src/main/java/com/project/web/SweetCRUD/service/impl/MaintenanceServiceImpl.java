package com.project.web.SweetCRUD.service.impl;

import com.project.web.SweetCRUD.dto.DessertsDto;
import com.project.web.SweetCRUD.entity.Desserts;
import com.project.web.SweetCRUD.repository.DessertsRepository;
import com.project.web.SweetCRUD.service.MaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MaintenanceServiceImpl implements MaintenanceService {

    @Autowired
    DessertsRepository dessertsRepository;

    @Override
    public List<DessertsDto> findAllDesserts() {

        List<DessertsDto> dessertss = new ArrayList<DessertsDto>();
        Iterable<Desserts> iterable = dessertsRepository.findAll();
        iterable.forEach(desserts -> {
            DessertsDto dessertsDto = new DessertsDto(
                    desserts.getIdDessert(),
                    desserts.getDessertName(),
                    desserts.getDescription(),
                    desserts.getPrice());
            dessertss.add(dessertsDto);
        });
        return dessertss;
    }
}
