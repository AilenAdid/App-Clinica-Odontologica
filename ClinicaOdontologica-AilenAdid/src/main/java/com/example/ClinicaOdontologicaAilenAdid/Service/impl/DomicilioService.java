package com.example.ClinicaOdontologicaAilenAdid.Service.impl;

import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import com.example.ClinicaOdontologicaAilenAdid.Model.DomicilioDto;
import com.example.ClinicaOdontologicaAilenAdid.Repository.IDomicilioRepository;
import com.example.ClinicaOdontologicaAilenAdid.Service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    private IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public DomicilioDto getDomicilio(Long id) {
        DomicilioDto domicilioDto = null;
        Domicilio domicilio = domicilioRepository.findById(id).get();
        if (domicilio != null) {
            domicilioDto = mapper.convertValue(domicilio, DomicilioDto.class);
        }
        return domicilioDto;
    }

    @Override
    public void modificarDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Set<DomicilioDto> getAll() {
        List<Domicilio> domicilios = domicilioRepository.findAll();
        Set<DomicilioDto> domiciliosDto = new HashSet<>();
        for (Domicilio domicilio : domicilios) {
            domiciliosDto.add(mapper.convertValue(domicilio, DomicilioDto.class));
        }
        return domiciliosDto;
    }
}
