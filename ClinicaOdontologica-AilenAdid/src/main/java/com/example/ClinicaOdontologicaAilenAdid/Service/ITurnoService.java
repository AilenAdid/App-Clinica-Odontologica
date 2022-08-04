package com.example.ClinicaOdontologicaAilenAdid.Service;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Turno;
import com.example.ClinicaOdontologicaAilenAdid.Model.TurnoDto;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Set;

public interface ITurnoService {

    void crearTurno(Turno turno) throws BadRequestException;
    TurnoDto getTurno(Long id);
    void modificarTurno(Turno turno);
    void eliminarTurno(Long id);
    Set<TurnoDto> getAll();
}
