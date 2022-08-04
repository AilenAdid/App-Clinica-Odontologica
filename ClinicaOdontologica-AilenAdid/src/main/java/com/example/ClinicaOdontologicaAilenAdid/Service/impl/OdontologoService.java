package com.example.ClinicaOdontologicaAilenAdid.Service.impl;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Exceptions.GlobarExceptionHandler;
import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import com.example.ClinicaOdontologicaAilenAdid.Model.DomicilioDto;
import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import com.example.ClinicaOdontologicaAilenAdid.Model.OdontologoDto;
import com.example.ClinicaOdontologicaAilenAdid.Repository.IOdontologoRespository;
import com.example.ClinicaOdontologicaAilenAdid.Service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {

    private static final Logger logger = Logger.getLogger(GlobarExceptionHandler.class);

    @Autowired
    private IOdontologoRespository odontologoRespository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(Odontologo odontologo) throws BadRequestException {

        if (findByMatricula(odontologo.getMatricula()) == null) {
            odontologoRespository.save(odontologo);
        } else {
            throw new BadRequestException("");
        }
    }

    @Override
    public OdontologoDto getOdontologo(Long id) {
        OdontologoDto odontologoDto = null;
        Odontologo odontologo = odontologoRespository.findById(id).get();
        if(odontologo != null){
            odontologoDto = mapper.convertValue(odontologo, OdontologoDto.class);
        }
        return odontologoDto;

    }

    @Override
    public void modificarOdontologo(Odontologo odontologo) {
    odontologoRespository.save(odontologo);
    }

    @Override
    public void eliminarOdontologo(Long id) {
    odontologoRespository.deleteById(id);
    }

    @Override
    public Set<OdontologoDto> getAll() {
        List<Odontologo> odontologos = odontologoRespository.findAll();
        Set<OdontologoDto> odontologosDto = new HashSet<>();
        for(Odontologo odontologo : odontologos){
            odontologosDto.add(mapper.convertValue(odontologo, OdontologoDto.class));
        }
        return odontologosDto;
    }

    public Odontologo findByMatricula(Integer mat){
        Odontologo odontologoFind = null;
        List<Odontologo> odontologos = odontologoRespository.findAll();
        for(Odontologo odontologo : odontologos){
            if(odontologo.getMatricula().equals(mat)){
                odontologoFind = odontologo;
            }
        }
        return odontologoFind;
    }

}
