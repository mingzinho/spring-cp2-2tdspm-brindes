package br.com.fiap.brindes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "TB_LOJA" , uniqueConstraints = {
        @UniqueConstraint(name = "UK_NOME_LOJA",columnNames = {"NM_LOJA"})
})
public class Loja {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_LOJA")
    @SequenceGenerator(
            name = "SQ_LOJA",
            sequenceName = "SQ_LOJA",
            allocationSize = 1
    )
    @Column(name = "ID_LOJA", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Column(name = "NM_LOJA", nullable = false, unique = true)
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_LOJA_PRODUTO",
            joinColumns = {
                    @JoinColumn(
                            name = "LOJA",
                            referencedColumnName = "ID_LOJA",
                            foreignKey = @ForeignKey(name = "FK_LOJA_PRODUTO")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "PRODUTO",
                            referencedColumnName = "ID_PRODUTO",
                            foreignKey = @ForeignKey(name = "FK_PRODUTO_LOJA")
                    )
            }
    )
    
    @PrimaryKeyJoinColumn()
    private Set<Produto> produtosComercializados = new LinkedHashSet<>();

}