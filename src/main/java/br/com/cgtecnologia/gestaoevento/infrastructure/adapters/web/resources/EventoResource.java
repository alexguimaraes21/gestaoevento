package br.com.cgtecnologia.gestaoevento.infrastructure.adapters.web.resources;

import br.com.cgtecnologia.gestaoevento.application.dtos.in.EventoDtoIn;
import br.com.cgtecnologia.gestaoevento.application.dtos.out.EventoDtoOut;
import br.com.cgtecnologia.gestaoevento.application.mappers.EventoDtoMapper;
import br.com.cgtecnologia.gestaoevento.core.entities.EventoCoreEntity;
import br.com.cgtecnologia.gestaoevento.core.ports.in.IEventoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventoResource {

    private final IEventoService eventoService;

    public EventoResource(IEventoService eventoService) {
        this.eventoService = eventoService;
    }

    @GetMapping(value = "/v1/evento", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findEventoById(@RequestParam(value = "eventoId", required = false) Long eventoId) {

        if (eventoId != null) {
            Optional<EventoCoreEntity> eventoCore = eventoService.getById(eventoId);
            return eventoCore.map(eventoCoreEntity -> ResponseEntity.ok(new EventoDtoOut(eventoCoreEntity))).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            List<EventoCoreEntity> eventosCore = eventoService.getAll();
            if (!eventosCore.isEmpty()) {
                List<EventoDtoOut> eventosDto = new ArrayList<>();
                eventosCore.forEach(evento -> eventosDto.add(new EventoDtoOut(evento)));
                return ResponseEntity.ok(eventosDto);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/v1/evento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EventoDtoOut>  createEvento(@RequestBody EventoDtoIn eventoDtoIn) {
        EventoCoreEntity eventoCore = this.eventoService.save(EventoDtoMapper.toCoreEntity(eventoDtoIn));
        return new ResponseEntity<>(new EventoDtoOut(eventoCore), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/v1/evento")
    public ResponseEntity<?> deleteEventoById(@RequestParam(value = "eventoId", required = false) Long eventoId) {
        if (eventoId != null) {
            eventoService.deleteById(eventoId);
        }
        return ResponseEntity.noContent().build();
    }
}
