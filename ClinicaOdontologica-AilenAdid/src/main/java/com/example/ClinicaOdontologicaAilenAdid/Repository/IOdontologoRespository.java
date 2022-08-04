package com.example.ClinicaOdontologicaAilenAdid.Repository;

import com.example.ClinicaOdontologicaAilenAdid.Model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRespository extends JpaRepository<Odontologo, Long> {
}
