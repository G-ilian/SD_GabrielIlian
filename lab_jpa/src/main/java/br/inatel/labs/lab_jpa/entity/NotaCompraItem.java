package br.inatel.labs.lab_jpa.entity;

import java.math.BigDecimal;

public class NotaCompraItem {

    // Atributos nota compra
    private Long id;
    private NotaCompra notaCompra;
    private Produto produto;
    private BigDecimal valorCompraProduto;
    private Integer quantidade;

    // Cálculo do total do item
    public BigDecimal getCalculoTotalItem(){
        return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
    }


}
