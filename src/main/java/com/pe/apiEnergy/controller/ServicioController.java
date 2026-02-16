package com.pe.apiEnergy.controller;

import com.pe.apiEnergy.dto.ServicioDTO;
import com.pe.apiEnergy.service.ServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ServicioController {

    private final ServicioService servicioService;

    @PostMapping
    public ServicioDTO guardar(@RequestBody ServicioDTO dto){
        return servicioService.guardar(dto);
    }

    @GetMapping
    public List<ServicioDTO> listar(){
        return servicioService.listar();
    }

    @GetMapping("/{id}")
    public ServicioDTO listarbyid(@PathVariable Long id){
        return servicioService.listarbyid(id);
    }


}
