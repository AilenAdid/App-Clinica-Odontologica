package com.example.ClinicaOdontologicaAilenAdid.Service.impl;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import com.example.ClinicaOdontologicaAilenAdid.Model.Turno;
import com.example.ClinicaOdontologicaAilenAdid.Model.TurnoDto;
import com.example.ClinicaOdontologicaAilenAdid.Repository.ITurnoRepository;
import com.example.ClinicaOdontologicaAilenAdid.Service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearTurno(Turno turno) throws BadRequestException {
        if(findTurno(turno.getOdontologo(),turno.getPaciente())==null){
            turnoRepository.save(turno);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public TurnoDto getTurno(Long id) {
        TurnoDto turnoDto = null;
        Turno turno = turnoRepository.findById(id).get();
        if(turno != null){
            turnoDto = mapper.convertValue(turno, TurnoDto.class);
        }
        return turnoDto;
    }

    @Override
    public void modificarTurno(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public void eliminarTurno(Long id) {
        turnoRepository.deleteById(id);
    }

    @Override
    public Set<TurnoDto> getAll() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDto> turnosDto = new HashSet<>();
        for (Turno turno : turnos){
            turnosDto.add(mapper.convertValue(turno, TurnoDto.class));
        }
        return turnosDto;
    }

    public Turno findTurno(Odontologo odontologo, Paciente paciente){
        Turno turno = null;
        List<Turno> turnos = turnoRepository.findAll();
        for (Turno turnoList : turnos){
            if(turnoList.getOdontologo().getId()==odontologo.getId() &&turnoList.getPaciente().getId() == paciente.getId()){
                turno = turnoList;
            }
        }
        return turno;
    }


}
