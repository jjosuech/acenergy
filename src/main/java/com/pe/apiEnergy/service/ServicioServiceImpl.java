package com.pe.apiEnergy.service;

import com.pe.apiEnergy.dto.ServicioDTO;
import com.pe.apiEnergy.model.Servicio;
import com.pe.apiEnergy.repository.ServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository repository;

    @Override
    public ServicioDTO guardar(ServicioDTO dto) {

        Servicio servicio = Servicio.builder()
                .nombre(dto.getNombre())
                .descripcion(dto.getDescripcion())
                .activo(true)
                .build();

        Servicio guardado = repository.save(servicio);

        return ServicioDTO.builder()
                .id(guardado.getId())
                .nombre(guardado.getNombre())
                .descripcion(guardado.getDescripcion())
                .activo(guardado.getActivo())
                .build();
    }

    @Override
    public List<ServicioDTO> listar() {

        return repository.findAll()
                .stream()
                .map(servicio -> ServicioDTO.builder()
                        .id(servicio.getId())
                        .nombre(servicio.getNombre())
                        .descripcion(servicio.getDescripcion())
                        .activo(servicio.getActivo())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public ServicioDTO listarbyid(Long id) {

        Servicio servicio = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        return mapToDTO(servicio);
    }

    private ServicioDTO mapToDTO(Servicio servicio) {
        return ServicioDTO.builder()
                .id(servicio.getId())
                .nombre(servicio.getNombre())
                .descripcion(servicio.getDescripcion())
                .activo(servicio.getActivo())
                .build();
    }
}