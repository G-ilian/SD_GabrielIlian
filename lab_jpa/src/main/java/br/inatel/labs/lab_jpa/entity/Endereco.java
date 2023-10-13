package br.inatel.labs.lab_jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Entity
@Data
public class Endereco {
    // Atributos
    @Id
    private String codigo;
    @NotNull
    private String rua;
    @NotNull
    private String numero;
    private String complemento;
    private String bairro;
    @NotNull
    private String cidade;
    @NotNull
    @Size(max=2)
    private String uf;

    // Métodos


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(codigo, endereco.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @PrePersist
    private void preencherCodigo(){
        this.codigo = UUID.randomUUID().toString();
    }

}
