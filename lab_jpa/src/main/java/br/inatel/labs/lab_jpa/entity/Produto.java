package br.inatel.labs.lab_jpa.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Entity
@Data
public class Produto {

    // Atributos da classe de produto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToMany(mappedBy = "listaProduto")
    private List <Fornecedor> listaFornecedor;

    @NotNull
    @Size(min=2,max=100)
    private String descricao;

    // Construtores
    public Produto() {

    }

    public Produto(String descricao) {
        super();
        this.descricao = descricao;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
