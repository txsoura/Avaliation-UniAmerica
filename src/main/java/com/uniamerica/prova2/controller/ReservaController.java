package com.uniamerica.prova2.controller;

import com.uniamerica.prova2.model.Reserva;
import com.uniamerica.prova2.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("reservas")
public class ReservaController {
    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> store(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.store(reserva));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> start(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.start(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> finalized(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.finalize(id));
    }
}
