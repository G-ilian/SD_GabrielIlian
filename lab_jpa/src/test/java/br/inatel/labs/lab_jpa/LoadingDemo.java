package br.inatel.labs.lab_jpa;

import br.inatel.labs.lab_jpa.entity.NotaCompra;
import br.inatel.labs.lab_jpa.entity.NotaCompraItem;
import br.inatel.labs.lab_jpa.service.NotaCompraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class LoadingDemo {
    @Autowired
    private NotaCompraService service;

    @Test
    public void demoEagerLoading(){
        try{

            NotaCompraItem item = service.buscarNotaCompraItemPeloId(1L);

            LocalDate dataEmissao = item.getNotaCompra().getDataEmissao();

            System.out.println(dataEmissao);

            System.out.println("Aconteceu o Eager");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void demoLazyLoading() {
        try {
            NotaCompra nota = service.buscarPeloId( 1L );

            int tamanho = nota.getListaCompraItem().size();

            System.out.println( tamanho );

        } catch (Exception e) {
            System.out.println("O carregamento foi LAZY e por isso lançou exception");
            e.printStackTrace();
        }
    }

    @Test
    public void demoPlanejandoConsulta() {
        try {
            //mas invocando outro método
            NotaCompra nota = service.buscarNotaCompraPeloIdComListaItem( 1L );

            int tamanho = nota.getListaCompraItem().size();

            System.out.println( tamanho );

        } catch (Exception e) {
            System.out.println("O carregamento foi LAZY e por isso lançou exception");
            e.printStackTrace();
        }
    }

}
