package br.inatel.labs.lab_jpa;

import br.inatel.labs.lab_jpa.entity.Fornecedor;
import br.inatel.labs.lab_jpa.entity.NotaCompra;
import br.inatel.labs.lab_jpa.entity.NotaCompraItem;
import br.inatel.labs.lab_jpa.entity.Produto;
import br.inatel.labs.lab_jpa.service.FornecedorService;
import br.inatel.labs.lab_jpa.service.NotaCompraService;
import br.inatel.labs.lab_jpa.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

//@SpringBootTest
class DataLoaderTests {

	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private FornecedorService fornecedorService;
	@Autowired
	private NotaCompraService notaCompraService;

	//@Test
	void load() {
		// Produtos
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Lixadeira");
		Produto p3 = new Produto("Plaina");
		Produto p4 = new Produto("Tupia");
		Produto p5 = new Produto("Serra Circular");

		p1 = produtoService.salvar( p1 );
		p2 = produtoService.salvar( p2 );
		p3 = produtoService.salvar( p3 );
		p4 = produtoService.salvar( p4 );
		p5 = produtoService.salvar( p5 );



		// Fornecedor
		Fornecedor f1 = new Fornecedor("Gasômetro Madeiras");
		Fornecedor f2 = new Fornecedor("Loja do Mecânico");

		f1 = fornecedorService.salvarFornecedor(f1);
		f2 = fornecedorService.salvarFornecedor(f2);

		//3.Nota Compra
		NotaCompra nc1 = new NotaCompra(f1,LocalDate.of(2021,1,15));
		nc1 = notaCompraService.salvarNotaCompra(nc1);

		NotaCompra nc2 = new NotaCompra(f2, LocalDate.of(2022, 2, 20));
		nc2 = notaCompraService.salvarNotaCompra(nc2);


		//4.Nota Compra Item
		NotaCompraItem i1_1 = new NotaCompraItem(nc1, p1, new BigDecimal("300.0"), 2);
		NotaCompraItem i1_2 = new NotaCompraItem(nc1, p2, new BigDecimal("1000.00"), 1);
		NotaCompraItem i1_3 = new NotaCompraItem(nc1, p3, new BigDecimal("500.00"), 3);

		i1_1 = notaCompraService.salvarNotaCompraItem(i1_1);
		i1_2 = notaCompraService.salvarNotaCompraItem(i1_2);
		i1_3 = notaCompraService.salvarNotaCompraItem(i1_3);

		NotaCompraItem i2_1 = new NotaCompraItem(nc2, p4, new BigDecimal("400.00"), 7);
		NotaCompraItem i2_2 = new NotaCompraItem(nc2, p2, new BigDecimal("1000.00"), 2);
		NotaCompraItem i2_3 = new NotaCompraItem(nc2, p5, new BigDecimal("700.00"), 1);
		i2_1 = notaCompraService.salvarNotaCompraItem(i2_1);
		i2_2 = notaCompraService.salvarNotaCompraItem(i2_2);
		i2_3 = notaCompraService.salvarNotaCompraItem(i2_3);

	}

}
