package com.example.clinicaOdontologica.dto.clinicaDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class TurnoDTO {

    private Long pacienteId;
    private Long odontologoId;
    private Date fecha;

    public TurnoDTO(){}

    @Override
    public String toString() {
        return "TurnoDTO{" +
                "pacienteID=" + pacienteId +
                ", odontologoID=" + odontologoId +
                ", fecha=" + fecha +
                '}';
    }
}
