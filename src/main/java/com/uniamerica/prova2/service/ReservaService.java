package com.uniamerica.prova2.service;

import com.uniamerica.prova2.enums.ReservaEstado;
import com.uniamerica.prova2.model.Reserva;
import com.uniamerica.prova2.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva store(Reserva reserva) {
        List<Reserva> available = reservaRepository.searchByDate(reserva.getCarro(),reserva.getData_retirada(), reserva.getData_devolucao());

        if (available.isEmpty()) {
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public Optional<Reserva> show(long id) {
        return reservaRepository.findById(id);
    }

    public Reserva finalize(long id) {
        Optional<Reserva> reserva = show(id);

        if (reserva.isPresent()) {
            reserva.setEstado(ReservaEstado.finalizado);
            return reservaRepository.save(reserva);
        } else {
            return null;
        }
    }

    public Reserva start(long id) {
        Optional<Reserva> reserva = show(id);

        if (reserva.isPresent()) {
            reserva.setEstado(ReservaEstado.em_andamento);
            return reservaRepository.save(reserva);
        } else {
            return null;
        }
    }
}
