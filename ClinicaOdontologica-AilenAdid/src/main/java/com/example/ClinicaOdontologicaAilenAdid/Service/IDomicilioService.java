package com.example.ClinicaOdontologicaAilenAdid.Service;

import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import com.example.ClinicaOdontologicaAilenAdid.Model.DomicilioDto;

import java.util.Set;

public interface IDomicilioService {

    void crearDomicilio(Domicilio domicilio);
    DomicilioDto getDomicilio(Long id);
    void modificarDomicilio(Domicilio domicilio);
    void eliminarDomicilio(Long id);
    Set<DomicilioDto> getAll();

}
