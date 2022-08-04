package com.example.ClinicaOdontologicaAilenAdid.Repository;

import com.example.ClinicaOdontologicaAilenAdid.Model.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITurnoRepository extends JpaRepository<Turno, Long> {
}
