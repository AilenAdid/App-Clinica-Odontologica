package com.example.ClinicaOdontologicaAilenAdid.Model;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(generator = "turno_sequence", strategy = GenerationType.SEQUENCE)
    private Long Id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss")
    private Time hora;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    public Turno(Long id, Date fecha, Time hora, Odontologo odontologo, Paciente paciente) {
        Id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Turno(Date fecha, Time hora, Odontologo odontologo, Paciente paciente) {
        this.fecha = fecha;
        this.hora = hora;
        this.odontologo = odontologo;
        this.paciente = paciente;
    }

    public Turno() {
    }

    public Long getId() {
        return Id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
