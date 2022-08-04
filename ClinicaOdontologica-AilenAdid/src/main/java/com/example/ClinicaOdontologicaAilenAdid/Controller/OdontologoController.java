package com.example.ClinicaOdontologicaAilenAdid.Controller;


import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import com.example.ClinicaOdontologicaAilenAdid.Model.OdontologoDto;
import com.example.ClinicaOdontologicaAilenAdid.Service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;
import java.util.Collection;


@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    private static final Logger logger = Logger.getLogger(OdontologoController.class);

    @Autowired
    OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDto> getOdontologo(@PathVariable Long id) throws ResourceNotFoundException {
        try{
            return ResponseEntity.ok().body(
                    odontologoService.getOdontologo(id));
        }catch (Exception ex){
            throw new ResourceNotFoundException("El odontologo con id " + id + " no existe.");
        }
    }

    @PostMapping
    public ResponseEntity<Odontologo> crearOdontologo(@RequestBody Odontologo odontologo) throws BadRequestException {
        try{
            odontologoService.crearOdontologo(odontologo);
            logger.info("El odontologo fue creado con exito");
            return ResponseEntity.status(HttpStatus.CREATED).body(odontologo);
        } catch (Exception ex) {
            logger.error("El odontologo que intenta crear ya existe o es invalido");
            throw new BadRequestException("El odontologo que intenta crear ya existe o es invalido");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {
        ResponseEntity response;
        try {
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.ok(HttpStatus.OK);
            logger.info("El odontologo " + id + " ha sido eliminado con exito");
        } catch (Exception ex) {
            response = ResponseEntity.internalServerError().body(ex.getMessage());
            logger.info("El odontologo con id " + id + " no existe.");
        }
        return response;
    }

        @PutMapping
        public ResponseEntity<Odontologo> modificarOdontologo(@RequestBody Odontologo odontologo){
            odontologoService.modificarOdontologo(odontologo);
            logger.info("El odontologo ha sido modificado con exito");
            return ResponseEntity.ok().body(odontologo);
        }
        @GetMapping
        public Collection<OdontologoDto> getAll(){
            return odontologoService.getAll();
        }
    }

