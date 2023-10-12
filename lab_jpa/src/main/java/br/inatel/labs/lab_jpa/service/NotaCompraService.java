package br.inatel.labs.lab_jpa.service;
import br.inatel.labs.lab_jpa.entity.NotaCompra;
import br.inatel.labs.lab_jpa.entity.NotaCompraItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class NotaCompraService {
    @PersistenceContext
    private EntityManager em;

    // Métodos
    public NotaCompra salvarNotaCompra(NotaCompra nota) {
        return em.merge(nota);
    }

    public NotaCompra buscarPeloId(Long id) {
        return em.find(NotaCompra.class, id);
    }

    public List<NotaCompra> listarNotaCompra() {
        return em.createQuery("select n from NotaCompra n", NotaCompra.class)
                .getResultList();
    }


    //nota compra item
    public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
        return em.merge(item);
    }

    public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
        return em.find(NotaCompraItem.class, id);
    }

    public List<NotaCompraItem> listarNotaCompraItem(){
        return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class)
                .getResultList();
    }
}
