package com.example.ClinicaOdontologicaAilenAdid.Service.impl;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import com.example.ClinicaOdontologicaAilenAdid.Model.PacienteDto;
import com.example.ClinicaOdontologicaAilenAdid.Repository.IPacienteRepository;
import com.example.ClinicaOdontologicaAilenAdid.Service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearPaciente(Paciente paciente) throws BadRequestException {
        if(findByDni(paciente.getDni())==null){
            pacienteRepository.save(paciente);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public PacienteDto getPaciente(Long id) {
        PacienteDto pacienteDto = null;
        Paciente paciente = pacienteRepository.findById(id).get();
        if (paciente != null) {
            pacienteDto = mapper.convertValue(paciente, PacienteDto.class);
        }
        return pacienteDto;
    }

    @Override
    public void modificarPaciente(Paciente paciente) {
        pacienteRepository.save(paciente);
    }

    @Override
    public void eliminarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    @Override
    public Set<PacienteDto> getAll() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDto> pacientesDtos = new HashSet<>();
        for (Paciente paciente : pacientes) {
            pacientesDtos.add(mapper.convertValue(paciente, PacienteDto.class));
        }
        return pacientesDtos;
    }

    public Paciente findByDni(String dni) {
        Paciente pacienteFind = null;
        List<Paciente> pacientes = pacienteRepository.findAll();
        for (Paciente paciente : pacientes) {
            if (paciente.getDni().equals(dni)) {
                pacienteFind = paciente;
            }

        }     return pacienteFind;
    }


}

