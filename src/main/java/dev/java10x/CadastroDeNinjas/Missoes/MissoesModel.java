package dev.java10x.CadastroDeNinjas.Missoes;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name="tb_missoes")
@AllArgsConstructor
@Data
public class MissoesModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private DificuldadeEnum dificuldade;
    // Um para muitos
    @OneToMany(mappedBy = "ninjas")
    private NinjaModel ninja;
}
