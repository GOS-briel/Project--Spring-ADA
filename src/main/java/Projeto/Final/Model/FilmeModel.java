package Projeto.Final.Model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.federation.EntityMapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "filmes")
public class FilmeModel {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @Column(nullable = false)
    private String titulo;
    private String diretor;
    private String ano;
    private String genero;
}
