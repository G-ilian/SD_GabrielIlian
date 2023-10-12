package br.inatel.labs.lab_jpa.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.List;

public class NotaCompra {

    // Atributos nota compra
    private Long id;
    private List<NotaCompraItem> listaCompraItem;
    private Fornecedor fornecedor;
    private LocalDate localDate;

    // Métodos
    public BigDecimal getCalculoTotalNotal(){
        BigDecimal totalDaNota = listaCompraItem.stream().map(i->i.getCalculoTotalItem()).reduce(BigDecimal.ZERO,BigDecimal::add);
        return totalDaNota ;
    }

}
