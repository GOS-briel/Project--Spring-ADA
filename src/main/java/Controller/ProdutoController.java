package Controller;

import Model.Produto;
import Model.Busca;
import Service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

private final ProdutoService produtoService;

public ProdutoController(ProdutoService produtoService){
    this.produtoService = produtoService;
}
@GetMapping
public String ListarProdutos(){
    return produtoService.listarProdutos(); //Não consegui encontrar formas de corrigir o erro

}
@PostMapping
public Produto Adicionarproduto(@RequestBody Produto produto){
    return produtoService.AdicionarProduto(produto);

}
    @PutMapping("/{id}")
    public Produto AtualizarProduto(@PathVariable Long id,@RequestBody Produto produtoAtualizado){
        return produtoService.AtualizarProduto(id,produtoAtualizado); // criar grud de atualizar(Classe Service)

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> ApagarProduto(@PathVariable Long id){
        this.produtoService.ApagarProduto(id);
        return ResponseEntity.noContent().build(); // criar grud de apagar(Classe Service)
    }

    public List<Produto> buscarProdutos(
            @RequestParam(required = false) String description,
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) Double maxPrice) {

        return produtoService.buscarProdutos(description, minPrice, maxPrice);
    }
    }





