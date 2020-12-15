package br.com.treinaweb.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.persistence.*;
import java.util.Objects;


@Entity
public class Produto {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    @Column(name="name")
    @NotNull(message = "{produto.name.notnull}")
    private String name;

    @JsonProperty("price")
    @Column(name="price")
    @NotNull(message = "{price.price.notnull}")
    private int price;

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
                Objects.equals(name, produto.name) &&
                Objects.equals(produto, produto.price);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", nome='" + name + '\'' +
                ", done=" + price +
                '}';
    }
}

/*
public class Produto {
    private int id;
    private String nome;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
*/