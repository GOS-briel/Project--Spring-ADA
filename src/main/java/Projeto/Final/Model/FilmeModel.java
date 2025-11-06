package Projeto.Final.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmeModel {

    private long id;
    private String titulo;
    private String diretor;
    private String ano;
    private String genero;
}
