package com.example.ClinicaOdontologicaAilenAdid.Repository;

import com.example.ClinicaOdontologicaAilenAdid.Model.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio, Long> {
}
