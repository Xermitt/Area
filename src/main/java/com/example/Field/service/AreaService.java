package com.example.Field.service;

import com.example.Field.Area;
import com.example.Field.DTO.AreaCreateDto;
import com.example.Field.DTO.AreaDto;
import com.example.Field.DTO.AreaUpdateDto;
import com.example.Field.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Autowired
    private AreaValidationService areaValidationService;

    public AreaDto createArea(AreaCreateDto area){
        areaValidationService.validateCreateDto(area);
        Area area1 = Area.builder()
                .userId(area.getUserId())
                .title(area.getName())
                .soil_type(area.getSoilType())
                .sowing_date(Date.valueOf(area.getSowingDate()))
                .build();
        Area savedArea = areaRepository.save(area1);
        return mapToDto(savedArea);
    }

    public AreaDto mapToDto(Area area) {
        return AreaDto.builder()
                .id(area.getId())
                .userId(area.getUserId())
                .name(area.getTitle())
                .solidType(area.getSoil_type())
                .sowingDate(area.getSowing_date().toString())
                .build();
    }


    public void updateArea(AreaUpdateDto updateDto){
        areaValidationService.validateUpdateDto(updateDto);
        Optional<Area> areaOpt = areaRepository.findById(updateDto.getAreaId());
        if(areaOpt.isPresent()){
            Area area = areaOpt.get();
            area.setSoil_type(updateDto.getSolidType());
            area.setSowing_date(Date.valueOf(updateDto.getSowingDate()));
            areaRepository.save(area);
        } else
            throw new IllegalArgumentException("Area with id " + updateDto.getAreaId() + " not found");
    }

    public void deleteArea(Integer id){
        areaRepository.deleteById(id);
    }

    public AreaDto findAreaById(Integer id){
        Optional<Area> areaOpt = areaRepository.findById(id);
        if (areaOpt.isPresent()){
            return mapToDto(areaOpt.get());
        } else
            throw new IllegalArgumentException("Area with id " + id + " not found");
    }

    public Page<AreaDto> findAllAreas(Integer page, Integer size){
        Page<Area> areas = areaRepository.findAll(PageRequest.of(page, size));
        return areas.map(area -> mapToDto(area));
    }

    public List<AreaDto> findAllAreaByUser(Integer userId){
        List<Area> areas = areaRepository.findAllByUserId(userId);
        return areas.stream()
                .map(this::mapToDto).collect(Collectors.toList());
    }
}
