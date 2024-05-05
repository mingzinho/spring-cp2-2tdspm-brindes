package br.com.fiap.brindes.entity;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_CATEGORIA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NOME_CATEGORIA", columnNames = {"NM_CATEGORIA"})
})

public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_CATEGORIA")
    @SequenceGenerator(
            name = "SQ_CATEGORIA",
            sequenceName = "SQ_CATEGORIA",
            allocationSize = 1
    )
    @Column(name = "ID_CATEGORIA", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "NM_CATEGORIA", nullable = false, unique = true)
    private String nome;

    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Produto> produtos;

}