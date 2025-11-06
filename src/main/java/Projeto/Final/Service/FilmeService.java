package Projeto.Final.Service;


import Projeto.Final.Model.FilmeModel;
import Projeto.Final.Repository.FilmeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<FilmeModel> listarTodos() {
        return filmeRepository.findAll();
    }

    public FilmeModel adicionar(FilmeModel filme) {
        return filmeRepository.save(filme);
    }

    public Optional<FilmeModel> buscarPorId(Long id) {
        return filmeRepository.findById(id);
    }

    public Optional<FilmeModel> atualizar(Long id, FilmeModel novoFilme) {
        return filmeRepository.findById(id).map(filme -> {
            filme.setTitulo(novoFilme.getTitulo());
            filme.setDiretor(novoFilme.getDiretor());
            filme.setAno(novoFilme.getAno());
            filme.setGenero(novoFilme.getGenero());
            return filmeRepository.save(filme);
        });
    }

    public boolean deletar(Long id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }




}
