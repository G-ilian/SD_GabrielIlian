package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.entity.Endereco;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EnderecoService {
    @PersistenceContext
    private EntityManager em;

    public Endereco salvar (Endereco end){
        return em.merge(end);
    }
}
