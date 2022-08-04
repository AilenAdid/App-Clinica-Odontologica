package com.example.ClinicaOdontologicaAilenAdid.Service;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import com.example.ClinicaOdontologicaAilenAdid.Model.DomicilioDto;
import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import com.example.ClinicaOdontologicaAilenAdid.Model.OdontologoDto;

import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(Odontologo odontologo) throws BadRequestException;
    OdontologoDto getOdontologo(Long id);
    void modificarOdontologo(Odontologo odontologo);
    void eliminarOdontologo(Long id);
    Set<OdontologoDto> getAll();
}
