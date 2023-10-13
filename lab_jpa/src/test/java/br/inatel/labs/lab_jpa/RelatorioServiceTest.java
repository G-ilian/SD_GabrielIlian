package br.inatel.labs.lab_jpa;

import br.inatel.labs.lab_jpa.DTO.TotalCompradoPorFornecedor;
import br.inatel.labs.lab_jpa.service.RelatorioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class RelatorioServiceTest {

    @Autowired
    private RelatorioService service;

    @Test
    void test() {
        List<TotalCompradoPorFornecedor> listaDTO = service.pesquisarTotalCompradoPorFornecedor();

        assertFalse( listaDTO.isEmpty() );

        System.out.println("FornecedorRazaoSocial : TotalComprado");
        listaDTO.forEach( r -> {
            System.out.print( r.fornecedorRazaoSocial() );
            System.out.print(" : ");
            System.out.println( r.totalComprado() );
        });
    }

}

