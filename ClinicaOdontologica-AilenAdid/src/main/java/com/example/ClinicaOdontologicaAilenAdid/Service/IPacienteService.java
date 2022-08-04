package com.example.ClinicaOdontologicaAilenAdid.Service;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import com.example.ClinicaOdontologicaAilenAdid.Model.PacienteDto;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Set;

public interface IPacienteService {

    void crearPaciente(Paciente paciente) throws BadRequestException;
    PacienteDto getPaciente(Long id);
    void modificarPaciente(Paciente paciente);
    void eliminarPaciente(Long id);
    Set<PacienteDto> getAll();

}
