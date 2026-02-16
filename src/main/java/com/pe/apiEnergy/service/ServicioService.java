package com.pe.apiEnergy.service;

import com.pe.apiEnergy.dto.ServicioDTO;

import java.util.List;

public interface ServicioService {
    ServicioDTO guardar (ServicioDTO dto);

    List<ServicioDTO> listar();

    ServicioDTO listarbyid(Long id);
}
