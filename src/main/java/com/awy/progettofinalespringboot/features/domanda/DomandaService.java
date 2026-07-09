package com.awy.progettofinalespringboot.features.domanda;

import com.awy.progettofinalespringboot.features.domanda.DomandaEntity;
import com.awy.progettofinalespringboot.features.domanda.repository.DomandaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomandaServiceImpl implements DomandaService {

    private final DomandaRepository repository;

    public DomandaServiceImpl(DomandaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomandaEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public DomandaEntity create(DomandaEntity domanda) {
        return repository.save(domanda);
    }
}
