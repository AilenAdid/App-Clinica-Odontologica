package com.example.ClinicaOdontologicaAilenAdid.Controller;


import com.example.ClinicaOdontologicaAilenAdid.Exceptions.BadRequestException;
import com.example.ClinicaOdontologicaAilenAdid.Exceptions.ResourceNotFoundException;
import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import com.example.ClinicaOdontologicaAilenAdid.Model.PacienteDto;
import com.example.ClinicaOdontologicaAilenAdid.Service.impl.PacienteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

private static final Logger logger = Logger.getLogger(PacienteController.class);

@Autowired
PacienteService pacienteService;

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> getPaciente(@PathVariable Long id) throws ResourceNotFoundException{
       try{
           return ResponseEntity.ok().body(
                   pacienteService.getPaciente(id));
       }catch (Exception ex){
           throw new ResourceNotFoundException("El paciente con id: " + id + " no existe.");
       }
    }

@PostMapping
public ResponseEntity<Paciente> crearPacient(@RequestBody Paciente paciente) throws BadRequestException {
    try{
        pacienteService.crearPaciente(paciente);
        logger.info("El paciente ha sido creado con exito");
        return ResponseEntity.status(HttpStatus.CREATED).body(paciente);
    } catch (Exception ex){
        logger.error("El paciente que intenta crear ya existe o es invalido");
        throw new BadRequestException("El paciente que intenta crear ya existe o es invalido");
    }
}

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {
        ResponseEntity response;
        try {
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.ok(HttpStatus.OK);
            logger.info("El paciente ha sido eliminado con exito.");
        } catch (Exception e) {
            response = ResponseEntity.internalServerError().body(e.getMessage());
            logger.info("El paciente con id "+id+" no existe.");
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Paciente> modificarPaciente(@RequestBody Paciente paciente){
        pacienteService.modificarPaciente(paciente);
        logger.info("El paciente ha sido modificado con exito.");
        return ResponseEntity.ok().body(paciente);
    }
    @GetMapping
    public Collection<PacienteDto> getAll(){
    return pacienteService.getAll();
    }


}
