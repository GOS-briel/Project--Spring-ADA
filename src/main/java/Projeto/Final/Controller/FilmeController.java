package Projeto.Final.Controller;

import Projeto.Final.Model.FilmeModel;
import Projeto.Final.Service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

private final FilmeService filmeService;
public FilmeController(FilmeService filmeService){
    this.filmeService = filmeService;

}
@GetMapping
    public List<FilmeModel> ListarFilmes(){
    return filmeService.listarTodos();
}
@PostMapping
    public ResponseEntity<FilmeModel> adicionar(@RequestBody FilmeModel filme) {
        FilmeModel novo = filmeService.adicionar(filme);
        return ResponseEntity.ok(novo);
    }
    @PutMapping
    public ResponseEntity<FilmeModel> atualizar(@PathVariable Long id, @RequestBody FilmeModel filme) {
        return filmeService.atualizar(id, filme)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        boolean removido = filmeService.deletar(id);
        return removido ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }



}
