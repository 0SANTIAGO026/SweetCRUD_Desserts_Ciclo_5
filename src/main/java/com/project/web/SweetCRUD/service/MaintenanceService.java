package com.project.web.SweetCRUD.service;

import com.project.web.SweetCRUD.dto.DessertsDto;

import java.util.List;

public interface MaintenanceService {

    List<DessertsDto> findAllDesserts();

}
