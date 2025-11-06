package Projeto.Final.Service;


import Projeto.Final.Model.FilmeModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    private final List<FilmeModel> filmes = new ArrayList<>();
    private long proximoId = 1l;

    public List<FilmeModel> ListarTodos() {
        return filmes;

    }

    public FilmeModel adicionar(FilmeModel filme) {
        filme.setId(proximoId++);
        filmes.add(filme);
        return filme;
    }
    public Optional<FilmeModel> atualizar(Long id, FilmeModel novoFilme) {
        for (FilmeModel f : filmes) {
            if (f.getId() == id) {
                f.setTitulo(novoFilme.getTitulo());
                f.setDiretor(novoFilme.getDiretor());
                f.setAno(novoFilme.getAno());
                f.setGenero(novoFilme.getGenero());
                return Optional.of(f);
            }
        }
        return Optional.empty();


    }
    public boolean deletar(long id){
        return filmes.removeIf(f -> f.getId() == id);
    }
    public Optional<FilmeModel> buscarPorId(long id){
        return filmes.stream().filter(f -> f.getId() == id).findFirst();
    }




}
