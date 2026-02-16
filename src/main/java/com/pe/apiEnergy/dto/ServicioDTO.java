package com.pe.apiEnergy.dto;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioDTO {

    private long id;
    private String nombre;
    private String descripcion;
    private Boolean activo;

}