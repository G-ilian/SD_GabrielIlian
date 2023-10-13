package br.inatel.labs.lab_jpa.repository;

import br.inatel.labs.lab_jpa.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
