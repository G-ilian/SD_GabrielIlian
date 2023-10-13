package br.inatel.labs.lab_jpa.repository;

import br.inatel.labs.lab_jpa.entity.NotaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaCompraRepository extends JpaRepository<NotaCompra, Long> {
}
