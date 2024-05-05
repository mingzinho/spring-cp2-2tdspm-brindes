package br.com.fiap.brindes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_PRODUTO" , uniqueConstraints = {
        @UniqueConstraint(columnNames = {"NM_PRODUTO","ID_CATEGORIA"})
})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRODUTO")
    @SequenceGenerator(
            name = "SQ_PRODUTO",
            sequenceName = "SQ_PRODUTO",
            allocationSize = 1
    )
    @PrimaryKeyJoinColumn()
    @Column(name = "ID_PRODUTO", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "NM_PRODUTO", nullable = false, unique = true)
    private String nome;

    @NotNull
    @Column(name = "PRECO_PROD", nullable = false)
    private Double preco;

    @ManyToOne()
    @JoinColumn(name = "ID_CATEGORIA", nullable = false, foreignKey = @ForeignKey(name="FK_PRODUTO_CATEGORIA"))
    private Categoria categoria;
    
    @ManyToMany(mappedBy = "produtosComercializados")
    private Set<Loja> lojas;


}