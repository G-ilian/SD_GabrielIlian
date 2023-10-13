package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.DTO.TotalCompradoPorFornecedor;
import br.inatel.labs.lab_jpa.repository.RelatorioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    @Autowired
    private RelatorioRepository repository;

    public List<TotalCompradoPorFornecedor> pesquisarTotalCompradoPorFornecedor() {
        return repository.pesquisarTotalCompradoPorFornecedor();
    }


}
