package dev.java10x.CadastroDeNinjas.Ninjas;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

// Entity transforma uma classe m uma entidade no DB
// JPA = Java Persistence API
@Entity
@Table(name = "tb_cadastro")
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email ;
    private int idade;
    @Column(name = "img_url")
    private String impUrl;
    // Muitos para um
    @ManyToOne
    @JoinColumn(name= "missoes_id")
    private List<MissoesModel> missoes;
}
