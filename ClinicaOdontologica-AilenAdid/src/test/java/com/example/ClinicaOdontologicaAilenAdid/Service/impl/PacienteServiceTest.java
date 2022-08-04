package com.example.ClinicaOdontologicaAilenAdid.Service.impl;

import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import com.example.ClinicaOdontologicaAilenAdid.Model.PacienteDto;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    PacienteService pacienteService;

    @Test
    public void crearPaciente() throws BadRequestException{
        Domicilio domicilio = new Domicilio("Juan b justo", "15", "Mendoza", "Mendoza" );
        Paciente paciente = new Paciente("Pedro", "Adid", "8567392", "juancito@yahoo.com", new Date(2022-03-27), domicilio);

        pacienteService.crearPaciente(paciente);
        Set<PacienteDto> pacientes = pacienteService.getAll();
        Assert.assertNotNull(pacientes.size());
    }
}
