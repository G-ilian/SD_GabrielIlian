package br.inatel.labs.lab_jpa.repository;

import br.inatel.labs.lab_jpa.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Long> {

}
