package com.example.ClinicaOdontologicaAilenAdid.Service.impl;


import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import com.example.ClinicaOdontologicaAilenAdid.Model.Turno;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.sql.Date;
import java.sql.Time;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@RunWith(SpringRunner.class)
public class IntegracionTurnosTest {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private OdontologoService odontologoService;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void cargarDataSet() throws BadRequestException {
        Domicilio domicilio = new Domicilio("Mansilla", "3231", "Maipu", "Mendoza");
        Paciente paciente = new Paciente("Josefina", "Rodriguez", "987587654365", "josero@gmail.com", new Date(2022-04-17), domicilio);
        Odontologo odontologo = new Odontologo("Roberto", "Gomez", 1560987654);
        Turno turno = new Turno(new Date(2022-03-17), new Time(17), odontologo, paciente);
        pacienteService.crearPaciente(paciente);
        odontologoService.crearOdontologo(odontologo);
        turnoService.crearTurno(turno);
    }
    @Test
    public void validarQueDevuelvaUnListadoDeTurnos() throws Exception {
        this.cargarDataSet();

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        Assert.assertFalse(response.getResponse().getContentAsString().isEmpty());

    }
}




