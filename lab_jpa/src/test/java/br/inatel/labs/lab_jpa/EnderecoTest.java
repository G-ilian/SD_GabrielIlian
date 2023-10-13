package br.inatel.labs.lab_jpa;

import br.inatel.labs.lab_jpa.entity.Endereco;
import br.inatel.labs.lab_jpa.service.EnderecoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoTest {

    @Autowired
    private EnderecoService service;

    @Test
    public void testarUUIDGeradoPeloJPAListener(){

        Endereco e = new Endereco();

        e.setRua("Av. João de Camargo");
        e.setNumero("510");
        e.setCidade("Santa Rita Do Sapucaí");
        e.setUf("MG");

        e = service.salvar(e);

        System.out.println(e);
    }
}
