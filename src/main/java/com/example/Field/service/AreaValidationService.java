package com.example.Field.service;

import com.example.Field.DTO.AreaCreateDto;
import com.example.Field.DTO.AreaUpdateDto;
import com.example.Field.repository.AreaRepository;
import org.springframework.stereotype.Service;

@Service
public class AreaValidationService {
    private AreaRepository areaRepository;
    private String type;
    void validateCreateDto(AreaCreateDto create){
        //проверка на существование области с таким именем
        if (areaRepository.existsByName(create.getName())){
            throw new IllegalArgumentException("Area with name " + create.getName() + " already exists");
        }
        if (!areaRepository.existBySoilType(create.getSoilType())){
            throw new IllegalArgumentException("We dont have areas with type " + create.getSoilType());
        }
    }
    void validateUpdateDto(AreaUpdateDto update){
        if (!areaRepository.existsById(update.getAreaId())){
            throw new IllegalArgumentException("Area with id " + update.getAreaId() + " does not exist");
        }
    }
}
