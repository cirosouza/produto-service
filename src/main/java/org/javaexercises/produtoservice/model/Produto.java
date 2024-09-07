package org.javaexercises.produtoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("produtos")
public class Produto {

    @Id
    private Long Id;
    private String nome;
    private Double preco;

}
