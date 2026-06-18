package com.azahartech.eventdev.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EventoTest {

    @Test
    void estaLleno_DebeDevolverFalse_CuandoHayPlazasDisponibles() {
        // Arrange
        Recinto recintoPrincipal = new Recinto("Wizink Center", "Av. Felipe II, Madrid", 100);
        Evento evento = new Evento("Gran Festival Rock", LocalDate.now().plusMonths(1), 45.0, recintoPrincipal, 50); // Aforo 100, inscritos 50
        // Act & Assert
        assertFalse(evento.estaLleno(), "El evento no debería estar lleno");
    }

    @Test //aforo 100 inscritos 100
    void estaLleno_DebeDevolverTrue_CuandoLosInscritosIgualanElAforo() {
// Arrange
        Recinto recintoPrincipal = new Recinto("Wizink Center", "Av. Felipe II, Madrid", 100);
        Evento evento = new Evento("Gran Festival Rock", LocalDate.now().plusMonths(1), 45.0, recintoPrincipal, 100); // Aforo 100, inscritos 50
        // Act & Assert
        assertFalse(evento.estaLleno(), "El evento no debería estar lleno");
    }

    @Test //aforo 100 inscritos 101
    void estaLleno_DebeDevolverTrue_CuandoHayMasInscritosQueAforo() {
        // Arrange
        Recinto recintoPrincipal = new Recinto("Wizink Center", "Av. Felipe II, Madrid", 100);
        Evento evento = new Evento("Gran Festival Rock", LocalDate.now().plusMonths(1), 45.0, recintoPrincipal, 101); // Aforo 100, inscritos 50
        // Act & Assert
        assertFalse(evento.estaLleno(), "El evento no debería estar lleno");
    }

    //terminado
}