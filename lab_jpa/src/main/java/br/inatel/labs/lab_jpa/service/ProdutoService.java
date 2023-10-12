package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoService {
    @PersistenceContext
    private EntityManager em;

    // Métodos
    public Produto salvar(Produto p) {
        p = em.merge( p );
        return p;
    }

    public Produto buscarPeloId(Long id) {
        Produto produto = em.find(Produto.class, id);
        return produto;
    }

    public List <Produto> listar() {
        return em.createQuery("select p from Produto p", Produto.class)
                .getResultList();
    }

    public void remover(Produto p) {
        p = em.merge( p );
        em.remove( p );
    }



}
