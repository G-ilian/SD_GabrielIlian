package br.inatel.labs.lab_jpa.DTO;

import java.math.BigDecimal;

public record TotalCompradoPorFornecedor(String fornecedorRazaoSocial, BigDecimal totalComprado) {

}
