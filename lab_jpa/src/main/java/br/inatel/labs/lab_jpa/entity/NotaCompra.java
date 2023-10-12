package br.inatel.labs.lab_jpa.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import java.util.List;
import java.util.Objects;


@Entity
@Data
public class NotaCompra {

    // Atributos nota compra
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    private List<NotaCompraItem> listaCompraItem;
    @ManyToOne
    private Fornecedor fornecedor;

    @NotNull
    @Past
    private LocalDate dataEmissao;

    // Métodos
    public BigDecimal getCalculoTotalNotal(){
        BigDecimal totalDaNota = listaCompraItem.stream().map(i->i.getCalculoTotalItem()).reduce(BigDecimal.ZERO,BigDecimal::add);
        return totalDaNota ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotaCompra that = (NotaCompra) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
