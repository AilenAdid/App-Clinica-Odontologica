package com.example.ClinicaOdontologicaAilenAdid.Service.impl;


import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    OdontologoService odontologoService;

    @Test
    public void crearOdontologo() throws BadRequestException {
        Odontologo odontologo = new Odontologo("Juan", "Perez", 675763);
        odontologoService.crearOdontologo(odontologo);
        Assert.assertNotNull(odontologoService.getAll());
    }
}
