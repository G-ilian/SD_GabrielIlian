package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.entity.Fornecedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FornecedorService {
    @PersistenceContext
    private EntityManager em;

    // Métodos
    public Fornecedor salvarFornecedor(Fornecedor f) {
        f = em.merge( f );
        return f;
    }

    public Fornecedor buscarPeloId(Long id) {
        Fornecedor fornecedor = em.find(Fornecedor.class, id);
        return fornecedor;
    }

    public List<Fornecedor> listarFornecedores() {
        List <Fornecedor> listaFornecedor = em.createQuery("select p from Produto p", Fornecedor.class)
                .getResultList();
        return listaFornecedor;
    }

    public void remover(Fornecedor f) {
        f = em.merge( f );
        em.remove( f );
    }
}
