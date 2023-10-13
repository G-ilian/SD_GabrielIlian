package br.inatel.labs.lab_jpa.service;

import br.inatel.labs.lab_jpa.entity.Produto;
import br.inatel.labs.lab_jpa.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    // Métodos
    public Produto salvar(Produto p) {
        return produtoRepository.save(p);
    }

    public Optional<Produto> buscarPeloId(Long id) {
        return produtoRepository.findById(id);
    }

    public List <Produto> listar() {
        return produtoRepository.findAll();
    }

    public void remover(Produto p) {
        produtoRepository.delete(p);
    }



}
