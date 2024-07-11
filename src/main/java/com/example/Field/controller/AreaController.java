package com.example.Field.controller;

import com.example.Field.DTO.AreaCreateDto;
import com.example.Field.DTO.AreaDto;
import com.example.Field.DTO.AreaUpdateDto;
import com.example.Field.service.AreaService;
import com.example.Field.service.AreaValidationService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/areas")
public class AreaController {
    private final AreaService areaService;
    private final AreaValidationService areaValidationService;
    @Autowired
    public AreaController(AreaService areaService, AreaValidationService areaValidationService) {
          this.areaService = areaService;
          this.areaValidationService = areaValidationService;
    }

    @PostMapping
    public AreaDto createArea(@RequestBody AreaCreateDto area) {
        return areaService.createArea(area);
    }

    @PutMapping("/{id}")
    public void updateArea(@PathVariable Integer id, @RequestBody AreaUpdateDto area) {
        area.setAreaId(id);
        areaService.updateArea(area);
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable Integer id) {
        areaService.deleteArea(id);
    }

    @GetMapping("/{id}")
    public AreaDto findAreaById(@PathVariable Integer id) {
        return areaService.findAreaById(id);
    }

    @GetMapping
    public Page<AreaDto> findAllAreas(@RequestParam Integer page, @RequestParam Integer size) {
        return areaService.findAllAreas(page, size);
    }

    @GetMapping("/users/{id}")
    public List<AreaDto> getAllAreasByUserId(@PathVariable Integer id) {
        return areaService.findAllAreaByUser(id);
    }



}
