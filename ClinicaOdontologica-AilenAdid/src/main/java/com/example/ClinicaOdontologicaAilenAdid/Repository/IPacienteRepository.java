package com.example.ClinicaOdontologicaAilenAdid.Repository;

import com.example.ClinicaOdontologicaAilenAdid.Model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente, Long> {
}
