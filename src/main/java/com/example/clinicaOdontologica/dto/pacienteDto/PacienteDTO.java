package com.example.clinicaOdontologica.dto.pacienteDto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PacienteDTO {

    private String apellido;
    private String nombre;
    private String direccion;

    public PacienteDTO(){}

    public void setDireccion(String calle, int numero) {
        this.direccion = calle+" "+String.valueOf(numero);
    }


    @Override
    public String toString() {
        return "PacienteDTO{" +
                "apellido='" + apellido + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
