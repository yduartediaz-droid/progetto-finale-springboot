package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.domanda.service.DomandaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domande")
public class DomandaController {

    private final DomandaService service;

    public DomandaController(DomandaService service) {
        this.service = service;
    }

    @GetMapping
    public List<DomandaEntity> getAll() {
        return service.getAll();
    }

    @PostMapping
    public DomandaEntity create(@RequestBody DomandaEntity domanda) {
        return service.create(domanda);
    }
}
